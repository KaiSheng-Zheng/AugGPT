import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessColor first) {
        currentPlayer = first;
    }

    public ConcreteChessGame() {
        this(ChessColor.WHITE);
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String s = chessboard.get(i);
            for (int j = 0; j < s.length(); j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                ChessColor side;

                char c = s.charAt(j);
                if (c > 'Z') {
                    side = ChessColor.WHITE;
                } else {
                    side = ChessColor.BLACK;
                }

                switch (c) {
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(point);
                        break;
                    case 'p':
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(chessComponents, point, side);
                        break;
                    case 'r':
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(chessComponents, point, side);
                        break;
                    case 'n':
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(chessComponents, point, side);
                        break;
                    case 'b':
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(chessComponents, point, side);
                        break;
                    case 'q':
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(chessComponents, point, side);
                        break;
                    case 'k':
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(chessComponents, point, side);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown chess type:" + c);
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
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                sb.append(component);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder sb = new StringBuilder();
        long num;
        List<ChessComponent> pieces = new ArrayList<>();
        for (ChessComponent[] chessComponent : chessComponents) {
            pieces.addAll(Arrays.asList(chessComponent));
        }

        num = 1 - pieces.stream().filter(x -> x instanceof KingChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'K' : 'k')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        num = 1 - pieces.stream().filter(x -> x instanceof QueenChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'Q' : 'q')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        num = 2 - pieces.stream().filter(x -> x instanceof RookChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'R' : 'r')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        num = 2 - pieces.stream().filter(x -> x instanceof BishopChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'B' : 'b')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        num = 2 - pieces.stream().filter(x -> x instanceof KnightChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'N' : 'n')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        num = 8 - pieces.stream().filter(x -> x instanceof PawnChessComponent && x.getChessColor() == player).count();
        if (num != 0) {
            sb.append(player == ChessColor.BLACK? 'P' : 'p')
                    .append(' ')
                    .append(num)
                    .append('\n');
        }

        return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent component = chessComponents[sourceX][sourceY];
        if (component.getChessColor() != currentPlayer) {
            return false;
        }

        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        if (!component.canMoveTo().contains(target)) {
            return false;
        }

        chessComponents[targetX][targetY] = component;
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
        component.setSource(target);

        if (currentPlayer == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }

        return true;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo().stream().sorted().collect(Collectors.toList());
    }
}