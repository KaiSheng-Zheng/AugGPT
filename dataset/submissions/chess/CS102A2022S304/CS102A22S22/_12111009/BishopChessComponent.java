import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint, char name) {
        if (name=='B'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='b'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public BishopChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('B');
        }else if (color==ChessColor.WHITE) {
            this.setName('b');
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
        ChessboardPoint source = this.getSource();
        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        int Xdiffer = Math.abs(source.getX()-destination.getX());
        int Ydiffer = Math.abs(source.getY()-destination.getY());
        int a,b;
        if (destination.getX()>source.getX()){
            a=1;
        }else a=-1;
        if (destination.getY()>source.getY()){
            b=1;
        }else b=-1;
        if (Xdiffer==Ydiffer){
            for (int i=1;i<Xdiffer;++i){
                if (!(chessComponents[source.getX()+a*i][source.getY()+b*i] instanceof EmptySlotComponent)) {
                    return false;
                }
            }return true;
        }return false;
    }
}