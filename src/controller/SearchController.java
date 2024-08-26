package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class SearchController implements ActionListener {
	private JTextField tfSearch;
	
	public SearchController(JTextField textField) {
		this.tfSearch= textField;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int retorno = fileChooser.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION) {
			tfSearch.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}
}
