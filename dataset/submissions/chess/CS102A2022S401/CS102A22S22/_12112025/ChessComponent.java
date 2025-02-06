import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    public  List<ChessboardPoint> canCanMoveTo(){
        if (canCanMoveTo()==null){
            return new ArrayList<>();
        }else {
            return canCanMoveTo();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
