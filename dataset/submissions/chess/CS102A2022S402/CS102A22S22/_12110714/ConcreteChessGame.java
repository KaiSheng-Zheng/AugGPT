import java.util.Collections;
import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void SwitchPlayer() {
        if (this.currentPlayer == ChessColor.BLACK) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer() == getChess(sourceX, sourceY).getChessColor()) {
            if (contains(getChess(sourceX, sourceY).canMoveTo(), getChess(targetX, targetY).getSource())) {
                getChess(sourceX,sourceY).changeSource(targetX,targetY);
                chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY,'_');
                SwitchPlayer();
                return true;
            } else return false;
        } else return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard) {
        int i, j;
        for (i = 0; i <= 7; i++) {
            for (j = 0; j <= 7; j++) {
                if (chessboard.get(i).charAt(j) == 'p' | chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'r' | chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'n' | chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'b' | chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'q' | chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'k' | chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                    chessComponents[i][j].setChessColor(chessboard.get(i).charAt(j));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(i, j,chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        int i, j;
        for (i = 0; i <= 6; i++) {
            for (j = 0; j <= 7; j++) {
                s.append(chessComponents[i][j]);
            }
            s.append("\n");
        }
        for (j = 0; j <= 7; j++) {
            s.append(chessComponents[7][j]);
        }
        return s.toString();
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        int[] num = {1, 1, 2, 2, 2, 8};
        int i, j;
        if (player == ChessColor.WHITE) {
            for (i = 0; i <= 7; i++) {
                for (j = 0; j <= 7; j++) {
                    if (chessComponents[i][j].toString().equals("k")) {
                        num[0] -= 1;
                    } else if (chessComponents[i][j].toString().equals("q")) {
                        num[1] -= 1;
                    } else if (chessComponents[i][j].toString().equals("r")) {
                        num[2] -= 1;
                    } else if (chessComponents[i][j].toString().equals("b")) {
                        num[3] -= 1;
                    } else if (chessComponents[i][j].toString().equals("n")) {
                        num[4] -= 1;
                    } else if (chessComponents[i][j].toString().equals("p")) {
                        num[5] -= 1;
                    }
                }
            }
        } else if (player == ChessColor.BLACK) {
            for (i = 0; i <= 7; i++) {
                for (j = 0; j <= 7; j++) {
                    if (chessComponents[i][j].toString().equals("K")) {
                        num[0] -= 1;
                    } else if (chessComponents[i][j].toString().equals("Q")) {
                        num[1] -= 1;
                    } else if (chessComponents[i][j].toString().equals("R")) {
                        num[2] -= 1;
                    } else if (chessComponents[i][j].toString().equals("B")) {
                        num[3] -= 1;
                    } else if (chessComponents[i][j].toString().equals("N")) {
                        num[4] -= 1;
                    } else if (chessComponents[i][j].toString().equals("P")) {
                        num[5] -= 1;
                    }
                }

            }
        }
        if (player == ChessColor.WHITE) {
            String[] name = {"k", "q", "r", "b", "n", "p"};
            for (i = 0; i <= 5; i++) {
                if (num[i] != 0) {
                    str.append(name[i] + " " + num[i] + "\n");
                }
            }
        } else if (player == ChessColor.BLACK) {
            String[] name = {"K", "Q", "R", "B", "N", "P"};
            for (i = 0; i <= 5; i++) {
                if (num[i] != 0) {
                    str.append(name[i] + " " + num[i] + "\n");
                }
            }
        }
        return str.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public boolean contains(List<ChessboardPoint> chessboardPointList, ChessboardPoint source) {
        int i;
        for (i = 0; i <chessboardPointList.size(); i++) {
            if (chessboardPointList.get(i).getX()==source.getX()&chessboardPointList.get(i).getY()==source.getY()) {
                return true;
            }
        }
        return false;
}
    }

