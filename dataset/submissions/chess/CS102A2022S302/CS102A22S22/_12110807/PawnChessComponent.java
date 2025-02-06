import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean isFirst = true;


    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name, ConcreteChessGame chessGame) {
        super(chessColor, chessboardPoint, name, chessGame);
    }

    public void setFirst(boolean first) {
        isFirst = first;
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

                if (this.getChessColor() == ChessColor.BLACK) {
                    if (source.getX() == 1 && source.getY() == destination.getY()
                            && (destination.getX() == 2 || destination.getX() == 3)) {
                        int col = source.getY();
                        if ((destination.getX() == 2 && (!(chessComponents[2][col] instanceof EmptySlotComponent)))
                                || (destination.getX() == 3 && (!(chessComponents[2][col] instanceof EmptySlotComponent) || !(chessComponents[3][col] instanceof EmptySlotComponent)))) {
                            canMoveTo = false;
                        }
                    } else if (source.getX() != 1 && source.getY() == destination.getY() && destination.getX() - source.getX() == 1) {
                        int col = source.getY();
                        int row = destination.getX();
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    } else if (destination.getX() - source.getX() == 1 && Math.abs(source.getY() - destination.getY()) == 1) {

                        if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent
                                || chessComponents[destination.getX()][destination.getY()].getChessColor().equals(ChessColor.BLACK)) {
                            canMoveTo = false;
                        }
                    } else {
                        canMoveTo = false;
                    }
                } else if (this.getChessColor() == ChessColor.WHITE) {
                    if (source.getX() == 6 && source.getY() == destination.getY()
                            && (destination.getX() == 5 || destination.getX() == 4)) {
                        int col = source.getY();
                        if ((destination.getX() == 5 && (!(chessComponents[5][col] instanceof EmptySlotComponent)))
                                || (destination.getX() == 4 && (!(chessComponents[5][col] instanceof EmptySlotComponent) || !(chessComponents[4][col] instanceof EmptySlotComponent)))) {
                            canMoveTo = false;
                        }
                    } else if (source.getX() != 6 && source.getY() == destination.getY() && source.getX() - destination.getX() == 1) {
                        int col = source.getY();
                        int row = destination.getX();
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            canMoveTo = false;
                        }
                    } else if (source.getX() - destination.getX() == 1 && Math.abs(source.getY() - destination.getY()) == 1) {
                        if (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent
                                || chessComponents[destination.getX()][destination.getY()].getChessColor().equals(ChessColor.WHITE)) {
                            canMoveTo = false;
                        }
                    } else {
                        canMoveTo = false;
                    }
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
