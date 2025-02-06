public class ChessboardPoint implements Comparable<ChessboardPoint>{
	private int x,y;
	public ChessboardPoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public ChessboardPoint offset(int dx, int dy){
		if (x+dx<0||x+dx>7||y+dy<0||y+dy>7) return null;
		else return new ChessboardPoint(x+dx,y+dy);
	}
	public int compareTo(ChessboardPoint a){
		return (x*8+y)-(a.getX()*8+a.getY());
	}
	public boolean equals(ChessboardPoint a){
		return x==a.getX()&&y==a.getY();
	}
}