package modelo;

import modelo.Ladron;

public class Mision {
        private ObjetoRobado objeto;
        private Ladron ladron;
        private RutaDeEscape ruta;
        
        public Mision(Policia poli, Ladron ladri){
        	ruta = new RutaDeEscape(poli.getRango(), ladri);
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
        
		
		public String objetoRobadoStr(){
			return objeto.getObjeto();
		}
		
		public String sexoLadron(){
			return ladron.getSexo();
		}
}