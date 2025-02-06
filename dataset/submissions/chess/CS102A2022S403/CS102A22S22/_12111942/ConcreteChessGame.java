import java.util.ArrayList;
import java.util.List;
public class ConcreteChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        char ch;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ch=chessboard.get(i).charAt(j);
                switch (ch){
                    case'B':
                        BishopChessComponent WBishop=new BishopChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WBishop;
                        break;
                    case'K':
                        KingChessComponent WKing=new KingChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WKing;
                        break;
                    case'N':
                        KnightChessComponent WKnight=new KnightChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WKnight;
                        break;
                    case'P':
                        PawnChessComponent WPawn=new PawnChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WPawn;
                        break;
                    case'Q':
                        QueenChessComponent WQueen=new QueenChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WQueen;
                        break;
                    case'R':
                        RookChessComponent WRook=new RookChessComponent(ChessColor.WHITE);
                        chessComponents[i][j]=WRook;
                        break;
                    case'b':
                        BishopChessComponent BBishop=new BishopChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BBishop;
                        break;
                    case'k':
                        KingChessComponent BKing=new KingChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BKing;
                        break;
                    case'n':
                        KnightChessComponent BKnight=new KnightChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BKnight;
                        break;
                    case'p':
                        PawnChessComponent BPawn=new PawnChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BPawn;
                        break;
                    case'q':
                        QueenChessComponent BQueen=new QueenChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BQueen;
                        break;
                    case'r':
                        RookChessComponent BRook=new RookChessComponent(ChessColor.BLACK);
                        chessComponents[i][j]=BRook;
                        break;
                    case'_':
                        chessComponents[i][j]=new EmptySlotComponent();
                        break;
                }

            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        ArrayList<String> chessboard=new ArrayList<>();
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent chess=chessComponents[i][j];

            }
        }
        return null;
    }
    public String getCapturedChess(ChessColor player){
        return null;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}