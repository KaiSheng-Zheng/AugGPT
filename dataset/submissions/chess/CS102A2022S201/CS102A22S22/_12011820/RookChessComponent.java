import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    private char name;			// What's the name
    ChessComponent[][] chessComponents;

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = source.getX();
        int y = source.getY();
        for(int i = -7;i<=7;i++){
            if(x+i<8&&x+i>=0&&canMoveTest(x,y,i,0)){
                result.add(new ChessboardPoint(x+i,y)) ;
            }
            if(y+i<8&&y+i>=0&&canMoveTest(x,y,0,i)){
                result.add(new ChessboardPoint(x,y+i)) ;
            }
        }
        sort(result);
        return result;
    }

    public void sort(List<ChessboardPoint> com){
        int size = com.size();
        for(int i = 0;i<size;i++){
            for(int k = 0;k<size-1 ;k++){
                ChessboardPoint com1 = com.get(k);
                ChessboardPoint com2 = com.get(k+1);
                if(com1.getX()>com2.getX()) {
                    com.set(k+1,com1);
                    com.set(k,com2);
                }
                else if(com1.getX()== com2.getX()&& com1.getY()>com2.getY()){
                    com.set(k+1,com1);
                    com.set(k,com2);
                }
            }
        }
    }

    private boolean canMoveTest(int x,int y,int dx,int dy){
        boolean result = true;
        if(dx==0&&dy==0){
            return false;
        }
        else if(dx == 0){
            int dy_ = Math.max(0,dy) - Math.min(0,dy);
            int dy__ = dy>0? 1:-1;
            for(int i = 1 ;i<dy_;i++){
                if(chessComponents[x][y+dy__*i].getName()!='_') return false;
            }
            if(chessComponents[x][y+dy].getChessColor().equals(chessComponents[x][y].getChessColor())){
                return false;
            }
        }
        else if(dy == 0){
            int dx_ = Math.max(0,dx) - Math.min(0,dx);
            int dx__ = dx>0? 1:-1;
            for(int i = 1 ;i<dx_;i++){
                if(chessComponents[x+dx__*i][y].getName()!='_') return false;
            }
            if(chessComponents[x+dx][y].getChessColor().equals(chessComponents[x][y].getChessColor())){
                return false;
            }
        }

        return result;
    }
    public RookChessComponent(char name , ChessColor a, ChessboardPoint b,ChessComponent[][] chessComponents){
        this.name = name ;
        chessColor = a;
        source = b;
        this.chessComponents = chessComponents;
    }
    public char getName(){
        return this.name;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public void printAllCanMoveTo(){
        List<ChessboardPoint> com = this.canMoveTo();
        for(ChessboardPoint a: com){
            System.out.println("("+a.getX()+","+a.getY()+")");
        }
    }
    public String toString() {
        return String.valueOf(this.name);
    }

}
