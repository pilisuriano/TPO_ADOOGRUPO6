package Mockeador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JOptionPane;

import modelo.Candidato;
import modelo.Empresa;
import modelo.Postulacion;
import modelo.Publicacion;
import modelo.Publicacion.ModalidadContrato;
import modelo.Publicacion.TipoTrabajo;
import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import patrones.MedioNotificacion;
import patrones.SistemaNotificador;

public class Mockeador 
{
	private HashMap<Integer, Candidato> candidatos;
	private HashMap<Integer, Publicacion> publicaciones;
	private HashMap<Integer, Empresa> empresas;
	private static Mockeador instancia;
	
	public static Mockeador getInstancia()
	{
		if (instancia == null)
			instancia = new Mockeador();
		
		return instancia;
	}
	
	private Mockeador()
	{
		candidatos = new HashMap<Integer, Candidato>();
		publicaciones = new HashMap<Integer, Publicacion>();
		empresas = new HashMap<Integer, Empresa>();
		
		this.llenarDatosPruebas();
	}
	
	public List<PublicacionVO> getPublicaciones()
	{
		List<PublicacionVO> pubs = new ArrayList<PublicacionVO>();
        
		for(Entry<Integer, Publicacion> entry :  publicaciones.entrySet())
		{
			PublicacionVO pVO = new PublicacionVO(entry.getValue());
			pVO.setIdPublicacion(entry.getKey());
			pubs.add(pVO);
		}
		
		return pubs;
	}
	
	public List<PublicacionVO> getPublicacionesActivas()
	{
		List<PublicacionVO> pubs = new ArrayList<PublicacionVO>();
        
		for(Entry<Integer, Publicacion> entry :  publicaciones.entrySet())
		{
			if (!entry.getValue().isActiva())
				continue;
			
			PublicacionVO pVO = new PublicacionVO(entry.getValue());
			pVO.setIdPublicacion(entry.getKey());
			pubs.add(pVO);
		}
		
		return pubs;
	}
	
	public List<PublicacionVO> getPublicacionesRemotasYPartTime()
	{
		List<PublicacionVO> pubs = new ArrayList<PublicacionVO>();
        
		for(Entry<Integer, Publicacion> entry :  publicaciones.entrySet())
		{
			Publicacion p = entry.getValue();
			
			if (!p.esRemotaYPartTime())
				continue;
			
			PublicacionVO pVO = new PublicacionVO(p);
			pVO.setIdPublicacion(entry.getKey());
			pubs.add(pVO);
		}
		
		return pubs;
	}
	
