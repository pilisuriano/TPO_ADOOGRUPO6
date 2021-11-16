package patrones;

public class Notificacion 
{
	private String remitente;
	private String msj;
	private String destinatario;
	
	Notificacion(String remi, String mensaje, String destina)
	{
		this.remitente = remi;
		this.msj = mensaje;
		this.destinatario = destina;
	}

	public Notificacion() {
		// TODO Auto-generated constructor stub
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
}
