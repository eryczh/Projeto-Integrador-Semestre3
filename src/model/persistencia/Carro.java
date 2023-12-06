package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.beans.DB;

public class Carro {
	
    
    public static void deletarCarro(String placa) {
    	try {
    		Connection conexao = DB.getConnection();
    		String sql = "DELETE FROM tbCarro WHERE placa = ?";
    		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
    			stmt.setString(1, placa);
    			
    			int linhasAfetadas = stmt.executeUpdate();
    			
    			if (linhasAfetadas > 0) {
    				JOptionPane.showMessageDialog(null, "Carro deletado com sucesso!");
    				
    			} else {
    				JOptionPane.showMessageDialog(null, "Carro não encontrado.");
    			}
    		}
    		
    	} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao deletar carro: " + e.getMessage());
		}
    }
    
    public static void inserirDadosNoBancoCarro(String placa, String modelo, String cor, String ano, String combustivel, String km) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "INSERT INTO tbCarro (placa, modelo, cor, ano, combustivel, km) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, placa);
                stmt.setString(2, modelo);
                stmt.setString(3, cor);
                stmt.setInt(4, Integer.parseInt(ano));
                stmt.setString(5, combustivel);
                stmt.setInt(6, Integer.parseInt(km));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buscarDadosNoBancoCarro(String placa) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "SELECT * FROM tbCarro WHERE placa = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, placa);
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    String modelo = resultSet.getString("modelo");
                    String cor = resultSet.getString("cor");
                    int ano = resultSet.getInt("ano");
                    String combustivel = resultSet.getString("combustivel");
                    int km = resultSet.getInt("km");
                    String dadosCarro = String.format("Modelo: %s, Cor: %s, Ano: %d, Combustível: %s, Km: %d%n",
                            modelo, cor, ano, combustivel, km);
                    JOptionPane.showMessageDialog(null, dadosCarro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void alterarCarro(String placa, String modelo, String cor, int ano, String combustivel, int km) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "UPDATE tbCarro SET modelo=?, cor=?, ano=?, combustivel=?, km=? WHERE placa=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, modelo);
                ps.setString(2, cor);
                ps.setInt(3, ano);
                ps.setString(4, combustivel);
                ps.setInt(5, km);
                ps.setString(6, placa);

                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Carro alterado com sucesso!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar carro: " + e.getMessage());
        }
    }
}