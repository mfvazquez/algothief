package modelo;

import modelo.Tiempo;
import modelo.Ladron;

public class Mision {
        private ObjetoRobado objeto;
        private Ladron ladron;
        private RutaDeEscape ruta;
        
        public Mision(Policia poli, Ladron ladri){
        	ruta = new RutaDeEscape(poli.getRango());
        	objeto = poli.getRango().elegirObjetoRobado(ruta.ciudadComienzo().getNombre());
        	ladron = ladri;
        	ruta.agregarLadron(ladron);
        }
        
        public Ciudad ciudadComienzo() {
        	return ruta.ciudadComienzo();
        }
        
        public Ladron obtenerLadron() {
        	return ladron;
        }
        
        // Posiblemente haya que sacar este metodo, a menos que mision sea el encargado de manejar el tiempo
        public String fecha() { 
			return Tiempo.getInstance().fecha();
		}

		public void crearOrdenDeArresto() {
			Tiempo.getInstance().consumirTiempo(3);
		}
}