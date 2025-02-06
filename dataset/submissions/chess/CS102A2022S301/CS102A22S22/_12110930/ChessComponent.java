import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public ChessComponent() {
    }

    public void setSource(ChessboardPoint s) {
        this.source = s;
    }

    public void setColor(ChessColor c) {
        this.chessColor = c;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'K' : 'k';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'Q' : 'q';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'R' : 'r';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'B' : 'b';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'N' : 'n';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = c == ChessColor.BLACK ? 'P' : 'p';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint s, ChessColor c) {
        super.setSource(s);
        super.setColor(c);
        super.name = '_';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<ChessboardPoint>();

        return res;
    }
}
