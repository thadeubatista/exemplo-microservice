package br.com.alura.microservice.loja.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.CompraService;
import br.com.alura.microservice.loja.service.CompraServiceFeign;

@RestController
@RequestMapping("/compras")
public class CompraResource {

	@Autowired
	private CompraService compraService;

	@Autowired
	private CompraServiceFeign compraServiceFeign;

	@PostMapping
	public Compra comprar(@RequestBody CompraDTO compra) {
		// this.compraService.realizaCompra(compra);
		return this.compraServiceFeign.realizarCompra(compra);
	}

}
