package controller;
import model.AbastecimentoModel;
import java.util.List;
import java.util.Date;

public class AbastecimentoController {
    
	public void salvarAbastecimento(AbastecimentoModel abastecimento) {
        abastecimento.InserirAbastecimento(abastecimento);
    }
    public List<AbastecimentoModel> buscarAbastecimentosPorVeiculo(String placaCarro) {
        return null;
    }
    public List<AbastecimentoModel> buscarAbastecimentosPorPosto(String cnpj) {
        return null;
    }
    public List<AbastecimentoModel> buscarAbastecimentosPorData(Date data) {
        return null;
    }
    public List<AbastecimentoModel> buscarAbastecimentos() {
        return null;
    }

    public double calcularMediaConsumo(AbastecimentoModel abastecimento) {
    	double mediaConsumo = 0;
        return mediaConsumo;
    }
}
