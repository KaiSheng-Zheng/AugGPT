import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    public static ChessComponent[][] chessComponentsStatic = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
        chessComponentsStatic = chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        String str;
        char chessName;
        for (int i = 0; i < 8; i++) {
            str = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                chessName = str.charAt(j);
                chessComponents[i][j] = loadChess(new ChessboardPoint(i, j), chessName);
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void changeCurrentPlayer(){
        this.currentPlayer = (getCurrentPlayer() == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(this.chessComponents[i][j].getName());
            }
            graph.append("\n");
        }
        return String.valueOf(graph);
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder lost = new StringBuilder();
        int king = 1, queen = 1, rook = 2, bishop = 2, knight = 2, pawn = 8;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (this.chessComponents[i][j].getName()) {
                        case 'R':
                            rook--;
                            break;
                        case 'N':
                            knight--;
                            break;
                        case 'B':
                            bishop--;
                            break;
                        case 'Q':
                            queen--;
                            break;
                        case 'K':
                            king--;
                            break;
                        case 'P':
                            pawn--;
                            break;
                    }
                }
            }
            if (king !=0){
                lost.append("K ");
                lost.append(king);
                lost.append("\n");
            }
            if (queen !=0){
                lost.append("Q ");
                lost.append(queen);
                lost.append("\n");
            }
            if (rook!=0){
                lost.append("R ");
                lost.append(rook);
                lost.append("\n");
            }
            if (bishop!=0){
                lost.append("B ");
                lost.append(bishop);
                lost.append("\n");
            }
            if (knight!=0){
                lost.append("N ");
                lost.append(knight);
                lost.append("\n");
            }
            if (pawn!=0){
                lost.append("P ");
                lost.append(pawn);
                lost.append("\n");
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (this.chessComponents[i][j].getName()) {
                        case 'r':
                            rook--;
                            break;
                        case 'n':
                            knight--;
                            break;
                        case 'b':
                            bishop--;
                            break;
                        case 'q':
                            queen--;
                            break;
                        case 'k':
                            king--;
                            break;
                        case 'p':
                            pawn--;
                            break;
                    }
                }
            }
            if (king !=0){
                lost.append("k ");
                lost.append(king);
                lost.append("\n");
            }
            if (queen !=0){
                lost.append("q ");
                lost.append(queen);
                lost.append("\n");
            }
            if (rook!=0){
                lost.append("r ");
                lost.append(rook);
                lost.append("\n");
            }
            if (bishop!=0){
                lost.append("b ");
                lost.append(bishop);
                lost.append("\n");
            }
            if (knight!=0){
                lost.append("n ");
                lost.append(knight);
                lost.append("\n");
            }
            if (pawn!=0){
                lost.append("p ");
                lost.append(pawn);
                lost.append("\n");
            }
        }
        return String.valueOf(lost);
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()){
            boolean canMove = false;
            for (ChessboardPoint point : chessComponents[sourceX][sourceY].canMoveTo()){
                if (point.getX() == targetX && point.getY() == targetY){
                    canMove = true;
                }
            }
            if (canMove){
                chessComponents[sourceX][sourceY].getSource().setX(targetX);
                chessComponents[sourceX][sourceY].getSource().setY(targetY);
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                changeCurrentPlayer();
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static ChessComponent loadChess(ChessboardPoint source, char parameter) {
        switch (parameter) {
            case 'R':
                return new RookChessComponent(source, ChessColor.BLACK, 'R');
            case 'N':
                return new KnightChessComponent(source, ChessColor.BLACK, 'N');
            case 'B':
                return new BishopChessComponent(source, ChessColor.BLACK, 'B');
            case 'Q':
                return new QueenChessComponent(source, ChessColor.BLACK, 'Q');
            case 'K':
                return new KingChessComponent(source, ChessColor.BLACK, 'K');
            case 'P':
                return new PawnChessComponent(source, ChessColor.BLACK, 'P');
            case '_':
                return new EmptySlotComponent(source, ChessColor.NONE, '_');
            case 'r':
                return new RookChessComponent(source, ChessColor.WHITE, 'r');
            case 'n':
                return new KnightChessComponent(source, ChessColor.WHITE, 'n');
            case 'b':
                return new BishopChessComponent(source, ChessColor.WHITE, 'b');
            case 'q':
                return new QueenChessComponent(source, ChessColor.WHITE, 'q');
            case 'k':
                return new KingChessComponent(source, ChessColor.WHITE, 'k');
            case 'p':
                return new PawnChessComponent(source, ChessColor.WHITE, 'p');
        }
        return null;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    //# Sample parameter (List<String>):
//    RNBQKBNR
//    PPPPPPPP
//    ________
//    ________
//    ________
//    ________
//    pppppppp
//    rnbqkbnr
//    w
//
//    In another word:
//    List<String> chessboard;
//chessboard.get(0) equals to "RNBQKBNR";
//chessboard.get(1) equals to "PPPPPPPP";
//chessboard.get(2) equals to "________";
//chessboard.get(3) equals to "________";
//chessboard.get(4) equals to "________";
//chessboard.get(5) equals to "________";
//chessboard.get(6) equals to "pppppppp";
//chessboard.get(7) equals to "rnbqkbnr";
//chessboard.get(8) equals to "w";
}
