package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RunController implements ActionListener {
	private JTextField tfSearch;
	private JFrame frame;
	
	public RunController(JTextField textField, JFrame frame) {
		this.tfSearch = textField;
		this.frame = frame;
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		try {
			String cmd = tfSearch.getText();
			Runtime.getRuntime().exec(cmd);
			frame.dispose();
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(frame, "Erro ao executar o comando", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}

	
