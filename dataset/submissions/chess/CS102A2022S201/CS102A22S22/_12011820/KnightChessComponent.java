import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    private ChessboardPoint source; // Where the chess is

    private ChessColor chessColor;  // What's the color

    private char name;			// What's the name

    ChessComponent[][] chessComponents;
    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();

        ChessboardPoint com1 = new ChessboardPoint(source.getX()+1, source.getY()+2);
        ChessboardPoint com2 = new ChessboardPoint(source.getX()+1, source.getY()-2);
        ChessboardPoint com3 = new ChessboardPoint(source.getX()-1, source.getY()-2);
        ChessboardPoint com4 = new ChessboardPoint(source.getX()-1, source.getY()+2);
        ChessboardPoint com5 = new ChessboardPoint(source.getX()+2, source.getY()-1);
        ChessboardPoint com6 = new ChessboardPoint(source.getX()+2, source.getY()+1);
        ChessboardPoint com7 = new ChessboardPoint(source.getX()-2, source.getY()+1);
        ChessboardPoint com8 = new ChessboardPoint(source.getX()-1, source.getY()+2);
        
        if(judge(com1)) result.add(com1);
        if(judge(com2)) result.add(com2);
        if(judge(com3)) result.add(com3);
        if(judge(com4)) result.add(com4);
        if(judge(com5)) result.add(com5);
        if(judge(com6)) result.add(com6);
        if(judge(com7)) result.add(com7);
        if(judge(com8)) result.add(com8);
        
        sort(result);
        return result;

    }

    private boolean judge(ChessboardPoint target){
        if(target.getY()>7||target.getY()<0||target.getX()>7||target.getX()<0) return false;

        if(chessComponents[target.getX()][target.getY()].getChessColor().equals(this.getChessColor())) return false;

        /***int x_ =Math.max(target.getX(), source.getX())-Math.min(target.getX(), source.getX());
        int y_ = Math.max(target.getY(), source.getY())-Math.min(target.getY(), source.getY());

        if(x_==2){
            if(chessComponents[(source.getX()+ target.getX())/2][source.getY()].getChessColor().equals(this.getChessColor())) return false;
        }
        if(y_==2){
            if(chessComponents[source.getX()][(source.getY()+ target.getY())/2].getChessColor().equals(this.getChessColor())) return false;
        }***/

        return true;
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
    public KnightChessComponent(char name , ChessColor a, ChessboardPoint b,ChessComponent[][] chessComponents){
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

