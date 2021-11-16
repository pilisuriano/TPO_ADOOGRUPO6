package vista;

import java.awt.EventQueue;

import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.CandidatoController;
import controlador.PublicacionController;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import patrones.FormatoExportar;
import patrones.SistemaNotificador;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaExportarImagenes extends JFrame implements ActionListener, ListSelectionListener {

	private PublicacionController coordPublicaciones;
	
	private JList listPublicaciones;
	private JButton btnExportar;
	private JButton btnSalir;
	
	private HashMap<Integer, PublicacionVO> pubMap;

	private JComboBox cbFormatoExportar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerPublicaciones frame = new VentanaVerPublicaciones();
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
	public VentanaExportarImagenes() {
		pubMap = new HashMap<Integer, PublicacionVO>();
		setBounds(100, 100, 602, 352);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbPublicaciones = new JLabel("Publicaciones");
		springLayout.putConstraint(SpringLayout.NORTH, lbPublicaciones, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbPublicaciones, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lbPublicaciones);
		
		listPublicaciones = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listPublicaciones, 17, SpringLayout.SOUTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, listPublicaciones, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listPublicaciones, 217, SpringLayout.SOUTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.EAST, listPublicaciones, 12, SpringLayout.EAST, lbPublicaciones);
		listPublicaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPublicaciones.addListSelectionListener(this);
		getContentPane().add(listPublicaciones);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		getContentPane().add(btnExportar);
		
		btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -31, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnExportar, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnExportar, -6, SpringLayout.WEST, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, -70, SpringLayout.EAST, getContentPane());
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
		
		cbFormatoExportar = new JComboBox();
		cbFormatoExportar.setModel(new DefaultComboBoxModel(FormatoExportar.values()));
		springLayout.putConstraint(SpringLayout.NORTH, cbFormatoExportar, 0, SpringLayout.NORTH, listPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, cbFormatoExportar, 47, SpringLayout.EAST, listPublicaciones);
		getContentPane().add(cbFormatoExportar);
	}
	
	public void llenarDatosPublicaciones()
	{
		List<PublicacionVO> pubs = this.coordPublicaciones.getPublicacionesActivas();
		DefaultListModel<String> titulosPubs = new DefaultListModel<String>();
		
		this.pubMap.clear();
		
		int i = 0;
		for (PublicacionVO itr : pubs)
		{
			this.pubMap.put(i, itr);
			i++;
			titulosPubs.addElement(itr.getTitulo());
		}
		
		this.listPublicaciones.setModel(titulosPubs);
	}

	public PublicacionController getCoordPublicaciones() {
		return coordPublicaciones;
	}

	public void setCoordPublicaciones(PublicacionController coordPublicaciones) {
		this.coordPublicaciones = coordPublicaciones;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		// TODO Auto-generated method stub
		int i = arg0.getLastIndex();
		PublicacionVO pub = this.pubMap.get(i);
		
		String requisitos = String.join("\n", pub.getRequisitos());
		String tareas = String.join("\n", pub.getTareas());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnExportar))
		{
			try
			{
				int i = this.listPublicaciones.getSelectedIndex();
				PublicacionVO pub = this.pubMap.get(i);
				
				this.cbFormatoExportar.getSelectedItem();
				String format = this.cbFormatoExportar.getSelectedItem().toString();
				FormatoExportar formato = FormatoExportar.PNG;
				
				if (format == "JPG")
					formato = FormatoExportar.JPG;
				else if (format == "PNG")
					formato = FormatoExportar.PNG;
				else if (format == "SVG")
					formato = FormatoExportar.SVG;
				
				this.coordPublicaciones.exportarImagen(pub, formato);
				JOptionPane.showMessageDialog(null, "Imagen exportada correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
			
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if (arg0.getSource().equals(btnSalir))
		{
			System.out.println("Salir");
			this.dispose();
		}
	}
}
