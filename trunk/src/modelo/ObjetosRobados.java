package modelo;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ObjetosRobados {
	private ArrayList<ObjetoRobado> objetos;

	private static ObjetosRobados INSTANCE = null;
	
	private ObjetosRobados(){
		this.cargarPistas();
	}
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new ObjetosRobados();
	    }
	}
	
	public static ObjetosRobados getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	private void cargarPistas(){
		ArrayList<ObjetoRobado> listaObjetos = new ArrayList<ObjetoRobado>();
		try {
			File fXmlFile = new File("recursos/objetosrobados.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("objetocomun");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String objeto = eElement.getElementsByTagName("objeto").item(0).getTextContent();
					String ciudad = eElement.getElementsByTagName("ciudad").item(0).getTextContent();
					
					ObjetoRobado temporal = new ObjetoComun(ciudad);//lo pongo asi para que no haga error
					listaObjetos.add(temporal);	 
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.objetos = listaObjetos;
		
	}
	
	public void mostrarObjetos(){
		for (ObjetoRobado o : this.objetos){
			System.out.println(o.getObjeto());
		}
	}

}
