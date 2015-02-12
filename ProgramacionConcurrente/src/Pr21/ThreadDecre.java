package Pr21;

public class ThreadDecre extends Thread{

	public void run(){
		Main.varComp -= 1;
	}

}
