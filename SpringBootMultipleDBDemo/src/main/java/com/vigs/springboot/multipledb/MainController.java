package com.vigs.springboot.multipledb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigs.springboot.multipledb.model.product.Product;
import com.vigs.springboot.multipledb.model.product.ProductRepository;
import com.vigs.springboot.multipledb.model.supplier.Supplier;
import com.vigs.springboot.multipledb.model.supplier.SupplierRepository;

@RestController
public class MainController {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	SupplierRepository supplierRepo;

	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productRepo.findAll();
	}


	@GetMapping("/suppliers")
	public List<Supplier> retrieveSuppliers(){
		return supplierRepo.findAll();
	}
}
