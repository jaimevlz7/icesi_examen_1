package puente;

import java.util.concurrent.Semaphore;

//Clase Norte

public class Norte extends Thread {

	//Atributos de la clase: conexión con clase puente. Inicializacion del semaforo para sincronizar.
	
	private Puente puente;
	private Semaphore semaforo;
	
	
	// Constructor de la clase
	public Norte(Puente p){
		puente = p;
		
	//creo el math.random(); para que el semaforo me permita pasar x cantidad entre 1 y 10
    	int cant = 1 + (int) (Math.random() * 10);

		semaforo = new Semaphore(cant);

	}
	//metodo run() creacion del hilo y permitir agregar carros cada y tiempo
	public void run() {

        while (true) {

        	int tiempo = 1 + (int) (Math.random() * 10);
            System.out.println("Llegara un carro en:" + tiempo + " segundos");
            puente.setCantN(1);
            try {
                sleep(tiempo * 1000);
            } catch (InterruptedException e) {
				
            }
            try {
				semaforo.acquire();
				puente.transitar();
				semaforo.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
            
        }
    }
}
