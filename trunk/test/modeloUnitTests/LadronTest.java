package modeloUnitTests;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.*;

public class LadronTest {
	@Test
	public void leerPistaLadron() {
		try {
			File fXmlFile = new File("recursos/pistasladrones.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			assertEquals(doc.getFirstChild().getNodeName(),"pistasladrones");
			
			NodeList nList = doc.getElementsByTagName("ladron");			
			Node nodo = nList.item(0);
			assertEquals(nodo.getNodeType(), Node.ELEMENT_NODE);
			assertTrue(nList.getLength()==10);
			
			NodeList listaLadrones = doc.getElementsByTagName("ladron");
			nodo = listaLadrones.item(0);
			assertEquals(nodo.getNodeName(), "ladron");
			Element element = (Element) nodo;
			assertEquals(element.getAttribute("nombre"), "Nick Brunch");
			NodeList listaPista = element.getElementsByTagName("pista");
			assertTrue(listaPista.getLength() == 4);
			nodo = listaPista.item(0);
			assertEquals("El tenia pelo negro.", nodo.getTextContent());
			
			int i = (int)(Math.floor(Math.random()*4));
			assertTrue(i>-1 && i<5);
			
			//nodo = listaPista.item(i);
			//assertEquals("Hablaba de su ultimo ascenso a una montania.", nodo.getTextContent());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
