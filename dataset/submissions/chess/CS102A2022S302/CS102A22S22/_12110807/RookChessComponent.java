import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent() {}

    public RookChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name,ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint,name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destination = new ArrayList<>();

        for (int i = 0; i < this.getConcreteChessGame().getChessComponents().length; i++) {
            for (int j = 0; j < this.getConcreteChessGame().getChessComponents()[i].length; j++) {
                boolean canMoveTo = true;
                if (this.getSource().getX() == i) {
                    int row = this.getSource().getX();
                    for (int col = Math.min(this.getSource().getY(), j) + 1;
                         col < Math.max(this.getSource().getY(), j); col++) {
                        if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    }
                } else if (this.getSource().getY() == j) {
                    int col = this.getSource().getY();
                    for (int row = Math.min(this.getSource().getX(), i) + 1;
                         row < Math.max(this.getSource().getX(), i); row++) {
                        if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    }
                } else {
                    canMoveTo = false;
                }

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
