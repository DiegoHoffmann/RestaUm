import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JanelaInfo extends JFrame{
	JPanel jpInfo;
	JLabel jlInfo;

	public JanelaInfo(){
		jpInfo = new JPanel();
		jlInfo = new JLabel();	
		jlInfo.setText("<html>" +
				"	<head>" +
				"		<div align='center'>" +
				"			<h2><font color='#0033FF'>Sobre o Jogo</font></h2>" +
				"	</head>" +
				"	<body>" +
				"	<p  align='justified' >" +
				"		<p>" +
				"			<b>Desenvolvedor:</b> Diego Hammes Hoffmann<br />" +
				"			<b>Professor:</b> Tales Viegas<br />" +
				"			<b>Data Entrega: </b> 12/11/2015" +
				"		</p>" +
				"		<p><br /> <br />" +
				"			Trabalho de Linguagem de Programa&ccedil;&atilde;o Orientada a Objetos II sobre interface e eventos. " +
				"		</p>" +
				"	</p>" +
				"	</div>" +
				"	</body>" +
				"</html>");

		jpInfo.add(jlInfo);
		this.add(jpInfo);
	}
}
