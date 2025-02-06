import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    public boolean canMoveTo(ChessboardPoint start, ChessboardPoint destination) {
        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(getChessboard()[destination.getX()][destination.getY()].getChessColor())) {
            return false;
        }
        ChessboardPoint source = start;

        

        int startX = source.getY();
        int startY = source.getX();
        int toX = destination.getY();
        int toY = destination.getX();

        boolean a1 = toX == startX + 1 && toY == startY + 2;
        boolean a2 = toX == startX + 1 && toY == startY - 2;
        boolean a3 = toX == startX - 1 && toY == startY + 2;
        boolean a4 = toX == startX - 1 && toY == startY - 2;
        boolean a5 = toX == startX + 2 && toY == startY + 1;
        boolean a6 = toX == startX + 2 && toY == startY - 1;
        boolean a7 = toX == startX - 2 && toY == startY + 1;
        boolean a8 = toX == startX - 2 && toY == startY - 1;
        if (a1 || a2 || a3 || a4 || a5 || a6 || a7 || a8){
            return true;
        }

            return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> value = new ArrayList<>();
        int startX = this.getSource().getX();
        int startY = this.getSource().getY();
        int toX;
        int toY;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(this.getSource(), getChessboard()[i][j].getSource())) {
                    value.add(getChessboard()[i][j].getSource());
                }

            }

        }
        return value;
    }
}
