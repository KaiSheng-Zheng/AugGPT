import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

    //    public RookChessComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
    public RookChessComponent( char name) {
        this.name = name;
    }

    public RookChessComponent() {
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
//        if(destination.getY()==source.getY()&&destination.getX()==source.getX()){
//            return false;
//        }
//        if(destination.getY()==source.getY()){
//            for (int i = Math.min(destination.getY(),source.getY());
//                 i <=Math.max(destination.getY(),source.getY()) ; i++) {
//                if(
//            }
//        }
        if ((chessboard[destination.getX()][destination.getY()].getChessColor())!= (chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
            int c =this.getSource().getX();
            int r = this.getSource().getY();
            //same row
            if (this.getSource().getX() == destination.getX()) {
                for (r = Math.min(this.getSource().getY(), destination.getY())+1 ;
                     r < Math.max(this.getSource().getY(), destination.getY()); r++) {
                    if (!(chessboard[c][r] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
            //same column
            if (this.getSource().getY() == destination.getY()) {
                for (c = Math.min(this.getSource().getX(), destination.getX()) +1;
                     c < Math.max(this.getSource().getX(), destination.getX()); c++) {
                    if (!(chessboard[c][r] instanceof EmptySlotComponent)) {
                        return false;
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
