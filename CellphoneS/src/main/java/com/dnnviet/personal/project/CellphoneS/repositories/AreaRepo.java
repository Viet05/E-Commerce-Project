package com.dnnviet.personal.project.CellphoneS.repositories;

import com.dnnviet.personal.project.CellphoneS.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepo extends JpaRepository<Area, Long> {
}
