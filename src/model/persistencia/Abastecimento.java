package model.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.beans.DB;

public class Abastecimento {

	public static void cadastrarAbastecimento(String data, String valorCombustivel, String qtdCombustivel,
            String tipoCombustivel, String placaCarro, String cnpjPosto) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Connection conexao = DB.getConnection();
			try {
				// Preparar a instrução SQL
				String sql = "INSERT INTO tbAbastecimento (dataAbastecimento, valorCombustivel, qtdCombustivel, " +
				"tipoCombustivel, placaDoCarro, cnpjDoPosto) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				// Preencher os parâmetros da instrução SQL com os valores dos campos
				stmt.setDate(1, new java.sql.Date(sdf.parse(data).getTime()));
				stmt.setDouble(2, Double.parseDouble(valorCombustivel));
				stmt.setInt(3, Integer.parseInt(qtdCombustivel));
				stmt.setString(4, tipoCombustivel);
				stmt.setString(5, placaCarro);
				stmt.setString(6, cnpjPosto);
				
				
				// Executar a instrução SQL
				stmt.executeUpdate();
				
				// Fechar o statement
				DB.closeStatement(stmt);
				
				// Exibir mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Abastecimento cadastrado com sucesso!");
				
				System.out.println("Cadastro de abastecimento comcluído");
			} catch (SQLException e) {
				// Tratar exceções
				JOptionPane.showMessageDialog(null, "Erro ao Cadastrar abastecimento: " + e.getMessage());
				e.printStackTrace(); // Isso ajuda a identificar a causa do erro durante o desenvolvimento
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	
	public static void alterarAbastecimento(Integer Id, String data, double valorCombustivel, Integer qtdCombustivel,
            String tipoCombustivel) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Connection conexao = DB.getConnection();
			String sql = "Update tbAbastecimento SET dataAbastecimento=?, valorCombustivel=?, qtdCombustivel=?, tipoCombustivel=? WHERE idAbastecimento = ?";
			try (PreparedStatement ps = conexao.prepareStatement(sql)) {
				ps.setDate(1, new java.sql.Date(sdf.parse(data).getTime()));
				ps.setDouble(2, valorCombustivel);
				ps.setInt(3, qtdCombustivel);
				ps.setString(4, tipoCombustivel);
				ps.setInt(5, Id);
				
				int linhasAfetadas = ps.executeUpdate();
				
				if (linhasAfetadas > 0) {
					JOptionPane.showMessageDialog(null, "Abastecimento alterado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Abastecimento não encontrado!");

				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar abastecimento: " + e.getMessage());
		}
	}
	
	public static double calcularMediaKmPorLitro(double qtdCombustivel, double distanciaPercorrida) {
        if (qtdCombustivel <= 0) {
            throw new IllegalArgumentException("A quantidade de combustível deve ser maior que zero.");
        }

        if (distanciaPercorrida <= 0) {
            throw new IllegalArgumentException("A distância percorrida deve ser maior que zero.");
        }

        return distanciaPercorrida / qtdCombustivel;
    }
	
	public static void deletarAbastecimento(String id) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "DELETE FROM tbabastecimento WHERE idAbastecimento = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, id);

                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Abastecimento deletado com sucesso!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Abastecimento não encontrado.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao deletar Abastecimento: " + e.getMessage());
        }
    }
	
	public static void buscarDadosNoBancoAbastecimento(String placa) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "SELECT * FROM tbAbastecimento WHERE placaDoCarro = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, placa);
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    Date date = resultSet.getDate("dataAbastecimento");
                    double valorC = resultSet.getDouble("valorCombustivel");
                    int qtdC = resultSet.getInt("qtdCombustivel");
                    String combustivel = resultSet.getString("tipoCombustivel");
                    String placaCarro = resultSet.getString("placaDoCarro");
                    String cnpjPosto = resultSet.getString("cnpjDoPosto");
                    String dadosAbastecimento = String.format("Data de Abastecimento: %s%nValor do Combustível: %.2f%nQuantidade de Combustível: %d%nTipo de Combustível: %s%nPlaca do Carro: %s%nCNPJ do Posto: %s%n",
                            date, valorC, qtdC, combustivel, placaCarro, cnpjPosto);
                    JOptionPane.showMessageDialog(null, dadosAbastecimento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}