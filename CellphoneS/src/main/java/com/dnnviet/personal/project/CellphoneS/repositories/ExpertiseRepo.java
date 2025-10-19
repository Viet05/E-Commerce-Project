package com.dnnviet.personal.project.CellphoneS.repositories;

import com.dnnviet.personal.project.CellphoneS.entities.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepo extends JpaRepository<Expertise, Long> {
}
