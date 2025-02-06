import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x, int y, ChessColor chessColor, char name,ChessComponent[][] chessboard) {
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

        int r1=Math.min(source.getX(), target.getX());
        int r2=Math.max(source.getX(), target.getX());
        int c1=Math.min(source.getY(), target.getY());
        int c2=Math.max(source.getY(), target.getY());

        if ((source.getX() == target.getX() && source.getY() == target.getY()) || b.getChessColor() == getChessColor() || Math.abs(source.getX()-target.getX())!= Math.abs(source.getY()-target.getY())) {
            return false;
        }

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (!(i == source.getX() && j == source.getY()) && Math.abs(source.getX() - i) == Math.abs(source.getY() - j)){
                    if (!(i == target.getX() && j == target.getY()) && !(getChessboard()[i][j] instanceof EmptySlotComponent)){
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
