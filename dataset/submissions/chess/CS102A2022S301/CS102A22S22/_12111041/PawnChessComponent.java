import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent() {
        super();
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        if (Character.isUpperCase(this.name)) {
            if (source.getX() == 1) {
                if (!this.hasChess(1, 0)) {
                    result.add(source.offset(1, 0));
                    if (!this.hasChess(2, 0)) {
                            result.add(source.offset(2, 0));
                        }
                    }
                }
            else if (!this.hasChess(1, 0)) {
                    result.add(source.offset(1, 0));
            }
            if (this.hasDifferentChess(1,1)){result.add(source.offset(1,1));}
            if (this.hasDifferentChess(1,-1)){result.add(source.offset(1,-1));}
        } else {
                    if (source.getX() == 6) {
                        if (!this.hasChess(-1, 0)) {
                            result.add(source.offset(-1, 0));
                            if (!this.hasChess(-2, 0)) {
                                result.add(source.offset(-2, 0));
                            }
                        }
                    }
                    else if (!this.hasChess(-1, 0)) {
                        result.add(source.offset(-1, 0));
                    }
                    if (this.hasDifferentChess(-1,1)){result.add(source.offset(-1,1));}
                    if (this.hasDifferentChess(-1,-1)){result.add(source.offset(-1,-1));}
        }
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
