package controller;


import java.sql.SQLException;
import javax.swing.JFrame;
import view.TelaAbastecimentos;
import view.TelaCarros;
import view.TelaPostos;
import view.TelaPrincipal;
import view.TelaSplash;
import view.*;

public class Main {
	public static void main(String[] args) throws SQLException {
		
        //Connection conexao = DB.getConnection();
		TelaSplash telaSplash = new TelaSplash();

        // Criar a tela principal
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Criar as telas secundárias
		TelaCarros telaCarros = new TelaCarros();
		TelaPostos telaPostos = new TelaPostos();
		TelaAltera telaAltera = new TelaAltera();
		TelaAlteraAbastecimento telaAlteraAbastecimento = new TelaAlteraAbastecimento();
		TelaAlteraPosto telaAlteraPosto = new TelaAlteraPosto();
		TelaDelete telaDelete = new TelaDelete();
		TelaAbastecimentos telaAbastecimentos = new TelaAbastecimentos(); 

		// Adicionar os painéis ao JFrame principal
		telaPrincipal.adicionarPainel("Carros", telaCarros.criarPainelCarros());
		telaPrincipal.adicionarPainel("Postos", telaPostos.criarPainelPostos());
		telaPrincipal.adicionarPainel("Abastecimentos", telaAbastecimentos.criarPainelAbastecimentos());
		telaPrincipal.adicionarPainel("Alterar Carro", telaAltera.criarTelaAlteraCarro());
		telaPrincipal.adicionarPainel("Altera Posto", telaAlteraPosto.criarTelaAlteraPosto());
		telaPrincipal.adicionarPainel("Altera Abastecimento",telaAlteraAbastecimento.criarTelaAlteraAbastecimento());
		telaPrincipal.adicionarPainel("Delete", telaDelete.criarTelaDelete());

		

		// Exibir a tela principal
		telaPrincipal.setVisible(true);
    }
		
}

