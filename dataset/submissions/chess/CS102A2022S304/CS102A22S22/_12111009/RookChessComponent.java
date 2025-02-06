import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint,  char name) {
        if (name=='R'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='r'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public RookChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('R');
        }else if (color==ChessColor.WHITE){
            this.setName('r');
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (canMoveTo(this.getChessboard(),this.getChessboard()[i][j].getSource())){
                    chessboardPoints.add(this.getChessboard()[i][j].getSource());
                }
            }
        }
        return chessboardPoints;
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = this.getSource();
        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
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
        } else {
            return false;
        }
        return true;
    }
}