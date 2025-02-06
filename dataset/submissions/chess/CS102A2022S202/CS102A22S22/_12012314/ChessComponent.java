import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){

    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString(){
        return String.valueOf(name);
    }
}

class EmptyChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public EmptyChessComponent(){
        this.name = '_';
        this.chessColor = ChessColor.NONE;
    }

    @Override
    public String toString() {
        return "_";
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'k';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'Q';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'q';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'B';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'b';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'P';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'p';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'R';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'r';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor chessColor){
        if (chessColor == ChessColor.BLACK){
            this.name = 'N';
        }
        else if (chessColor == ChessColor.WHITE){
            this.name = 'n';
        }
        else this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        return a;
    }
}