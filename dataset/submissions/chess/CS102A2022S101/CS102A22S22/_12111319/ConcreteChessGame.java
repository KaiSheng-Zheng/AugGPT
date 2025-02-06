import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private String boardGraph;
    private List<String> chessboard;

    public ConcreteChessGame () {
        currentPlayer = ChessColor.WHITE;
        chessComponents = new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source = new ChessboardPoint(i,j);
                chessComponents[i][j] = Turn(chessboard.get(i).charAt(j),source);
            }
        }
        if (chessboard.get(8).contains("w") ) {
            currentPlayer = ChessColor.WHITE;
        } else if ((chessboard.get(8).contains("b"))){
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.NONE;
        }
        StringBuilder g = new StringBuilder();
        for (int i = 0;i < 7;i++) {
            g.append(chessboard.get(i));
            g.append("\n");
        }
        g.append(chessboard.get(7));
        boardGraph = g.toString();
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph() {
        return boardGraph;
    }
    public String getCapturedChess(ChessColor player) {
        setBoardGraph(chessComponents);
        StringBuilder a = new StringBuilder();
        char qi;
        int k = 0,q = 0,r = 0,b = 0,n = 0,p = 0;
        int K = 0,Q = 0,R = 0,B = 0,N = 0,P = 0;
        for (int i = 0;i < boardGraph.length();i++) {
            qi = boardGraph.charAt(i);
            if (qi == 'k') {
                k++;
            } else if ((qi == 'q')) {
                q++;
            } else if ((qi == 'r')) {
                r++;
            } else if ((qi == 'b')) {
                b++;
            } else if ((qi == 'n')) {
                n++;
            } else if ((qi == 'p')) {
                p++;
            } else if (qi == 'K') {
                K++;
            } else if ((qi == 'Q')) {
                Q++;
            } else if ((qi == 'R')) {
                R++;
            } else if ((qi == 'B')) {
                B++;
            } else if ((qi == 'N')) {
                N++;
            } else if ((qi == 'P')) {
                P++;
            }
        }
        if (player == ChessColor.WHITE) {
            if (k == 0) {
                a.append("k "+1);
                a.append("\n");
            }
            if (q == 0) {
                a.append("q "+1);
                a.append("\n");
            }
            if (r != 2) {
                int g = 2-r;
                a.append("r "+g);
                a.append("\n");
            }
            if (b != 2) {
                int g = 2-b;
                a.append("b "+g);
                a.append("\n");
            }
            if (n != 2) {
                int g = 2-n;
                a.append("n "+g);
                a.append("\n");
            }
            if (p != 8) {
                int g = 8-p;
                a.append("p "+g);
                a.append("\n");
            }
        } else {
            if (K == 0) {
                a.append("K "+1);
                a.append("\n");
            }
            if (Q == 0) {
                a.append("Q "+1);
                a.append("\n");
            }
            if (R != 2) {
                int G = 2 - R;
                a.append("R "+G);
                a.append("\n");
            }
            if (B != 2) {
                int G = 2 - B;
                a.append("B "+G);
                a.append("\n");
            }
            if (N != 2) {
                int G = 2 - N;
                a.append("N "+G);
                a.append("\n");
            }
            if (P != 8) {
                int G = 8 - P;
                a.append("P "+G);
                a.append("\n");
            }
        }
        return a.toString();
    }
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public ChessComponent Turn(char a,ChessboardPoint source) {
        ChessboardPoint p = new ChessboardPoint(source.getX(), source.getY());
        if (a == 'k') {
            KingChessComponent k = new KingChessComponent('k',ChessColor.WHITE,chessComponents,source);
            return k;
        } else if (a == 'n'){
            KnightChessComponent n = new KnightChessComponent('n',ChessColor.WHITE,chessComponents,source);
            return n;
        } else if (a == 'r'){
            RookChessComponent r = new RookChessComponent('r',ChessColor.WHITE,chessComponents,source);
            return r;
        } else if (a == 'b'){
            BishopChessComponent b = new BishopChessComponent('b',ChessColor.WHITE,chessComponents,source);
            return b;
        } else if (a == 'q'){
            QueenChessComponent q = new QueenChessComponent('q',ChessColor.WHITE,chessComponents,source);
            return q;
        } else if (a == 'p') {
            PawnChessComponent pawn = new PawnChessComponent('p',ChessColor.WHITE,chessComponents,source);
            return pawn;
        } else if (a == 'K') {
            KingChessComponent K = new KingChessComponent('K',ChessColor.BLACK,chessComponents,source);
            return K;
        } else if (a == 'N'){
            KnightChessComponent N = new KnightChessComponent('N',ChessColor.BLACK,chessComponents,source);
            return N;
        } else if (a == 'R'){
            RookChessComponent R = new RookChessComponent('R',ChessColor.BLACK,chessComponents,source);
            return R;
        } else if (a == 'B'){
            BishopChessComponent B = new BishopChessComponent('B',ChessColor.BLACK,chessComponents,source);
            return B;
        } else if (a == 'Q'){
            QueenChessComponent Q = new QueenChessComponent('Q',ChessColor.BLACK,chessComponents,source);
            return Q;
        } else if (a == 'P') {
            PawnChessComponent Pawn = new PawnChessComponent('P',ChessColor.BLACK,chessComponents,source);
            return Pawn;
        }else {
            EmptySlotComponent o = new EmptySlotComponent('_',ChessColor.NONE,chessComponents,source);
            return o;
        }
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setBoardGraph(ChessComponent[][] chessComponents1) {
        StringBuilder g = new StringBuilder();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                g.append(chessComponents1[j][i].name);
            }
            g.append("\n");
        }
        boardGraph = g.toString();
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()) {
            if (chessComponents[sourceX][sourceY].canMoveto(targetX,targetY)) {
                if (chessComponents[sourceX][sourceY].getChessColor()  == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else if (chessComponents[sourceX][sourceY].getChessColor()  == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                }
                ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',ChessColor.NONE,chessComponents,source);
                if (chessComponents[targetX][targetY] instanceof BishopChessComponent) {
                    ChessboardPoint s = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY] = new BishopChessComponent(chessComponents[targetX][targetY].name,chessComponents[targetX][targetY].getChessColor(),chessComponents,s);
                } else if (chessComponents[targetX][targetY] instanceof RookChessComponent) {
                    ChessboardPoint s = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY] = new RookChessComponent(chessComponents[targetX][targetY].name,chessComponents[targetX][targetY].getChessColor(),chessComponents,s);
                } else if (chessComponents[targetX][targetY] instanceof KnightChessComponent) {
                    ChessboardPoint s = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY] = new KnightChessComponent(chessComponents[targetX][targetY].name,chessComponents[targetX][targetY].getChessColor(),chessComponents,s);
                } else if (chessComponents[targetX][targetY] instanceof QueenChessComponent) {
                    ChessboardPoint s = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY] = new QueenChessComponent(chessComponents[targetX][targetY].name,chessComponents[targetX][targetY].getChessColor(),chessComponents,s);
                }
                chessboard.set(sourceX,chessComponents[sourceX].toString());
                chessboard.set(targetX,chessComponents[targetX].toString());
                return true;
            }
            return false;
        }
        return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoints;
    }
}
