package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.persistencia.Abastecimento;

public class TelaAlteraAbastecimento extends JFrame {

    private static final String LABEL_ID = "ID do abastecimento:";
    private static final String LABEL_DATA = "Nova Data:";
    private static final String LABEL_VALORC = "Novo valor:";
    private static final String LABEL_QTDC = "Nova quantidade:";
    private static final String LABEL_COMBUSTIVEL = "Combustível do Carro:";

    private JTextField campoID;
    private JTextField campoData;
    private JTextField campoValor;
    private JTextField campoQtdc;
    private JTextField campoCombustivel;

    public TelaAlteraAbastecimento() {
        setTitle("Tela de Alteração");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        criarTelaAlteraAbastecimento();
        pack();
        setLocationRelativeTo(null);
    }

    public JPanel criarTelaAlteraAbastecimento() {
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel(LABEL_ID), gbc);

        gbc.gridx = 1;
        campoID = new JTextField(15);
        painel.add(campoID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel(LABEL_DATA), gbc);

        gbc.gridx = 1;
        campoData = new JTextField(15);
        painel.add(campoData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel(LABEL_VALORC), gbc);

        gbc.gridx = 1;
        campoValor = new JTextField(15);
        painel.add(campoValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel(LABEL_QTDC), gbc);

        gbc.gridx = 1;
        campoQtdc = new JTextField(15);
        painel.add(campoQtdc, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(new JLabel(LABEL_COMBUSTIVEL), gbc);

        gbc.gridx = 1;
        campoCombustivel = new JTextField(15);
        painel.add(campoCombustivel, gbc);

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
                realizarAlteracao();
            }
        });

        add(painel);
		return painel;
    }

    private void realizarAlteracao() {
        try {
            int id = Integer.parseInt(campoID.getText());
            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            
            String dataStr = campoData.getText();
            java.util.Date utilDate = sdfInput.parse(dataStr);
            String dataFormatada = sdfInput.format(utilDate);
            Double valor = Double.parseDouble(campoValor.getText());
            int qtdC = Integer.parseInt(campoQtdc.getText());
            String combustivel = campoCombustivel.getText();

            Abastecimento.alterarAbastecimento(id, dataFormatada, valor, qtdC, combustivel);

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
            dispose();
        } catch (ParseException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao converter a data ou valores: " + ex.getMessage());
        }
    }

    
}
