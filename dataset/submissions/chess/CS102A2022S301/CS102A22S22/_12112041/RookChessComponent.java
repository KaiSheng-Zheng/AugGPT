import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char theName,ChessComponent[][] chessComponents){
        super(source,chessColor,theName,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints=new ArrayList<>();
        int row=this.getSource().getX();
        int col=this.getSource().getY();

        for (int y = col; y < 8; y++) {
            if (chessboard[row][y].getChessColor() != chessboard[row][col].getChessColor() && y != col) {
                movablePoints.add(chessboard[row][y].getSource());
                if(!(chessboard[row][y] instanceof EmptySlotComponent)){break;}
            }
            if(chessboard[row][y].getChessColor() == chessboard[row][col].getChessColor() && y != col){break;}
        }
        for (int y = col; y >= 0 ; y--) {
            if (chessboard[row][y].getChessColor() != chessboard[row][col].getChessColor()&& y != col) {
                movablePoints.add(chessboard[row][y].getSource());
                if(!(chessboard[row][y] instanceof EmptySlotComponent)){break;}
            }
            if( chessboard[row][y].getChessColor() == chessboard[row][col].getChessColor() && y != col){break;}
        }
        for (int x = row; x < 8; x++) {
            if (chessboard[x][col].getChessColor() != chessboard[row][col].getChessColor()&& x != row) {
                movablePoints.add(chessboard[x][col].getSource());
                if(!(chessboard[x][col] instanceof EmptySlotComponent)){break;}
            }
            if(chessboard[x][col].getChessColor() == chessboard[row][col].getChessColor() && x != row){break;}
        }
        for (int x = row; x >= 0; x--) {
            if (chessboard[x][col].getChessColor() != chessboard[row][col].getChessColor()&& x != row) {
                movablePoints.add(chessboard[x][col].getSource());
                if(!(chessboard[x][col] instanceof EmptySlotComponent)){break;}
            }
            if(chessboard[x][col].getChessColor() == chessboard[row][col].getChessColor() && x != row){break;}
        }
        return movablePoints;
    }
}