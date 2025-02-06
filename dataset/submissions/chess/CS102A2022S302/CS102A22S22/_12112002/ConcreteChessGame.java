import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {


    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;



    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //FIXME: ChessComponent seems to be final
                //ChessComponent chessComponent ;
                //FIXME
                ChessboardPoint point = new ChessboardPoint(i, j);
                String thisPlace = chessboard.get(i).substring(j, j+1);
                switch (thisPlace) {
                    case "R":
                        chessComponents[i][j] = new RookChessComponent(point,ChessColor.BLACK,'R',chessComponents);
                        break;
                    case "r":
                        chessComponents[i][j] = new RookChessComponent(point,ChessColor.WHITE,'r',chessComponents);
                        break;
                    case "N":
                        chessComponents[i][j] = new KnightChessComponent(point,ChessColor.BLACK,'N',chessComponents);
                        break;
                    case "n":
                        chessComponents[i][j] = new KnightChessComponent(point,ChessColor.WHITE,'n',chessComponents);
                        break;
                    case "Q":
                        chessComponents[i][j] = new QueenChessComponent(point,ChessColor.BLACK,'Q',chessComponents);
                        break;
                    case "q":
                        chessComponents[i][j] = new QueenChessComponent(point,ChessColor.WHITE,'q',chessComponents);
                        break;
                    case "K":
                        chessComponents[i][j] = new KingChessComponent(point,ChessColor.BLACK,'K',chessComponents);
                        break;
                    case "k":
                        chessComponents[i][j] = new KingChessComponent(point,ChessColor.WHITE,'k',chessComponents);
                        break;
                    case "P":
                        chessComponents[i][j] = new PawnChessComponent(point,ChessColor.BLACK,'P',chessComponents);
                        break;
                    case "p":
                        chessComponents[i][j] = new PawnChessComponent(point,ChessColor.WHITE,'p',chessComponents);
                        break;
                    case "B":
                        chessComponents[i][j]=new BishopChessComponent(point,ChessColor.BLACK,'B',chessComponents);
                        break;
                    case "b":
                        chessComponents[i][j]=new BishopChessComponent(point,ChessColor.WHITE,'b',chessComponents);
                        break;
                    case "_":
                        chessComponents[i][j] = new EmptySlotComponent(point,ChessColor.NONE,'_',chessComponents);
                        break;
                    default: chessComponents[i][j]=null;
                }
                //chessComponents[i][j] = chessComponent;
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }

    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }



    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        StringBuilder str=new StringBuilder();
        int K = 1, k = 1, Q = 1, q = 1, R = 2, r = 2, B = 2, b = 2, N = 2, n = 2, P = 8, p = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'K':
                        K--;
                        break;
                    case 'k':
                        k--;
                        break;
                    case 'Q':
                        Q--;
                        break;
                    case 'q':
                        q--;
                        break;
                    case 'R':
                        R--;
                        break;
                    case 'r':
                        r--;
                        break;
                    case 'B':
                        B--;
                        break;
                    case 'b':
                        b--;
                        break;
                    case 'N':
                        N--;
                        break;
                    case 'n':
                        n--;
                        break;
                    case 'P':
                        P--;
                        break;
                    case 'p':
                        p--;
                        break;
                }

            }
        }
        if (player.equals(ChessColor.BLACK)){
            if (K!=0){
                str.append("K "+K+"\n");
            }
            if (Q!=0){
                str.append("Q "+Q+"\n");
            }
            if (R!=0){
                str.append("R "+R+"\n");
            }
            if (B!=0){
                str.append("B "+B+"\n");
            }
            if (N!=0){
                str.append("N "+N+"\n");
            }
            if (P!=0){
                str.append("P "+P+"\n");
            }
        }else if (player.equals(ChessColor.WHITE)){
            if (k!=0){
                str.append("k "+k+"\n");
            }
            if (q!=0){
                str.append("q "+q+"\n");
            }
            if (r!=0){
                str.append("r "+r+"\n");
            }
            if (b!=0){
                str.append("b "+b+"\n");
            }
            if (n!=0){
                str.append("n "+n+"\n");
            }
            if (p!=0){
                str.append("p "+p+"\n");
            }
        }
        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x,int y){
        ChessComponent cp=chessComponents[x][y];
        return cp;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        //FIXME: ALWAYS UPDATE BOARD
        chessComponents[source.getX()][source.getY()].a(chessComponents);
        ArrayList<ChessboardPoint> arrayList=(ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(arrayList);
        return arrayList;
    }

    public boolean check(int number){
        if (number<0||number>7){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if (!check(sourceX)){
            return false;
        }
        if (!check(sourceY)){
            return false;
        }
        if (!check(targetX)){
            return false;
        }
        if (!check(targetY)){
            return false;
        }



        ChessComponent chessFirst=chessComponents[sourceX][sourceY];
        ChessComponent chessSecond=chessComponents[targetX][targetY];
        ChessboardPoint pointFirst=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint pointSecond=new ChessboardPoint(targetX,targetY);

        //check same color of player and the chess if not return false
        //FIXME: rude equal sentence
        if (!chessFirst.getChessColor().equals(getCurrentPlayer())){
            return false;
        }

        //check if the target(destination) is in the list of this chessComponent
        boolean check2=false;
        for (int i = 0; i < chessFirst.canMoveTo().size(); i++) {
            if (pointSecond.getY()==chessFirst.canMoveTo().get(i).getY()&&pointSecond.getX()==chessFirst.canMoveTo().get(i).getX()){
                check2=true;
                break;
            }
        }
        if (!check2){
            return false;
        }

        //I think I can start move chess now
        //FIXME: strange delete I don't know if the following codes have bugs

        chessComponents[sourceX][sourceY]=new EmptySlotComponent(pointFirst,getCurrentPlayer(),'_',chessComponents);
        chessFirst.setSource(pointSecond);
        chessComponents[targetX][targetY]=chessFirst;


        if (currentPlayer.equals(ChessColor.WHITE)){
            currentPlayer=ChessColor.BLACK;
        }else if (currentPlayer.equals(ChessColor.BLACK)){
            currentPlayer=ChessColor.WHITE;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].a(chessComponents);
            }
        }
        return true;


    }
}
