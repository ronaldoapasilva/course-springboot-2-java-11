package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

// @Repository //poderia colocar essa anotação, mas não tem necessidade pq está herdando do extends JpaRepositor e que já está registrado com esse componente @Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
