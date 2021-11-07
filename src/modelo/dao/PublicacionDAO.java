package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.*;

public class PublicacionDAO 
{
	
	public List<PublicacionVO> getPublicaciones() {
		Conexion conex= new Conexion();
		List<PublicacionVO> publicaciones= new ArrayList<PublicacionVO>();		
		List<PostulacionVO> postulaciones= new ArrayList<PostulacionVO>();

		try {	
			String query = "SELECT * FROM publicacion;";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = statement.executeQuery();
			while(res.next()){
				int i = indexOfArray(publicaciones, res.getString("titulo"));
				
				if(i == -1) {
					PublicacionVO publicacion= new PublicacionVO();
					publicacion.setTitulo(res.getString("titulo"));
					publicacion.setSueldo(Float.parseFloat(res.getString("sueldo")));
					publicacion.setDescripcion(res.getString("descripcion"));
					
					String mod = res.getString("modalidadContrato");
					
					if (mod == "Part-Time")
						publicacion.setModalidad(PublicacionVO.ModalidadContrato.PART_TIME);
					else if (mod == "Full-Time")
						publicacion.setModalidad(PublicacionVO.ModalidadContrato.FULL_TIME);
					
					String tipo = res.getString("tipoDeTrabajo");
					
					if (tipo == "Remoto")
						publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.REMOTO);
					else if (tipo == "Presencial")
						publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.PRESENCIAL);
					
					
					String[] requisitos = res.getString("requisitos").split(",");
					
					publicacion.setCategoria(res.getString("categoria"));
					
					for (String str : requisitos)
						publicacion.agregarRequisito(str);
					
					publicacion.setActiva(res.getBoolean("activa"));
					publicaciones.add(publicacion);
					
					/*postulaciones= new ArrayList<PostulacionVO>();
					
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
					publicaciones.add(publicacion);*/
				}
				else {
					/*PublicacionVO publicacion = publicaciones.get(i);
					PostulacionVO pos = new PostulacionVO();
					pos.setMes(Integer.parseInt(res.getString("mes")));
					pos.setAnio(Integer.parseInt(res.getString("anio")));
					
					CandidatoVO cand = new CandidatoVO();
					cand.setNombre(res.getString("nombre"));
					cand.setApellido(res.getString("apellido"));
					cand.setDNI(Integer.parseInt(res.getString("DNI")));
					pos.setCandidato(cand);
					publicacion.getPostulaciones().add(pos);
					publicaciones.set(i, publicacion);*/
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
	
	public List<PublicacionVO> getPublicacionesActivas()
	{
		Conexion conex = new Conexion();
		List<PublicacionVO> pubs = new ArrayList<PublicacionVO>();
		
		try
		{
			String query = ""; // Aqui va la consulta SELECT para extraer las publicaciones con estado activo
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			ResultSet res = consulta.executeQuery();
			while(res.next())
			{
				PublicacionVO pub = new PublicacionVO();
				// Se lee cada publicacion y se adjunta a la lista de pubs
			}
			
			res.close();
			conex.desconectar();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return pubs;
	}
	
	private int indexOfArray(List<PublicacionVO> publicaciones, String job) {
		int index = -1;
		for(int i = 0; i< publicaciones.size(); i++) {
			if(job.equals(publicaciones.get(i).getTitulo()))
					index = i;
		}
		return index;
	}

	public void registrarPublicacion(PublicacionVO pub)
	{
		Conexion conex = new Conexion();
		
		try
		{
			String query = "INSERT INTO publicacion (titulo, descripcion, modalidadContrato, tipoDeTrabajo, lugarDeTrabajo"
					+ ", categoria, requisitos, sueldo, activa) VALUES"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?);"; // Insertar aqui la query para insercion en SQL
			
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			
			statement.setString(1, pub.getTitulo());
			statement.setString(2, pub.getDescripcion());
			statement.setString(3, pub.getModalidadStr());
			statement.setString(4, pub.getTipoTrabajoStr());
			statement.setString(5, pub.getLugarTrabajo());
			statement.setString(6, pub.getCategoria());
			statement.setString(7, pub.getRequisitosStr());
			statement.setFloat(8, pub.getSueldo());
			statement.setBoolean(9, false);
			
			statement.execute();
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente la publicacion","Informacion",JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			conex.desconectar();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
	
}
