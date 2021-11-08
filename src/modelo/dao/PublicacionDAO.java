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
		try {	
			String query = "SELECT * FROM publicacion;";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				PublicacionVO publicacion= new PublicacionVO();
				publicacion.setTitulo(res.getString("titulo"));
				publicacion.setSueldo(Float.parseFloat(res.getString("sueldo")));
				
				String mod = res.getString("modalidadContrato");
				
				if (mod.equals("part-time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.PART_TIME);	
				}
				else if (mod.equals("Full-Time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.FULL_TIME);
				}
				
				String tipo = res.getString("tipoDeTrabajo");
				
				if (tipo.equals("remoto"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.REMOTO);
				else if (tipo.equals("Presencial"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.PRESENCIAL);
				
				
				String[] tareas = res.getString("descripcion").split(";");
				
				for (String str : tareas)
					publicacion.agregarTareas(str);
				
				String[] requisitos = res.getString("requisitos").split(";");
				
				publicacion.setCategoria(res.getString("categoria"));
				
				for (String str : requisitos)
					publicacion.agregarRequisito(str);
				
				publicacion.setActiva(res.getBoolean("activa"));
				publicaciones.add(publicacion);
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
		Conexion conex= new Conexion();
		List<PublicacionVO> publicaciones= new ArrayList<PublicacionVO>();		
		List<PostulacionVO> postulaciones= new ArrayList<PostulacionVO>();

		try {	
			String query = "SELECT * FROM publicacion WHERE activa = TRUE; ";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				PublicacionVO publicacion= new PublicacionVO();
				publicacion.setTitulo(res.getString("titulo"));
				publicacion.setSueldo(Float.parseFloat(res.getString("sueldo")));
				
				String mod = res.getString("modalidadContrato");
				
				System.out.println(mod);
				
				
				if (mod.equals("part-time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.PART_TIME);	
				}
				else if (mod.equals("Full-Time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.FULL_TIME);
				}
				
				String tipo = res.getString("tipoDeTrabajo");
				
				System.out.println(tipo);
				
				if (tipo.equals("remoto"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.REMOTO);
				else if (tipo.equals("Presencial"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.PRESENCIAL);
				
				
				String[] tareas = res.getString("descripcion").split(";");
				
				for (String str : tareas)
					publicacion.agregarTareas(str);
				
				String[] requisitos = res.getString("requisitos").split(";");
				
				publicacion.setCategoria(res.getString("categoria"));
				
				for (String str : requisitos)
					publicacion.agregarRequisito(str);
				
				publicacion.setActiva(res.getBoolean("activa"));
				publicaciones.add(publicacion);
			}
			res.close();
			conex.desconectar();
			return publicaciones;
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return null;
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
			statement.setString(2, String.join(";", pub.getTareas()));
			statement.setString(3, pub.getModalidadStr());
			statement.setString(4, pub.getTipoTrabajoStr());
			statement.setString(5, pub.getLugarTrabajo());
			statement.setString(6, pub.getCategoria());
			statement.setString(7, String.join(";", pub.getRequisitos()));
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

	public List<PublicacionVO> getPublicacionesRemotasYPartTime() {
		
		Conexion conex= new Conexion();
		List<PublicacionVO> publicaciones= new ArrayList<PublicacionVO>();		
		List<PostulacionVO> postulaciones= new ArrayList<PostulacionVO>();

		try {	
			String query = "SELECT * FROM publicacion WHERE modalidadContrato = \"part-time\" AND tipoDeTrabajo = \"remoto\"; ";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				PublicacionVO publicacion= new PublicacionVO();
				publicacion.setTitulo(res.getString("titulo"));
				publicacion.setSueldo(Float.parseFloat(res.getString("sueldo")));
				
				String mod = res.getString("modalidadContrato");
				
				System.out.println(mod);
				
				
				if (mod.equals("part-time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.PART_TIME);	
				}
				else if (mod.equals("Full-Time"))
				{
					publicacion.setModalidad(PublicacionVO.ModalidadContrato.FULL_TIME);
				}
				
				String tipo = res.getString("tipoDeTrabajo");
				
				System.out.println(tipo);
				
				if (tipo.equals("remoto"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.REMOTO);
				else if (tipo.equals("Presencial"))
					publicacion.setTipoTrabajo(PublicacionVO.TipoTrabajo.PRESENCIAL);
				
				
				String[] tareas = res.getString("descripcion").split(";");
				
				for (String str : tareas)
					publicacion.agregarTareas(str);
				
				String[] requisitos = res.getString("requisitos").split(";");
				
				publicacion.setCategoria(res.getString("categoria"));
				
				for (String str : requisitos)
					publicacion.agregarRequisito(str);
				
				publicacion.setActiva(res.getBoolean("activa"));
				publicaciones.add(publicacion);
			}
			res.close();
			conex.desconectar();				
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return publicaciones;
	}
	
}
