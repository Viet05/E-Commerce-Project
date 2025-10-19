package com.dnnviet.personal.project.CellphoneS.repositories.user;

import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
