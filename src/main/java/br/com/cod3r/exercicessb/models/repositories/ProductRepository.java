package br.com.cod3r.exercicessb.models.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exercicessb.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
}
