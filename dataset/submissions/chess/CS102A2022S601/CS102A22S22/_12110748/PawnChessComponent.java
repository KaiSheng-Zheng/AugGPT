import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
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
                if (moveChess(source.getX(), source.getY(), i, j)) {
                    result.add(new ChessboardPoint(i, j));
                }
            }
        }
        return result;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == ChessColor.WHITE ) {
            if (sourceY == targetY) {
                if(sourceX - targetX == 1 ) return
                        chessComponents[targetX][targetY].getChessColor()==ChessColor.NONE;
                else return (sourceX == 6 && sourceX - targetX == 2  &&
                        chessComponents[targetX][targetY].getChessColor()==ChessColor.NONE &&
                        chessComponents[sourceX-1][sourceY].getChessColor()==ChessColor.NONE);
            }
            else if (Math.abs(sourceY-targetY) == 1 && sourceX - targetX == 1){
                return chessComponents[targetX][targetY].getChessColor()== ChessColor.BLACK;
            }
            else return false;
        }
        else if (chessComponents[sourceX][sourceY].getChessColor() == ChessColor.BLACK ) {
            if (sourceY == targetY) {
                if(sourceX - targetX == -1  && chessComponents[targetX][targetY].getChessColor()==ChessColor.NONE)return true;
                else return (sourceX == 1 && sourceX - targetX == -2  &&
                        chessComponents[targetX][targetY].getChessColor()==ChessColor.NONE &&
                        chessComponents[sourceX-1][sourceY].getChessColor()==ChessColor.NONE);
            }
            else if (Math.abs(sourceY-targetY) == 1 && sourceX - targetX == -1){
                return chessComponents[targetX][targetY].getChessColor() == ChessColor.WHITE;
            }
            else return false;
        }
        else return false;
    }

}