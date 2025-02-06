import java.util.List;
import java.util.Map;

public class ConcreteChessGame extends ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private String[] bname = {"K","Q","R","B","N","P"};
    private String[] wname = {"k","q","r","b","n","p"};
    private Map<String, Integer> black_loses;
    private Map<String, Integer> white_loses;
    private char empty = '_';

    void loadChessGame(List<String> chessboard){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char temp = chessboard.get(i).charAt(j);
                switch (temp){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'P':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BLACK,temp);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    case 'p':
                        chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE,temp);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(i,j,ChessColor.NONE,temp);
                        break;
                }

            }
        }
            }

            @Override
            public ChessColor getCurrentPlayer(){
                return this.currentPlayer;
            }

    @Override
    ChessComponent getChess(int x, int y) {
        if(x >= 8 || x < 0 || y >= 8 || y < 0){
            System.out.println("index error!");
            return null;
        }
        else
            return this.chessComponents[x][y];
    }

    @Override
    String getChessboardGraph() {
        return null;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = "";
        if(player == ChessColor.WHITE){
            for(String a :wname){
                int w = white_loses.get(a);
                if (w > 0){
                    s += a + " " + w + "\n";
                }
            }
        }
        else{
            for (String a :bname){
                int w =black_loses.get(a);
                if(w>0) {
                    s += a + " " + w + "\n";
                }
            }
        }
        return s;
    }

    @Override
    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    @Override
    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }


}
