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

public class VentanaVerPublicaciones extends JFrame implements ActionListener, ListSelectionListener {

	private PublicacionController coordPublicaciones;
	private CandidatoController coordCandidatos;
	
	private JList listPublicaciones;
	private JButton btnPostularse;
	private JButton btnSalir;
	
	private HashMap<Integer, PublicacionVO> pubMap;
	private JTextArea tADetallesPub;
	private JButton btnFavoritos;
	private JTextField tfRenumeracion;
	
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
	public VentanaVerPublicaciones() {
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
		
		tADetallesPub = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, tADetallesPub, 0, SpringLayout.NORTH, listPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, tADetallesPub, 7, SpringLayout.EAST, listPublicaciones);
		springLayout.putConstraint(SpringLayout.SOUTH, tADetallesPub, -23, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(tADetallesPub);
		
		JLabel lbDetallesPublicacion = new JLabel("Detalles de Publicaci\u00F3n");
		springLayout.putConstraint(SpringLayout.WEST, lbDetallesPublicacion, 39, SpringLayout.EAST, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.NORTH, lbDetallesPublicacion, 0, SpringLayout.NORTH, lbPublicaciones);
		getContentPane().add(lbDetallesPublicacion);
		
		btnPostularse = new JButton("Postularse");
		btnPostularse.addActionListener(this);
		getContentPane().add(btnPostularse);
		
		btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -31, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnPostularse, 0, SpringLayout.NORTH, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnPostularse, -6, SpringLayout.WEST, btnSalir);
		springLayout.putConstraint(SpringLayout.EAST, btnSalir, -70, SpringLayout.EAST, getContentPane());
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
		
		JButton btnAgregarCV = new JButton("Agregar CV");
		springLayout.putConstraint(SpringLayout.WEST, btnAgregarCV, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tADetallesPub, -26, SpringLayout.WEST, btnAgregarCV);
		getContentPane().add(btnAgregarCV);
		
		JLabel lbRenumeracion = new JLabel("Renumeracion");
		springLayout.putConstraint(SpringLayout.NORTH, lbRenumeracion, 41, SpringLayout.NORTH, getContentPane());
		getContentPane().add(lbRenumeracion);
		
		tfRenumeracion = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfRenumeracion, 341, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tfRenumeracion, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbRenumeracion, -6, SpringLayout.WEST, tfRenumeracion);
		springLayout.putConstraint(SpringLayout.NORTH, tfRenumeracion, 40, SpringLayout.NORTH, getContentPane());
		getContentPane().add(tfRenumeracion);
		
		btnFavoritos = new JButton("Marcar Favorita");
		springLayout.putConstraint(SpringLayout.NORTH, btnFavoritos, 107, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnFavoritos, 26, SpringLayout.EAST, tADetallesPub);
		springLayout.putConstraint(SpringLayout.SOUTH, btnFavoritos, -187, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnFavoritos, -215, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAgregarCV, -6, SpringLayout.NORTH, btnFavoritos);
		getContentPane().add(btnFavoritos);
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
		
		this.tADetallesPub.setText("");
		
		this.tADetallesPub.append("Tareas: " + "\n" + tareas);
		this.tADetallesPub.append("\n\nSalario: " + pub.getSueldo());
		this.tADetallesPub.append("\nModalidad: " + pub.getModalidadStr());
		this.tADetallesPub.append("\nTipo: " + pub.getTipoTrabajoStr());
		this.tADetallesPub.append("\n\nRequisitos:\n\n" + requisitos);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnPostularse))
		{
			try
			{
				int i = this.listPublicaciones.getSelectedIndex();
				PublicacionVO pub = this.pubMap.get(i);
				PostulacionVO post = new PostulacionVO();
				
				LocalDateTime date = LocalDateTime.now();
				float renum = Float.parseFloat(this.tfRenumeracion.getText());
				post.setRenumeracion(renum);
				post.setDia(date.getDayOfMonth());
				post.setMes(date.getMonthValue());
				post.setAnio(date.getYear());
				
				CandidatoVO cFijo = this.coordCandidatos.buscarCandidato(1000);
				
				post.setCandidato(cFijo);
				
				this.coordPublicaciones.registrarPostulacion(pub, post);
				SistemaNotificador.getInstancia().notificarPostulacion(post, pub);
			
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

	public void setCoordCandidatos(CandidatoController coordCandidatos) {
		this.coordCandidatos = coordCandidatos;
	}
}
