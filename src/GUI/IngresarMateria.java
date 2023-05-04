package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import Logic.Main;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IngresarMateria extends JPanel {
	
	private JFrame ventana;
	private JTextField lblMateria;
	private Main logica;
	private AdministrarMateria adminMateria;
	private JPanel estePanel;

	//Formulario para entrar
	private JPanel panelIngresar = new JPanel();
	private JPanel panelIngresar2 = new JPanel();
	private JLabel titulo = new JLabel("INGRESAR MATERIA");
	private JButton btnIngresar = new JButton("Ingresar");
	//Foto izquierda uns
	private JPanel panelPhoto = new JPanel();
	private JLabel photo = new JLabel("");

	/**
	 * Create the panel.
	 */
	public IngresarMateria(JFrame v,Main l) {
		ventana = v;
		estePanel = this;
		setBackground(new Color(255, 255, 255));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setSize(1000,700);
		JPanel panel = new JPanel();
		panel.setSize(1000,700);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));


		panelIngresar.setSize(500,700);
		panelIngresar.setBackground(new Color(240, 240, 240));
		panel.add(panelIngresar);
		GridBagLayout gbl_panelIngresar = new GridBagLayout();
		gbl_panelIngresar.columnWidths = new int[] {100, 200, 100};
		gbl_panelIngresar.rowHeights = new int[] {110, 110, 250, 110, 110};
		gbl_panelIngresar.columnWeights = new double[]{1.0, 0.0};
		gbl_panelIngresar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelIngresar.setLayout(gbl_panelIngresar);


		GridBagConstraints gbc_panelIngresar2 = new GridBagConstraints();
		gbc_panelIngresar2.insets = new Insets(0, 0, 5, 0);
		gbc_panelIngresar2.fill = GridBagConstraints.VERTICAL;
		gbc_panelIngresar2.gridx = 1;
		gbc_panelIngresar2.gridy = 2;
		panelIngresar.add(panelIngresar2, gbc_panelIngresar2);
		GridBagLayout gbl_panelIngresar2 = new GridBagLayout();
		gbl_panelIngresar2.columnWidths = new int[] {250};
		gbl_panelIngresar2.rowHeights = new int[] {75, 30, 75};
		gbl_panelIngresar2.columnWeights = new double[]{1.0};
		gbl_panelIngresar2.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelIngresar2.setLayout(gbl_panelIngresar2);
		

		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
	    
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		panelIngresar2.add(titulo, gbc_titulo);
		
		lblMateria = new JTextField();
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 0);
		gbc_lblMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 1;
		panelIngresar2.add(lblMateria, gbc_lblMateria);
		lblMateria.setColumns(10);
		
		//Aca control materias
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String materia = lblMateria.getText().toUpperCase();
					
					adminMateria = new AdministrarMateria(estePanel, ventana,materia);
					
					if(!materia.isEmpty()) {
						cambiarVentana(adminMateria);
					}
					lblMateria.setText("");
		
				
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresar.gridx = 0;
		gbc_btnIngresar.gridy = 2;
		panelIngresar2.add(btnIngresar, gbc_btnIngresar);
		FlowLayout fl_panelPhoto = (FlowLayout) panelPhoto.getLayout();
		fl_panelPhoto.setHgap(0);
		fl_panelPhoto.setVgap(0);
		panelPhoto.setBackground(new Color(128, 64, 0));
		panel.add(panelPhoto);
		
		
		Image imagen = new ImageIcon(IngresarMateria.class.getResource("/Recs/photoAlem1.png")).getImage().getScaledInstance(932, 700, Image.SCALE_SMOOTH);
		photo.setIcon(new ImageIcon(imagen));
		photo.setBounds(0, 0, 0, 0);
		panelPhoto.add(photo);

	}
	
	private void cambiarVentana(AdministrarMateria admiMateria) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(admiMateria);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

}
