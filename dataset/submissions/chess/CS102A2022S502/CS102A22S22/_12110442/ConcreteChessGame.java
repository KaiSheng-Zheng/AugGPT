import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == '_'){
                    EmptySlotComponent empty = new EmptySlotComponent('_', i, j);
                    this.chessComponents[i][j] = empty;
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    RookChessComponent RookB = new RookChessComponent('R', i, j);
                    this.chessComponents[i][j] = RookB;
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    RookChessComponent RookW = new RookChessComponent('r', i, j);
                    this.chessComponents[i][j] = RookW;
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    KnightChessComponent KnightB = new KnightChessComponent('N', i, j);
                    this.chessComponents[i][j] = KnightB;
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    KnightChessComponent KnightW = new KnightChessComponent('n', i, j);
                    this.chessComponents[i][j] = KnightW;
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    BishopChessComponent BishopB = new BishopChessComponent('B', i, j);
                    this.chessComponents[i][j] = BishopB;
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    BishopChessComponent BishopW = new BishopChessComponent('b', i, j);
                    this.chessComponents[i][j] = BishopW;
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    QueenChessComponent QueenB = new QueenChessComponent('Q', i, j);
                    this.chessComponents[i][j] = QueenB;
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    QueenChessComponent QueenW = new QueenChessComponent('q', i, j);
                    this.chessComponents[i][j] = QueenW;
                }
                if (chessboard.get(i).charAt(j) == 'K'){
                    KingChessComponent KingB = new KingChessComponent('K', i, j);
                    this.chessComponents[i][j] = KingB;
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    KingChessComponent KingW = new KingChessComponent('k', i, j);
                    this.chessComponents[i][j] = KingW;
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    PawnChessComponent PawnB = new PawnChessComponent('P', i, j);
                    this.chessComponents[i][j] = PawnB;
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    PawnChessComponent PawnW = new PawnChessComponent('p', i, j);
                    this.chessComponents[i][j] = PawnW;
                }
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
        StringBuilder graph = new StringBuilder(new String());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j]);
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder capturedChess = new StringBuilder();
        StringBuilder str = new StringBuilder(getChessboardGraph());
        int numR = 0, numN = 0, numB = 0, numQ = 0, numK = 0, numP = 0;
        if (player == ChessColor.BLACK){
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'R'){numR++;}
                if (str.charAt(i) == 'N'){numN++;}
                if (str.charAt(i) == 'B'){numB++;}
                if (str.charAt(i) == 'Q'){numQ++;}
                if (str.charAt(i) == 'K'){numK++;}
                if (str.charAt(i) == 'P'){numP++;}
            }
            if (numK < 1){capturedChess.append("K 1\n");}
            if (numQ < 1){capturedChess.append("Q 1\n");}
            if (numR < 2){capturedChess.append("R " + (2-numR) + "\n");}
            if (numB < 2){capturedChess.append("B " + (2-numB) + "\n");}
            if (numN < 2){capturedChess.append("N " + (2-numN) + "\n");}
            if (numP < 8){capturedChess.append("P " + (8-numP) + "\n");}
        }
        if (player == ChessColor.WHITE){
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'r'){numR++;}
                if (str.charAt(i) == 'n'){numN++;}
                if (str.charAt(i) == 'b'){numB++;}
                if (str.charAt(i) == 'q'){numQ++;}
                if (str.charAt(i) == 'k'){numK++;}
                if (str.charAt(i) == 'p'){numP++;}
            }
            if (numK < 1){capturedChess.append("k 1\n");}
            if (numQ < 1){capturedChess.append("q 1\n");}
            if (numR < 2){capturedChess.append("r " + (2-numR) + "\n");}
            if (numB < 2){capturedChess.append("b " + (2-numB) + "\n");}
            if (numN < 2){capturedChess.append("n " + (2-numN) + "\n");}
            if (numP < 8){capturedChess.append("p " + (8-numP) + "\n");}
        }
        return capturedChess.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer == ChessColor.BLACK){
            currentPlayer = ChessColor.WHITE;
        }
        if (currentPlayer == ChessColor.WHITE){
            currentPlayer = ChessColor.BLACK;
        }
        for (ChessboardPoint c : getChess(sourceX,sourceY).canMoveTo()) {
            if (c.getX() == targetX){
                if (c.getY() == targetY){
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',sourceX,sourceY);
                    chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                }
            }
        }
        return false;
    }
}
