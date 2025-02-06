import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint source = getSource();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint[][] chessboardPoints1 = new ChessboardPoint[8][8];
        for (int i=0; i<8; i++){
            for (int j =0; j<8; j++) {
                ChessboardPoint target = chessboardPoints1[i][j];
                if (source.getX() == target.getX()&&Math.abs(source.getY()-target.getY())==1) {
                   chessboardPoints.add(target);
                } else if (source.getY() == target.getY()&&Math.abs(source.getX()-target.getX())==1) {
                    chessboardPoints.add(target);;
                } else if (Math.abs(source.getX()-target.getX())==Math.abs(source.getY()-target.getY())&&Math.abs(source.getY()-target.getY())==1){
                    chessboardPoints.add(target);
                }else {
                    break;
                }
            }
        }
        return chessboardPoints;
    }

     public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.name=name;
        source=this.getSource();
        chessColor=this.getChessColor();
    }

}
