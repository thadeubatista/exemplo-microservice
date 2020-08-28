package br.com.alura.microservice.loja.dto;

public class InfoFornecedorDTO {

	private String endereco;
	private String estado;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

}
