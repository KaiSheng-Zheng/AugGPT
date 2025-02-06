import java.util.ArrayList;
import java.util.List;

// KingChessComponent
class KingChessComponent extends ChessComponent {

    // constructor
    public KingChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                ChessboardPoint point = new ChessboardPoint(i, j);
                canMoveTo.add(point);
            }
        }

        return canMoveTo;
    }

}

// QueenChessComponent
class QueenChessComponent extends ChessComponent {

    // constructor
    public QueenChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        for (int i = -8; i <= 8; i++) {
            for (int j = -8; j <= 8; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == j || i == -j || i == 0 || j == 0) {
                    ChessboardPoint point = new ChessboardPoint(i, j);
                    canMoveTo.add(point);
                }
            }
        }

        return canMoveTo;
    }

}

// RookChessComponent
class RookChessComponent extends ChessComponent {

    // constructor
    public RookChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        // can move to
        for (int i = -8; i <= 8; i++) {
            for (int j = -8; j <= 8; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    ChessboardPoint point = new ChessboardPoint(i, j);
                    canMoveTo.add(point);
                }
            }
        }

        return canMoveTo;
    }

}

// BishopChessComponent
class BishopChessComponent extends ChessComponent {

    // constructor
    public BishopChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        // can move to
        for (int i = -8; i <= 8; i++) {
            for (int j = -8; j <= 8; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == j || i == -j) {
                    ChessboardPoint point = new ChessboardPoint(i, j);
                    canMoveTo.add(point);
                }
            }
        }

        return canMoveTo;
    }

}

// KnightChessComponent
class KnightChessComponent extends ChessComponent {

    // constructor
    public KnightChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        // can move to
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) == 1 && Math.abs(j) == 2) {
                    ChessboardPoint point = new ChessboardPoint(i, j);
                    canMoveTo.add(point);
                } else if (Math.abs(i) == 2 && Math.abs(j) == 1) {
                    ChessboardPoint point = new ChessboardPoint(i, j);
                    canMoveTo.add(point);
                }
            }
        }

        return canMoveTo;
    }

}

// PawnChessComponent
class PawnChessComponent extends ChessComponent {

    // constructor
    public PawnChessComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();

        // can move to
        ChessboardPoint point;
        point = new ChessboardPoint(-2, 0);
        canMoveTo.add(point);
        point = new ChessboardPoint(-1, -1);
        canMoveTo.add(point);
        point = new ChessboardPoint(-1, 0);
        canMoveTo.add(point);
        point = new ChessboardPoint(-1, 1);
        canMoveTo.add(point);
        point = new ChessboardPoint(1, -1);
        canMoveTo.add(point);
        point = new ChessboardPoint(1, 0);
        canMoveTo.add(point);
        point = new ChessboardPoint(1, 1);
        canMoveTo.add(point);
        point = new ChessboardPoint(2, 0);
        canMoveTo.add(point);

        return canMoveTo;
    }

}

// EmptySlotComponent
class EmptySlotComponent extends ChessComponent {

    // constructor
    public EmptySlotComponent() {
        super();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}