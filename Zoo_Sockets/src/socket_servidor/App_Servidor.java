package socket_servidor;

public class App_Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor s = new Servidor();
		Thread t = new Thread(s);
		t.start();
	}

}
