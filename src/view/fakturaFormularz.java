package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fakturaFormularz extends JPanel implements ActionListener{
	
	private View view;
	
	private JLabel name;
	private JButton cofnij;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
    private JLabel nazwa;
    private JTextField nazwaPole;
    private JLabel adres;
    private JTextField adresPole;
    private JLabel nip;
    private JTextField nipPole;
    private JLabel paragon;
    private JTextField paragonPole;
	private JButton zatwierdz;

	public fakturaFormularz(View view) {
		this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);
        
        name = new JLabel();
        cofnij = new JButton("cofnij");
        zatwierdz = new JButton("utworz");
        cofnij.addActionListener(this);
        zatwierdz.addActionListener(this);
        
        nazwa = new JLabel("Nazwa: ");
        nazwaPole = new JTextField();
        nazwaPole.setPreferredSize(new Dimension(70, 20));
        adres = new JLabel("Adres: ");
        adresPole = new JTextField();
        adresPole.setPreferredSize(new Dimension(70, 20));
        nip = new JLabel("NIP: ");
        nipPole = new JTextField();
        nipPole.setPreferredSize(new Dimension(70, 20));
        paragon = new JLabel("Paragon: ");
        paragonPole = new JTextField();
        paragonPole.setPreferredSize(new Dimension(70, 20));
        
        
        pom.insets = new Insets(0, 0, 20, 50);
        pom.gridx = 0;
        pom.gridy = 0;
        add(cofnij, pom);

        pom.insets = new Insets(0, 30, 20, 0);
        pom.gridx = 4;
        add(name, pom);

        pom.insets = new Insets(0, 0, 0, 0);
        pom.gridx = 1;
        pom.gridy = 1;
        add(nazwa, pom);
        
        pom.gridx = 3;
        add(nazwaPole, pom);
        
        pom.gridy = 2;
        add(adresPole, pom);
        
        pom.gridx = 1;
        add(adres, pom);
        
        pom.gridy = 3;
        add(nip, pom);
        
        pom.gridx = 3;
        add(nipPole, pom);
        
        pom.gridy = 4;
        add(paragonPole, pom);
        
        pom.gridx = 1;
        add(paragon, pom);
        
        pom.gridx = 2;
        pom.gridy = 5;
        add(zatwierdz, pom);
	}
	
	public void show(String nameUser) {
		name.setText(nameUser);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if(button == cofnij) {
			view.wybranoFaktury();
		} else if(button == zatwierdz) {
			
		}
	}

}
