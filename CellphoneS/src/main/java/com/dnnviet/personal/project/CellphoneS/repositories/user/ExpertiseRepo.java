package com.dnnviet.personal.project.CellphoneS.repositories.user;

import com.dnnviet.personal.project.CellphoneS.entities.user.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepo extends JpaRepository<Expertise, Long> {
}
