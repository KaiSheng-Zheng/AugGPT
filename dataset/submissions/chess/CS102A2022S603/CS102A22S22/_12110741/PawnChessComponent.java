import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint source = getSource();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint[][] chessboardPoints1 = new ChessboardPoint[8][8];
        for (int i=0; i<8; i++){
            for (int j =0; j<8; j++) {
                ChessboardPoint target = chessboardPoints1[i][j];
                if (source.getX() == target.getX()&&Math.abs(source.getY()-target.getY())==1) {
                    int row = source.getX();
                    int col = Math.min(source.getY(), target.getY()) + 1;
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        break;
                    }
                } else if (source.getY() == target.getY()&&Math.abs(source.getX()-target.getX())==1) {
                    int col = source.getY();
                    int row = Math.min(source.getX(), target.getX()) + 1;
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        break;
                    }
                } else if (Math.abs(source.getX()-target.getX())==Math.abs(source.getY()-target.getY())&&Math.abs(source.getY()-target.getY())==1){
                    chessboardPoints.add(target);
                }
                chessboardPoints.add(target);
            }
        }

        return chessboardPoints;
    }
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.name=name;
        source=this.getSource();
        chessColor=this.getChessColor();
    }

}
