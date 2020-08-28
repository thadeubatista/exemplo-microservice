package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

/**
 * Classe que implementa uma requisição a um microservice utilizando o feign
 * 
 * @author thadeu
 *
 */
@Service
public class CompraServiceFeign {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizarCompra(CompraDTO compra) {
		InfoFornecedorDTO info = this.fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDTO pedido = this.fornecedorClient.realizaPedido(compra.getItens());
		// System.out.println(info.getEndereco() + " do " + info.getEstado());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;
	}
}
