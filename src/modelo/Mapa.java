package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Mapa {
	private Arbol<Ciudad> arbol;
	private ArrayList<Ciudad> ciudades;
	private static Mapa INSTANCE = null;
	private int cantHijos;
	private HashMap<String,Ciudad> referencias;
	
	private Mapa(){
		referencias = new HashMap<String, Ciudad>();
		cantHijos = 2;
		ciudades = this.cargarCiudades();
		this.agregarCiudadesIniciales();
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
		
	public List<Ciudad> ciudadesAdyacentes(Ciudad ciudad){
		List<Ciudad> adyacentes = this.ciudadesDestino(ciudad);
		Ciudad anterior = arbol.verPadre(ciudad);
		if (anterior != null) adyacentes.add(anterior);
		return adyacentes;
	}
	
	public Ciudad verCiudadInicial() {
		return arbol.verRaiz();
	}
	
	public List<Ciudad> ciudadesDestino(Ciudad ciudad){
		List<Ciudad> destinos = arbol.verHijos(ciudad);
		if (destinos == null) return null;
		if (destinos.isEmpty()){
			this.agregarDestinos(cantHijos, ciudad);
			destinos = arbol.verHijos(ciudad);
		}
		return destinos;
	}
	
	public Ciudad ciudadAnterior(Ciudad ciudad){
		return arbol.verPadre(ciudad);
	}
	
	public Ciudad buscarCiudad(String nombreCiudad){
		if (!referencias.containsKey(nombreCiudad)) return null;
		return referencias.get(nombreCiudad);
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
	
	private void agregarCiudadesIniciales(){
		Double subindice = Math.floor(Math.random()*ciudades.size());
		Ciudad raiz = ciudades.remove(subindice.intValue());
		referencias.put(raiz.getNombre(), raiz);
		arbol = new Arbol<Ciudad>(raiz);
		this.agregarDestinos(cantHijos + 1, raiz);
	}
	
	private void agregarDestinos(int cantidad, Ciudad origen){
		for (int i = 0; i < cantidad && ciudades.size() > 0; i++){
			Double subindice = Math.floor(Math.random()*ciudades.size());
			Ciudad hijo = ciudades.remove(subindice.intValue());
			arbol.agregarHijo(origen, hijo);
			referencias.put(hijo.getNombre(), hijo);
		}
	}
	
	public int cantidadCiudades(){
		return arbol.size();
	}
}
