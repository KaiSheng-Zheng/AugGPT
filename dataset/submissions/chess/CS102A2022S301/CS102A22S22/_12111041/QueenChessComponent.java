import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
        super();
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
            if(this.hasChess(0,i)){
                if (hasDifferentChess(0,i)){result.add(resource.offset(0,i));break;}
                else break;
            }
            else result.add(resource.offset(0,i));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(0,-i)){
                if (hasDifferentChess(0,-i)){result.add(resource.offset(0,-i));break;}
                else break;
            }
            else result.add(resource.offset(0,-i));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(i,0)){
                if (hasDifferentChess(i,0)){result.add(resource.offset(i,0));break;}
                else break;
            }
            else result.add(resource.offset(i,0));
        }
        for (int i = 1; i < 8; i++) {
            if(this.hasChess(-i,0)){
                if (hasDifferentChess(-i,0)){result.add(resource.offset(-i,0));break;}
                else break;
            }
            else result.add(resource.offset(-i,0));
        }
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
