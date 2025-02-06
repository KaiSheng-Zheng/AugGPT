import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor; }

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
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'K':'k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'R':'r';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'P':'p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent (ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'B':'b';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}


