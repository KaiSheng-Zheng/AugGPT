import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessComponent{
    Pawn(){}

    @Override
    public void setName(final ChessColor chessColor) {
        setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE){
            name ='p';
        }else{
            name = 'P';
        }
    }
    private final static ChessboardPoint[] WHITE_PAWN_MOVES = {
            new ChessboardPoint(-1,0),
            new ChessboardPoint(-1,-1),
            new ChessboardPoint(-1,1),

    };
    private final static ChessboardPoint[] BLACK_PAWN_MOVES = {
            new ChessboardPoint(1,0),
            new ChessboardPoint(1,-1),
            new ChessboardPoint(1,1),

    };
    @Override
    public List<ChessboardPoint> canMoveTo() {
        final ChessboardPoint initialCoordinate = new ChessboardPoint(getSource().getX(), getSource().getY());
        final List<ChessboardPoint> legalMoves =  new ArrayList<>();
        if (this.getChessColor()==ChessColor.BLACK){
            for (ChessboardPoint tile :
                    BLACK_PAWN_MOVES) {
                final ChessboardPoint candidatePoint = initialCoordinate.offset(tile.getX(), tile.getY());
                if (candidatePoint!=null&&board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=this.getChessColor()){
                    if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=ChessColor.NONE&&candidatePoint.getY()!= initialCoordinate.getY()) legalMoves.add(candidatePoint);

                    if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()==ChessColor.NONE&&candidatePoint.getY()== initialCoordinate.getY()) {
                        legalMoves.add(candidatePoint);
                        if (board[candidatePoint.getX()+1][candidatePoint.getY()].getChessColor()==ChessColor.NONE&&initialCoordinate.getX()==1) {
                            legalMoves.add(new ChessboardPoint(candidatePoint.getX() + 1, candidatePoint.getY()));
                        }
                    }
                }
            }

        }else{
            for (ChessboardPoint tile :
                    WHITE_PAWN_MOVES) {
                final ChessboardPoint candidatePoint = initialCoordinate.offset(tile.getX(), tile.getY());
                if (candidatePoint!=null&&board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=this.getChessColor()){
                    if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()!=ChessColor.NONE&&candidatePoint.getY()!= initialCoordinate.getY()) legalMoves.add(candidatePoint);

                    if (board[candidatePoint.getX()][candidatePoint.getY()].getChessColor()==ChessColor.NONE&&candidatePoint.getY()== initialCoordinate.getY()) {
                        legalMoves.add(candidatePoint);
                        if (board[candidatePoint.getX()-1][candidatePoint.getY()].getChessColor()==ChessColor.NONE&&initialCoordinate.getX()==6) {
                            legalMoves.add(new ChessboardPoint(candidatePoint.getX() - 1, candidatePoint.getY()));
                        }
                    }
                }
            }
        }
        return legalMoves;
    }
}
