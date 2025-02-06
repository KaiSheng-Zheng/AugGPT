import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (Objects.equals(chessboard.get(i).charAt(k), '_')) {
                    ChessComponent chessComponent = new EmptySlotComponent(new ChessboardPoint(i, k), ChessColor.NONE, '_');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'R')) {
                    ChessComponent chessComponent = new RookChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'R');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'r')) {
                    ChessComponent chessComponent = new RookChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'r');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'K')) {
                    ChessComponent chessComponent = new KingChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'K');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'k')) {
                    ChessComponent chessComponent = new KingChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'k');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'P')) {
                    ChessComponent chessComponent = new PawnChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'P');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'p')) {
                    ChessComponent chessComponent = new PawnChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'p');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'Q')) {
                    ChessComponent chessComponent = new QueenChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'Q');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'q')) {
                    ChessComponent chessComponent = new QueenChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'q');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'B')) {
                    ChessComponent chessComponent = new BishopChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'B');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'b')) {
                    ChessComponent chessComponent = new BishopChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'b');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'N')) {
                    ChessComponent chessComponent = new KnightChessComponent(new ChessboardPoint(i, k), ChessColor.BLACK, 'N');
                    this.chessComponents[i][k] = chessComponent;
                }
                if (Objects.equals(chessboard.get(i).charAt(k), 'n')) {
                    ChessComponent chessComponent = new KnightChessComponent(new ChessboardPoint(i, k), ChessColor.WHITE, 'n');
                    this.chessComponents[i][k] = chessComponent;
                }
            }
        }
        ChessComponent.setChessComponents(this.chessComponents.clone());
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
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                c.append(chessComponents[i][j].name);
            }
            c.append("\n");
        }
        for (int k=0;k<8;k++){
            c.append(chessComponents[7][k].name);
        }
        return c.toString();
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0;
        int Q = 0;
        int R = 0;
        int B = 0;
        int N = 0;
        int P = 0;
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K') {
                    K = K + 1;
                }
                if (chessComponents[i][j].name == 'Q') {
                    Q = Q + 1;
                }
                if (chessComponents[i][j].name == 'R') {
                    R = R + 1;
                }
                if (chessComponents[i][j].name == 'B') {
                    B = B + 1;
                }
                if (chessComponents[i][j].name == 'N') {
                    N = N + 1;
                }
                if (chessComponents[i][j].name == 'P') {
                    P = P + 1;
                }
            }
        }
        String storeBlack= "";
        if (player == ChessColor.BLACK) {
            int k1 = 1 - K;
            int q1 = 1 - Q;
            int r1 = 2 - R;
            int b1 = 2 - B;
            int n1 = 2 - N;
            int p1 = 8 - P;
            if (k1 != 0) {
                storeBlack = storeBlack + "K 1";
            }
            if (q1 != 0) {
                storeBlack = storeBlack + "\nQ 1";
            }
            if (r1 != 0) {
                storeBlack = storeBlack + "\n" + "R " + r1;
            }
            if (b1 != 0) {
                storeBlack = storeBlack + "\n" + "B " + b1;
            }
            if (n1 != 0) {
                storeBlack = storeBlack + "\n" + "N " + n1;
            }
            if (p1 != 0) {
                storeBlack = storeBlack + "\n" + "P " + p1;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'k') {
                    k = k + 1;
                }
                if (chessComponents[i][j].name == 'q') {
                    q = q + 1;
                }
                if (chessComponents[i][j].name == 'r') {
                    r = r + 1;
                }
                if (chessComponents[i][j].name == 'b') {
                    b = b + 1;
                }
                if (chessComponents[i][j].name == 'n') {
                    n = n + 1;
                }
                if (chessComponents[i][j].name == 'p') {
                    p = p + 1;
                }
            }
        }
        String storeWhite = "";
        if (player == ChessColor.WHITE) {
            int k1 = 1 - k;
            int q1 = 1 - q;
            int r1 = 2 - r;
            int b1 = 2 - b;
            int n1 = 2 - n;
            int p1 = 8 - p;
            if (k1 != 0) {
                storeWhite = storeWhite + "k 1";
            }
            if (q1 != 0) {
                storeWhite = storeWhite + "\nq 1";
            }
            if (r1 != 0) {
                storeWhite = storeWhite + "\nr " + r1;
            }
            if (b1 != 0) {
                storeWhite = storeWhite + "\nb " + b1;
            }
            if (n1 != 0) {
                storeWhite = storeWhite + "\nn " + n1;
            }
            if (p1 != 0) {
                storeWhite = storeWhite + "\np " + p1;
            }
        }
        if (player == ChessColor.BLACK)
            return storeBlack;
        else {
            return storeWhite;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean move = false;

        for (int i = 0; i <= chessComponents[sourceX][sourceY].canMoveTo().size() - 1; i++) {

            if (targetX==chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()&&targetY==chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()) {
                move = true;
                break;
            }
        }
        if (this.getChess(sourceX, sourceY).getChessColor() != this.currentPlayer) {
            move = false;
        }
        if (move) {
            this.chessComponents[targetX][targetY] = this.getChess(sourceX, sourceY);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
            if (this.currentPlayer == ChessColor.BLACK) {
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
            ChessComponent.setChessComponents(this.chessComponents);
        }
        return move;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        return chessComponents[x][y].canMoveTo();
    }

}