import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatFrame extends JFrame implements ActionListener
{
	JTextArea txtMessaggi;
	JTextField txtMsg;
	Client client;
	String nome;
	
    public ChatFrame(String n, Client c)
    {
    	nome = n;
    	client = c;
    	
    	JPanel p = new JPanel(new BorderLayout());
    	JPanel pSouth = new JPanel(new BorderLayout());
    	
    	txtMessaggi = new JTextArea();
    	txtMessaggi.setWrapStyleWord(true);
    	
    	txtMsg = new JTextField(5);
    	
    	JButton btnInvia = new JButton("Invia");
    	btnInvia.addActionListener(this);
    	
    	pSouth.add(txtMsg, "Center");
    	pSouth.add(btnInvia, "East");

    	p.add(txtMessaggi, "Center");
    	p.add(pSouth, "South");

    	setContentPane(p);
    	setSize(500, 300);
    	setVisible(true);
    	setTitle("Whatsagram");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void AggiungiMessaggio(String msg)
    {
    	txtMessaggi.setText(txtMessaggi.getText() + "\n" + msg);
    }
    
    public void actionPerformed(ActionEvent arg0)
    {
    	if(arg0.getActionCommand().equals("Invia")
    		&& txtMsg.getText().trim() != "")
    	{
    		client.InviaMessaggio(nome, txtMsg.getText());
    		txtMsg.setText("");
    	}
    }
}