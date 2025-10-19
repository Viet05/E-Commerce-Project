package com.dnnviet.personal.project.CellphoneS.repositories.user;

import com.dnnviet.personal.project.CellphoneS.entities.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {
}
