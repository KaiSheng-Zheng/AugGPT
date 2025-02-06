import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> pawn = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessColor color = super.getChessColor();
        if (color == ChessColor.BLACK) {
            if (x == 1) {
                if (super.chessboard[x+2][y].getChessColor().equals(ChessColor.NONE)&&super.chessboard[x+1][y].getChessColor().equals(ChessColor.NONE)) {
                    ChessboardPoint a = new ChessboardPoint(x+2, y);
                    pawn.add(a);
                }
                if (super.chessboard[x+1][y].getChessColor().equals(ChessColor.NONE)) {
                    ChessboardPoint a = new ChessboardPoint(x+1, y);
                    pawn.add(a);
                }
                if (super.getSource().cando(1,1)) {
                    if (super.chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                        ChessboardPoint a = new ChessboardPoint(x + 1, y + 1);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando(1,  -1)) {
                    if (super.chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                        ChessboardPoint a = new ChessboardPoint(x + 1, y - 1);
                        pawn.add(a);
                    }
                }
            } else {
                if (super.getSource().cando(1, 0)) {
                    if (super.chessboard[x+1][y].getChessColor().equals(ChessColor.NONE)) {
                        ChessboardPoint a = new ChessboardPoint(x+1, y);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando(1, 1)) {
                    if (super.chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                        ChessboardPoint a = new ChessboardPoint(x + 1, y + 1);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando( 1,  - 1)) {
                    if (super.chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                        ChessboardPoint a = new ChessboardPoint(x + 1, y - 1);
                        pawn.add(a);
                    }
                }
            }
        }
        if (color == ChessColor.WHITE){
            if (x == 6) {
                if (super.chessboard[x - 2][y].getChessColor().equals(ChessColor.NONE)&&super.chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    ChessboardPoint a = new ChessboardPoint(x-2, y);
                    pawn.add(a);
                }
                if (super.chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    ChessboardPoint a = new ChessboardPoint(x-1, y);
                    pawn.add(a);
                }
                if (super.getSource().cando( - 1,  - 1)) {
                    if (super.chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                        ChessboardPoint a = new ChessboardPoint(x - 1, y - 1);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando( - 1,  1)) {
                    if (super.chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                        ChessboardPoint a = new ChessboardPoint(x - 1, y + 1);
                        pawn.add(a);
                    }
                }
            } else {
                if (super.getSource().cando(-1, 0)) {
                    if (super.chessboard[x-1][y].getChessColor().equals(ChessColor.NONE)) {
                        ChessboardPoint a = new ChessboardPoint(x-1, y);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando( - 1,  - 1)) {
                    if (super.chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                        ChessboardPoint a = new ChessboardPoint(x - 1, y - 1);
                        pawn.add(a);
                    }
                }
                if (super.getSource().cando( - 1,  1)) {
                    if (super.chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                        ChessboardPoint a = new ChessboardPoint(x - 1, y + 1);
                        pawn.add(a);
                    }
                }
            }
        }
        super.Sort(pawn);
        return pawn;
    }
}

