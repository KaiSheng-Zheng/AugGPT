import java.util.List;

class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name=chessColor==ChessColor.BLACK?'K':'k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}