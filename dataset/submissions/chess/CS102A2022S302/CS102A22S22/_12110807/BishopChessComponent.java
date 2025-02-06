import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name,ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint,name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destination = new ArrayList<>();

        for (int i = 0; i < this.getConcreteChessGame().getChessComponents().length; i++) {
            for (int j = 0; j < this.getConcreteChessGame().getChessComponents()[i].length; j++) {
                boolean canMoveTo = true;
                if (Math.abs(this.getSource().getX() - i) == Math.abs(this.getSource().getY() - j)) {
                    if (this.getSource().getX() < i && this.getSource().getY() < j) {
                        for (int col = this.getSource().getY() + 1, row = this.getSource().getX() + 1; col < j; col++, row++) {
                            if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
                        }
                    } else if (this.getSource().getX() > i && this.getSource().getY() > j) {
                        for (int col = j + 1, row = i + 1; col < this.getSource().getY(); col++, row++) {
                            if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
                        }
                    } else if (this.getSource().getX() < i && this.getSource().getY() > j) {
                        for (int col = this.getSource().getY() - 1, row = this.getSource().getX() + 1; col > j; col--, row++) {
                            if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
                        }
                    } else if (this.getSource().getX() > i && this.getSource().getY() < j) {
                        for (int col = j - 1, row = i + 1; col > this.getSource().getY(); col--, row++) {
                            if (!(this.getConcreteChessGame().getChessComponents()[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
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
