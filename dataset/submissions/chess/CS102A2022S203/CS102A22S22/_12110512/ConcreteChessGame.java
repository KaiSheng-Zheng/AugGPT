import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame (){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'K': {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'k': {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'Q': {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'q': {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'R': {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'r': {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'B': {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'b': {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'N': {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'n': {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'P': {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case 'p': {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                    case '_': {
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setName('_');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                        break;
                    }
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }
        else
            this.currentPlayer = ChessColor.BLACK;
    }

    public String getChessboardGraph(){
        StringBuilder ChessboardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (chessComponents[i][j].getName() == 'R')
                    ChessboardGraph.append('R');
                else if (chessComponents[i][j].getName() == 'r')
                    ChessboardGraph.append('r');
                else if (chessComponents[i][j].getName() == 'N')
                    ChessboardGraph.append('N');
                else if (chessComponents[i][j].getName() == 'n')
                    ChessboardGraph.append('n');
                else if (chessComponents[i][j].getName() == 'B')
                    ChessboardGraph.append('B');
                else if (chessComponents[i][j].getName() == 'b')
                    ChessboardGraph.append('b');
                else if (chessComponents[i][j].getName() == 'Q')
                    ChessboardGraph.append('Q');
                else if (chessComponents[i][j].getName() == 'q')
                    ChessboardGraph.append('q');
                else if (chessComponents[i][j].getName() == 'K')
                    ChessboardGraph.append('K');
                else if (chessComponents[i][j].getName() == 'k')
                    ChessboardGraph.append('k');
                else if (chessComponents[i][j].getName() == 'P')
                    ChessboardGraph.append('P');
                else if (chessComponents[i][j].getName() == 'p')
                    ChessboardGraph.append('p');
                else if (chessComponents[i][j].getName() == '_')
                    ChessboardGraph.append('_');
            }
            if (i < 7)
                ChessboardGraph.append('\n');
        }
        return String.valueOf(ChessboardGraph);
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder capturedChess = new StringBuilder();
        if (player == ChessColor.BLACK){
            int K = 1;
            int Q = 1;
            int R = 2;
            int B = 2;
            int N = 2;
            int P = 8;
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    if (chessComponents[i][j].name == 'K')
                        K--;
                    else if (chessComponents[i][j].name == 'Q')
                        Q--;
                    else if (chessComponents[i][j].name == 'R')
                        R--;
                    else if (chessComponents[i][j].name == 'B')
                        B--;
                    else if (chessComponents[i][j].name == 'N')
                        N--;
                    else if (chessComponents[i][j].name == 'P')
                        P--;
                }
            }
            if (K != 0){
                capturedChess.append("K ").append(K).append("\n");
            }
            if (Q != 0){
                capturedChess.append("Q ").append(Q).append("\n");
            }
            if (R != 0){
                capturedChess.append("R ").append(R).append("\n");
            }
            if (B != 0){
                capturedChess.append("B ").append(B).append("\n");
            }
            if (N != 0){
                capturedChess.append("N ").append(N).append("\n");
            }
            if (P != 0){
                capturedChess.append("P ").append(P).append("\n");
            }
        }
        else if (player ==ChessColor.WHITE){
            int k = 1;
            int q = 1;
            int r = 2;
            int b = 2;
            int n = 2;
            int p = 8;
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    if (chessComponents[i][j].name == 'k')
                        k--;
                    else if (chessComponents[i][j].name == 'q')
                        q--;
                    else if (chessComponents[i][j].name == 'r')
                        r--;
                    else if (chessComponents[i][j].name == 'b')
                        b--;
                    else if (chessComponents[i][j].name == 'n')
                        n--;
                    else if (chessComponents[i][j].name == 'p')
                        p--;
                }
            }
            if (k != 0){
                capturedChess.append("k ").append(k).append("\n");
            }
            if (q != 0){
                capturedChess.append("q ").append(q).append("\n");
            }
            if (r != 0){
                capturedChess.append("r ").append(r).append("\n");
            }
            if (b != 0){
                capturedChess.append("b ").append(b).append("\n");
            }
            if (n != 0){
                capturedChess.append("n ").append(n).append("\n");
            }
            if (p != 0){
                capturedChess.append("p ").append(p).append("\n");
            }
        }
        return String.valueOf(capturedChess);
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        ChessComponent chess = this.getChess(source.getX(), source.getY());
        return chess.canMoveTo();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}