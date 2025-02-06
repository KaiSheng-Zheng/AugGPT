import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;

    //    public QueenChessComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
//    public QueenChessComponent( char name) {
//        this.name = name;
//    }


    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
                if(can(chessboardPoint)){
                    chessboardPoints.add(chessboardPoint);
                }
            }
        }
        return chessboardPoints;
    }

    public boolean can(ChessboardPoint destination) {
        if(chessboard[destination.getX()][destination.getY()].getChessColor()!=( chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
            int row = this.getSource().getX();
            int col = this.getSource().getY();
            if (this.getSource().getX() == destination.getX()) {
                for (col = Math.min(this.getSource().getY(), destination.getY()) +1;
                     col < Math.max(this.getSource().getY(), destination.getY()); col++) {
                    if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
            if (this.getSource().getY() == destination.getY()) {
                for (row = Math.min(this.getSource().getX(), destination.getX()) +1;
                     row < Math.max(this.getSource().getX(), destination.getX()); row++) {
                    if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
            //bishop
            if (destination.getX() - this.getSource().getX() == destination.getY() - this.getSource().getY()) {
                if (destination.getX() - this.getSource().getX() > 0) {
                    for (int i = 1; i < destination.getX() - this.getSource().getX() ; i++) {
                        if (!(chessboard[this.getSource().getX() + i][this.getSource().getY() + i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 1; i < this.getSource().getX() - destination.getX() ; i++) {
                        if (!(chessboard[destination.getX() + i][destination.getY() + i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            if (destination.getX() - this.getSource().getX() == this.getSource().getY() - destination.getY()) {
                if (destination.getX() - this.getSource().getX() > 0) {
                    for (int i = 1; i < destination.getX() - this.getSource().getX() ; i++) {
                        if (!(chessboard[this.getSource().getX() + i][this.getSource().getY() - i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 1; i < this.getSource().getX() - destination.getX() ; i++) {
                        if (!(chessboard[destination.getX() + i][destination.getY() - i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
