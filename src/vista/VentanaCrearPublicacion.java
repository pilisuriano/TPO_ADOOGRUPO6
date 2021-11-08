package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import controlador.PublicacionController;
import modelo.vo.PublicacionVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class VentanaCrearPublicacion extends JFrame implements ActionListener {
	private JTextField tfTitulo;
	private JTextField tfSueldo;
	private JButton btnCrear;
	private JButton btnSalir;
	private JComboBox cbCategoria;
	private JTextArea tARequisitos;
	private JComboBox cbTipo;
	private JComboBox cbModalidad;
	private JLabel lbLugarTrabajo;
	private JTextField tfLugarTrabajo;
	private PublicacionController coordinadorPublicaciones;
	private JList listTareas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearPublicacion frame = new VentanaCrearPublicacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCrearPublicacion() {
		setBounds(100, 100, 541, 483);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbTitulo = new JLabel("Titulo");
		springLayout.putConstraint(SpringLayout.NORTH, lbTitulo, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbTitulo, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lbTitulo);
		
		JLabel lbDescripcion = new JLabel("Descripcion");
		springLayout.putConstraint(SpringLayout.NORTH, lbDescripcion, 13, SpringLayout.SOUTH, lbTitulo);
		springLayout.putConstraint(SpringLayout.WEST, lbDescripcion, 0, SpringLayout.WEST, lbTitulo);
		getContentPane().add(lbDescripcion);
		
		tfTitulo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfTitulo, -3, SpringLayout.NORTH, lbTitulo);
		springLayout.putConstraint(SpringLayout.WEST, tfTitulo, 31, SpringLayout.EAST, lbTitulo);
		getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		cbModalidad = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, cbModalidad, -145, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cbModalidad, 0, SpringLayout.EAST, tfTitulo);
		cbModalidad.setModel(new DefaultComboBoxModel(new String[] {"Part-Time", "Full-Time"}));
		getContentPane().add(cbModalidad);
		
		JLabel lbModalidad = new JLabel("Modalidad");
		springLayout.putConstraint(SpringLayout.NORTH, lbModalidad, 3, SpringLayout.NORTH, cbModalidad);
		springLayout.putConstraint(SpringLayout.EAST, lbModalidad, -6, SpringLayout.WEST, cbModalidad);
		getContentPane().add(lbModalidad);
		
		JLabel lbTipo = new JLabel("Tipo");
		springLayout.putConstraint(SpringLayout.NORTH, lbTipo, 3, SpringLayout.NORTH, cbModalidad);
		getContentPane().add(lbTipo);
		
		cbTipo = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, lbTipo, -6, SpringLayout.WEST, cbTipo);
		springLayout.putConstraint(SpringLayout.NORTH, cbTipo, 0, SpringLayout.NORTH, cbModalidad);
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Remoto", "Presencial"}));
		getContentPane().add(cbTipo);
		
		tfSueldo = new JTextField();
		getContentPane().add(tfSueldo);
		tfSueldo.setColumns(10);
		
		JLabel lbSueldo = new JLabel("Sueldo");
		springLayout.putConstraint(SpringLayout.NORTH, tfSueldo, -3, SpringLayout.NORTH, lbSueldo);
		springLayout.putConstraint(SpringLayout.WEST, lbSueldo, 0, SpringLayout.WEST, lbTitulo);
		getContentPane().add(lbSueldo);
		
		JLabel lbRequisitos = new JLabel("Requisitos");
		springLayout.putConstraint(SpringLayout.WEST, lbRequisitos, 196, SpringLayout.EAST, lbDescripcion);
		springLayout.putConstraint(SpringLayout.EAST, cbTipo, 0, SpringLayout.EAST, lbRequisitos);
		springLayout.putConstraint(SpringLayout.NORTH, lbRequisitos, 0, SpringLayout.NORTH, lbDescripcion);
		getContentPane().add(lbRequisitos);
		
		cbCategoria = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cbCategoria, 0, SpringLayout.WEST, cbModalidad);
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {"Ingenieria", "Salud", "Economia", "Legislativa", "Contaduria", "Artes", "Investigacion"}));
		getContentPane().add(cbCategoria);
		
		JLabel lbCategoria = new JLabel("Categoria");
		springLayout.putConstraint(SpringLayout.NORTH, lbSueldo, 23, SpringLayout.SOUTH, lbCategoria);
		springLayout.putConstraint(SpringLayout.NORTH, cbCategoria, -3, SpringLayout.NORTH, lbCategoria);
		springLayout.putConstraint(SpringLayout.WEST, lbCategoria, 0, SpringLayout.WEST, lbTitulo);
		getContentPane().add(lbCategoria);
		
		tARequisitos = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, tARequisitos, 36, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tARequisitos, 6, SpringLayout.EAST, lbRequisitos);
		springLayout.putConstraint(SpringLayout.EAST, tARequisitos, 166, SpringLayout.EAST, lbRequisitos);
		getContentPane().add(tARequisitos);
		
		btnCrear = new JButton("Crear");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCrear, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCrear, 0, SpringLayout.EAST, lbRequisitos);
		btnCrear.addActionListener(this);
		getContentPane().add(btnCrear);
		
		btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.SOUTH, tARequisitos, -152, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 0, SpringLayout.NORTH, btnCrear);
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 0, SpringLayout.WEST, tARequisitos);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
		
		lbLugarTrabajo = new JLabel("Lugar de Trabajo");
		springLayout.putConstraint(SpringLayout.NORTH, lbCategoria, 6, SpringLayout.SOUTH, lbLugarTrabajo);
		springLayout.putConstraint(SpringLayout.NORTH, lbLugarTrabajo, 307, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbLugarTrabajo, 0, SpringLayout.WEST, lbTitulo);
		getContentPane().add(lbLugarTrabajo);
		
		tfLugarTrabajo = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfSueldo, 0, SpringLayout.WEST, tfLugarTrabajo);
		springLayout.putConstraint(SpringLayout.NORTH, tfLugarTrabajo, 304, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tfLugarTrabajo, 2, SpringLayout.EAST, lbLugarTrabajo);
		getContentPane().add(tfLugarTrabajo);
		tfLugarTrabajo.setColumns(10);
		
		listTareas = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listTareas, -1, SpringLayout.NORTH, lbDescripcion);
		springLayout.putConstraint(SpringLayout.WEST, listTareas, 6, SpringLayout.EAST, lbDescripcion);
		listTareas.setModel(new AbstractListModel() {
			String[] values = new String[] {"Analizar", "Desarrollar", "Toma de Datos", "Capacitacion", "Asesorar", "Documentar", "Liquidacion de Nominas"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		getContentPane().add(listTareas);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnCrear))
		{
			try {
				PublicacionVO pub = new PublicacionVO();
				pub.setTitulo(this.tfTitulo.getText());
				
				for (Object itr : this.listTareas.getSelectedValues())
					pub.agregarTareas((String) itr);
				
				String mod = (String) this.cbModalidad.getSelectedItem();
				String tipo = (String) this.cbTipo.getSelectedItem();
				
				if (mod == "Part-Time")
					pub.setModalidad(PublicacionVO.ModalidadContrato.PART_TIME);
				else if (mod == "Full-Time")
					pub.setModalidad(PublicacionVO.ModalidadContrato.FULL_TIME);
				
				if (tipo == "Remoto")
					pub.setTipoTrabajo(PublicacionVO.TipoTrabajo.REMOTO);
				else if (tipo == "Presencial")
					pub.setTipoTrabajo(PublicacionVO.TipoTrabajo.PRESENCIAL);
				
				
				for (String str : this.tARequisitos.getText().split("\n"))
					pub.agregarRequisito(str);
				
				pub.setLugarTrabajo(this.tfLugarTrabajo.getText());
				pub.setCategoria((String) this.cbCategoria.getSelectedItem());
				pub.setSueldo(Float.parseFloat(this.tfSueldo.getText()));
				this.coordinadorPublicaciones.crearPublicacion(pub);
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (arg0.getSource().equals(btnSalir))
		{
			this.dispose();
		}
	}

	public PublicacionController getCoordinadorPublicaciones() {
		return coordinadorPublicaciones;
	}

	public void setCoordinadorPublicaciones(PublicacionController coordinadorPublicaciones) {
		this.coordinadorPublicaciones = coordinadorPublicaciones;
	}
}
