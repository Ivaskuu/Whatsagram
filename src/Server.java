import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class Server extends Thread
{
	final int PORTA = 5678;
	
	private ServerSocket ss;
	private Socket[] clienti;
	
	private BufferedReader[] input; // Riceve i messaggi
	private PrintStream[] output; // Inviare i messaggi
	
	public Server()
	{
		try
		{
			ss = new ServerSocket(PORTA);
			clienti = new Socket[2];
			input = new BufferedReader[2];
			output = new PrintStream[2];
			
			start();
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
			for(int i = 0; i < 2; i++)
			{
				System.out.println("In attesa del " + (i+1) + " client...");
				clienti[i] = ss.accept();
				input[i] = new BufferedReader(new InputStreamReader(clienti[i].getInputStream()));
				output[i] = new PrintStream(clienti[i].getOutputStream());
								
				System.out.println("Il client " + (i+1) + " si e collegato.");
			}
			
			System.out.println("I clienti si sono collegati entrambi.");
			
			while(true)
			{
				for(int i = 0; i < 2; i++)
				{
					if(input[i].ready())
					{
						String msg = input[i].readLine();
						
						for(int j = 0; j < 2; j++)
						{
							output[j].println(msg);
						}
					}
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}