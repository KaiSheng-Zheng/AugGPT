import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        chessComponents= ConcreteChessGame.chessComponentsTmp;
        int x=ConcreteChessGame.a;
        int y=ConcreteChessGame.b;
        if (chessComponents[x][y].name=='R'){
            currentPlayer=ChessColor.BLACK;
        }
        else currentPlayer = ChessColor.WHITE;
        boolean con=false;

        for (int i = x+1; i < 8; i++) {
            if (chessComponents[x][y].name-17<=chessComponents[i][y].name && chessComponents[i][y].name<=chessComponents[x][y].name+8){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,y));
                if (chessComponents[i][y].name!='_'){
                    break;
                }
            }
        }
        for (int i = x-1; i >=0; i--) {
            if (chessComponents[x][y].name-17<=chessComponents[i][y].name && chessComponents[i][y].name<=chessComponents[x][y].name+8){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,y));
                if (chessComponents[i][y].name!='_'){
                    break;
                }
            }
        }
        for (int i = y+1; i < 8; i++) {
            if (chessComponents[x][y].name-17<=chessComponents[x][i].name && chessComponents[x][i].name<=chessComponents[x][y].name+8){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(x,i));
                if (chessComponents[x][i].name!='_'){
                    break;
                }
            }
        }
        for (int i = y-1; i >=0; i--) {
            if (chessComponents[x][y].name-17<=chessComponents[x][i].name && chessComponents[x][i].name<=chessComponents[x][y].name+8){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(x,i));
                if (chessComponents[x][i].name!='_'){
                    break;
                }
            }
        }
        canMoveTo.sort(new Comparator2());
        canMoveTo.sort(new Comparator1());
        return canMoveTo;
    }

}
