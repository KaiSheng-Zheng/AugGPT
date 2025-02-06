import java.util.Comparator;
import java.util.List;

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
        chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) currentPlayer = ChessColor.WHITE;
        if (chessboard.get(8).equals("b")) currentPlayer = ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                    str.append(chessComponents[i][j].name);
                }
                if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    str.append(chessComponents[i][j].name);
                }
                if (chessComponents[i][j].getChessColor().equals(ChessColor.NONE)) {
                    str.append("_");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int King = 0, Queen = 0, Knight = 0, Rook = 0, Pawn = 0, Bishop = 0, king = 0, queen = 0, knight = 0, rook = 0, pawn = 0, bishop = 0;
        String str = getChessboardGraph();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'R':
                    Rook++;
                    break;
                case 'N':
                    Knight++;
                    break;
                case 'B':
                    Bishop++;
                    break;
                case 'K':
                    King++;
                    break;
                case 'Q':
                    Queen++;
                    break;
                case 'P':
                    Pawn++;
                    break;
                case 'r':
                    rook++;
                    break;
                case 'n':
                    knight++;
                    break;
                case 'b':
                    bishop++;
                    break;
                case 'k':
                    king++;
                    break;
                case 'q':
                    queen++;
                    break;
                case 'p':
                    pawn++;
                    break;
            }
        }
        Rook = 2 - Rook;
        Knight = 2 - Knight;
        Bishop = 2 - Bishop;
        King = 1 - King;
        Queen = 1 - Queen;
        Pawn = 8 - Pawn;
        rook = 2 - rook;
        knight = 2 - knight;
        bishop = 2 - bishop;
        king = 1 - king;
        queen = 1 - queen;
        pawn = 8 - pawn;
        StringBuilder s = new StringBuilder();
        if (player.equals(ChessColor.BLACK)) {
            if (King != 0) {
                s.append("K ").append(King).append("\n");
            }
            if (Queen != 0) {
                s.append("Q ").append(Queen).append("\n");
            }
            if (Rook != 0) {
                s.append("R ").append(Rook).append("\n");
            }
            if (Bishop != 0) {
                s.append("B ").append(Bishop).append("\n");
            }
            if (Knight != 0) {
                s.append("N ").append(Knight).append("\n");
            }
            if (Pawn != 0) {
                s.append("P ").append(Pawn).append("\n");
            }
        } else {
            if (king != 0) {
                s.append("k ").append(king).append("\n");
            }
            if (queen != 0) {
                s.append("q ").append(queen).append("\n");
            }
            if (rook != 0) {
                s.append("r ").append(rook).append("\n");
            }
            if (bishop != 0) {
                s.append("b ").append(bishop).append("\n");
            }
            if (knight != 0) {
                s.append("n ").append(knight).append("\n");
            }
            if (pawn != 0) {
                s.append("p ").append(pawn).append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Comparator<ChessboardPoint> comparator = new MyComparator();
        canMovePoints.sort(comparator);
        return canMovePoints;
    }

    class MyComparator implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            if (o1.getX() == o2.getX()) {
                return o1.getY() - o2.getY();
            } else {
                return o1.getX() - o2.getX();
            }
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean flag=false;
        if (getCurrentPlayer() == ChessColor.BLACK) {
            if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()) {
                if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(sourceX, sourceY));
                    flag=true;
                    currentPlayer = ChessColor.WHITE;
                }
            }
        }else if (getCurrentPlayer() == ChessColor.WHITE) {
            if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()) {
                if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(sourceX, sourceY));
                flag =true;
                    currentPlayer = ChessColor.BLACK;
                }
            }
        }

        return flag;
    }

        public ChessComponent[][] getChessComponents () {
            return chessComponents;
        }
    }

