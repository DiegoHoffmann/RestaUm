import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class JanelaPrincipal extends JFrame {

	JPanel principal;
	JPanel tabuleiro;
	JPanel infoJogo;
	Container c;
	JLabel jlJogador;
	JLabel jlPecas;
	JanelaPrincipal(String nome, JFrame frameRecorde, JFrame frameManual, JFrame frameInfo){
		super(nome);
		setResizable(false); // Não permite o redimensionamento da tela	
		//Cria a barra de menus
		JMenuBar menuBarra = new JMenuBar();
		//Cria a primeira lista de menu 
		JMenu menuOpcao = new JMenu("Opção");
		//Cria os itens do menu Opção
		JMenuItem menuNovo = new JMenuItem("Novo");
		JMenuItem menuRecorde = new JMenuItem("Recorde");
		//menuNovo.addActionListener(iniciaJogo());
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
		
		//Tabuleiro tabuleiro = new Tabuleiro();
		super.setJMenuBar(menuBarra);
		//tabuleiro.setPreferredSize(new Dimension(800,600));
		
		menuManual.addActionListener(new AbreJanela(frameManual));
		menuInfo.addActionListener(new AbreJanela(frameInfo));
		
		iniciaJogo();
	}
	
	private void iniciaJogo(){
		c = this.getContentPane();
		c.setLayout(new FlowLayout());
		principal = new FundoJanela();
		infoJogo = new JPanel();
		jlJogador = new JLabel("Jogador");
		jlPecas = new JLabel("Pecas");
		infoJogo.add(jlJogador);
		//infoJogo.add(infoJogo);
		principal.add(infoJogo);
		tabuleiro = new Tabuleiro();
		tabuleiro.setPreferredSize(new Dimension(600,600));
		principal.add(tabuleiro);
		c.add(principal);	
	}
	private class AbreJanela implements ActionListener {

		private JFrame frame;
		
		AbreJanela(JFrame frame){
			this.frame = frame;	
			this.frame.setSize(500,500);
		}
		
		public void actionPerformed(ActionEvent e) {
			this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.frame.setResizable(false);
			this.frame.setVisible(true);
		}
		
	}
}
