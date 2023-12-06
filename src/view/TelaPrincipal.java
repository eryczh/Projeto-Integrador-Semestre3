package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    private TelaCarros telaCarros = new TelaCarros();
    private TelaPostos telaPostos = new TelaPostos();
    private TelaAltera telaAltera = new TelaAltera();
    private TelaAlteraAbastecimento telaAlteraA = new TelaAlteraAbastecimento();
    private TelaAlteraPosto telaAlteraPosto = new TelaAlteraPosto();
    private TelaDelete telaDelete = new TelaDelete();
    private TelaAbastecimentos telaAbastecimentos = new TelaAbastecimentos();

    private JPanel painelAtual;

    public TelaPrincipal() {
        // Configuração da janela
        setTitle("Fuel");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede que a janela seja redimensionada

        // Painel lateral esquerdo
        JPanel painelLateral = criarPainelLateral();
        
        // Layout principal da tela
        setLayout(new BorderLayout());
        add(painelLateral, BorderLayout.WEST);
        
        // Adiciona um listener para trocar para a tela de Carros por padrão
        trocarPainel("Carros");
    }

    private JPanel criarPainelLateral() {
        JPanel painelLateral = new JPanel();
        painelLateral.setPreferredSize(new Dimension(250, 700));
        painelLateral.setBackground(Color.decode("#862EAF"));

        JLabel nomeAppLabel = new JLabel("Fuel");
        nomeAppLabel.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 62));
        nomeAppLabel.setForeground(Color.WHITE);
        nomeAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel espacamento = new JPanel();
        espacamento.setBackground(Color.decode("#862EAF"));
        espacamento.setPreferredSize(new Dimension(250, 10));

        JPanel painelCarros = criarPainelOpcao("Carros");
        JPanel painelPostos = criarPainelOpcao("Postos");
        JPanel painelAltera = criarPainelOpcao("Alterar Carro");
        JPanel painelAlteraAb = criarPainelOpcao("Alterar Abastecimento");
        JPanel painelAlteraPosto = criarPainelOpcao("Alterar Posto");
        JPanel painelDelete = criarPainelOpcao("Delete");
        JPanel painelAbastecimentos = criarPainelOpcao("Abastecimentos");

        painelLateral.setLayout(new GridLayout(10, 1, 5, 5)); // GridLayout com 8 linhas, 1 coluna e espaçamento vertical e horizontal de 5 pixels
        painelLateral.add(nomeAppLabel);
        painelLateral.add(espacamento);
        painelLateral.add(painelCarros);
        painelLateral.add(painelPostos);
        painelLateral.add(painelAbastecimentos);
        painelLateral.add(painelAltera);
        painelLateral.add(painelAlteraAb);
        painelLateral.add(painelAlteraPosto);
        painelLateral.add(painelDelete);
        

        return painelLateral;
    }

    private void trocarPainel(String texto) {
        JPanel novoPainel;

        switch (texto) {
            case "Carros":
                novoPainel = telaCarros.criarPainelCarros();
                break;
            case "Postos":
                novoPainel = telaPostos.criarPainelPostos(); // Substitua isso com a lógica para criar o painel de Postos
                break;
            case "Abastecimentos":
                novoPainel = telaAbastecimentos.criarPainelAbastecimentos(); // Substitua isso com a lógica para criar o painel de Abastecimentos
                break;
            case "Alterar Carro":
                novoPainel = telaAltera.criarTelaAlteraCarro();
                break;
            case "Alterar Abastecimento":
            	novoPainel = telaAlteraA.criarTelaAlteraAbastecimento();
            	break;
            case "Alterar Posto":
            	novoPainel = telaAlteraPosto.criarTelaAlteraPosto();
            	break;
            case "Delete":
                novoPainel = telaDelete.criarTelaDelete();
                break;
            default:
                return;
        }

        if (painelAtual != null) {
            getContentPane().remove(painelAtual);
        }

        add(novoPainel, BorderLayout.CENTER);

        validate();
        repaint();

        painelAtual = novoPainel;
    }

    private JPanel criarPainelOpcao(String texto) {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setPreferredSize(new Dimension(250, 40)); // Reduzi o tamanho para 40 pixels
        painel.setBackground(Color.decode("#862EAF"));

        JLabel label = new JLabel(texto);
        label.setFont(new Font("Cairo", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        painel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                trocarPainel(texto);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                painel.setBackground(Color.decode("#C173FF"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                painel.setBackground(Color.decode("#862EAF"));
            }
        });

        painel.add(label, BorderLayout.CENTER);

        return painel;
    }

	public void adicionarPainel(String string, JPanel criarPainelCarros) {
		// TODO Auto-generated method stub
		
	}
	public JPanel criarPainelButtons() {
        ImageIcon alterarIcon = new ImageIcon("caminho/para/seu/icone_de_alteracao.png");
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
        ImageIcon deletarIcon = new ImageIcon("caminho/para/seu/icone_de_delecao.png");
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
