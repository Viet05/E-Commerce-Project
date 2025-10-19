package com.dnnviet.personal.project.CellphoneS.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "areas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long areaId;

    @Column(name = "area_name")
    private String areaName;

    @OneToMany(mappedBy = "area")
    private List<Staff> staffs;

    @OneToMany(mappedBy = "area")
    private List<Order> orders;

    @OneToMany(mappedBy = "area")
    private List<Store> stores;
}
