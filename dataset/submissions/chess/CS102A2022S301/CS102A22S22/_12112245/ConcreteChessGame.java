


import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    RookChessComponent a = new RookChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('R');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    KnightChessComponent a = new KnightChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('N');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    BishopChessComponent a = new BishopChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('B');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    QueenChessComponent a = new QueenChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('Q');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    KingChessComponent a = new KingChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('K');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    PawnChessComponent a = new PawnChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.BLACK);
                    a.setName('P');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    RookChessComponent a = new RookChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.WHITE);
                    a.setName('r');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    KnightChessComponent a = new KnightChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.WHITE);
                    a.setName('n');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    BishopChessComponent a = new BishopChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.WHITE);
                    a.setName('b');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    QueenChessComponent a = new QueenChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.WHITE);
                    a.setName('q');
                    a.setSource(b);
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    KingChessComponent a = new KingChessComponent(chessComponents, b);
                    a.setChessColor(ChessColor.WHITE);
                    a.setName('k');
                    a.setSource(b);
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    PawnChessComponent a = new PawnChessComponent(chessComponents, b);

                    a.setChessColor(ChessColor.WHITE);
                    a.setName('p');
                    chessComponents[i][j] = a;
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    ChessboardPoint b = new ChessboardPoint(i, j);
                    EmptySlotComponent a = new EmptySlotComponent(chessComponents, b);
                    a.setChessColor(ChessColor.NONE);
                    a.setName('_');
                    chessComponents[i][j] = a;
                }


            }

        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        }

    }

    @Override
    public String getChessboardGraph() {
        String ans = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == '_') {
                    ans += ("_");
                } else {
                    ans += (chessComponents[i][j]);
                }
            }
            ans += ("\n");
        }
        System.out.println(ans);
        return ans;
    }

    public ChessComponent getChessComponents(int i, int j) {
        return chessComponents[i][j];
    }


    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
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
    public String getCapturedChess(ChessColor player) {
        int[] sm = {1, 1, 2, 2, 2, 8};// r 2,b 3,n 4,k 0,q 1,p 5
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'R') {
                        sm[2] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'B') {
                        sm[3] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'N') {
                        sm[4] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'K') {
                        sm[0] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'Q') {
                        sm[1] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'P') {
                        sm[5] -= 1;
                    }
                }

            }
            String ans = "";

            if (sm[0] != 0) {
                ans += "K " + sm[0] + "\n";
            }
            if (sm[1] != 0) {
                ans += "Q " + sm[1] + "\n";
            }
            if (sm[2] != 0) {
                ans += "R " + sm[2] + "\n";
            }
            if (sm[3] != 0) {
                ans += "B " + sm[3] + "\n";
            }
            if (sm[4] != 0) {
                ans += "N " + sm[4] + "\n";
            }
            if (sm[5] != 0) {
                ans += "P " + sm[5] + "\n";
            }
            return ans;


        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'r') {
                        sm[2] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'b') {
                        sm[3] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'n') {
                        sm[4] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'k') {
                        sm[0] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'q') {
                        sm[1] -= 1;
                    }
                    if (chessComponents[i][j].getName() == 'p') {
                        sm[5] -= 1;
                    }
                }

            }
            String ans = "";

            if (sm[0] != 0) {
                ans += "k " + sm[0] + "\n";
            }
            if (sm[1] != 0) {
                ans += "q " + sm[1] + "\n";
            }
            if (sm[2] != 0) {
                ans += "r " + sm[2] + "\n";
            }
            if (sm[3] != 0) {
                ans += "b " + sm[3] + "\n";
            }
            if (sm[4] != 0) {
                ans += "n " + sm[4] + "\n";
            }
            if (sm[5] != 0) {
                ans += "p " + sm[5] + "\n";
            }
            return ans;

        }

    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChessComponents(source.getX(),source.getY());

        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        return canMovePoints;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chess = new ChessboardPoint(sourceX,sourceY);

        boolean f=false;
        if(getChessComponents(sourceX,sourceY).getChessColor()==getCurrentPlayer()) {
            for (ChessboardPoint chessboardPoint : chessComponents[sourceX][sourceY].canMoveTo()) {
                if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                    swapLocation(sourceX, sourceY, targetX, targetY);

                    f = true;


                }

            }
        }
        if( f==true&&getCurrentPlayer() == ChessColor.BLACK) {
            setCurrentPlayer(ChessColor.WHITE);
        } else if(f==true&&getCurrentPlayer()==ChessColor.WHITE){
            setCurrentPlayer(ChessColor.BLACK);
        }
        return f;



    }
    public void swapLocation( int sX,int sY,int tX,int tY){
        ChessboardPoint c1=new ChessboardPoint(sX,sY);
        
        ChessComponent chess1 = getChessComponents(sX,sY);
        ChessComponent chess2=getChessComponents(tX,tY);
        chess2.setChessColor(chess1.getChessColor());
        chess2.setName(chess1.getName());
        
        chess1.setSource(getChessComponents(tX,tY).getSource());
        chessComponents[sX][sY]=new EmptySlotComponent(chessComponents,c1);
        chessComponents[tX][tY]=chess1;
    }
}
