import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;

    @Override
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }


    private ChessComponent createChessComponent(int x, int y, char c) {
        ChessboardPoint p = new ChessboardPoint(x, y);
        if (c == '_')
            return new EmptySlotComponent(p, ChessColor.NONE, c);
        ChessColor color;
        if (Character.isUpperCase(c))
            color = ChessColor.BLACK;
        else
            color = ChessColor.WHITE;
        if (c == 'R' || c == 'r')
            return new RookChessComponent(p, color, c);
        if (c == 'N' || c == 'n')
            return new KnightChessComponent(p, color, c);
        if (c == 'B' || c == 'b')
            return new BishopChessComponent(p, color, c);
        if (c == 'Q' || c == 'q')
            return new QueenChessComponent(p, color, c);
        if (c == 'K' || c == 'k')
            return new KingChessComponent(p, color, c);
        if (c == 'P' || c == 'p')
            return new PawnChessComponent(p, color, c);
        System.out.println("ERROR: " + c + " " + color + p);
        return null;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        int row = chessboard.size();
        for (int r = 0; r < row - 1; r++) {
            String str = chessboard.get(r);
            for (int c = 0; c < str.length(); c++) {
                char cs = str.charAt(c);
                chessComponents[r][c] = createChessComponent(r, c, cs);
            }
        }
        char player = chessboard.get(row - 1).charAt(0);
        if (player == 'w')
            this.currentPlayer = ChessColor.WHITE;
        else if (player == 'b')
            this.currentPlayer = ChessColor.BLACK;
        else {
            System.out.println("ERROR: " + "player + " + player);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8)
            return null;
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        int row = chessComponents.length;
        int col = chessComponents[0].length;
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                sb.append(chessComponents[r][c].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int row = chessComponents.length;
        int col = chessComponents[0].length;
        Map<Character, Integer> mapping = new LinkedHashMap<>();
        Map<Character, Integer> now = new LinkedHashMap<>();

        if (player.equals(ChessColor.WHITE)) {
            mapping.put('k', 1);
            mapping.put('q', 1);
            mapping.put('r', 2);
            mapping.put('b', 2);
            mapping.put('n', 2);
            mapping.put('p', 8);

            now.put('k', 0);
            now.put('q', 0);
            now.put('r', 0);
            now.put('b', 0);
            now.put('n', 0);
            now.put('p', 0);
        } else {
            mapping.put('K', 1);
            mapping.put('Q', 1);
            mapping.put('R', 2);
            mapping.put('B', 2);
            mapping.put('N', 2);
            mapping.put('P', 8);

            now.put('K', 0);
            now.put('Q', 0);
            now.put('R', 0);
            now.put('B', 0);
            now.put('N', 0);
            now.put('P', 0);
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                ChessComponent chess = chessComponents[r][c];
                if (!chess.getChessColor().equals(player)) continue;
                char chr = chess.name;
                now.put(chr, now.get(chr) + 1);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (Character c : mapping.keySet()) {
            if (now.get(c).equals(mapping.get(c))) continue;
            sb.append(c);
            sb.append(" ");
            sb.append(mapping.get(c) - now.get(c));
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = chessComponents[x][y];
        chess.setChessGame(this);
//        System.out.println("xxxxx = " + x + " yyyyy = " + y);
//        System.out.println(chessComponents[x][y]);
        List<ChessboardPoint> canMoveList = chess.canMoveTo();

        Collections.sort(canMoveList, (o1, o2) -> {
            if (o1.getX() == o2.getX())
                return o1.getY() - o2.getY();
            return o1.getX() - o2.getX();
        });

        return canMoveList;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer))
            return false;

        List<ChessboardPoint> points = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));

        for(ChessboardPoint p : points) {
            if(p.getX() == targetX && p.getY() == targetY) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                if(currentPlayer.equals(ChessColor.BLACK)) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }
}
