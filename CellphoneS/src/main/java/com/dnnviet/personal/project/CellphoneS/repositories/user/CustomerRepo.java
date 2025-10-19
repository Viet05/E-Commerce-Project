package com.dnnviet.personal.project.CellphoneS.repositories.user;

import com.dnnviet.personal.project.CellphoneS.entities.user.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
