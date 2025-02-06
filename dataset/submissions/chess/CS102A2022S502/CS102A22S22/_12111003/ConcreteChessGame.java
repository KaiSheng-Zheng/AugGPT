import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    // R/r=rooks, N/n=knights, B/b=bishops, Q/q=queen, K/k=king, P/p=pawns, _=nothing
    // The upper case letter indicates black chess pieces, while the lower case letter means white chess pieces.
    // "w" means the current player is white, while "b" means the current player is black.
    public void loadChessGame(List<String> chessboard){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        for (int i= 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                switch (chessboard.get(i).charAt(j)) {
                    case 'K' -> this.chessComponents[i][j] = new KingChessComponent('K');
                    case 'Q' -> this.chessComponents[i][j] = new QueenChessComponent('Q');
                    case 'R' -> this.chessComponents[i][j] = new RookChessComponent('R');
                    case 'B' -> this.chessComponents[i][j] = new BishopChessComponent('B');
                    case 'N' -> this.chessComponents[i][j] = new KnightChessComponent('N');
                    case 'P' -> this.chessComponents[i][j] = new PawnChessComponent('P');
                    case 'k' -> this.chessComponents[i][j] = new KnightChessComponent('k');
                    case 'q' -> this.chessComponents[i][j] = new QueenChessComponent('q');
                    case 'r' -> this.chessComponents[i][j] = new RookChessComponent('r');
                    case 'b' -> this.chessComponents[i][j] = new BishopChessComponent('b');
                    case 'n' -> this.chessComponents[i][j] = new KnightChessComponent('n');
                    case 'p' -> this.chessComponents[i][j] = new PawnChessComponent('p');
                    case '_' -> this.chessComponents[i][j] = new EmptySlotComponent('_');
                }
            }
        }
        if (chessboard.get(8).equals("b")) this.currentPlayer = ChessColor.BLACK;
    }
    @Override
    public ChessColor getCurrentPlayer() {return this.currentPlayer;}
    @Override
    public String getChessboardGraph() {
        StringBuilder chessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessboardGraph.append(this.chessComponents[i][j]);
            }
            chessboardGraph.append("\n");
        }
        return chessboardGraph.toString();
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder capturedChess = new StringBuilder();
        if (player == ChessColor.BLACK){
            int King = 1, Queen = 1, Rooks = 2, Bishops = 2, Knights = 2, Pawns = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K' -> King--;
                        case 'Q' -> Queen--;
                        case 'R' -> Rooks--;
                        case 'B' -> Bishops--;
                        case 'N' -> Knights--;
                        case 'P' -> Pawns--;
                    }
                }
            }
            if (King > 0) capturedChess.append("K ").append(King).append("\n");
            if (Queen > 0) capturedChess.append("Q ").append(Queen).append("\n");
            if (Rooks > 0) capturedChess.append("R ").append(Rooks).append("\n");
            if (Bishops > 0) capturedChess.append("B ").append(Bishops).append("\n");
            if (Knights > 0) capturedChess.append("N ").append(Knights).append("\n");
            if (Pawns > 0) capturedChess.append("P ").append(Pawns);
        }
        else if (player == ChessColor.WHITE){
            int king = 1, queen = 1, rooks = 2, bishops = 2, knights = 2, pawns = 8;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'k' -> king--;
                        case 'q' -> queen--;
                        case 'r' -> rooks--;
                        case 'b' -> bishops--;
                        case 'n' -> knights--;
                        case 'p' -> pawns--;
                    }
                }
            }
            if (king > 0) capturedChess.append("k ").append(king).append("\n");
            if (queen > 0) capturedChess.append("q ").append(queen).append("\n");
            if (rooks > 0) capturedChess.append("r ").append(rooks).append("\n");
            if (bishops > 0) capturedChess.append("b ").append(bishops).append("\n");
            if (knights > 0) capturedChess.append("n ").append(knights).append("\n");
            if (pawns > 0) capturedChess.append("p ").append(pawns);
        }
        return capturedChess.toString();
    }
    public ChessComponent getChess(int x, int y) {return this.chessComponents[x][y];}

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        boolean match;
        ArrayList<Object> white = new ArrayList<>(), black = new ArrayList<>();
        white.add('K');white.add('Q');white.add('R');white.add('B');white.add('N');white.add('P');
        black.add('k');black.add('q');black.add('r');black.add('b');black.add('n');black.add('p');
        match = this.currentPlayer == ChessColor.BLACK &&
                white.contains(chessComponents[sourceX][sourceY].name) ||
                this.currentPlayer == ChessColor.WHITE &&
                black.contains(chessComponents[sourceX][sourceY].name);
        return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return null;
    }
}
