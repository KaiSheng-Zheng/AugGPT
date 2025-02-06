import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{


    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char q) {
    }

    private static boolean sameDiagonal(ChessboardPoint a, ChessboardPoint b){
        return Math.abs(a.getX()) - b.getX() == Math.abs(a.getY() - b.getY());
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return new ArrayList<>();
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return new ArrayList<>();
                }
            }
        }
        else if (!sameDiagonal(source,destination))return new ArrayList<>();
        else if (source.equals(destination))return new ArrayList<>();
        else {
            int x = Math.abs(source.getX() - destination.getX());
            int a = source.getX()-destination.getX();
            int b = source.getY()-destination.getY();
            if (a*b>0&&a<0){
                for (int i=1;i<x;i++){
                    if (!(chessComponents[source.getX()+i][source.getY()+i]instanceof EmptySlotComponent))return new ArrayList<>();
                }
            }
            if (a*b>0&&a>0){
                for (int i=1;i<x;i++){
                    if (!(chessComponents[source.getX()-i][source.getY()-i]instanceof EmptySlotComponent))return new ArrayList<>();
                }
            }
            if (a*b<0&&a<0){
                for (int i=1;i<x;i++){
                    if (!(chessComponents[source.getX()+i][source.getY()-i]instanceof EmptySlotComponent))return new ArrayList<>();
                }
            }
            if (a*b<0&&a>0){
                for (int i=1;i<x;i++){
                    if (!(chessComponents[source.getX()-i][source.getY()+i]instanceof EmptySlotComponent))return new ArrayList<>();
                }
            }
        }
        return Collections.singletonList(destination);
    }
}