package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.PublicacionController;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaVerPostulantes extends JFrame implements ListSelectionListener, ActionListener {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerPostulantes frame = new VentanaVerPostulantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JList<String> listPublicaciones;
	private PublicacionController coordPublicaciones;
	private List<PublicacionVO> publicaciones;
	private JList listPostulantes;
	private CandidatoVO candActual;
	private JTextArea tAInformacionPostulante;
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public VentanaVerPostulantes() {
		setBounds(100, 100, 450, 460);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbPublicaciones = new JLabel("Publicaciones");
		springLayout.putConstraint(SpringLayout.WEST, lbPublicaciones, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbPublicaciones, -381, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lbPublicaciones);
		
		listPublicaciones = new JList<String>();
		springLayout.putConstraint(SpringLayout.NORTH, listPublicaciones, 6, SpringLayout.SOUTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, listPublicaciones, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listPublicaciones, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listPublicaciones, -330, SpringLayout.EAST, getContentPane());
		listPublicaciones.addListSelectionListener(this);
		getContentPane().add(listPublicaciones);
		
		listPostulantes = new JList();
		springLayout.putConstraint(SpringLayout.WEST, listPostulantes, 6, SpringLayout.EAST, listPublicaciones);
		springLayout.putConstraint(SpringLayout.SOUTH, listPostulantes, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listPostulantes, -226, SpringLayout.EAST, getContentPane());
		listPostulantes.addListSelectionListener(this);
		getContentPane().add(listPostulantes);
		
		JLabel lbPostulantes = new JLabel("Postulantes");
		springLayout.putConstraint(SpringLayout.WEST, lbPostulantes, 43, SpringLayout.EAST, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.NORTH, listPostulantes, 6, SpringLayout.SOUTH, lbPostulantes);
		springLayout.putConstraint(SpringLayout.NORTH, lbPostulantes, 0, SpringLayout.NORTH, lbPublicaciones);
		getContentPane().add(lbPostulantes);
		
		tAInformacionPostulante = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, tAInformacionPostulante, 36, SpringLayout.EAST, listPostulantes);
		springLayout.putConstraint(SpringLayout.SOUTH, tAInformacionPostulante, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tAInformacionPostulante, -30, SpringLayout.EAST, getContentPane());
		getContentPane().add(tAInformacionPostulante);
		
		JLabel lbDetallesPostulante = new JLabel("Informacion del Postulante");
		springLayout.putConstraint(SpringLayout.WEST, lbDetallesPostulante, 82, SpringLayout.EAST, lbPostulantes);
		springLayout.putConstraint(SpringLayout.NORTH, tAInformacionPostulante, 6, SpringLayout.SOUTH, lbDetallesPostulante);
		springLayout.putConstraint(SpringLayout.NORTH, lbDetallesPostulante, 0, SpringLayout.NORTH, lbPublicaciones);
		getContentPane().add(lbDetallesPostulante);
		
		btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 185, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, getContentPane());
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);

	}
	
	public void agregarInfoPublicaciones(List<PublicacionVO> pubs)
	{
		DefaultListModel<String> titulosPubs = new DefaultListModel<>(); 
		
		for (PublicacionVO itr : pubs)
		{
			titulosPubs.addElement(itr.getTitulo());
		}
		
		this.listPublicaciones.setModel(titulosPubs);
	}

	public void setCoordinadorPublicaciones(PublicacionController publicacionController) {
		// TODO Auto-generated method stub
		this.coordPublicaciones = publicacionController;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		if (arg0.getSource().equals(listPublicaciones))
		{
			// TODO Auto-generated method stub
			int idx = this.listPublicaciones.getSelectedIndex();
			PublicacionVO pub = publicaciones.get(idx);
			DefaultListModel<String> titulosPostulantes = new DefaultListModel<>(); 
			
			for (PostulacionVO itr : pub.getPostulaciones())
			{
				candActual = itr.getCandidato();
				String nombreCand = candActual.getNombre() + " " + candActual.getApellido();
				titulosPostulantes.addElement(nombreCand);
			}
			
			this.listPostulantes.setModel(titulosPostulantes);
		}
		else if (arg0.getSource().equals(listPostulantes))
		{
			this.tAInformacionPostulante.setText(candActual.getInfoCandidato());
		}
	}

	public void llenarDatos() {
		// TODO Auto-generated method stub
		publicaciones = this.coordPublicaciones.getPublicacionesActivas();
		
		DefaultListModel<String> titulosPubs = new DefaultListModel<>(); 
		
		for (PublicacionVO itr : publicaciones)
		{
			titulosPubs.addElement(itr.getTitulo());
		}
		
		this.listPublicaciones.setModel(titulosPubs);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnSalir))
			this.dispose();
	}
}
