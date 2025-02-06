import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    /**
     * A 2-dimension array to store all the chess components,
     * should be initialized in your constructor.
     * i.e. = new ChessComponent[8][8]
     */
    private ChessComponent[][] chessComponents;
    /**
     * What's the current player's color, black or white?
     * should be initialized in your constructor.
     * by default, set the color to white.
     */
    private ChessColor currentPlayer;

    // Constructor
    public ConcreteChessGame(){
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.setChessComponents(chessComponents); // construct a chessComponents of 8*8
        this.setCurrentPlayer(ChessColor.WHITE); // white by default
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * R: rook   N: knight   B: bishop   Q: queen   K: king   P: pawn   _: nothing
     * UPPER case: black   lower case: white
     * w: white now   b: black now
     * note: REMEMBER TO CHANGE THE CLASS NAME OF THE CHESS
     */
    public void loadChessGame(List<String> chessboard){
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.BLACK, 'K');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i, j, ChessColor.WHITE, 'k');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.BLACK, 'Q');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i, j, ChessColor.WHITE, 'q');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.BLACK, 'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i, j, ChessColor.WHITE, 'r');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.BLACK, 'B');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i, j, ChessColor.WHITE, 'b');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.BLACK, 'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i, j, ChessColor.WHITE, 'n');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.BLACK, 'P');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(i, j, ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(i, j, ChessColor.NONE, '_');
                        break;
                }
            }
        }
        this.setChessComponents(chessComponents);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j].setChessboard(this.getChessComponents());
            }
        }
        if (chessboard.get(8).equals("w")){
            this.setCurrentPlayer(ChessColor.WHITE);
        } else {
            this.setCurrentPlayer(ChessColor.BLACK);
        }
    }

    /**
     * Return the chessboard status in one string, use \n to separate 2 rows.
     * @return the chessboard status
     */
    public String getChessboardGraph(){
        StringBuilder chessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboardGraph.append(this.getChessComponents()[i][j].getName());
            }
            chessboardGraph.append('\n');
        }
        return chessboardGraph.toString();
    }

    /**
     * 1King > 1Queen > 2Rooks > 2Bishops > 2Knights > 8Pawns
     * example: "Q 1\nR 2\n" or "p 4\n"
     * @return all the captured chess pieces
     */
    public String getCapturedChess(ChessColor player){
        StringBuilder capturedChess = new StringBuilder();
        if (player == ChessColor.BLACK){ // UPPER case
            int K = 1;
            int Q = 1;
            int R = 2;
            int B = 2;
            int N = 2;
            int P = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (this.getChessComponents()[i][j].getName()){
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
                            break;
                        case 'P':
                            P--;
                            break;
                    }
                }
            }
            if (K != 0){
                capturedChess.append("K ");
                capturedChess.append(K);
                capturedChess.append('\n');
            }
            if (Q != 0){
                capturedChess.append("Q ");
                capturedChess.append(Q);
                capturedChess.append('\n');
            }
            if (R != 0){
                capturedChess.append("R ");
                capturedChess.append(R);
                capturedChess.append('\n');
            }
            if (B != 0){
                capturedChess.append("B ");
                capturedChess.append(B);
                capturedChess.append('\n');
            }
            if (N != 0){
                capturedChess.append("N ");
                capturedChess.append(N);
                capturedChess.append('\n');
            }
            if (P != 0){
                capturedChess.append("P ");
                capturedChess.append(P);
                capturedChess.append('\n');
            }
        } else { // lower case
            int k = 1;
            int q = 1;
            int r = 2;
            int b = 2;
            int n = 2;
            int p = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (this.getChessComponents()[i][j].getName()){
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
                            break;
                        case 'p':
                            p--;
                            break;
                    }
                }
            }
            if (k != 0){
                capturedChess.append("k ");
                capturedChess.append(k);
                capturedChess.append('\n');
            }
            if (q != 0){
                capturedChess.append("q ");
                capturedChess.append(q);
                capturedChess.append('\n');
            }
            if (r != 0){
                capturedChess.append("r ");
                capturedChess.append(r);
                capturedChess.append('\n');
            }
            if (b != 0){
                capturedChess.append("b ");
                capturedChess.append(b);
                capturedChess.append('\n');
            }
            if (n != 0){
                capturedChess.append("n ");
                capturedChess.append(n);
                capturedChess.append('\n');
            }
            if (p != 0){
                capturedChess.append("p ");
                capturedChess.append(p);
                capturedChess.append('\n');
            }
        }
        return capturedChess.toString();
    }

    // returns the concrete chess component in (x, y) location
    public ChessComponent getChess(int x, int y){
        return this.getChessComponents()[x][y];
    }
    public ChessComponent getChess(ChessboardPoint source){
        return this.getChessComponents()[source.getX()][source.getY()];
    }

    // sort
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessboardPoint[] canMovePoints = new ChessboardPoint[this.getChess(source).canMoveTo().size()];
        for (int i = 0; i < canMovePoints.length; i++) {
            canMovePoints[i] = this.getChess(source).canMoveTo().get(i);
        } // fill List available into the canMovePoints array
        if (canMovePoints.length != 0){
            for (int i = 1; i < canMovePoints.length; i++) {
                boolean flag = true;
                for (int j = 0; j < canMovePoints.length - i; j++) {
                    // compare x
                    if (canMovePoints[j].getX() > canMovePoints[j + 1].getX()){
                        ChessboardPoint tmp = canMovePoints[j];
                        canMovePoints[j] = canMovePoints[j + 1];
                        canMovePoints[j + 1] = tmp;
                        flag = false;
                    } else if (canMovePoints[j].getX() == canMovePoints[j + 1].getX()){
                        // x same, compare y
                        if (canMovePoints[j].getY() > canMovePoints[j + 1].getY()){
                            ChessboardPoint tmp = canMovePoints[j];
                            canMovePoints[j] = canMovePoints[j + 1];
                            canMovePoints[j + 1] = tmp;
                            flag = false;
                        }
                    }
                }
                if (flag){
                    break;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(canMovePoints));
    }

    /**
     * 1. check out whether the chess match the player
     * 2. change the location(source) of two chess
     * 3. swap the reference of two chess in array "chessComponents"
     * 4. The original place of the piece should be replaced to an empty chess component
     * @return whether the move is legal
     */
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        if (this.getChess(source).getChessColor() == this.getCurrentPlayer() &&
                this.getCanMovePoints(source).contains(target)){
            // swap the reference of two chess in array "chessComponents"
            ChessComponent[][] newStatus = this.getChessComponents();
            this.getChess(source).setSource(target);
            newStatus[targetX][targetY] = this.getChess(source);
            newStatus[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ChessColor.NONE, '_');
            this.setChessComponents(newStatus);
            // switch player
            if (this.getCurrentPlayer() == ChessColor.BLACK){
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
            return true; // legal
        } else {
            return false; // illegal
        }
    }
}
