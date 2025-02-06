
import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
    public void setSource(int a,int b){
        source=new ChessboardPoint(a,b);
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveto=new ArrayList<>();

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);int sign=1;
                if (source.getX() == destination.getX()) {
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), destination.getY()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            sign=0;
                        }
                    }
                } else if (source.getY() == destination.getY()) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            sign=0;
                        }
                    }
                } else { // Not on the same row or the same column.
                    sign=0;
                }
                if (sign==1&&chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.chessColor){
                    moveto.add(destination);
                }
            }
        }
        return moveto;
    }
}
