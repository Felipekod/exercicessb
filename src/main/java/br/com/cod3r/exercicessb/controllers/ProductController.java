package br.com.cod3r.exercicessb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exercicessb.models.entities.Product;
import br.com.cod3r.exercicessb.models.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository produtoRepository;
	
	@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String nom){
		Product product = new Product(nom);
		produtoRepository.save(product);
		return product;
	}
}
