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

public class Prolab2_2 extends JFrame {
	
	private static Node root = null;
	public static int RootX;
	public static int RootY;
	
	public static int ParentX;
	public static int ParentY;
	
	public static int ParentTopX;
	public static int ParentTopY;
	
	public static int ParentBotX;
	public static int ParentBotY;
	
	
	public static boolean Control=false;
    private JFrame pencere = new JFrame(); 
    private JLabel labelUsername = new JLabel("Hoþ Geldiniz");
    private JButton buttonRandom = new JButton("Random Number");
    private JButton buttonNaNRandom = new JButton("Randomsuz");
    protected static int click =0;
     
    public Prolab2_2() {
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
			    Graphics g = pencere.getGraphics();
				int x=e.getX();
			    int y=e.getY();
			    
			    if(Control == false)
			    {
			    	
			    	Control=true;
			    	for(int i =0;i<512;i++)
			    	{
			    		g.drawString("-", i, y);
			    		g.drawString("|", x, i);
			    	}
			    	RootX =x;
			    	RootY =y;
			    	insert(x,y,512,0,512,0,1);
			    	
			    }else
			    {
			    	insert(x,y,0,0,0,0,0);
			    	if(x<ParentX && y<ParentY) //2.bolge
			    	{
			    		int maxX=0,minX=0,maxY=0,minY=0;
			    		
			    		minX = ParentBotX;
			    		maxX = ParentX;
			    		
			    		maxY = ParentY;
			    		minY = ParentTopY;
			    		
			    		for(int i=minX;i<maxX;i++)
			    		{
			    			g.drawString("-",i,y);
			    		}
			    		
			    		for(int i=minY; i < maxY ;i++)
			    		{
			    			g.drawString("|",x,i);
			    		}
			    		
			    		insert(x,y,maxX,minX,maxY,minY,1);
			    	}
			    	if(x<ParentX && y>ParentY) // 3. bolge
			    	{
			    		int maxX=0,minX=0,maxY=0,minY=0;
			    		
			    		minX = ParentBotX;
			    		maxX = ParentX;
			    		
			    		maxY = ParentBotY;
			    		minY = ParentY;
			    		
			    		for(int i=minX;i<maxX;i++)
			    		{
			    			g.drawString("-",i,y);
			    		}
			    		
			    		for(int i=minY; i < maxY ;i++)
			    		{
			    			g.drawString("|",x,i);
			    		}
			    		
			    		insert(x,y,maxX,minX,maxY,minY,1);
			    	}
			    	if(x>ParentX && y<ParentY) // 1. bolge
			    	{
			    		int maxX=0,minX=0,maxY=0,minY=0;
			    		
			    		minX = ParentX;
			    		maxX = ParentTopX;
			    		
			    		maxY = ParentY;
			    		minY = ParentTopY;
			    		
			    		for(int i=minX;i<maxX;i++)
			    		{
			    			g.drawString("-",i,y);
			    		}
			    		
			    		for(int i=minY; i < maxY ;i++)
			    		{
			    			g.drawString("|",x,i);
			    		}
			    		
			    		insert(x,y,maxX,minX,maxY,minY,1);
			    		
			    		
			    	}
			    	if(x>ParentX && y>ParentY) //4. bolge
			    	{
			    		int maxX=0,minX=0,maxY=0,minY=0;
			    		
			    		minX=ParentX;
			    		maxX=ParentTopX;
			    		minY=ParentY;
			    		maxY=ParentBotY;
			    		
			    		for(int i=minX; i<maxX ;i++)
			    		{
			    			g.drawString("-",i,y);
			    		}
			    		
			    		for(int i=minY; i < maxY ;i++)
			    		{
			    			g.drawString("|",x,i);
			    		}
			    		
			    		insert(x,y,maxX,minX,maxY,minY,1); 
			    	}
			    }
			   
			    g.drawString("X", x, y);
				
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
        		  pencere.setVisible(true);
        	  } 
        	} );
        
        buttonNaNRandom.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		display(root);
        		System.out.println("______________________________");
        	}
        });
    }
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prolab2_2().setVisible(true);
            }
        });
        
        
    }
    public static void insert(int x,int y,int maxX,int minX,int maxY,int minY,int kontrol)
	{
		Node newNode = new Node(x,y,maxX,minX,maxY,minY,kontrol);
		if(root==null){		
			ParentX = x;
			ParentY = y;
			
			ParentTopX = 0;
			ParentTopY = 0;
			ParentBotX = 512;
			ParentBotY = 512;
			
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true){
			parent = current;
			if(x < current.x && y < current.y){ //2.Bolge		
				if(current != null)
				{
					ParentX = current.x;
					ParentY = current.y;
					
					ParentTopX = current.TopX;
					ParentTopY = current.TopY;
					
					ParentBotX = current.BottomX;
					ParentBotY = current.BottomY;
				}
				
				current = current.x1y1;
				
				if(current==null){
					if(kontrol == 0)
					{
						return;
					}else
					{
						parent.x1y1 = newNode;
						return;
					}
					
					
				}
			}else if(x < current.x && y > current.y){ //3.Bolge
				if(current != null)
				{
					ParentX = current.x;
					ParentY = current.y;
					
					ParentTopX = current.TopX;
					ParentTopY = current.TopY;
					ParentBotX = current.BottomX;
					ParentBotY = current.BottomY;
				}
				
				current = current.x1y2;
				
				if(current==null){
					if(kontrol == 0)
					{
						return;
					}else
					{
						parent.x1y2 = newNode;
						return;
					}
				}
			}
				else if(x > current.x && y > current.y){ //4.Bolge
					if(current != null)
					{
						ParentX = current.x;
						ParentY = current.y;
						
						ParentTopX = current.TopX;
						ParentTopY = current.TopY;
						ParentBotX = current.BottomX;
						ParentBotY = current.BottomY;
					}
					
					current = current.x2y2;
					
					if(current==null){
						if(kontrol == 0)
						{
							return;
						}else
						{
							parent.x2y2 = newNode;
							return;
						}
					}
				}
				else if(x > current.x && y < current.y){ //1.Bolge
					if(current != null)
					{
						ParentX = current.x;
						ParentY = current.y;
						
						ParentTopX = current.TopX;
						ParentTopY = current.TopY;
						ParentBotX = current.BottomX;
						ParentBotY = current.BottomY;
						
					}
					
					current = current.x2y1;
					
					if(current==null){
						if(kontrol == 0)
						{
							return;
						}else
						{
							parent.x2y1 = newNode;
							return;
						}
					}
				}
			}
	}
    public static void display(Node gecici)
	{
		if(gecici!=null)
		{
			System.out.println("Values: x: " + gecici.x + " - y: " + gecici.y);
			display(gecici.x2y2);
			display(gecici.x1y2);
			display(gecici.x1y1);
			display(gecici.x2y1);					
		}	
	}
    
}

