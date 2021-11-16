package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ReporteController;
import modelo.vo.ReporteVO;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class VentanaReporte extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ReporteController miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador	
	private JTextField txtMes;
	private JTextField txtAnio;
	private JButton btnNewButton;
	private JTextArea tATopMCategorias;
	private JTextField tfMCategorias;
	private JLabel lbResultadoOfertaMasAccesible;
	private JLabel lbResultadoOfertaMasExigente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReporte frame = new VentanaReporte();
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
	public VentanaReporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte Oferta Laboral con mayor postulaciones");
		lblNewLabel.setBounds(10, 34, 226, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mes");
		lblNewLabel_1.setBounds(30, 74, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Año");
		lblNewLabel_2.setBounds(30, 122, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		txtMes = new JTextField();
		txtMes.setBounds(103, 60, 130, 44);
		contentPane.add(txtMes);
		txtMes.setColumns(10);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(103, 108, 130, 44);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
				
		JLabel lblNewLabel_3 = new JLabel("Oferta:");
		lblNewLabel_3.setBounds(30, 248, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Postulantes:");
		lblNewLabel_4.setBounds(30, 274, 90, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblOfertaTitle = new JLabel("");
		lblOfertaTitle.setBounds(172, 248, 344, 16);
		contentPane.add(lblOfertaTitle);
		
		JLabel lblPostulantes = new JLabel("");
		lblPostulantes.setBounds(172, 274, 344, 16);
		contentPane.add(lblPostulantes);
		
		btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 365, 117, 29);
		contentPane.add(btnNewButton);		
		
		JLabel lbOfertaMCategorias = new JLabel("Reporte Primeras M Categorias Seleccionadas");
		lbOfertaMCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		lbOfertaMCategorias.setBounds(286, 31, 220, 22);
		contentPane.add(lbOfertaMCategorias);
		
		tATopMCategorias = new JTextArea();
		tATopMCategorias.setBounds(288, 90, 218, 136);
		contentPane.add(tATopMCategorias);
		
		JLabel lbMValue = new JLabel("Valor de M:");
		lbMValue.setBounds(288, 60, 61, 13);
		contentPane.add(lbMValue);
		
		tfMCategorias = new JTextField();
		tfMCategorias.setBounds(364, 60, 96, 19);
		contentPane.add(tfMCategorias);
		tfMCategorias.setColumns(10);
		
		JLabel lbOfertaMasAccesible = new JLabel("Oferta Mas Accessible");
		lbOfertaMasAccesible.setHorizontalAlignment(SwingConstants.LEFT);
		lbOfertaMasAccesible.setBounds(30, 305, 155, 13);
		contentPane.add(lbOfertaMasAccesible);
		
		JLabel lbOfertaMasExigente = new JLabel("Oferta Mas Exigente:");
		lbOfertaMasExigente.setHorizontalAlignment(SwingConstants.LEFT);
		lbOfertaMasExigente.setBounds(30, 327, 155, 13);
		contentPane.add(lbOfertaMasExigente);
		
		lbResultadoOfertaMasAccesible = new JLabel("");
		lbResultadoOfertaMasAccesible.setBounds(172, 305, 344, 13);
		contentPane.add(lbResultadoOfertaMasAccesible);
		
		lbResultadoOfertaMasExigente = new JLabel("");
		lbResultadoOfertaMasExigente.setBounds(172, 328, 344, 13);
		contentPane.add(lbResultadoOfertaMasExigente);
	}
	
	public void setCoordinador(ReporteController miCoordinador) {
		System.out.println("contro: " + miCoordinador.toString());
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(btnNewButton))
		{
			this.tATopMCategorias.setText("");
			this.lbResultadoOfertaMasAccesible.setText("");
			this.lbResultadoOfertaMasExigente.setText("");
			
			/* Top M Categorias vistas*/
			String mValue = this.tfMCategorias.getText();
			List<String> topMCategorias = null;
			
			try
			{
				if (mValue.isEmpty())
				{
					// Por defecto obtengo las primeras 5
					topMCategorias = this.miCoordinador.getTopMCategoriasSeleccionadasPublicaciones(5);
				}
				else
					topMCategorias = this.miCoordinador.getTopMCategoriasSeleccionadasPublicaciones(Integer.parseInt(mValue));
				
				for (String cat : topMCategorias)
					this.tATopMCategorias.append(cat + "\n");
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			/* Oferta Mas Accessible
			 */
			ReporteVO mejorTrabajo = this.miCoordinador.getOfertaMasAccesible();
			this.lbResultadoOfertaMasAccesible.setText(mejorTrabajo.getTitulo_oferta());
			
			/*
			 * Oferta Mas Exigente
			 */
			
			ReporteVO masExigente = this.miCoordinador.getOfertaMasExigente();
			this.lbResultadoOfertaMasExigente.setText(masExigente.getTitulo_oferta());	
		}
	}
}
