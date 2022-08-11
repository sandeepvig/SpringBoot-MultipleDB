package com.vigs.springboot.multipledb.model.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository //vig: NOT NECESSARY
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
