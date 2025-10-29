package com.dnnviet.personal.project.CellphoneS.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Component
public class JwtUtils {

    @NonFinal
    @Value("${jwt.signerKey}")
    private String SECRET_KEY;
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(String username) {

            JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(username)
                    .issuer("cellphoneS")
                    .issueTime(new Date())
                    .expirationTime(new Date(Instant
                            .now()
                            .plus(1, ChronoUnit.HOURS)
                            .toEpochMilli()))
                    .claim("role", "CUSTOMER")
                    .build();

            JWSObject jwsObject = new JWSObject(
                    header,
                    new Payload(claimsSet.toJSONObject()));

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot generate token", e);
            throw new RuntimeException(e);
        }
    }

    public boolean validateToken(String token) throws JOSEException, ParseException {
        try {


            JWSObject jwsObject = JWSObject.parse(token);

            JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());
            if (!jwsObject.verify(verifier)) {
                log.warn("Invalid token");
                return false;
            }

            JWTClaimsSet claimsSet = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());

            Date expirationTime = claimsSet.getExpirationTime();
            if (expirationTime.before(new Date())) {
                log.warn("JWT token expired");
                return false;
            }
            return true;
        }
        catch (JOSEException e) {
            log.error("Cannot validate token");
            return false;
        }
    }

    public String getUsernameFromToken(String token) throws ParseException, JOSEException {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWTClaimsSet claimsSet = JWTClaimsSet.parse(jwsObject.getPayload().toJSONObject());
            return claimsSet.getSubject();
        }
        catch (Exception e) {
            log.error("Cannot get username from token", e);
            return null;
        }
    }

}
