package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Logic.Main;
import Logic.Par;
import TDALista.PositionList;

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
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AdministrarMateria extends JPanel {

	//ventana principal
	private JFrame ventana;
	private Main logica;

	//Paneles 
	private JPanel panel = new JPanel();
	private JPanel panelDatos = new JPanel();
	private JLabel lblPhoto = new JLabel("");
	private JPanel panelAdminitrar = new JPanel();
	private JPanel panelTabla = new JPanel();
	private JPanel panelDatosPromedioNotaMin = new JPanel();
	private JPanel panelCabecera = new JPanel();
	private JPanel panelBotones = new JPanel();

	//Labels
	private JLabel lblMateria = new JLabel("Estrucutas de datos");
	private JLabel lblPromedio = new JLabel("El promedio general es: 0");
	private JLabel lblNotaMinima = new JLabel("La nota minima es: 0");

	//Separadores parte de abajo donde va promedio
	private Component horizontalStrut = Box.createHorizontalStrut(30);
	private Component horizontalStrut_1 = Box.createHorizontalStrut(40);

	//Panel de tabla
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table_1 = new JTable();
	private DefaultTableModel modelo;
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JButton btnAlumnoNuevo = new JButton("Agregar alumno");
	private final JButton btnOrdenMayorMenor = new JButton("Ordenar mayor a menor");
	private final JButton btnAlumnosAprobados = new JButton("Mostrar alumnos aprobados");
	private final JButton btnAlumnosDesaprobados = new JButton("Mostrar alumnos desaprobados");
	private final JButton btnEliminarAlumno = new JButton("Eliminar alumno");
	private final JButton btnNewButton = new JButton("Obtener nota");

	/**
	 * Creo el panel donde se adminitra las notas
	 * @param v Frame donde se contiene la aplicacion
	 * @param l Objeto de logica
	 */
	public AdministrarMateria(JFrame v, Main l) {
		ventana = v;
		logica = l;

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


		//Grid de panel adminitrar
		GridBagConstraints gbc_panelAdminitrar = new GridBagConstraints();
		gbc_panelAdminitrar.insets = new Insets(0, 30, 5, 0);
		gbc_panelAdminitrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAdminitrar.gridx = 0;
		gbc_panelAdminitrar.gridy = 0;
		panelAdminitrar.setBackground(new Color(255, 255, 0));
		panelDatos.add(panelAdminitrar, gbc_panelAdminitrar);
		panelAdminitrar.setLayout(new BoxLayout(panelAdminitrar, BoxLayout.Y_AXIS));

		//Configurar panel cabecera
		panelAdminitrar.add(panelCabecera);
		GridBagLayout gbl_panelCabecera = new GridBagLayout();
		gbl_panelCabecera.columnWidths = new int[] {700};
		gbl_panelCabecera.rowHeights = new int[] {75, 50};
		gbl_panelCabecera.columnWeights = new double[]{0.0};
		gbl_panelCabecera.rowWeights = new double[]{0.0, 0.0};
		panelCabecera.setLayout(gbl_panelCabecera);


		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 0);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panelCabecera.add(lblMateria, gbc_lblMateria);
		//Agrego el nombre a la cabecera
		lblMateria.setText(logica.getMateria());
		lblMateria.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));

		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotones.anchor = GridBagConstraints.WEST;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 1;
		panelCabecera.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));

		panelBotones.add(panel_1);
		btnAlumnoNuevo.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_1.add(btnAlumnoNuevo);
		btnOrdenMayorMenor.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_1.add(btnOrdenMayorMenor);
		btnAlumnosAprobados.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_1.add(btnAlumnosAprobados);
		btnAlumnosDesaprobados.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_1.add(btnAlumnosDesaprobados);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		panelBotones.add(panel_2);
		btnEliminarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_2.add(btnEliminarAlumno);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_2.add(btnNewButton);

		//Datos
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 20, 5, 0);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 1;
		panelTabla.setBackground(new Color(255, 0, 0));
		panelDatos.add(panelTabla, gbc_panelTabla);


		//Creo una tabla
		table_1.setBounds(10,38,400,200);

		//Setup del modelo de la tabla
		modelo = getModelo();

		//Agrego el modelo a la tabla
		panelTabla.setLayout(new BoxLayout(panelTabla, BoxLayout.X_AXIS));
		table_1.setModel(modelo);


		scrollPane.setViewportView(table_1);

		scrollPane.setBounds(10, 38, 414, 212);
		panelTabla.add(scrollPane);


		//Configuro panel datos con el promedio y nota minima

		GridBagConstraints gbc_panelDatosPromedioNotaMin = new GridBagConstraints();
		gbc_panelDatosPromedioNotaMin.anchor = GridBagConstraints.WEST;
		gbc_panelDatosPromedioNotaMin.insets = new Insets(0, 20, 5, 0);
		gbc_panelDatosPromedioNotaMin.gridx = 0;
		gbc_panelDatosPromedioNotaMin.gridy = 2;
		panelDatosPromedioNotaMin.setBackground(new Color(255, 255, 255));
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

		//Listener de botones
		//Agregar alumno
		btnAlumnoNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarVentanaAgregarAlumno();
			}
		});
		//Ordenar (momentariamente lo utilizare para rellenar la tabla)
		btnOrdenMayorMenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test();
			}
		});
		//Alumnos aprobados
		btnAlumnosAprobados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aprobados();
			}
		});
		//Alumnos desaprobados
		btnAlumnosDesaprobados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desaprobados();
			}
		});

		//Eliminar
		btnEliminarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarVentanaEliminarAlumno();
			}
		});
		//Obtener nota de un alumno
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarVentanaObtenerAlumno();
			}
		});


	}

	private void llamarVentanaAgregarAlumno() {
		AgregarAlumno agregarAlumno = new AgregarAlumno(ventana,this,true);
		agregarAlumno.setVisible(true);
	}

	private void llamarVentanaEliminarAlumno() {
		EliminarAlumno eliminarAlumno = new EliminarAlumno(ventana,this,true);
		eliminarAlumno.setVisible(true);
	}

	private void llamarVentanaObtenerAlumno() {
		ObtenerAlumno obtenerAlumno = new ObtenerAlumno(ventana,logica,true);
		obtenerAlumno.setVisible(true);
	}
	/**
	 * Agrega un registro con los datos de JPanel
	 * @param lu del alumno
	 * @param nota nota del alumno
	 */
	public void AgregarAlumnos(int lu, int nota){
		//Aca se deberia agregar llamar al main y llamar al metodo agregar
		logica.agregarAlumno(lu, nota);
		actualizarTabla(logica.getRegistro());
		actualizarPromedioNotaMinima();
	}
	/**
	 * Si el lu coinciden con algun registro se eliminar y actualiza la tabla, promedio y nota minima
	 * @param lu del alumno el cual se quiere eliminar
	 */
	public void EliminarAlumnos(int lu) {
		logica.eliminarRegistro(lu);
		actualizarTabla(logica.getRegistro());
		actualizarPromedioNotaMinima();
	}

	/**
	 * Borra y actualiza la tabla en caso de agregar o eliminar
	 * @param la lista que se mostrara en la tabla
	 */
	private void actualizarTabla(PositionList<Par> registro) {

		//Reseteo la tabla
		modelo = getModelo();

		Par aux;
		for(Iterator<Par> it = registro.iterator();it.hasNext();) {
			aux = it.next();

			modelo.addRow(new Object[] {aux.getLu(),aux.getNota()});
		}
		table_1.setModel(modelo);
	}
	private void actualizarPromedioNotaMinima() {
		if(!logica.getRegistro().isEmpty()) {
			lblPromedio.setText("El promedio general es: "+logica.calcularPromedio());
			lblNotaMinima.setText("La nota minima es: "+logica.notaMinima());
		}else {
			lblPromedio.setText("El promedio general es: "+0);
			lblNotaMinima.setText("La nota minima es: "+0);
		}
	}
	/**
	 * Filtra la tabla por aprobados
	 */
	private void aprobados() {
		//Obtengo el registro de alumnos
		actualizarTabla(logica.alumnosAprobados());
	}
	/**
	 * Filtra la tabla por aprobados
	 */
	private void desaprobados() {
		//Obtengo el registro de alumnos
		actualizarTabla(logica.alumnosDesaprobados());
	}



	/**
	 * Obtengo un modelo de tabla
	 * @return nuevo modelo de tabla vacio
	 */
	private DefaultTableModel getModelo() {
		//Reseteo la tabla
		DefaultTableModel toReturn = new DefaultTableModel(0,0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnsName = new String[] {"LU","Nota"};
		toReturn.setColumnIdentifiers(columnsName);
		return toReturn;
	}

	private void test() {
		int nota;
		int lu;
		for(int i=0;i<20;i++) {
			lu = (int)(Math.random()*10000)+100000;
			nota = (int)(Math.random()*10)+1;
			AgregarAlumnos(lu, nota);
		}
	}
}
