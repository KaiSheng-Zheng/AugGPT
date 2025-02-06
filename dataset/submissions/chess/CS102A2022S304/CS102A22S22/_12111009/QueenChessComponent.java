import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint chessboardPoint,  char name) {
        if (name=='Q'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='q'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public QueenChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('Q');
        }else if (color==ChessColor.WHITE){
            this.setName('q');
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (canMoveTo(this.getChessboard(),new ChessboardPoint(i,j))){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        ChessboardPoint source = this.getSource();
        int Xdiffer = Math.abs(source.getX()-destination.getX());
        int Ydiffer = Math.abs(source.getY()-destination.getY());
        int a,b;
        if (destination.getX()>source.getX()){
            a=1;
        }else a=-1;
        if (destination.getY()>source.getY()){
            b=1;
        }else b=-1;
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
        }
        else if (Xdiffer!=Ydiffer){
            return false;
        }
        else {
            for (int i=1;i<Xdiffer;++i){
                if (!(chessComponents[source.getX()+a*i][source.getY()+b*i] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }return true;
    }
}