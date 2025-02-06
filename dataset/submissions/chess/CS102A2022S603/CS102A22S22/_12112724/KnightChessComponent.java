
import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chesscolor) {
        super(source, chesscolor);
        if (chesscolor == ChessColor.BLACK) {
            this.name = 'N';
        }
        if (chesscolor == ChessColor.WHITE) {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Points = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ableToMove(getChessboard()[i][j])) {
                    Points.add(new ChessboardPoint(i, j));
                }
            }
        }
        return Points;
    }

    public boolean ableToMove(ChessComponent a) {
        ChessboardPoint source = getSource();
        ChessboardPoint target = a.getSource();
        int x1 = Math.min(source.getX(), target.getX());
        int x2 = Math.max(source.getX(), target.getX());
        int y1 = Math.min(source.getY(), target.getY());
        int y2 = Math.max(source.getY(), target.getY());
        if ((source.getX() == target.getX() && source.getY() == target.getY()) || a.getChessColor() == getChessColor()) {
            return false;
        }
       if ((x2-x1 == 1 && y2-y1 == 2) || (x2-x1 == 2 && y2-y1 == 1)) {
            return true;
        }
        return false;
    }
}


//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        List<ChessboardPoint> Points=new ArrayList<>();
//        if(getSource().offset(-2,-1)!=null){
//            Points.add(getSource().offset(-2,-1));
//        }
//        if(getSource().offset(-2,1)!=null){
//            Points.add(getSource().offset(-2,1));
//        }
//        if(getSource().offset(-1,-2)!=null){
//            Points.add(getSource().offset(-1,-2));
//        }
//        if(getSource().offset(-1,2)!=null){
//            Points.add(getSource().offset(-1,2));
//        }
//        if(getSource().offset(1,-2)!=null){
//            Points.add(getSource().offset(1,-2));
//        }
//        if(getSource().offset(1,2)!=null){
//            Points.add(getSource().offset(1,2));
//        }
//        if(getSource().offset(2,-1)!=null){
//            Points.add(getSource().offset(2,-1));
//        }
//        if(getSource().offset(2,1)!=null){
//            Points.add(getSource().offset(2,1));
//        }
//        return Points;
//    }
//}
//
