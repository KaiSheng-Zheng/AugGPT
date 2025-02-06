import java.util.ArrayList;
import java.util.List;

class KingChessComponent extends ChessComponent {

    public KingChessComponent() {
    }

    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (getSource().offset(i, j) != null && !(i == 0 && j == 0) && getChessComponents()[getSource().offset(i, j).getX()][getSource().offset(i, j).getY()].getChessColor() != getChessColor()) {
                    points.add(getSource().offset(i, j));
                }
            }
        }
        return points;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        points.addAll(straight());
        points.addAll(diagonal());
        return points;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent() {
    }

    public RookChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        return straight();
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        return diagonal();
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(getSource().getX() - i) == 1 && Math.abs(getSource().getY() - j) == 2) || (Math.abs(getSource().getX() - i) == 2 && Math.abs(getSource().getY() - j) == 1)) {
                    if (getChessComponents()[i][j].getChessColor() != getChessColor()) {
                        points.add(new ChessboardPoint(i, j));
                    }
                }

            }
        }
        return points;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() == 1) {
                if(isNone(1,0)) {
                    points.add(getSource().offset(1, 0));
                }
                if(isNone(1,0) && isNone(2,0)) {
                    points.add(getSource().offset(2, 0));
                }
            } else if(getSource().offset(1,0) != null && isNone(1,0)){
                points.add(getSource().offset(1, 0));
            }

            if(getSource().offset(1,1) != null && isOppositeColor(1,1)){
                points.add(getSource().offset(1, 1));
            }
            if(getSource().offset(1,-1) != null && isOppositeColor(1,-1)){
                points.add(getSource().offset(1, -1));
            }
        }
        if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() == 6) {
                if(isNone(-1,0)) {
                    points.add(getSource().offset(-1, 0));
                }
                if(isNone(-1,0) && isNone(-2,0)) {
                    points.add(getSource().offset(-2, 0));
                }
            } else if(getSource().offset(-1,0) != null && isNone(-1,0)){
                points.add(getSource().offset(-1, 0));
            }

            if(getSource().offset(-1,1) != null && isOppositeColor(-1,1)){
                points.add(getSource().offset(-1, 1));
            }
            if(getSource().offset(-1,-1) != null && isOppositeColor(-1,-1)){
                points.add(getSource().offset(-1, -1));
            }
        }
        return points;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessColor chessColor) {
        super(chessColor);
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}