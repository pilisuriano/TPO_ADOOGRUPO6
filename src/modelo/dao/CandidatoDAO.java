package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.CandidatoVO;

public class CandidatoDAO {
	
	public void registrarCandidato(CandidatoVO cand)
	{
		Conexion conex = new Conexion();
		
		try {
			String query = "INSERT INTO `postulante` VALUES "
					+ "(?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			statement.setInt(1, cand.getDNI());
			statement.setString(2, cand.getNombre() + " " + cand.getApellido());
			statement.setDate(3, (Date) cand.getFechaNacimiento());
			statement.setString(4, cand.getNacionalidadesStr());
			statement.setString(5, cand.getIdiomasStr());
			statement.setString(6, cand.getInteresesStr());
			
			statement.execute();
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente al candidato","Informacion",JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
	
	public CandidatoVO buscarCandidato(int DNI)
	{
		Conexion conex = new Conexion();
		CandidatoVO cand = new CandidatoVO();
		
		boolean existe=false;
		try 
		{
			String query = "SELECT * FROM `postulantes` WHERE `dni` = ?"; // Query de Seleccion
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setInt(1, DNI);
			ResultSet res = consulta.executeQuery();
			while(res.next())
			{
				cand.setDNI(res.getInt("dni"));
				String[] nombreApellido = res.getString("nombreYApe").split(" ");
				
				cand.setNombre(nombreApellido[0]);
				cand.setApellido(nombreApellido[1]);
				
				String[] nacionalidades = res.getString("nacionalidad").split(" ");
				
				for (String str : nacionalidades)
					cand.agregarNacionalidad(str);
				
				String[] intereses = res.getString("intereses").split(" ");
				
				for (String str : intereses)
					cand.agregarInteres(str);
				
				String[] idiomas = res.getString("idiomas").split(" ");
				
				for (String str : idiomas)
					cand.agregarIdioma(str);
				
				existe=true;
				// Aqui se extraen los datos de la DB y se colocan en el objeto CandidatoVO
			}
			res.close();
			conex.desconectar();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		if (existe)
			return cand;
		
		return null;
	}
	
	
	public List<CandidatoVO> getCandidatos() {
		Conexion conex= new Conexion();
		List<CandidatoVO> candidatos = new ArrayList<CandidatoVO>();
		
		try{
			String query = "SELECT * FROM `postulantes`";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			ResultSet res = consulta.executeQuery();
			while(res.next())
			{
				CandidatoVO cand = new CandidatoVO();
				cand.setDNI(res.getInt("dni"));
				String[] nombreApellido = res.getString("nombreYApe").split(" ");
				
				cand.setNombre(nombreApellido[0]);
				cand.setApellido(nombreApellido[1]);
				
				String[] nacionalidades = res.getString("nacionalidad").split(" ");
				
				for (String str : nacionalidades)
					cand.agregarNacionalidad(str);
				
				String[] intereses = res.getString("intereses").split(" ");
				
				for (String str : intereses)
					cand.agregarInteres(str);
				
				String[] idiomas = res.getString("idiomas").split(" ");
				
				for (String str : idiomas)
					cand.agregarIdioma(str);
				
				candidatos.add(cand);
			}
			res.close();
			conex.desconectar();
			
			return candidatos;
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return null;
	}
}
