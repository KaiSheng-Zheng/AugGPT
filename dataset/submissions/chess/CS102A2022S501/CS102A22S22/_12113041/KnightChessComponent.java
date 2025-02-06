import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;


    //    public KnightChessComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

//    public KnightChessComponent() {
//    }

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
            if ((Math.abs(destination.getX() - this.getSource().getX()) == 2) && (Math.abs(destination.getY() - this.getSource().getY()) == 1)) {
                return true;
            }
            if ((Math.abs(destination.getX() - this.getSource().getX()) == 1) && (Math.abs(destination.getY() - this.getSource().getY()) == 2)) {
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
