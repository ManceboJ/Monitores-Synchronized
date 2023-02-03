/*
 * En la clase Cruzar implementamos los metodos synchronized del monitor para controlar el acceso del puente
 * En java los monitores garantizan que solo accede un hilo a la vez y que lo hacen respetando el orden de llegada,
 * por ello los veh�culo comenzaran a cruzar seg�n el orden de llegada.
 */

public class Cruzar {
	
	// variables para contar cuantos veh�culos estan cruzando en un sentido
	private static int cruzandoNorteSur = 0;
	private static int cruzandoSurNorte = 0;

	 public synchronized void entrarNorte(int id) throws InterruptedException {	  
		 while (cruzandoSurNorte > 0) { 	// comprueba si hay vech�culos cruzando en sentido contrario
			 wait();	// pausa el hilo
		     }
		 cruzandoNorteSur++;	// incrementa el n�mero de veh�culos que est�n cruzando en este sentido
		 }

	  public synchronized void entrarSur() throws InterruptedException {
		  while (cruzandoNorteSur > 0) { 	// comprueba si hay vech�culos cruzando en sentido contrario
		      wait();	// pausa el hilo
		      }
		  
		  cruzandoSurNorte++;	// incrementa el n�mero de veh�culos que est�n cruzando en este sentido
		  }

	  public synchronized void salirNorte() {
		  cruzandoNorteSur--;	// decrementa el n�mero de veh�culos que est�n cruzando en este sentido
		  notifyAll();	// despierta todos los hilos que esten esperando  
		  }

	  public synchronized void salirSur() {
		  cruzandoSurNorte--;	// decrementa el n�mero de veh�culos que est�n cruzando en este sentido
		  notifyAll();	// despierta todos los hilos que esten esperando
		  }
		  
	  public static int getCruzandoNorteSur() {
		  return cruzandoNorteSur;
		  }

	  public static int getCruzandoSurNorte() {
		  return cruzandoSurNorte;
		  }
}
