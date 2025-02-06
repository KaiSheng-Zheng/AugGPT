import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> bishop = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessColor color = super.getChessColor();
        for (int i = 1; i < 8; i++) {
            if (!super.getSource().cando(i,i)){
                break;
            }else{
                if (super.chessboard[x+i][y+i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x+i][y+i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x+i,y+i);
                        bishop.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x+i,y+i);
                        bishop.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!super.getSource().cando(-i,-i)){
                break;
            }else{
                if (super.chessboard[x-i][y-i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x-i][y-i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x-i,y-i);
                        bishop.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x-i,y-i);
                        bishop.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!super.getSource().cando(i,-i)){
                break;
            }else{
                if (super.chessboard[x+i][y-i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x+i][y-i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x+i,y-i);
                        bishop.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x+i,y-i);
                        bishop.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (!super.getSource().cando(-i,i)){
                break;
            }else{
                if (super.chessboard[x-i][y+i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x-i][y+i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x-i,y+i);
                        bishop.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x-i,y+i);
                        bishop.add(a);
                    }
                }
            }
        }
        super.Sort(bishop);
        return bishop;
    }
}
