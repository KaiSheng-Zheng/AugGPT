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
                if (chessboard.get(i).charAt(j) == 'R') {
                    RookChessComponent rookChessComponent = new RookChessComponent();
                    rookChessComponent.setChessColor(ChessColor.BLACK);
                    rookChessComponent.setName('R');
                    rookChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = rookChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    R++;
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    RookChessComponent rookChessComponent = new RookChessComponent();
                    rookChessComponent.setChessColor(ChessColor.WHITE);
                    rookChessComponent.setName('r');
                    rookChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = rookChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    r++;
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    KnightChessComponent knightChessComponent = new KnightChessComponent();
                    knightChessComponent.setChessColor(ChessColor.BLACK);
                    knightChessComponent.setName('N');
                    knightChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = knightChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    N++;
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    KnightChessComponent knightChessComponent = new KnightChessComponent();
                    knightChessComponent.setChessColor(ChessColor.WHITE);
                    knightChessComponent.setName('n');
                    knightChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = knightChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    n++;
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    BishopChessComponent bishopChessComponent = new BishopChessComponent();
                    bishopChessComponent.setChessColor(ChessColor.BLACK);
                    bishopChessComponent.setName('B');
                    bishopChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = bishopChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    B++;
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    BishopChessComponent bishopChessComponent = new BishopChessComponent();
                    bishopChessComponent.setChessColor(ChessColor.WHITE);
                    bishopChessComponent.setName('b');
                    bishopChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = bishopChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    b++;
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    QueenChessComponent queenChessComponent = new QueenChessComponent();
                    queenChessComponent.setChessColor(ChessColor.BLACK);
                    queenChessComponent.setName('Q');
                    queenChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = queenChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    Q++;
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    QueenChessComponent queenChessComponent = new QueenChessComponent();
                    queenChessComponent.setChessColor(ChessColor.WHITE);
                    queenChessComponent.setName('q');
                    queenChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = queenChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    q++;
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    KingChessComponent kingChessComponent = new KingChessComponent();
                    kingChessComponent.setChessColor(ChessColor.BLACK);
                    kingChessComponent.setName('K');
                    kingChessComponent.setSource(new ChessboardPoint(i, j));
                    this.chessComponents[i][j] = kingChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    K++;
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    KingChessComponent kingChessComponent = new KingChessComponent();
                    kingChessComponent.setChessColor(ChessColor.WHITE);
                    kingChessComponent.setName('k');
                    kingChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = kingChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    k++;
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    PawnChessComponent pawnChessComponent = new PawnChessComponent();
                    pawnChessComponent.setChessColor(ChessColor.BLACK);
                    pawnChessComponent.setName('P');
                    pawnChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = pawnChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    P++;
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    PawnChessComponent pawnChessComponent = new PawnChessComponent();
                    pawnChessComponent.setChessColor(ChessColor.WHITE);
                    pawnChessComponent.setName('p');
                    pawnChessComponent.setSource(new ChessboardPoint(i, j));
                    chessComponents[i][j] = pawnChessComponent;
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
//                    p++;
                } else if (chessboard.get(i).charAt(j) == '_') {
                    EmptySlotComponent emptySlotComponent = new EmptySlotComponent();
                    emptySlotComponent.setChessColor(ChessColor.NONE);
                    chessComponents[i][j] = emptySlotComponent;
                    emptySlotComponent.setName('_');
                    emptySlotComponent.setSource(new ChessboardPoint(i, j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
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
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].toString());
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        byte K = 0;
        byte k = 0;
        byte N = 0;
        byte n = 0;
        byte B = 0;
        byte b = 0;
        byte Q = 0;
        byte q = 0;
        byte P = 0;
        byte p = 0;
        byte R = 0;
        byte r = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    if (chessComponents[i][j].getName() == 'k') k++;
                    else if (chessComponents[i][j].getName() == 'q') q++;
                    else if (chessComponents[i][j].getName() == 'r') r++;
                    else if (chessComponents[i][j].getName() == 'b') b++;
                    else if (chessComponents[i][j].getName() == 'n') n++;
                    else if (chessComponents[i][j].getName() == 'p') p++;
                } else if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    if (chessComponents[i][j].getName() == 'K') K++;
                    else if (chessComponents[i][j].getName() == 'Q') Q++;
                    else if (chessComponents[i][j].getName() == 'R') R++;
                    else if (chessComponents[i][j].getName() == 'B') B++;
                    else if (chessComponents[i][j].getName() == 'N') N++;
                    else if (chessComponents[i][j].getName() == 'P') P++;
                }
            }
        }
        if (player == ChessColor.WHITE) {
            if (k < 1) {
                str.append("k ").append((byte) (1 - k)).append("\n");
            }
            if (q < 1) {
                str.append("q ").append((byte) (1 - q)).append("\n");
            }
            if (r < 2) {
                str.append("r ").append((byte) (2 - r)).append("\n");
            }
            if (b < 2) {
                str.append("b ").append((byte) (2 - b)).append("\n");
            }
            if (n < 2) {
                str.append("n ").append((byte) (2 - n)).append("\n");
            }
            if (p < 8) {
                str.append("p ").append((byte) (8 - p)).append("\n");
            }
        } else if (player == ChessColor.BLACK) {
            if (K < 1) {
                str.append("K ").append((byte) (1 - K)).append("\n");
            }

            if (Q < 1) {
                str.append("Q ").append((byte) (1 - Q)).append("\n");
            }

            if (R < 2) {
                str.append("R ").append((byte) (2 - R)).append("\n");
            }

            if (B < 2) {
                str.append("B ").append((byte) (2 - B)).append("\n");
            }

            if (N < 2) {
                str.append("N ").append((byte) (2 - N)).append("\n");
            }

            if (P < 8) {
                str.append("P ").append((byte) (8 - P)).append("\n");
            }
        }
        return str.toString();
    }

    //change player
    public void changePlayer() {
        if (this.currentPlayer == ChessColor.WHITE) {
            this.currentPlayer = ChessColor.BLACK;
        } else if (this.currentPlayer == ChessColor.BLACK) {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        ChessboardPoint[] canMove = new ChessboardPoint[canMovePoints.size()];
        for (int i = 0; i < canMovePoints.size(); i++) {
            canMove[i] = canMovePoints.get(i);
        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                if (canMove[j].getX() > canMove[j + 1].getX()) {
                    ChessboardPoint chessboardPoint = canMove[j];
                    canMove[j] = canMove[j + 1];
                    canMove[j + 1] = chessboardPoint;
                } else if ((canMove[j].getX() == canMove[j + 1].getX()) && (canMove[j].getY() > canMove[j + 1].getY())) {
                    ChessboardPoint chessboardPoint = canMove[j];
                    canMove[j] = canMove[j + 1];
                    canMove[j + 1] = chessboardPoint;
                }
            }
        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            canMovePoints.remove(0);
            canMovePoints.add(canMove[i]);
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = chessComponents[sourceX][sourceY];
        if (this.getChess(sourceX, sourceY).getChessColor() == this.currentPlayer) {
            for (int i = 0; i < this.getChess(sourceX, sourceY).canMoveTo().size(); i++) {
                if (this.getChess(sourceX, sourceY).canMoveTo().get(i).getX() == targetX && this.getChess(sourceX, sourceY).canMoveTo().get(i).getY() == targetY) {
                    //new empty to place in source
                    EmptySlotComponent emptySlotComponent = new EmptySlotComponent();
                    emptySlotComponent.setChessColor(ChessColor.NONE);
                    emptySlotComponent.setName('_');
                    emptySlotComponent.setSource(new ChessboardPoint(sourceX, sourceY));
                    chessComponents[sourceX][sourceY] = emptySlotComponent;
                    //change source component's point
                    source.setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[targetX][targetY] = source;
                    this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
                    changePlayer();
                    return true;
                }
            }
        }

        return false;
    }
}
