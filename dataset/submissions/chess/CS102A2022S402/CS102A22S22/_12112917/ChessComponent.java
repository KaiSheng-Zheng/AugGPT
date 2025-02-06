import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ChessComponent {
    private ChessboardPoint source;
    static ChessComponent[][] chessComponents;
    public ChessboardPoint getSource() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    private ChessColor chessColor;
    protected char name;
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
    }
    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    public Boolean AvailableMove(int i, int j){
        if(this.source.offset(i,j)==null
                ||chessComponents[this.source.getX()+i][this.source.getY()+j].chessColor==this.chessColor){
            return false;
        }
        else return true;
    }
    public Boolean CapturedChess(int i,int j){
        if(chessComponents[i][j].chessColor!=this.chessColor&&chessComponents[i][j].chessColor!=ChessColor.NONE){
            return true;
        }
        else return false;
    }
    public Map<ChessboardPoint,Integer> InAttackPlaces(){
        Map<ChessboardPoint,Integer> h1 = new HashMap<>();
        for(int i = 0;i<=7;i++){
            for(int j = 0;j<=7;j++){
                if(chessComponents[i][j] instanceof KingChessComponent){
                    continue;
                }
                for(int m = 0;m<chessComponents[i][j].canMoveTo().size();m++){
                    h1.put(chessComponents[i][j].canMoveTo().get(m),1);
                }
            }
        }
        return h1;
    }

}
