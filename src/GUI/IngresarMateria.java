package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

@SuppressWarnings("serial")
public class IngresarMateria extends JPanel {

	private JFrame ventana;
	private JTextField textFieldMateria;
	private Main logica;
	private AdministrarMateria adminMateria;

	//Formulario para entrar
	private JPanel panelIngresar = new JPanel();
	private JPanel panelIngresar2 = new JPanel();
	private JLabel titulo = new JLabel("INGRESAR MATERIA");
	private JButton btnIngresar = new JButton("Ingresar");
	//Foto izquierda uns
	private JPanel panelPhoto = new JPanel();
	private JLabel photo = new JLabel("");

	/**
	 * Creo el panel ingresar materia, el primer panel
	 *  @param v frame de la aplicacion
	 */
	public IngresarMateria(JFrame v) {
		ventana = v;

		//Configuro el panel
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setSize(1000,700);
		JPanel panel = new JPanel();
		panel.setSize(1000,700);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		//Configuro panelIngresar
		panelIngresar.setSize(500,700);
		panelIngresar.setBackground(new Color(240, 240, 240));
		panel.add(panelIngresar);
		GridBagLayout gbl_panelIngresar = new GridBagLayout();
		gbl_panelIngresar.columnWidths = new int[] {100, 200, 100};
		gbl_panelIngresar.rowHeights = new int[] {110, 110, 250, 110, 110};
		gbl_panelIngresar.columnWeights = new double[]{1.0, 0.0};
		gbl_panelIngresar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelIngresar.setLayout(gbl_panelIngresar);


		//Configuro panelIngresar2, el cual se encargar de centrar el input y titulo
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

		//Configuro la label
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));

		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 0;
		panelIngresar2.add(titulo, gbc_titulo);

		//Configuro el textField
		textFieldMateria = new JTextField();
		GridBagConstraints gbc_textFieldMateria = new GridBagConstraints();
		gbc_textFieldMateria.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMateria.gridx = 0;
		gbc_textFieldMateria.gridy = 1;
		panelIngresar2.add(textFieldMateria, gbc_textFieldMateria);
		textFieldMateria.setColumns(10);


		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ventana.getRootPane().setDefaultButton(btnIngresar);

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


		//Listeners
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtengo el nombre de la materia
				String materia = textFieldMateria.getText().toUpperCase();

				//Si el textField no esta vacio voy al siguiente panel
				if(!materia.isEmpty()) {
					//Creo el objeto main
					logica = new Main(materia);
					//Creo el panel adminitrarMateria
					adminMateria = new AdministrarMateria(ventana, logica);
					//Cambio el panel
					cambiarVentana(adminMateria);
					textFieldMateria.setText("");
				}


			}
		});
	}

	/**
	 * Cambia el panel de la ventana
	 * @param admiMateria nuevo panel al cual se quiera ir
	 */
	private void cambiarVentana(AdministrarMateria admiMateria) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(admiMateria);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

}
