import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setName('_');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setName('R');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setName('N');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setName('B');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setName('Q');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setName('K');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setName('P');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setName('r');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setName('n');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setName('b');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setName('q');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setName('k');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setName('p');
                    this.chessComponents[i][j].setSource(i, j);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
            switch (chessboard.get(8)) {
                case "w":
                    this.currentPlayer = ChessColor.WHITE;
                    break;
                case "b":
                    this.currentPlayer = ChessColor.BLACK;
                    break;
            }
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
        StringBuilder chessboardGraph = new StringBuilder();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                chessboardGraph.append(chessComponents[j][i]);
            }
            chessboardGraph.append(System.getProperty("line.separator"));
        }
        return chessboardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
