import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    final ChessboardPoint[] Rook_Moves = {
            new ChessboardPoint(-1,0),
            new ChessboardPoint(1, 0),
            new ChessboardPoint(0, -1),
            new ChessboardPoint(0, 1),
    };

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint Source = new ChessboardPoint(getSource().getX(), getSource().getY());
        List<ChessboardPoint> Movable = new ArrayList<>();

        for(ChessboardPoint temp : this.Rook_Moves){
            ChessboardPoint points = Source.offset(temp.getX(), temp.getY());

            ChessComponent[][] board = getChessComponents();
            while(points != null){
                if(board[points.getX()][points.getY()].getChessColor() != this.getChessColor()){
                    Movable.add(points);
                    if(board[points.getX()][points.getY()].getChessColor() != ChessColor.NONE)
                        break;
                }
                points = points.offset(temp.getX(), temp.getY());
            }
        }
        return Movable;
    }

}
