package modelo;

import java.util.List;

import javax.swing.JOptionPane;

import modelo.dao.PublicacionDAO;
import modelo.vo.*;

public class Publicacion {

	public List<PublicacionVO> getPublicaciones() {
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicaciones();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
}
