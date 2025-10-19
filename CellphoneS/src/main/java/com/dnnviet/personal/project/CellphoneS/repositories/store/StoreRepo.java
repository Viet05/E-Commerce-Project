package com.dnnviet.personal.project.CellphoneS.repositories.store;

import com.dnnviet.personal.project.CellphoneS.entities.store.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends CrudRepository<Store, Long> {
}
