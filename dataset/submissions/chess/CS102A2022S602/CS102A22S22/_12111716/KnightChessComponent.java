import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        int x=source.getX(),y=source.getY();
        List<ChessboardPoint> a=new ArrayList<>();
        for (int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                if((i==x-2&j==y-1)^(i==x-2&j==y+1)^(i==x-1&j==y-2)^(i==x-1&j==y+2)^(i==x+1&j==y-2)^(i==x+1&j==y+2)^(i==x+2&j==y+1)^(i==x+2&j==y-1)) {
                    if (yes(x, y, i, j)) {
                        a.add(new ChessboardPoint(i, j));
                    }
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
    public boolean yes(int x,int y,int i,int j){
            return chessComponents[i][j].getChessColor() != chessComponents[x][y].getChessColor();
        }

}
