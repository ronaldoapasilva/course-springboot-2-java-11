package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

// @Repository //poderia colocar essa anotação, mas não tem necessidade pq está herdando do extends JpaRepositor e que já está registrado com esse componente @Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
