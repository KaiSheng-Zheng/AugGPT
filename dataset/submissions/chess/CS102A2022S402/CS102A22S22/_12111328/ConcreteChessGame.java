import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private static ChessComponent[][] chessComponents1 ;

    public static ChessComponent[][] getChessComponents1() {
        return chessComponents1;
    }

    public  void setChessComponents1() {
        chessComponents1 = chessComponents;
    }

    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case ('R'):
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        break;
                    case ('N'):
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        break;
                    case ('B'):
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        break;
                    case ('Q'):
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        break;
                    case ('K'):
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        break;
                    case ('P'):
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        break;
                    case ('r'):
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        break;
                    case ('n'):
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        break;
                    case ('b'):
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        break;
                    case ('q'):
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        break;
                    case ('k'):
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        break;
                    case ('p'):
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        break;
                    default:
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        break;
                }
            }
        }
        setChessComponents1();
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return  chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder status = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                status.append(chessComponents[i][j].name);
            }
            if(i<7){
                status.append("\n");
            }
        }
        return status.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String x = "";
        StringBuilder status = new StringBuilder();
        int B=0;int K=0;int N=0;int P =0;int Q=0;int R=0;
        int b=0;int k=0;int n=0;int p =0;int q=0;int r=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case ('B'):
                        B ++;
                        break;
                    case ('K'):
                        K ++;
                        break;
                    case ('N'):
                        N ++;
                        break;
                    case ('P'):
                        P ++;
                        break;
                    case ('Q'):
                        Q ++;
                        break;
                    case ('R'):
                        R ++;
                        break;
                    case ('b'):
                        b ++;
                        break;
                    case ('k'):
                        k ++;
                        break;
                    case ('n'):
                        n ++;
                        break;
                    case ('p'):
                        p ++;
                        break;
                    case ('q'):
                        q ++;
                        break;
                    case ('r'):
                        r ++;
                        break;
                }
            }
        }

        if (player==ChessColor.BLACK){
            if ( K != 1) {
                x = x + "K " + String.valueOf(1 - K) + "\n";
            }
            if (Q != 1) {
                x = x + "Q " + String.valueOf(1 - Q) + "\n";
            }
            if (R != 2) {
                x = x + "R " + String.valueOf(2 - R) + "\n";
            }
            if ( B != 2) {
                x = x + "B " + String.valueOf(2 - B) + "\n";
            }
            if (N != 2) {
                x = x + "N " + String.valueOf(2 - N) + "\n";
            }
            if (P != 8) {
                x = x + "P " + String.valueOf(8 - P) + "\n";
            }
        }
        if(player==ChessColor.WHITE) {
            if ( k != 1) {
                x = x + "k " + String.valueOf(1 - k) + "\n";
            }
            if ( q != 1) {
                x = x + "q " + String.valueOf(1 - q) + "\n";
            }
            if ( r != 2) {
                x = x + "r " + String.valueOf(2 - r) + "\n";
            }
            if ( b != 2) {
                x = x + "b " + String.valueOf(2 - b) + "\n";
            }
            if ( n != 2) {
                x = x + "n " + String.valueOf(2 - n) + "\n";
            }
            if ( p != 8) {
                x = x + "p " + String.valueOf(8 - p) + "\n";
            }
        }
        return x;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            boolean x = chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY));
            if (x==true) {
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                setChessComponents1();

            if(currentPlayer==ChessColor.BLACK) {
                currentPlayer=ChessColor.WHITE;
            }
            else {
                currentPlayer=ChessColor.BLACK;
            }
        }
        return x;}
        else {
            return false;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        for(int j=1;j<canMovePoints.size();j++){
            for(int i=0;i<canMovePoints.size()-1;i++)
            {
                if(canMovePoints.get(i).getX()>canMovePoints.get(i+1).getX())
                {
                    ChessboardPoint a =canMovePoints.get(i);
                    canMovePoints.remove(i);
                    canMovePoints.add(i+1,a);
                }

                if(canMovePoints.get(i).getX()==canMovePoints.get(i+1).getX()&&canMovePoints.get(i).getY()>canMovePoints.get(i+1).getY())
                {
                    ChessboardPoint b =canMovePoints.get(i);
                    canMovePoints.remove(i);
                    canMovePoints.add(i+1,b);
                }

            }
        }
        return canMovePoints;
    }

}

