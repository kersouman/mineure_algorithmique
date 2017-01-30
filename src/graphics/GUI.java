package graphics;

import javax.swing.JFrame;

public class GUI extends JFrame {

	private Panel contentPane;
	
	public GUI(Panel contentPane) {
		this.contentPane = contentPane;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}
	
}
