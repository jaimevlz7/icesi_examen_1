package puente;

import java.util.concurrent.Semaphore;

public class Puente {

	public final static int CAP_MAX = 10;
	private boolean norte;
	private boolean sur;
	private int cantS;
	private int cantN;
	private Semaphore semaforo;
	
	public Puente(){
		norte=false;
		sur = false;
		cantS=0;
		cantN=0;
		semaforo = new Semaphore(1);

	}
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
