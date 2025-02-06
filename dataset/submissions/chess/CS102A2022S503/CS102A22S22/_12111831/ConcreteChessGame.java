import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'R');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'N');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'B');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'Q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'K');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents, 'P');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'r');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'n');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'b');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'q');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'k');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents, 'p');
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent();
                }
            }
        }

        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
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
        StringBuilder[] chessboardParts = new StringBuilder[8];
        String outcome = new String();
        for (int i = 0; i < 8; i++) {
            chessboardParts[i] = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        chessboardParts[i].append("R");
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        chessboardParts[i].append("N");
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        chessboardParts[i].append("B");
                    } else if (chessComponents[i][j] instanceof KingChessComponent) {
                        chessboardParts[i].append("K");
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        chessboardParts[i].append("Q");
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        chessboardParts[i].append("P");
                    }
                } else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        chessboardParts[i].append("r");
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        chessboardParts[i].append("n");
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        chessboardParts[i].append("b");
                    } else if (chessComponents[i][j] instanceof KingChessComponent) {
                        chessboardParts[i].append("k");
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        chessboardParts[i].append("q");
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        chessboardParts[i].append("p");
                    }
                } else {
                    chessboardParts[i].append("_");
                }
            }

            outcome = outcome.concat(String.valueOf(chessboardParts[i]) + '\n');

        }

        return outcome;

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] chessNum = new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    if (chessComponents[i][j] instanceof RookChessComponent) {
                        chessNum[2]++;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        chessNum[4]++;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        chessNum[3]++;
                    } else if (chessComponents[i][j] instanceof KingChessComponent) {
                        chessNum[0]++;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        chessNum[1]++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        chessNum[5]++;
                    }
                }
            }
        }

        String outcome = new String();

        if (player == ChessColor.BLACK) {
            if (chessNum[0] != 1) {
                outcome = outcome.concat(String.format("K %d\n", 1 - chessNum[0]));
            }
            if (chessNum[1] != 1) {
                outcome = outcome.concat(String.format("Q %d\n", 1 - chessNum[1]));
            }
            if (chessNum[2] != 2) {
                outcome = outcome.concat(String.format("R %d\n", 2 - chessNum[2]));
            }
            if (chessNum[3] != 2) {
                outcome = outcome.concat(String.format("B %d\n", 2 - chessNum[3]));
            }
            if (chessNum[4] != 2) {
                outcome = outcome.concat(String.format("N %d\n", 2 - chessNum[4]));
            }
            if (chessNum[5] != 8) {
                outcome = outcome.concat(String.format("P %d\n", 8 - chessNum[5]));
            }
        } else if (player == ChessColor.WHITE) {
            if (chessNum[0] != 1) {
                outcome = outcome.concat(String.format("k %d\n", 1 - chessNum[0]));
            }
            if (chessNum[1] != 1) {
                outcome = outcome.concat(String.format("q %d\n", 1 - chessNum[1]));
            }
            if (chessNum[2] != 2) {
                outcome = outcome.concat(String.format("r %d\n", 2 - chessNum[2]));
            }
            if (chessNum[3] != 2) {
                outcome = outcome.concat(String.format("b %d\n", 2 - chessNum[3]));
            }
            if (chessNum[4] != 2) {
                outcome = outcome.concat(String.format("n %d\n", 2 - chessNum[4]));
            }
            if (chessNum[5] != 8) {
                outcome = outcome.concat(String.format("p %d\n", 8 - chessNum[5]));
            }
        }

        return outcome;

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean outcome = false;
        for (ChessboardPoint chessboardPoint : chessComponents[sourceX][sourceY].canMoveTo()) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                outcome = true;
            }
        }
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            outcome = false;
        }

        if (outcome) {
            //move the CHESS
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();


            //switch player
            if (currentPlayer == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            } else if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            }
        }
        return outcome;
    }
}
