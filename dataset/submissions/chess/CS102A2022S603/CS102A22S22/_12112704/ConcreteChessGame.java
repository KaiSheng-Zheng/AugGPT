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
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char c = chessboard.get(i).charAt(j);
                ChessComponent chess = null;
                // choose corresponding chess
                if (c == 'r' || c == 'R') {
                    chess = new RookChessComponent(c);
                } else if (c == 'n' || c == 'N') {
                    chess = new KnightChessComponent(c);
                } else if (c == 'b' || c == 'B') {
                    chess = new BishopChessComponent(c);
                } else if (c == 'q' || c == 'Q') {
                    chess = new QueenChessComponent(c);
                } else if (c == 'k' || c == 'K') {
                    chess = new KingChessComponent(c);
                } else if (c == 'p' || c == 'P') {
                    chess = new PawnChessComponent(c);
                } else {
                    chess = new EmptySlotComponent(c);
                }
                // lower case => white, upper case => black
                if (c >= 'a' && c <= 'z') {
                    chess.setChessColor(ChessColor.WHITE);
                } else if (c >= 'A' && c <= 'Z') {
                    chess.setChessColor(ChessColor.BLACK);
                }
                this.chessComponents[i][j] = chess;
                chess.setSource(new ChessboardPoint(i, j));
                chess.setChessComponents(this.chessComponents);
            }
        }
        if (chessboard.get(chessboard.size() - 1).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.chessComponents.length; i++) {
            for (int j = 0; j < this.chessComponents[0].length; j++) {
                sb.append(this.chessComponents[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String chessboardStatus = getChessboardGraph();
        // construct default map
        Map<Character, Integer> defaultMap = new HashMap<>();
        defaultMap.put('k', 1);
        defaultMap.put('K', 1);
        defaultMap.put('q', 1);
        defaultMap.put('Q', 1);
        defaultMap.put('r', 2);
        defaultMap.put('R', 2);
        defaultMap.put('b', 2);
        defaultMap.put('B', 2);
        defaultMap.put('n', 2);
        defaultMap.put('N', 2);
        defaultMap.put('p', 8);
        defaultMap.put('P', 8);
        // get current chess count
        Map<Character, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < chessboardStatus.length(); i++) {
            char key = chessboardStatus.charAt(i);
            if (currentMap.containsKey(key)) {
                int value = currentMap.get(key) + 1;
                currentMap.put(key, value);
            } else {
                currentMap.put(key, 1);
            }
        }
        // get captured chess
        StringBuilder sb = new StringBuilder();
        char[] whiteKey = {'k', 'q', 'r', 'b', 'n', 'p'};
        char[] blackKey = {'K', 'Q', 'R', 'B', 'N', 'P'};
        char[] checkKey = null;
        if (player.equals(ChessColor.WHITE)) {
            checkKey = whiteKey;
        } else {
            checkKey = blackKey;
        }
        for (char key : checkKey) {
            int defaultValue = defaultMap.get(key);
            int currentValue = currentMap.getOrDefault(key, 0);
            int diff = defaultValue - currentValue;
            if (diff != 0) {
                sb.append(key).append(" ").append(diff).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = getChess(x, y);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // sort
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = getChess(sourceX, sourceY);
        List<ChessboardPoint> canMoveTo = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        // check out whether the chess match the current player.
        if (chess.getChessColor() != currentPlayer) {
            return false;
        }
        // can move or not
        boolean canMove = canMoveTo.contains(new ChessboardPoint(targetX, targetY));
        if (canMove) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chess.setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_');
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        List<String> chessboard = new ArrayList<>();
        //              01234567
        chessboard.add("R_BQK__R");// 0
        chessboard.add("PPPP_PPP");// 1
        chessboard.add("__N_P___");// 2
        chessboard.add("___Np___");// 3
        chessboard.add("_B_p____");// 4
        chessboard.add("___q_n__");// 5
        chessboard.add("ppp__ppp");// 6
        chessboard.add("rnb_kb_r");// 7
        chessboard.add("w");

        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(chessboard);
        System.out.println(game.getChessboardGraph());

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("It's " + game.currentPlayer + "'s turn !");
            int x = input.nextInt();
            int y = input.nextInt();
            int xx = input.nextInt();
            int yy = input.nextInt();
            System.out.println(game.moveChess(x, y, xx, yy));
            System.out.println(game.getChessboardGraph());

        }
    }
}
