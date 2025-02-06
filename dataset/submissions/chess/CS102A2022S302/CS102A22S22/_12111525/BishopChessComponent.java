import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super(source,chessColor);
        this.chessColor = chessColor;
        this.source = source;
        if (chessColor == ChessColor.BLACK){
            name = 'B';
        }
        if (chessColor == ChessColor.WHITE){
            name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> F = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (source.getX()+i>7||source.getY()+i>7)
                break;
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor){
                F.add(chessboard[source.getX()+i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor() == this.chessColor)
                break;
        }
        for (int i = 0; i < 8; i++) {
            if (source.getX()+i>7||source.getY()-i<0)
                break;
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor){
                F.add(chessboard[source.getX()+i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor() == this.chessColor)
                break;
        }
        for (int i = 0; i < 8; i++) {
            if (source.getX()-i<0||source.getY()+i>7)
                break;
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor){
                F.add(chessboard[source.getX()+i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor() == this.chessColor)
                break;
        }
        for (int i = 0; i < 8; i++) {
            if (source.getX()-i<0||source.getY()-i<0)
                break;
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor){
                F.add(chessboard[source.getX()+i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor() == this.chessColor)
                break;
        }
        return F;

    }
}
