package com.product.springmvc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="Product")
public class ProductEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int quantity;
	private double discountprice;
	private double taxprice;
	private double discountRate;
	private double offerPrice;
	private double finalprice;
	private double stockvalue;

}

