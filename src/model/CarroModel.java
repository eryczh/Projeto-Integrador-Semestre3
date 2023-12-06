package model;

import java.util.List;

public class CarroModel {
    private int idCarro;
    private String placaCarro;
    private String modelo;
    private String corCarro;
    private String anoCarro;
    private String tipoCombustivel;
    
	public CarroModel() {
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCorCarro() {
		return corCarro;
	}

	public void setCorCarro(String corCarro) {
		this.corCarro = corCarro;
	}

	public String getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(String anoCarro) {
		this.anoCarro = anoCarro;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public void InserirCarro(CarroModel carro) {

	}

	public CarroModel buscarCarroPorPlaca(String placa) {
		return null;
	}

	public List<CarroModel> buscarCarros() {
		return null;
	}
}
