import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> knightsteps = new ArrayList<>();
        ChessboardPoint knight = new ChessboardPoint(getSource().getX(), getSource().getY());
        if (knight.offset(knight.getX() + 1, knight.getY() + 2) != null) {
            knightsteps.add(knight.offset(knight.getX() + 1, knight.getY() + 2));
        }
        if (knight.offset(knight.getX() + 1, knight.getY() - 2) != null) {
            knightsteps.add(knight.offset(knight.getX() + 1, knight.getY() + 2));
        }
        if (knight.offset(knight.getX() - 1, knight.getY() + 2) != null) {
            knightsteps.add(knight.offset(knight.getX() + 1, knight.getY() + 2));
        }
        if (knight.offset(knight.getX() - 1, knight.getY() - 2) != null) {
            knightsteps.add(knight.offset(knight.getX() + 1, knight.getY() + 2));
        }
        if (knight.offset(knight.getX() + 2, knight.getY() + 1) != null) {
            knightsteps.add(knight.offset(knight.getX() + 2, knight.getY() + 1));
        }
        if (knight.offset(knight.getX() + 2, knight.getY() - 1) != null) {
            knightsteps.add(knight.offset(knight.getX() + 2, knight.getY() + 1));
        }
        if (knight.offset(knight.getX() - 2, knight.getY() + 1) != null) {
            knightsteps.add(knight.offset(knight.getX() + 2, knight.getY() + 1));
        }
        if (knight.offset(knight.getX() - 2, knight.getY() - 1) != null) {
            knightsteps.add(knight.offset(knight.getX() + 2, knight.getY() + 1));
        }
        return knightsteps;
    }
    public boolean isLegal(ChessboardPoint source,ChessboardPoint target){

        return false;
    }

}
