import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
    public RookChessComponent(){}

    public  boolean move(int sourceX, int sourceY, int targetX, int targetY) {
        int row = Math.abs(targetX - sourceX);
        int column = Math.abs(targetY - sourceY);
        int rowMin = Math.min(targetX, sourceX);
        int colMin = Math.min(targetY, sourceY);
        boolean isEmpty = true;

        if (row == 0 && column == 0) {
            return false;
        }
        if (column == 0) {
            for (int i = 1; i < row; i++) {
                if (!chessComponents[rowMin + i][colMin].getChessColor() .equals( ChessColor.NONE)) {
                    isEmpty = false;
                    break;
                }
            }
        }
        if (row == 0) {
            for (int i = 1; i < column; i++) {
                if (!(chessComponents[rowMin][colMin + i].getChessColor() .equals(ChessColor.NONE))) {
                    isEmpty = false;
                    break;
                }
            }
        }
        if(isEmpty&&(row==0||column==0)){
            return true;
        }
        return false;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int sourceX = source.getX();
        int sourceY = source.getY();
        ChessColor player =this.getChessColor();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(move(sourceX,sourceY,i,j)){
                    if(!(chessComponents[i][j].getChessColor().equals(player))){
                        canMoveTo.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return canMoveTo;
    }


}
