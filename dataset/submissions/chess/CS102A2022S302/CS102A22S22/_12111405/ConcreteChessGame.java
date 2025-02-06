import java.util.HashMap;
import java.util.List;


public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent getChessComponents(int i, int j) {
        return chessComponents[i][j];
    }


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;

    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case '_':
                        ChessboardPoint e=new ChessboardPoint(i,j);
                        chessComponents[i][j] = new EmptySlotComponent(e);
                        chessComponents[i][j].name = '_';
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setChessboard(this.chessComponents);

                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].name = 'R';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint R=new ChessboardPoint(i,j);
                        R.setX(i);
                        R.setY(j);
                        chessComponents[i][j].setSource(R);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].name = 'r';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint r=new ChessboardPoint(i,j);
                        r.setX(i);
                        r.setY(j);
                        chessComponents[i][j].setSource(r);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].name = 'K';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint K=new ChessboardPoint(i,j);
                        K.setX(i);
                        K.setY(j);
                        chessComponents[i][j].setSource(K);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].name = 'k';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint k=new ChessboardPoint(i,j);
                        k.setX(i);
                        k.setY(j);
                        chessComponents[i][j].setSource(k);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].name = 'Q';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint Q=new ChessboardPoint(i,j);
                        Q.setX(i);
                        Q.setY(j);
                        chessComponents[i][j].setSource(Q);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].name = 'q';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint q=new ChessboardPoint(i,j);
                        q.setX(i);
                        q.setY(j);
                        chessComponents[i][j].setSource(q);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].name = 'B';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint B=new ChessboardPoint(i,j);
                        B.setX(i);
                        B.setY(j);
                        chessComponents[i][j].setSource(B);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].name = 'b';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint b=new ChessboardPoint(i,j);
                        b.setX(i);
                        b.setY(j);
                        chessComponents[i][j].setSource(b);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].name = 'N';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint N=new ChessboardPoint(i,j);
                        N.setX(i);
                        N.setY(j);
                        chessComponents[i][j].setSource(N);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].name = 'n';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint n=new ChessboardPoint(i,j);
                        n.setX(i);
                        n.setY(j);
                        chessComponents[i][j].setSource(n);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].name = 'P';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint P=new ChessboardPoint(i,j);
                        P.setX(i);
                        P.setY(j);
                        chessComponents[i][j].setSource(P);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].name = 'p';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        ChessboardPoint p=new ChessboardPoint(i,j);
                        p.setX(i);
                        p.setY(j);
                        chessComponents[i][j].setSource(p);
                        break;
                }


            }

        }
        String color = chessboard.get(8);
        if (color.equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else currentPlayer = ChessColor.BLACK;

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        StringBuilder d = new StringBuilder();
        StringBuilder e = new StringBuilder();
        StringBuilder f = new StringBuilder();
        StringBuilder g = new StringBuilder();
        StringBuilder h = new StringBuilder();

        for (int j = 0; j < chessComponents[0].length; j++) {
            a.append(chessComponents[0][j].name);
            b.append(chessComponents[1][j].name);
            c.append(chessComponents[2][j].name);
            d.append(chessComponents[3][j].name);
            e.append(chessComponents[4][j].name);
            f.append(chessComponents[5][j].name);
            g.append(chessComponents[6][j].name);
            h.append(chessComponents[7][j].name);
        }


        return a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String chess = getChessboardGraph();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chess.length(); i++) {
            if (map.containsKey(chess.charAt(i))) {
                map.put(chess.charAt(i), map.get(chess.charAt(i)) + 1);
            } else {
                map.put(chess.charAt(i), 1);
            }
        }
        int K = 1 - map.getOrDefault('K',0);
        int k = 1 - map.getOrDefault('k',0);
        int Q = 1 - map.getOrDefault('Q',0);
        int q = 1 - map.getOrDefault('q',0);
        int B = 2 - map.getOrDefault('B',0);
        int b = 2 - map.getOrDefault('b',0);
        int N = 2 - map.getOrDefault('N',0);
        int n = 2 - map.getOrDefault('n',0);
        int R = 2 - map.getOrDefault('R',0);
        int r = 2 - map.getOrDefault('r',0);
        int P = 8 - map.getOrDefault('P',0);
        int p = 8 - map.getOrDefault('p',0);
        StringBuilder sb = new StringBuilder();
        if (player.equals(ChessColor.BLACK)) {
            if (K != 0) {
                sb.append("K " + K + "\n");
            }
            if (Q != 0) {
                sb.append("Q " + Q + "\n");
            }
            if (R != 0) {
                sb.append("R " + R + "\n");
            }
            if (B != 0) {
                sb.append("B " + B + "\n");
            }
            if (N != 0) {
                sb.append("N " + N + "\n");
            }
            if (P != 0) {
                sb.append("P " + P + "\n");
            }
        }
        if (player.equals(ChessColor.WHITE)){
            if (k != 0) {
                sb.append("k " + k + "\n");
            }
            if (q != 0) {
                sb.append("q " + q + "\n");
            }
            if (r != 0) {
                sb.append("r " + r + "\n");
            }
            if (b != 0) {
                sb.append("b " + b + "\n");
            }
            if (n != 0) {
                sb.append("n " + n + "\n");
            }
            if (p != 0) {
                sb.append("p " + p + "\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();


            return canMovePoints;

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> canMove = getCanMovePoints(source);
        boolean contain = false;
        if (chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        for(int p=0;p<canMove.size();p++){
            if(canMove.get(p).getX()==targetX&&canMove.get(p).getY()==targetY){
                contain = true;
                break;
            }
        }
        if(contain){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(source);

            if(currentPlayer.equals(ChessColor.BLACK)){
                currentPlayer = ChessColor.WHITE;
            }else {
                currentPlayer = ChessColor.BLACK;
            }
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            for(int a=0; a<8; a++){
                for(int b=0; b<8; b++){
                    chessComponents[a][b].setChessboard(this.chessComponents);
                }
            }
            return true;
        }else {
            return false;
        }


    }



    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}