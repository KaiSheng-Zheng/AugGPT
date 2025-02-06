import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    /* A 2-dimension array to store all the chess components
     should be initialized in your construct method.
     i.e. = new ChessComponent[8][8]*/
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    /* What's the current player's color, black or white?
     should be initialized in your construct method.
     by default, set the color to white.*/
    private ChessColor currentPlayer;
    private ChessboardPoint source;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

//    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
//        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
//        if (!(chess2 instanceof EmptySlotComponent)) {
//            remove(chess2);
//            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
//        }
//        chess1.swapLocation(chess2);
//        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
//        chessComponents[row1][col1] = chess1;
//        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
//        chessComponents[row2][col2] = chess2;
//    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessboard.get(i).charAt(j);
                if (name == 'r' || name == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == 'n' || name == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == 'b' || name == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == 'q' || name == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == 'k' || name == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == 'p' || name == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),name,this);
                }
                if (name == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),name,this);
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w') {
            currentPlayer = ChessColor.WHITE;
        } else currentPlayer = ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        String re = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                re += chessComponents[i][j].getName();
            }
            re += "\n";
        }
        return re;
    }

    public String getCapturedChess(ChessColor player) {
        String cc = "";
        int K=0;int Q=0;int R=0;int B=0;int N=0;int P=0;
        int k=0;int q=0;int r=0;int b=0;int n=0;int p=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        k++;
                    } else K++;
                }
                if (chessComponents[i][j] instanceof QueenChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        q++;
                    } else Q++;
                }
                if (chessComponents[i][j] instanceof RookChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        r++;
                    } else R++;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        b++;
                    } else B++;
                }
                if (chessComponents[i][j] instanceof KnightChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        n++;
                    } else N++;
                }
                if (chessComponents[i][j] instanceof PawnChessComponent) {
                    if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        p++;
                    } else P++;
                }
            }
        }

        if (player == ChessColor.BLACK) {
            int lostK = 1-K;
            if (lostK > 0) cc+=String.format("K %d\n",lostK);
            int lostQ = 1-Q;
            if (lostQ > 0) cc+=String.format("Q %d\n",lostQ);
            int lostR = 2-R;
            if (lostR > 0) cc+=String.format("R %d\n",lostR);
            int lostB = 2-B;
            if (lostB > 0) cc+=String.format("B %d\n",lostB);
            int lostN = 2-N;
            if (lostN > 0) cc+=String.format("N %d\n",lostN);
            int lostP = 8-P;
            if (lostP > 0) cc+=String.format("P %d\n",lostP);
        } else {
            int lostK = 1-k;
            if (lostK > 0) cc += String.format("k %d\n", lostK);
            int lostQ = 1-q;
            if (lostQ > 0) cc += String.format("q %d\n", lostQ);
            int lostR = 2-r;
            if (lostR > 0) cc += String.format("r %d\n", lostR);
            int lostB = 2-b;
            if (lostB > 0) cc += String.format("b %d\n", lostB);
            int lostN = 2-n;
            if (lostN > 0) cc += String.format("n %d\n", lostN);
            int lostP = 8-p;
            if (lostP > 0) cc += String.format("p %d\n", lostP);
        }
        return cc;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent cs = this.getChessComponents()[sourceX][sourceY];
        boolean re = false;
        for (int i = 0; i < cs.canMoveTo().size(); i++) {
            if (cs.canMoveTo().get(i).getX()==targetX&&cs.canMoveTo().get(i).getY()==targetY
                        && cs.getChessColor()==currentPlayer) {
                char name = chessComponents[sourceX][sourceY].getName();
                if (name == 'r' || name == 'R') {
                    chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == 'n' || name == 'N') {
                    chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == 'b' || name == 'B') {
                    chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == 'q' || name == 'Q') {
                    chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == 'k' || name == 'K') {
                    chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == 'p' || name == 'P') {
                    chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                if (name == '_') {
                    chessComponents[targetX][targetY] = new EmptySlotComponent(new ChessboardPoint(targetX,targetY),name,this);
                }
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),'_',this);
                if (currentPlayer==ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else currentPlayer = ChessColor.WHITE;
                re = true;
            }
        }
        return re;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> cbp = this.getChessComponents()[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> cbs = cbp;
        for(int i=0; i<cbs.size()-1; i++){
            for(int j=i+1; j<cbs.size(); j++){
                if(cbs.get(i).getX()>cbs.get(j).getX()){
                    ChessboardPoint temp = cbs.get(i);
                    cbs.set(i,cbs.get(j));
                    cbs.set(j,temp);
                }
                if (cbs.get(i).getX() == cbs.get(j).getX()){
                    if (cbs.get(i).getY()>cbs.get(j).getY()) {
                        ChessboardPoint temp = cbs.get(i);
                        cbs.set(i,cbs.get(j));
                        cbs.set(j,temp);
                    }
                }
            }
        }
        return cbs;
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }
}
