package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.persistencia.Posto;

public class TelaPostos extends JFrame {
    private JTextArea resultadoArea;

    public JPanel criarPainelPostos() {
        JPanel painelCadastroPosto = new JPanel();
        painelCadastroPosto.setLayout(new BorderLayout());

        JPanel painelCamposCadastroPosto = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastroPosto);
        painelCamposCadastroPosto.setLayout(layout);

        JLabel tituloLabel = new JLabel("Posto");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel nomeLabel = new JLabel("   Nome do Posto:");
        JTextField nomeField = new JTextField();

        JLabel cnpjLabel = new JLabel("   CNPJ:");
        JTextField cnpjField = new JTextField();

        JLabel enderecoLabel = new JLabel("   Endereço:");
        JTextField enderecoField = new JTextField();

        JLabel cidadeLabel = new JLabel("   Cidade:");
        JTextField cidadeField = new JTextField();

        JLabel estadoLabel = new JLabel("   Estado:");
        JTextField estadoField = new JTextField();

        JLabel buscaLabel = new JLabel(" Digite o CNPJ do posto que está procurando:");
        JTextField buscaCnpjCampo = new JTextField();

        JButton buscarButton = new JButton("Buscar");
        JButton cadastrarButton = new JButton("Cadastrar");
        JPanel painelButtonPosto = new JPanel();
        painelButtonPosto.add(cadastrarButton);
        painelButtonPosto.add(buscarButton);
        
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Posto.buscarDadosNoBanco(buscaCnpjCampo.getText());
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Posto.inserirDadosNoBanco(nomeField.getText(), cnpjField.getText(), enderecoField.getText(),
                        cidadeField.getText(), estadoField.getText());
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(nomeLabel)
                .addComponent(cnpjLabel)
                .addComponent(enderecoLabel)
                .addComponent(cidadeLabel)
                .addComponent(estadoLabel)
                .addComponent(buscaLabel)
        );

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(nomeField)
                .addComponent(cnpjField)
                .addComponent(enderecoField)
                .addComponent(cidadeField)
                .addComponent(estadoField)
                .addComponent(painelButtonPosto)
                .addComponent(buscaCnpjCampo)
        );

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nomeLabel)
                .addComponent(nomeField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cnpjLabel)
                .addComponent(cnpjField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(enderecoLabel)
                .addComponent(enderecoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cidadeLabel)
                .addComponent(cidadeField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(estadoLabel)
                .addComponent(estadoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(painelButtonPosto));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(buscaLabel)
                .addComponent(buscaCnpjCampo));

        layout.setVerticalGroup(vGroup);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        JPanel painelButton = criarPainelButtons();
        scrollPane.setBorder(new EmptyBorder(0, 20, 10, 20));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        painelCadastroPosto.add(painelCamposCadastroPosto, BorderLayout.NORTH);
        //painelCadastroPosto.add(scrollPane, BorderLayout.CENTER);
        painelCadastroPosto.add(painelButton, BorderLayout.SOUTH);

        return painelCadastroPosto;
    }
    
    public JPanel criarPainelButtons() {
    	ImageIcon alterarIcon = new ImageIcon("src/view/img/icons-atualizar.png");
        JButton alterarButton = new JButton(alterarIcon);
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir a tela de alteração
                // Substitua a linha abaixo pela lógica específica do seu programa
                JOptionPane.showMessageDialog(null, "Abrir tela de alteração");
            }
        });

        // Botão para tela de deleção
        ImageIcon deletarIcon = new ImageIcon("src/view/img/icons-remover.png");
        JButton deletarButton = new JButton(deletarIcon);
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir a tela de deleção
                // Substitua a linha abaixo pela lógica específica do seu programa
                JOptionPane.showMessageDialog(null, "Abrir tela de deleção");
            }
        });

        // Painel para os botões de alteração e deleção
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(alterarButton);
        painelBotoes.add(deletarButton);

        return painelBotoes;
    }

}
