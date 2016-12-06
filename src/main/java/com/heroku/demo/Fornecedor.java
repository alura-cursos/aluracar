package com.heroku.demo;

public class Fornecedor {
	
	private String nome;
	
	private String telefoneComercial;
	
	private String telefoneCelular;
	
	public Fornecedor(String nome, String telefoneComercial, String telefoneCelular) {
		this.nome = nome;
		this.telefoneComercial = telefoneComercial;
		this.telefoneCelular = telefoneCelular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

}
