import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.w3c.dom.events.MouseEvent;

public class SwingJPanelDemo extends JFrame {
    private JFrame pencere = new JFrame(); 
    
    private JLabel labelUsername = new JLabel("Hoþ Geldiniz");
    private JLabel labelPassword = new JLabel("Enter password: ");
    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonRandom = new JButton("Random Number");
    private JButton buttonNaNRandom = new JButton("Randomsuz");
    protected static int click =0;
     
    public SwingJPanelDemo() {
        super("JPanel Demo Program");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 10;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
      
        newPanel.add(buttonRandom, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        //constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonNaNRandom, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "QuarTree ProlabII-II"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
        
        pencere.setSize(512,512);
    	pencere.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX();
			    int y=e.getY();
			    Graphics g = pencere.getGraphics();
			    g.drawString("X", x, y);
				System.out.println("Hello world coordinatX " + x +" | coordinat Y " + y +" | " + click);
				
				click++;
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

    		
    	});
        
        buttonRandom.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  mundi();
        	  } 
        	} );
    }
    public void mundi()
    {
    	pencere.setVisible(true);
    	
    }
    
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingJPanelDemo().setVisible(true);
            }
        });
        
        
    }
}
