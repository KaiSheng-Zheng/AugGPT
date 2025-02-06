import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    protected char name;
    private  boolean canCross;
    protected int sgn;

    public  int getSgn() {
        return 0;
    }

    public ChessComponent(){};

    public boolean getCanCross() {return canCross;}

    public ChessComponent(ChessColor chessColor){this.chessColor=chessColor;}

    public  abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName(){
        return 'K';
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public String toString() {return String.valueOf(this.name);}

    public int getID(){
        return 1;
    }

    public static ChessComponent IDtoChessComponent(int Id,ChessColor chessColor){
        ChessComponent[] chessComponents={new KingChessComponent(chessColor),new QueenChessComponent(chessColor),new RookChessComponent(chessColor),
                new BishopChessComponent(chessColor),new KnightChessComponent(chessColor),new PawnChessComponent(chessColor),new EmptySlotComponent()};
        return chessComponents[Id];
    }



}
