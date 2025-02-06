import java.util.ArrayList;
import java.util.List;

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
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.BLACK;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        int j = 0;
        for (String s : chessboard) {
            if (j == 8) {
                switch (s) {
                    case "w":
                        this.currentPlayer = ChessColor.WHITE;
                        break;
                    case "b":
                        this.currentPlayer = ChessColor.BLACK;
                        break;
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    ChessboardPoint currentPoint = new ChessboardPoint(j, i);
                    switch (s.charAt(i)) {
                        case 'R':
                            chessComponents[j][i] = new RookChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case 'N':
                            chessComponents[j][i] = new KnightChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case 'B':
                            chessComponents[j][i] = new BishopChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case 'Q':
                            chessComponents[j][i] = new QueenChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case 'K':
                            chessComponents[j][i] = new KingChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case 'P':
                            chessComponents[j][i] = new PawnChessComponent(chessComponents, currentPoint, ChessColor.BLACK);
                            break;
                        case '_':
                            chessComponents[j][i] = new EmptySlotComponent(chessComponents, currentPoint, ChessColor.NONE);
                            break;
                        case 'r':
                            chessComponents[j][i] = new RookChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                        case 'n':
                            chessComponents[j][i] = new KnightChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                        case 'b':
                            chessComponents[j][i] = new BishopChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                        case 'q':
                            chessComponents[j][i] = new QueenChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                        case 'k':
                            chessComponents[j][i] = new KingChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                        case 'p':
                            chessComponents[j][i] = new PawnChessComponent(chessComponents, currentPoint, ChessColor.WHITE);
                            break;
                    }
                }
            }
            j++;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder currentChessBoard = new StringBuilder();
        for (ChessComponent[] i : chessComponents) {
            for (ChessComponent j : i) {
                currentChessBoard.append(j);
            }
            currentChessBoard.append("\n");
        }
        return currentChessBoard.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[]{1, 1, 2, 2, 2, 8};
        if (player == ChessColor.BLACK) {
            for (ChessComponent[] i : chessComponents) {
                for (ChessComponent j : i) {
                    switch (j.toString()) {
                        case "K":
                            count[0]--;
                            break;
                        case "Q":
                            count[1]--;
                            break;
                        case "R":
                            count[2]--;
                            break;
                        case "B":
                            count[3]--;
                            break;
                        case "N":
                            count[4]--;
                            break;
                        case "P":
                            count[5]--;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (count[0] > 0) sb.append("K ").append(count[0]).append("\n");
            if (count[1] > 0) sb.append("Q ").append(count[1]).append("\n");
            if (count[2] > 0) sb.append("R ").append(count[2]).append("\n");
            if (count[3] > 0) sb.append("B ").append(count[3]).append("\n");
            if (count[4] > 0) sb.append("N ").append(count[4]).append("\n");
            if (count[5] > 0) sb.append("P ").append(count[5]).append("\n");
        } else {
            for (ChessComponent[] i : chessComponents) {
                for (ChessComponent j : i) {
                    switch (j.toString()) {
                        case "k":
                            count[0]--;
                            break;
                        case "q":
                            count[1]--;
                            break;
                        case "r":
                            count[2]--;
                            break;
                        case "b":
                            count[3]--;
                            break;
                        case "n":
                            count[4]--;
                            break;
                        case "p":
                            count[5]--;
                            break;
                    }
                }
            }
            if (count[0] > 0) sb.append("k ").append(count[0]).append("\n");
            if (count[1] > 0) sb.append("q ").append(count[1]).append("\n");
            if (count[2] > 0) sb.append("r ").append(count[2]).append("\n");
            if (count[3] > 0) sb.append("b ").append(count[3]).append("\n");
            if (count[4] > 0) sb.append("n ").append(count[4]).append("\n");
            if (count[5] > 0) sb.append("p ").append(count[5]).append("\n");
        }
        return sb.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints1 = new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
        List<ChessboardPoint> canMovePoints = new ArrayList<>(canMovePoints1.size());
        while (canMovePoints1.size() > 0) {
            int k = 0;
            for (int j = 1; j < canMovePoints1.size(); j++) {
                if (canMovePoints1.get(k).getX() > canMovePoints1.get(j).getX()) k = j;
                else if (canMovePoints1.get(k).getX() == canMovePoints1.get(j).getX() && canMovePoints1.get(k).getY() > canMovePoints1.get(j).getY()) {
                    k = j;
                }
            }
            canMovePoints.add(canMovePoints1.get(k));
            canMovePoints1.remove(k);
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX<8&&sourceX>=0&&sourceY<8&&sourceY>=0&&currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            ArrayList<ChessboardPoint> check = new ArrayList<>(chessComponents[sourceX][sourceY].canMoveTo());
            for (ChessboardPoint x : check) {
                if (x.getX() == targetX && x.getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(this.chessComponents, new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
                    return true;
                }
            }
        }
        return false;
    }
}
