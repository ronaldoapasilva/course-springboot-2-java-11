package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

// @Component //essa anotação permite registrar mapear com o autowired, spring já entende
@Service //Service é mais semanticamente especifico, mas poderia usar o component acima, essa anotação permite registrar mapear com o autowired, spring já entende
public class OrderService {

	@Autowired	
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
		
	}
}
