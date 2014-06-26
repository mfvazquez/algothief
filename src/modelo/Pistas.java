package modelo;

import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;


public class Pistas {
	private ArrayList<Pista> pistas;

	private static Pistas INSTANCE = null;
	
	private Pistas(){
		this.cargarPistas();
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Pistas();
	    }
	}
	
	public static Pistas getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	private void cargarPistas(){
		ArrayList<Pista> listaPista = new ArrayList<Pista>();
		try {
			File fXmlFile = new File("recursos/pistas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("pistafacil");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String pista = eElement.getElementsByTagName("pista").item(0).getTextContent();
					String ciudad = eElement.getElementsByTagName("ciudad").item(0).getTextContent();
					String edi = eElement.getElementsByTagName("edificio").item(0).getTextContent();
					
					Pista temporal = new PistaFacil(pista, edi, ciudad);
					listaPista.add(temporal);	 
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.pistas = listaPista;
		
	}
	
	public void mostrarPistas(){
		for (Pista p : this.pistas){
			System.out.println(p.getPista());
		}
	}

	public Pista pedirPistaCiudad(Ciudad destino) {
		return null;
	}
}
