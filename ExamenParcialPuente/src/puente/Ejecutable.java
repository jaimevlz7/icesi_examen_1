package puente;



public class Ejecutable {
	
	//Clase EJECUTABLE que permite la iniciar todas las otras clases. PUENTE NORTE Y SUR

	public static void main(String main[]){

		Puente p = new Puente();
        Norte n = new Norte(p);
        Sur s = new Sur(p);

        n.start();
        s.start();

    }
	
}






