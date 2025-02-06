import java.util.ArrayList;
import java.util.List;

public class PawnChessCompoent extends ChessComponent {
    public PawnChessCompoent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> PawnsLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        if (getChessColor() == ChessColor.WHITE){
            if (Y == 1) {
                PawnsLand.add(new ChessboardPoint(X, Y + 1));
                PawnsLand.add(new ChessboardPoint(X, Y + 2));
            }else {
                if (X >= 0 && X <= 7 && Y >=0 && Y+1 <= 7)
                PawnsLand.add(new ChessboardPoint(X, Y + 1));
            }
        }
        else if (getChessColor() == ChessColor.BLACK){
            if (Y == 6) {
                PawnsLand.add(new ChessboardPoint(X, Y - 2));
                PawnsLand.add(new ChessboardPoint(X, Y - 1));
            }else {
            if (X >= 0 && X <= 7 && Y <= 0 && Y - 1 >= 0)
                PawnsLand.add(new ChessboardPoint(X, Y - 1));
        }
        }

                return PawnsLand;
    }
}