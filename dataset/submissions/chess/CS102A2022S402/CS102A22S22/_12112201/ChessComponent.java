
import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessColor getComponentColor(char component) {
        if (component == '_') {
            return ChessColor.NONE;
        }
        if (component >= 'A' && component <= 'Z') {
            return ChessColor.BLACK;
        } else {
            return ChessColor.WHITE;
        }
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'B';
        } else {
            this.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, ChessColor.NONE);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'P';
        } else {
            this.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kn = new ArrayList<>();
        ChessboardPoint new1 = source.offset(0, 1);
        if (new1 != null && getComponentColor(chessboard[new1.getX()][new1.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new1);
        }
        ChessboardPoint new2 = source.offset(1, 1);
        if (new2 != null && getComponentColor(chessboard[new2.getX()][new2.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new2);
        }
        ChessboardPoint new3 = source.offset(-1, 1);
        if (new3 != null && getComponentColor(chessboard[new3.getX()][new3.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new3);
        }
        ChessboardPoint new4 = source.offset(0, -1);
        if (new4 != null && getComponentColor(chessboard[new4.getX()][new4.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new4);
        }
        ChessboardPoint new5 = source.offset(1, -1);
        if (new5 != null && getComponentColor(chessboard[new5.getX()][new5.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new5);
        }
        ChessboardPoint new6 = source.offset(-1, -1);
        if (new6 != null && getComponentColor(chessboard[new6.getX()][new6.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new6);
        }
        ChessboardPoint new7 = source.offset(1, 0);
        if (new7 != null && getComponentColor(chessboard[new7.getX()][new7.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new7);
        }
        ChessboardPoint new8 = source.offset(-1, 0);
        if (new8 != null && getComponentColor(chessboard[new8.getX()][new8.getY()].toString().charAt(0)) != chessColor) {
            kn.add(new8);
        }
        return kn;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> king = new ArrayList<>();
        ChessboardPoint new11 = source.offset(-2, 1);
        if (new11 != null && getComponentColor(chessboard[new11.getX()][new11.getY()].toString().charAt(0)) != chessColor) {
            king.add(new11);
        }
        ChessboardPoint new21 = source.offset(-2, -1);
        if (new21 != null && getComponentColor(chessboard[new21.getX()][new21.getY()].toString().charAt(0)) != chessColor) {
            king.add(new21);
        }
        ChessboardPoint new31 = source.offset(-1, 2);
        if (new31 != null && getComponentColor(chessboard[new31.getX()][new31.getY()].toString().charAt(0)) != chessColor) {
            king.add(new31);
        }
        ChessboardPoint new41 = source.offset(1, 2);
        if (new41 != null && getComponentColor(chessboard[new41.getX()][new41.getY()].toString().charAt(0)) != chessColor) {
            king.add(new41);
        }
        ChessboardPoint new51 = source.offset(1, -2);
        if (new51 != null && getComponentColor(chessboard[new51.getX()][new51.getY()].toString().charAt(0)) != chessColor) {
            king.add(new51);
        }
        ChessboardPoint new61 = source.offset(-1, -2);
        if (new61 != null && getComponentColor(chessboard[new61.getX()][new61.getY()].toString().charAt(0)) != chessColor) {
            king.add(new61);
        }
        ChessboardPoint new71 = source.offset(2, 1);
        if (new71 != null && getComponentColor(chessboard[new71.getX()][new71.getY()].toString().charAt(0)) != chessColor) {
            king.add(new71);
        }
        ChessboardPoint new81 = source.offset(2, -1);
        if (new81 != null && getComponentColor(chessboard[new81.getX()][new81.getY()].toString().charAt(0)) != chessColor) {
            king.add(new81);
        }
        return king;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'Q';
        } else {
            this.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
    class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (this.chessColor.equals(ChessColor.BLACK)) {
            this.name = 'R';
        } else {
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        return null;
    }
}

