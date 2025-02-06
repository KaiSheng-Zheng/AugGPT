import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;


    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX(), y = source.getY();
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i=0;i<8;i++) {
                for(int j=0;j<8;j++){
                   if(yes(x,y,i,j)){
                     a.add(new ChessboardPoint(i,j));
    }

        }
    }

        return a;
    }
    public ChessboardPoint getSource(){
        return source;
    }

    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public boolean yes(int x,int y,int i,int j) {
        if ((i==x&j==y+1)^(i==x&j==y-1)^(i==x-1&j==y)^(i==x+1&j==y)^(i==x-1&j==y-1)^(i==x+1&j==y-1)^(i==x-1&j==y+1)^(i==x+1&j==y+1)) {
            if (chessComponents[i][j].getChessColor() != chessComponents[x][y].getChessColor()) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


    }
