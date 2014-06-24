package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Mapa {
	private Arbol<Ciudad> arbol;
	private static Mapa INSTANCE = null;
	
	private Mapa(){
		ArrayList<Ciudad> lista = this.cargarCiudades();
		this.enlazarCiudades(lista);
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Mapa();
	    }
	}

	public static Mapa getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	public Ciudad ciudadAnterior(Ciudad ciudad){
		return arbol.verPadre(ciudad);
	}
	
	public List<Ciudad> ciudadesDestino(Ciudad ciudad){
		 
		return arbol.verHijos(ciudad);
	}
		
	public List<Ciudad> ciudadesAdyacentes(Ciudad ciudad){
		List<Ciudad> adyacentes = arbol.verHijos(ciudad);
		if (adyacentes == null) return null;
		Ciudad anterior = arbol.verPadre(ciudad);
		if (anterior != null) adyacentes.add(anterior);
		return adyacentes;
	}
	
	public Ciudad verCiudadInicial() {
		return arbol.verRaiz();
	}
	
	private ArrayList<Ciudad> cargarCiudades(){
		
		ArrayList<Ciudad> listaCiudades= new ArrayList<Ciudad>();
		
		try {
			File fXmlFile = new File("recursos/ciudades.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		 	 
			NodeList nList = doc.getElementsByTagName("ciudad");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String latitudStr = eElement.getElementsByTagName("latitud").item(0).getTextContent();
					String longitudStr = eElement.getElementsByTagName("longitud").item(0).getTextContent();
					double longitud = Double.parseDouble(longitudStr) * 111;
					double latitud = Double.parseDouble(latitudStr) * 111;
					
					Ciudad temporal = new Ciudad(nombre, latitud, longitud);
					listaCiudades.add(temporal);	 
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaCiudades;
	}
	
	private void enlazarCiudades(ArrayList<Ciudad> lista){
		
		Double subindice = Math.floor(Math.random()*lista.size());
		Ciudad tmp = lista.remove(subindice.intValue());
		ArrayList<Ciudad> padres = new ArrayList<Ciudad>();
		ArrayList<Ciudad> proximos = new ArrayList<Ciudad>();
		arbol = new Arbol<Ciudad>(tmp);
		padres.add(tmp);
		
		while (!lista.isEmpty()){
			while (!padres.isEmpty()){
				Ciudad padre = padres.remove(0);
				for (int i = 0; i < 2 && lista.size() > 0; i++){
					subindice = Math.floor(Math.random()*lista.size());
					Ciudad hijo = lista.remove(subindice.intValue());
					arbol.agregarHijo(padre, hijo);
					proximos.add(hijo);
				}
			}
			padres = proximos;
			proximos = new ArrayList<Ciudad>();
		}
	}
	
}
