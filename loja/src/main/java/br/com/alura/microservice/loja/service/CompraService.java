package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

/**
 * Classe que implementa uma chamada a um microserviços com RestTemplate
 * 
 * @author thadeu
 *
 */
@Service
public class CompraService {
	/**
	 * Necessário transformar RestTemplate em um bean gerenciável e anotá-lo com
	 * LoadBalance na classe que cria o bean (LojaApplication.java) para o spring
	 * conseguir resolver os endereços dos microservices pelo nome dos serviços e
	 * não pelo endereço http: Ex. isso "http://localhost:8081/info/" vira isso
	 * http://fornecedor/info/
	 */
	@Autowired
	private RestTemplate cliente;

	@Autowired
	private DiscoveryClient eurekaClient;

	public void realizaCompra(CompraDTO compra) {
		ResponseEntity<InfoFornecedorDTO> exchange = cliente.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);

		this.eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println("localhost:" + fornecedor.getPort());
		});

		System.out.println(exchange.getBody().getEndereco() + " de " + exchange.getBody().getEstado());
	}

}
