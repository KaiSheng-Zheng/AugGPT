import java.util.List;
import java.util.Objects;

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

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessBoard(chessComponents);
                chessComponents[i][j].source.setChessComponents(chessComponents);
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (Objects.equals(chessboard.get(8), "b")) {
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
        char[][] chars = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chars[i][j] = chessComponents[i][j].name;
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", String.valueOf(chars[0]), String.valueOf(chars[1]), String.valueOf(chars[2]), String.valueOf(chars[3]), String.valueOf(chars[4]), String.valueOf(chars[5]), String.valueOf(chars[6]), String.valueOf(chars[7]));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;
        String str = "";
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        k = k - 1;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        q = q - 1;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        r = r - 1;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        b = b - 1;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        n = n - 1;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        p = p - 1;
                    }
                }
            }
            if (k != 0) {
                str = str + String.format("k %d\n", k);
            }
            if (q != 0) {
                str = str + String.format("q %d\n", q);
            }
            if (r != 0) {
                str = str + String.format("r %d\n", r);
            }
            if (b != 0) {
                str = str + String.format("b %d\n", b);
            }
            if (n != 0) {
                str = str + String.format("n %d\n", n);
            }
            if (p != 0) {
                str = str + String.format("p %d\n", p);
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        k = k - 1;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        q = q - 1;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        r = r - 1;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        b = b - 1;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        n = n - 1;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        p = p - 1;
                    }
                }
            }
            if (k != 0) {
                str = str + String.format("K %d\n", k);
            }
            if (q != 0) {
                str = str + String.format("Q %d\n", q);
            }
            if (r != 0) {
                str = str + String.format("R %d\n", r);
            }
            if (b != 0) {
                str = str + String.format("B %d\n", b);
            }
            if (n != 0) {
                str = str + String.format("N %d\n", n);
            }
            if (p != 0) {
                str = str + String.format("P %d\n", p);
            }
        }
        return str;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> a = chessComponents[source.getX()][source.getY()].canMoveTo();
        int jiShuQi = 0;
        ChessboardPoint trans;
        out:
        for (int j = 0; j < a.size(); j++) {
            jiShuQi = 0;
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i).getX() > a.get(i + 1).getX()) {
                    trans = a.get(i);
                    a.set(i,a.get(i+1));
                    a.set(i+1,trans);
                    jiShuQi++;
                }else if (a.get(i).getX() == a.get(i + 1).getX() && a.get(i).getY() > a.get(i + 1).getY()){
                    trans = a.get(i);
                    a.set(i,a.get(i+1));
                    a.set(i+1,trans);
                    jiShuQi++;
                }
            }
            if (jiShuQi == 0){
                break out;
            }
        }
        return a;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint chessboardPoint1 = new ChessboardPoint(targetX, targetY);
        if (Objects.equals(this.currentPlayer, chessComponents[sourceX][sourceY].getChessColor())) {
            for (ChessboardPoint chessboardPoint : getCanMovePoints(new ChessboardPoint(sourceX, sourceY))) {
                if (Objects.equals(chessboardPoint.toString(), chessboardPoint1.toString())) {

                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            chessComponents[i][j].setChessBoard(chessComponents);
                            chessComponents[i][j].source.setChessComponents(chessComponents);
                        }
                    }
                    if (Objects.equals(currentPlayer,ChessColor.WHITE)){
                        currentPlayer = ChessColor.BLACK;
                    }else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}
