import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    //private ChessColor chessColor;
    //private ChessboardPoint source;
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(chessboard[x][y].getChessColor() == ChessColor.BLACK) {
            if (x == 1) {
                if (withinBoard(x + 1, y)) {
                    if (chessboard[x+1][y].getChessColor() == ChessColor.NONE) {
                        list.add(new ChessboardPoint(x + 1, y));
                    }
                }
                if (withinBoard(x + 2, y)) {
                    if (chessboard[x+2][y].getChessColor() == ChessColor.NONE && chessboard[x+1][y].getChessColor() == ChessColor.NONE) {
                        list.add(new ChessboardPoint(x + 2, y));
                    }
                }
                if (withinBoard(x + 1, y + 1)) {
                    if (isOurChess(x + 1, y + 1)) {
                        if(chessboard[x+1][y+1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x + 1, y + 1));
                        }
                    }
                }
                if (withinBoard(x + 1, y - 1)) {
                    if (isOurChess(x + 1, y - 1)) {
                        if(chessboard[x+1][y+1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x + 1, y - 1));
                        }
                    }
                }
                return list;
            } else {
                if(withinBoard(x+1, y)){
                    if(isOurChess(x + 1, y)){
                        if (chessboard[x+1][y].getChessColor() == ChessColor.NONE)
                            list.add(new ChessboardPoint(x+1, y));
                    }
                }
                if (withinBoard(x + 1, y + 1)) {
                    if (isOurChess(x + 1, y + 1)) {
                        if(chessboard[x+1][y+1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x + 1, y + 1));
                        }
                    }
                }
                if (withinBoard(x + 1, y - 1)) {
                    if (isOurChess(x + 1, y - 1)) {
                        if(chessboard[x+1][y-1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x + 1, y + 1));
                        }
                        list.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                return list;
            }
        }
        else {
            if (x == 6) {
                if (withinBoard(x - 1, y)) {
                    if (isOurChess(x - 1, y)) {
                        if(chessboard[x-1][y].getChessColor() == ChessColor.NONE) {
                            list.add(new ChessboardPoint(x - 1, y));
                        }
                    }
                }
                if (withinBoard(x - 2, y)) {
                    if (chessboard[x-2][y].getChessColor() == ChessColor.NONE && chessboard[x-1][y].getChessColor() == ChessColor.NONE) {
                        list.add(new ChessboardPoint(x - 2, y));
                    }
                }
                if (withinBoard(x - 1, y + 1)) {
                    if (isOurChess(x - 1, y + 1)) {
                        if(chessboard[x-1][y+1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x - 1, y + 1));
                        }
                    }
                }
                if (withinBoard(x - 1, y - 1)) {
                    if (isOurChess(x - 1, y - 1)) {
                        if(chessboard[x-1][y-1].getChessColor() != ChessColor.NONE) {
                            list.add(new ChessboardPoint(x - 1, y - 1));
                        }
                    }
                }
                return list;
            }
            else {
                if (withinBoard(x - 1, y)) {
                    if (isOurChess(x - 1, y)) {
                        if(chessboard[x-1][y].getChessColor() == ChessColor.NONE)
                            list.add(new ChessboardPoint(x - 1, y));
                    }
                }
                if (withinBoard(x - 1, y + 1)) {
                    if (isOurChess(x - 1, y + 1)) {
                        if(chessboard[x-1][y+1].getChessColor() != ChessColor.NONE)
                            list.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
                if (withinBoard(x - 1, y - 1)) {
                    if (isOurChess(x - 1, y - 1)) {
                        if(chessboard[x-1][y-1].getChessColor() != ChessColor.NONE)
                            list.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                return list;
            }
        }
    }
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source){
        setChessColor(chessColor);
        setSource(source);
        if(chessColor == ChessColor.BLACK)
            this.name = 'P';
        else
            this.name = 'p';
    }
    public String toString(){
        return String.valueOf(this.name);
    }

}
