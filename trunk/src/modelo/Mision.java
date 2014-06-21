package modelo;

import modelo.Tiempo;
import modelo.Ladron;

public class Mision {
        private ObjetoRobado objeto;
        private Ladron ladron;
        private Tiempo tiempo;
        private RutaDeEscape ruta;
        
        public Mision(int rango){
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

		public String fecha(){ 
			return tiempo.fecha();
		}

		public void crearOrdenDeArresto() {
			tiempo.consumirTiempo(3);
		}
		
		public Tiempo getTiempo(){
			return this.tiempo;
		}

		public void consumirTiempo(int tiemp){
			this.tiempo.consumirTiempo(tiemp);
			if (this.tiempo.terminoTiempo()){
				this.perdioMision();
			}
		}

		private void perdioMision() {
			
		}
}