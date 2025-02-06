import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        ChessColor chessColor = getChessColor();

        if (x > 1 && y > 0) {
            if (chessboard[x-2][y-1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 2,y - 1));
            }
        }
        if (x > 0 && y > 1) {
            if (chessboard[x-1][y-2].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 1,y - 2));
            }
        }
        if (x > 1 && y < 7) {
            if (chessboard[x-2][y+1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 2,y + 1));
            }
        }
        if (x > 0 && y < 6) {
            if (chessboard[x-1][y+2].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x - 1,y + 2));
            }
        }
        if (x < 7 && y > 1) {
            if (chessboard[x+1][y-2].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 1,y - 2));
            }
        }
        if (x < 6 && y > 0) {
            if (chessboard[x+2][y-1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 2,y - 1));
            }
        }
        if (x < 7 && y < 6) {
            if (chessboard[x+1][y+2].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 1,y + 2));
            }
        }
        if (x < 6 && y < 7) {
            if (chessboard[x+2][y+1].getChessColor() != chessColor){
                chessboardPointList.add(new ChessboardPoint(x + 2,y + 1));
            }
        }

        chessboardPointList.sort(new SortByXY());
        return chessboardPointList;
    }

    public String toString(){
        if (getChessColor()==ChessColor.WHITE)return "n";
        else return "N";
    }
}
