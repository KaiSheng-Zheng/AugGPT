import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 9; i++) {
            if (i != 8) {
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 'k') {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'K') {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'q') {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'Q') {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'r') {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'R') {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'b') {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'B') {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'n') {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'N') {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'p') {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == 'P') {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }
                    if (chessboard.get(i).charAt(j) == '_') {
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                    }

                }

            } else {
                if (chessboard.get(i).charAt(0) == 'w')
                    currentPlayer = ChessColor.WHITE;
                if (chessboard.get(i).charAt(0) == 'b')
                    currentPlayer = ChessColor.BLACK;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {

        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof EmptySlotComponent) {
                    board.append("_");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("b");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("B");
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("k");
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("K");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("n");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("N");
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("p");
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("P");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("q");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("Q");
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    board.append("r");
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    board.append("R");
                }
            }
            board.append("\n");
        }
        return board.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int king = 1;
        int queen = 1;
        int rook = 2;
        int knight = 2;
        int bishop = 2;
        int pawn = 8;
        int newK = 0;
        int newQ = 0;
        int newR = 0;
        int newN = 0;
        int newB = 0;
        int newP = 0;
        String chessboard = getChessboardGraph();
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < chessboard.length(); i++) {
                if (chessboard.charAt(i) == 'k') {
                    newK++;
                }
                if (chessboard.charAt(i) == 'q') {
                    newQ++;
                }
                if (chessboard.charAt(i) == 'b') {
                    newB++;
                }
                if (chessboard.charAt(i) == 'n') {
                    newN++;
                }
                if (chessboard.charAt(i) == 'p') {
                    newP++;
                }
                if (chessboard.charAt(i) == 'r') {
                    newR++;
                }
            }
            int getCapturedK = king - newK;
            int getCapturedQ = queen - newQ;
            int getCapturedN = knight - newN;
            int getCapturedR = rook - newR;
            int getCapturedB = bishop - newB;
            int getCapturedP = pawn - newP;


            if (getCapturedK != 0) {
                str.append("k ");
                str.append(getCapturedK);
                str.append("\n");
            }
            if (getCapturedQ != 0) {
                str.append("q ");
                str.append(getCapturedQ);
                str.append("\n");
            }
            if (getCapturedR != 0) {
                str.append("r ");
                str.append(getCapturedR);
                str.append("\n");
            }
            if (getCapturedB != 0) {
                str.append("b ");
                str.append(getCapturedB);
                str.append("\n");
            }
            if (getCapturedN != 0) {
                str.append("n ");
                str.append(getCapturedN);
                str.append("\n");
            }
            if (getCapturedP != 0) {
                str.append("p ");
                str.append(getCapturedP);
                str.append("\n");
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < chessboard.length(); i++) {
                if (chessboard.charAt(i) == 'K') {
                    newK++;
                }
                if (chessboard.charAt(i) == 'Q') {
                    newQ++;
                }
                if (chessboard.charAt(i) == 'B') {
                    newB++;
                }
                if (chessboard.charAt(i) == 'N') {
                    newN++;
                }
                if (chessboard.charAt(i) == 'P') {
                    newP++;
                }
                if (chessboard.charAt(i) == 'R') {
                    newR++;
                }
            }
            int getCapturedK = king - newK;
            int getCapturedQ = queen - newQ;
            int getCapturedN = knight - newN;
            int getCapturedR = rook - newR;
            int getCapturedB = bishop - newB;
            int getCapturedP = pawn - newP;


            if (getCapturedK != 0) {
                str.append("K");
                str.append(" ");
                str.append(getCapturedK);
                str.append("\n");
            }
            if (getCapturedQ != 0) {
                str.append("Q");
                str.append(" ");
                str.append(getCapturedQ);
                str.append("\n");
            }
            if (getCapturedR != 0) {
                str.append("R");
                str.append(" ");
                str.append(getCapturedR);
                str.append("\n");
            }
            if (getCapturedB != 0) {
                str.append("B");
                str.append(" ");
                str.append(getCapturedB);
                str.append("\n");
            }
            if (getCapturedN != 0) {
                str.append("N");
                str.append(" ");
                str.append(getCapturedN);
                str.append("\n");
            }
            if (getCapturedP != 0) {
                str.append("P");
                str.append(" ");
                str.append(getCapturedP);
                str.append("\n");
            }


        }
        return str.toString();

    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(new Sort());
        return canMovePoints;
    }
    private static class Sort implements Comparator<ChessboardPoint>{
        public int compare(ChessboardPoint destination1, ChessboardPoint destination2){
            if(destination1.getX() == destination2.getX()){
                return destination1.getY() - destination2.getY();
            }else{
                return destination1.getX() - destination2.getX();
            }
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = this.getChess(sourceX, sourceY);
        ArrayList<ChessboardPoint> canMovePoints =(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if(! canMovePoints.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }else {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');

            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }
    }
}