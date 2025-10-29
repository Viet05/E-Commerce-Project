package com.dnnviet.personal.project.CellphoneS.security;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Component
public class JwtUtils {

    private static final String SECRET_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3NjE3MjQwNjIsImV4cCI6MTc2MTcyNzY2MiwianRpIjoiY2FiMzc3ZjUtYzE3YS00Y2Y1LWJlODQtZDI2MDUxM2RkZGE4IiwiaXNzIjoiYXBpLmV4YW1wbGUuY29tIiwic3ViIjoidXNlcl85MTQyIiwiYXVkIjoiaHR0cHM6Ly9leGFtcGxlLmNvbSIsInJvbGVzIjpbInVzZXIiXX0.1J3NnCI1gUOgdopNFnY-56h53ZEctw1bUF0fd1noBOq5ZOcxWdZIJsypvmC6LPHIZ6e__wn04fPdr28bpl1eXQ";
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(String username) {

            JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

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
}
