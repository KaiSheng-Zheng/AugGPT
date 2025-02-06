
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
        super();
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }




    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        ChessboardPoint source=this.getSource();
        if(!this.hasChess(-1,-1)||this.hasDifferentChess(-1,-1)){result.add(source.offset(-1,-1));}
        if(!this.hasChess(-1,0)||this.hasDifferentChess(-1,0)){result.add(source.offset(-1,0));}
        if(!this.hasChess(-1,1)||this.hasDifferentChess(-1,1)){result.add(source.offset(-1,1));}
        if(!this.hasChess(0,-1)||this.hasDifferentChess(0,-1)){result.add(source.offset(0,-1));}
        if(!this.hasChess(0,1)||this.hasDifferentChess(0,1)){result.add(source.offset(0,1));}
        if(!this.hasChess(1,-1)||this.hasDifferentChess(1,-1)){result.add(source.offset(1,-1));}
        if(!this.hasChess(1,0)||this.hasDifferentChess(1,0)){result.add(source.offset(1,0));}
        if(!this.hasChess(1,1)||this.hasDifferentChess(1,1)){result.add(source.offset(1,1));}
        return result;
    }
}
