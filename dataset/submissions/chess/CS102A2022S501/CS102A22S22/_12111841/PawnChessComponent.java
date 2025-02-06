import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        switch (this.getChessColor()) {
            case WHITE -> {
                if (x == 6) {
                    if (chessboard[x-1][y].getChessColor() == ChessColor.NONE && chessboard[x-2][y].getChessColor() == ChessColor.NONE) {
                        canMoveTo.add(this.getSource().offset(-2, 0));
                    }
                }
                if (this.getSource().offset(-1, 0) != null) {
                    if (chessboard[x-1][y].getChessColor() == ChessColor.NONE) {
                        canMoveTo.add(this.getSource().offset(-1, 0));
                    }
                }
                if (this.getSource().offset(-1, -1) != null){
                    if (chessboard[x-1][y-1].getChessColor() == ChessColor.BLACK) {
                        canMoveTo.add(this.getSource().offset(-1, -1));
                    }
                }
                if (this.getSource().offset(-1, 1) != null){
                    if (chessboard[x-1][y+1].getChessColor() == ChessColor.BLACK) {
                        canMoveTo.add(this.getSource().offset(-1, 1));
                    }
                }
            }
            case BLACK -> {
                if (x == 1) {
                    if (chessboard[x+1][y].getChessColor() == ChessColor.NONE && chessboard[x+2][y].getChessColor() == ChessColor.NONE) {
                        canMoveTo.add(this.getSource().offset(2, 0));
                    }
                }
                if (this.getSource().offset(1, 0) != null) {
                    if (chessboard[x+1][y].getChessColor() == ChessColor.NONE) {
                        canMoveTo.add(this.getSource().offset(1, 0));
                    }
                }
                if (this.getSource().offset(1, -1) != null){
                    if (chessboard[x+1][y-1].getChessColor() == ChessColor.WHITE) {
                        canMoveTo.add(this.getSource().offset(1, -1));
                    }
                }
                if (this.getSource().offset(1, 1) != null){
                    if (chessboard[x+1][y+1].getChessColor() == ChessColor.WHITE) {
                        canMoveTo.add(this.getSource().offset(1, 1));
                    }
                }
            }
        }
        return canMoveTo;
    }
}