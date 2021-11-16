package patrones;

public class AdapterMailLib implements IAdapterEmail {

	@Override
	public void enviarMail(Notificacion not) {
		// TODO Auto-generated method stub
		System.out.println("Usando Libreria EmailSender");
	}

}
