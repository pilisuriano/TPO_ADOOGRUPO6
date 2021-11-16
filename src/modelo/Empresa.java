package modelo;

import java.util.ArrayList;

import modelo.vo.CandidatoVO;
import modelo.vo.PostulacionVO;
import modelo.vo.PublicacionVO;
import patrones.MedioNotificacion;
import patrones.Notificacion;
import patrones.SistemaNotificador;

public class Empresa 
{
	private String razonSocial;
	private int cuit;
	private ArrayList<Publicacion> publicaciones;
	private String email;
	private int tlf;
	
	public Empresa()
	{
		this.razonSocial = "";
		this.publicaciones = new ArrayList<Publicacion>();
		this.cuit = 0;
		this.setEmail("");
	}

	public Empresa(String razonSocial,
				   int cuit,
				   ArrayList<Publicacion> publicaciones) {
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.publicaciones = publicaciones;
	}
	
	public void agregarPublicacion(Publicacion pub)
	{
		if (this.publicaciones.indexOf(pub) == -1)
			this.publicaciones.add(pub);
	}
	
	public void eliminarPublicacion(Publicacion pub)
	{
		int pos = this.publicaciones.indexOf(pub);
		
		if (pos != -1)
			publicaciones.remove(pos);
	}
	
	public void setRazonSocial(String razSoc)
	{
		this.razonSocial = razSoc;
	}
	
	public String getRazonSocial() { return this.razonSocial; }

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	
	public void postulacionRealizada(PostulacionVO postu, PublicacionVO pub)
	{
		// TODO Auto-generated method stub
		// Solo notificar si la publicacion es de la empresa
		boolean existe = false;
		for (Publicacion itr : this.publicaciones)
		{
			if (itr.getIdPublicacion() == pub.getIdPublicacion())
			{
				existe = true;
				break;
			}
		}
		
		if (!existe)
			return;
		
		Notificacion not = new Notificacion();
		CandidatoVO candidato = postu.getCandidato();
		
		not.setRemitente("Sistema RRHH - Postulaciones");
		not.setMsj("Se ha postulado un nuevo candidato llamado: " + candidato.getNombre() + " " + candidato.getApellido());
		
		if (pub.getMedioNotificacion() == MedioNotificacion.EMAIL)
			not.setRemitente(this.email);
		else
			not.setRemitente(Integer.toString(tlf));
		
		
		SistemaNotificador.getInstancia().enviarNotificacion(not, pub.getMedioNotificacion());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
}
