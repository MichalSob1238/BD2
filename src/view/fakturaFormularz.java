package view;

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
	
	private JLabel tytul;
	private JButton zatwierdz;

	public fakturaFormularz(View view) {
		this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);
        
        name = new JLabel();
        cofnij = new JButton("cofnij");
        
        
        pom.insets = new Insets(0, 0, 20, 50);
        pom.gridx = 0;
        pom.gridy = 0;
        add(cofnij, pom);

        pom.insets = new Insets(0, 30, 20, 0);
        pom.gridx = 2;
        add(name, pom);

        pom.insets = new Insets(0, 0, 0, 0);
	}
	
	public void show(String nameUser) {
		name.setText(nameUser);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
