import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
    public BishopChessComponent(){}

    public boolean move(int sourceX, int sourceY, int targetX, int targetY) {
        int row = Math.abs(targetX - sourceX);
        int column = Math.abs(targetY - sourceY);
        int rowDiff = targetX - sourceX;
        int colDiff = targetY - sourceY;
        boolean isEmpty = true;
        if (row == 0 || column == 0) {
            return false;
        }
        if (row == column) {
            for (int i = 1; i < row; i++) {
                if (rowDiff > 0) {
                    if (colDiff < 0) {
                        if (!(chessComponents[sourceX + i][sourceY - i].getChessColor().equals( ChessColor.NONE))) {
                            isEmpty = false;
                        }
                    } else {
                        if (!(chessComponents[sourceX + i][sourceY + i].getChessColor() .equals(ChessColor.NONE))) {
                            isEmpty = false;
                        }
                    }

                }
                if (rowDiff < 0) {
                    if (colDiff < 0) {
                        if (!(chessComponents[sourceX - i][sourceY - i].getChessColor() .equals(ChessColor.NONE))) {
                            isEmpty = false;
                        }
                    } else {
                        if (!(chessComponents[sourceX - i][sourceY + i].getChessColor() .equals(ChessColor.NONE))) {
                            isEmpty = false;
                        }
                    }
                }
            }
        }
        if(row==column&&isEmpty){
            return true;
        }else {return false;}
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
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



