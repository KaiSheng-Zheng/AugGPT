import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = getSource().getX();int b = getSource().getY();
        List<ChessboardPoint> shit = new ArrayList<>();
        if(this.fuck(-1,-1) ){
            shit.add(new ChessboardPoint(a-1,b-1));
        }
        if(this.fuck(-1,0) ){
            shit.add(new ChessboardPoint(a-1,b));
        }
        if(this.fuck(-1,1) ){
            shit.add(new ChessboardPoint(a-1,b+1));
        }
        if(this.fuck(0,-1) ){
            shit.add(new ChessboardPoint(a,b-1));
        }
        if(this.fuck(0,1) ){
            shit.add(new ChessboardPoint(a,b+1));
        }
        if(this.fuck(1,-1) ){
            shit.add(new ChessboardPoint(a+1,b-1));
        }
        if(this.fuck(1,0) ){
            shit.add(new ChessboardPoint(a+1,b));
        }
        if(this.fuck(1,1) ){
            shit.add(new ChessboardPoint(a+1,b+1));
        }
        return shit;
    }

}
