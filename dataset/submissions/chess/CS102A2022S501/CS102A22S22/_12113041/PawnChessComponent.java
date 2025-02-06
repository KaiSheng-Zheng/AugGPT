import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;

//    public PawnChessComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
//    public PawnChessComponent( char name) {
//        this.name = name;
//    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

    public PawnChessComponent() {
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
        if(chessboard[destination.getX()][destination.getY()].getChessColor()!=(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
            ChessColor color = this.getChessColor();
            //black pawn
            if (color == ChessColor.BLACK) {
                //the same y
                if (destination.getY() == this.getSource().getY()) {
                    //move
                    //first step
                    if (this.getSource().getX() == 1) {
                        if ((destination.getX() - this.getSource().getX() == 1 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) || (destination.getX() - this.getSource().getX() == 2 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent) && (chessboard[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent))) {
                            return true;
                        }
                    } //not the first step
                    else {
                        if (destination.getX() -this.getSource().getX() == 1 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                            return true;
                        }
                    }
                }
                //diagonal capture
                if (Math.abs(this.getSource().getY() - destination.getY()) == 1) {
                    return destination.getX() - this.getSource().getX() == 1 && !(chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent);
                }
            }
            if (color == ChessColor.WHITE) {
                if (destination.getY() ==this.getSource().getY()) {
                    if (this.getSource().getX() == 6) {
                        if ((destination.getX() - this.getSource().getX() == -1 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) || (destination.getX() - this.getSource().getX() == -2 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent) && (chessboard[destination.getX() + 1][destination.getY()] instanceof EmptySlotComponent))) {
                            return true;
                        }
                    } else {
                        if (destination.getX() - this.getSource().getX() == -1 && (chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                            return true;
                        }
                    }
                }
                if (this.getSource().getY() - destination.getY() == this.getSource().getX() - destination.getX() || this.getSource().getY() - destination.getY() == destination.getX() - this.getSource().getX()) {
                    return destination.getX() - this.getSource().getX() == -1 && !(chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent);
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
