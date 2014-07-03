package modelo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ladron {
	private String nombre;
	private String sexo;
	private String hobby;
	private String cabello;
	private String senia;
	private String vehiculo;
    private RutaDeEscape ruta;
    private Armas armas;
    

    public Ladron(){
    	nombre = new String();
    	sexo = new String();
    	hobby = new String();
    	cabello = new String();
    	senia = new String();
    	vehiculo = new String();
    	armas = new Armas();
    }
    
    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo){
    	this.nombre = nombre;
    	this.sexo = sexo;
    	this.hobby = hobby;
    	this.cabello = cabello;
    	this.senia = senia;
    	this.vehiculo = vehiculo;
    	armas = new Armas();
    }
    
    public Ladron(RutaDeEscape r) {
    //La ruta la crea la mision que conoce el rango del policía
    	this.ruta = r;
    }
    
    public String getNombre(){
    	return this.nombre;
    }
    
    public boolean suSexoEs(String sexo){
    	return (this.sexo.equals(sexo));
    }
    
    public String getSexo(){
    	return sexo;
    }

    public boolean suHobbyEs(String hobby){
    	return (this.hobby.equals(hobby));
    }

    public boolean suCabelloEs(String pelo){
    	return (this.cabello.equals(pelo));
    }
    
    public boolean suSeniaEs(String senia){
    	return (this.senia.equals(senia));
    }
    
    public boolean suVehiculoEs(String vehiculo){
    	return (this.vehiculo.equals(vehiculo));
    }

	public String getPista() {
		String pistaLadron = null;
		try {
			File fXmlFile = new File("recursos/pistasladrones.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList listaLadrones = doc.getElementsByTagName("ladron");			
			Node nodo;
			Element element;
			
			for (int temp = 0; temp < listaLadrones.getLength(); temp++) {
				nodo = listaLadrones.item(temp);
				element = (Element) nodo;
				if (this.nombre.equals(element.getAttribute("nombre"))){
					NodeList listaPista = element.getElementsByTagName("pista");
					//elige aleatoriamente entre las 4 pistas posibles
					nodo = listaPista.item((int)(Math.floor(Math.random()*4)));
					pistaLadron = nodo.getTextContent();
					break;
				}
			}
				
						
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pistaLadron;
	}

	public void defenderse(){
		int demora = armas.getDemora();
		Tiempo.getInstance().consumirTiempo(demora);
	}
	
	public String getArma(){
		return armas.getArma();
	}

}
