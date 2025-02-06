

import java.util.ArrayList;
import java.util.List;

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
                char c = chessboard.get(i).charAt(j);
                switch (c) {
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, i, j);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, i, j);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(i, j);
                        break;
                }
            }
        }
        switch (chessboard.get(8).charAt(0)) {
            case 'w':
                currentPlayer = ChessColor.WHITE;
                break;
            case 'b':
                currentPlayer = ChessColor.BLACK;
                break;
        }
        Chessboard.chessboard = this.chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder ChessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardGraph.append(chessComponents[i][j].getName());
            }
            if (i != 7) {
                ChessboardGraph.append("\n");
            }
        }
        return ChessboardGraph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int numOfKing = 0, numOfQueen = 0, numOfRook = 0, numOfBishop = 0, numOfKnight = 0, numOfPawn = 0;
        StringBuilder capturedChess = new StringBuilder();
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char c = chessComponents[i][j].getName();
                    switch (c) {
                        case 'b':
                            numOfBishop++;
                            break;
                        case 'k':
                            numOfKing++;
                            break;
                        case 'n':
                            numOfKnight++;
                            break;
                        case 'p':
                            numOfPawn++;
                            break;
                        case 'q':
                            numOfQueen++;
                            break;
                        case 'r':
                            numOfRook++;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (1 - numOfKing != 0) {
                capturedChess.append(String.format("k %d\n", 1 - numOfKing));
            }
            if (1 - numOfQueen != 0) {
                capturedChess.append(String.format("q %d\n", 1 - numOfQueen));
            }
            if (2 - numOfRook != 0) {
                capturedChess.append(String.format("r %d\n", 2 - numOfRook));
            }
            if (2 - numOfBishop != 0) {
                capturedChess.append(String.format("b %d\n", 2 - numOfBishop));
            }
            if (2 - numOfKnight != 0) {
                capturedChess.append(String.format("n %d\n", 2 - numOfKnight));
            }
            if (8 - numOfPawn != 0) {
                capturedChess.append(String.format("p %d\n", 8 - numOfPawn));
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char c = chessComponents[i][j].getName();
                    switch (c) {
                        case 'B':
                            numOfBishop++;
                            break;
                        case 'K':
                            numOfKing++;
                            break;
                        case 'N':
                            numOfKnight++;
                            break;
                        case 'P':
                            numOfPawn++;
                            break;
                        case 'Q':
                            numOfQueen++;
                            break;
                        case 'R':
                            numOfRook++;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (1 - numOfKing != 0) {
                capturedChess.append(String.format("K %d\n", 1 - numOfKing));
            }
            if (1 - numOfQueen != 0) {
                capturedChess.append(String.format("Q %d\n", 1 - numOfQueen));
            }
            if (2 - numOfRook != 0) {
                capturedChess.append(String.format("R %d\n", 2 - numOfRook));
            }
            if (2 - numOfBishop != 0) {
                capturedChess.append(String.format("B %d\n", 2 - numOfBishop));
            }
            if (2 - numOfKnight != 0) {
                capturedChess.append(String.format("N %d\n", 2 - numOfKnight));
            }
            if (8 - numOfPawn != 0) {
                capturedChess.append(String.format("P %d\n", 8 - numOfPawn));
            }
        }
        return capturedChess.toString();
    }//get capturedChess end

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (Chessboard.chessboard[sourceX][sourceY].getChessColor() == currentPlayer) {
            List<ChessboardPoint> list = Chessboard.chessboard[sourceX][sourceY].canMoveTo();
            if (list.size() == 0) {
                return false;
            }
            for (ChessboardPoint chessboardPoint : list) {
                if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {

                    Chessboard.chessboard[targetX][targetY] = Chessboard.chessboard[sourceX][sourceY];
                    Chessboard.chessboard[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);
                    Chessboard.chessboard[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    Chessboard.chessboard[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    chessComponents= Chessboard.chessboard;

                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        List<ChessboardPoint> canMovePoints = Chessboard.chessboard[source.getX()][source.getY()].canMoveTo();
        for (int k = 0; k < 100; k++) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(i + 1).getX()) {
                    ChessboardPoint p = canMovePoints.get(i + 1);
                    canMovePoints.set(i + 1, canMovePoints.get(i));
                    canMovePoints.set(i, p);
                } else if (canMovePoints.get(i).getX() == canMovePoints.get(i + 1).getX()) {
                    if (canMovePoints.get(i).getY() > canMovePoints.get(i + 1).getY()) {
                        ChessboardPoint p = canMovePoints.get(i + 1);
                        canMovePoints.set(i + 1, canMovePoints.get(i));
                        canMovePoints.set(i, p);
                    }
                }
            }
        }

        return canMovePoints;
    }
}


