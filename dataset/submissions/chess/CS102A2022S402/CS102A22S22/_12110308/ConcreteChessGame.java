import java.util.List;
import java.util.ArrayList;

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
    ChessColor getChessColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='B'&&component<='R')?ChessColor.BLACK:ChessColor.WHITE);
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char component = chessboard.get(i).charAt(j);
                switch (component) {
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
                        break;
                    default:
                }
            }
        }
        currentPlayer = chessboard.get(8).charAt(0) == 'w' ? ChessColor.WHITE : ChessColor.BLACK;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            if (i < 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] cnt = new int[128];
        int[] characters = new int[]{'K', 'Q', 'R', 'B', 'N', 'P'};
        int[] numbers = new int[]{1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((player == ChessColor.BLACK && chessComponents[i][j].toString().charAt(0) <= 'R' && chessComponents[i][j].toString().charAt(0) >= 'B') || (player == ChessColor.WHITE && chessComponents[i][j].toString().charAt(0) <= 'r' && chessComponents[i][j].toString().charAt(0) >= 'b')) {
                    cnt[chessComponents[i][j].toString().charAt(0) - (player == ChessColor.WHITE ? 32 : 0)]++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (cnt[characters[i]] < numbers[i]) {
                sb.append((char) (characters[i] + (player == ChessColor.WHITE ? 32 : 0)));
                sb.append(" ");
                sb.append(numbers[i] - cnt[characters[i]]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
         chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        if(currentPlayer!=getChessColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        ArrayList<ChessboardPoint> canMovePoints = (ArrayList<ChessboardPoint>) chessComponents[sourceX][sourceY].canMoveTo();
        if (!canMovePoints.contains(new ChessboardPoint(targetX, targetY))) {
            return false;
        }
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
        currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
        return true;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> canMovePoints = (ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = i + 1; j < canMovePoints.size(); j++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(j).getX() || (canMovePoints.get(i).getX() == canMovePoints.get(j).getX() && canMovePoints.get(i).getY() > canMovePoints.get(j).getY())) {
                    ChessboardPoint tmp = new ChessboardPoint(canMovePoints.get(j).getX(), canMovePoints.get(j).getY());
                    canMovePoints.remove(j);
                    canMovePoints.add(i, tmp);
                }
            }
        }
        return canMovePoints;
    }


}
