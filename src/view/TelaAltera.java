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

public class TelaAltera extends JFrame {

    private static final String LABEL_PLACA = "Placa do Carro:";
    private static final String LABEL_MODELO = "Modelo do Carro:";
    private static final String LABEL_COR = "Nova Cor:";
    private static final String LABEL_ANO = "Ano do Carro:";
    private static final String LABEL_COMBUSTIVEL = "Combustível do Carro:";
    private static final String LABEL_KM = "KM do Carro:";

    private JTextField campoPlaca;
    private JTextField campoModelo;
    private JTextField campoCor;
    private JTextField campoAno;
    private JTextField campoCombustivel;
    private JTextField campoKM;

    public JPanel criarTelaAlteraCarro() {
        setTitle("Tela de Alteração");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel(LABEL_PLACA), gbc);

        gbc.gridx = 1;
        campoPlaca = new JTextField(15);
        painel.add(campoPlaca, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel(LABEL_MODELO), gbc);

        gbc.gridx = 1;
        campoModelo = new JTextField(15);
        painel.add(campoModelo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel(LABEL_COR), gbc);

        gbc.gridx = 1;
        campoCor = new JTextField(15);
        painel.add(campoCor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel(LABEL_ANO), gbc);

        gbc.gridx = 1;
        campoAno = new JTextField(15);
        painel.add(campoAno, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(new JLabel(LABEL_COMBUSTIVEL), gbc);

        gbc.gridx = 1;
        campoCombustivel = new JTextField(15);
        painel.add(campoCombustivel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        painel.add(new JLabel(LABEL_KM), gbc);

        gbc.gridx = 1;
        campoKM = new JTextField(15);
        painel.add(campoKM, gbc);

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
                String placa = campoPlaca.getText();
                String modelo = campoModelo.getText();
                String cor = campoCor.getText();
                int ano = Integer.parseInt(campoAno.getText());
                String combustivel = campoCombustivel.getText();
                int km = Integer.parseInt(campoKM.getText());
                

                // Chama o método alterarCarro para executar a alteração no banco de dados
                Carro.alterarCarro(placa, modelo, cor, ano, combustivel, km);

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
	