import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args)
	{
		char scelta;
		String msg;
		String nome;
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader tast = new BufferedReader(in);
		
		try
		{
			/* -=-=-= MENU =-=-=-*/
			System.out.print("\n-=-=-= MENU =-=-=-\n"
					+ "[1] Fare da server\n"
					+ "[2] Fare da client\n"
					+ "[0] ===> Uscire\n"
					+ "\nScelta : "
			);
			
			scelta = tast.readLine().charAt(0);
			
			
			if(scelta == '1')
			{
				Server server = new Server();
			}

			Client client = new Client("127.0.0.1", 5678);
			
			System.out.print("Inserisca il suo nome : ");
			nome = tast.readLine();
			
			do
			{
				msg = tast.readLine();
				
				if(msg == "QUIT")
				{
					// TODO : Chiudere la connessione
				}
				else
				{
					client.InviaMessaggio(nome, msg);
				}
			}
			while(true);
		}
		catch(Exception ex)
		{
			System.out.println("Errore : " + ex);
		}
	}
}