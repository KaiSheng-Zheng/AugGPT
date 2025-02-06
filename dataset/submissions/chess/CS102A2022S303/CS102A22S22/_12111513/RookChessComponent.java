import java.util.ArrayList;
import java.util.List;

public  class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public RookChessComponent() {
    }
    public boolean canMoveTo(ChessboardPoint start, ChessboardPoint destination) {
        if (getChessboard()[start.getX()][start.getY()].getChessColor().equals(getChessboard()[destination.getX()][destination.getY()].getChessColor())) {
            return false;
        }
        ChessboardPoint source = start;
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(getChessboard()[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(getChessboard()[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { 
            return false;
        }
        return true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> value = new ArrayList<>();
        int startX=this.getSource().getX();
        int startY=this.getSource().getY();
        int toX;
        int toY;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((canMoveTo(this.getSource(),getChessboard()[i][j].getSource()))){
                    value.add(getChessboard()[i][j].getSource());
                }

            }

        }
        return value;
    }
}
