import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessColor c){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = c;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'N':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'B':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'Q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'K':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'P':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),
                                ChessColor.BLACK);
                        break;
                    case 'r':
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;
                    case 'n':
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;
                    case 'b':
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;
                    case 'q':
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;
                    case 'k':
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;
                    case 'p':
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j),
                                ChessColor.WHITE);
                        break;

                    case '_':
                        this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j),
                                ChessColor.NONE);
                        break;

                    default:
                        break;
                }
            }
        }
    };

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder res = new StringBuilder();

        for (ChessComponent row[] : chessComponents) {
            for (ChessComponent c : row) {
                res.append(c.toString());
            }
            res.append('\n');
        }

        return res.substring(0, res.length() - 1);
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder res = new StringBuilder();

        return res.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x - 1][y - 1];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint c) {
        return new ArrayList<ChessboardPoint>();
        chessComponents[1][1]=new KingChessComponent.canMoveTo();
    }

    public boolean moveChess(int i,int j,int k,int l){
        return true;
    }
}
