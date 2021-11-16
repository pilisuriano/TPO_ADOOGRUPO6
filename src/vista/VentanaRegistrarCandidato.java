package vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import controlador.CandidatoController;
import modelo.conexion.Conexion;
import modelo.vo.CandidatoVO;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;

public class VentanaRegistrarCandidato extends JFrame implements ActionListener {
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfFechaNac;
	private JTextField tfNacionalidad;
	private JButton btnRegistrar;
	private JButton btnSalir;
	private JList listIntereses;
	private JRadioButton[] rdBtnIdiomas;
	private JTextField tfDNI;

	private CandidatoController coordinadorCandidatos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistrarCandidato frame = new VentanaRegistrarCandidato();
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
	public VentanaRegistrarCandidato() {
		setBounds(100, 100, 521, 300);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbNombre = new JLabel("Nombre");
		springLayout.putConstraint(SpringLayout.NORTH, lbNombre, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbNombre, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lbNombre);
		
		JLabel lbApellido = new JLabel("Apellido");
		springLayout.putConstraint(SpringLayout.NORTH, lbApellido, 7, SpringLayout.SOUTH, lbNombre);
		springLayout.putConstraint(SpringLayout.WEST, lbApellido, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(lbApellido);
		
		JLabel lbFechaNac = new JLabel("Fecha Nacimiento (Dia/Mes/Anio)");
		springLayout.putConstraint(SpringLayout.NORTH, lbFechaNac, 6, SpringLayout.SOUTH, lbApellido);
		springLayout.putConstraint(SpringLayout.WEST, lbFechaNac, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(lbFechaNac);
		
		JLabel lbNacionalidad = new JLabel("Nacionalidad");
		springLayout.putConstraint(SpringLayout.NORTH, lbNacionalidad, 25, SpringLayout.SOUTH, lbApellido);
		springLayout.putConstraint(SpringLayout.WEST, lbNacionalidad, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(lbNacionalidad);
		
		JLabel lbIdiomas = new JLabel("Idiomas");
		springLayout.putConstraint(SpringLayout.NORTH, lbIdiomas, 6, SpringLayout.SOUTH, lbNacionalidad);
		springLayout.putConstraint(SpringLayout.WEST, lbIdiomas, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(lbIdiomas);
		
		rdBtnIdiomas = new JRadioButton[4];
		
		JRadioButton rBtnEspanol = new JRadioButton("Espa\u00F1ol");
		rdBtnIdiomas[0] = rBtnEspanol;
		springLayout.putConstraint(SpringLayout.NORTH, rBtnEspanol, 9, SpringLayout.SOUTH, lbIdiomas);
		springLayout.putConstraint(SpringLayout.WEST, rBtnEspanol, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(rBtnEspanol);
		
		JRadioButton rdBtnAleman = new JRadioButton("Aleman");
		rdBtnIdiomas[1] = rdBtnAleman;
		springLayout.putConstraint(SpringLayout.NORTH, rdBtnAleman, 6, SpringLayout.SOUTH, rBtnEspanol);
		springLayout.putConstraint(SpringLayout.WEST, rdBtnAleman, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(rdBtnAleman);
		
		JRadioButton rBtnFrances = new JRadioButton("Frances");
		rdBtnIdiomas[2] = rBtnFrances;
		springLayout.putConstraint(SpringLayout.WEST, rBtnFrances, 8, SpringLayout.EAST, rdBtnAleman);
		getContentPane().add(rBtnFrances);
		
		JRadioButton rBtnIngles = new JRadioButton("Ingles");
		rdBtnIdiomas[3] = rBtnIngles;
		springLayout.putConstraint(SpringLayout.NORTH, rBtnFrances, 6, SpringLayout.SOUTH, rBtnIngles);
		springLayout.putConstraint(SpringLayout.NORTH, rBtnIngles, 0, SpringLayout.NORTH, rBtnEspanol);
		springLayout.putConstraint(SpringLayout.WEST, rBtnIngles, 6, SpringLayout.EAST, rBtnEspanol);
		getContentPane().add(rBtnIngles);
		
		tfNombre = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfNombre, -3, SpringLayout.NORTH, lbNombre);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, tfNombre, 0, SpringLayout.EAST, tfApellido);
		springLayout.putConstraint(SpringLayout.NORTH, tfApellido, -3, SpringLayout.NORTH, lbApellido);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		tfFechaNac = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfFechaNac, 3, SpringLayout.SOUTH, tfApellido);
		springLayout.putConstraint(SpringLayout.WEST, tfFechaNac, 6, SpringLayout.EAST, lbFechaNac);
		springLayout.putConstraint(SpringLayout.EAST, tfApellido, 0, SpringLayout.EAST, tfFechaNac);
		getContentPane().add(tfFechaNac);
		tfFechaNac.setColumns(10);
		
		tfNacionalidad = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfNacionalidad, 0, SpringLayout.SOUTH, tfFechaNac);
		springLayout.putConstraint(SpringLayout.EAST, tfNacionalidad, 0, SpringLayout.EAST, tfFechaNac);
		getContentPane().add(tfNacionalidad);
		tfNacionalidad.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistrar, -10, SpringLayout.SOUTH, getContentPane());
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.EAST, btnRegistrar, -6, SpringLayout.WEST, btnSalir);
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 0, SpringLayout.NORTH, btnRegistrar);
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 0, SpringLayout.WEST, tfNombre);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
		
		listIntereses = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listIntereses, -1, SpringLayout.NORTH, lbApellido);
		springLayout.putConstraint(SpringLayout.EAST, listIntereses, -31, SpringLayout.EAST, getContentPane());
		listIntereses.setModel(new AbstractListModel() {
			String[] values = new String[] {"Ingenieria", "Salud", "Economia", "Legislativa", "Contaduria", "Artes", "Investigacion"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		getContentPane().add(listIntereses);
		
		JLabel lbIntereses = new JLabel("Intereses");
		springLayout.putConstraint(SpringLayout.NORTH, lbIntereses, 0, SpringLayout.NORTH, lbNombre);
		springLayout.putConstraint(SpringLayout.WEST, lbIntereses, 0, SpringLayout.WEST, listIntereses);
		getContentPane().add(lbIntereses);
		
		JLabel lbDNI = new JLabel("DNI");
		springLayout.putConstraint(SpringLayout.WEST, lbDNI, 0, SpringLayout.WEST, lbNombre);
		getContentPane().add(lbDNI);
		
		tfDNI = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfDNI, 10, SpringLayout.SOUTH, rBtnFrances);
		springLayout.putConstraint(SpringLayout.NORTH, lbDNI, 3, SpringLayout.NORTH, tfDNI);
		springLayout.putConstraint(SpringLayout.WEST, tfDNI, 0, SpringLayout.WEST, tfNombre);
		getContentPane().add(tfDNI);
		tfDNI.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(this.btnRegistrar))
		{	
			Conexion con = new Conexion();
			try {
				CandidatoVO cand = new CandidatoVO();
				cand.setNombre(this.tfNombre.getText());
				cand.setApellido(this.tfApellido.getText());
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(this.tfFechaNac.getText());
			    System.out.println();
				
				cand.agregarNacionalidad(this.tfNacionalidad.getText());
				cand.setDNI(Integer.parseInt(this.tfDNI.getText()));
				
				for (JRadioButton btn : this.rdBtnIdiomas)
				{
					if (btn.isSelected())
						cand.agregarIdioma(btn.getText());
				}
				
				for (Object itr : this.listIntereses.getSelectedValues())
					cand.agregarInteres((String) itr);
				
				coordinadorCandidatos.registrarCandidato(cand);
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (arg0.getSource().equals(btnSalir))
		{
			System.out.println("SALRI");
			this.dispose();
		}
	}

	public void setCandidatoController(CandidatoController cand)
	{
		this.coordinadorCandidatos = cand;
	}
}
