package com.educandoweb.course.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

// @Component //essa anotação permite registrar mapear com o autowired, spring já entende
@Service //Service é mais semanticamente especifico, mas poderia usar o component acima, essa anotação permite registrar mapear com o autowired, spring já entende
public class UserService {

	@Autowired	
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //vai no banco de dados
	//	return obj.get();		dá exceção 500 caso o objeto user não estiver presente
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // não vai no banco ainda deixa o objeto monitorado
		updateData(entity, obj);
		return repository.save(entity);		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());				
	}
}
