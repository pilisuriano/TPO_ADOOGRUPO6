package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class VentanaVerPublicaciones extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lbPublicaciones = new JLabel("Publicaciones");
		springLayout.putConstraint(SpringLayout.NORTH, lbPublicaciones, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lbPublicaciones, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lbPublicaciones);
		
		JList listPublicaciones = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, listPublicaciones, 17, SpringLayout.SOUTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, listPublicaciones, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, listPublicaciones, 217, SpringLayout.SOUTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.EAST, listPublicaciones, 0, SpringLayout.EAST, lbPublicaciones);
		listPublicaciones.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pub1", "Pub2", "Pub3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listPublicaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(listPublicaciones);
		
		JTextArea tADetallesPub = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, tADetallesPub, -31, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(tADetallesPub);
		
		JLabel lbDetallesPublicacion = new JLabel("Detalles de Publicaci\u00F3n");
		springLayout.putConstraint(SpringLayout.NORTH, tADetallesPub, 17, SpringLayout.SOUTH, lbDetallesPublicacion);
		springLayout.putConstraint(SpringLayout.NORTH, lbDetallesPublicacion, 0, SpringLayout.NORTH, lbPublicaciones);
		springLayout.putConstraint(SpringLayout.WEST, lbDetallesPublicacion, 0, SpringLayout.WEST, tADetallesPub);
		getContentPane().add(lbDetallesPublicacion);
		
		JButton btnPostularse = new JButton("Postularse");
		springLayout.putConstraint(SpringLayout.WEST, btnPostularse, 269, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnPostularse, -31, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tADetallesPub, -6, SpringLayout.WEST, btnPostularse);
		getContentPane().add(btnPostularse);
		
		JButton btnNewButton_1 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.WEST, tADetallesPub, 25, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnPostularse);
		getContentPane().add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Salir");
		springLayout.putConstraint(SpringLayout.NORTH, btnSalir, 0, SpringLayout.NORTH, btnPostularse);
		springLayout.putConstraint(SpringLayout.WEST, btnSalir, 6, SpringLayout.EAST, btnPostularse);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnSalir);
		
		JButton btnAgregarCV = new JButton("Agregar CV");
		springLayout.putConstraint(SpringLayout.WEST, btnAgregarCV, 42, SpringLayout.EAST, tADetallesPub);
		getContentPane().add(btnAgregarCV);
		
		JLabel lbRenumeracion = new JLabel("Renumeracion");
		springLayout.putConstraint(SpringLayout.NORTH, lbRenumeracion, 1, SpringLayout.NORTH, listPublicaciones);
		getContentPane().add(lbRenumeracion);
		
		JFormattedTextField tfRenumeracion = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfRenumeracion, 341, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tfRenumeracion, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lbRenumeracion, -6, SpringLayout.WEST, tfRenumeracion);
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregarCV, 6, SpringLayout.SOUTH, tfRenumeracion);
		springLayout.putConstraint(SpringLayout.NORTH, tfRenumeracion, 40, SpringLayout.NORTH, getContentPane());
		getContentPane().add(tfRenumeracion);

	}
}
