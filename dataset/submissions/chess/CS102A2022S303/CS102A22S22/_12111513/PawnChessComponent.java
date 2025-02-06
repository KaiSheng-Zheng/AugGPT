import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    private boolean isBlack = true;

    private boolean isFirst = true;

    public PawnChessComponent() {
    }

    public boolean canMoveTo(ChessboardPoint start, ChessboardPoint destination) {
        ChessboardPoint source = start;
        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(ChessColor.BLACK)) {
            isBlack = true;
        } else {
            isBlack = false;
        }
        int toX = destination.getY();
        int toY = destination.getX();
        int startX = source.getY();
        int startY = source.getX();
        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(getChessboard()[destination.getX()][destination.getY()].getChessColor())) {
            return false;
        }


        if (isBlack) {
            if (startY != 1) isFirst = false;
           
            if (isFirst) {
                if (toY - startY == 2 && toX == startX) {
                    if (!(getChessboard()[toY - 1][startX] instanceof EmptySlotComponent)) {
                        return false;
                    } else {
                        if (getChessboard()[toY][startX] instanceof EmptySlotComponent) {
//                            isFirst = false;
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else if (toY - startY == 1 && toX == startX) {
                    if (getChessboard()[toY][startX] instanceof EmptySlotComponent) {
//                        isFirst = false;
                        return true;
                    } else return false;

                } else if (toY - startY == 1&&Math.abs(toX - startX) == 1){
                    if (!(getChessboard()[toY][toX] instanceof EmptySlotComponent)) {
                        return true;}else {
                        return false;
                    }

                }
            }

           
            if (toY - startY <= 0) return false; 

            else if (toY - startY == 1) { 
                if (Math.abs(toX - startX) == 1) { 

                    if (!(getChessboard()[toY][toX] instanceof EmptySlotComponent)) {
                        return true;
                    } else return false;

                } else if (toX == startX) { 
                    if (getChessboard()[toY][startX] instanceof EmptySlotComponent) {
                        return true;
                    } else return false;
                } else return false;

            } else return false;

        } else {

            if (startY != 6) isFirst = false;
            
            if (isFirst) {
                if (toY - startY == -2 && toX == startX) {

                    if (!(getChessboard()[toY + 1][startX] instanceof EmptySlotComponent)) {
                        return false;
                    } else {
                        if (getChessboard()[toY][startX] instanceof EmptySlotComponent) {

                            return true;
                        } else return false;

                    }
                } else if (toY - startY == -1 && toX == startX) {
                    if (getChessboard()[toY][startX] instanceof EmptySlotComponent) {

                        return true;
                    } else return false;

                } else if (toY - startY == -1&&Math.abs(toX - startX) == 1){
                    if (!(getChessboard()[toY][toX] instanceof EmptySlotComponent)) {
                        return true;}else {
                    return false;}
                }
            }

            

            if (toY - startY >= 0) return false; 

            else if (toY - startY == -1) { 

                if (Math.abs(toX - startX) == 1) { 
                    if (!(getChessboard()[toY][toX] instanceof EmptySlotComponent)) {
                        return true;
                    } else return false;

                } else if (toX == startX) { 

                    if (getChessboard()[toY][toX] instanceof EmptySlotComponent) {
                        return true;
                    } else return false;

                } else return false;

            } else return false;
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> value = new ArrayList<>();
        int startX = this.getSource().getX();
        int startY = this.getSource().getY();
        int toX;
        int toY;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                    ChessboardPoint d = new ChessboardPoint(i, j);
                if (canMoveTo(this.getSource(), d)) {
                    value.add(getChessboard()[i][j].getSource());
                }


            }

        }
        return value;
    }
}