	public void agregarFavoritaACandidato(PublicacionVO pub, CandidatoVO cand)
	{
		try
		{
			Candidato candEO = this.candidatos.get(cand.getDNI());
			Publicacion pubEO = this.publicaciones.get(pub.getIdPublicacion());
			
			if (candEO.tieneFavorita(pubEO))
				throw new Exception();
			
			candEO.getPublicacionesFavoritas().add(pubEO);
			
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente la publicacion","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"La publicacion ya existe en favoritos","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void registrarPublicacion(PublicacionVO pub)
	{
		try
		{
			Publicacion p = new Publicacion();
			
			p.setTitulo(pub.getTitulo());
			
			for (String itr : pub.getTareas())
				p.getTareas().add(itr);
			
			p.setModalidad(pub.getModalidadContrato());
			p.setTipo(pub.getTipoTrabajo());
			p.setLugarTrabajo(pub.getLugarTrabajo());
			p.setCategoria(pub.getCategoria());
			
			for (String itr : pub.getRequisitos())
				p.getRequisitos().add(itr);
			
			p.setSueldo(pub.getSueldo());
			p.setActiva(pub.isActiva());
			
			int key = publicaciones.size();
			pub.setIdPublicacion(key);
			publicaciones.put(key, p);
			key++;
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente la publicacion","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error Registrando la Publicacion","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarCandidato(CandidatoVO candVO)
	{
		try
		{
			Candidato cand = new Candidato();
			
			cand.setDNI(candVO.getDNI());
			cand.setNombre(candVO.getNombre());
			cand.setApellido(candVO.getApellido());
			
			java.util.Date fecha = candVO.getFechaNacimiento();
			
 			cand.setFechaNacimiento(fecha.getDay(), fecha.getMonth(), fecha.getYear());
			
			for (String itr : candVO.getNacionalidades())
				cand.agregarNacionalidad(itr);
			
			for (String itr : candVO.getIdiomas())
				cand.agregarIdioma(itr);
			
			for (String itr : candVO.getIntereses())
				cand.agregarInteres(itr);
			
			if (this.candidatos.containsKey(cand.getDNI()))
				throw new Exception();
			
			this.candidatos.put(cand.getDNI(), cand);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente al Candidato","Informacion",JOptionPane.INFORMATION_MESSAGE);
			SistemaNotificador.getInstancia().agregarObservable(cand);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error Registrando el Candidato","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void registrarPostulacion(PublicacionVO pVO, PostulacionVO postuVO)
	{
		try
		{
			Postulacion postu = new Postulacion();
			
			Candidato cand = this.candidatos.get(postuVO.getCandidato().getDNI());
			
			postu.setCandidato(cand);
			postu.setRenumeracion(postuVO.getRenumeracion());
			
			Date fecha = new Date(postuVO.getDia(), postuVO.getMes(), postuVO.getAnio());
			postu.setFechaPostulacion(fecha);
			
			Publicacion pub = this.publicaciones.get(pVO.getIdPublicacion());
						
			for (Postulacion itr : pub.getPostulaciones())
			{
				if (itr.getCandidato().getDNI() == cand.getDNI())
					throw new Exception();
			}
			
			pub.getPostulaciones().add(postu);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error Registrando la Postulacion","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public CandidatoVO getCandidato(int DNI)
	{
		if (!this.candidatos.containsKey(DNI))
			return null;
	
		Candidato c = this.candidatos.get(DNI);
		
		return new CandidatoVO(c);
	}

	public Empresa getEmpresa(int CUIT)
	{
		if (!this.empresas.containsKey(CUIT))
			return null;
		
		Empresa emp = this.empresas.get(CUIT);
		return emp;
	}
	
	public List<CandidatoVO> getCandidatos() 
	{
		// TODO Auto-generated method stub
		List<CandidatoVO> listCandidatos = new ArrayList<CandidatoVO>();
        
		for(Entry<Integer, Candidato> entry : this.candidatos.entrySet())
		{
			CandidatoVO cVO = new CandidatoVO(entry.getValue());
			listCandidatos.add(cVO);
		}
		
		return listCandidatos;
	}
	
	private void llenarDatosPruebas()
	{
		String[] intereses = new String[] {"Ingenieria", "Salud", "Economia", "Legislativa", "Contaduria", "Artes", "Investigacion"};
		String[] tareas = new String[] {"Analizar", "Desarrollar", "Toma de Datos", "Capacitacion", "Asesorar", "Documentar", "Liquidacion de Nominas"};
		String[] nombres = new String[] {"Pedro", "Jose", "Pilar", "Claudio", "Sergio"};
		String[] apellidos = new String[] {"Sanchez", "Alberdi", "Lopez", "Kiramman"};
		String[] idiomas = new String[] {"Espa\\u00F1ol", "Ingles", "Aleman", "Frances"};
		String[] titulos = new String[] {"DevOps Jr",
				"QA Jr",
				"Dev Jr",
				"Dev Ssr",
				"QA Ssr",
				"DevOps Ssr",
				"Dev Sr",
				"QA Sr",
				"DevOps Sr",
				"Pay Roll",
				"Recruiter",
				"Analista N2"};
		
		
		String requisitos[] = new String[] {
				"React","NextJS","Logica Programacional","MVC","Git","Linux","JQuery","CSS","Angular","HTML","Python"
		};
		
		String lugares[] = new String[] {
				"CABA",
				"La Plata",
				"Cordoba",
				"Rosario",
		};
		
		String nacionalidades[] = new String[] {"Argentina", "Francesa", "Estadounidense", "Colombiana", "Chilena"};
		
		int DNI = 1000;
		
		Empresa uade = new Empresa();
		uade.setCuit(1234);
		uade.setEmail("contacto@uade.edu.ar");
		uade.setRazonSocial("UADE");
		
		this.empresas.put(uade.getCuit(), uade);
		
		for (int i = 0; i < 5; ++i)
		{
			CandidatoVO c = new CandidatoVO();
			
			c.setNombre(getRandomElement(nombres));
			c.setApellido(getRandomElement(apellidos));
			
			for (String itr : getShuffleContainer(intereses))
				c.agregarInteres(itr);
				
			for (String itr : getShuffleContainer(idiomas))
				c.agregarIdioma(itr);
			
			for (String itr : getShuffleContainer(nacionalidades))
				c.agregarNacionalidad(itr);

			c.setFechaNacimiento(getRandomDate());
			c.setDNI(DNI);
			DNI += 2;
			this.registrarCandidato(c);
		}
		
		// TODO Auto-generated method stub
			
        // Se agrega desde aqui por motivos de pruebas
		for(Entry<Integer, Candidato> entry : this.candidatos.entrySet())
			SistemaNotificador.getInstancia().agregarObservable(entry.getValue());
			
		for (int i = 0; i < 5; ++i)
		{
			PublicacionVO p = new PublicacionVO();
			
			p.setTitulo(getRandomElement(titulos));
			
			for (String itr : getShuffleContainer(tareas))
				p.getTareas().add(itr);
			
			for (String itr : getShuffleContainer(requisitos))
				p.getRequisitos().add(itr);
			
			p.setSueldo(getRandomNumber(100, 600));
			p.setActiva(true);
			
			if (getRandomNumber(0, 1) == 1)
				p.setModalidad(ModalidadContrato.FULL_TIME);
			else
				p.setModalidad(ModalidadContrato.PART_TIME);
			
			if (getRandomNumber(0, 1) == 1)
				p.setTipoTrabajo(TipoTrabajo.PRESENCIAL);
			else
				p.setTipoTrabajo(TipoTrabajo.REMOTO);
			
			p.setLugarTrabajo(getRandomElement(lugares));
			p.setCategoria(getRandomElement(intereses));
			p.setMedioNotificacion(MedioNotificacion.EMAIL);
			
			this.registrarPublicacion(p);
		}
	}
	
	private String[] getShuffleContainer(String[] values) 
	{
		String[] ret = null;
		
		List<String> container = Arrays.asList(values);

		Collections.shuffle(container);
		
		int min = 0;
		int max = values.length - 1;

		Random r = new Random();
		int idx = r.nextInt((max - min) + 1) + min;

		ret = new String[idx];
		
		for (int i = 0; i < idx; ++i)
			ret[i] = container.get(i);
		
		return ret;
	}
	
	private int getRandomNumber(int min, int max)
	{
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private Date getRandomDate()
	{
		int day = getRandomNumber(1, 30);
		int month = getRandomNumber(1, 12);
		int year = getRandomNumber(2000, 2021);
		
		return new Date(day, month, year);
	}
	
	private String getRandomElement(String[] values) 
	{
		int min = 0;
		int max = values.length - 1;
		

		Random r = new Random();
		int idx = r.nextInt((max - min) + 1) + min;
		return values[idx];
	}
}
