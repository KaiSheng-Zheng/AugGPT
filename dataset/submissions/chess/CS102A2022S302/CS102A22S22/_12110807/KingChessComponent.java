import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    public KingChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name,ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint,name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destination = new ArrayList<>();

        for (int i = 0; i < this.getConcreteChessGame().getChessComponents().length; i++) {
            for (int j = 0; j < this.getConcreteChessGame().getChessComponents()[i].length; j++) {
                boolean canMoveTo = ((Math.abs(this.getSource().getX() - i) == 1 && Math.abs(this.getSource().getY() - j) == 0)
                        || Math.abs(this.getSource().getY() - j) == 1 && Math.abs(this.getSource().getX() - i) == 0)
                        || (Math.abs(this.getSource().getX() - i) == 1 && Math.abs(this.getSource().getY() - j) == 1);

                if (getConcreteChessGame().getChessComponents()[i][j].getChessColor() == getChessColor() ){
                    canMoveTo = false;
                }


                if (canMoveTo){
                    destination.add(new ChessboardPoint(i,j));
                }
            }
        }

        return destination;
    }
}
