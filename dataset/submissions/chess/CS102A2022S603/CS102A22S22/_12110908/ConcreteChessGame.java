
import java.lang.reflect.Array;
import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(i, j);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(i, j);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].chessboard = this.chessComponents;
            }
        }
        if (chessboard.get(8).charAt(0)=='w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        ArrayList<String> chessboard = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("R");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("N");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("B");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("Q");
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("K");
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    row.append("P");
                }
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("r");
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("n");
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("b");
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("q");
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("k");
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    row.append("p");
                }
                if (chessComponents[i][j] instanceof EmptySlotComponent) {
                    row.append("_");
                }
            }
            chessboard.add(String.valueOf(row));
        }
        return chessboard.get(0) + "\n" + chessboard.get(1) + "\n" + chessboard.get(2) + "\n" + chessboard.get(3) + "\n" + chessboard.get(4) + "\n" + chessboard.get(5) + "\n" + chessboard.get(6) + "\n" + chessboard.get(7) + "\n";
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String chessboard = getChessboardGraph();
        chessboard = chessboard.replaceAll("\n", "");
        StringBuilder loss = new StringBuilder();
        if (player == ChessColor.WHITE) {
            int rook = 0, knight = 0, bishop = 0, queen = 0, king = 0, pawn = 0;
            for (int i = 0; i < chessboard.length(); i++) {
                if (chessboard.charAt(i) == 'r') {
                    rook = rook + 1;
                } else if (chessboard.charAt(i) == 'n') {
                    knight = knight + 1;
                } else if (chessboard.charAt(i) == 'b') {
                    bishop = bishop + 1;
                } else if (chessboard.charAt(i) == 'q') {
                    queen = queen + 1;
                } else if (chessboard.charAt(i) == 'k') {
                    king = king + 1;
                } else if (chessboard.charAt(i) == 'p') {
                    pawn = pawn + 1;
                }
            }
            if (king == 0) {
                loss.append("k 1\n");
            }
            if (queen == 0) {
                loss.append("q 1\n");
            }
            if (rook < 2) {
                loss.append("r ").append(2 - rook).append("\n");
            }
            if (bishop < 2) {
                loss.append("b ").append(2 - bishop).append("\n");
            }
            if (knight < 2) {
                loss.append("n ").append(2 - knight).append("\n");
            }
            if (pawn < 8) {
                loss.append("p ").append(8 - pawn).append("\n");
            }
        } else {
            int rook = 0, knight = 0, bishop = 0, queen = 0, king = 0, pawn = 0;
            for (int i = 0; i < chessboard.length(); i++) {
                if (chessboard.charAt(i) == 'R') {
                    rook = rook + 1;
                } else if (chessboard.charAt(i) == 'N') {
                    knight = knight + 1;
                } else if (chessboard.charAt(i) == 'B') {
                    bishop = bishop + 1;
                } else if (chessboard.charAt(i) == 'Q') {
                    queen = queen + 1;
                } else if (chessboard.charAt(i) == 'K') {
                    king = king + 1;
                } else if (chessboard.charAt(i) == 'P') {
                    pawn = pawn + 1;
                }
            }
            if (king == 0) {
                loss.append("K 1\n");
            }
            if (queen == 0) {
                loss.append("Q 1\n");
            }
            if (rook < 2) {
                loss.append("R ").append(2 - rook).append("\n");
            }
            if (bishop < 2) {
                loss.append("B ").append(2 - bishop).append("\n");
            }
            if (knight < 2) {
                loss.append("N ").append(2 - knight).append("\n");
            }
            if (pawn < 8) {
                loss.append("P ").append(8 - pawn).append("\n");
            }
        }
        return String.valueOf(loss);
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(new sort());
        return canMovePoints;
    }

    private static class sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            if (o1.getX() > o2.getX()) {
                return 1;
            }
            if (o1.getX() < o2.getX()) {
                return -1;
            } else {
                if (o1.getY() > o2.getY()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        if (chess.getChessColor()==this.getCurrentPlayer()) {
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            for (ChessboardPoint canMovePoint : canMovePoints) {
                if (canMovePoint.getX() == targetX && canMovePoint.getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(targetX,targetY);
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                    if (currentPlayer==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }else if (currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}