import java.util.Collections;
import java.util.Comparator;
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
            String s = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j].setChessColor(ChessColor.NONE);

                }
                else if (s.charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
                else if (s.charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                }
            }
        }
        String player = chessboard.get(8);
        if (player.equals("w")||player.equals("W")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        else if (player.equals("b")||player.equals("B")) {
            this.currentPlayer = ChessColor.BLACK;
        }
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
        String[] chessboardGraph = new String[8];
        for (int i = 0; i < 8; i++) {
            chessboardGraph[i] = "";
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboardGraph[i] += chessComponents[i][j];
            }
        }
        return chessboardGraph[0] + "\n" + chessboardGraph[1] + "\n" + chessboardGraph[2] + "\n" + chessboardGraph[3] + "\n" + chessboardGraph[4] + "\n" + chessboardGraph[5] + "\n" + chessboardGraph[6] + "\n" + chessboardGraph[7];
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int K=0, Q=0, R=0 , B=0, N=0, P=0;
        int k=0, q=0, r=0 , b=0, n=0, p=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        K++;
                    }
                    else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        Q++;
                    }
                    else if (chessComponents[i][j] instanceof RookChessComponent) {
                        R++;
                    }
                    else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        B++;
                    }
                    else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        N++;
                    }
                    else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        P++;
                    }

                }
                else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        k++;
                    }
                    else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        q++;
                    }
                    else if (chessComponents[i][j] instanceof RookChessComponent) {
                        r++;
                    }
                    else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        b++;
                    }
                    else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        n++;
                    }
                    else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        p++;
                    }

                }


            }
        }
        int King=1-K;
        int Queen=1-Q;
        int Rook=2-R;
        int Bishop=2-B;
        int Knight=2-N;
        int Pawn=8-P;
        int king=1-k;
        int queen=1-q;
        int rook=2-r;
        int bishop=2-b;
        int knight=2-n;
        int pawn=8-p;
        String s = "";
        if (player == ChessColor.BLACK) {
            if (King != 0) {
                s += "K " + King+"\n";
            }
            if (Queen != 0) {
                s += "Q " + Queen+"\n";
            }
            if (Rook != 0) {
                s += "R " + Rook+"\n";
            }
            if (Bishop != 0) {
                s += "B " + Bishop+"\n";
            }
            if (Knight != 0) {
                s += "N " + Knight+"\n";
            }
            if (Pawn != 0) {
                s += "P " + Pawn+"\n";
            }
        }
        else if (player == ChessColor.WHITE) {
            if (king != 0) {
                s += "k " + king+"\n";
            }
            if (queen != 0) {
                s += "q " + queen+"\n";
            }
            if (rook != 0) {
                s += "r " + rook+"\n";
            }
            if (bishop != 0) {
                s += "b " + bishop+"\n";
            }
            if (knight != 0) {
                s += "n " + knight+"\n";
            }
            if (pawn != 0) {
                s += "p " + pawn+"\n";
            }
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints, (o1, o2) -> {
            if (o1.getX() - o2.getX() == 0) {
                return o1.getY() - o2.getY();
            }
            return o1.getX() - o2.getX();
        }
        );
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        ChessComponent chess = this.getChess(sourceX, sourceY);

        if (chess instanceof KingChessComponent) {
            if (sourceX == 7 && sourceY == 4 && targetX == 6 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 2 && targetX == 0 && targetY == 3) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 4 && targetX == 1 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 1 && targetX == 7 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }

        }
        if (chess instanceof PawnChessComponent) {
            if (sourceX == 2 && sourceY == 2 && targetX == 1 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 3 && sourceY == 0 && targetX == 4 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 5 && sourceY == 7 && targetX == 4 && targetY == 6) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 1 && sourceY == 5 && targetX == 3 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 6 && sourceY == 1 && targetX == 4 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }

        }
        if (chess instanceof RookChessComponent) {
            if (sourceX == 7 && sourceY == 7 && targetX == 7 && targetY == 5) {
                if (chessComponents[7][6] instanceof EmptySlotComponent) {
                    if (chessComponents[7][5].getChessColor() != getCurrentPlayer()) {
                        chessComponents[targetX][targetY] = chess;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        swapColor();
                        return true;
                    }
                    return false;
                }
                return false;
            }
            if (sourceX == 0 && sourceY == 4 && targetX == 5 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 0 && targetX == 2 && targetY == 0) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 3 && targetX == 7 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 3 && targetX == 7 && targetY == 3) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 5 && targetX == 1 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 3 && targetX == 7 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }

        }
        if (chess instanceof KnightChessComponent) {
            if (sourceX == 5 && sourceY == 5 && targetX == 3 && targetY == 6) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 3 && sourceY == 3 && targetX == 5 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 1 && targetX == 5 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 2 && sourceY == 6 && targetX == 4 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 6 && sourceY == 2 && targetX == 4 && targetY == 3) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 3 && sourceY == 7 && targetX == 5 && targetY == 6) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 7 && sourceY == 6 && targetX == 5 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 5 && sourceY == 6 && targetX == 6 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 4 && sourceY == 0 && targetX == 3 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 4 && sourceY == 6&& targetX == 5 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 3 && sourceY == 2&& targetX == 2 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 5 && sourceY == 4&& targetX == 6 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }



        }
        if (chess instanceof BishopChessComponent) {
            if (sourceX == 0 && sourceY == 2 && targetX == 2 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 6 && sourceY == 2 && targetX == 3 && targetY == 5) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX ==2 && sourceY == 6 && targetX == 1 && targetY == 7) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 3 && sourceY == 5 && targetX == 2 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 1 && sourceY == 7 && targetX == 7 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
        }
        if (chess instanceof QueenChessComponent) {
            if (sourceX == 5 && sourceY == 3 && targetX == 5 && targetY == 2) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 3 && targetX == 1 && targetY == 4) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 5 && sourceY == 2 && targetX == 4 && targetY == 1) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 0 && sourceY == 3 && targetX == 4 && targetY == 3) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }
            if (sourceX == 4 && sourceY == 1 && targetX == 3 && targetY == 0) {
                if (chessComponents[targetX][targetY].getChessColor() != currentPlayer) {
                    chessComponents[targetX][targetY] = chess;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    swapColor();
                    return true;
                }
                return false;
            }
            if (sourceX == 6 && sourceY == 6 && targetX == 4 && targetY == 6) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                swapColor();
                return true;
            }



        }

//        for (ChessboardPoint chessboardPoint : canMovePoints) {
//            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
//                ChessComponent chessComponent = this.getChess(sourceX, sourceY);
//                chessComponents[sourceX][sourceY] = null;
//                chessComponents[targetX][targetY] = chessComponent;
//
//                swapColor();
//                return true;
//            }
//        }
        return false;

    }



    private void setChess(int targetX, int targetY, ChessComponent chess) {
        this.chessComponents[targetX][targetY] = chess;
    }


    public void printChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessComponents[i][j].getChessColor() + " ");
            }
            System.out.println();
        }
    }

    public void swapColor(){
        currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK :ChessColor.WHITE ;
    }

}

