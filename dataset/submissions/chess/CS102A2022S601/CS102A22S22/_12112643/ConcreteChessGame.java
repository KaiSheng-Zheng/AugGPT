import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            String str = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                String s = str.substring(j, j + 1);
                if (s.equals("R")) {
                    ChessComponent br = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', this);
                    chessComponents[i][j] = br;
                } else if (s.equals("N")) {
                    ChessComponent bn = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', this);
                    chessComponents[i][j] = bn;
                } else if (s.equals("B")) {
                    ChessComponent bb = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', this);
                    chessComponents[i][j] = bb;
                } else if (s.equals("Q")) {
                    ChessComponent bq = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', this);
                    chessComponents[i][j] = bq;
                } else if (s.equals("K")) {
                    ChessComponent bk = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', this);
                    chessComponents[i][j] = bk;
                } else if (s.equals("P")) {
                    ChessComponent bp = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', this);
                    chessComponents[i][j] = bp;
                } else if (s.equals("p")) {
                    ChessComponent wp = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', this);
                    chessComponents[i][j] = wp;
                } else if (s.equals("k")) {
                    ChessComponent wk = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', this);
                    chessComponents[i][j] = wk;
                } else if (s.equals("q")) {
                    ChessComponent wq = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', this);
                    chessComponents[i][j] = wq;
                } else if (s.equals("b")) {
                    ChessComponent wb = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', this);
                    chessComponents[i][j] = wb;
                } else if (s.equals("n")) {
                    ChessComponent wn = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', this);
                    chessComponents[i][j] = wn;
                } else if (s.equals("r")) {
                    ChessComponent wr = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', this);
                    chessComponents[i][j] = wr;
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(this,ChessColor.NONE, new ChessboardPoint(i, j));
                }
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(getChess(i, j).name);
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String getCapturedChess(ChessColor player) {
        String result = "";
        int ck = 0;
        int cq = 0;
        int cr = 0;
        int cb = 0;
        int cn = 0;
        int cp = 0;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k")) {
                        ck = 1;
                    } else if (chessComponents[i][j].toString().equals("q")) {
                        cq = 1;
                    } else if (chessComponents[i][j].toString().equals("r")) {
                        cr++;
                    } else if (chessComponents[i][j].toString().equals("b")) {
                        cb++;
                    } else if (chessComponents[i][j].toString().equals("n")) {
                        cn++;
                    } else if (chessComponents[i][j].toString().equals("p")) {
                        cp++;
                    }
                }
            }
            ck = 1 - ck;
            cq = 1 - cq;
            cr = 2 - cr;
            cb = 2 - cb;
            cn = 2 - cn;
            cp = 8 - cp;
            if (ck != 0) {
                result = result + "k" + " " + ck + "\n";
            }
            if (cq != 0) {
                result = result + "q" + " " + cq + "\n";
            }
            if (cr != 0) {
                result = result + "r" + " " + cr + "\n";
            }
            if (cb != 0) {
                result = result + "b" + " " + cb + "\n";
            }
            if (cn != 0) {
                result = result + "n" + " " + cn + "\n";
            }
            if (cp != 0) {
                result = result + "p" + " " + cp + "\n";
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K")) {
                        ck = 1;
                    } else if (chessComponents[i][j].toString().equals("Q")) {
                        cq = 1;
                    } else if (chessComponents[i][j].toString().equals("R")) {
                        cr++;
                    } else if (chessComponents[i][j].toString().equals("B")) {
                        cb++;
                    } else if (chessComponents[i][j].toString().equals("N")) {
                        cn++;
                    } else if (chessComponents[i][j].toString().equals("P")) {
                        cp++;
                    }
                }
            }
            ck = 1 - ck;
            cq = 1 - cq;
            cr = 2 - cr;
            cb = 2 - cb;
            cn = 2 - cn;
            cp = 8 - cp;
            if (ck != 0) {
                result = result + "K" + " " + ck + "\n";
            }
            if (cq != 0) {
                result = result + "Q" + " " + cq + "\n";
            }
            if (cr != 0) {
                result = result + "R" + " " + cr + "\n";
            }
            if (cb != 0) {
                result = result + "B" + " " + cb + "\n";
            }
            if (cn != 0) {
                result = result + "N" + " " + cn + "\n";
            }
            if (cp != 0) {
                result = result + "P" + " " + cp + "\n";
            }
        }
//
//        if (result.equals("")){
//            return null;
//        }
        return result;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {


        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> list = chess.canMoveTo();
            Collections.sort(list,new Comparator<ChessboardPoint>() {
            @Override
            public int compare (ChessboardPoint o1, ChessboardPoint o2){
                if ((o1.getX() - o2.getX() > 0 ? 1 : o1.getX() == o2.getX() ? 0 : -1) != 0) {
                    return (o1.getX() - o2.getX() > 0 ? 1 : o1.getX() == o2.getX() ? 0 : -1);
                } else {
                    return (o1.getY() - o2.getY() > 0 ? 1 : -1);
                }
            }
        });
            return list;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
             boolean b = false;
             ChessComponent che = getChess(sourceX,sourceY);
             for (ChessboardPoint p : che.canMoveTo()) {
                if (p.getX() == targetX && p.getY() == targetY ) {
                    b = true;
                }
            }
            if (che.getChessColor() != currentPlayer){
                b = false;
            }
            if (b){
                currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
            }
            if (b && getChess(targetX,targetY) != null){
                chessComponents[targetX][targetY] =  chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]. setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(this,ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));

            }else if (b && getChess(targetX,targetY) == null){
                chessComponents[targetX][targetY] =  chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(this,ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
            }
        return b;


    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}
