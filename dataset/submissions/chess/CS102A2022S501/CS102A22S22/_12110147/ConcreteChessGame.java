import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void passToConcreteChessGame() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponent(i,j,chessComponents[i][j]);
            }
        }
    }

    public ConcreteChessGame() {
        super();
    }

    public void setCurrentPlayer(ChessColor color) {
        this.currentPlayer = color;
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a.append(chessComponents[i][j].getName());
            }
            a.append('\n');
        }
        return a.toString();
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            setCurrentPlayer(ChessColor.WHITE);
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            setCurrentPlayer(ChessColor.BLACK);
        }
        passToConcreteChessGame();

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int Bn = 0;
        int bn = 0;
        int Kn = 0;
        int kn = 0;
        int Qn = 0;
        int qn = 0;
        int Pn = 0;
        int pn = 0;
        int Nn = 0;
        int nn = 0;
        int Rn = 0;
        int rn = 0;
        for (int j = 0; j < 72 ; j++) {
            switch (getChessboardGraph().charAt(j)) {
                case 'B':
                    Bn++;
                    break;
                case 'b':
                    bn++;
                    break;
                case 'K':
                    Kn++;
                    break;
                case 'k':
                    kn++;
                    break;
                case 'Q':
                    Qn++;
                    break;
                case 'q':
                    qn++;
                    break;
                case 'P':
                    Pn++;
                    break;
                case 'p':
                    pn++;
                    break;
                case 'R':
                    Rn++;
                    break;
                case 'r':
                    rn++;
                    break;
                case 'N':
                    Nn++;
                    break;
                case 'n':
                    nn++;
                    break;

            }
        }
        StringBuilder CapturedChess = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (Kn < 1) {
                CapturedChess.append("K ");
                CapturedChess.append(1-Kn);
                CapturedChess.append('\n');
            }
            if (Qn < 1) {
                CapturedChess.append("Q ");
                CapturedChess.append(1-Qn);
                CapturedChess.append('\n');
            }
            if (Rn < 2) {
                CapturedChess.append("R ");
                CapturedChess.append(2-Rn);
                CapturedChess.append('\n');
            }
            if (Bn < 2) {
                CapturedChess.append("B ");
                CapturedChess.append(2-Bn);
                CapturedChess.append('\n');
            }
            if (Nn < 2) {
                CapturedChess.append("N ");
                CapturedChess.append(2-Nn);
                CapturedChess.append('\n');
            }
            if (Pn < 8) {
                CapturedChess.append("P ");
                CapturedChess.append(8-Pn);
                CapturedChess.append('\n');
            }

        }
        if (player == ChessColor.WHITE) {
            if (kn < 1) {
                CapturedChess.append("k ");
                CapturedChess.append(1-kn);
                CapturedChess.append('\n');
            }
            if (qn < 1) {
                CapturedChess.append("q ");
                CapturedChess.append(1-qn);
                CapturedChess.append('\n');
            }
            if (rn < 2) {
                CapturedChess.append("r ");
                CapturedChess.append(2-rn);
                CapturedChess.append('\n');
            }
            if (bn < 2) {
                CapturedChess.append("b ");
                CapturedChess.append(2-bn);
                CapturedChess.append('\n');
            }
            if (nn < 2) {
                CapturedChess.append("n ");
                CapturedChess.append(2-nn);
                CapturedChess.append('\n');
            }
            if (pn < 8) {
                CapturedChess.append("p ");
                CapturedChess.append(8-pn);
                CapturedChess.append('\n');
            }

        }
        return String.valueOf(CapturedChess);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        if (!(chess2.getName() == '_')) {
            chess2 = new EmptySlotComponent();
        }
        chess1.swapLocation(chess2);
        passToConcreteChessGame();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
    
        if (sourceX >= 0 && sourceX <= 7 && targetX >= 0 && targetY <= 7) {
            
            if (chessComponents[sourceX][sourceY].canMoveTo().size() > 0) {
                
                for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                    if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
                        
                        if (chessComponents[targetX][targetY].getChessColor() != currentPlayer) {
                            
                            if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                                
                                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX) {
                                    
                                    swapChessComponents(chessComponents[sourceX][sourceY], chessComponents[targetX][targetY]);
                                    if (currentPlayer == ChessColor.WHITE) {
                                        currentPlayer = ChessColor.BLACK;
                                    } else {
                                        currentPlayer = ChessColor.WHITE;
                                    }
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


}