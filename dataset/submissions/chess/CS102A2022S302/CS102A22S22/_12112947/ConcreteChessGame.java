import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    ChessboardPoint source;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    private ChessColor getComponentColor(char component) {
        return (component == '_') ? ChessColor.NONE : ((component >= 'A' && component <= 'Z') ? ChessColor.BLACK : ChessColor.WHITE);
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char component = chessboard.get(i).charAt(j), raw = (component == '_') ? '_' : (char) (component & (~32));
                if (raw == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else if (raw == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else if (raw == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else if (raw == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else if (raw == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else if (raw == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), getComponentColor(component));
                }
            }
        }
        currentPlayer = chessboard.get(8).charAt(0) == 'b' ? ChessColor.BLACK : ChessColor.WHITE;
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

        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.append(chessComponents[i][j].toString());
            }
            board.append("\n");
        }
        return board.toString();
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder board = new StringBuilder();
        int[] num = new int[200];
        int[] symPol = new int[]{'K', 'Q', 'R', 'B', 'N', 'P'};
        int[] initNum = new int[]{1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getComponentColor(chessComponents[i][j].toString().charAt(0)) == player) {
                    num[chessComponents[i][j].toString().charAt(0) & (~32)]++;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            if (num[symPol[i]] < initNum[i]) {
                board.append((char) (symPol[i] | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(initNum[i] - num[symPol[i]]).append("\n");
            }
        }
        return board.toString();



    }
    }

