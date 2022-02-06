package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

// @Component //essa anotação permite registrar mapear com o autowired, spring já entende
@Service //Service é mais semanticamente especifico, mas poderia usar o component acima, essa anotação permite registrar mapear com o autowired, spring já entende
public class ProductService {

	@Autowired	
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		
	}
}
