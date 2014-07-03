package modelo;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Juego {
	private ArrayList<Policia> policias;
	
	public Juego() throws MapaSeQuedoSinCiudades{
		policias = new ArrayList<Policia>();
	    Ladrones.getInstance();
	    Mapa.getInstance();
	}
	
	public Juego(ArrayList<Policia> polis) throws MapaSeQuedoSinCiudades{
		this.policias = polis;
		Ladrones.getInstance();
		Mapa.getInstance();
	}
	
	public boolean policiaExistente(Policia poli){
		return policias.contains(poli);
	}
	
	public void agregarPolicia(Policia poli) {
		policias.add(poli);
	}
		
	public int cantidadPolicias(){
		return policias.size();
	}
	
	public Policia obtenerPolicia(String nombre){
		Policia poli_aux = new Policia(nombre);
		if (!this.policiaExistente(poli_aux)) return null;
		int indice = policias.indexOf(poli_aux);
		return policias.get(indice);
	}

	
	public Mision nuevaMision(Policia policia) {
		Ladron ladron = Ladrones.getInstance().ladronAleatorio();
		Mision mision = new Mision(policia, ladron); 
	    policia.asignarMision(mision);
	    return mision;
	}
	
	public String ciudadInicioStr() throws MapaSeQuedoSinCiudades{
		return Mapa.getInstance().verCiudadInicial().getNombre();
	}

	public void guardarJuego() throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factory.newDocumentBuilder();
		Document doc = db.newDocument();
		Element juego = doc.createElement("juego");
		for(Policia poli : this.policias){
			juego.appendChild(poli.toXml(doc));
		}
		doc.appendChild(juego);
		File archivo = new File("recursos/persistencia.xml");
		/*if(archivo.exists()){
			archivo.delete();
		}*/
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(archivo);
		transformer.transform(source, result);
	}
	public static Juego cargarJuego() throws MapaSeQuedoSinCiudades{
		ArrayList<Policia> listaPolicias = new ArrayList<Policia>();
		try {
			File fXmlFile = new File("recursos/persistencia.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("policia");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				listaPolicias.add(Policia.cargar(nNode));	 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Juego(listaPolicias);
		
	}
	
}
