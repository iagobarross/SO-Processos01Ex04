/*EXERCÍCIO 4 (DESAFIO) – Exclusivo Windows:
Utilizando o Framework Window Builder, criar, em Eclipse, um projeto Java que simula o
Executar (Run) do Windows.
No package view, deve ser criado, com auxílio do framework, conforme figura abaixo, uma tela
com um JTextField e 3 botões (OK, Cancelar e Procurar).
No package controller, devemos ter :
1) Uma classe, chamada SearchController, que receba o JTextField pelo construtor, implementa
um ActionListener para executar a ação do botão Procurar. No método ActionPerformed, deve
ter uma busca de arquivos executáveis Windows, via JFileChooser, e seleciona o arquivo a ser
executado e escreve seu caminho completo no JTextField.
2) Uma classe, chamada RunController, que receba o JTextField e o próprio JFrame da tela pelo
construtor, implementa um ActionListener para executar a ação do
botão OK. No método ActionPerformed, deve tentar executar o que está escrito no JTextField
(O usuário pode digitar o caminho por conta própria, ao invés de procurar). Caso o arquivo seja
inválido, dar uma mensagem de erro. Uma vez executado, sem erro, a tela deverá ser finalizada
pelo método dispose().
3) Uma classe, chamada CancelController, que receba o próprio JFrame da tela pelo construtor,
implementa um ActionListener para executar a ação do botão Cancelar. O método
actionPerformed deve proceder um dispose() da tela.
*/
package view;
 

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import controller.SearchController;
import controller.RunController;
import controller.CancelController;

public class Executar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSearch;
	private JLabel lblInputMessage;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnSearch;
	private JLabel lblOpen;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executar frame = new Executar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Executar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInputMessage = new JLabel("Digite o caminho do executável ou clique e Procurar");
		lblInputMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInputMessage.setBounds(87, 39, 285, 33);
		contentPane.add(lblInputMessage);
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOK.setBounds(35, 135, 89, 23);
		contentPane.add(btnOK);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBounds(170, 135, 89, 23);
		contentPane.add(btnCancel);
		
		btnSearch = new JButton("Procurar");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(308, 135, 89, 23);
		contentPane.add(btnSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(58, 83, 339, 20);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		lblOpen = new JLabel("Abrir:");
		lblOpen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpen.setBounds(10, 77, 38, 33);
		contentPane.add(lblOpen);
		
		btnSearch.addActionListener(new SearchController(tfSearch));
		btnOK.addActionListener(new RunController(tfSearch, this));
		btnCancel.addActionListener(new CancelController(this));
		
	}
}
