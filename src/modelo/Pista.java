package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public abstract class Pista {
	protected String pista;
	protected String ciudad;
	protected String edificio;

	public Pista(){
		this.pista = "No se vio a esa persona por aca";
	}

	public Pista(String ciu, String edi, String dificultad, String pistaLadron) {
		this.ciudad = ciu;
		this.edificio = edi;
		try {
			File fXmlFile = new File("recursos/pistas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName(dificultad);			
			Node nodo = nList.item(0);
			
			Element element = (Element) nodo;
			NodeList listaEdi = element.getElementsByTagName(edi);
			
			element = (Element) (listaEdi.item(0));
			NodeList listaCiu = element.getElementsByTagName("ciudad");
						
			for (int temp = 0; temp < listaCiu.getLength(); temp++) {
				nodo = listaCiu.item(temp);
				element = (Element) nodo;
				if (ciu.equals(element.getAttribute("nombre"))){
					this.pista = element.getTextContent();
					if (pistaLadron != null) {
						this.pista = this.pista + " " + pistaLadron;
					}
					break;
				}
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setPista(String pist) {
		this.pista = pist;
	}

	public String getPista() {
		return this.pista;
	}

	public abstract boolean esPistaFacil();
   	public abstract boolean esPistaMedia();
    public abstract boolean esPistaDificil();
    
   // public boolean esPistaDeEdificio(Edificio edi){
   // 	return (this.edificio.equals(edi.getTipo()));
   // }

}
