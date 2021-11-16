package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import modelo.Publicacion;
import modelo.vo.*;
import vista.VentanaReporte;

public class ReporteController {

	private Publicacion publicacion;
	private VentanaReporte ventanaReporte;
	
	public ReporteController() {
		publicacion = new Publicacion();
	}
	
	public VentanaReporte getMiVentanaReporte() {
		return ventanaReporte;
	}
	public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
		this.ventanaReporte = miVentanaReporte;
	}	
	public Publicacion getMiLogica() {
		return publicacion;
	}
	
//////////////////////////////////////////////////////////
	
	public void mostrarVentanaReporte() {
		ventanaReporte = new VentanaReporte();
		ventanaReporte.setCoordinador(this);
		ventanaReporte.setVisible(true);
	}	
	
	public ReporteVO getReporteMayorOfertasLaborales(String mes, String anio) 
	{
		ReporteVO res = new ReporteVO();
		List<PublicacionVO> publicaciones = publicacion.getPublicaciones();
		String title = "";
		int mayor = 0;
		for(PublicacionVO ol : publicaciones) {
			int cant = 0;
			for(PostulacionVO postulacion : ol.getPostulaciones()) {
				if(postulacion.getAnio().toString().equals(anio.trim())) {
					if(!mes.trim().equals("") && postulacion.getMes().toString().equals(mes.trim())) {
						cant++;
					}
					else if(mes.trim().equals("")){
						cant++;
					}
				}
			}
			if(cant > mayor) {
				title = ol.getTitulo();
				mayor = cant;
			}
		}
		
		res.setTitulo_oferta(title);
		res.setCantidad_entre_fechas(mayor);
		return res;
	}
	
	
	public List<String> getTopMCategoriasSeleccionadasPublicaciones(int M)
	{
		List<String> categorias = new ArrayList<String>();
		List<PublicacionVO> pubs = publicacion.getPublicaciones();
		
		TreeMap<String, Integer> freqs = new TreeMap<String, Integer>(Comparator.reverseOrder());
		
		for (PublicacionVO itr : pubs)
		{
			String cat = itr.getCategoria();
			
			if (freqs.containsKey(cat))
			{
				Integer countRef = freqs.get(cat);
				int count = countRef.intValue();
				count += 1;
				countRef = count;
				freqs.put(cat, count);
			}
			else
				freqs.put(cat, 1); 
		}
		
		for(Map.Entry<String,Integer> entry : freqs.entrySet()) 
		{
		  String key = entry.getKey();
		  if (categorias.size() >= M)
			  break;
		  
		  categorias.add(key);
		}
		
		return categorias;
	}
	
	public ReporteVO getOfertaMasAccesible()
	{
		List<PublicacionVO> pubs = publicacion.getPublicacioneRemotasYPartTime();
		
		if (pubs.isEmpty())
			return null;
		
		PublicacionVO min = pubs.get(0);
		ReporteVO mejorOferta = new ReporteVO();
		
		for (PublicacionVO itr : pubs)
		{	
			int lhsReq = min.getRequisitos().size() + min.getTareas().size();
			int rhsReq = itr.getRequisitos().size() + itr.getTareas().size();
			
			if (lhsReq > rhsReq)
				min = itr;
		}
		
		mejorOferta.setTitulo_oferta(min.getTitulo());
		
		return mejorOferta;
	}
	
	public ReporteVO getOfertaMasExigente()
	{
		List<PublicacionVO> pubs = publicacion.getPublicaciones();
		
		if (pubs.isEmpty())
			return null;
		
		PublicacionVO pubMasExigente = pubs.get(0);
		
		for (PublicacionVO itr : pubs)
		{
			
			
			if (pubMasExigente.getRequisitos().size() < itr.getRequisitos().size())
				pubMasExigente = itr;
		}
		
		ReporteVO masExigente = new ReporteVO();
		masExigente.setTitulo_oferta(pubMasExigente.getTitulo());
		
		return masExigente;
	}
}
