package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class oknoZwrotu extends JPanel implements ActionListener{

	private View view;
	private JLabel msg;
	private JLabel nameLabel;
	private JTextField idField;
	private JLabel name;
	
	private JButton loginButton;
	private JButton returnButton;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoZwrotu(View view) {
	this.view = view;
	
	layout = new GridBagLayout();
	pom = new GridBagConstraints();
	
	msg = new JLabel("Nie ma takiego pracownika!");
	msg.setForeground(Color.RED);

	name = new JLabel("");

	nameLabel = new JLabel("Numer Rachunku:");
	
	idField = new JTextField();
	idField.setPreferredSize(new Dimension(70, 20));

	loginButton = new JButton("Dokonaj Zwrotu");
	loginButton.addActionListener(this);

	returnButton = new JButton("cofnij");
	returnButton.addActionListener(this);
	

	setLayout(layout);

	pom.insets = new Insets(0, 40, 60, 0);
	pom.gridx = 1;
	add(name,pom);

	pom.insets = new Insets(0, 0, 0, 0);
	pom.gridx = 0;
	pom.gridy = 1;
	pom.gridwidth = 1;
	add(nameLabel, pom);
	
	pom.gridx = 1;
	add(idField, pom);
	
	
	
	
	pom.insets = new Insets(20, 0, 0, 0);
	pom.gridx = 0;
	pom.gridy = 3;
	pom.gridwidth = 2;
	add(loginButton, pom);
	pom.gridy = 4;
	add(returnButton,pom);

	}

	public void show(String nameUser) {
		name.setText(nameUser);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if(button == returnButton) {
			view.oknoStartowe();
		}else if(button == loginButton) {
			String receipt = idField.getText();
			view.podanoPargonZwrot(receipt);

		}
	}
	
}
