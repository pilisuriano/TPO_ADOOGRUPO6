package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import modelo.Publicacion;
import modelo.vo.*;
import vista.VentanaReporte;

public class ReporteController {

	private Publicacion publicacion;
	private VentanaReporte miVentanaReporte;
	
	public ReporteController() {
		publicacion = new Publicacion();
	}
	
	public VentanaReporte getMiVentanaReporte() {
		return miVentanaReporte;
	}
	public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
		this.miVentanaReporte = miVentanaReporte;
	}	
	public Publicacion getMiLogica() {
		return publicacion;
	}
	
//////////////////////////////////////////////////////////
	
	public void mostrarVentanaReporte() {
		miVentanaReporte = new VentanaReporte();
		miVentanaReporte.setCoordinador(this);
		miVentanaReporte.setVisible(true);
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
	
	
	public List<String> primerasMCategoriasTop(int M)
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
				//System.out.println(cat + " => " + freqs.get(cat));
			}
			else
				freqs.put(cat, 1); 
		}
		
		for(Map.Entry<String,Integer> entry : freqs.entrySet()) 
		{
		  String key = entry.getKey();
		  Integer value = entry.getValue();
		  
		  System.out.println(key + " => " + value);
		  
		  if (categorias.size() >= M)
			  break;
		  
		  categorias.add(key);
		  
		  System.out.println(key + " => " + value);
		}
		
		return categorias;
	}
	
	public PublicacionVO getTrabajoMasAccesible()
	{
		List<PublicacionVO> pubs = publicacion.getPublicacioneRemotasYPartTime();
		
		if (pubs.isEmpty())
			return null;
		
		PublicacionVO min = pubs.get(0);
		
		for (PublicacionVO itr : pubs)
		{	
			int lhsReq = min.getRequisitos().size() + min.getTareas().size();
			int rhsReq = itr.getRequisitos().size() + itr.getTareas().size();
			
			System.out.println(lhsReq + "," + rhsReq);
			
			if (lhsReq > rhsReq)
				min = itr;
		}
		
		return min;
	}
	
	public PublicacionVO getOfertaMasExigente()
	{
		List<PublicacionVO> pubs = publicacion.getPublicaciones();
		
		if (pubs.isEmpty())
			return null;
		
		PublicacionVO pubMasExigente = pubs.get(0);
		
		for (PublicacionVO itr : pubs)
		{
			int rhsReq = itr.getRequisitos().size();
			int lhsReq = pubMasExigente.getRequisitos().size();
			
			String str = String.format("Req LHS: %d, Req RHS: %d", lhsReq, rhsReq);
			System.out.println(str);
			
			if (pubMasExigente.getRequisitos().size() < itr.getRequisitos().size())
				pubMasExigente = itr;
		}
		
		return pubMasExigente;
	}
}
