import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name,ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint, name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> destinations = new ArrayList<>();

        for (int i = 0; i < this.getConcreteChessGame().getChessComponents().length; i++) {
            for (int j = 0; j < this.getConcreteChessGame().getChessComponents()[i].length; j++) {
                boolean canMoveTo = true;

                ChessboardPoint source = this.getSource();
                ChessboardPoint destination = new ChessboardPoint(i,j);
                ChessComponent[][]chessComponents = getConcreteChessGame().getChessComponents();

                if (source.getX() == destination.getX()) {
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), destination.getY()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    }
                } else if (source.getY() == destination.getY()) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    }
                } else if (Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY())) {
                    if (source.getX() < destination.getX() && source.getY() < destination.getY()) {
                        for (int col = source.getY() + 1, row = source.getX() + 1; col < destination.getY(); col++, row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }

                        }
                    } else if (source.getX() > destination.getX() && source.getY() > destination.getY()) {
                        for (int col = destination.getY() + 1, row = destination.getX() + 1; col < source.getY(); col++, row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
                        }
                    } else if (source.getX() < destination.getX() && source.getY() > destination.getY()) {
                        for (int col = source.getY() - 1, row = source.getX() + 1; col > destination.getY(); col--, row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                canMoveTo = false;
                            }
                        }
                    } else if (source.getX() > destination.getX() && source.getY() < destination.getY()) {
                        for (int col = destination.getY() - 1, row = destination.getX() + 1; col > source.getY(); col--, row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
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
                    destinations.add(new ChessboardPoint(i,j));
                }
            }
        }
        return destinations;
    }
}
