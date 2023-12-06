package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.persistencia.Carro;
import model.persistencia.Posto;

public class TelaAlteraPosto extends JFrame {

    private static final String LABEL_CNPJ = "CNPJ do posto:";
    private static final String LABEL_NOME = "Novo nome do Posto:";
    private static final String LABEL_ENDERECO = "Novo Endereco:";
    private static final String LABEL_CIDADE = "Nova Cidade:";
    private static final String LABEL_ESTADO = "Novo Estado:";

    private JTextField campoCNPJ;
    private JTextField campoNome;
    private JTextField campoEndereco;
    private JTextField campoCidade;
    private JTextField campoEstado;

    public JPanel criarTelaAlteraPosto() {
        setTitle("Tela de Alteração");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel(LABEL_CNPJ), gbc);

        gbc.gridx = 1;
        campoCNPJ = new JTextField(15);
        painel.add(campoCNPJ, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel(LABEL_NOME), gbc);

        gbc.gridx = 1;
        campoNome = new JTextField(15);
        painel.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel(LABEL_ENDERECO), gbc);

        gbc.gridx = 1;
        campoEndereco = new JTextField(15);
        painel.add(campoEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel(LABEL_CIDADE), gbc);

        gbc.gridx = 1;
        campoCidade = new JTextField(15);
        painel.add(campoCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(new JLabel(LABEL_ESTADO), gbc);

        gbc.gridx = 1;
        campoEstado = new JTextField(15);
        painel.add(campoEstado, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;     

        gbc.gridy = 7;
        JButton buttonAlterar = new JButton("Alterar");
        painel.add(buttonAlterar, gbc);

        buttonAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnpj = campoCNPJ.getText();
                String nome = campoNome.getText();
                String endereco = campoEndereco.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();

                // Chama o método alterarCarro para executar a alteração no banco de dados
                Posto.alterarPosto(cnpj, nome, endereco, cidade, estado);
                // Pode ser exibida uma mensagem após a alteração
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
                dispose(); // Fecha a janela após a alteração
            }
        });

        add(painel);
        pack();
        setLocationRelativeTo(null);

        return painel;
    }

    
}
	