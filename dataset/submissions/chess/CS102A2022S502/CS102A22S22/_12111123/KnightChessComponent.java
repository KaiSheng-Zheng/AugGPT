import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = getSource().getX();int b = getSource().getY();
        List<ChessboardPoint> shit = new ArrayList<>();
        if(this.fuck(-2,-1) ){
            shit.add(new ChessboardPoint(a-2,b-1));
        }
        if(this.fuck(-2,1) ){
            shit.add(new ChessboardPoint(a-2,b+1));
        }
        if(this.fuck(-1,-2) ){
            shit.add(new ChessboardPoint(a-1,b-2));
        }
        if(this.fuck(-1,2) ){
            shit.add(new ChessboardPoint(a-1,b+2));
        }
        if(this.fuck(1,-2) ){
            shit.add(new ChessboardPoint(a+1,b-2));
        }
        if(this.fuck(1,2) ){
            shit.add(new ChessboardPoint(a+1,b+2));
        }
        if(this.fuck(2,-1) ){
            shit.add(new ChessboardPoint(a+2,b-1));
        }
        if(this.fuck(2,1) ){
            shit.add(new ChessboardPoint(a+2,b+1));
        }
        return shit;
    }
}
