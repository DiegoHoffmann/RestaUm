import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class JanelaRecorde extends JFrame{
	
	public JanelaRecorde(){
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		String[] colunas = {"Player","Pontos"};
		String[][] rec = new String[9][9];
		int i = 0;
		int j = 0;
		
		try{
			File arq = new File("Recorde.txt");
			FileReader fr = new FileReader(arq);
			BufferedReader br = new BufferedReader(fr);
			String aux;
			String auxNome;
			String auxRec; 	
			while(br.ready()){
				j = 0;
				aux = br.readLine(); 
				auxNome = aux.substring(0, aux.indexOf(";") - 1);
				auxRec = aux.substring(aux.indexOf(";") + 1);
				rec[i][j] = auxNome;
				j++;
				rec[i][j] = auxRec;
				i++;
			}
			fr.close();
			br.close();
		}catch(Exception e){
			System.out.println("Não foi possivel ler o arquivo");
		}
		i = 0;
		j = 0;
		JTable table = new JTable(rec,colunas);
		table.disable();
		JScrollPane scroll = new JScrollPane();  
		scroll.setViewportView(table);  
		jp.add(scroll, BorderLayout.CENTER);
		super.add(jp);
		
	}
}
