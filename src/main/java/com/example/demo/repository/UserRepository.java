package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository		//Marcação para indicar que é um componente/repositório que vai interagir com o banco de dados
public interface UserRepository extends JpaRepository<User, Long> { //<Tipo da entidade, tipo do id>

}
