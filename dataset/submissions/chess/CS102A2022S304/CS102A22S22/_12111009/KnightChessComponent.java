import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,  char name) {
        if (name=='N'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.BLACK);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }else if (name=='n'){
            this.setSource(chessboardPoint);
            this.setChessColor(ChessColor.WHITE);
            this.setName(name);
            chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
        }
    }
    public KnightChessComponent(ChessColor color){
        if (color==ChessColor.BLACK){
            this.setName('N');
        }else if (color==ChessColor.WHITE){
            this.setName('n');
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
        return Xdiffer + Ydiffer == 3 && Xdiffer > 0 && Ydiffer > 0;
    }
}