package patrones;

public class Notificador 
{
	IEstrategiaNotificable estrategia;
	
	void notificar(Notificacion not)
	{
		this.estrategia.enviar(not);
	}
	
	public void cambiarEstrategiaNotificacion(IEstrategiaNotificable estra)
	{
		this.estrategia = estra;
	}
};