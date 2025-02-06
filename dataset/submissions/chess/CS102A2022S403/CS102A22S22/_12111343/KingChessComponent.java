import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor,source);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='K';
        }else{
            this.name='k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        if (source.getX()+1<8) {
            if (!super.chessboard[source.getX()+1][source.getY()].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor) ){
                moveTo.add(new ChessboardPoint(source.getX() + 1, source.getY()));
            }
        }
        if (source.getY()+1<8) {
            if (!super.chessboard[source.getX()][source.getY()+1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX(), source.getY() + 1));
            }
        }
        if (source.getX()-1>=0) {
            if (!super.chessboard[source.getX()-1][source.getY()].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 1, source.getY()));
            }
        }
        if (source.getY()-1>=0) {
            if (!super.chessboard[source.getX()][source.getY()-1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX(), source.getY() - 1));
            }
        }
        if (source.getX()+1<8&&source.getY()+1<8) {
            if (!super.chessboard[source.getX()+1][source.getY()+1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
            }
        }
        if (source.getX()-1>=0&&source.getY()+1<8) {
            if (!super.chessboard[source.getX()-1][source.getY()+1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
            }
        }
        if (source.getX()-1>=0&&source.getY()-1>=0) {
            if (!super.chessboard[source.getX()-1][source.getY()-1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
            }
        }
        if (source.getX()+1<8&&source.getY()-1>=0) {
            if (!super.chessboard[source.getX()+1][source.getY()-1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
            }
        }
        return moveTo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
