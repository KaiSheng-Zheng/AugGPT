import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    //Load game
    public void loadChessGame(List<String> chessboard) {
        ChessColor chessColor = ChessColor.NONE;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) <= 90) {
                    chessColor = ChessColor.BLACK;
                }
                if (chessboard.get(i).charAt(j) >= 97) {
                    chessColor = ChessColor.WHITE;
                }
                switch (chessboard.get(i).charAt(j)) {
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, 'k');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, 'q');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, 'r');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, 'b');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, 'n');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, 'p');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, 'K');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, 'Q');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, 'R');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, 'B');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, 'N');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, 'P');
                        break;
                }
                chessComponents[i][j].setConcreteChessGame(this);
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
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

    //Save Game
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
        }
        String str = sb.toString();
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n", str.substring(0, 8), str.substring(8, 16), str.substring(16, 24)
                , str.substring(24, 32), str.substring(32, 40), str.substring(40, 48), str.substring(48, 56), str.substring(56, 64));
    }

    //Find Lost Chess
    @Override
    public String getCapturedChess(ChessColor player) {
        String graph = getChessboardGraph();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int wk = 1;
        int wq = 1;
        int wr = 2;
        int wb = 2;
        int wn = 2;
        int wp = 8;
        int bk = 1;
        int bq = 1;
        int br = 2;
        int bb = 2;
        int bn = 2;
        int bp = 8;
        for (int i = 0; i < graph.length(); i++) {
            switch (graph.charAt(i)) {
                case 'k':
                    wk--;
                    break;
                case 'q':
                    wq--;
                    break;
                case 'r':
                    wr--;
                    break;
                case 'b':
                    wb--;
                    break;
                case 'n':
                    wn--;
                    break;
                case 'p':
                    wp--;
                    break;
                case 'K':
                    bk--;
                    break;
                case 'Q':
                    bq--;
                    break;
                case 'R':
                    br--;
                    break;
                case 'B':
                    bb--;
                    break;
                case 'N':
                    bn--;
                    break;
                case 'P':
                    bp--;
                    break;
            }
        }

        if (bk > 0) {
            sb1.append("K ").append(bk).append("\n");
        }
        if (bq > 0) {
            sb1.append("Q ").append(bq).append("\n");
        }
        if (br > 0) {
            sb1.append("R ").append(br).append("\n");
        }
        if (bb > 0) {
            sb1.append("B ").append(bb).append("\n");
        }
        if (bn > 0) {
            sb1.append("N ").append(bn).append("\n");
        }
        if (bp > 0) {
            sb1.append("P ").append(bp).append("\n");
        }

        if (wk > 0) {
            sb2.append("k ").append(wk).append("\n");
        }
        if (wq > 0) {
            sb2.append("q ").append(wq).append("\n");
        }
        if (wr > 0) {
            sb2.append("r ").append(wr).append("\n");
        }
        if (wb > 0) {
            sb2.append("b ").append(wb).append("\n");
        }
        if (wn > 0) {
            sb2.append("n ").append(wn).append("\n");
        }
        if (wp > 0) {
            sb2.append("p ").append(wp).append("\n");
        }

        if (player.equals(ChessColor.BLACK)) {
            return sb1.toString();
        } else {
            return sb2.toString();
        }
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ArrayList<ChessboardPoint> chess = (ArrayList<ChessboardPoint>) getChess(source.getX(), source.getY()).canMoveTo();
        Comparator<ChessboardPoint> x = Comparator.comparing(ChessboardPoint::getX);
        Comparator<ChessboardPoint> y = Comparator.comparing(ChessboardPoint::getY);
        chess.sort(x.thenComparing(y));
        return chess;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        boolean black = chessComponents[sourceX][sourceY].name <= 90 && currentPlayer.equals(ChessColor.BLACK);
        boolean white = chessComponents[sourceX][sourceY].name >= 97 && currentPlayer.equals(ChessColor.WHITE);
        boolean canmove = false;
        for (int i = 0; i < this.getCanMovePoints(source).size(); i++) {
            ChessboardPoint point = this.getCanMovePoints(source).get(i);
            if (point.getX() == targetX && point.getY() == targetY) {
                canmove = true;
            }
        }
        if (canmove && (white || black)) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
            chessComponents[targetX][targetY].setSource(targetX, targetY);
            chessComponents[sourceX][sourceY].setConcreteGame(this);
            switchPlayer();
            return true;
        } else {
            return false;
        }
    }

    public void switchPlayer() {
        if (this.currentPlayer.equals(ChessColor.WHITE)) {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }
}
