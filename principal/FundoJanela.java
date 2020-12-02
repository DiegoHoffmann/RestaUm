import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class FundoJanela extends JPanel{
	File f = new File(".");
	String imagemResta = f.getAbsolutePath() + "/imagens/Lighthouse.jpg";
	String marvel =  f.getAbsolutePath() + "/imagens/marvel.png";
	public void paintComponent(Graphics g) {
		g.drawImage(this.getImage(marvel), 0, 0, 800, 600, this);
	}
	public BufferedImage getImage(String path) {

		File inputFile = new File(path);
		try {
			BufferedImage imagem = ImageIO.read(inputFile);

			return imagem;

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
