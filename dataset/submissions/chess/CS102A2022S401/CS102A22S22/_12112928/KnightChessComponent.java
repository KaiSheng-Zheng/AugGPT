
import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveto=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                int sign=Math.abs(source.getX()-destination.getX())*Math.abs(source.getY()-destination.getY());
                if(sign==2&&chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.chessColor){
                    moveto.add(destination);
                }
            }
        }
        return moveto;
    }
}
