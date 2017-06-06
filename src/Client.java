import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends Thread
{
	private Socket socket;
	private BufferedReader input; // Riceve i messaggi
	private PrintStream output; // Inviare i messaggi
	
	public Client(String ip, int porta)
	{
		try
		{
			socket = new Socket(ip, porta);
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
		output.println(nome + " [" + new SimpleDateFormat("HH:mm").format(new Date()) + "] : " + msg); // Fabio [23:12] : Ciao mondo !
	}
	
	public void ChiudereConnessione()
	{
		try
		{
			socket.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
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
					Main.ScriviMessaggio(input.readLine());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}