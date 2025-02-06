import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo=new ArrayList<>();
        chessComponents= ConcreteChessGame.chessComponentsTmp;
        int x=ConcreteChessGame.a;
        int y=ConcreteChessGame.b;
        
        if (chessComponents[x][y].name=='B'){
            currentPlayer=ChessColor.BLACK;
        }
        else currentPlayer = ChessColor.WHITE;
        boolean con=false;

        for (int i = x+1,j=y+1; i < 8&&j<8; i++,j++) {
            if (chessComponents[x][y].name-1<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+24){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
                if (chessComponents[i][j].name!='_'){
                    break;
                }
            }
        }
        for (int i = x-1,j=y-1; i >=0&&j>=0; i--,j--) {
            if (chessComponents[x][y].name-1<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+24){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
                if (chessComponents[i][j].name!='_'){
                    break;
                }
            }
        }
        for (int i =x+1,j= y-1; i < 8&&j>=0; i++,j--) {
            if (chessComponents[x][y].name-1<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+24){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
                if (chessComponents[i][j].name!='_'){
                    break;
                }
            }
        }
        for (int i = x-1,j=y+1; i >=0&&j<8; i--,j++) {
            if (chessComponents[x][y].name-1<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+24){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
                break;
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
                if (chessComponents[i][j].name!='_'){
                    break;
                }
            }
        }
        canMoveTo.sort(new Comparator2());
        canMoveTo.sort(new Comparator1());
        return canMoveTo;
    }


}
