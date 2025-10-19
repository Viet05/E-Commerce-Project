package com.dnnviet.personal.project.CellphoneS.repositories;

import com.dnnviet.personal.project.CellphoneS.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
