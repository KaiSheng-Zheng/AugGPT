import java.util.*;
import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String line = chessboard.get(i);
                if (line.charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (line.charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);

                }
                if (line.charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);

                }
                if (line.charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);

                }
                if (line.charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);

                }
                if (line.charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);

                }
                if (line.charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);

                }
                if (line.charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);

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


    public String getChessboardGraph() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                out.append(chessComponents[i][j].toString());
            }
            out.append("\n");
        }
        return out.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] counter = new int[]{0, 0, 0, 0, 0, 0};
        int[] Number = new int[]{1, 1, 2, 2, 2, 8};
        String[] black = new String[]{"K", "Q", "R", "B", "N", "P"}, white = new String[]{"k", "q", "r", "b", "n", "p"};
        StringBuilder out = new StringBuilder();
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getChessColor() == player) {
                        if (chessComponents[i][j].toString().charAt(0) == 'k') {
                            counter[0]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'q') {
                            counter[1]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'r') {
                            counter[2]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'b') {
                            counter[3]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'n') {
                            counter[4]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'p') {
                            counter[5]++;
                        }
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                if (counter[i] != Number[i]) {
                    out.append(white[i]).append(" ").append(Number[i] - counter[i]).append("\n");
                }
            }
        } else if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getChessColor() == player) {
                        if (chessComponents[i][j].toString().charAt(0) == 'K') {
                            counter[0]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'Q') {
                            counter[1]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'R') {
                            counter[2]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'B') {
                            counter[3]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'N') {
                            counter[4]++;
                        }
                        if (chessComponents[i][j].toString().charAt(0) == 'P') {
                            counter[5]++;
                        }
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                if (counter[i] != Number[i]) {
                    out.append(black[i]).append(" ").append(Number[i] - counter[i]).append("\n");
                }
            }
        }
        return out.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadChessboard(chessComponents);
        ArrayList<ChessboardPoint> canMoveToPoints = (ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        canMoveToPoints.sort(new XYAscending());
        return canMoveToPoints;
    }

    private static class XYAscending implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2) {

            if (o1.getX() == o2.getX()) {
                return o1.getY() - o2.getY();
            } else {
                return o1.getX() - o2.getX();
            }
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint Destination = new ChessboardPoint(targetX, targetY);
        ChessComponent chessComponent=getChess(sourceX,sourceY);
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            if (chessComponents[sourceX][sourceY].canMoveTo().contains(Destination)) {
                chessComponents[targetX][targetY] =chessComponent;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                  if (currentPlayer==ChessColor.BLACK){
                   this.currentPlayer=ChessColor.WHITE;
               }else {
                   this.currentPlayer=ChessColor.BLACK;
               }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
