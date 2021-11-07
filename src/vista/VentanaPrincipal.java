package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CandidatoController;
import controlador.PublicacionController;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRegistrarPostulante;
	private JButton btnVerPublicaciones;
	private JButton btnVerPostulantes;
	private JButton btnCrearPublicacion;
	
	private CandidatoController candCoordinador;
	private PublicacionController pubCoordinador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		btnVerPostulantes = new JButton("Ver Postulantes");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVerPostulantes, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVerPostulantes, -138, SpringLayout.SOUTH, contentPane);
		btnVerPostulantes.addActionListener(this);
		contentPane.add(btnVerPostulantes);
		
		btnVerPublicaciones = new JButton("Ver Publicaciones");
		btnVerPublicaciones.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVerPublicaciones, 26, SpringLayout.SOUTH, btnVerPostulantes);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVerPublicaciones, 0, SpringLayout.WEST, btnVerPostulantes);
		contentPane.add(btnVerPublicaciones);
		
		btnRegistrarPostulante = new JButton("Registrar Postulante");
		btnRegistrarPostulante.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRegistrarPostulante, 0, SpringLayout.NORTH, btnVerPublicaciones);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRegistrarPostulante, 4, SpringLayout.EAST, btnVerPublicaciones);
		contentPane.add(btnRegistrarPostulante);
		
		btnCrearPublicacion = new JButton("Crear Publicacion");
		btnCrearPublicacion.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCrearPublicacion, 0, SpringLayout.NORTH, btnVerPostulantes);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCrearPublicacion, 6, SpringLayout.EAST, btnVerPostulantes);
		contentPane.add(btnCrearPublicacion);
		
		JLabel lbOpcionesEmpresa = new JLabel("Opciones Empresa");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbOpcionesEmpresa, 0, SpringLayout.WEST, btnVerPostulantes);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbOpcionesEmpresa, -6, SpringLayout.NORTH, btnVerPostulantes);
		contentPane.add(lbOpcionesEmpresa);
		
		JLabel lbOpcionesPostulante = new JLabel("Opciones Postulante");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbOpcionesPostulante, 6, SpringLayout.SOUTH, btnVerPostulantes);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbOpcionesPostulante, 0, SpringLayout.WEST, btnVerPostulantes);
		contentPane.add(lbOpcionesPostulante);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		Object src = arg0.getSource();
		
		if (src.equals(this.btnCrearPublicacion))
			this.pubCoordinador.mostrarVentanaCrearPublicacion();
		else if (src.equals(this.btnVerPostulantes))
			this.pubCoordinador.mostrarVentanaVerPostulantes();
		else if (src.equals(this.btnRegistrarPostulante))
			this.candCoordinador.mostrarVentanaRegistroPostulante();
	}
	
	public void setCandidatoController(CandidatoController c)
	{
		this.candCoordinador = c;
	}
	
	public void setPublicacionesController(PublicacionController c)
	{
		this.pubCoordinador = c;
	}
}
