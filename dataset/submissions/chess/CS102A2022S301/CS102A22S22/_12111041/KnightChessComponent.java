import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent() {
        super();
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        if(!hasChess(2,1)||this.hasDifferentChess(2,1)){result.add(this.getSource().offset(2,1));}
        if(!hasChess(1,2)||this.hasDifferentChess(1,2)){result.add(this.getSource().offset(1,2));}
        if(!hasChess(-2,1)||this.hasDifferentChess(-2,1)){result.add(this.getSource().offset(-2,1));}
        if(!hasChess(1,-2)||this.hasDifferentChess(1,-2)){result.add(this.getSource().offset(1,-2));}
        if(!hasChess(2,-1)||this.hasDifferentChess(2,-1)){result.add(this.getSource().offset(2,-1));}
        if(!hasChess(-1,2)||this.hasDifferentChess(-1,2)){result.add(this.getSource().offset(-1,2));}
        if(!hasChess(-2,-1)||this.hasDifferentChess(-2,-1)){result.add(this.getSource().offset(-2,-1));}
        if(!hasChess(-1,-2)||this.hasDifferentChess(-1,-2)){result.add(this.getSource().offset(-1,-2));}
        List<ChessboardPoint> result1=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (ChessboardPoint results:result) {
                    if(results.getX()==i&&results.getY()==j){
                        result1.add(results);
                    }
                }
            }
        }
        return result1;
    }
}
