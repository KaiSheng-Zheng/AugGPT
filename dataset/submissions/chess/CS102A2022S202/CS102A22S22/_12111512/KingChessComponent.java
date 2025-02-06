import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK){
            name = 'K';
        }
        else
            name = 'k';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (source.getX()+1<=7){
            if (chessboard[source.getX()+1][source.getY()].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()+1][source.getY()].getSource());
        }
        if (source.getX()+1<=7 && source.getY()+1<=7){
            if (chessboard[source.getX()+1][source.getY()+1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()+1][source.getY()+1].getSource());
        }
        if (source.getY()+1<=7){
            if (chessboard[source.getX()][source.getY()+1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()][source.getY()+1].getSource());
        }
        if (source.getX()-1>=0 && source.getY()+1<=7){
            if (chessboard[source.getX()-1][source.getY()+1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()-1][source.getY()+1].getSource());
        }
        if (source.getX()-1>=0){
            if (chessboard[source.getX()-1][source.getY()].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()-1][source.getY()].getSource());
        }
        if (source.getX()-1>=0 && source.getY()-1>=0){
            if (chessboard[source.getX()-1][source.getY()-1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()-1][source.getY()-1].getSource());
        }
        if (source.getY()-1>=0){
            if (chessboard[source.getX()][source.getY()-1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()][source.getY()-1].getSource());
        }
        if (source.getX()+1<=7 && source.getY()-1>=0){
            if (chessboard[source.getX()+1][source.getY()-1].getChessColor()!=this.chessColor)
                a.add(chessboard[source.getX()+1][source.getY()-1].getSource());
        }



        return a;
    }
}
