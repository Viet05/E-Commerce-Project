package com.dnnviet.personal.project.CellphoneS.entities;

import com.dnnviet.personal.project.CellphoneS.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "genders")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private LocalDateTime dateOfBirth;

    @Column(name = "phone")
    private int phone;

    @Column(name = "email")
    private String email;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "expertise_id")
    private Expertise expertise;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @OneToMany(mappedBy = "staff")
    private List<Order> orders;
}
