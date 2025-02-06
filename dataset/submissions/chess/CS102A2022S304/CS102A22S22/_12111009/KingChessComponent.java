import java.util.*;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint chessboardPoint,  char name) {
        if (name=='K'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='k'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public KingChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('K');
        }else if (color==ChessColor.WHITE){
            this.setName('k');
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
        if (Xdiffer==0){
            return Ydiffer==1;
        }else if (Xdiffer==1){
            return Ydiffer==0||Ydiffer==1;
        }return false;
    }
}