import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;// What's the name
    private ChessboardPoint souce1;
    int cnt = 0;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        super.name = name;
        this.chessColor = chessColor;
        this.source = source;
        super.chessColor1 = chessColor;
        this.souce1 = new ChessboardPoint(source.getX(), source.getY());
    }


    public boolean canMoveTo1(ChessboardPoint destination) {

        if (ConcreteChessGame.chessComponents11[destination.getX()][destination.getY()].getChessColor().equals(chessColor)) {
            return false;
        }

        if (ConcreteChessGame.chessComponents11[destination.getX()][destination.getY()] instanceof EmptySlotComponent) {
        } else return false;
        if (destination.getX() != source.getX()) {
            return false;
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            if (source.getY() == 6) {
                if (destination.getY() - source.getY() == 1 || destination.getY() - source.getY() == 2) {
                    if (destination.getY() - source.getY() == 2) {
                        if (ConcreteChessGame.chessComponents11[destination.getX()][destination.getY() + 1] instanceof EmptySlotComponent) {

                        }else {return false;}
                    }

                } else return false;
            } else {
                if (destination.getY() - source.getY() == 1) {

                } else return false;
            }
        }
        if (chessColor.equals(ChessColor.BLACK)) {
            if (source.getY() == 1) {
                if (destination.getY() - source.getY() == -1 || destination.getY() - source.getY() == -2) {
                    if (destination.getY() - source.getY() == -1 || destination.getY() - source.getY() == -2) {
                        if (destination.getY() - source.getY() == -2) {
                            if (ConcreteChessGame.chessComponents11[destination.getX()][destination.getY() - 1] instanceof EmptySlotComponent) {
                            } else {
                                return false;
                            }

                        } else return false;
                    } else {
                        if (destination.getY() - source.getY() == -1) {

                        } else return false;

                    }
                }}}
                return true;
            }


            @Override
            public List<ChessboardPoint> canMoveTo () {
                List<ChessboardPoint> i = new ArrayList<>();
                for (int x = 0; x <= 7; x++) {
                    for (int y = 0; y <= 7; y++) {

                        if (canMoveTo1(chessboardPoints[x][y])) {
                            i.add(chessboardPoints[x][y]);
                        }
                    }

                }
                return i;


            }
            public void changeSource ( int x, int y){
                source = new ChessboardPoint(x, y);
            }


        }
