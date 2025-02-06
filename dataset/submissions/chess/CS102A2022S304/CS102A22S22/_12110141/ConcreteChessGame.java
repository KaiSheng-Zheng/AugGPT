import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.awt.Color.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'B' || chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'K' || chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'N' || chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'P' || chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'Q' || chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'R' || chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i, j, chessboard.get(i).charAt(j));
                }

                chessComponents[i][j].setChessboard(this.chessComponents);

                if (chessboard.get(8).charAt(0) == 'w') {
                    currentPlayer = ChessColor.WHITE;
                }
                if (chessboard.get(8).charAt(0) == 'b') {
                    currentPlayer = ChessColor.BLACK;
                }

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
        String col = "";
        if (getCurrentPlayer() == ChessColor.BLACK) {
            col = "b";
        }
        if (getCurrentPlayer() == ChessColor.WHITE) {
            col = "w";
        }
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof EmptySlotComponent) {
                    graph.append('_');
                }
//                else
//                    if (chessComponents[i][j].chessColor == ChessColor.WHITE) {
//                    graph.append((char) (chessComponents[i][j].name - 'A' + 'a'));
//                }
                else {
                    graph.append(chessComponents[i][j].toString());
                }
            }
            graph.append("\n");
        }

        return graph.toString();
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int bb = 0, kk = 0, nn = 0, pp = 0, qq = 0, rr = 0;
        int BB = 0, KK = 0, NN = 0, PP = 0, QQ = 0, RR = 0;
        StringBuilder aa = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'B') {
                        BB++;
                    }
                    if (chessComponents[i][j].name == 'K') {
                        KK++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        NN++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        PP++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        QQ++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        RR++;
                    }
                }
            }
            if (1 - KK != 0) {
                aa.append(String.format("%s %d\n", "K", 1 - KK));
            }
            if (1 - QQ != 0) {
                aa.append(String.format("%s %d\n", "Q", 1 - QQ));
            }
            if (2 - RR != 0) {
                aa.append(String.format("%s %d\n", "R", 2 - RR));
            }
            if (2 - BB != 0) {
                aa.append(String.format("%s %d\n", "B", 2 - BB));
            }
            if (2 - NN != 0) {
                aa.append(String.format("%s %d\n", "N", 2 - NN));
            }
            if (8 - PP != 0) {
                aa.append(String.format("%s %d\n", "P", 8 - PP));
            }

        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'b') {
                        bb++;
                    }
                    if (chessComponents[i][j].name == 'k') {
                        kk++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        nn++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        pp++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        qq++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        rr++;
                    }
                }
            }
            if (1 - kk != 0) {
                aa.append(String.format("%s %d\n", "k", 1 - kk));
            }
            if (1 - qq != 0) {
                aa.append(String.format("%s %d\n", "q", 1 - qq));
            }
            if (2 - rr != 0) {
                aa.append(String.format("%s %d\n", "r", 2 - rr));
            }
            if (2 - bb != 0) {
                aa.append(String.format("%s %d\n", "b", 2 - bb));
            }
            if (2 - nn != 0) {
                aa.append(String.format("%s %d\n", "n", 2 - nn));
            }
            if (8 - pp != 0) {
                aa.append(String.format("%s %d\n", "p", 8 - pp));
            }

        }
        return aa.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).chessColor() == currentPlayer) {
            if (include(getChess(sourceX, sourceY).canMoveTo(), targetX, targetY)) {
                getChess(sourceX, sourceY).getSource().setX(targetX);
                getChess(sourceX, sourceY).getSource().setY(targetY);
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }
                chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, '_');
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public boolean include(List<ChessboardPoint> sample, int targetX, int targetY) {
        for (int i = 0; i < sample.size(); i++) {
            if (sample.get(i).getX() == targetX && sample.get(i).getY() == targetY) {
                return true;
            }
        }
        return false;
    }
}

