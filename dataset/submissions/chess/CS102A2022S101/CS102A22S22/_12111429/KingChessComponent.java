import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    final ChessboardPoint[] King_Moves = {
            new ChessboardPoint(0, 1),
            new ChessboardPoint(0, -1),
            new ChessboardPoint(-1, 1),
            new ChessboardPoint(1, 1),
            new ChessboardPoint(-1, -1),
            new ChessboardPoint(1, -1),
            new ChessboardPoint(1, 0),
            new ChessboardPoint(-1, 0),

    };

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint Source = new ChessboardPoint(getSource().getX(), getSource().getY());
        List<ChessboardPoint> Movable = new ArrayList<>();

        for(ChessboardPoint temp : King_Moves){
            ChessboardPoint points = Source.offset(temp.getX(), temp.getY());
            ChessComponent[][] board = getChessComponents();
            if(points != null && board[points.getX()][points.getY()].getChessColor() != this.getChessColor()){
                if(board[points.getX()][points.getY()].getChessColor() != ChessColor.NONE){
                    if(points.getY() != Source.getY())
                        Movable.add(points);
                }
                if(board[points.getX()][points.getY()].getChessColor() != ChessColor.NONE){
                    if(points.getY() != Source.getY()){
                        Movable.add(points);
                        if(board[points.getX() - 1][points.getY()].getChessColor() == ChessColor.NONE && Source.getX() == 6)
                            Movable.add(new ChessboardPoint(points.getX() - 1, points.getY()));
                        if(board[points.getX() + 1][points.getY()].getChessColor() == ChessColor.NONE && Source.getX() == 1)
                            Movable.add(new ChessboardPoint(points.getX() + 1, points.getY()));
                    }
                }

            }
        }
        return Movable;
    }


}
