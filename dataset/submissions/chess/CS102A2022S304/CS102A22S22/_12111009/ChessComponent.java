import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessboard=new ChessComponent[8][8];

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    //public ChessComponent[]
    public static ChessComponent transbyChar(int x,int y,char name){
        if (name=='_'){
            return new EmptySlotComponent(new ChessboardPoint(x, y));
        }else if (name=='B'||name=='b'){
            return new BishopChessComponent(new ChessboardPoint(x, y),name);
        }else if (name=='K'||name=='k') {
            return new KingChessComponent(new ChessboardPoint(x, y), name);
        }else if (name=='N'||name=='n') {
            return new KnightChessComponent(new ChessboardPoint(x, y), name);
        }else if (name=='P'||name=='p') {
            return new PawnChessComponent(new ChessboardPoint(x, y), name);
        }else if (name=='Q'||name=='q') {
            return new QueenChessComponent(new ChessboardPoint(x, y), name);
        }else if (name=='R'||name=='r') {
            return new RookChessComponent(new ChessboardPoint(x, y), name);
        }return null;
    }
}