package com.heroku.demo;

import java.math.BigDecimal;

public class Carro {
	
	private String nome;
	
	private BigDecimal preco;
	
	public Carro(){}
	
	public Carro(String nome, BigDecimal preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
