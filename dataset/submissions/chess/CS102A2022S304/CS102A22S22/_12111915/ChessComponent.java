import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent() {
    }

    @Override

    public List<ChessboardPoint> canMoveTo() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (i!=1&&j!=1) {
                    if (getSource().offset(i-1,j-1)!=null) {
                        canMoveTo().add(getSource().offset(i-1,j-1));
                    }
                }
            }
        }
        return canMoveTo();
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 1; i<8; i++) {
            if (getSource().offset(i,0)!=null) {
                canMoveTo().add(getSource().offset(i,0));
            }
            if (getSource().offset(-i,0)!=null) {
                canMoveTo().add(getSource().offset(-i,0));
            }
            if (getSource().offset(0,i)!=null) {
                canMoveTo().add(getSource().offset(0,i));
            }
            if (getSource().offset(0,-i)!=null) {
                canMoveTo().add(getSource().offset(0,-i));
            }
            if (getSource().offset(i,i)!=null) {
                canMoveTo().add(getSource().offset(i,i));
            }
            if (getSource().offset(i,-i)!=null) {
                canMoveTo().add(getSource().offset(i,-i));
            }
            if (getSource().offset(-i,i)!=null) {
                canMoveTo().add(getSource().offset(-i,i));
            }
            if (getSource().offset(-i,-i)!=null) {
                canMoveTo().add(getSource().offset(-i,-i));
            }
        }
        return canMoveTo();
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 1; i<8; i++) {
            if (getSource().offset(i,0)!=null) {
                canMoveTo().add(getSource().offset(i,0));
            }
            if (getSource().offset(-i,0)!=null) {
                canMoveTo().add(getSource().offset(-i,0));
            }
            if (getSource().offset(0,i)!=null) {
                canMoveTo().add(getSource().offset(0,i));
            }
            if (getSource().offset(0,-i)!=null) {
                canMoveTo().add(getSource().offset(0,-i));
            }
        }
        return canMoveTo();
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 1; i<8; i++) {
            if (getSource().offset(i,i)!=null) {
                canMoveTo().add(getSource().offset(i,i));
            }
            if (getSource().offset(i,-i)!=null) {
                canMoveTo().add(getSource().offset(i,-i));
            }
            if (getSource().offset(-i,i)!=null) {
                canMoveTo().add(getSource().offset(-i,i));
            }
            if (getSource().offset(-i,-i)!=null) {
                canMoveTo().add(getSource().offset(-i,-i));
            }
        }
        return canMoveTo();
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (getSource().offset(2*i-1,4*j-2)!=null) {
                    canMoveTo().add(getSource().offset(2*i-1,4*j-2));
                }
                if (getSource().offset(4*i-2,2*j-1)!=null) {
                    canMoveTo().add(getSource().offset(4*i-2,2*j-1));
                }
            }
        }
        return canMoveTo();
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 0; i < 7; i++) {
            if (getSource().offset(0,i)!=null) {
                canMoveTo().add(getSource().offset(0,i));
            }
        }
        return canMoveTo();
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public EmptySlotComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}