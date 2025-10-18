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
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;
}
