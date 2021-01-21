package view;

import controller.Controller;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class View {
	Controller controller;
	Model model;
    private glowneOkno wsk;
    
    public View(){
    	wsk = new glowneOkno();
        wsk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wsk.setVisible(true);
    }

	public void setControllerAndModel(Controller controller, Model model) {
		this.controller = controller;
		this.model = model;
	}

	public void oknoLogowania() {
		wsk.oknoLogowania(false);
		wsk.repaint();
	}
	
	public void oknoLogowaniePonowne() {
		wsk.oknoLogowania(true);
		wsk.repaint();
	}
	
	public void oknoStartoweZwyklegoPracownika() {
		wsk.oknoStartowe(false);
		wsk.repaint();
	}
	
	public void oknoStartoweMenadzer() {
		wsk.oknoStartowe(true);
		wsk.repaint();
	}
}

