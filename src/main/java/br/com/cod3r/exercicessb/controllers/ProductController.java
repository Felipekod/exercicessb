package br.com.cod3r.exercicessb.controllers;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.cod3r.exercicessb.models.entities.Product;
import br.com.cod3r.exercicessb.models.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	//Injection de dependence
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product newProduct(@Valid Product product){
		productRepository.save(product);
		return product;
	}
	
	@GetMapping
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/nom/{partNom}")
	public Iterable<Product> getProductsByNom(@PathVariable String partNom) {
		return productRepository.findByNomContainingIgnoreCase(partNom);
	}
	
	@GetMapping(path = "/page/{pageNumero}/{qtePage}")
	public Iterable<Product> getProductPerPage(@PathVariable int pageNumero,
												@PathVariable int qtePage){
		if(qtePage >= 5)qtePage = 5;
		Pageable page = PageRequest.of(pageNumero, qtePage);
		return productRepository.findAll(page);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
	
}
