import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class JanelaPrincipal extends JFrame {

	JPanel principal;
	Tabuleiro tabuleiro;
	JPanel infoJogo;
	Container c;
	JLabel jlJogador;
	JLabel jlPecas;
	Jogador player;
	static String[] recordes;

	JanelaPrincipal(String nome, JFrame frameRecorde, JFrame frameManual,
			JFrame frameInfo) {
		super(nome);
		setResizable(false); // Não permite o redimensionamento da tela
		// Cria a barra de menus
		JMenuBar menuBarra = new JMenuBar();
		// Cria a primeira lista de menu
		JMenu menuOpcao = new JMenu("Opção");
		// Cria os itens do menu Opção
		JMenuItem menuNovo = new JMenuItem("Novo");
		JMenuItem menuRecorde = new JMenuItem("Recorde");
		menuNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mnIniciarActionPerformed(evt);
			}
		});
		menuRecorde.addActionListener(new AbreJanela(frameRecorde));
		menuOpcao.add(menuNovo);
		menuOpcao.add(menuRecorde);

		JMenu menuSobre = new JMenu("Sobre");
		final JMenuItem menuManual = new JMenuItem("Manual");
		JMenuItem menuInfo = new JMenuItem("Info Jogo");
		menuSobre.add(menuManual);
		menuSobre.add(menuInfo);
		menuBarra.add(menuOpcao);
		menuBarra.add(menuSobre);

		super.setJMenuBar(menuBarra);
		menuManual.addActionListener(new AbreJanela(frameManual));
		menuInfo.addActionListener(new AbreJanela(frameInfo));

		// Tabuleiro tabuleiro = new Tabuleiro();
		super.setJMenuBar(menuBarra);
		// tabuleiro.setPreferredSize(new Dimension(800,600));

		menuManual.addActionListener(new AbreJanela(frameManual));
		menuInfo.addActionListener(new AbreJanela(frameInfo));

		iniciaJogo();
	}

	private void iniciaJogo() {
		try {
			c = this.getContentPane();
			recordes = new String[10];
			c.setLayout(new FlowLayout());
			principal = new FundoJanela();
			infoJogo = new JPanel();
			player = new Jogador();
			String nome ;
			do{
				nome = JOptionPane.showInputDialog(null,
						"Informe seu nome:", "Resta Um",
						JOptionPane.QUESTION_MESSAGE);
				player.setNome(nome);
			}while(verificaPlayer(nome));
			nome = "<html><b>Nome: </b><font color='#0033FF'>" + nome
					+ "</font></html>";
			jlJogador = new JLabel(nome);
			jlPecas = new JLabel("Pecas: 32");
			infoJogo.setLayout(new GridLayout(0, 3));
			infoJogo.add(jlJogador);
			infoJogo.add(jlPecas);
			principal.setLayout(new BorderLayout());
			principal.add(infoJogo, BorderLayout.NORTH);
			tabuleiro = new Tabuleiro();
			tabuleiro.setJanelaPrincipal(this);
			tabuleiro.setPreferredSize(new Dimension(800, 600));
			principal.add(tabuleiro, BorderLayout.CENTER);
			c.add(principal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private class AbreJanela implements ActionListener {
		private JFrame frame;

		AbreJanela(JFrame frame) {
			this.frame = frame;
			this.frame.setSize(600, 500);
		}

		public void actionPerformed(ActionEvent e) {
			this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.frame.setResizable(false);
			this.frame.setVisible(true);
		}
	}

	private void mnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
		int resultado = JOptionPane.showConfirmDialog(null,
				"Se continuar perdera o jogo: ", "Resta Um",
				JOptionPane.OK_CANCEL_OPTION);
		if (resultado == 0) {
			int pontos = (-player.getPontos()) + 32;
			armazenaPontos(pontos);	
			String aux = player.getNome() + ";" + pontos;
			tabuleiro.novoJogo = true;
			tabuleiro.contaPeca = 32;
			String nome = JOptionPane.showInputDialog(null,
					"Informe seu nome:", "Resta Um",
					JOptionPane.QUESTION_MESSAGE);
			player.setNome(nome);
			nome = "<html><b>Nome: </b><font color='#0033FF'>" + nome
					+ "</font></html>";
			jlJogador.setText(nome);
			jlPecas.setText("Pecas: 32");
					
		}
	}

	public void armazenaPontos(int pontos) {
		try {
			leArq();
			File arqNovo = new File("Recorde.txt");
			FileWriter fw = new FileWriter(arqNovo);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; recordes[i] != null ; i++){
				bw.write(recordes[i]);
				bw.newLine();
			}
			bw.write(player.getNome() + ";" + pontos);
			bw.newLine();
			bw.close();
			fw.close();

		} catch (IOException iex) {
			System.out.println("Erro na leitura do arquivo: "
					+ iex.getMessage());
		}

	}

	public boolean verificaPlayer(String nome) {
		boolean flag = false;
		try {
			File arq = new File("Recorde.txt");
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			String aux;
			while (br.ready()) {
				aux = br.readLine();
				if(aux.substring(0, aux.indexOf(";")).equals(nome)){
					flag = true;
					JOptionPane.showConfirmDialog(null,	"Jogador ja existe!!!", "Resta Um",JOptionPane.PLAIN_MESSAGE);
					break;
				}else{
					flag = false;
				}
				recordes[i] = aux;
				i++;
			}
			br.close();
			fr.close();
			return flag;
			
		} catch (IOException iex) {
			System.out.println("Erro na leitura do arquivo: "
					+ iex.getMessage());
		}
		return flag;
	}
	
	public void leArq(){
		try {
			File arq = new File("Recorde.txt");
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			String aux;
			while (br.ready()) {
				aux = br.readLine();
				recordes[i] = aux;
				i++;
			}
			br.close();
			fr.close();
		} catch (IOException iex) {
			System.out.println("Erro na leitura do arquivo: "
					+ iex.getMessage());
		}
	}
}
