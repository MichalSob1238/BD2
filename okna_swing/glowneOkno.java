import javax.swing.JFrame;

public class glowneOkno extends JFrame{
	private oknoLogowania logowanie;
	private oknoStartowe start;
	
	public glowneOkno() {
		super("Baza danych - Sklep");
		setSize(300, 300);
		setResizable(true);
		setLocation(450, 200);
		
		logowanie = new oknoLogowania();
		start = new oknoStartowe();
	}
	public void oknoLogowania(boolean badMsg) {
		logowanie.show(badMsg);
		add(logowanie);
	}
	public void oknoStartowe(boolean manager) {
		start.show(manager);
		add(start);
	}
}
