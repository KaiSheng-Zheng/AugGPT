import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private String str;
    private List<String> chessboard;

    public ConcreteChessGame() {
        init();
    }

    private void init() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i= 0; i<8; i++){
            for (int j= 0; j<8; j++){
                char s = chessboard.get(i).charAt(j);
                switch (s){
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.BLACK,'B');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptyChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.NONE,'_');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), chessComponents,ChessColor.BLACK,'K');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.BLACK,'N');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.BLACK,'P');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.BLACK,'Q');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.BLACK,'R');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), chessComponents, ChessColor.WHITE,'b');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.WHITE,'k');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.WHITE,'n');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.WHITE,'p');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),chessComponents, ChessColor.WHITE,'q');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), chessComponents,ChessColor.WHITE,'r');
                        break;
                }
            }
        }  if (chessboard.get(8).equals("w")){
            str = "w";
            currentPlayer = ChessColor.WHITE;
        }else {
            str = "b";
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public List<String> getChessboard() {
        return chessboard;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void swapColor() {
        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public String getChessboardGraph() {
        StringBuilder[] str1 = new StringBuilder[8];
        for (int i=0; i<8; i++){
            str1[i] = new StringBuilder("0");
        }
        for (int i= 0; i<8; i++){
            for (int j=0; j<8; j++){
                str1[i].append(chessComponents[i][j].name);
            }
        }

        return str1[0].substring(1,9) + "\n" + str1[1].substring(1,9) +"\n" +str1[2].substring(1,9) + "\n" +str1[3].substring(1,9) +"\n"+str1[4].substring(1,9)+"\n"+str1[5].substring(1,9)+"\n"+str1[6].substring(1,9) +"\n" +str1[7].substring(1,9);
        }


    @Override
    public String getCapturedChess(ChessColor player) {
        int[] arr = new int[12];
        for (int i=0; i<12; i++){
            arr[i] = 0;
        }
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                    switch (chessComponents[i][j].name){
                        case 'B':
                            arr[0]++;
                            break;
                        case 'K':
                            arr[1]++;
                            break;
                        case 'N':
                            arr[2]++;
                            break;
                        case 'P':
                            arr[3]++;
                            break;
                        case 'Q':
                            arr[4]++;
                            break;
                        case 'R':
                            arr[5]++;
                            break;
                        case 'b':
                            arr[6]++;
                            break;
                        case 'k':
                            arr[7]++;
                            break;
                        case 'n':
                            arr[8]++;
                            break;
                        case 'p':
                            arr[9]++;
                            break;
                        case 'q':
                            arr[10]++;
                            break;
                        case 'r':
                            arr[11]++;
                            break;
                }
            }
        }
        int[] num = new int[12];
        num[0] = 2-arr[0];
        num[1] = 1-arr[1];
        num[2] = 2-arr[2];
        num[3] = 8-arr[3];
        num[4] = 1-arr[4];
        num[5] = 2-arr[5];
        num[6] = 2-arr[6];
        num[7] = 1-arr[7];
        num[8] = 2-arr[8];
        num[9] = 8-arr[9];
        num[10] = 1-arr[10];
        num[11] = 2-arr[11];
        StringBuilder s = new StringBuilder();
        if (player == ChessColor.BLACK){
            if (num[1] != 0){
                s.append('K');
                s.append(' ');
                s.append(num[1]);
                s.append("\n");
            }
            if (num[4] != 0){
                s.append('Q');
                s.append(' ');
                s.append(num[4]);
                s.append("\n");
            }
            if (num[5] != 0){
                s.append('R');
                s.append(' ');
                s.append(num[5]);
                s.append("\n");
            }
        if (num[0] != 0){
            s.append('B');
            s.append(' ');
            s.append(num[0]);
            s.append("\n");
        }
        if (num[2] != 0){
            s.append('N');
            s.append(' ');
            s.append(num[2]);
            s.append("\n");
        }
        if (num[3] != 0){
            s.append('P');
            s.append(' ');
            s.append(num[3]);
            s.append("\n");
        }
        }
        if (player == ChessColor.WHITE){
            if (num[7] != 0){
                s.append('k');
                s.append(' ');
                s.append(num[7]);
                s.append("\n");
            }
            if (num[10] != 0){
                s.append('q');
                s.append(' ');
                s.append(num[10]);
                s.append("\n");
            }
            if (num[11] != 0){
                s.append('r');
                s.append(' ');
                s.append(num[11]);
                s.append("\n");
            }
        if (num[6] != 0){
            s.append('b');
            s.append(' ');
            s.append(num[6]);
            s.append("\n");
        }
        if (num[8] != 0){
            s.append('n');
            s.append(' ');
            s.append(num[8]);
            s.append("\n");
        }
        if (num[9] != 0){
            s.append('p');
            s.append(' ');
            s.append(num[9]);
            s.append("\n");
        }
        }
System.out.println(num[3]);
        return s.toString();
    }
//public String getCapturedChess(ChessColor player) {
//    StringBuilder a = new StringBuilder();
//    char qi;
//    int k = 0,q = 0,r = 0,b = 0,n = 0,p = 0;
//    int K = 0,Q = 0,R = 0,B = 0,N = 0,P = 0;
//    for (int i = 0;i < 8;i++) {
//        for (int j=0; j<8; j++){
//        qi = chessComponents[i][j].name;
//        if (qi == 'k') {
//            k++;
//        } else if ((qi == 'q')) {
//            q++;
//        } else if ((qi == 'r')) {
//            r++;
//        } else if ((qi == 'b')) {
//            b++;
//        } else if ((qi == 'n')) {
//            n++;
//        } else if ((qi == 'p')) {
//            p++;
//        } else if (qi == 'K') {
//            K++;
//        } else if ((qi == 'Q')) {
//            Q++;
//        } else if ((qi == 'R')) {
//            R++;
//        } else if ((qi == 'B')) {
//            B++;
//        } else if ((qi == 'N')) {
//            N++;
//        } else if ((qi == 'P')) {
//            P++;
//        }
//    }
//    if (player == ChessColor.WHITE) {
//        if (k == 0) {
//            a.append("k "+1);
//            a.append("\n");
//        }
//        if (q == 0) {
//            a.append("q "+1);
//            a.append("\n");
//        }
//        if (r != 2) {
//            int g = 2-r;
//            a.append("r "+g);
//            a.append("\n");
//        }
//        if (b != 2) {
//            int g = 2-b;
//            a.append("b "+g);
//            a.append("\n");
//        }
//        if (n != 2) {
//            int g = 2-n;
//            a.append("n "+g);
//            a.append("\n");
//        }
//        if (p != 8) {
//            int g = 8-p;
//            a.append("p "+g);
//            a.append("\n");
//        }
//    } else {
//        if (K == 0) {
//            a.append("K "+1);
//            a.append("\n");
//        }
//        if (Q == 0) {
//            a.append("Q "+1);
//            a.append("\n");
//        }
//        if (R != 2) {
//            int G = 2 - R;
//            a.append("R "+G);
//            a.append("\n");
//        }
//        if (B != 2) {
//            int G = 2 - B;
//            a.append("B "+G);
//            a.append("\n");
//        }
//        if (N != 2) {
//            int G = 2 - N;
//            a.append("N "+G);
//            a.append("\n");
//        }
//        if (P != 8) {
//            int G = 8 - P;
//            a.append("P "+G);
//            a.append("\n");
//        }
//    }
//    }
//    return a.toString();
//}


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent C = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = C.canMoveTo();
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        for (int i = 0;i < 8;i++) {
            for (int j=0; j<8; j++){
                System.out.print(chessComponents[i][j].name);
            }
            System.out.println(" ");
        }

        System.out.println(getCapturedChess(ChessColor.WHITE));

        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        if (chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)) {
                if (getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).contains(chessComponents[targetX][targetY].getSource())) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptyChessComponent(new ChessboardPoint(sourceX,sourceY), chessComponents, ChessColor.NONE, '_');
                    if (getCurrentPlayer() == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }else {
                    return false;
                }
        }
        return false;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

}
