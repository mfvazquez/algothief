package control;

import control.Tiempo;
import control.Ladron;

public class Mision {
       // private ObjetoRobado objeto;
        private Ladron ladron;
        private Tiempo tiempo;
        private RutaDeEscape ruta;
        
        public Mision(String rango){
        	//objeto = new ObjetoRobado(rango);
        	ruta = new RutaDeEscape(rango);
        	ladron = new Ladron(this.ruta);
        	tiempo = new Tiempo();
        }
        
        public Ciudad ciudadComienzo() {
        	return ruta.ciudadComienzo();
        }
        
        public Ladron obtenerLadron() {
        	return ladron;
        }
        
        public boolean ladronEstaEnCiudad(Ciudad c){
        	return (ruta.ciudadEnRuta(c));
        }
}