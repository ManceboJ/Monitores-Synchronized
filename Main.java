/*
 * Programa para la parte 2 de la segunda actividad de Programación concurrente y distribuida de la UE
 * En el main tenemos tres tandas separadas entre ellas por un tiempo definido
 * En las rondas creamos coches en diferentes ordenes para comprobar que:
 * - No cruzan vehículos desde ambos extremos a la vez, esperar a que el puente este libre
 * - Si un vechículo llega y hay otro cruzando en el mismo sentido empieza a cruzar en lugar de esperar
 */

public class Main {

	public static void main(String[] args) {
		
		Cruzar monitor = new Cruzar();
		int id= 0;
		int tiempoNuevoCocheNorte = 4000;
		

		System.out.println("----------------Primera ronda de vehículos----------------");
			for(int i=0; i<3; i++) {
				new VehiculoSur(monitor, ++id);
			}
			
			for(int i = 0; i<3 ; i ++) {
				new VehiculoNorte(monitor, ++id);
			}
			
			new VehiculoSur(monitor, ++id);
			new VehiculoNorte(monitor, ++id);
			
			try {
				Thread.sleep(tiempoNuevoCocheNorte);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("\n----------------Segunda ronda de vehículos----------------");
			for(int i=0; i<3; i++) {
				new VehiculoNorte(monitor, ++id);
			}

			for(int i = 0; i<3 ; i ++) {
				new VehiculoSur(monitor, ++id);
			}
						
			new VehiculoNorte(monitor, ++id);
			new VehiculoSur(monitor, ++id);
			
			try {
				Thread.sleep(tiempoNuevoCocheNorte);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("\n----------------Tercera ronda de vehículos----------------");
			for(int i=0; i<2; i++) {
				new VehiculoSur(monitor, ++id);
				new VehiculoNorte(monitor, ++id);
			}
			
			for(int i=0; i<2; i++) {
				new VehiculoSur(monitor, ++id);
			}
			
			for(int i=0; i<2; i++) {
				new VehiculoNorte(monitor, ++id);
			}
			
			try {
				Thread.sleep(tiempoNuevoCocheNorte);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
