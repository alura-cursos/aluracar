/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heroku.demo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class HomeController {
	
	private static Integer contador = 0;
	


    @RequestMapping("/")
    public List<Carro> getCarros(HttpServletResponse response) {
    	
    	List<Carro> carros = new ArrayList<>();
    	carros.add(new Carro("Azera V6", new BigDecimal(85000)));
    	carros.add(new Carro("Onix 1.6", new BigDecimal(35000)));
    	carros.add(new Carro("Fiesta 2.0", new BigDecimal(52000)));
    	carros.add(new Carro("C3 1.0", new BigDecimal(22000)));
    	carros.add(new Carro("Uno Fire", new BigDecimal(11000)));
    	carros.add(new Carro("Sentra 2.0", new BigDecimal(53000)));
    	carros.add(new Carro("Astra Sedan", new BigDecimal(39000)));
    	carros.add(new Carro("Vectra 2.0 Turbo", new BigDecimal(37000)));
    	carros.add(new Carro("Hilux 4x4", new BigDecimal(90000)));
    	carros.add(new Carro("Montana Cabine dupla", new BigDecimal(57000)));
    	carros.add(new Carro("Outlander 2.4", new BigDecimal(99000)));
    	carros.add(new Carro("Brasilia Amarela", new BigDecimal(9500)));
    	carros.add(new Carro("Omega Hatch", new BigDecimal(8000)));
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

    	
        return carros;
    }
    
    @RequestMapping("/test")
    public List<Carro> getCarrosCaracterEspecial(HttpServletResponse response) {
    	List<Carro> carros = new ArrayList<>();
    	carros.add(new Carro("Azera V6 @€£ß", new BigDecimal(85000)));
    	carros.add(new Carro("Onix 1.6", new BigDecimal(35000)));
    	carros.add(new Carro("Fiesta 2.0", new BigDecimal(52000)));
    	carros.add(new Carro("C3 1.0", new BigDecimal(22000)));
    	carros.add(new Carro("Uno Fire", new BigDecimal(11000)));
    	carros.add(new Carro("Sentra 2.0", new BigDecimal(53000)));
    	carros.add(new Carro("Astra Sedan", new BigDecimal(39000)));
    	carros.add(new Carro("Vectra 2.0 Turbo", new BigDecimal(37000)));
    	carros.add(new Carro("Hilux 4x4", new BigDecimal(90000)));
    	carros.add(new Carro("Montana Cabine dupla", new BigDecimal(57000)));
    	carros.add(new Carro("Outlander 2.4", new BigDecimal(99000)));
    	carros.add(new Carro("Brasília Amarela Maça", new BigDecimal(9500)));
    	carros.add(new Carro("Omega Hatch 2", new BigDecimal(8000)));
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

    	
        return carros;
    }
    
    @RequestMapping(value = "salvarpedido", method = RequestMethod.GET)
    public Agendamento saveCarro(String nome, String endereco, String email, String carro, String preco, String dataAgendamento, HttpServletResponse response){
    	
    	if (contador == 2) {
    		contador = 0;
    		throw new RuntimeException("Erro no servidor.");
    	}else{
    		if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() ) {
        		throw new RuntimeException("Campos obrigatórios!");
        	}
    	}
    	
    	contador++;
    	
    	Carro carroEscolhido = new Carro(carro, new BigDecimal(preco));
    	Agendamento pedido = new Agendamento(carroEscolhido, nome, endereco, email, dataAgendamento);
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    	
    	return pedido;
    	
    }
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ObjectNode login(String email, String senha, HttpServletResponse response) throws IOException{
    	
    	Usuario usuario = null;
    	ObjectMapper mapper = new ObjectMapper();
    	ObjectNode objetoNo = mapper.createObjectNode();
    	if ( (email != null && email.equals("joao@alura.com.br")) && (senha != null && senha.equals("alura123")) ) {
    		usuario = new Usuario(1l, "João da Silva", "30/01/1990", "1199887788", email);
    		objetoNo.putPOJO("usuario", usuario);
    	}else {
            objetoNo.put("mensagem", "Usuário não cadastrado!");
            response.setStatus(403);
    	}
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    	
    	return objetoNo;
    	
    }
    
    @RequestMapping(value = "agendamentos", method = RequestMethod.GET)
    public List<Agendamento> obterPedidos(HttpServletResponse response){
    	List<Agendamento> pedidos = new ArrayList<>();
    	Carro azera = new Carro("Azera V6", new BigDecimal(85000));
    	Carro sentra = new Carro("Sentra 2.0", new BigDecimal(53000));
    	
    	pedidos.add(new Agendamento(sentra, "Paula Celina", "Rua Brasil, 123", "paulacelina@alura.com.br", "30/08/2016"));
    	pedidos.add(new Agendamento(azera, "João Robert", "Rua Chile, 321", "jao@alura.com.br", "28/08/2016"));
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

    	
        return pedidos;
    	
    }
    
    @RequestMapping(value = "fornecedores", method = RequestMethod.GET)
    public List<Fornecedor> obterFornecedores(HttpServletResponse response){
    	List<Fornecedor> fornecedores = new ArrayList<>();
    	
    	fornecedores.add(new Fornecedor("Luiz Silva", "1133446655", "1198899776"));
    	fornecedores.add(new Fornecedor("Angela Nunes", "3134340090", "3188778877"));
    	
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

    	
        return fornecedores;
    	
    }
    


}
