/*
 * En la clase Cruzar implementamos los metodos synchronized del monitor para controlar el acceso del puente
 * En java los monitores garantizan que solo accede un hilo a la vez y que lo hacen respetando el orden de llegada,
 * por ello los vehículo comenzaran a cruzar según el orden de llegada.
 */

public class Cruzar {
	
	// variables para contar cuantos vehículos estan cruzando en un sentido
	private static int cruzandoNorteSur = 0;
	private static int cruzandoSurNorte = 0;

	 public synchronized void entrarNorte(int id) throws InterruptedException {	  
		 while (cruzandoSurNorte > 0) { 	// comprueba si hay vechículos cruzando en sentido contrario
			 wait();	// pausa el hilo
		     }
		 cruzandoNorteSur++;	// incrementa el número de vehículos que están cruzando en este sentido
		 }

	  public synchronized void entrarSur() throws InterruptedException {
		  while (cruzandoNorteSur > 0) { 	// comprueba si hay vechículos cruzando en sentido contrario
		      wait();	// pausa el hilo
		      }
		  
		  cruzandoSurNorte++;	// incrementa el número de vehículos que están cruzando en este sentido
		  }

	  public synchronized void salirNorte() {
		  cruzandoNorteSur--;	// decrementa el número de vehículos que están cruzando en este sentido
		  notifyAll();	// despierta todos los hilos que esten esperando  
		  }

	  public synchronized void salirSur() {
		  cruzandoSurNorte--;	// decrementa el número de vehículos que están cruzando en este sentido
		  notifyAll();	// despierta todos los hilos que esten esperando
		  }
		  
	  public static int getCruzandoNorteSur() {
		  return cruzandoNorteSur;
		  }

	  public static int getCruzandoSurNorte() {
		  return cruzandoSurNorte;
		  }
}
