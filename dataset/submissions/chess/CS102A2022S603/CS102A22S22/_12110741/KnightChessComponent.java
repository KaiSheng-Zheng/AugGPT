import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
@Override
public List<ChessboardPoint> canMoveTo(){
    ChessboardPoint source = getSource();
    List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    ChessboardPoint[][] chessboardPoints1 = new ChessboardPoint[8][8];
    for (int i=0; i<8; i++){
        for (int j =0; j<8; j++) {
            ChessboardPoint target = chessboardPoints1[i][j];
            if (source.getX() == target.getX()) {
                int row = source.getX();
                for (int col = Math.min(source.getY(), target.getY()) + 1;
                     col < Math.max(source.getY(),target.getY()); col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                       break;
                    }
                }
            } else if (source.getY() == target.getY()) {
                int col = source.getY();
                for (int row = Math.min(source.getX(), target.getX()) + 1;
                     row < Math.max(source.getX(), target.getX()); row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        break;
                    }
                }
            } else if (Math.abs(source.getX()-target.getX())==Math.abs(source.getY()-target.getY())){
                int col = source.getY();
                int row = source.getX();

            } else { // Not on the same row or the same column.
                break;
            }
            chessboardPoints.add(target);
        }
    }

    return chessboardPoints;
}
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.name=name;
        source=this.getSource();
        chessColor=this.getChessColor();
    }
}
