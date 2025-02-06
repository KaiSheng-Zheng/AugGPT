import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint loc = this.getSource();
        int x = loc.getX(), y = loc.getY();
        List<ChessboardPoint> possiblemoves = new ArrayList<>();
        possiblemoves.clear();
        if (getChessColor() == ChessColor.BLACK) {
            if (x == 7)
                return possiblemoves;
            if (chessboard[x + 1][y] instanceof EmptySlotComponent) {
                possiblemoves.add(chessboard[x + 1][y].getSource());
                if (x == 1) {
                    if (chessboard[3][y] instanceof EmptySlotComponent)
                        possiblemoves.add(chessboard[3][y].getSource());
                }
            }
            if ((y > 0) && !(chessboard[x + 1][y - 1] instanceof EmptySlotComponent) && (chessboard[x + 1][y - 1].getChessColor() != this.getChessColor()))
                possiblemoves.add(chessboard[x - 1][y - 1].getSource());
            if ((y < 7) && !(chessboard[x + 1][y + 1] instanceof EmptySlotComponent) && (chessboard[x + 1][y + 1].getChessColor() != this.getChessColor()))
                possiblemoves.add(chessboard[x + 1][y + 1].getSource());
        }
        else {
            if (x == 0)
                return possiblemoves;
            if (chessboard[x - 1][y] instanceof EmptySlotComponent) {
                possiblemoves.add(chessboard[x - 1][y].getSource());
                if (x == 6) {
                    if (chessboard[4][y] instanceof EmptySlotComponent)
                        possiblemoves.add(chessboard[4][y].getSource());
                }
            }
            if((y>0)&&!(chessboard[x-1][y-1] instanceof EmptySlotComponent)&&(chessboard[x-1][y-1].getChessColor()!=this.getChessColor()))
                possiblemoves.add(chessboard[x-1][y-1].getSource());
            if((y<7)&&!(chessboard[x-1][y+1] instanceof EmptySlotComponent)&&(chessboard[x-1][y+1].getChessColor()!=this.getChessColor()))
                possiblemoves.add(chessboard[x-1][y+1].getSource());
        }
        return possiblemoves;
    }
}
