import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private int[] captureSort;
    private char[] sortw;
    private char[] sortb;
    private ChessComponent[][] chessComponents;
    private ArrayList<String> capturedChessw;
    private ArrayList<String> capturedChessb;
    private ChessColor currentPlayer;
    private EmptySlotComponent e;
    private BishopChessComponent b;
    private KingChessComponent k;
    private PawnChessComponent p;
    private QueenChessComponent q;
    private RookChessComponent r;
    private KnightChessComponent n;
    private BishopChessComponent B;
    private KingChessComponent K;
    private PawnChessComponent P;
    private QueenChessComponent Q;
    private RookChessComponent R;
    private KnightChessComponent N;

    public ConcreteChessGame(){
        captureSort = new int[6];
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        capturedChessw = new ArrayList<>();
        capturedChessb = new ArrayList<>();
        sortw = new char[]{'K','Q','R','B','N','P'};
        sortb = new char[]{'k','q','r','b','n','p'};
        e = new EmptySlotComponent();e.setChessColor(ChessColor.NONE);
        b = new BishopChessComponent();b.setChessColor(ChessColor.WHITE);
        k = new KingChessComponent();k.setChessColor(ChessColor.WHITE);
        p = new PawnChessComponent();p.setChessColor(ChessColor.WHITE);
        q = new QueenChessComponent();q.setChessColor(ChessColor.WHITE);
        r = new RookChessComponent();r.setChessColor(ChessColor.WHITE);
        n = new KnightChessComponent();n.setChessColor(ChessColor.WHITE);
        B = new BishopChessComponent();B.setChessColor(ChessColor.BLACK);
        K= new KingChessComponent();K.setChessColor(ChessColor.BLACK);
        P = new PawnChessComponent();P.setChessColor(ChessColor.BLACK);
        Q = new QueenChessComponent();Q.setChessColor(ChessColor.BLACK);
        R = new RookChessComponent();R.setChessColor(ChessColor.BLACK);
        N = new KnightChessComponent();N.setChessColor(ChessColor.BLACK);
        b.setName('b');
        k.setName('k');
        p.setName('p');
        q.setName('q');
        r.setName('r');
        n.setName('n');
        B.setName('B');
        K.setName('K');
        P.setName('P');
        Q.setName('Q');
        R.setName('R');
        N.setName('N');
        e.setName('_');
    }


    public ChessComponent[][] getChessComponents() {return chessComponents;}

    public ChessColor getCurrentPlayer() {return this.currentPlayer;}

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint>  a = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(a, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() < o2.getX()) {
                    return -1;
                } else if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getY() < o2.getY()) {
                    return -1;
                } else if (o1.getY() > o2.getY()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return a;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            if (sourceX<8 && sourceX>=0 && sourceY<8 && sourceY>=0 &&targetY<8 && targetY>=0 && targetX<8 && targetX>=0 ){
                if (chessComponents[sourceX][sourceY].getSource().check(chessComponents[sourceX][sourceY].canMoveTo(),targetX,targetY)){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    e.setSource(new ChessboardPoint(sourceX,sourceY));
                    chessComponents[sourceX][sourceY] = e;
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }else if (currentPlayer == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            chessComponents[i][j].setChessComponents(chessComponents);
                        }
                    }
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


    public void loadChessGame(List<String> chessboard){
        char chess;
        for (int i = 1;i < 9;i++) {
            for (int j = 1; j < 9; j++) {
                chess = chessboard.get(i - 1).charAt(j - 1);
                switch (chess) {
                    case '_':
                        e.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new EmptySlotComponent();
                        chessComponents[i - 1][j - 1].build(e);
                        break;
                    case 'b':
                        b.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new BishopChessComponent();
                        chessComponents[i - 1][j - 1].build(b);
                        break;
                    case 'k':
                        k.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new KingChessComponent();
                        chessComponents[i - 1][j - 1].build(k);
                        break;
                    case 'p':
                        p.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new PawnChessComponent();
                        chessComponents[i - 1][j - 1].build(p);
                        break;
                    case 'q':
                        q.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new QueenChessComponent();
                        chessComponents[i - 1][j - 1].build(q);
                        break;
                    case 'r':
                        r.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new RookChessComponent();
                        chessComponents[i - 1][j - 1].build(r);
                        break;
                    case 'n':
                        n.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new KnightChessComponent();
                        chessComponents[i - 1][j - 1].build(n);
                        break;
                    case 'B':
                        B.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new BishopChessComponent();
                        chessComponents[i - 1][j - 1].build(B);
                        break;
                    case 'K':
                        K.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new KingChessComponent();
                        chessComponents[i - 1][j - 1].build(K);
                        break;
                    case 'P':
                        P.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new PawnChessComponent();
                        chessComponents[i - 1][j - 1].build(P);
                        break;
                    case 'Q':
                        Q.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new QueenChessComponent();
                        chessComponents[i - 1][j - 1].build(Q);
                        break;
                    case 'R':
                        R.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new RookChessComponent();
                        chessComponents[i - 1][j - 1].build(R);
                        break;
                    case 'N':
                        N.setSource(new ChessboardPoint(i - 1, j - 1));
                        chessComponents[i - 1][j - 1] = new KnightChessComponent();
                        chessComponents[i - 1][j - 1].build(N);
                        break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
            if(chessboard.get(8).equals("w") ||chessboard.get(8).equals("W")){
                currentPlayer = ChessColor.WHITE;
            }else if (chessboard.get(8).equals("b")|| chessboard.equals("B")){
                currentPlayer = ChessColor.BLACK;
            }else {
                currentPlayer = ChessColor.NONE;
            }
    }

    public String getCapturedChess(ChessColor player) {
        captureSort[0] = 1;
        captureSort[1] = 1;
        captureSort[2] = 2;
        captureSort[3] = 2;
        captureSort[4] = 2;
        captureSort[5] = 8;
        StringBuffer str = new StringBuffer();
        if (player == ChessColor.WHITE) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessComponents[i][j].name == 'k') {
                            captureSort[0]--;
                        } else if (chessComponents[i][j].name == 'q') {
                            captureSort[1]--;
                        } else if (chessComponents[i][j].name == 'r') {
                            captureSort[2]--;
                        } else if (chessComponents[i][j].name == 'b') {
                            captureSort[3]--;
                        } else if (chessComponents[i][j].name == 'n') {
                            captureSort[4]--;
                        } else if (chessComponents[i][j].name == 'p'){
                            captureSort[5]--;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (captureSort[i] != 0) {
                        str.append(sortb[i]);
                        str.append(' ');
                        str.append(captureSort[i]);
                        str.append("\n");
                    }
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessComponents[i][j].name == 'K') {
                            captureSort[0]--;
                        } else if (chessComponents[i][j].name == 'Q') {
                            captureSort[1]--;
                        } else if (chessComponents[i][j].name == 'R') {
                            captureSort[2]--;
                        } else if (chessComponents[i][j].name == 'B') {
                            captureSort[3]--;
                        } else if (chessComponents[i][j].name == 'N') {
                            captureSort[4]--;
                        } else if (chessComponents[i][j].name == 'P'){
                            captureSort[5]--;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    if (captureSort[i] != 0) {
                        str.append(sortw[i]);
                        str.append(' ');
                        str.append(captureSort[i]);
                        str.append("\n");
                    }
                }
            }
        return String.valueOf(str);
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        StringBuffer fin = new StringBuffer();
        for (int i = 0;i<8;i++){
            for (ChessComponent chess:chessComponents[i]){
                fin.append(chess.name);
            }
            if(i != 7){
            fin.append("\n");
            }
        }
        return fin.toString();
    }
}