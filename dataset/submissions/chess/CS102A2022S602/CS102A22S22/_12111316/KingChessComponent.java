import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (canMove(i,j)  && chick(i,j)){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }


    public KingChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents,ChessColor chessColor, char name){
        super(source,chessComponents, chessColor, name);
        this.name=name;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public boolean canMove(int x, int y){
        {
            ChessboardPoint source = getSource();
            if((Math.abs(source.getX() - x)+Math.abs(source.getY() - y))!=1
                    && !(Math.abs(source.getX() -x)==1
                    &&(Math.abs(source.getX() - x)==Math.abs(source.getY()- y)))){
                return false;
            }
            return true;
    }
}

    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptyChessComponent){
            return true;
        }
        return false;
    }
}

