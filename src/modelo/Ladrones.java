package modelo;

import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Ladrones {
	private ArrayList<Ladron> ladrones;
	private static Ladrones INSTANCE = null;
	
	private Ladrones(){
		this.cargarLadrones();
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Ladrones();
	    }
	}
	
	public static Ladrones getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	private void cargarLadrones(){
		ArrayList<Ladron> listaLadrones = new ArrayList<Ladron>();
		try {
			File fXmlFile = new File("recursos/ladrones.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("ladron");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String sexo = eElement.getElementsByTagName("sexo").item(0).getTextContent();
					String hobby = eElement.getElementsByTagName("hobby").item(0).getTextContent();
					String cabello =  eElement.getElementsByTagName("cabello").item(0).getTextContent();
					String senia =  eElement.getElementsByTagName("senia").item(0).getTextContent();
					String vehiculo =  eElement.getElementsByTagName("vehiculo").item(0).getTextContent();
					Ladron temporal = new Ladron(nombre, sexo, hobby, cabello, senia, vehiculo);
					listaLadrones.add(temporal);	 
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.ladrones = listaLadrones;
		
	}
	
	public Ladron ladronAleatorio(){
		Double subindice = Math.random()*ladrones.size();
		return ladrones.get(subindice.intValue());
	}
	public ArrayList<Ladron> getLadrones(){
		return this.ladrones;
	}

	public ArrayList<Ladron> getLadronesConCaracteristicas(String sexo,
			String hobby, String cabello, String senia, String vehiculo) {
		ArrayList<Ladron> sospechosos = (ArrayList<Ladron>) this.ladrones.clone();
		
		if (!(sexo.equals(""))){
			for (Ladron l : new ArrayList<Ladron>(sospechosos)){
				if (! (l.suSexoEs(sexo))){
					sospechosos.remove(l);
				}
			}
		}
		
		if (!(hobby.equals(""))){
			for (Ladron l : new ArrayList<Ladron>(sospechosos)){
				if (! (l.suHobbyEs(hobby))){
					sospechosos.remove(l);
				}
			}
		}
		if (!(cabello.equals(""))){
			for (Ladron l : new ArrayList<Ladron>(sospechosos)){
				if (! (l.suCabelloEs(cabello))){
					sospechosos.remove(l);
				}
			}
		}
		if (!(senia.equals(""))){
			for (Ladron l : new ArrayList<Ladron>(sospechosos)){
				if (! (l.suSeniaEs(senia))){
					sospechosos.remove(l);
				}
			}
		}
		if (!(vehiculo.equals(""))){
			for (Ladron l : new ArrayList<Ladron>(sospechosos)){
				if (! (l.suVehiculoEs(vehiculo))){
					sospechosos.remove(l);
				}
			}
		}
		return sospechosos;
	}
	
	
}
