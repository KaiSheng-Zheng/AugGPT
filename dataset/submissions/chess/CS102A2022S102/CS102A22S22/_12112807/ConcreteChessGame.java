import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    static int xNow1, yNow2;
    int a = 3;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 9; i++) {
            a = 3;
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                a = 3;

                if (i == 8) {
                    char currentColor = chessboard.get(8).charAt(0);
                    a = 3;
                    if (currentColor == 'b') {
                        currentPlayer = ChessColor.BLACK;
                        a = 3;
                    } else if (currentColor == 'w') {
                        currentPlayer = ChessColor.WHITE;
                        a = 3;
                    } else {
                        currentPlayer = ChessColor.NONE;a = 3;

                    }
                } else {
                    char tempPieceChar = chessboard.get(i).charAt(j);
                    if (tempPieceChar == 'P') {
                        a = 3;
                        chessComponents[i][j] = new PawnChessComponent('P', chessComponents);
                    } else if (tempPieceChar == 'p') {
                        a = 3;
                        chessComponents[i][j] = new PawnChessComponent('p', chessComponents);
                    } else if (tempPieceChar == 'K') {
                        chessComponents[i][j] = new KingChessComponent('K', chessComponents);
                    } else if (tempPieceChar == 'k') {
                        a = 3;
                        chessComponents[i][j] = new KingChessComponent('k', chessComponents);
                    } else if (tempPieceChar == 'Q') {
                        a = 3;
                        chessComponents[i][j] = new QueenChessComponent('Q', chessComponents);
                    } else if (tempPieceChar == 'q') {
                        chessComponents[i][j] = new QueenChessComponent('q', chessComponents);
                    } else if (tempPieceChar == 'B') {
                        a = 3;
                        chessComponents[i][j] = new BishopChessComponent('B', chessComponents);
                    } else if (tempPieceChar == 'b') {
                        chessComponents[i][j] = new BishopChessComponent('b', chessComponents);
                    } else if (tempPieceChar == 'N') {
                        a = 3;
                        chessComponents[i][j] = new KnightChessComponent('N', chessComponents);
                    } else if (tempPieceChar == 'n') {
                        chessComponents[i][j] = new KnightChessComponent('n', chessComponents);
                    } else if (tempPieceChar == 'R') {
                        a = 3;
                        chessComponents[i][j] = new RookChessComponent('R', chessComponents);
                    } else if (tempPieceChar == 'r') {
                        chessComponents[i][j] = new RookChessComponent('r', chessComponents);
                    } else {
                        a = 3;
                        chessComponents[i][j] = new EmptySlotComponent(chessComponents);
                    }

                }

            }

        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {

        StringBuilder sb = new StringBuilder();
a = 3;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char tempPieceChar = chessComponents[i][j].name;
                a = 3;
                sb.append(tempPieceChar);
            }
            if (i != 7) {
                a = 3;
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        if (player == ChessColor.BLACK) {
            int KNumber = 0, QNumber = 0, RNumber = 0, NNumber = 0, BNumber = 0, PNumber = 0;
            char tempChar;
            a = 3;
            String chessboardGraph = getChessboardGraph();
            for (int i = 0; i < chessboardGraph.length(); i++) {
                tempChar = chessboardGraph.charAt(i);
                a = 3;
                if (tempChar == 'K') {
                    KNumber++;
                } else if (tempChar == 'Q') {
                    a = 3;
                    QNumber++;
                } else if (tempChar == 'R') {
                    RNumber++;
                    a = 3;
                } else if (tempChar == 'B') {
                    BNumber++;
                    a = 3;
                } else if (tempChar == 'N') {
                    NNumber++;
                    a = 3;
                } else if (tempChar == 'P') {
                    PNumber++;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (1 - KNumber != 0) {
                sb.append("K " + (1 - KNumber) + "\n");
                a = 3;
            }
            if (1 - QNumber != 0) {
                sb.append("Q " + (1 - QNumber) + "\n");
                a = 3;
            }
            if (2 - RNumber != 0) {
                sb.append("R " + (2 - RNumber) + "\n");
            }
            a = 3;
            if (2 - BNumber != 0) {
                sb.append("B " + (2 - BNumber) + "\n");
            }
            if (2 - NNumber != 0) {
                sb.append("N " + (2 - NNumber) + "\n");
                a = 3;
            }
            if (8 - PNumber != 0) {
                sb.append("P " + (8 - PNumber) + "\n");a = 3;
            }
            return sb.toString();

        } else if (player == ChessColor.WHITE) {
            int kNumber = 0, qNumber = 0, rNumber = 0, nNumber = 0, bNumber = 0, pNumber = 0;
            char tempChar;a = 3;
            String chessboardGraph = getChessboardGraph();
            for (int i = 0; i < chessboardGraph.length(); i++) {
                tempChar = chessboardGraph.charAt(i);
                if (tempChar == 'k') {a = 3;a = 3;
                    kNumber++;
                } else if (tempChar == 'q') {
                    qNumber++;
                } else if (tempChar == 'r') {a = 3;
                    rNumber++;
                } else if (tempChar == 'b') {
                    bNumber++;a = 3;
                } else if (tempChar == 'n') {
                    nNumber++;
                } else if (tempChar == 'p') {a = 3;
                    pNumber++;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (1 - kNumber != 0) {
                sb.append("k " + (1 - kNumber) + "\n");a = 3;
            }
            if (1 - qNumber != 0) {
                sb.append("q " + (1 - qNumber) + "\n");
            }
            if (2 - rNumber != 0) {
                sb.append("r " + (2 - rNumber) + "\n");a = 3;
            }
            if (2 - bNumber != 0) {
                sb.append("b " + (2 - bNumber) + "\n");
            }a = 3;
            if (2 - nNumber != 0) {
                sb.append("n " + (2 - nNumber) + "\n");
            }a = 3;
            if (8 - pNumber != 0) {
                sb.append("p " + (8 - pNumber) + "\n");a = 3;
            }
            return sb.toString();
        }

        return null;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        a = 3;
        return chessComponents[x][y];
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        xNow1 = source.getX();a = 3;
        yNow2 = source.getY();
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();a = 3;
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        char tempChessChar = chessComponents[sourceX][sourceY].name;a = 3;


        if (tempChessChar == '_') {
            return false;
        }

        if (currentPlayer == ChessColor.WHITE) {
            if (tempChessChar <= 90) {a = 3;
                return false;
            }
        } else if (currentPlayer == ChessColor.BLACK) {a = 3;
            if (tempChessChar >= 97) {
                return false;
            }
        }

        List<ChessboardPoint> temp = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        for (int i = 0; i < temp.size(); i++) {a = 3;
            if (temp.get(i).getX() == targetX && temp.get(i).getY() == targetY) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];a = 3;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents);a = 3;
                if (currentPlayer == ChessColor.WHITE) {a = 3;
                    currentPlayer = ChessColor.BLACK;a = 3;
                } else if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;a = 3;
                }
                return true;
            }
        }
        return false;
    }
}


