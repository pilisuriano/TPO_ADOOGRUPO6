package vista;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;

import controlador.PublicacionController;
import modelo.vo.PublicacionVO;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaVerPostulantes extends JFrame {

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
		getContentPane().add(listPublicaciones);
		
		JList listPostulantes = new JList();
		springLayout.putConstraint(SpringLayout.WEST, listPostulantes, 6, SpringLayout.EAST, listPublicaciones);
		springLayout.putConstraint(SpringLayout.SOUTH, listPostulantes, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, listPostulantes, -226, SpringLayout.EAST, getContentPane());
		listPostulantes.setModel(new AbstractListModel() {
			String[] values = new String[] {"Post1", "Post2", "Post3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		getContentPane().add(listPostulantes);
		
		JLabel lbPostulantes = new JLabel("Postulantes");
		springLayout.putConstraint(SpringLayout.WEST, lbPostulantes, 43, SpringLayout.EAST, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.NORTH, listPostulantes, 6, SpringLayout.SOUTH, lbPostulantes);
		springLayout.putConstraint(SpringLayout.NORTH, lbPostulantes, 0, SpringLayout.NORTH, lbPublicaciones);
		getContentPane().add(lbPostulantes);
		
		JTextArea tAInformacionPostulante = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, tAInformacionPostulante, 36, SpringLayout.EAST, listPostulantes);
		springLayout.putConstraint(SpringLayout.SOUTH, tAInformacionPostulante, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tAInformacionPostulante, -30, SpringLayout.EAST, getContentPane());
		getContentPane().add(tAInformacionPostulante);
		
		JLabel lbDetallesPostulante = new JLabel("Informacion del Postulante");
		springLayout.putConstraint(SpringLayout.WEST, lbDetallesPostulante, 82, SpringLayout.EAST, lbPostulantes);
		springLayout.putConstraint(SpringLayout.NORTH, tAInformacionPostulante, 6, SpringLayout.SOUTH, lbDetallesPostulante);
		springLayout.putConstraint(SpringLayout.NORTH, lbDetallesPostulante, 0, SpringLayout.NORTH, lbPublicaciones);
		getContentPane().add(lbDetallesPostulante);
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 185, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, getContentPane());
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
}
