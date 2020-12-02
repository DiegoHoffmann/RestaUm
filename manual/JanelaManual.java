import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JanelaManual extends JFrame{
	JPanel jpManual;
	JLabel jlTexto;
	
	public JanelaManual(){
		jpManual = new JPanel();
		jlTexto = new JLabel();	
	
		jlTexto.setText("<html>" +
							"<head>" +
								"<div align='center'>" +
									"<h2><font color='#0033FF'>Manual do Jogo</font></h2>"+
								"</div>" +
							"</head>" +
							"<body>" +
							"<p text-align='justify'>" +
								"<p>" +
									"<b>Meta:</b> Restar somente Uma pe&ccedil;a" +
								"</p><br /><br />" +
								"<b>1)</b> O jogo  <font color='#0033FF'><u>Resta Um</u> </font>tem inicialmente 32 pe&ccedil;as no tabuleiro, apenas  a posi&ccedil;&atilde;o do centro do<br /> tabuleiro fica vaga.<br>" +
								"<br /><b>2)</b> A jogada deve ser da seguinte maneira, para a jogada ser v&aacute;lida a pe&ccedil;a deve pular duas<br /> casa somente na horizontal ou na vertical," +
								"por&ecirc;m o movimento do diagonal n&atilde;o &eacute; aceito,<br /> sendo que o destino da pe&ccedil;a deve ser vazio e deve haver uma pe&ccedil;a no meio da posi&ccedil;&atilde;o<br /> inicial e a posi&ccedil;&atilde;o final.<br>" +
								"<br /><b>3)</b> Para movimentar as pe&ccedil;as &eacute; necess&aacute;rio selecionar uma pe&ccedil;a, que ficara vermelha.<br>"+
								"<br /><b>4)</b> Selecione um campo que esteja vazio na horizontal ou vertical. Pulando por cima de uma pe&ccedil;a.<br />At&eacute; que reste apenas uma pe&ccedil;a<br />" +
								"<br /><br /><h2><font color='#DD0000'>Bom Jogo</font></h2>"+
							"</p>"+
							"</body>"+
						"</html>");

		jpManual.add(jlTexto);
		this.add(jpManual);
		
	}
	
}
