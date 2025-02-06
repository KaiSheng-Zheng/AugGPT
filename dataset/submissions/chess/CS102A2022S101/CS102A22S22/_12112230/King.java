import java.util.ArrayList;
import java.util.List;

public class King extends  ChessComponent{
    King(){}

    @Override
    public void setName(final ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name ='K';
        }else{
            name = 'k';
        }
    }
    private final static ChessboardPoint[] KING_MOVES = {
            new ChessboardPoint(1,0),
            new ChessboardPoint(1,-1),
            new ChessboardPoint(0,-1),
            new ChessboardPoint(-1,-1),
            new ChessboardPoint(-1,0),
            new ChessboardPoint(-1,1),
            new ChessboardPoint(0,1),
            new ChessboardPoint(1,1),
    };
    @Override
    public List<ChessboardPoint> canMoveTo() {
        final ChessboardPoint initialCoordinate = new ChessboardPoint(getSource().getX(), getSource().getY());
        final List<ChessboardPoint> legalMoves =  new ArrayList<>();
        for (final ChessboardPoint tile:
             KING_MOVES) {
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
