import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    private static ConcreteChessGame instance;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        instance = this;
    }

    public static ConcreteChessGame getInstance() {
        return instance;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < chessboard.size(); i++) {
            char[] chars = chessboard.get(i).toCharArray();
            if (i == 8) {
                if (chars[0] == 'w') {
                    currentPlayer = ChessColor.WHITE;
                } else if (chars[0] == 'b') {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.NONE;
                }
                continue;
            }
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] >= 'A' && chars[j] <= 'Z') {
                    ChessColor chessColor = ChessColor.BLACK;
                    if (chars[j] == 'R') {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'N') {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'B') {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'Q') {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'K') {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'P') {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    }
                } else if (chars[j] >= 'a' && chars[j] <= 'z') {
                    ChessColor chessColor = ChessColor.WHITE;
                    if (chars[j] == 'r') {
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'n') {
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'b') {
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'q') {
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'k') {
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    } else if (chars[j] == 'p') {
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                    }
                } else {
                    ChessColor chessColor = ChessColor.NONE;
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), chessColor, chars[j]);
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String result = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result += chessComponents[i][j];
            }
            if (i < 7) {
                result += "\n";
            }
        }

        return result;
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int King = 1;
        int Queen = 1;
        int Rook = 2;
        int Bishop = 2;
        int Knight = 2;
        int Pawn = 8;

        String result = "";

        String origin = getChessboardGraph();

        if (player == ChessColor.BLACK) {
            if (King - getNum(origin, "K") > 0) {
                result += "K " + (King - getNum(origin, "K")) + "\n";
            }
            if (Queen - getNum(origin, "Q") > 0) {
                result += "Q " + (Queen - getNum(origin, "Q")) + "\n";
            }
            if (Rook - getNum(origin, "R") > 0) {
                result += "R " + (Rook - getNum(origin, "R")) + "\n";
            }
            if (Bishop - getNum(origin, "B") > 0) {
                result += "B " + (Bishop - getNum(origin, "B")) + "\n";
            }
            if (Knight - getNum(origin, "N") > 0) {
                result += "N " + (Knight - getNum(origin, "N")) + "\n";
            }
            if (Pawn - getNum(origin, "P") > 0) {
                result += "P " + (Pawn - getNum(origin, "P")) + "\n";
            }
        } else if (player == ChessColor.WHITE) {
            if (King - getNum(origin, "k") > 0) {
                result += "k " + (King - getNum(origin, "k")) + "\n";
            }
            if (Queen - getNum(origin, "q") > 0) {
                result += "q " + (Queen - getNum(origin, "q")) + "\n";
            }
            if (Rook - getNum(origin, "r") > 0) {
                result += "r " + (Rook - getNum(origin, "r")) + "\n";
            }
            if (Bishop - getNum(origin, "b") > 0) {
                result += "b " + (Bishop - getNum(origin, "b")) + "\n";
            }
            if (Knight - getNum(origin, "n") > 0) {
                result += "n " + (Knight - getNum(origin, "n")) + "\n";
            }
            if (Pawn - getNum(origin, "p") > 0) {
                result += "p " + (Pawn - getNum(origin, "p")) + "\n";
            }
        }
        return result;
    }

    private int getNum(String origin, String targetStr) {
        return origin.length() - origin.replaceAll(targetStr, "").length();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> list = chessComponent.canMoveTo();
        if (list.size() < 1) {
            return list;
        }
        List<ChessboardPoint> result = list.stream().sorted(Comparator.comparing(ChessboardPoint::getX)
                .thenComparing(ChessboardPoint::getY)).collect(Collectors.toList());
        return result;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
        if (chessComponent.getChessColor() != currentPlayer) {
            return false;
        }
        System.out.println(chessComponent.name);
        List<ChessboardPoint> list = getCanMovePoints(chessComponent.getSource());

        if (list.size() < 1) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX() == targetX && list.get(i).getY() == targetY) {
                chessComponent.getSource().setX(targetX);
                chessComponent.getSource().setY(targetY);
                chessComponents[targetX][targetY] = chessComponent;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');

                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }

                return true;
            }
        }
        return false;
    }


}
