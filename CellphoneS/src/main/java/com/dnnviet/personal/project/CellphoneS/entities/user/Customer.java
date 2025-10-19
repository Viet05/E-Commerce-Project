package com.dnnviet.personal.project.CellphoneS.entities.user;

import com.dnnviet.personal.project.CellphoneS.entities.product.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name", nullable = false)
    @NotBlank
    private String customerName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_numbers")
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "birthday")
    private LocalDateTime dateOfBirth;

    @Column(name = "reward_points")
    private BigDecimal rewardPoints;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
