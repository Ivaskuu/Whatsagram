import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Thread
{
	private BufferedReader input; // Riceve i messaggi
	private PrintStream output; // Inviare i messaggi
	
	public Client(String ip, int porta)
	{
		try
		{
			Socket socket = new Socket(ip, porta);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintStream(socket.getOutputStream());
			
			start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void InviaMessaggio(String nome, String msg)
	{
		output.println(nome + " : " + msg); // Fabio : Ciao mondo !
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				// TODO : Ricevere i messaggi
				if(input.ready())
				{
					System.out.println(input.readLine());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
