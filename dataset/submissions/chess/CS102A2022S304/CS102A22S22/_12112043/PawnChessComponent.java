import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> can = new ArrayList<>();
        ChessColor color = getChessColor();
                if (color == ChessColor.BLACK) {
                    if (source.getX() == 1) {
                        if (chessboard[2][source.getY()] instanceof EmptySlotComponent) {
                            ChessboardPoint destination = new ChessboardPoint(2, source.getY());
                            can.add(destination);
                        }
                        if (chessboard[3][source.getY()] instanceof EmptySlotComponent) {
                            ChessboardPoint destination = new ChessboardPoint(3, source.getY());
                            can.add(destination);
                        }
                    } else {
                        if (chessboard[source.getX()+1][source.getY()] instanceof EmptySlotComponent) {
                            ChessboardPoint destination = new ChessboardPoint(source.getX()+1, source.getY());
                            can.add(destination);
                        }
                    }
                    if (source.getX() + 1 < 8 ) {
                        if (source.getY() + 1 < 8){
                        if (chessboard[source.getX() + 1][source.getY() + 1].chessColor==ChessColor.WHITE){
                            ChessboardPoint destination = new ChessboardPoint(source.getX() + 1, source.getY()+1);
                            can.add(destination);
                        }
                    }
                        if (source.getY()-1>=0){
                            if (chessboard[source.getX() + 1][source.getY() - 1].chessColor==ChessColor.WHITE){
                                ChessboardPoint destination = new ChessboardPoint(source.getX() + 1, source.getY()-1);
                                can.add(destination);
                            }
                        }
                    }

                }
        if (color == ChessColor.WHITE) {
            if (source.getX() == 6) {
                if (chessboard[5][source.getY()] instanceof EmptySlotComponent) {
                    ChessboardPoint destination = new ChessboardPoint(5, source.getY());
                    can.add(destination);
                }
                if (chessboard[4][source.getY()] instanceof EmptySlotComponent) {
                    ChessboardPoint destination = new ChessboardPoint(4, source.getY());
                    can.add(destination);
                }
            } else {
                if (chessboard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {
                    ChessboardPoint destination = new ChessboardPoint(source.getX()-1, source.getY());
                    can.add(destination);
                }
            }
            if (source.getX() - 1 >= 0) {
                if (source.getY() + 1 < 8) {
                    if (chessboard[source.getX() - 1][source.getY() + 1].chessColor == ChessColor.BLACK) {
                        ChessboardPoint destination = new ChessboardPoint(source.getX() - 1, source.getY() + 1);
                        can.add(destination);
                    }
                }
                if (source.getY() - 1 >= 0) {
                    if (chessboard[source.getX() - 1][source.getY() - 1].chessColor == ChessColor.BLACK) {
                        ChessboardPoint destination = new ChessboardPoint(source.getX() - 1, source.getY() - 1);
                        can.add(destination);
                    }
                }

            }
        }
        if (can!=null){
        return can;
        }else {
            return new ArrayList<>();
        }
    }
}
