import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.synth.Region;



public class JanelaTabuleiro extends JPanel implements MouseListener{

	File f = new File(".");
	JTable tabela;
	JPanel panelGrid;
	String imagenCelOn = f.getAbsolutePath() + "/imagens/blueOn.png";
	String imagenCelOff = f.getAbsolutePath() + "/imagens/blueOff.png";
	String imagenCelBlue = f.getAbsolutePath() + "/imagens/blue.png";
	String imagenCelOnSel = f.getAbsolutePath() + "/imagens/blueOnSel.png";
	
	public JanelaTabuleiro(){
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(0 ,0, 500, 500);
		int linha = 500 / 9;
        int coluna = 500 / 9;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
            	if(i == 4 & j == 4){
            		g.drawImage(this.getImage(imagenCelOff),1+(j*coluna),1+(i*linha),coluna-1,linha-1,null);
            	}else if((j > 2 && j < 6) || (i > 2 && i < 6)){
            		g.drawImage(this.getImage(imagenCelOn),1+(j*coluna),1+(i*linha),coluna-1,linha-1,null);
            	}else{
            		g.drawImage(this.getImage(imagenCelBlue),1+(j*coluna),1+(i*linha),coluna-1,linha-1,null);
            	}
            }

        }
	}
	
	public BufferedImage getImage(String path){
        
        File inputFile = new File(path);
        try {
            BufferedImage imagem = ImageIO.read(inputFile);
            
            return imagem;
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	//eventos do Mouse

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}
	
	
}
