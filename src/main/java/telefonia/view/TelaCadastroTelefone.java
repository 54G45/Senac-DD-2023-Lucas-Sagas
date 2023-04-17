package telefonia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telefonia.controller.TelefoneController;
import telefonia.model.vo.Telefone;

public class TelaCadastroTelefone {

	private JFrame frmNovoTelefone;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JCheckBox chckbxMovel = new JCheckBox("  movel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmNovoTelefone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoTelefone = new JFrame();
		frmNovoTelefone.setTitle("Novo Telefone");
		frmNovoTelefone.setBounds(100, 100, 384, 300);
		frmNovoTelefone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovoTelefone.getContentPane().setLayout(null);
		
		JLabel lblDdd = new JLabel("DDD: ");
		lblDdd.setBounds(83, 52, 46, 14);
		frmNovoTelefone.getContentPane().add(lblDdd);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(83, 96, 46, 14);
		frmNovoTelefone.getContentPane().add(lblNumero);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(139, 49, 135, 20);
		frmNovoTelefone.getContentPane().add(txtDdd);
		txtDdd.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(139, 93, 135, 20);
		frmNovoTelefone.getContentPane().add(txtNumero);
		
		
		chckbxMovel.setBounds(117, 132, 97, 23);
		frmNovoTelefone.getContentPane().add(chckbxMovel);
		
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Telefone telefone = new Telefone();
				telefone.setDdd(txtDdd.getText());
				telefone.setMovel(chckbxMovel.isSelected());
				telefone.setNumero(txtNumero.getText());
				telefone.setAtivo(false);
				
				TelefoneController controller = new TelefoneController();
				controller.inserir(telefone);
				
			}
		});
		btnSalvar.setBounds(139, 196, 100, 30);
		frmNovoTelefone.getContentPane().add(btnSalvar);
		
		
	}
}
