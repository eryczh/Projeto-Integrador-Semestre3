package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.persistencia.Abastecimento;
import model.persistencia.Carro;
import model.persistencia.Posto;

public class TelaDelete extends JFrame {

    private static final String LABEL_PLACA = "Placa do Carro:";
    private static final String LABEL_CNPJ = "CNPJ do Posto:";
    private static final String LABEL_ID = "ID do Abastecimento";

    private JTextField campoTexto;
    private JButton botaoDeletar;
    private JComboBox<String> comboBox;

    public JPanel criarTelaDelete() {
        setTitle("Tela de Deleção");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        comboBox = new JComboBox<>(new String[]{LABEL_PLACA, LABEL_CNPJ, LABEL_ID});
        campoTexto = new JTextField();
        campoTexto.setPreferredSize(new Dimension(200, 25));

        botaoDeletar = new JButton("Deletar");
        botaoDeletar.setPreferredSize(new Dimension(200, 30));
        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        null,
                        "Tem certeza que deseja deletar?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );

                if (resposta == JOptionPane.YES_OPTION) {
                    String texto = campoTexto.getText();
                    if (comboBox.getSelectedItem().equals(LABEL_PLACA)) {
                        // Chama o método deletarCarro para executar a exclusão no banco de dados
                        Carro.deletarCarro(texto);
                    } else if (comboBox.getSelectedItem().equals(LABEL_CNPJ)) {
                        // Chama o método deletarPosto para executar a exclusão no banco de dados
                        Posto.deletarPosto(texto);
                    } else if (comboBox.getSelectedItem().equals(LABEL_ID)) {
                        
                        Abastecimento.deletarAbastecimento(texto);
                    }
                }
            }
        });

        painel.add(comboBox);
        painel.add(campoTexto);
        painel.add(botaoDeletar);

        add(painel);
        pack();
        setLocationRelativeTo(null);

        return painel;
    }
}
