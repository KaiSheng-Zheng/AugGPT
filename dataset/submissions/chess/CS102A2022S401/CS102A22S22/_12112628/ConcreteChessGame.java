import java.util.List;

public class ConcreteChessGame implements ChessGame {
    //ChessComponent[x][y]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        String line;
        char name;
        ChessComponent chessComponent;
        ChessboardPoint point;
        for (int x = 0; x < 8; x++) {
            line = chessboard.get(x);
            for (int y = 0; y < 8; y++) {
                name = line.charAt(y);
                point = new ChessboardPoint(x, y);
                switch (name) {
                    case 'p', 'P':
                        chessComponent = new PawnChessComponent(point, name, chessComponents);
                        break;
                    case 'k', 'K':
                        chessComponent = new KingChessComponent(point, name, chessComponents);
                        break;
                    case 'q', 'Q':
                        chessComponent = new QueenChessComponent(point, name, chessComponents);
                        break;
                    case 'r', 'R':
                        chessComponent = new RookChessComponent(point, name, chessComponents);
                        break;
                    case 'b', 'B':
                        chessComponent = new BishopChessComponent(point, name, chessComponents);
                        break;
                    case 'n', 'N':
                        chessComponent = new KnightChessComponent(point, name, chessComponents);
                        break;
                    default:
                        chessComponent = new EmptySlotComponent(point);
                }
                chessComponents[x][y] = chessComponent;
            }
        }
        char color = chessboard.get(8).charAt(0);
        if (color == 'w')
            currentPlayer = ChessColor.WHITE;
        else
            currentPlayer = ChessColor.BLACK;
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
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                sb.append(chessComponents[x][y].toString());
            }
            if (x != 7)
                sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int pawnCount = 8;
        int rookCount = 2;
        int knightCount = 2;
        int bishopCount = 2;
        int queenCount = 1;
        int kingCount = 1;

        ChessComponent chess;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chess = chessComponents[x][y];
                if (chess.getChessColor() != player)
                    continue;

                if (chess instanceof PawnChessComponent)
                    --pawnCount;
                else if (chess instanceof RookChessComponent)
                    --rookCount;
                else if (chess instanceof KnightChessComponent)
                    --knightCount;
                else if (chess instanceof BishopChessComponent)
                    --bishopCount;
                else if (chess instanceof QueenChessComponent)
                    --queenCount;
                else if (chess instanceof KingChessComponent)
                    --kingCount;
            }
        }


        StringBuilder sb = new StringBuilder();
        if (kingCount > 0)
            sb.append("k ").append(kingCount).append("\n");
        if (queenCount > 0)
            sb.append("q ").append(queenCount).append("\n");
        if (rookCount > 0)
            sb.append("r ").append(rookCount).append("\n");
        if (bishopCount > 0)
            sb.append("b ").append(bishopCount).append("\n");
        if (knightCount > 0)
            sb.append("n ").append(knightCount).append("\n");
        if (pawnCount > 0)
            sb.append("p ").append(pawnCount).append("\n");

        if (player == ChessColor.BLACK)
            return sb.toString().toUpperCase();
        else
            return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!ChessboardPoint.isPositionValid(sourceX, sourceY) ||
                !ChessboardPoint.isPositionValid(targetX, targetY))
            return false;

        ChessComponent chess = getChess(sourceX, sourceY);
        ChessboardPoint newPt = new ChessboardPoint(targetX, targetY);
        if (chess.getChessColor() != currentPlayer || !chess.canMoveTo().contains(newPt))
            return false;
        chessComponents[targetX][targetY] = chess;
        chess.setSource(newPt);
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(
                new ChessboardPoint(sourceX, sourceY));
        currentPlayer = currentPlayer.reverse();
        return true;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> ptList =
                getChess(source.getX(), source.getY()).canMoveTo();

        ptList.sort((o1, o2) -> (o1.getX() - o2.getX()) * 8 + (o1.getY() - o2.getY()));
        return ptList;
    }
}
