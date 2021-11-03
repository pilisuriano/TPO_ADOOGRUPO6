package modelo.vo;

public class ReporteVO {
	private String titulo_oferta;
	private Integer cantidad_entre_fechas;
	
	public String getTitulo_oferta() {
		return titulo_oferta;
	}
	public void setTitulo_oferta(String titulo_oferta) {
		this.titulo_oferta = titulo_oferta;
	}
	public Integer getCantidad_entre_fechas() {
		return cantidad_entre_fechas;
	}
	public void setCantidad_entre_fechas(Integer cantidad_entre_fechas) {
		this.cantidad_entre_fechas = cantidad_entre_fechas;
	}
}
