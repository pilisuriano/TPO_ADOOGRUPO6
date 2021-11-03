package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.*;

public class PublicacionDAO {
	public List<PublicacionVO> getPublicaciones() {
		Conexion conex= new Conexion();
		List<PublicacionVO> publicaciones= new ArrayList<PublicacionVO>();		
		List<PostulacionVO> postulaciones= new ArrayList<PostulacionVO>();

		try {			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				int i = indexOfArray(publicaciones, res.getString("titulo"));
				
				if(i == -1) {
					PublicacionVO publicacion= new PublicacionVO();
					publicacion.setTitulo(res.getString("titulo"));
					publicacion.setSueldo(Double.parseDouble(res.getString("sueldo")));	
					postulaciones= new ArrayList<PostulacionVO>();
					
					PostulacionVO pos = new PostulacionVO();
					pos.setMes(Integer.parseInt(res.getString("mes")));
					pos.setAnio(Integer.parseInt(res.getString("anio")));
					
					CandidatoVO cand = new CandidatoVO();
					cand.setNombre(res.getString("nombre"));
					cand.setApellido(res.getString("apellido"));
					cand.setDNI(Integer.parseInt(res.getString("DNI")));
					pos.setCandidato(cand);				
					postulaciones.add(pos);
					
					publicacion.setPostulaciones(postulaciones);
					publicaciones.add(publicacion);
				}
				else {
					PublicacionVO publicacion = publicaciones.get(i);
					PostulacionVO pos = new PostulacionVO();
					pos.setMes(Integer.parseInt(res.getString("mes")));
					pos.setAnio(Integer.parseInt(res.getString("anio")));
					
					CandidatoVO cand = new CandidatoVO();
					cand.setNombre(res.getString("nombre"));
					cand.setApellido(res.getString("apellido"));
					cand.setDNI(Integer.parseInt(res.getString("DNI")));
					pos.setCandidato(cand);
					publicacion.getPostulaciones().add(pos);
					publicaciones.set(i, publicacion);
				}				
			}
			res.close();
			conex.desconectar();				
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return publicaciones;
	}
	
	private int indexOfArray(List<PublicacionVO> publicaciones, String job) {
		int index = -1;
		for(int i = 0; i< publicaciones.size(); i++) {
			if(job.equals(publicaciones.get(i).getTitulo()))
					index = i;
		}
		return index;
	}
}
