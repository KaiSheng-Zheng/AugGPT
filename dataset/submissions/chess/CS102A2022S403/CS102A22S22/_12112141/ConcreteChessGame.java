import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    private ChessComponent newChessComponent(int x, int y, char c) {
        ChessboardPoint point = new ChessboardPoint(x, y);
        ChessColor color = null;
        if (c == '_')
            return new EmptySlotComponent(point, ChessColor.NONE);

        if (Character.isUpperCase(c))
            color = ChessColor.BLACK;
        else
            color = ChessColor.WHITE;

        if (c == 'r' || c == 'R')
            return new RookChessComponent(point, color);
        else if (c == 'n' || c == 'N')
            return new KnightChessComponent(point, color);
        else if (c == 'b' || c == 'B')
            return new BishopChessComponent(point, color);
        else if (c == 'q' || c == 'Q')
            return new QueenChessComponent(point, color);
        else if (c == 'p' || c == 'P')
            return new PawnChessComponent(point, color);
        else if(c == 'k' || c == 'K')
            return new KingChessComponent(point, color);
        else {
            System.out.println("fuck c =" + c);
            return null;
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String line = chessboard.get(i);
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                chessComponents[i][j] = newChessComponent(i, j, c);
                chessComponents[i][j].setName(c);
                assert chessComponents[i][j] != null;
            }
        }

        if (chessboard.get(8).charAt(0) == 'w')
            currentPlayer = ChessColor.WHITE;

        if (chessboard.get(8).charAt(0) == 'b')
            currentPlayer = ChessColor.BLACK;

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x >= 0 && x < chessComponents.length && y >= 0 && y < chessComponents[0].length)
            return chessComponents[x][y];
        return null;
    }

    @Override
    public String getChessboardGraph() {
        int row = chessComponents.length;
        int col = chessComponents[0].length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(chessComponents[i][j].toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = null;
        if(player.equals(ChessColor.WHITE)) {
           chars = new char[] {'k', 'q', 'r', 'b', 'n', 'p'} ;
        }
        else if(player.equals(ChessColor.BLACK)) {
            chars = new char[] {'K', 'Q', 'R', 'B', 'N', 'P'} ;
        }
        else {
            System.out.println("error in getCapturedChess");
            return "";
        }
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent c = chessComponents[i][j];
                if(!c.getChessColor().equals(player)) continue;
                map.put(c.name, map.getOrDefault(c.name, 0) + 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer n = map.get(c);
            if (n == null) n = 0;
            if (i >= 0 && i <= 1)
                n = 1 - n;
            if (i >= 2 && i <= 4)
                n = 2 - n;
            if (i == 5)
                n = 8 - n;
            if(n == 0)
                continue;
            sb.append(c);
            sb.append(' ');
            sb.append(n);
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!ChessboardPoint.inChess(sourceX, sourceY))
            return true;
        if (!ChessboardPoint.inChess(targetX, targetY))
            return true;
        ChessComponent c = chessComponents[sourceX][sourceY];

        if (c.name == '-')
            return true;

        if (!c.getChessColor().equals(currentPlayer))
            return true;

        List<ChessboardPoint> list = c.canMoveTo();
        for (ChessboardPoint p : list) {
            if (p.getX() == targetX && p.getY() == targetY)
             if(currentPlayer.equals(ChessColor.WHITE))
                    currentPlayer = ChessColor.BLACK;
                else
                    currentPlayer = ChessColor.WHITE;
            return true;
        }
        return false;
    }
    

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();

        ChessComponent chess = chessComponents[x][y];
        chess.setChessComponents(chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints, (o1, o2) -> {
            if (o1.getX() == o2.getX())
                return o1.getY() - o2.getY();
            return o1.getX() - o2.getX();
        });
        return canMovePoints;
    }

    @Override
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}