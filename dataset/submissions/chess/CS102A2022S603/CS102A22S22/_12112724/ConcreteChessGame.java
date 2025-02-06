import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K')
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'k')
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'Q')
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'q')
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'R')
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'r')
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'B')
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'b')
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'N')
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'n')
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'P')
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'p')
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
            }
        }
        for (int i=0;i<8;i++){
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
        switch (chessboard.get(8)) {
            case "w":
                this.currentPlayer = ChessColor.WHITE;
                break;
            case "b":
                this.currentPlayer = ChessColor.BLACK;
                break;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder Board1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board1.append(getChess(i, j).name);
            }
            Board1.append("\n");
        }
        return new String(Board1);
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder CapturedChess = new StringBuilder();
        int nubK = 0, nubQ = 0, nubR = 0, nubB = 0, nubN = 0, nubP = 0;
        int nubk = 0, nubq = 0, nubr = 0, nubb = 0, nubn = 0, nubp = 0;
        if (player.equals(ChessColor.BLACK)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (getChess(i, j).name) {
                        case 'K':
                            nubK++;
                            break;
                        case 'Q':
                            nubQ++;
                            break;
                        case 'R':
                            nubR++;
                            break;
                        case 'B':
                            nubB++;
                            break;
                        case 'N':
                            nubN++;
                            break;
                        case 'P':
                            nubP++;
                            break;
                    }
                }
            }
                if (nubK !=1)
                    CapturedChess.append("K " + (1-nubK) + "\n");
                if (nubQ !=1)
                    CapturedChess.append("Q " + (1-nubQ) + "\n");
                if (nubR !=2)
                    CapturedChess.append("R " + (2-nubR) + "\n");
                if (nubB !=2 )
                    CapturedChess.append("B " + (2-nubB) + "\n");
                if (nubN !=2 )
                    CapturedChess.append("N " + (2-nubN) + "\n");
                if (nubP !=8 )
                    CapturedChess.append("P " + (8-nubP) + "\n");
        } else {
             for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                     switch (getChess(i, j).name) {
                         case 'k':
                             nubk++;
                             break;
                         case 'q':
                             nubq++;
                             break;
                         case 'r':
                             nubr++;
                             break;
                         case 'b':
                             nubb++;
                             break;
                         case 'n':
                             nubn++;
                             break;
                         case 'p':
                             nubp++;
                             break;
                     }
                 }
             }
                if (nubk !=1)
                    CapturedChess.append("k " + (1-nubk) + "\n");
                if (nubq !=1)
                    CapturedChess.append("q " + (1-nubq) + "\n");
                if (nubr !=2)
                    CapturedChess.append("r " + (2-nubr) + "\n");
                if (nubb !=2)
                    CapturedChess.append("b " + (2-nubb) + "\n");
                if (nubn !=2)
                    CapturedChess.append("n " + (2-nubn) + "\n");
                if (nubp !=8 )
                    CapturedChess.append("p " + (8-nubp) + "\n");


            }
        return  CapturedChess.toString();
    }
        @Override
        public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source){

            ChessComponent chess = this.getChess(source.getX(), source.getY());

            return chess.canMoveTo();
        }

        @Override
        public boolean moveChess ( int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX>7||sourceY>7||targetY>7||targetX>7){
            return false;
        }
            ChessComponent a = chessComponents[sourceX][sourceY];
            ChessboardPoint b = chessComponents[targetX][targetY].getSource();
            if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
                return false;
            }
            if (chessComponents[sourceX][sourceY].ableToMove(chessComponents[targetX][targetY])) {
                chessComponents[targetX][targetY] = a;
                a.setSource(b);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent( chessComponents[sourceX][sourceY].getSource(),ChessColor.NONE);
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                }else {
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }else {
                return false;
            }
        }
    }
