package com.product.springmvc.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.springmvc.Entity.ProductEntity;
import com.product.springmvc.Model.ProductModel;
import com.product.springmvc.Service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    
	@Autowired
    private ProductService productService;
    
    @GetMapping("/productform")
    public String getproductForm(Model model)
    {
    	ProductModel productModel=new ProductModel();
    	productModel.setMadeIn("india");
    	productModel.setQuantity(2);
    	productModel.setDiscountRate(10.5);
    	model.addAttribute("productModel",productModel);
    	
    {
    	
    	return "add-product";
    	
    }
    }
    @PostMapping("/saveProduct")
    public String save(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        HashMap<String, String> validationError = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) { // Corrected to getFieldErrors()
                validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("productModel", productModel);
            model.addAttribute("validationError", validationError);
            return "add-product";
        }

        productService.saveProductDetails(productModel);
        return "redirect:/getallproducts";
    }

    @GetMapping("/getallproducts")
    public String getAllproducts (Model model) {
    	List<ProductEntity>products=productService.getAllproducts();
    	model.addAttribute("products",products);
    	return "product-list";
    	
    }
    @GetMapping("/getsearchform")
    public String  getsearchform()
    {
		return "search-product";
    	
    }
    @PostMapping("/searchid")
    public String searchById(@RequestParam Long id,Model model)
    {
    	ProductEntity product=productService.searchById(id);
    	model.addAttribute("product",product);
    	return "search-product";
    }
    @GetMapping("/delete/{id}")
    public String deleteproductById(@PathVariable Long id)
    {
    	productService.deletetById(id);
    	return "redirect:/getallproducts";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable Long id, Model model) {
        ProductModel product = productService.editProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "edit-product";
    }

    @PostMapping("/savepriduct/{id}")
    public String showEditForm(@PathVariable Long id,ProductModel productModel) {
        productService.updateProduct(id,productModel); 
        return "redirect:/getallproducts";
    }

    
}


