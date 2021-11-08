package modelo.vo;

public class CandidatoVO {
	private String nombre;
	private String apellido;
	private Integer DNI;
	private Date fechaDeNacimiento;
	private String nacionalidad;
	private List<Strings> idiomas;
	private List<Strings> intereses;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDNI() {
		return DNI;
	}
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void getFechaDeNacimiento(date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public List<Strings> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Strings> idiomas) {
		this.idiomas = idiomas;
	}
	public List<Strings> getIntereses() {
		return intereses;
	}
	public void setIntereses(List<Strings> intereses) {
		this.intereses = intereses;
	}
}
