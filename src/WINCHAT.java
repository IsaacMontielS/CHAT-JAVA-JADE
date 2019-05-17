import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WINCHAT {	
	
	public static void main (String[] args){    
		JFrame frame;
		frame = new JFrame();
	    frame.setSize(new Dimension(300, 350));
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.black);
	    
	    JLabel convLabel = new JLabel("Coversasion:");
	    convLabel.setBounds( 10, 50, 60, 20 ); 
	    convLabel.setForeground(Color.white);
	    panel.add(convLabel);
	    
	    JTextArea msgsArea = new JTextArea(12,20);

	    JScrollPane scrollPane = new JScrollPane(msgsArea); 
	    msgsArea.setEditable(false);
	    panel.add(scrollPane, BorderLayout.NORTH);

	    JLabel msgLabel = new JLabel("Mensajes:");
	    msgLabel.setBounds( 10, 50, 60, 20 ); // x, y, width, height
	    msgLabel.setForeground(Color.white);
	    panel.add(msgLabel);
	    
	    JTextField nwmsg = new JTextField();
	    nwmsg.setPreferredSize(new Dimension(250, 30));
	    panel.add(nwmsg);
	    
	    JButton enviar = new JButton("enviar");
	    panel.add(enviar);
	    
	    enviar.addActionListener(new ActionListener() {
			private String nuevoMsg;
			@Override
			public void actionPerformed(ActionEvent e) {
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				 LocalDateTime now = LocalDateTime.now();
				 this.nuevoMsg = nwmsg.getText().toString();
				 msgsArea.append(dtf.format(now) + "\n");
				 msgsArea.append("-->"+this.nuevoMsg + "\n");
			}
	    });
	    frame.getContentPane().add(panel);
	    frame.setVisible(true);
	}
}
