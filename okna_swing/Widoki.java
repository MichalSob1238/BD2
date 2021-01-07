import java.awt.EventQueue;

import javax.swing.JFrame;

public class Widoki {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				
				glowneOkno wsk = new glowneOkno();
				wsk.oknoStartowe(true);//tu wstawiæ funkcjê, która tworzy odpowiednie okno
				wsk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				wsk.setVisible(true);
			}
		});
	}
}
