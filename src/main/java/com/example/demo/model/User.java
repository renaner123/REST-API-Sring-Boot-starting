package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id              											//Notação do javax.persistence, identifica o id -- chave primária no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//IDENTITY banco que deve incrementar o id. stategy é Tipo de geração do valor do id
	private Long id;
	
	@Column(nullable = false, unique=true, length = 45)                     				//Não precisa marcação, entity mapeia todos os atributos, a não ser que queria por alguma restrição
	private String email;
	private String firstname;
	private String lastname;
	private String password;
		
}

