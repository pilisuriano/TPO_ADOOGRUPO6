package modelo.vo;

public class EmpresaVO {
	private String razonSocial;
	private String email;
	private int CUIT;
	
	public EmpresaVO()
	{
		
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCUIT() {
		return CUIT;
	}

	public void setCUIT(int cUIT) {
		CUIT = cUIT;
	}
}
