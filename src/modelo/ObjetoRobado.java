package modelo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class ObjetoRobado {
	protected String objeto;
	protected String ciudad;
	
	public ObjetoRobado(String ciu, String tipoObjeto) {
		try {
			File fXmlFile = new File("recursos/objetosrobados.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		
			NodeList nList = doc.getElementsByTagName(tipoObjeto);			
			Node nodo = nList.item(0);
			
			Element element = (Element) nodo;
			NodeList listaCiu = element.getElementsByTagName("ciudad");
			
			for (int temp = 0; temp < listaCiu.getLength(); temp++) {
				nodo = listaCiu.item(temp);
				element = (Element) nodo;
				if (ciu.equals(element.getAttribute("nombre"))){
					this.objeto = element.getTextContent();
				}
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getObjeto() {
		return objeto;
	}
	
	public abstract boolean esObjetoComun();
	public abstract boolean esObjetoValioso();
	public abstract boolean esObjetoMuyValioso();
}
