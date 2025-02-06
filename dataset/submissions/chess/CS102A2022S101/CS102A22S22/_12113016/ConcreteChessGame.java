import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
        instanceChessGame = this;
    }

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public static ConcreteChessGame instanceChessGame;

    public ConcreteChessGame getInstanceChessGame() {
        return instanceChessGame;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8; i1++) {
                if (chessboard.get(i).charAt(i1) == 'R') {
                    chessComponents[i][i1] = new RookChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'N') {
                    chessComponents[i][i1] = new KnightChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'B') {
                    chessComponents[i][i1] = new BishopChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'Q') {
                    chessComponents[i][i1] = new QueenChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'K') {
                    chessComponents[i][i1] = new KingChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'P') {
                    chessComponents[i][i1] = new PawnChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.BLACK);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'p') {
                    chessComponents[i][i1] = new PawnChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'r') {
                    chessComponents[i][i1] = new RookChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'n') {
                    chessComponents[i][i1] = new KnightChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'b') {
                    chessComponents[i][i1] = new BishopChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'k') {
                    chessComponents[i][i1] = new KingChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == 'q') {
                    chessComponents[i][i1] = new QueenChessComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.WHITE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }
                if (chessboard.get(i).charAt(i1) == '_') {
                    chessComponents[i][i1] = new EmptySlotComponent();
                    chessComponents[i][i1].setChessColor(ChessColor.NONE);
                    chessComponents[i][i1].setSource(new ChessboardPoint(i, i1));
                    chessComponents[i][i1].setChessboard(chessboard);
                }

            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChesses(chessComponents);
            }
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
        String chessboardGraph = new String();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (int j = 0; j < chessComponents.length; j++) {
                chessboardGraph = chessboardGraph + chessComponent[j].toString();
            }
            chessboardGraph = chessboardGraph + "\n";
        }
        return chessboardGraph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int rookCounter = 0;
        int pawnCounter = 0;
        int knightCounter = 0;
        int bishopCounter = 0;
        int queenCounter = 0;
        int kingCounter = 0;
        String lostChess = new String();

        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents.length; j++) {
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == player) {
                    rookCounter++;
                }
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == player) {
                    pawnCounter++;
                }
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == player) {
                    queenCounter++;
                }
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == player) {
                    kingCounter++;
                }
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == player) {
                    bishopCounter++;
                }
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == player) {
                    knightCounter++;
                }
            }
        }

        if (kingCounter != 1) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + "k 1\n";
            } else {
                lostChess = lostChess + "K 1\n";
            }
        }
        if (queenCounter != 1) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + "q 1\n";
            } else {
                lostChess = lostChess + "Q 1\n";
            }
        }
        if (rookCounter != 2) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + String.format("r %d\n", 2 - rookCounter);
            } else {
                lostChess = lostChess + String.format("R %d\n", 2 - rookCounter);
            }
        }
        if (bishopCounter != 2) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + String.format("b %d\n", 2 - bishopCounter);
            } else {
                lostChess = lostChess + String.format("B %d\n", 2 - bishopCounter);
            }
        }
        if (knightCounter != 2) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + String.format("n %d\n", 2 - knightCounter);
            } else {
                lostChess = lostChess + String.format("N %d\n", 2 - knightCounter);
            }
        }
        if (pawnCounter != 8) {
            if (player == ChessColor.WHITE) {
                lostChess = lostChess + String.format("p %d\n", 8 - pawnCounter);
            } else {
                lostChess = lostChess + String.format("P %d\n", 8 - pawnCounter);
            }
        }
        return lostChess;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> whereCanMove = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(whereCanMove, new coordinateCompare());

        return whereCanMove;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY] instanceof EmptySlotComponent) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        if (sourceX > 7 || sourceX < 0 || sourceY > 7 || sourceY < 0 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        List<ChessboardPoint> canMoveTo = chessComponents[sourceX][sourceY].canMoveTo();
        boolean judge = false;
        for (ChessboardPoint c : canMoveTo) {
            if (c.getX() == targetX && c.getY() == targetY) {
                judge = true;
                break;
            }
        }
        if (judge) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer=ChessColor.WHITE;
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChesses(chessComponents);
                }
            }

            return true;
        }
        return false;
    }
}

class coordinateCompare implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint c1, ChessboardPoint c2) {
        return (c1.getX() * 10000 + c1.getY()) - (c2.getX() * 10000 + c2.getY());
    }

}