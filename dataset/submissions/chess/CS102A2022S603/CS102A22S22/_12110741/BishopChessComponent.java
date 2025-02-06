import java.util.*;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint source = getSource();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessboardPoint[][] chessboardPoints1 = new ChessboardPoint[8][8];
        for (int i=0; i<8; i++){
            for (int j =0; j<8; j++) {
                ChessboardPoint target = chessboardPoints1[i][j];
                if (Math.abs(source.getX()-target.getX())==Math.abs(source.getY()-target.getY())){
                    int col = Math.min(source.getY(),target.getY());
                    int row = Math.min(source.getX(),target.getX());
                    for (int k=1; k<Math.abs(source.getX()-target.getX());k++){
                        if (!(chessComponents[row+k][col+k] instanceof EmptySlotComponent)) {
                            break;
                        }
                    }
                    for (int k=1; k <Math.abs(source.getX()-target.getX());k++){
                        if (!(chessComponents[row-k][col-k] instanceof EmptySlotComponent)) {
                           break;
                        }
                    }
                } else { // Not on the same row or the same column.
                   break;
                }
               chessboardPoints.add(target);
            }
        }
        return chessboardPoints;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.name=name;
        source=this.getSource();
        chessColor=this.getChessColor();
    }

}
