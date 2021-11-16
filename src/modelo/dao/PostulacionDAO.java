package modelo.dao;

import javax.swing.JOptionPane;

import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;

public class PostulacionDAO 
{
	public void registrarPostulacion(PublicacionVO pub, PostulacionVO postu) 
	{
		JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente la postulacion","Informacion",JOptionPane.INFORMATION_MESSAGE);
		// Falta obtener el id de la publicacion para vincularlo en la DB como clave foranea
		/*Conexion conex = new Conexion();
		
		try {
			String query = "INSERT INTO `PubliPostu` VALUES "
					+ "(?, ?, ?);";
			
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			
			Date date = new Date(postu.getDia(), postu.getMes(), postu.getAnio());
			statement.setDate(1, date);
			
			statement.setInt(3, postu.getCandidato().getDNI());
			
			statement.execute();
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente al candidato","Informacion",JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
		return;*/
	}
}
