import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    private char name;			// What's the name
    ChessComponent[][] chessComponents;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = source.getX();
        int y = source.getY();
        if(x>=1&&x<=8&&y>=1&&y<=8){
            if(!chessComponents[x-1][y-1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(x-1,y-1));
            }
        }
        for(int dx = 1 ;dx>-2;dx-=2){
            for(int dy = 1 ;dy>-2;dy-=2 ){
                for(int i = 1;i<8;i++){
                    if(x+dx*i>-1&&x+dx*i<8&&y+dy*i>-1&&y+dy*i<8&&emptyTest(x,y,x+dx*i,y+dy*i)) result.add(new ChessboardPoint(x+dx*i,y+dy*i));
                }
            }
            for(int i =1;i<8;i++){
                if(x+dx*i>-1&&x+dx*i<8&&canMoveTest(x,y,dx*i,0)) result.add(new ChessboardPoint(x+dx*i,y));
                if(y+dx*i>-1&&y+dx*i<8&&canMoveTest(x,y,0,dx*i)) result.add(new ChessboardPoint(x,y+dx*i));
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

    private boolean emptyTest(int x ,int y,int x_,int y_){
        int X = x>x_ ? -1:1;
        int Y = y>y_ ? -1:1;
        int count = Math.max(x,x_) - Math.min(x,x_);
        for(int i = 1 ;i<count ;i++){
            if(chessComponents[x+X*i][y+Y*i].getName()!= '_') return false;
        }
        if(chessComponents[x_][y_].getChessColor().equals(this.chessColor)) return false;
        return true;
    }

    public QueenChessComponent(char name , ChessColor a, ChessboardPoint b,ChessComponent[][] chessComponents){
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
