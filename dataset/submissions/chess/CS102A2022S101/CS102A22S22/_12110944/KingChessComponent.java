import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chessComponents;
    public KingChessComponent(char name, ChessColor chessColor,ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessColor, chessComponents,source);
        this.name=name;
        this.source=source;
        this.chessColor = chessColor;
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result= new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveChess(source.getX(),source.getY(),i,j)){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }
    public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX==targetX&&sourceY==targetY){
            return false;
        }

        if(!((Math.abs(sourceX-targetX))==1&&Math.abs(sourceX - targetX) == Math.abs(sourceY - targetY))&&((Math.abs(sourceX-targetX)+Math.abs(sourceY-targetY)))!=1){
            return false;
        }

        if(chessComponents[sourceX][sourceY].getChessColor()==chessComponents[targetX][targetY].getChessColor()){
            return false;
        }
        return true;
    }


}

