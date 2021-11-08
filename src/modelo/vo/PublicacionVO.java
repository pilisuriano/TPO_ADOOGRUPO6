package modelo.vo;

import java.util.List;

public class PublicacionVO {
	private String titulo;
	private Double sueldo;
	private List<PostulacionVO> postulaciones;
	private date fechaLimite;
	private boolean postulacionActiva;
	private String descripcion;
	private bool modalidadFT;
	private bool tipoDeTrabajoRemoto;
	private String lugarTrabajo;
	private Categoria categoria;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public List<PostulacionVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<PostulacionVO> postulaciones) {
		this.postulaciones = postulaciones;
	}
	public void setFechaLimite(date fechaLimite) {
		this.setFechaLimite(); = fechaLimite;
	}
	public date getFechaLimite()  {
		return fechaLimite;
	}
	public void activarPublicacion() {
		this.postulacionActiva(); = true;
	}
	public void desactivarPublicacion() {
		this.postulacionActiva(); = false;
	}
	public boolean getEstadoPublicacion() {
		this.postulacionActiva();
	}

	public void setLugarTrabajo(string lugarTrabajo)
	{
		this.lugarTrabajo = lugarTrabajo;
	}

	public string getLugarTrabajo  {
		return lugarTrabajo;
	}

	private void setCategoria (Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setTipoDeTrabajoRemoto(bool trabajoRemoto)
	{
		if (trabajoRemoto==true)
			this.tipoDeTrabajoRemoto =true;
		else
			this.tipoDeTrabajoRemoto = false;
	}
	public bool getTipoDeTrabajoRemoto  {
		this.tipoDeTrabajoRemoto();
	}

}
