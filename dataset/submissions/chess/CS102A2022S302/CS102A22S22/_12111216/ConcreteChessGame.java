import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.BLACK;
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                        break;

                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;



                }
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){currentPlayer = ChessColor.WHITE;}else {currentPlayer=ChessColor.BLACK;}

    }
    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder a1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a1.append(chessComponents[i][j].toString());
            }
            a1.append("\n");
        }
        return a1.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int Q = 1;
        int K = 1;
        int B = 2;
        int R = 2;
        int N = 2;
        int P = 8;
        int Q1 = 0;
        int K1 = 0;
        int B1 = 0;
        int R1 = 0;
        int N1 = 0;
        int P1 = 0;
        int q1 = 0;
        int k1 = 0;
        int b1 = 0;
        int r1 = 0;
        int n1 = 0;
        int p1 = 0;
        StringBuilder lost = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].toString().charAt(0)) {
                    case 'R':
                        R1++;
                        break;
                    case 'N':
                        N1++;
                        break;
                    case 'B':
                        B1++;
                        break;
                    case 'Q':
                        Q1++;
                        break;
                    case 'K':
                        K1++;
                        break;
                    case 'P':
                        P1++;
                        break;
                    case '_':
                        break;
                    case 'r':
                        r1++;
                        break;
                    case 'n':
                        n1++;
                        break;
                    case 'b':
                        b1++;
                        break;
                    case 'q':
                        q1++;
                        break;
                    case 'k':
                        k1++;
                        break;
                    case 'p':
                        p1++;
                        break;


                }
            }}
            if (player.equals(ChessColor.BLACK)) {
                if(K1!=K)lost.append(String.format("K %d\n",K-K1));
                if(Q1!=Q)lost.append(String.format("Q %d\n",Q-Q1));
                if(R1!=R)lost.append(String.format("R %d\n",R-R1));
                if(B1!=B)lost.append(String.format("B %d\n",B-B1));
                if(N1!=N)lost.append(String.format("N %d\n",N-N1));
                if(P1!=P)lost.append(String.format("P %d\n",P-P1));

            }else {
                if(k1!=K)lost.append(String.format("k %d\n",K-k1));
                if(q1!=Q)lost.append(String.format("q %d\n",Q-q1));
                if(r1!=R)lost.append(String.format("r %d\n",R-r1));
                if(b1!=B)lost.append(String.format("b %d\n",B-b1));
                if(n1!=N)lost.append(String.format("n %d\n",N-n1));
                if(p1!=P)lost.append(String.format("p %d\n",P-p1));
            }

        return lost.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(currentPlayer==chessComponents[sourceX][sourceY].getChessColor()){
            if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));

                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].setChessComponents(chessComponents);
                chessComponents[targetX][targetX].setChessComponents(chessComponents);
                if(currentPlayer==ChessColor.BLACK){currentPlayer=ChessColor.WHITE;}
                else {currentPlayer=ChessColor.BLACK;}
                return true;
            }else return false;
        }else return false;

    }

    @Override
    public ChessComponent getChess(int y, int x){
        return chessComponents[y][x];
    }




}
