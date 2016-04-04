package puente;

import java.util.concurrent.Semaphore;

public class Norte extends Thread {

	
	
	private Puente puente;
	private Semaphore semaforo;
	
	public Norte(Puente p){
		puente = p;
	}
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
