import java.util.ArrayList;
import java.util.List;

public class Queen extends  ChessComponent{
    Queen(){}

    @Override
    public void setName(final ChessColor chessColor) {
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name ='Q';
        }else{
            name = 'q';
        }
    }
    private final static ChessboardPoint[] QUEEN_MOVES = {
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
                QUEEN_MOVES) {
            ChessboardPoint candidatePoint = initialCoordinate.offset(tile.getX(), tile.getY());
            while (candidatePoint!=null){

                if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=this.getChessColor()){

                    legalMoves.add(candidatePoint);
                    if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=ChessColor.NONE) break;
                }else{
                    break;
                }

                candidatePoint = candidatePoint.offset(tile.getX(), tile.getY());

            }
        }
        return  legalMoves;
    }
}
