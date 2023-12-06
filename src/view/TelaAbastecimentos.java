package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.persistencia.Abastecimento;

public class TelaAbastecimentos {
	
	
	
    private JTextArea resultadoArea;

    public JPanel criarPainelAbastecimentos() {
        JPanel painelCadastro = new JPanel(new BorderLayout());

        JPanel painelCamposCadastro = new JPanel();
        GroupLayout layout = new GroupLayout(painelCamposCadastro);
        painelCamposCadastro.setLayout(layout);

        JLabel tituloLabel = new JLabel("Abastecimentos");
        tituloLabel.setFont(new Font("Inter", Font.BOLD, 20));

        JLabel dataLabel = new JLabel("Data:");
        JTextField dataField = new JTextField();

        JLabel valorCombustivelLabel = new JLabel("Valor do Combustível:");
        JTextField valorCombustivelField = new JTextField();

        JLabel qtdCombustivelLabel = new JLabel("Quantidade de Combustível:");
        JTextField qtdCombustivelField = new JTextField();
        
        JLabel distanciaPercorridaLabel = new JLabel("Distância Percorrida(km):");
        JTextField distanciaPercorridaField = new JTextField();
     
        JLabel tipoCombustivelLabel = new JLabel("Tipo de Combustível:");
        JTextField tipoCombustivelField = new JTextField();

        JLabel placaCarroLabel = new JLabel("Placa do Carro:");
        JTextField placaCarroField = new JTextField();

        JLabel cnpjPostoLabel = new JLabel("CNPJ do Posto:");
        JTextField cnpjPostoField = new JTextField();
        
        JPanel painelFiltrosData = new JPanel();
        JPanel painelFiltrosCNPJ = new JPanel();
        
        JLabel placaFiltroLabel = new JLabel("Placa do Carro:");
        JTextField placaFiltroField = new JTextField();
        placaFiltroField.setPreferredSize(new Dimension(210, placaFiltroField.getPreferredSize().height));
        
        
        painelFiltrosCNPJ.add(placaFiltroLabel);
        painelFiltrosCNPJ.add(placaFiltroField);

        JButton buscarButton = new JButton("Buscar");
        JButton cadastrarButton = new JButton("Cadastrar");
        JPanel painelButtonPosto = new JPanel();
        painelButtonPosto.add(cadastrarButton);
        painelButtonPosto.add(buscarButton);
        
        JButton calcularMediaButton = new JButton("Calcular Média");
        painelButtonPosto.add(cadastrarButton);
        painelButtonPosto.add(buscarButton);
        painelButtonPosto.add(calcularMediaButton);
        
        buscarButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Abastecimento.buscarDadosNoBancoAbastecimento(placaFiltroField.getText());
        	}
        });
        
        calcularMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double qtdCombustivel = Double.parseDouble(qtdCombustivelField.getText());
                    double distanciaPercorrida = Double.parseDouble(distanciaPercorridaField.getText());

                    // Calcular a média de quilômetros por litro
                    double mediaKmPorLitro = Abastecimento.calcularMediaKmPorLitro(qtdCombustivel, distanciaPercorrida);

                    // Exibir mensagem com o resultado
                    JOptionPane.showMessageDialog(null, "Média de Km/L: " + new DecimalFormat("#.##").format(mediaKmPorLitro));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para os campos numéricos.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		
            		Abastecimento.cadastrarAbastecimento(
                            dataField.getText(),
                            valorCombustivelField.getText(),
                            qtdCombustivelField.getText(),
                            tipoCombustivelField.getText(),
                            placaCarroField.getText(),
                            cnpjPostoField.getText()
                            
                            
                    );
            		
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(tituloLabel)
                .addComponent(dataLabel)
                .addComponent(valorCombustivelLabel)
                .addComponent(qtdCombustivelLabel)
                .addComponent(distanciaPercorridaLabel)
                .addComponent(tipoCombustivelLabel)
                .addComponent(placaCarroLabel)
                .addComponent(cnpjPostoLabel)
                .addComponent(painelFiltrosData)
                );

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(dataField)
                .addComponent(valorCombustivelField)
                .addComponent(qtdCombustivelField)
                .addComponent(distanciaPercorridaField)
                .addComponent(tipoCombustivelField)
                .addComponent(placaCarroField)
                .addComponent(cnpjPostoField)
                .addComponent(painelButtonPosto)
                .addComponent(painelFiltrosCNPJ));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tituloLabel));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(dataLabel)
                .addComponent(dataField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(valorCombustivelLabel)
                .addComponent(valorCombustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(qtdCombustivelLabel)
                .addComponent(qtdCombustivelField));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(distanciaPercorridaLabel)
                .addComponent(distanciaPercorridaField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(tipoCombustivelLabel)
                .addComponent(tipoCombustivelField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(placaCarroLabel)
                .addComponent(placaCarroField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cnpjPostoLabel)
                .addComponent(cnpjPostoField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(painelButtonPosto));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(painelFiltrosData)
                .addComponent(painelFiltrosCNPJ));
        
        

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
