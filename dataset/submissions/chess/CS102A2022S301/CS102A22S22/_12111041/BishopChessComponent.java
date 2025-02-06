

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
        super();
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        ChessboardPoint resource=this.getSource();
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(i,i)){
                if (hasDifferentChess(i,i)){result.add(resource.offset(i,i));break;}
                else break;
            }
            else result.add(resource.offset(i,i));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(i,-i)){
                if (hasDifferentChess(i,-i)){result.add(resource.offset(i,-i));break;}
                else break;
            }
            else result.add(resource.offset(i,-i));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(-i,i)){
                if (hasDifferentChess(-i,i)){result.add(resource.offset(-i,i));break;}
                else break;
            }
            else result.add(resource.offset(-i,i));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(-i,-i)){
                if (hasDifferentChess(-i,-i)){result.add(resource.offset(-i,-i));break;}
                else break;
            }
            else result.add(resource.offset(-i,-i));
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
