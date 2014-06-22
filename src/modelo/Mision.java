package modelo;

import modelo.Tiempo;
import modelo.Ladron;

public class Mision {
        private ObjetoRobado objeto;
        private Ladron ladron;
        private RutaDeEscape ruta;
        
        public Mision(Policia poli){
        	//objeto = new ObjetoRobado(poli.getRango());
        	ruta = new RutaDeEscape(poli.getRango());
        	ladron = new Ladron(this.ruta);
        	Tiempo.getInstance();
        }
        
        public Ciudad ciudadComienzo() {
        	return ruta.ciudadComienzo();
        }
        
        public Ladron obtenerLadron() {
        	return ladron;
        }
        
        public boolean ladronEstaEnCiudad(Ciudad c) {
        	return (ruta.ciudadEnRuta(c));
        }

		public String fecha() { 
			return Tiempo.getInstance().fecha();
		}

		public void crearOrdenDeArresto() {
			Tiempo.getInstance().consumirTiempo(3);
		}
}