import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatFrame extends JFrame implements ActionListener
{
	JTextArea txtMessaggi;
	JTextField txtMsg;
	
    public ChatFrame()
    {
    	JPanel p = new JPanel(new BorderLayout());
    	p.setLayout(new BorderLayour());
    	JPanel pSouth = new JPanel(new BorderLayout());
    	
    	txtMessaggi = new JTextArea();
    	txtMsg = new JTextField(5);
    	
    	JButton btnInvia = new JButton("Invia");
    	btnInvia.addActionListener(this);
    	
    	pSouth.add(txtMsg, "Center");
    	pSouth.add(btnInvia, "East");

    	p.add(txtMessaggi, "Center");

    	setContentPane(p);
    	setSize(500, 300);
    	setVisible(true);
    }
    
    public void AggiungiMessaggio(String msg)
    {
    	txtMessaggi.setText(txtMessaggi.getText() + "\n" + msg);
    }
    
    public void actionPerformed(ActionEvent arg0)()
    {
    	if(arg0.getActionCommand().equals("Invia")
    		&& txtMsg.getText().trim() != "")
    	{
    		//Client.InviaAlServer(txtMsg.getText());
    	}
    }
}