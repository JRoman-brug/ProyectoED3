package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AdministrarMateria extends JPanel {

	//ventana principal
	private JFrame ventana;
	private JPanel anterior;
	
	private JPanel panel = new JPanel();
	private JPanel panelDatos = new JPanel();
	private JLabel lblPhoto = new JLabel("");
	private JPanel panelAdminitrar = new JPanel();
	private JPanel panelTabla = new JPanel();
	private JPanel panelDatosPromedioNotaMin = new JPanel();
	private JPanel panelCabecera = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JPanel panelTitulo = new JPanel();
	private JLabel lblMateria = new JLabel("Estrucutas de datos");
	private JButton btnVolver = new JButton("Volver");
	private JButton btnAlumnoNuevo = new JButton("Agregar alumno");
	private JButton btnOrdenMayorMenor = new JButton("Ordenar mayor a menor");
	private JButton btnAlumnosAprobados = new JButton("Mostrar alumnos aprobados");
	private JButton btnAlumnosDesaprobados = new JButton("Mostrar alumnos desaprobados");
	private JLabel lblPromedio = new JLabel("El promedio general es: 30");
	private JLabel lblNotaMinima = new JLabel("La nota minima es: 2");
	private Component horizontalStrut = Box.createHorizontalStrut(30);
	private Component horizontalStrut_1 = Box.createHorizontalStrut(40);
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table_1 = new JTable();
	/**
	 * Create the panel.
	 */
	public AdministrarMateria(JPanel a,JFrame v,String materia) {
		ventana = v;
		anterior = a;
		lblMateria.setText(materia);
		//Configuro panel principal 
		setSize(1000,700);
		
		
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {700, 300};
		gbl_panel.rowHeights = new int[] {700};
		gbl_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		//Configurar panelDatos
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.anchor = GridBagConstraints.NORTH;
		gbc_panelDatos.gridx = 0;
		gbc_panelDatos.gridy = 0;
		panel.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[] {700};
		gbl_panelDatos.rowHeights = new int[] {150, 450, 50};
		gbl_panelDatos.columnWeights = new double[]{1.0};
		gbl_panelDatos.rowWeights = new double[]{1.0, 1.0, 1.0};
		panelDatos.setLayout(gbl_panelDatos);
		
		GridBagConstraints gbc_panelAdminitrar = new GridBagConstraints();
		gbc_panelAdminitrar.insets = new Insets(0, 30, 5, 0);
		gbc_panelAdminitrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAdminitrar.gridx = 0;
		gbc_panelAdminitrar.gridy = 0;
		panelAdminitrar.setBackground(new Color(255, 255, 0));
		panelDatos.add(panelAdminitrar, gbc_panelAdminitrar);
		panelAdminitrar.setLayout(new BoxLayout(panelAdminitrar, BoxLayout.Y_AXIS));
		
		panelAdminitrar.add(panelCabecera);
		GridBagLayout gbl_panelCabecera = new GridBagLayout();
		gbl_panelCabecera.columnWidths = new int[] {700};
		gbl_panelCabecera.rowHeights = new int[] {0, 75, 50};
		gbl_panelCabecera.columnWeights = new double[]{0.0};
		gbl_panelCabecera.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelCabecera.setLayout(gbl_panelCabecera);
		
		GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
		gbc_panelTitulo.anchor = GridBagConstraints.WEST;
		gbc_panelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitulo.gridx = 0;
		gbc_panelTitulo.gridy = 1;
		panelCabecera.add(panelTitulo, gbc_panelTitulo);
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarVentana();
			}
		});
		
		panelTitulo.add(btnVolver);
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		panelTitulo.add(lblMateria);
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.anchor = GridBagConstraints.WEST;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 2;
		panelCabecera.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnAlumnoNuevo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panelBotones.add(btnAlumnoNuevo);
		btnOrdenMayorMenor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		panelBotones.add(btnOrdenMayorMenor);
		btnAlumnosAprobados.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		panelBotones.add(btnAlumnosAprobados);
		btnAlumnosDesaprobados.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		panelBotones.add(btnAlumnosDesaprobados);
		
		//Datos
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 20, 5, 0);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 1;
		panelTabla.setBackground(new Color(255, 0, 0));
		panelDatos.add(panelTabla, gbc_panelTabla);
		
	
		
		
		
		table_1 = new JTable();
		table_1.setBounds(10,38,400,200);
		DefaultTableModel modelo = new DefaultTableModel(0,0);
		String[] columnsName = new String[] {"Alumno","LU","Nota"};
		modelo.setColumnIdentifiers(columnsName);
		
		for (int i = 0; i < 40; i++) {
			modelo.addRow(new Object[] {"Test1","Test2","Test3"});
		}
		
		panelTabla.setLayout(new BoxLayout(panelTabla, BoxLayout.X_AXIS));
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setModel(modelo);
		scrollPane.setViewportView(table_1);

	    scrollPane.setBounds(10, 38, 414, 212);
		panelTabla.add(scrollPane);
		
		
	
		
		
		
		GridBagConstraints gbc_panelDatosPromedioNotaMin = new GridBagConstraints();
		gbc_panelDatosPromedioNotaMin.anchor = GridBagConstraints.WEST;
		gbc_panelDatosPromedioNotaMin.insets = new Insets(0, 20, 5, 0);
		gbc_panelDatosPromedioNotaMin.gridx = 0;
		gbc_panelDatosPromedioNotaMin.gridy = 2;
		panelDatosPromedioNotaMin.setBackground(new Color(0, 128, 0));
		panelDatos.add(panelDatosPromedioNotaMin, gbc_panelDatosPromedioNotaMin);
		
		panelDatosPromedioNotaMin.add(horizontalStrut);
		
		panelDatosPromedioNotaMin.add(lblPromedio);
		
		panelDatosPromedioNotaMin.add(horizontalStrut_1);
		
		panelDatosPromedioNotaMin.add(lblNotaMinima);
		
		
		
		
		//Grid foto
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 0;
		panel.add(lblPhoto, gbc_lblPhoto);
		
		//foto izquierda
		Image imagen = new ImageIcon(IngresarMateria.class.getResource("/Recs/photoAlem2.png")).getImage().getScaledInstance(300, 700, Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(imagen));
		

	}
	
	private void cambiarVentana() {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(anterior);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

}
