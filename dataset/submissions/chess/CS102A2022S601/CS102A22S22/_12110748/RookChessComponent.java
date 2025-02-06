import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name, ChessComponent[][] chessComponents){
        super(source,chessColor,name,chessComponents);
this.source=source;this.name=name;this.chessColor=chessColor;this.chessComponents=chessComponents;
    }

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
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if((sourceX == targetX && sourceY == targetY)||(chessComponents[targetX][targetY].getChessColor() == chessComponents[sourceX][sourceY].getChessColor())) {return false;}
        else {
            if (sourceX == targetX) {
                int row = source.getX();
                int num = Math.abs(targetY-sourceY);
                for (int col = Math.min(sourceY, targetY) + 1;
                     col < Math.max(sourceY, targetY); col++) {
                    if ((chessComponents[row][col].getChessColor()==ChessColor.NONE)) {
                        num--;
                    }
                }
                return num==1;
            }
            else if (sourceY == targetY) {
                int num = Math.abs(targetX-sourceX);
                int col = source.getY();
                for (int row = Math.min(sourceX, targetX) + 1;
                     row < Math.max(sourceX, targetX); row++) {
                    if ((chessComponents[row][col].getChessColor()==ChessColor.NONE)) {
                        num--;
                    }
                }
                return num == 1;
            }
            else return false;
        }
    }
}