import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Peca {
	private int x;
	private int y;
	private boolean status;
	private boolean ehPeca;
	private boolean selecionada;
	
	
	public Peca(int x, int y,boolean status, boolean ehPeca, boolean selecionada){
		this.x = x;
		this.y = y;
		this.status = status;
		this.ehPeca = ehPeca;
		this.selecionada = selecionada;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;	
	}
	public boolean isEhPeca(){
		return ehPeca;
	}
	public void setEhPeca(boolean ehPeca){
		this.ehPeca = ehPeca;
	}
	public boolean isSelecionada() {
		return selecionada;
	}
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
}
