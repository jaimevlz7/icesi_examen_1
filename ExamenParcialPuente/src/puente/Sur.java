package puente;

import java.util.concurrent.Semaphore;

public class Sur extends Thread {

	
	
	private Puente puente;
	private Semaphore semaforo;
	public Sur(Puente p){
		puente = p;
		int cant = 1 + (int) (Math.random() * 10);

		semaforo = new Semaphore(cant);

	}
	public void run() {

        while (true) {

        	int tiempo = 1 + (int) (Math.random() * 10);
            System.out.println("Llegara un carro en:" + tiempo + " segundos");
            
            puente.setCantS(1);
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
