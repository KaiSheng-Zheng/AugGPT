import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(int x, int y, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(x, y, chessColor,name,chessboard);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ableToMoveTo(getChessboard()[i][j])){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }

    public boolean ableToMoveTo(ChessComponent b) {
        ChessboardPoint source = getSource();
        ChessboardPoint target = b.getSource();

        int r = Math.abs(source.getX()-target.getX());
        int c = Math.abs(source.getY()-target.getY());

        if ((source.getX() == target.getX() && source.getY() == target.getY()) || b.getChessColor() == getChessColor()) {
            return false;
        }

        return (r + c == 1) || (r == 1 && c == 1 && Math.abs(source.getX() - target.getX()) == Math.abs(source.getY() - target.getY()));
    }
}
