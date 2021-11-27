package br.com.cod3r.exercicessb.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cod3r.exercicessb.models.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	
	public Iterable<Product> findByNomContainingIgnoreCase(String partNom);
}
