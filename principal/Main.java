import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		JanelaRecorde janelaRecorde = new JanelaRecorde();
		JanelaManual janelaManual = new JanelaManual();
		JanelaInfo janelaInfo = new JanelaInfo();
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal("Resta Um", janelaRecorde, janelaManual, janelaInfo);
		
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.pack();
		janelaPrincipal.setVisible(true);

	}

}
