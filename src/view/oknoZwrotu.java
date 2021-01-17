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

	private JLabel msg;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel surnameLabel;
	
	private JButton loginButton;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoZwrotu() {
		
	layout = new GridBagLayout();
	pom = new GridBagConstraints();
	
	msg = new JLabel("Nie ma takiego pracownika!");
	msg.setForeground(Color.RED);
	
	nameLabel = new JLabel("Numer Rachunku:");
	
	nameField = new JTextField();
	nameField.setPreferredSize(new Dimension(70, 20));

	loginButton = new JButton("Dokonaj Zwrotu");
	loginButton.addActionListener(this);
	

	setLayout(layout);
	Insets pom2 = new Insets(0, 0, 0, 0);
	
	pom.insets = pom2;
	pom.gridy = 1;
	pom.gridwidth = 1;
	add(nameLabel, pom);
	
	pom.gridx = 1;
	add(nameField, pom);
	
	
	
	
	pom.insets = new Insets(20, 0, 0, 0);
	pom.gridx = 0;
	pom.gridy = 3;
	pom.gridwidth = 2;
	add(loginButton, pom);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String receipt = nameField.getText();
		//wywo³anie odpowiedniej metody podaj¹c jako argumenty "name" i "surname"
	}
	
}
