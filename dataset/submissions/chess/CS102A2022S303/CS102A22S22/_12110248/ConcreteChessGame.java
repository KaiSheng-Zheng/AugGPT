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

    private ChessColor getComponentColor(char type) {
        if (type >= 'A' && type <= 'Z') {
            return ChessColor.BLACK;
        } else if (type >= 'a' && type <= 'z') {
            return ChessColor.WHITE;
        }
        return ChessColor.NONE;
    }

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'B': {
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'b': {
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case '_': {
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'K': {
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'k': {
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'N': {
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'n': {
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'P': {
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'p': {
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'Q': {
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'q': {
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'R': {
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                    case 'r': {
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        this.chessComponents[i][j].setChessBoard(this.chessComponents);
                        break;
                    }
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
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
        StringBuilder chessBoardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardGraph.append(chessComponents[i][j].name);
            }
            chessBoardGraph.append("\n");
        }
        return chessBoardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder whiteCaptured = new StringBuilder();
        StringBuilder blackCaptured = new StringBuilder();
        int[] white = new int[6];
        int[] black = new int[6];
        int[] all = {1, 1, 2, 2, 2, 8};
        char[] whiteChess = {'k', 'q', 'r', 'b', 'n', 'p'};
        char[] blackChess = {'K', 'Q', 'R', 'B', 'N', 'P'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].chessColor == ChessColor.WHITE) {
                    switch (chessComponents[i][j].name) {
                        case 'k': {
                            white[0]++;
                            break;
                        }
                        case 'q': {
                            white[1]++;
                            break;
                        }
                        case 'r': {
                            white[2]++;
                            break;
                        }
                        case 'b': {
                            white[3]++;
                            break;
                        }
                        case 'n': {
                            white[4]++;
                            break;
                        }
                        case 'p': {
                            white[5]++;
                            break;
                        }
                    }
                }
                if (chessComponents[i][j].chessColor == ChessColor.BLACK) {
                    switch (chessComponents[i][j].name) {
                        case 'K': {
                            black[0]++;
                            break;
                        }
                        case 'Q': {
                            black[1]++;
                            break;
                        }
                        case 'R': {
                            black[2]++;
                            break;
                        }
                        case 'B': {
                            black[3]++;
                            break;
                        }
                        case 'N': {
                            black[4]++;
                            break;
                        }
                        case 'P': {
                            black[5]++;
                            break;
                        }
                    }
                }
            }
        }

        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 6; i++) {
                if (all[i] - white[i] != 0) {
                    whiteCaptured.append(String.format("%s %d\n", whiteChess[i], (all[i] - white[i])));
                }
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (all[i] - black[i] != 0) {
                    blackCaptured.append(String.format("%s %d\n", blackChess[i], (all[i] - black[i])));
                }
            }
        }

        if (player == ChessColor.BLACK) {
            return blackCaptured.toString();
        }
        return whiteCaptured.toString();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = this.getChess(sourceX, sourceY);
        if (currentPlayer != getComponentColor(chess.toString().charAt(0))) {
            return false;
        }
        List<ChessboardPoint> moveTo = chess.canMoveTo();
        if (moveTo.contains(new ChessboardPoint(targetX, targetY))) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];//eat chess(update the component)
            chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);//eat chess(update the location)
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);//was eaten
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            }
            else if (currentPlayer == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            }

            //change currentPlayer
            return true;
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(new Sort());
        // 3.sort canMovePoints by x - y ascending order
        //1)Comparable, write in class(can be found in Lab13)
        //2)Comparator, write here(recommended,solve only once)
        return canMovePoints;
    }

    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1, ChessboardPoint p2) {
            if (p1.getX() == p2.getX()) {
                return p1.getY() - p2.getY();
            }


            return p1.getX() - p2.getX();
        }
    }
}
