package com.generation.gamestore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome não pode ser nulo nem conter somente espaços em branco!")
	private String nome;
	
	@NotBlank(message = "O atributo desenvolvedor não pode ser nulo nem conter somente espaços em branco!")
	private String desenvolvedor;
	
	@NotBlank(message = "O atributo plataforma não pode ser nulo nem conter somente espaços em branco!")
	private String plataforma;
	
	@NotBlank(message = "O atributo gênero não pode ser nulo nem conter somente espaços em branco!")
	private String genero;
	
	@NotNull(message = "O atributo preço não pode ser nulo!")
	@Positive(message = "O atributo preço deve ser maior que zero!")
	private BigDecimal preco;
	
	@NotNull(message = "O atributo estoque não pode ser nulo!")
	@PositiveOrZero(message = "O atributo estoque deve ser maior ou igual a zero!")
	private int estoque;
	
	private LocalDate lancamento;
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;

}
