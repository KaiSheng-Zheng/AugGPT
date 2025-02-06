import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor,source);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='N';
        }else{
            this.name='n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        if (source.getX()+2<8&&source.getY()+1<8) {
            if (!super.chessboard[source.getX()+2][source.getY()+1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 2, source.getY() + 1));
            }
        }
        if (source.getX()+1<8&&source.getY()+2<8) {
            if (!super.chessboard[source.getX()+1][source.getY()+2].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() + 2));
            }
        }
        if (source.getX()-2>=0&&source.getY()+1<8) {
            if (!super.chessboard[source.getX()-2][source.getY()+1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 2, source.getY() + 1));
            }
        }
        if (source.getX()-1>=0&&source.getY()+2<8) {
            if (!super.chessboard[source.getX()-1][source.getY()+2].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() + 2));
            }
        }
        if (source.getX()-1>=0&&source.getY()-2>=0) {
            if (!super.chessboard[source.getX()-1][source.getY()-2].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() - 2));
            }
        }
        if (source.getX()-2>=0&&source.getY()-1>=0) {
            if (!super.chessboard[source.getX()-2][source.getY()-1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() - 2, source.getY() - 1));
            }
        }
        if (source.getX()+2<8&&source.getY()-1>=0) {
            if (!super.chessboard[source.getX()+2][source.getY()-1].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 2, source.getY() - 1));
            }
        }
        if (source.getX()+1<8&&source.getY()-2>=0) {
            if (!super.chessboard[source.getX()+1][source.getY()-2].chessColor.equals(
                    super.chessboard[source.getX()][source.getY()].chessColor)) {
                moveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() - 2));
            }
        }
        return moveTo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}