package patrones;

public class NotificacionEmail implements IEstrategiaNotificable
{
	private IAdapterEmail adapterEmail;
	
	@Override
	public void enviar(Notificacion not) {
		// TODO Auto-generated method stub
		this.adapterEmail.enviarMail(not);
	}
	
	public void setAdapterEmail(IAdapterEmail adap)
	{
		this.adapterEmail = adap;
	}
}
