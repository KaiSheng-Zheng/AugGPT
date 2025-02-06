import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> king = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessColor color = super.getChessColor();
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(i,i)){
                break;
            }else{
                if (super.chessboard[x+i][y+i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x+i][y+i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x+i,y+i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x+i,y+i);
                        king.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(-i,-i)){
                break;
            }else{
                if (super.chessboard[x-i][y-i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x-i][y-i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x-i,y-i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x-i,y-i);
                        king.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(i,-i)){
                break;
            }else{
                if (super.chessboard[x+i][y-i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x+i][y-i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x+i,y-i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x+i,y-i);
                        king.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(-i,i)){
                break;
            }else{
                if (super.chessboard[x-i][y+i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x-i][y+i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x-i,y+i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x-i,y+i);
                        king.add(a);
                    }
                }
            }
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(i,0)){
                break;
            }else{
                if (super.chessboard[x+i][y].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x+i][y].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x+i,y);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x+i,y);
                        king.add(a);
                    }
                }
            }
        }

        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(-i,0)){
                break;
            }else{
                if (super.chessboard[x-i][y].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x-i][y].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x-i,y);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x-i,y);
                        king.add(a);
                    }
                }
            }
        }

        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(0,i)){
                break;
            }else{
                if (super.chessboard[x][y+i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x][y+i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x,y+i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x,y+i);
                        king.add(a);
                    }
                }
            }
        }

        for (int i = 1; i < 2; i++) {
            if (!super.getSource().cando(0,-i)){
                break;
            }else{
                if (super.chessboard[x][y-i].getChessColor().equals(color)){
                    break;
                }else {
                    if (!super.chessboard[x][y-i].getChessColor().equals(ChessColor.NONE)){
                        ChessboardPoint a = new ChessboardPoint(x,y-i);
                        king.add(a);
                        break;
                    }
                    else {
                        ChessboardPoint a = new ChessboardPoint(x,y-i);
                        king.add(a);
                    }
                }
            }
        }
        super.Sort(king);
        return king;
    }
}
