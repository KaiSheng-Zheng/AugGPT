import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        ChessColor chessColor = getChessColor();
        ChessComponent[][] chessboard = getChessboard();

        if (x>0){
            if (chessboard[x-1][y].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 1,y));
            }
        }
        if (x<7){
            if (chessboard[x+1][y].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 1,y));
            }
        }
        if (y>0){
            if (chessboard[x][y-1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x,y - 1));
            }
        }
        if (y<7){
            if (chessboard[x][y+1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x,y + 1));
            }
        }

        if (x>0 && y>0){
            if (chessboard[x-1][y-1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 1,y - 1));
            }
        }
        if (x>0 && y<7){
            if (chessboard[x-1][y+1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 1,y + 1));
            }
        }
        if (x<7 && y>0){
            if (chessboard[x+1][y-1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 1,y - 1));
            }
        }
        if (x<7 && y<7){
            if (chessboard[x+1][y+1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 1,y + 1));
            }
        }

        chessboardPointList.sort(new SortByXY());
        return chessboardPointList;
    }

    public String toString(){
        if (getChessColor()==ChessColor.WHITE)return "k";
        else return "K";
    }
}
