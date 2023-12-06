package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.persistencia.Carro;

public class TelaCarros {
    private JTextArea resultadoArea;

    public JPanel criarPainelCarros() {
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new BorderLayout());

        JPanel painelCamposCadastro = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastro);
        painelCamposCadastro.setLayout(layout);

        JLabel tituloLabel = new JLabel("Carros");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel placaLabel = new JLabel("   Placa do Carro:");
        JTextField placaField = new JTextField();

        JLabel modeloLabel = new JLabel("   Modelo:");
        JTextField modeloField = new JTextField();

        JLabel corLabel = new JLabel("   Cor do Carro:");
        JTextField corField = new JTextField();

        JLabel anoLabel = new JLabel("   Ano do Carro:");
        JTextField anoField = new JTextField();

        JLabel combustivelLabel = new JLabel("   Tipo de Combustível:");
        JTextField combustivelField = new JTextField();

        JLabel kmLabel = new JLabel("   Km Percorridos:");
        JTextField kmField = new JTextField();

        JPanel painelFiltro = new JPanel();
        JLabel buscaLabel = new JLabel(" Placa do carro:");
        JTextField buscaPlacaCampo = new JTextField();
        buscaPlacaCampo.setPreferredSize(new Dimension(210, buscaPlacaCampo.getPreferredSize().height));


        JButton buscarButton = new JButton("Buscar");
        painelFiltro.add(buscaLabel);
        painelFiltro.add(buscaPlacaCampo);
        
        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carro.inserirDadosNoBancoCarro(placaField.getText(), modeloField.getText(), corField.getText(),
                        anoField.getText(), combustivelField.getText(), kmField.getText());
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carro.buscarDadosNoBancoCarro(buscaPlacaCampo.getText());
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(placaLabel)
                .addComponent(modeloLabel)
                .addComponent(corLabel)
                .addComponent(anoLabel)
                .addComponent(combustivelLabel)
                .addComponent(kmLabel)
                .addComponent(painelFiltro)
        );

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(placaField)
                .addComponent(modeloField)
                .addComponent(corField)
                .addComponent(anoField)
                .addComponent(combustivelField)
                .addComponent(kmField)
                .addComponent(cadastrarButton)
                .addComponent(buscarButton)
        );

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(placaLabel)
                .addComponent(placaField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(modeloLabel)
                .addComponent(modeloField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(corLabel)
                .addComponent(corField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(anoLabel)
                .addComponent(anoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(combustivelLabel)
                .addComponent(combustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(kmLabel)
                .addComponent(kmField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cadastrarButton));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(painelFiltro)
                .addComponent(buscarButton));

        layout.setVerticalGroup(vGroup);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        JPanel painelButton = criarPainelButtons();
        scrollPane.setBorder(new EmptyBorder(0, 20, 10, 20));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        painelCadastro.add(painelCamposCadastro, BorderLayout.NORTH);
        painelCadastro.add(scrollPane, BorderLayout.CENTER);
        painelCadastro.add(painelButton, BorderLayout.SOUTH);

        return painelCadastro;
    }
    
    public JPanel criarPainelButtons() {
        ImageIcon alterarIcon = new ImageIcon("src/view/img/icons-atualizar.png");
        JButton alterarButton = new JButton(alterarIcon);
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAltera telaAlteracao = new TelaAltera();
                telaAlteracao.setVisible(true);
            }
        });

        // Botão para tela de deleção
        ImageIcon deletarIcon = new ImageIcon("src/view/img/icons-remover.png");
        JButton deletarButton = new JButton(deletarIcon);
        deletarButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                TelaDelete telaDelecao = new TelaDelete  ();
                telaDelecao.setVisible(true);
            }
        });

        // Painel para os botões de alteração e deleção
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(alterarButton);
        painelBotoes.add(deletarButton);

        return painelBotoes;
    }

    
}
