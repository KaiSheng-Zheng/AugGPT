import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessColor currentPlayer = ChessColor.WHITE ;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    public void loadChessGame(List<String> chessboard){
        for(int a = 0 ; a<8 ; a++){
            System.out.println(chessboard.get(a).toString());
            for(int b = 0 ; b < 8 ; b++) {

                switch (chessboard.get(a).charAt(b)) {
                    case 'R' :
                    chessComponents[a][b] = new RookChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'N' :
                        chessComponents[a][b] = new KnightChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'B' :
                        chessComponents[a][b] = new BishopChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'K' :
                        chessComponents[a][b] = new KingChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'Q' :
                        chessComponents[a][b] = new QueenChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'P' :
                        chessComponents[a][b] = new PawnChessComponent(a,b,ChessColor.BLACK);
                        break;
                    case 'r' :
                        chessComponents[a][b] = new RookChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case 'n' :
                        chessComponents[a][b] = new KnightChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case 'b' :
                        chessComponents[a][b] = new BishopChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case 'k' :
                        chessComponents[a][b] = new KingChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case 'q' :
                        chessComponents[a][b] = new QueenChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case 'p' :
                        chessComponents[a][b] = new PawnChessComponent(a,b,ChessColor.WHITE);
                        break;
                    case '_' :
                        chessComponents[a][b] = new EmptySlotComponent(a,b,ChessColor.NONE);

                }
            }
        }
        if(!Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.BLACK;
            System.out.println("b");
        }else{
            System.out.println("w");
        }


    }
    public ChessColor getCurrentPlayer(){
        return  currentPlayer;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];

    }
    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i<8 ; i++){
         str.append(chessComponents[i].toString());
         str.append("\n");
        }
        return str.toString();

    }
    public String getCapturedChess(ChessColor player){
        int R = 2,N = 2,B = 2,Q = 1,K = 1,P = 8;
        int r = 2,n = 2,b = 2,q = 1,k = 1,p = 8;
        ChessComponent storage;
        for(int a = 0 ; a < 8 ; a++){
            for(int c = 0 ; c < 8 ; c++){
                switch (chessComponents[a][c].toString()){
                    case "R" :
                        R--;
                        break;
                    case "N" :
                        N--;
                        break;
                    case "B" :
                        B--;
                        break;
                    case "K" :
                        K--;
                        break;
                    case "Q" :
                        Q--;
                        break;
                    case "P" :
                        P--;
                        break;
                    case "r" :
                        r--;
                        break;
                    case "n" :
                        n--;
                        break;
                    case "b" :
                        b--;
                        break;
                    case "k" :
                        k--;
                        break;
                    case "q" :
                        q--;
                        break;
                    case "p" :
                        p--;
                        break;
                    case "_":
                        break;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        if(player == ChessColor.BLACK) {
            if (K != 0) {
                str.append("K " + (1-K) + "\n");
            }
            if (Q != 0) {
                str.append("Q " + (1-Q) + "\n");
            }
            if (R != 0) {
                str.append("R " + (2-R) + "\n");
            }
            if (B != 0) {
                str.append("B " + (2-B) + "\n");
            }
            if (N != 0) {
                str.append("N " + (2-N) + "\n");
            }
            if (P != 0) {
                str.append("P " + (8-P) + "\n");
            }
        }else {
            if (k != 0) {
                str.append("k " + (1-k) + "\n");
            }
            if (q != 0) {
                str.append("q " + (1-q) + "\n");
            }
            if (r != 0) {
                str.append("r " + (2-r) + "\n");
            }
            if (b != 0) {
                str.append("b " + (2-b) + "\n");
            }
            if (n != 0) {
                str.append("n " + (2-n) + "\n");
            }
            if (p != 0) {
                str.append("p " + (8-p) + "\n");
            }
        }
        if(str.length() > 1) {
            str.delete(str.length() - 1, str.length());
        }
        System.out.print(str.toString());
        return  str.toString();


    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> result = new LinkedList<ChessboardPoint>(){{
            new ChessboardPoint(1,1);
        }};
        return result;

    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        return true;

    }
}
