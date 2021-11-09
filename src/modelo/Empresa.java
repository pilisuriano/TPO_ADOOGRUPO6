package modelo;

import java.util.ArrayList;

public class Empresa 
{
	private String razonSocial;
	private int cuit;
	private ArrayList<Publicacion> publicaciones;
	
	public Empresa()
	{
		this.razonSocial = "";
		this.publicaciones = new ArrayList<Publicacion>();
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
	
	
}
