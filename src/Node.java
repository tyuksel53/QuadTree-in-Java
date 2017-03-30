class Node{
	int x,y;
	int TopX;
	int TopY;
	int BottomX;
	int BottomY;
	int kontrol;
	String ParentName;
	Node x1y1,x2y1,x2y2,x1y2;
	public Node(int x,int y,int TopX,int BottomX,int BottomY,int TopY,int kontrol,String ParentName){
		this.x = x;
		this.y = y;
		this.TopX = TopX;
		this.TopY = TopY;
		this.kontrol = kontrol;
		this.BottomX = BottomX;
		this.BottomY = BottomY;
		this.ParentName = ParentName;
		x1y1=null;
	    x1y2=null;
	    x1y1=null;
	    x2y1=null;
	}
}