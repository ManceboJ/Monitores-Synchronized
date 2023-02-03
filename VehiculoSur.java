/*
 * La clase VehiculoSur crea un hilo por cada coche que cruza de sur a norte
 */

public class VehiculoSur extends Thread{
	
	private int id;
	Cruzar monitor;

	
	public VehiculoSur(Cruzar monitor, int id) {
		this.id=id;
		this.monitor = monitor;
		start();
	}
	
	public void run() {
		
		// Informa si hay veh�culos cruzando en sentido contrario
		if(monitor.getCruzandoNorteSur() > 0)
			System.out.println("Veh�culo n�mero " + id + " esperando en el sur");	
		
		// solicita cruzar el puiente usando monitores
		try {
			monitor.entrarSur();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// El veh�culo tarda un tiempo fijo en cruzar para que no se adelanten unos a otros en el puente
		System.out.println("Veh�culo n�mero " + id + " comienza a cruzar desde el sur");
		try {
			Thread.sleep(200);
		}catch( Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Veh�culo n�mero " + id + " ha terminado de cruzar desde el sur");
		// solicita acceder al monitor para informar de que ha terminado de cruzar
		monitor.salirSur();

	}

	
}
