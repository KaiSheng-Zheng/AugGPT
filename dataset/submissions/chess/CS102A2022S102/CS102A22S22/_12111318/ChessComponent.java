import java.util.List;
import java.util.Objects;
public abstract class ChessComponent {
    private ChessboardPoint point;
    protected ChessColor chessColor;
    protected char a;
    public ChessComponent(int a,int b){
        boolean judge=false;
    }
    public ChessComponent(){
    }
    public ChessComponent(ChessboardPoint point, ChessColor chessColor, char a) {
        this.point = point;
        this.chessColor = chessColor;
        this.a = a;
    }
    @Override
    public String toString() {
        return String.valueOf(this.a);
    }
    @Override
    public int hashCode() {
        return Objects.hash(point, chessColor, a);
    }
    public void setpoint(ChessboardPoint point) {
        this.point = point;
    }
    public ChessboardPoint getpoint() {
        return point;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();


}
