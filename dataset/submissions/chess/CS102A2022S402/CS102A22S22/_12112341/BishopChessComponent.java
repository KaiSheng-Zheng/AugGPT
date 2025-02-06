import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char b) {
    }

    private static boolean sameDiagonal(ChessboardPoint a, ChessboardPoint b){
        return Math.abs(a.getX()) - b.getX() == Math.abs(a.getY() - b.getY());
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (!sameDiagonal(source,destination))return new ArrayList<>();
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