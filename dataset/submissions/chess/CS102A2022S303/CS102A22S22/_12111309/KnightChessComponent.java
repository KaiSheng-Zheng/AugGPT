import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;

    public KnightChessComponent(ChessboardPoint c,ChessColor b,char a) {
        source = c;
        super.setChessColor(b);
        name = a;
    }

    @Override
    public char getName() {
        return name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if (x-2>=0&&y-1>=0){
            if (chessboard[x-2][y-1].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x-2,y-1));
            }
        }
        else if (x-2>=0&&y+1<=7){
            if (chessboard[x-2][y+1].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x-2,y+1));
            }
        }
        else if (x-1>=0&&y-2>=0){
            if (chessboard[x-1][y-2].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x-1,y-2));
            }
        }
        else if (x-1>=0&&y+2<=7){
            if (chessboard[x-1][y+2].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x-1,y+2));
            }
        }
        else if (x+1<=7&&y-2>=0){
            if (chessboard[x+1][y-2].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x+1,y-2));
            }
        }
        else if (x+1<=7&&y+2<=7){
            if (chessboard[x+1][y+2].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x+1,y+2));
            }
        }
        else if (x+2<=7&&y-1>=0){
            if (chessboard[x+2][y-1].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x+2,y-1));
            }
        }
        else if (x+2<=7&&y+1<=7){
            if (chessboard[x+2][y+1].getChessColor()!=super.getChessColor()){
                points.add(new ChessboardPoint(x+2,y+1));
            }
        }
        return points;
    }
}
