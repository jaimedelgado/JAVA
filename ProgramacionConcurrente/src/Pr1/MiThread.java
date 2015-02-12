package Pr1;

public class MiThread extends Thread{

	private int id;
	private int time;
	
	public MiThread(){
		this.id = 0;
		this.time = 0;
	}
	
	public MiThread(int id, int time){
		this.id = id;
		this.time = time;
	}
	
	public void run(){
		System.out.println("Primer print, Thread: " +  this.id);
		
		try {
			sleep(this.time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Segundo print, Thread: " +  this.id);
	}
}
