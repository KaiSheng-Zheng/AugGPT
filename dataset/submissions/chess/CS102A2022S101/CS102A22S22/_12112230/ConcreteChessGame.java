import java.util.ArrayList;
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
    private List<String> chessboard;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'p' -> {
                        Pawn pawnB = new Pawn();
                        pawnB.setName(ChessColor.WHITE);
                        pawnB.setSource(i, j);
                        chessComponents[i][j] = pawnB;
                    }
                    case 'P' -> {
                        Pawn pawn = new Pawn();
                        pawn.setName(ChessColor.BLACK);
                        pawn.setSource(i, j);
                        chessComponents[i][j] = pawn;
                    }
                    case 'k' -> {
                        King king = new King();
                        king.setName(ChessColor.WHITE);
                        king.setSource(i, j);
                        chessComponents[i][j] = king;
                    }
                    case 'K' -> {
                        King kingB = new King();
                        kingB.setName(ChessColor.BLACK);
                        kingB.setSource(i, j);
                        chessComponents[i][j] = kingB;
                    }
                    case 'q' -> {
                        Queen queen = new Queen();
                        queen.setName(ChessColor.WHITE);
                        queen.setSource(i, j);
                        chessComponents[i][j] = queen;
                    }
                    case 'Q' -> {
                        Queen queenB = new Queen();
                        queenB.setName(ChessColor.BLACK);
                        queenB.setSource(i, j);
                        chessComponents[i][j] = queenB;
                    }
                    case 'r' -> {
                        Rook rook = new Rook();
                        rook.setName(ChessColor.WHITE);
                        rook.setSource(i, j);
                        chessComponents[i][j] = rook;
                    }
                    case 'R' -> {
                        Rook rookB = new Rook();
                        rookB.setName(ChessColor.BLACK);
                        rookB.setSource(i, j);
                        chessComponents[i][j] = rookB;
                    }
                    case 'b' -> {
                        Bishop bishop = new Bishop();
                        bishop.setName(ChessColor.WHITE);
                        bishop.setSource(i, j);
                        chessComponents[i][j] = bishop;
                    }
                    case 'B' -> {
                        Bishop bishopB = new Bishop();
                        bishopB.setName(ChessColor.BLACK);
                        bishopB.setSource(i, j);
                        chessComponents[i][j] = bishopB;
                    }
                    case 'n' -> {
                        Knight knight = new Knight();
                        knight.setName(ChessColor.WHITE);
                        knight.setSource(i, j);
                        chessComponents[i][j] = knight;
                    }
                    case 'N' -> {
                        Knight knightB = new Knight();
                        knightB.setName(ChessColor.BLACK);
                        knightB.setSource(i, j);
                        chessComponents[i][j] = knightB;
                    }
                    default -> {
                        Empty empty = new Empty();
                        empty.setSource(i, j);
                        chessComponents[i][j] = empty;
                    }
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }
        this.chessboard = chessboard;
    }

    @Override
    public ChessColor getCurrentPlayer() {

        return this.currentPlayer;
    }

    public List<String> getChessboardFromChessComponents() {
        List<String> getNewChessBoard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder oneRow = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                ChessComponent chess = chessComponents[i][j];
                if (chess instanceof King) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('k');
                    }else{
                        oneRow.append('K');
                    }
                } else if (chess instanceof Queen) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('q');
                    }else{
                        oneRow.append('Q');
                    }
                } else if (chess instanceof Bishop) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('b');
                    }else{
                        oneRow.append('B');
                    }
                } else if (chess instanceof Knight) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('n');
                    }else{
                        oneRow.append('N');
                    }
                } else if (chess instanceof Rook) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('r');
                    }else{
                        oneRow.append('R');
                    }
                } else if (chess instanceof Pawn) {
                    if (chess.getChessColor()==ChessColor.WHITE){
                        oneRow.append('p');
                    }else{
                        oneRow.append('P');
                    }
                } else {
                    oneRow.append('_');
                }
            }
            getNewChessBoard.add(oneRow.toString());

        }
        return getNewChessBoard;
    }

    @Override
    public ChessComponent getChess(int x, int y) {

        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {

        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            bars.append(chessboard.get(i));
            bars.append("\n");
        }
        return bars.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.WHITE) {
            int k = 1;
            int q = 1;
            int r = 2;
            int b = 2;
            int n = 2;
            int p = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (getChessboardFromChessComponents().get(i).charAt(j)) {
                        case 'p':
                            p--;
                            break;
                        case 'k':
                            k--;
                            break;
                        case 'q':
                            q--;
                            break;
                        case 'r':
                            r--;
                            break;
                        case 'b':
                            b--;
                            break;
                        case 'n':
                            n--;
                        default:
                            break;
                    }
                }
            }
            StringBuilder lost = new StringBuilder();
            if (k != 0) lost.append("k ").append(k).append("\n");
            if (q != 0) lost.append("q ").append(q).append("\n");
            if (r != 0) lost.append("r ").append(r).append("\n");
            if (b != 0) lost.append("b ").append(b).append("\n");
            if (n != 0) lost.append("n ").append(n).append("\n");
            if (p != 0) lost.append("p ").append(p).append("\n");
            return lost.toString();
        } else {
            int K = 1;
            int Q = 1;
            int R = 2;
            int B = 2;
            int N = 2;
            int P = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (getChessboardFromChessComponents().get(i).charAt(j)) {
                        case 'P':
                            P--;
                            break;
                        case 'K':
                            K--;
                            break;
                        case 'Q':
                            Q--;
                            break;
                        case 'R':
                            R--;
                            break;
                        case 'B':
                            B--;
                            break;
                        case 'N':
                            N--;
                        default:
                            break;
                    }
                }
            }
            StringBuilder lost = new StringBuilder();
            if (K != 0) lost.append("K ").append(K).append("\n");
            if (Q != 0) lost.append("Q ").append(Q).append("\n");
            if (R != 0) lost.append("R ").append(R).append("\n");
            if (B != 0) lost.append("B ").append(B).append("\n");
            if (N != 0) lost.append("N ").append(N).append("\n");
            if (P != 0) lost.append("P ").append(P).append("\n");
            return lost.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        ChessComponent chessComponent = getChess(source.getX(), source.getY());
        chessComponent.board = chessComponents;
        final List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
        canMovePoints.sort(ChessboardPoint.xAscending);
        canMovePoints.sort(ChessboardPoint.yAscending);
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7)
            return false;
        final ChessComponent currentChessComponent = getChess(sourceX, sourceY);
        if (getCurrentPlayer() != currentChessComponent.getChessColor() || currentChessComponent instanceof Empty)
            return false;
        final ChessboardPoint targetedCoordinate = new ChessboardPoint(targetX, targetY);

        if (!getCanMovePoints(currentChessComponent.getSource()).isEmpty()) {
            for (ChessboardPoint candidateCoordinate :
                    getCanMovePoints(currentChessComponent.getSource())) {
                if (targetedCoordinate.isTheSameCoordinate(candidateCoordinate)) {
                    chessComponents[sourceX][sourceY] = new Empty();
                    currentChessComponent.setSource(targetX, targetY);
                    chessComponents[targetX][targetY] = currentChessComponent;
                    if (getCurrentPlayer() == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
