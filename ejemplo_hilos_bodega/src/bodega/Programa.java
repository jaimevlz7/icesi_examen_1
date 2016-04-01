package bodega;

import static java.lang.Thread.sleep;


public class Programa {
    
	public static void main(String main[]){

        Bodega bode = new Bodega();

        Descargador procesoDescarga = new Descargador(bode);
        Empacador procesoCarga=new Empacador(bode);

        procesoDescarga.start();
        procesoCarga.start();

    }
    
}
