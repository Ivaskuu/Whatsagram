import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static ChatFrame cf;
	
	public static void main(String[] args)
	{
		LoginFrame lf = new LoginFrame();
	}
	
	public static void NuovoServer(String n)
	{
		Server s = new Server();
		Client c = new Client("127.0.0.1", 5678);
		
		cf = new ChatFrame(n, c);
	}
	
	public static void NuovoClient(String n, String ip, int porta)
	{
		Client c = new Client(ip, porta);
		cf = new ChatFrame(n, c);
	}
	
	public static void ScriviMessaggio(String messaggio)
	{
		cf.AggiungiMessaggio(messaggio);
	}
}