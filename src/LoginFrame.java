import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener
{
	JTextField txtNome;
	JTextField txtIp;
	JTextField txtPorta;
	
    public LoginFrame()
    {
    	JPanel p = new JPanel(new BorderLayout());
    	JPanel pTop = new JPanel(new FlowLayout());
    	JPanel pGrid = new JPanel(new GridLayout(1, 2));
    	
    	JPanel pLeft = new JPanel(new GridLayout(4, 2));
    	JPanel pRight = new JPanel(new FlowLayout());
    	
    	JLabel lblNome = new JLabel("Nome");
    	txtNome = new JTextField(10);
    	
    	pTop.add(lblNome);
    	pTop.add(txtNome);
    	
    	JLabel lblIp = new JLabel("Ip");
    	txtIp = new JTextField(10);
    	
    	JLabel lblPorta = new JLabel("Porta");
    	txtPorta = new JTextField(5);
    	
    	JButton btnConnect = new JButton("Collegati");
    	btnConnect.addActionListener(this);

    	pLeft.add(lblIp);
    	pLeft.add(txtIp);
    	pLeft.add(lblPorta);
    	pLeft.add(txtPorta);
    	pLeft.add(btnConnect);
    	
    	JButton btnCreaServer = new JButton("Crea un server");
    	btnCreaServer.addActionListener(this);
    	
    	pRight.add(btnCreaServer);
    	
    	pGrid.add(pLeft);
    	pGrid.add(pRight);
    	
    	p.add(pTop, "North");
    	p.add(pGrid, "Center");
    	
    	setContentPane(p);
    	setSize(300, 150);
    	setVisible(true);
    	setTitle("Whatsagram - Login");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent arg0)
    {
    	if(arg0.getActionCommand().equals("Collegati"))
    	{
    		Main.NuovoClient(txtNome.getText(), txtIp.getText(), Integer.parseInt(txtPorta.getText()));
    	}
    	else
    	{
    		Main.NuovoServer(txtNome.getText());
    	}
    	
    	setVisible(false);
    }
}