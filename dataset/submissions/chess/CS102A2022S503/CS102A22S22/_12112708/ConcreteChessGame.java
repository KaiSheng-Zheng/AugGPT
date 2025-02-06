import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    private ChessColor getCurrentColor(char component) {
        if (component == 'B' || component == 'K' || component == 'N' || component == 'P' || component == 'Q' || component == 'R') {
            return ChessColor.BLACK;
        }
        if (component == 'b' || component == 'k' || component == 'n' || component == 'p' || component == 'q' || component == 'r') {
            return ChessColor.WHITE;
        } else return ChessColor.NONE;

    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j));
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].toString());
            }
            result.append("\n");
        }
        for (int k = 0; k < 8; k++) {
            result.append(chessComponents[7][k].toString());
        }
        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int numberR = 0, numberN = 0, numberB = 0, numberQ = 0, numberK = 0, numberP = 0,
                numberr = 0, numbern = 0, numberb = 0, numberq = 0, numberk = 0, numberp = 0;
        for (int i = 0; i < getChessboardGraph().length(); i++) {
            if (getChessboardGraph().charAt(i) == 'R') {
                numberR++;
            }
            if (getChessboardGraph().charAt(i) == 'N') {
                numberN++;
            }
            if (getChessboardGraph().charAt(i) == 'B') {
                numberB++;
            }
            if (getChessboardGraph().charAt(i) == 'Q') {
                numberQ++;
            }
            if (getChessboardGraph().charAt(i) == 'K') {
                numberK++;
            }
            if (getChessboardGraph().charAt(i) == 'P') {
                numberP++;
            }
            if (getChessboardGraph().charAt(i) == 'r') {
                numberr++;
            }
            if (getChessboardGraph().charAt(i) == 'n') {
                numbern++;
            }
            if (getChessboardGraph().charAt(i) == 'b') {
                numberb++;
            }
            if (getChessboardGraph().charAt(i) == 'q') {
                numberq++;
            }
            if (getChessboardGraph().charAt(i) == 'k') {
                numberk++;
            }
            if (getChessboardGraph().charAt(i) == 'p') {
                numberp++;
            }
        }
        if (player == ChessColor.BLACK) {
            String output = "";
            if (numberK != 1) {
                output = "K " + (1 - numberK);
            }
            if (numberQ != 1) {
                output = output + "\n" + "Q " + (1 - numberQ);
            }
            if (numberR != 2) {
                output = output + "\n" + "R " + (2 - numberR);
            }
            if (numberB != 2) {
                output = output + "\n" + "B " + (2 - numberB);
            }
            if (numberN != 2) {
                output = output + "\n" + "N " + (2 - numberN);
            }
            if (numberP != 8) {
                output = output + "\n" + "P " + (8 - numberP);
            }
            return output;
        }
        if (player == ChessColor.WHITE) {
            String output = "";
            if (numberk != 1) {
                output = "k " + (1 - numberk);
            }
            if (numberq != 1) {
                output = output + "\n" + "q " + (1 - numberq);
            }
            if (numberr != 2) {
                output = output + "\n" + "r " + (2 - numberr);
            }
            if (numberb != 2) {
                output = output + "\n" + "b " + (2 - numberb);
            }
            if (numbern != 2) {
                output = output + "\n" + "n " + (2 - numbern);
            }
            if (numberp != 8) {
                output = output + "\n" + "p " + (8 - numberp);
            }
            return output;
        } else return null;
    }

    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint a, ChessboardPoint b) {
            if (a.getX() == b.getX()) {
                return a.getY() - b.getY();
            } else return a.getX() - b.getX();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        chessComponents[x][y].LoadChessboard(chessComponents);
        ArrayList<ChessboardPoint> canMoveTo = (ArrayList<ChessboardPoint>) chessComponents[x][y].canMoveTo();
        canMoveTo.sort(new Sort());
        return canMoveTo;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer == getCurrentColor(chessComponents[sourceX][sourceY].toString().charAt(0))) {
            chessComponents[sourceX][sourceY].LoadChessboard(chessComponents);
            List<ChessboardPoint> canMoveTo = chessComponents[sourceX][sourceY].canMoveTo();
            for (ChessboardPoint chessboardPoint : canMoveTo) {
                if (chessboardPoint.getX()==targetX &&chessboardPoint.getY()==targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].source1 = new ChessboardPoint(targetX, targetY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(sourceX, sourceY));
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }
                    else if (currentPlayer==ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;}
                    return true;
                }
            }
        }
            return false;
        }

    }