import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(int x, int y, char ming) {

////        source = new ChessboardPoint(x, y);
////        if (ming == 'N') {
////            chessColor = ChessColor.BLACK;
////        }
////        else if (ming == 'n') {
////            chessColor = ChessColor.WHITE;
////        } else {
////            chessColor = ChessColor.NONE;
////        }
//        super(x,y,ming);
//        this.name='N';
        setSource(new ChessboardPoint(x, y));

        if (ming == 'N') {
            setChessColor(ChessColor.BLACK);
            this.name = 'N';

        } else if (ming == 'n') {
            setChessColor(ChessColor.WHITE);
            this.name = 'n';

        } else {
            setChessColor(ChessColor.NONE);
        }


    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveTo(chessboard, new ChessboardPoint(i,j))){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.getChessColor()) {
            if ((Math.abs((source.getY()) - destination.getY()) == 1 && Math.abs(source.getX() - destination.getX()) == 2)
                    || (Math.abs((source.getY()) - destination.getY()) == 2 && Math.abs(source.getX() - destination.getX()) == 1)) {
                return true;
            }
            else {
                return false;
            }
        }
        else { // Not on the  same diagonal.
            return false;
        }
    }
}