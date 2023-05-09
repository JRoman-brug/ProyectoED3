package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Main;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class VentanaPrincipal {

	private JFrame frmSiuGuaran;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmSiuGuaran.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Configuro el frame
		frmSiuGuaran = new JFrame();
		frmSiuGuaran.setTitle("SIU Guaraní");
		frmSiuGuaran.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Recs/logo-uns2.png")));
		frmSiuGuaran.setResizable(false);
		frmSiuGuaran.setBounds(100, 100, 1000, 700);
		//Inicio el JPanel 
		IngresarMateria ingresarMateria = new IngresarMateria(frmSiuGuaran);
		frmSiuGuaran.getContentPane().add(ingresarMateria);
		ingresarMateria.setLayout(new BoxLayout(ingresarMateria, BoxLayout.Y_AXIS));
		frmSiuGuaran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
