import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
  //  ChessComponent[][] chessComponents = getChessboard();
    public boolean ss(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source =new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        destination =new ChessboardPoint(destination.getX(),destination.getY());
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        ChessboardPoint chessboardPoint;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                ChessComponent[][] chessComponents = getChessboard();
              //  ChessComponent[][] chessComponents = new ChessComponent[8][8];
                if(ss(chessComponents, destination)){
                    chess.add(new ChessboardPoint(i,j));
                }
            }
        }
    return chess;
    }

}