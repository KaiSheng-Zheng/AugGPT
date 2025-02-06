import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{




    public PawnChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints= new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e= belonging.getChessComponents()[i][j];
                if (this.move(belonging.getChessComponents(),e.getChessboardPoint()))chessboardPoints.add(e.getChessboardPoint());
            }

        }
        return chessboardPoints;
    }

    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        boolean flag = false;

        ChessboardPoint source = this.getChessboardPoint();

        if (destination.getX() > 8 || destination.getX() < 0) return false;
        if (destination.getY() > 8 || destination.getY() < 0) return false;
        ChessComponent c = chessComponents[destination.getX()][destination.getY()];
        ChessComponent d = chessComponents[source.getX()][source.getY()];

        if (steps == 0) {
            if (destination.getY() == source.getY()) {
                if (d.getChessColor() == ChessColor.BLACK) {
                    if ((destination.getX() - source.getX() == 1 && c instanceof EmptySlotComponent)
                            || (destination.getX() - source.getX() == 2 && c instanceof EmptySlotComponent && chessComponents[destination.getX() - 1][source.getY()] instanceof EmptySlotComponent))
                        flag = true;
                }
                if (d.getChessColor() == ChessColor.WHITE) {
                    if ((destination.getX() - source.getX() == -1 && c instanceof EmptySlotComponent)
                            || (destination.getX() - source.getX() == -2 && c instanceof EmptySlotComponent && chessComponents[destination.getX() + 1][source.getY()] instanceof EmptySlotComponent))
                        flag = true;
                }

                if (d.getChessColor() == ChessColor.BLACK) {
                    if (destination.getX() - source.getX() == 1
                            && (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE)
                            && Math.abs(destination.getY() - source.getY()) == 1) {
                        flag = true;
                    }
                }
                if (d.getChessColor() == ChessColor.WHITE) {
                    if (destination.getX() - source.getX() == -1
                            && Math.abs(destination.getY() - source.getY()) == 1
                            && (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK)) {
                        flag = true;
                    }
                }

            }
        } else if (destination.getY() == source.getY()) {
            if (d.getChessColor() == ChessColor.BLACK) {
                if (destination.getX() - source.getX() == 1 && c instanceof EmptySlotComponent) flag = true;
            }
            if (d.getChessColor() == ChessColor.WHITE) {
                if (destination.getX() - source.getX() == -1 && c instanceof EmptySlotComponent) flag = true;
            }
        } else if (Math.abs(destination.getY() - source.getY()) == 1 && Math.abs(destination.getX() - source.getX()) == 1) {
            if (d.getChessColor() == ChessColor.BLACK) {
                if (destination.getX() - source.getX() == 1 && (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE)) {
                    flag = true;
                }
            }
            if (d.getChessColor() == ChessColor.WHITE) {
                if (destination.getX() - source.getX() == -1 && (chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

}
