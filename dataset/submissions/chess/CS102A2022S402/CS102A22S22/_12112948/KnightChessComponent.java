import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public KnightChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        chessComponents= ConcreteChessGame.chessComponentsTmp;
        int x=ConcreteChessGame.a;
        int y=ConcreteChessGame.b;
        if (chessComponents[x][y].name=='N'){
            currentPlayer=ChessColor.BLACK;
        }
        else currentPlayer = ChessColor.WHITE;
        boolean con=false;

        int i = x+1,j=y+2;
        if (i < 8&&j<8){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }
            if (con){
            }
            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
                if (chessComponents[i][j].name!='_'){
                }
            }
        }
        i = x+1;
        j=y-2;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x+2;
        j=y+1;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x+2;
        j=y-1;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x-1;
        j=y+2;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x-1;
        j=y-2;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x-2;
        j=y+1;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        i = x-2;
        j=y-1;
        if (i < 8&&j<8&&i>=0&j>=0){
            if (chessComponents[x][y].name-13<=chessComponents[i][j].name && chessComponents[i][j].name<=chessComponents[x][y].name+12){
                con=true;
            }
            else {
                con=false;
            }

            if (!con){
                canMoveTo.add(new ChessboardPoint(i,j));
            }
        }
        canMoveTo.sort(new Comparator2());
        canMoveTo.sort(new Comparator1());
        return canMoveTo;
    }

}
