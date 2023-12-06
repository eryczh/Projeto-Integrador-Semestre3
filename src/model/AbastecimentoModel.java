package model;
import java.util.Date;
import java.util.List;

public class AbastecimentoModel {
    private int idAbastecimento;
    private Date dataAbastecimento;
    private String valorCombustivel;
    private String qtdCombustivel;
    private String tipoCombustivel;
    private int idCarro;
    private int idPosto;
    
	public AbastecimentoModel() {
	}
	
	public int getIdAbastecimento() {
		return idAbastecimento;
	}
	public void setIdAbastecimento(int idAbastecimento) {
		this.idAbastecimento = idAbastecimento;
	}
	public Date getDataAbastecimento() {
		return dataAbastecimento;
	}
	public void setDataAbastecimento(Date dataAbastecimento) {
		this.dataAbastecimento = dataAbastecimento;
	}
	public String getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(String valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}
	public String getQtdCombustivel() {
		return qtdCombustivel;
	}
	public void setQtdCombustivel(String qtdCombustivel) {
		this.qtdCombustivel = qtdCombustivel;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	public int getIdPosto() {
		return idPosto;
	}
	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public void InserirAbastecimento(AbastecimentoModel abastecimento){}

	public List<AbastecimentoModel> ConsultarAbastecimentosPorPlaca(){
		return null;
	}
	public List<AbastecimentoModel> ConsultarAbastecimentosPorCNPJ(){
		return null;
	}
	public List<AbastecimentoModel> ConsultarAbastecimentos(){
		return null;
	}
}
