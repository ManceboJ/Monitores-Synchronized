/*
 * La clase VehiculoNorte crea un hilo por cada coche que cruza de norte a sur
 */

public class VehiculoNorte extends Thread{
	
	private int id;
	Cruzar monitor;

	public VehiculoNorte(Cruzar monitor, int id) {
		this.id=id;
		this.monitor = monitor;
		start();
	}
	
	public void run() {
		
		// Informa si hay vehículos cruzando en sentido contrario
		if(monitor.getCruzandoSurNorte() > 0)
			System.out.println("Vehículo número " + id + " esperando en el norte");
		
		// solicita cruzar el puente usando monitores
		try {
			monitor.entrarNorte(id);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// El vehículo tarda un tiempo fijo en cruzar para que no se adelanten unos a otros en el puente
		System.out.println("Vehículo número " + id + " comienza a cruzar desde el norte");		
		try {
			Thread.sleep(200);
		}catch( Exception e) {
			e.printStackTrace();
		}
				
		System.out.println("Vehículo número " + id + " ha terminado de cruzar desde el norte");
		// solicita acceder al monitor para informar de que ha terminado de cruzar
		monitor.salirNorte();		

	}

}
