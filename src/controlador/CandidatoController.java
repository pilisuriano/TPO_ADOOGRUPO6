package controlador;

import modelo.Candidato;
import modelo.vo.CandidatoVO;
import vista.VentanaRegistrarCandidato;

public class CandidatoController 
{
	Candidato modeloCandidato;
	VentanaRegistrarCandidato registrarCandVentana;
	
	public CandidatoController()
	{
		modeloCandidato = new Candidato();
	}
	
	public void registrarCandidato(CandidatoVO candidato)
	{
		modeloCandidato.registrarCandidato(candidato);
	}
	
	public CandidatoVO buscarCandidato(int DNI)
	{
		return modeloCandidato.buscarCandidato(DNI);
	}

	public void mostrarVentanaRegistroPostulante() {
		// TODO Auto-generated method stub
		this.registrarCandVentana = new VentanaRegistrarCandidato();
		this.registrarCandVentana.setCandidatoController(this);
		this.registrarCandVentana.setVisible(true);
	}
}
