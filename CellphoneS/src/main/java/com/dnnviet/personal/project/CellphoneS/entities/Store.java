package com.dnnviet.personal.project.CellphoneS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "still_empty")
    private String stillEmpty;

    @OneToMany(mappedBy = "store")
    private List<Stock> stockList;

}
