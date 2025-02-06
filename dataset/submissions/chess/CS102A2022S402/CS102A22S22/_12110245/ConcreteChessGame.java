import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    private ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    //load chess game from given chessboard
    //import list<String>into component array
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char component1=chessboard.get(i).charAt(j);
                if(component1=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(component1=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(component1=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(component1=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(component1=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(component1=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(component1=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else{
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                }

            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    //print out the chess board as a string
    public String getChessboardGraph() {
        StringBuilder chessBoardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoardGraph.append(chessComponents[i][j].toString());
            }
            if (i < 7) {
                chessBoardGraph.append("\n");
            }
        }
        return chessBoardGraph.toString();
    }

    public String getCapturedChess(ChessColor player) {
//        final int numOfKing = 1;
//        final int numOfQueen = 1;
//        final int numOfRooks = 2;
//        final int numOfBishops = 2;
//        final int numOfKnights = 2;
//        final int numOfPawns = 8;
        int numK_B=0;
        int numK_W=0;
        int numQ_B=0;
        int numQ_W=0;
        int numR_B=0;
        int numR_W=0;
        int numB_B=0;
        int numB_W=0;
        int numN_B=0;
        int numN_W=0;
        int numP_B=0;
        int numP_W=0;
        String a;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a = chessComponents[i][j].toString();
                if (!Objects.equals(a, "_")) {
                    if(Objects.equals(a, "K")){
                        numK_B++;
                    }
                    if(Objects.equals(a, "Q")){
                        numQ_B++;
                    }
                    if(Objects.equals(a, "R")){
                        numR_B++;
                    }
                    if(Objects.equals(a, "B")){
                        numB_B++;
                    }
                    if(Objects.equals(a, "N")){
                        numN_B++;
                    }
                    if(Objects.equals(a, "P")){
                        numP_B++;
                    }
                    if(Objects.equals(a, "k")){
                        numK_W++;
                    }
                    if(Objects.equals(a, "q")){
                        numQ_W++;
                    }
                    if(Objects.equals(a, "r")){
                        numR_W++;
                    }
                    if(Objects.equals(a, "b")){
                        numB_W++;
                    }
                    if(Objects.equals(a, "n")){
                        numN_W++;
                    }
                    if(Objects.equals(a, "p")){
                        numP_W++;
                    }
                }
            }
        }
        if (player == ChessColor.BLACK) {
            StringBuilder capturedChess = new StringBuilder();
            if (numK_B < 1) {
                capturedChess.append("K ").append(1- numK_B).append("\n");
            }
            if (numQ_B < 1) {
                capturedChess.append("Q ").append(1- numQ_B).append("\n");
            }
            if (numR_B< 2) {
                capturedChess.append("R ").append(2 - numR_B).append("\n");
            }
            if (numB_B < 2) {
                capturedChess.append("B ").append(2 - numB_B).append("\n");
            }
            if (numN_B < 2) {
                capturedChess.append("N ").append(2 - numN_B).append("\n");
            }
            if (numP_B < 8) {
                capturedChess.append("P ").append(8 - numP_B).append("\n");
            }
            return capturedChess.toString();
        } else {
            StringBuilder capturedChess = new StringBuilder();
            if (numK_W< 1) {
                capturedChess.append("k ").append(1 - numK_W).append("\n");
            }
            if (numQ_W< 1) {
                capturedChess.append("q ").append(1 - numQ_W).append("\n");
            }
            if (numR_W < 2) {
                capturedChess.append("r ").append(2 - numR_W).append("\n");
            }
            if (numB_W < 2) {
                capturedChess.append("b ").append(2 - numB_W).append("\n");
            }
            if (numN_W < 2) {
                capturedChess.append("n ").append(2 - numN_W).append("\n");
            }
            if (numP_W < 8) {
                capturedChess.append("p ").append(8 - numP_W).append("\n");
            }
            return capturedChess.toString();

        }
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }


}
