import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // variables
    private ChessComponent[][] chessComponents;
    private ChessColor beginPlayer;
    private ChessColor currentPlayer;
    private static List<String> chessboard = new ArrayList<>();

    // constructor
    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    // setters and getters
    public void setBeginPlayer(ChessColor beginPlayer) {
        this.beginPlayer = beginPlayer;
    }

    public ChessColor getBeginPlayer() {
        return beginPlayer;
    }

    public void setCurrentPlayer(ChessColor cPlayer) {
        this.currentPlayer = cPlayer;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder chessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboardGraph.append(chessComponents[i][j].name);
            }
            if (i != 7) {
                chessboardGraph.append("\n");
            }
        }
        return chessboardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character, Integer> chess = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!chess.containsKey(getChess(i, j).name)) {
                    chess.put(getChess(i, j).name, 1);
                } else {
                    chess.replace(getChess(i, j).name, chess.get(getChess(i, j).name) + 1);
                }
            }
        }
        StringBuilder captured = new StringBuilder();
        if (player.equals(ChessColor.WHITE)) {
            if (!chess.containsKey('k')) {
                captured.append("k 1\n");
            }
            if (!chess.containsKey('q')) {
                captured.append("q 1\n");
            }
            if (!chess.containsKey('r')) {
                captured.append("r 2\n");
            } else if (chess.get('r') != 2) {
                captured.append("r ");
                captured.append(2 - chess.get('r'));
                captured.append("\n");
            }
            if (!chess.containsKey('b')) {
                captured.append("b 2\n");
            } else if (chess.get('b') != 2) {
                captured.append("b ");
                captured.append(2 - chess.get('b'));
                captured.append("\n");
            }
            if (!chess.containsKey('n')) {
                captured.append("n 2\n");
            } else if (chess.get('n') != 2) {
                captured.append("n ");
                captured.append(2 - chess.get('n'));
                captured.append("\n");
            }
            if (!chess.containsKey('p')) {
                captured.append("p 8");
            } else if (chess.get('p') != 8) {
                captured.append("p ");
                captured.append(8 - chess.get('p'));
                captured.append("\n");
            }
            return captured.toString();
        } else if (player.equals(ChessColor.BLACK)) {
            if (!chess.containsKey('K')) {
                captured.append("K 1\n");
            }
            if (!chess.containsKey('Q')) {
                captured.append("Q 1\n");
            }
            if (!chess.containsKey('R')) {
                captured.append("R 2\n");
            } else if (chess.get('R') != 2) {
                captured.append("R ");
                captured.append(2 - chess.get('R'));
                captured.append("\n");
            }
            if (!chess.containsKey('B')) {
                captured.append("B 2\n");
            } else if (chess.get('B') != 2) {
                captured.append("B ");
                captured.append(2 - chess.get('B'));
                captured.append("\n");
            }
            if (!chess.containsKey('N')) {
                captured.append("N 2\n");
            } else if (chess.get('N') != 2) {
                captured.append("N ");
                captured.append(2 - chess.get('N'));
                captured.append("\n");
            }
            if (!chess.containsKey('P')) {
                captured.append("P 8\n");
            } else if (chess.get('P') != 8) {
                captured.append("P ");
                captured.append(8 - chess.get('P'));
                captured.append("\n");
            }
            return captured.toString();
        } else {
            return "";
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return (chessComponents[source.getX()][source.getY()].canMoveTo());
    }

    //methods
    @Override
    public void loadChessGame(List<String> cb) {
        if (chessboard.size() == 9) {
            while (chessboard.size() != 0) {
                chessboard.remove(0);
            }
        }
        chessboard.addAll(cb);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                chessComponents[i][j] = getChessFromFile(chessboard.get(i).charAt(j), i, j);
            }
        }
        setBeginPlayer(getCurrentPlayerFromFile(chessboard.get(chessboard.size() - 1)));
        setCurrentPlayer(getBeginPlayer());
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadChessboard(chessComponents);
        if (getChess(sourceX, sourceY).getChessColor().equals(currentPlayer)
                && getChess(sourceX, sourceY).moveTo(getChess(targetX, targetY).getSource())) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', this);
            setCurrentPlayer(switchCurrentPlayer());
            return true;
        }
        return false;
    }

    // new
    public ChessComponent getChessFromFile(char c, int x, int y) {
        switch (c) {
            case 'r':
                return new RookChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'r', this);
            case 'R':
                return new RookChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'R', this);
            case 'n':
                return new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'n', this);
            case 'N':
                return new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'N', this);
            case 'b':
                return new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'b', this);
            case 'B':
                return new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'B', this);
            case 'q':
                return new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'q', this);
            case 'Q':
                return new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'Q', this);
            case 'k':
                return new KingChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'k', this);
            case 'K':
                return new KingChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'K', this);
            case 'p':
                return new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'p', this);
            case 'P':
                return new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'P', this);
            case '_':
                return new EmptySlotComponent(new ChessboardPoint(x, y), ChessColor.NONE, '_', this);
        }
        return null;
    }

    public ChessColor getCurrentPlayerFromFile(String lastline) {
        if (lastline.equals("w")) {
            return ChessColor.WHITE;
        } else if (lastline.equals("b")) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.NONE;
        }
    }

    private ChessColor switchCurrentPlayer() {
        if (getCurrentPlayer().equals(ChessColor.WHITE)) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.WHITE;
        }
    }
}
