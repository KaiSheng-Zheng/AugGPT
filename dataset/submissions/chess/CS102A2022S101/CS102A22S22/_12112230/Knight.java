import java.util.ArrayList;
import java.util.List;

public class Knight extends  ChessComponent{
    Knight(){}

    @Override
    public void setName(final ChessColor chessColor) {
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name ='N';
        }else{
            name = 'n';
        }
    }
    private final static ChessboardPoint[] KNIGHT_MOVES = {
            new ChessboardPoint(-1,-2),
            new ChessboardPoint(-2,-1),
            new ChessboardPoint(-2,1),
            new ChessboardPoint(-1,2),
            new ChessboardPoint(1,2),
            new ChessboardPoint(2,1),
            new ChessboardPoint(2,-1),
            new ChessboardPoint(1,-2),
    };
    @Override
    public List<ChessboardPoint> canMoveTo() {
        final ChessboardPoint initialCoordinate = new ChessboardPoint(getSource().getX(), getSource().getY());
        final List<ChessboardPoint> legalMoves =  new ArrayList<>();
        for (final ChessboardPoint tile:
                KNIGHT_MOVES) {
            final ChessboardPoint candidatePoint = initialCoordinate.offset(tile.getX(), tile.getY());
            if (candidatePoint!=null){
                if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=this.getChessColor()){
                    legalMoves.add(candidatePoint);
                }
            }
        }
        return legalMoves;
    }
}
