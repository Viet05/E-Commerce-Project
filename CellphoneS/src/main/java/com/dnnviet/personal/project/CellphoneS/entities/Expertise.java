package com.dnnviet.personal.project.CellphoneS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "positions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Expertise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expertise_id")
    private Long expertiseId;

    @Column(name = "expertise_name")
    private String expertiseName;

    @OneToMany(mappedBy = "expertise")
    private List<Staff> staffs;

    @OneToMany(mappedBy = "expertise")
    private List<Order> orders;
}
