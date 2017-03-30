import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Prolab2_2 extends JFrame {
	public static boolean btnControl = false;
	private static Node root = null;	
	public static int asciiCode=65; 
	public static int ParentX;
	public static int ParentY;
	public static int ParentTopX;
	public static int ParentTopY;
	public static int ParentBotX;
	public static int ParentBotY;

	public static boolean Control=false;
    private static JFrame pencere = new JFrame(); 
    private JLabel labelUsername = new JLabel("Ho� Geldiniz");
    private JButton buttonClick = new JButton("Click");
    private JButton buttonRandom = new JButton("Random");
    private JButton buttonClear = new JButton("Temizle");
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
        //constraints.weightx=150;
      
        newPanel.add(buttonClick, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        //constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonRandom, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 10;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonClear, constraints);
         
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "QuarTree ProlabII-II"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);
        
        pencere.setSize(512,512);
		pencere.setVisible(true);
		
    	pencere.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(btnControl)
				{
					Draw(e.getX(),e.getY());
				}
				
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
        
    	buttonClick.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  Clear();
        		  btnControl = true;
        	  } 
        	} );
        
        buttonRandom.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		Clear();
        		Random();
        		btnControl = false;

        	}
        });
        buttonClear.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		Clear();
        		
        	}
        });
    }
    public static void Random()
    {
    	  int x,y,tmp;
    	  int [] coordinatesX = new int[512];
    	  int [] coordinatesY = new int[512];
    	  for(int i=0;i<512;i++)
    	  {
    		  coordinatesX[i] =i;
    		  coordinatesY[i] =i;
    	  }
    	  for(int i=0;i<512;i++)
    	  {
    		  x = (int)(Math.random() * 512);
    		  y = (int)(Math.random() * 512);
    		  
    		  tmp = coordinatesX[i];
			  coordinatesX[i] = coordinatesX[x];
			  coordinatesX[x] = tmp;
			  
			  tmp = coordinatesY[i];
			  coordinatesY[i] = coordinatesY[x];
			  coordinatesY[x] = tmp;
    	  }
		  for(int i=0;i<20;i++)
		  {
			  Draw(coordinatesX[i],coordinatesY[511-i]);
		  }
    }
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prolab2_2().setVisible(true);
            }
        });
    }
    public static void insert(int x,int y,int maxX,int minX,int maxY,int minY,int kontrol,String Name)
	{
		Node newNode = new Node(x,y,maxX,minX,maxY,minY,kontrol,Name); // yeni dugum olustur
		if(root==null){	// ana dugumu olustur	
			ParentX = x;
			ParentY = y;
			ParentTopX = 0; //baslangic max degerlerini ata
			ParentTopY = 0;
			ParentBotX = 512;
			ParentBotY = 512;
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true){ // hedef dugume gidene kadar bam bam bam ilerle
			parent = current;
			if(x < current.x && y < current.y){ //2.Bolge		
				if(current != null) // parent bilgileri al
				{
					ParentX = current.x;
					ParentY = current.y;			
					ParentTopX = current.TopX;
					ParentTopY = current.TopY;
					ParentBotX = current.BottomX;
					ParentBotY = current.BottomY;
				}
				current = current.x1y1; //sonraki dugume ilerle
				if(current==null){
					if(kontrol == 0) //parent bilgileri al ve geri don
					{
						return;
					}else
					{
						parent.x1y1 = newNode; // yeni dugum ekle
						return;
					}
					
					
				}
			}else if(x < current.x && y > current.y){ //3.Bolge
				if(current != null) // parent bilgilerini al
				{
					ParentX = current.x;
					ParentY = current.y;
					ParentTopX = current.TopX;
					ParentTopY = current.TopY;
					ParentBotX = current.BottomX;
					ParentBotY = current.BottomY;
				}				
				current = current.x1y2; // sonraki dugume git
				if(current==null){
					if(kontrol == 0) // parent bilgileri al geri don
					{
						return;
					}else
					{
						parent.x1y2 = newNode; // yeni dugum ekel
						return;
					}
				}
			}
				else if(x > current.x && y > current.y){ //4.Bolge
					if(current != null) // Parent Bilgilerini Al
					{
						ParentX = current.x;
						ParentY = current.y;
						ParentTopX = current.TopX;
						ParentTopY = current.TopY;
						ParentBotX = current.BottomX;
						ParentBotY = current.BottomY;
					}
					current = current.x2y2; // sonraki dugume git
					if(current==null){
						if(kontrol == 0) //parent bilgilerini al don
						{
							return;
						}else
						{
							parent.x2y2 = newNode; // yeni dugumu ekle
							return;
						}
					}
				}
				else if(x > current.x && y < current.y){ //1.Bolge
					if(current != null) //Parent Bilgilerini al
					{
						ParentX = current.x;
						ParentY = current.y;
						ParentTopX = current.TopX;
						ParentTopY = current.TopY;
						ParentBotX = current.BottomX;
						ParentBotY = current.BottomY;
					}
					current = current.x2y1; //sonraki dugume ilerle
					if(current==null){ 
						if(kontrol == 0) //parent bilgileri i�in
						{
							return;
						}else
						{
							parent.x2y1 = newNode; // yeni dugum ekle
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
    
    public void Clear()
    {
    	asciiCode=65; 
    	root=null;
    	Control = false;
    	Graphics g = pencere.getGraphics();
    	g.setColor(pencere.getBackground());
        g.fillRect(0, 0, 512, 512);
    }
    public static void Draw(int coordinateX,int coordinateY)
    {
    	String NodeName = Character.toString ((char) asciiCode);
		asciiCode++; // dugum isimlerinin art�r�lmas�
		System.out.println(NodeName);
	    int R = (int) (Math.random( )*256); // random renk olustur
	    int G = (int)(Math.random( )*256);
	    int B= (int)(Math.random( )*256);
	    Color randomColor = new Color(R, G, B);
	    Graphics g = pencere.getGraphics();
	    g.setColor(randomColor);
	    
	    int x = coordinateX; // tiklanan yerden coordinat al
	    int y = coordinateY;
	    
	    if(Control == false) // ilk dugum mu kontrolu
	    {
	    	Control=true;
	    	for(int i =0;i<512;i++)
	    	{
	    		g.drawString("-", i, y);
	    		g.drawString("|", x, i);
	    	}
	    	insert(x,y,512,0,512,0,1,NodeName); // ekle
	    	
	    }else
	    {
	    	insert(x,y,0,0,0,0,0,"a"); // parent bilgilerini al
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
	    		
	    		for(int i=minY+5; i < maxY-5 ;i++)
	    		{
	    			g.drawString("|",x,i);
	    		}
	    		
	    		insert(x,y,maxX,minX,maxY,minY,1,NodeName);
	    	}
	    	if(x<ParentX && y>ParentY) // 3. bolge
	    	{
	    		int maxX=0,minX=0,maxY=0,minY=0;
	    		
	    		minX = ParentBotX;
	    		maxX = ParentX;
	    		maxY = ParentBotY;
	    		minY = ParentY;
	    		
	    		for(int i=minX;i<maxX;i++) // draw x coordinates
	    		{
	    			g.drawString("-",i,y);
	    		}
	    		for(int i=minY+5; i < maxY-5 ;i++) // draw y coordinates
	    		{
	    			g.drawString("|",x,i);
	    		}			    		
	    		insert(x,y,maxX,minX,maxY,minY,1,NodeName);
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
	    		
	    		for(int i=minY+5; i < maxY-5;i++)
	    		{
	    			g.drawString("|",x,i);
	    		}
	    		
	    		insert(x,y,maxX,minX,maxY,minY,1,NodeName);
	    		
	    		
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
	    		
	    		for(int i=minY+5; i < maxY-5 ;i++)
	    		{
	    			g.drawString("|",x,i);
	    		}
	    		
	    		insert(x,y,maxX,minX,maxY,minY,1,NodeName); 
	    	}
	    }
	    g.drawString(NodeName, x+3, y-5);
    }
    
}

