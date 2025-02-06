import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        init();
    }

    private void init() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            char[] array = chessboard.get(i).toCharArray();
            for (int j = 0; j < array.length; j++) {
                char point = array[j];
                switch (point) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                        break;
                    default:
                        break;
                }
            }
        }

        currentPlayer = chessboard.get(chessboard.size() - 1).equals("w") ?
                ChessColor.WHITE : ChessColor.BLACK;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i != 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int map(char c) {
        switch (c) {
            case 'K':
            case 'k':
                return 6;
            case 'Q':
            case 'q':
                return 5;
            case 'R':
            case 'r':
                return 4;
            case 'B':
            case 'b':
                return 3;
            case 'N':
            case 'n':
                return 2;
            case 'P':
            case 'p':
                return 1;
            case '_':
                return 0;
            default:
                return -1;
        }
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        Map<Character, Integer> capturedChess = new HashMap<>();
        capturedChess.put('P', 8);
        capturedChess.put('p', 8);
        capturedChess.put('K', 1);
        capturedChess.put('k', 1);
        capturedChess.put('Q', 1);
        capturedChess.put('q', 1);
        capturedChess.put('R', 2);
        capturedChess.put('r', 2);
        capturedChess.put('N', 2);
        capturedChess.put('n', 2);
        capturedChess.put('B', 2);
        capturedChess.put('b', 2);
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                if (!component.getChessColor().equals(ChessColor.NONE)) {
                    capturedChess.merge(component.name, -1, Integer::sum);
                }
            }
        }
        return capturedChess
                .entrySet()
                .stream()
                .filter(e -> player.equals(ChessColor.WHITE) ?
                        Character.isLowerCase(e.getKey()) :
                        Character.isUpperCase(e.getKey()))
                .filter(e -> e.getValue() > 0)
                .sorted((o1, o2) -> -map(o1.getKey()) + map(o2.getKey()))
                .map(e -> String.format("%c %d\n", e.getKey(), e.getValue()))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()]
                .canMoveTo()
                .stream()
                .filter(point -> canMove(source.getX(), source.getY(), point.getX(), point.getY())).sorted((o1, o2) -> o1.getX() != o2.getX() ? o1.getX() - o2.getX() : o1.getY() - o2.getY()).collect(Collectors.toList());
    }

    public boolean canMove(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[targetX][targetY].getChessColor().equals(chessComponents[sourceX][sourceY].getChessColor()))
            return false;
        ChessComponent component = chessComponents[sourceX][sourceY];
        if (!component.canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            return false;
        } else {
            if (component instanceof PawnChessComponent) {
                if (sourceX == targetX) {
                    if (Math.abs(sourceY - targetY) == 1
                            && chessComponents[targetX][targetY].getChessColor().equals(ChessColor.NONE)) {
                        return true;
                    }
                    return Math.abs(sourceY - targetY) == 2
                            && chessComponents[targetX][targetY].getChessColor().equals(ChessColor.NONE)
                            && chessComponents[targetX][(targetY + sourceY) / 2].getChessColor().equals(ChessColor.NONE);
                } else {
                    return false;
                }
            } else if (component instanceof KnightChessComponent
                    || component instanceof KingChessComponent) {
                return true;
            } else {
                int dx = Integer.compare(targetX - sourceX, 0);
                int dy = Integer.compare(targetY - sourceY, 0);
                int x = sourceX + dx;
                int y = sourceY + dy;
                while (x != targetX
                        || y != targetY) {
                    if (!chessComponents[x][y].getChessColor().equals(ChessColor.NONE)) {
                        return false;
                    }
                    x += dx;
                    y += dy;
                }
                return true;
            }
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor()))
            return false;
        if (getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).contains(chessComponents[targetX][targetY].getSource())) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
            return true;
        }
        return false;
    }
}
