import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
        this.source = source;
        this.name = name;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(moveChess(source.getX(),source.getY(),i,j)){
                   result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
         ChessColor chessColor1 = chessComponents[targetX][targetY].getChessColor();
        ChessColor chessColor2 = chessComponents[sourceX][sourceY].getChessColor();
        if(chessColor1!=chessColor2 ) {
            if (sourceX == targetX ) {
                return Math.abs(sourceY - targetY) == 1;
            }
            else if (sourceY == targetY ) {
                return Math.abs(sourceX - targetX) == 1 ;
            }
            else return Math.abs(sourceX - targetX) == 1 && Math.abs(sourceY - targetY) == 1;
        }else return false;
        }
}