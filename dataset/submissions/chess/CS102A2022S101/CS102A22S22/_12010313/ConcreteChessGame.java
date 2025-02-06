import java.util.List;
import java.util.Scanner;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    Scanner sc = new Scanner(System.in);

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setBlackColor();
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setNoneColor();
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setWhiteColor();
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setWhiteColor();
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setWhiteColor();
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setWhiteColor();
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setWhiteColor();
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setWhiteColor();
                }
            }
        }//endFor
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j]);
            }
            graph.append('\n');
        }
        return graph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int kingLost = 1, queenLost = 1, rookLost = 2, bishopLost = 2, knightLost = 2, pawnLost = 8;
        StringBuilder capLost = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == player) {
                    kingLost--;
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == player) {
                    queenLost--;
                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == player) {
                    rookLost--;
                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == player) {
                    bishopLost--;
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == player) {
                    knightLost--;
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == player) {
                    pawnLost--;
                }
            }
        }//forEnd
        if (kingLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("K ");
            } else {
                capLost.append("k ");
            }
            capLost.append(kingLost);
            capLost.append('\n');
        }
        if (queenLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("Q ");
            } else {
                capLost.append("q ");
            }
            capLost.append(queenLost);
            capLost.append('\n');
        }
        if (rookLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("R ");
            } else {
                capLost.append("r ");
            }
            capLost.append(rookLost);
            capLost.append('\n');
        }
        if (bishopLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("B ");
            } else {
                capLost.append("b ");
            }
            capLost.append(bishopLost);
            capLost.append('\n');
        }
        if (knightLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("N ");
            } else {
                capLost.append("n ");
            }
            capLost.append(knightLost);
            capLost.append('\n');
        }
        if (pawnLost != 0) {
            if (player == ChessColor.BLACK) {
                capLost.append("P ");
            } else {
                capLost.append("p ");
            }
            capLost.append(pawnLost);
            capLost.append('\n');
        }
        return capLost.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}