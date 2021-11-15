package modelo;

import java.util.ArrayList;
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
	
	public List<PublicacionVO> getPublicacioneRemotasYPartTime()
	{
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicacionesRemotasYPartTime();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public List<PublicacionVO> getPublicacionesActivas() {
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicacionesActivas();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
	
	public void registrarPublicacion(PublicacionVO pub)
	{
		PublicacionDAO pubDAO;
		
		try {				
			pubDAO = new PublicacionDAO();
			pubDAO.registrarPublicacion(pub);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<PostulacionVO> getPostulaciones(PublicacionVO pub) {
		PublicacionDAO pubDAO;
		try {				
			pubDAO = new PublicacionDAO();
			return pubDAO.getPostulaciones(pub);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
