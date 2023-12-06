package model;

import java.util.List;

public class PostoModel {
    private int idPosto;
    private String nomePosto;
    private String cnpjPosto;
    private String enderecoPosto;
    private String cepPosto;
    private String cidadePosto;
    private String estadoPosto;
    
	public PostoModel() {
	}

	public int getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public String getNomePosto() {
		return nomePosto;
	}

	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}

	public String getCnpjPosto() {
		return cnpjPosto;
	}

	public void setCnpjPosto(String cnpjPosto) {
		this.cnpjPosto = cnpjPosto;
	}

	public String getEnderecoPosto() {
		return enderecoPosto;
	}

	public void setEnderecoPosto(String enderecoPosto) {
		this.enderecoPosto = enderecoPosto;
	}

	public String getCepPosto() {
		return cepPosto;
	}

	public void setCepPosto(String cepPosto) {
		this.cepPosto = cepPosto;
	}

	public String getCidadePosto() {
		return cidadePosto;
	}

	public void setCidadePosto(String cidadePosto) {
		this.cidadePosto = cidadePosto;
	}

	public String getEstadoPosto() {
		return estadoPosto;
	}

	public void setEstadoPosto(String estadoPosto) {
		this.estadoPosto = estadoPosto;
	}

	public void inserirPosto(PostoModel posto) {

	}

	public PostoModel buscarPostoPorCnpj(String cnpj) {
		return null;
	}

	public List<PostoModel> buscarPostos() {
		return null;
	}
	
	
}
