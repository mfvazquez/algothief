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
        	ladron = new Ladron();
        	tiempo = new Tiempo();
        	ruta = new RutaDeEscape(rango);
        }
        
        public Ciudad ciudadComienzo() {
        	return ruta.ciudadComienzo();
        }
}