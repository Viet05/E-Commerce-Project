package com.dnnviet.personal.project.CellphoneS.repositories.store;

import com.dnnviet.personal.project.CellphoneS.entities.store.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepo extends JpaRepository<Area, Integer> {
}
