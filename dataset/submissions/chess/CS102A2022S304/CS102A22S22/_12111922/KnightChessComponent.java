import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> knight = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessColor color = super.getChessColor();
        if (super.getSource().cando(1, 2)) {
            if (!super.chessboard[x + 1][y + 2].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x+1,y+2);
                knight.add(a);
            }
        }
        if (super.getSource().cando(1, -2)) {
            if (!super.chessboard[x + 1][y - 2].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x+1,y-2);
                knight.add(a);
            }
        }
        if (super.getSource().cando(-1, 2)) {
            if (!super.chessboard[x - 1][y + 2].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x-1,y+2);
                knight.add(a);
            }
        }
        if (super.getSource().cando(-1, -2)) {
            if (!super.chessboard[x - 1][y - 2].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x-1,y-2);
                knight.add(a);
            }
        }
        if (super.getSource().cando(2, 1)) {
            if (!super.chessboard[x + 2][y + 1].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x+2,y+1);
                knight.add(a);
            }
        }
        if (super.getSource().cando(2, -1)) {
            if (!super.chessboard[x + 2][y - 1].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x+2,y-1);
                knight.add(a);
            }
        }
        if (super.getSource().cando(-2, 1)) {
            if (!super.chessboard[x - 2][y + 1].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x-2,y+1);
                knight.add(a);
            }
        }
        if (super.getSource().cando(-2, -1)) {
            if (!super.chessboard[x - 2][y - 1].getChessColor().equals(color)) {
                ChessboardPoint a = new ChessboardPoint(x-2,y-1);
                knight.add(a);
            }
        }
        super.Sort(knight);
        return knight;
    }
}