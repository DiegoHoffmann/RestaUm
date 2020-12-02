import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Tabuleiro extends JPanel {

	File f = new File(".");
	String imagenCelOn = f.getAbsolutePath() + "/imagens/gem.png";
	String imagenCelOff = f.getAbsolutePath() + "/imagens/gemBlack.png";
	String imagenCelBlue = f.getAbsolutePath() + "/imagens/blue.png";
	String imagenCelOnSel = f.getAbsolutePath() + "/imagens/gemSel.png";
	static int  tamTab = 7;
	int linha = 500 / tamTab;
	int coluna = 500 / tamTab;
	static int contaPeca = 32;
	static int deslocamentoX = 30;
	static int deslocamentoY = 10;
	static boolean novoJogo = true;
	static Peca[][] peca; 

	public Tabuleiro() {
		this.addMouseListener(new selecionaPeca());
		peca = new Peca[7][7];
		
	}

	
	public void paintComponent(Graphics g) {
		if(novoJogo) {
			for (int i = 0; i < tamTab; i++) {
				boolean flag = false;
				for (int j = 0; j < tamTab; j++) {
					if (i == 3 & j == 3) {
						g.drawImage(this.getImage(imagenCelOff), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
						flag = true;
					} else if ((j >= 2 && j <=4 ) || (i >= 2 && i <= 4)) {
						g.drawImage(this.getImage(imagenCelOn), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
						flag = true;
					} else {
						g.drawImage(this.getImage(""), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
						flag = false;
					}
	
					if (flag) {
						if (i == 3 && j == 3) {
							peca[i][j] = new Peca(deslocamentoX + (j * coluna),
									deslocamentoY + (i * linha), false, true, false);
						} else {
							peca[i][j] = new Peca(deslocamentoX + (j * coluna),
									deslocamentoY + (i * linha), true, true, false);
						}
					} else {
						peca[i][j] = new Peca(deslocamentoX + (j * coluna),
								deslocamentoY + (i * linha), false, false, false);
					}
				}
			}
			for (int i = 0; i < tamTab; i++) {
				for (int j = 0; j < tamTab; j++) {
					System.out.println("Peca: " + i + " - " + j);
					System.out.println("Peca posX " + peca[i][j].getX());
					System.out.println("Peca posY " + peca[i][j].getY());
					System.out.println("Peca eh Peca " + peca[i][j].isEhPeca());
				}
			}
		}else{
			for (int i = 0; i < tamTab; i++) {
				for (int j = 0; j < tamTab; j++) {
					if(!peca[i][j].isEhPeca()){
						g.drawImage(this.getImage(""), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
					}else if (peca[i][j].isSelecionada()) {
						g.drawImage(this.getImage(imagenCelOnSel), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
					}else if (!peca[i][j].isStatus()) {
						g.drawImage(this.getImage(imagenCelOff), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
					} else if (peca[i][j].isStatus()) {
						g.drawImage(this.getImage(imagenCelOn), deslocamentoX
								+ (j * coluna), deslocamentoY + (i * linha),
								coluna, linha, null);
					} 
				}
			}
		}
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

	class selecionaPeca implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			novoJogo = false;
			System.out.println("X: " + x + " - Y: " + y);
			temPeca(x, y);
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void temPeca(int x, int y) {
			int pecaPosX;
			int pecaPosY;
			boolean pecaEhPeca = false;
			boolean pecaStatus = false;
			for (int i = 0; i < tamTab; i++) {
				for (int j = 0; j < tamTab; j++) {
					pecaPosX = peca[i][j].getX();
					pecaPosY = peca[i][j].getY();
					pecaEhPeca = peca[i][j].isEhPeca();
					pecaStatus = peca[i][j].isStatus();
					if ((x >= pecaPosX) && (x < pecaPosX + 70)) {
						if ((y >= pecaPosY) && (y < pecaPosY + 70)) {
							if ((pecaEhPeca && pecaStatus)|| temPecaSelecionada(i, j)) {
								if (!temPecaSelecionada(i, j)) {
									System.out.println("Tem peca");
									pecaSelecionada(i, j, peca[i][j].isSelecionada(), false);
									peca[i][j].setSelecionada(!peca[i][j].isSelecionada());
									System.out.println(peca[i][j].isStatus());
								} else if (validaJogada(x, y)) {
									System.out.println("Jogada Valida");
									contaPeca--;
									System.out.println("Pecas Restantes: " + contaPeca);
									
								}
							}
						}
					}
				}
			}
		}

		public void pecaSelecionada(int i, int j, boolean sel, boolean semPeca) {

			Graphics g = getGraphics();
			if (semPeca) {
				g.drawImage(getImage(imagenCelOff), deslocamentoX
						+ (j * coluna), deslocamentoY + (i * linha), coluna,
						linha, null);
			} else if (!sel) {
				g.drawImage(getImage(imagenCelOnSel), deslocamentoX
						+ (j * coluna), deslocamentoY + (i * linha), coluna,
						linha, null);
			} else {
				g.drawImage(getImage(imagenCelOn),
						deslocamentoX + (j * coluna), deslocamentoY
								+ (i * linha), coluna, linha, null);
			}
		}

		public boolean temPecaSelecionada(int y, int x) {
			for (int i = 0; i < tamTab; i++) {
				for (int j = 0; j < tamTab; j++) {
					if (peca[i][j].isSelecionada()) {
						if (i == y && j == x) {
							return false;
						}
						// System.out.println(i + " - " + j);
						return true;
					}
				}
			}
			return false;
		}

		// Valida jogada parametros é a posição do mouse
		public boolean validaJogada(int x, int y) {
			int pecaPosX;
			int pecaPosY;
			// boolean pecaEhPeca = false;
			for (int i = 0; i < tamTab; i++) {
				for (int j = 0; j < tamTab; j++) {
					pecaPosX = peca[i][j].getX();
					pecaPosY = peca[i][j].getY();
					if ((x >= pecaPosX) && (x < pecaPosX + 70)) {
						if ((y >= pecaPosY) && (y < pecaPosY + 70)) {
							if (!peca[i][j].isStatus() && peca[i][j].isEhPeca()) {
								if (i >= 2) {
									if (peca[i - 2][j].isSelecionada()) {
										if (peca[i - 1][j].isStatus()) {
											peca[i][j].setSelecionada(false);
											peca[i][j].setStatus(true);
											pecaSelecionada(i, j, true, false);
											peca[i - 1][j]
													.setSelecionada(false);
											peca[i - 1][j].setStatus(false);
											pecaSelecionada(i - 1, j, false,
													true);
											peca[i - 2][j]
													.setSelecionada(false);
											peca[i - 2][j].setStatus(false);
											pecaSelecionada(i - 2, j, false,
													true);
											return true;
										}
									}
								}
								if (i <= 4) {
									if (peca[i + 2][j].isSelecionada()) {
										if (peca[i + 1][j].isStatus()) {
											peca[i][j].setSelecionada(false);
											peca[i][j].setStatus(true);
											pecaSelecionada(i, j, true, false);
											peca[i + 1][j]
													.setSelecionada(false);
											peca[i + 1][j].setStatus(false);
											pecaSelecionada(i + 1, j, false,
													true);
											peca[i + 2][j]
													.setSelecionada(false);
											peca[i + 2][j].setStatus(false);
											pecaSelecionada(i + 2, j, false,
													true);
											return true;
										}
									}
								}
								if (j >= 2) {
									if (peca[i][j - 2].isSelecionada()) {
										if (peca[i][j - 1].isStatus()) {
											peca[i][j].setSelecionada(false);
											peca[i][j].setStatus(true);
											pecaSelecionada(i, j, true, false);
											peca[i][j - 1]
													.setSelecionada(false);
											peca[i][j - 1].setStatus(false);
											pecaSelecionada(i, j - 1, false,
													true);
											peca[i][j - 2]
													.setSelecionada(false);
											peca[i][j - 2].setStatus(false);
											pecaSelecionada(i, j - 2, false,
													true);
											return true;
										}
									}
								}
								if (j <= 4) {
									if (peca[i][j + 2].isSelecionada()) {
										if (peca[i][j + 1].isStatus()) {
											peca[i][j].setSelecionada(false);
											peca[i][j].setStatus(true);
											pecaSelecionada(i, j, true, false);
											peca[i][j + 1]
													.setSelecionada(false);
											peca[i][j + 1].setStatus(false);
											pecaSelecionada(i, j + 1, false,
													true);
											peca[i][j + 2]
													.setSelecionada(false);
											peca[i][j + 2].setStatus(false);
											pecaSelecionada(i, j + 2, false,
													true);
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
			return false;
		}

	}
}
