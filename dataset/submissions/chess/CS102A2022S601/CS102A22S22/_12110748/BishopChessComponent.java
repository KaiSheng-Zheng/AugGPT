import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);this.source=source;this.name=name;this.chessColor=chessColor;this.chessComponents=chessComponents;

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
        if(sourceX==targetX && sourceY == targetY){return false;}
        else if (chessComponents[targetX][targetY].getChessColor()==chessComponents[sourceX][sourceY].getChessColor()) {
            return false;
        }
        else if(sourceX-targetX == sourceY-targetY){
            int row = Math.min(sourceX,targetX);
            int col = Math.min(sourceY,targetY);
            for (int i = 1; i < Math.abs(sourceX-targetX); i++) {
                if(!(chessComponents[row+i][col+i].getChessColor()==ChessColor.NONE)){
                    return false;
                }
            }
        }else if(sourceX + sourceY == targetX + targetY) {
            int row = Math.min(sourceX, targetX);
            int col = Math.max(sourceY, targetY);
            for (int i = 1; i < Math.abs(sourceX - targetX); i++) {
                if (!(chessComponents[row + i][col - i].getChessColor()==ChessColor.NONE)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;}
}
