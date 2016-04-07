package puente;

import java.util.concurrent.Semaphore;

public class Puente {

	//Atributos de clase. tiene constante de capacidad máxima. Verificadores de quien esta transitando(boolean norte y suer)
	//Unos int que expresan la cantidad de carros que se encuentran en cada lado(int cantS y cantN)
	//Semaforo para la validacion de cuantos carros transiten por cada lado.
	
	public final static int CAP_MAX = 10;
	private boolean norte;
	private boolean sur;
	private int cantS;
	private int cantN;
	private Semaphore semaforo;
	
	//constructor de la clase con inicializacion de los atributos.
	
	public Puente(){
		norte=false;
		sur = false;
		cantS=0;
		cantN=0;
		semaforo = new Semaphore(1);

	}
	
	//Metodo transitar, permite y da el pase de carros o de norte o sur, dependiendo de la condición de quién pase o no. Haciendo un llamado
	//los metodos transitarSur() y transitarNorte() que da paso a los carros de ese lado en el que esta.
	public void transitar(){
		if(norte ==false && sur == false){
			norte = true;
			transitarNorte();
			System.out.println("Esta transitando norte");
		}
		if(norte==true){
			norte = false;
			sur = true;		
			transitarSur();
			System.out.println("Esta transitando sur");
		}else{
			sur = false;
			norte = true;
			System.out.println("Esta transitando norte");
		}
	}
	//Metodos tansitarSur() y transitarNorte() hacen lo mismo solo que en los lados diferentes.
	private void transitarSur() {
		if(cantS <= CAP_MAX){
			cantS = 0;
			System.out.println("Cantidad de carros en sur:" + cantS);

		}else{
			cantS-=10;
			System.out.println("Cantidad de carros en sur:" + cantS);
		}
	}
	private void transitarNorte() {
		if(cantN <= CAP_MAX){
			cantN = 0;
			System.out.println("Cantidad de carros en norte:" + cantN);

		}else{
			cantN-=10;
			System.out.println("Cantidad de carros en norte:" + cantN);

		}
	}
	//Metodos get and set *****
	public boolean isNorte() {
		return norte;
	}
	public void setNorte(boolean norte) {
		this.norte = norte;
	}
	public boolean isSur() {
		return sur;
	}
	public void setSur(boolean sur) {
		this.sur = sur;
	}
	public static int getCapMax() {
		return CAP_MAX;
	}
	public void setCantN(int cant) {
		this.cantN+=cant;
	}
	public void setCantS(int cant) {
		this.cantS+=cant;
	}
	
}
