import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;


//    public KingChessComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

//    @Override
//    public ChessColor getChessColor() {
//        return chessColor;
//    }
//
//    @Override
//    public char getName() {
//        return name;
//    }

    public KingChessComponent() {
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
            //diagonal
            boolean a = false;
            boolean b = false;
            if (Math.abs(destination.getX() - this.getSource().getX()) <= 1 && destination.getX() >= 0 && destination.getX() <= 7) {
                a = true;
            }
            if (Math.abs(destination.getY() - this.getSource().getY()) <= 1 && destination.getY() >= 0 && destination.getY() <= 7) {
                b = true;
            }
            return a && b;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
