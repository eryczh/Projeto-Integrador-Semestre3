package model.persistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.beans.DB;

public class Posto {
	
	public static void inserirDadosNoBanco(String nome, String cnpj, String endereco, String cidade, String estado) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "INSERT INTO tbPosto (nomePosto, cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, cnpj);
                stmt.setString(3, endereco);
                stmt.setString(4, cidade);
                stmt.setString(5, estado);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco: " + e.getMessage());
        }
    }

	public static void alterarPosto(String cnpj, String nome, String endereco, String cidade, String estado) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "UPDATE tbPosto SET nomePosto=?, endereco=?, cidade=?, estado=? WHERE cnpj=?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.setString(2, endereco);
                ps.setString(3, cidade);
                ps.setString(4, estado);
                ps.setString(5, cnpj);

                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Posto alterado com sucesso!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Posto não encontrado.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar posto: " + e.getMessage());
        }
    }
	
    public static void buscarDadosNoBanco(String cnpj) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "SELECT * FROM tbPosto WHERE cnpj = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, cnpj);
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()) {
                    String nome = resultado.getString("nomePosto");
                    String endereco = resultado.getString("endereco");
                    String cidade = resultado.getString("cidade");
                    String estado = resultado.getString("estado");
                    JOptionPane.showMessageDialog(null, (String.format("Nome: %s\nEndereço: %s\nCidade: %s\nEstado: %s", nome, endereco, cidade, estado)));
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados no banco: " + e.getMessage());
        }
    }

    public static void deletarPosto(String cnpj) {
        try {
            Connection conexao = DB.getConnection();
            String sql = "DELETE FROM tbPosto WHERE cnpj = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, cnpj);

                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Posto deletado com sucesso!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Posto não encontrado.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao deletar posto: " + e.getMessage());
        }
    }
}
