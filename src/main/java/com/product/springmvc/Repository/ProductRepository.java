package com.product.springmvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.springmvc.Entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
	

}
