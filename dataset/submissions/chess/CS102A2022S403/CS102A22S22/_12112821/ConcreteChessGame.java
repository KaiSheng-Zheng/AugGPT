
import java.util.*;


public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String chessTest = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char eachChess = chessTest.charAt(j);
                switch (eachChess) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].name = 'R';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].name = 'r';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].name = 'N';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].name = 'n';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].name = 'B';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].name = 'b';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].name = 'Q';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].name = 'q';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].name = 'K';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].name = 'k';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].name = 'P';
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].name = 'p';
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].name = '_';
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                }
                chessComponents[i][j].setChessComponents(this.chessComponents);
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        // decide which color of player
        if (chessboard.get(8).charAt(0) == 'w') this.currentPlayer = ChessColor.WHITE;
        else this.currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //
    public String getCapturedChess(ChessColor player) {
        // get Player
        char[] order = new char[]{'k', 'q', 'r', 'b', 'n', 'p'};
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                order[i] = Character.toUpperCase(order[i]);
            }
        }
        int[] capturedChessNumber = {1, 1, 2, 2, 2, 8};
        HashMap<Character, Integer> exits = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char chessName = chessComponents[i][j].name;
                if (chessName == '_') continue;
                if (player == ChessColor.BLACK && Character.isUpperCase(chessName)) {
                    exits.merge(chessName, 1, Integer::sum);
                } else if (player == ChessColor.WHITE && Character.isLowerCase(chessName)) {
                    exits.merge(chessName, 1, Integer::sum);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length; i++) {
            int exitsChess = exits.getOrDefault(order[i], 0);
            if (exitsChess != capturedChessNumber[i]) {
                sb.append(order[i]).append(" ").append(capturedChessNumber[i] - exitsChess).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> chessboardPoints = chess.canMoveTo();
        chessboardPoints.sort((o1, o2) -> {
            if (o1.getX() != o2.getX()) {
                return o1.getX() - o2.getX();
            } else {
                return o1.getY() - o2.getY();
            }
        });
        return chessboardPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() != getCurrentPlayer()) {
            return false;
        }
        List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        ChessboardPoint chessboardPointToMove = new ChessboardPoint(targetX, targetY);
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (chessboardPoint.equals(chessboardPointToMove)) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
                if (this.getCurrentPlayer() == ChessColor.BLACK) {
                    this.currentPlayer = ChessColor.WHITE;
                } else {
                    this.currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

}
