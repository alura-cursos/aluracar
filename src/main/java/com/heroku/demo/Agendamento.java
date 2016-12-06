package com.heroku.demo;

public class Agendamento {
	
	private Carro carro;
	
	private String nome;
	
	private String endereco;
	
	private String email;
	
	private String dataAgendamento;
	
	public Agendamento(Carro carro, String nome, String endereco, String email, String dataAgendamento) {
		super();
		this.carro = carro;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataAgendamento = dataAgendamento;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	
	
}
