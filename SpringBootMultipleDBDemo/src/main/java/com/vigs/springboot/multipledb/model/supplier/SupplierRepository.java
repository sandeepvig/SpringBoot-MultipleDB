package com.vigs.springboot.multipledb.model.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository //vig: NOT NECESSARY
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
