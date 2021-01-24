package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoFaktur extends JPanel implements ActionListener {

private View view;
	
	private JLabel name;
	private JButton cofnij;
	private JPanel przyciski;
	private JButton create;
	private JButton lista;
	
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoFaktur(View view) {
		this.view = view;
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		przyciski = new JPanel();
		przyciski.setLayout(new GridLayout( 6, 2, 5, 5));
		
		cofnij = new JButton("cofnij");
		przyciski.add(create = new JButton("nowa faktura"));
		przyciski.add(lista = new JButton("lista faktur"));
		
		cofnij.addActionListener(this);
		create.addActionListener(this);
		lista.addActionListener(this);
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 1;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridx = 0;
		pom.gridy = 1;
		pom.gridwidth = 2;
		add(przyciski, pom);
			
	}
	
	public void show(String nameUser) {
		name.setText(nameUser);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button =(JButton) arg0.getSource();
		if (button == cofnij)
		{
			view.oknoStartowe();
		} else if(button == lista) {
			view.wybranoPrzegladFaktur();
		} else if(button == create) {
			view.utworzFakture();
		}
		
	}

}
