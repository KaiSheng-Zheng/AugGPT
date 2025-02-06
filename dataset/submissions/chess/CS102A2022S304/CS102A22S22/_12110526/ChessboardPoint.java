
import java.util.List;
public class ChessboardPoint {
    private int x;
    private int y;

    /*
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /*
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /*
     * should design
     * @return
     */
    @Override
    public String toString() {
    	boolean on = this.x>=0&&this.x<8&&this.y<8&&this.y>=0;
    	String str = "("+this.x+","+this.y+")" ;
    	if(on) {return str;}
    	
    	else {
    	return null;}
    }


    /*
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
       boolean on =this.x+dx>=0&&this.x+dx<8&&this.y+dy<8&&this.y+dy>=0; 
    
       if(on) {
    	   ChessboardPoint answer = new ChessboardPoint(dx+this.x,dy+this.y);
    	   return answer;}
    	else{return null;}
    }


    public boolean check(List<ChessboardPoint> chessboardPoints,int X,int Y){
        if (chessboardPoints.size() != 0){
        	for( int i =0;i<chessboardPoints.size() ;i++){
        		ChessboardPoint a = chessboardPoints.get(i);
        		if( a.getX()==X&&a.getY()==Y) {
        			return true;
        		}}
            return false;
        }else {
            return false;
        }
    }

}

