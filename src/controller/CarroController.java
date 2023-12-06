package controller;
import model.CarroModel;
import java.util.List;


public class CarroController {
	public void salvarCarro(CarroModel carro) {
        carro.InserirCarro(carro);
	}

	public CarroModel buscarCarroPorPlaca(String placa) {
        return null;
    }

	public List<CarroModel> buscarCarros() {
        return null;
    }
}
