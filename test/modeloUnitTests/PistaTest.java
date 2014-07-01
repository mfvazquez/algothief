package modeloUnitTests;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import modelo.*;

public class PistaTest {

	@Test
	public void pistaPorDefectotest() {
		Pista pist = new PistaFacil();
		assertEquals("No se vio a esa persona por aca", pist.getPista());
	}
	
	@Test
	public void constructorConPista(){
		Pista pist = new PistaFacil();
		pist.setPista("Tenia el pelo rubio");
		assertEquals("Tenia el pelo rubio", pist.getPista());
	}
	
	@Test
	public void leerPista() {
		PistaFacil pista = new PistaFacil("Buenos Aires", "aeropuerto", null);
		assertEquals(pista.getPista(), "Se fue en un avion de bandera celeste y blanca.");
		PistaMedia pistaM = new PistaMedia("Buenos Aires", "banco", null);
		assertEquals(pistaM.getPista(), "Dijo estar preocupado por la posibilidad de default.");
		PistaDificil pistaF = new PistaDificil("Buenos Aires", "biblioteca", null);
		assertEquals(pistaF.getPista(), "Pidio el 'Martin Fierro'.");
	}

	@Test
	public void leerArchivo() {
		try {
			File fXmlFile = new File("recursos/pistas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			assertEquals(doc.getFirstChild().getNodeName(),"pistas");
			
			String dificultad = "pistasfacil";
			NodeList nList = doc.getElementsByTagName(dificultad);			
			Node nodo = nList.item(0);
			assertEquals(nodo.getNodeType(), Node.ELEMENT_NODE);
			assertTrue(nList.getLength()==1);
			
			Element element = (Element) nodo;
			NodeList listaEdi = element.getElementsByTagName("aeropuerto");
			assertTrue(listaEdi.getLength()==1);
			assertEquals(listaEdi.item(0).getNodeName(), "aeropuerto");
			
			element = (Element) (listaEdi.item(0));
			NodeList listaCiu = element.getElementsByTagName("ciudad");
			assertTrue(listaCiu.getLength()==30);
			
			nodo = listaCiu.item(1);
			assertEquals(nodo.getNodeName(),"ciudad");
			element = (Element) nodo;
			assertEquals(element.getTagName(), "ciudad");
			assertEquals(element.getAttribute("nombre"), "Buenos Aires");
			assertEquals(element.getTextContent(), "Se fue en un avion de bandera celeste y blanca.");
			assertEquals(element.getElementsByTagName("pista").item(0).getTextContent(),"Se fue en un avion de bandera celeste y blanca.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
