import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    private ChessComponent setChessComponent(char X, ChessboardPoint point){
        switch (X){
            case 'p'|'P':
                return new PawnChessCompoent(X,point);
            case 'k'|'K':
                return new KingChessComponent(X,point);
            case 'n'|'N':
                return new KnightChessCompoent(X,point);
            case 'q'|'Q':
                return new QueeenChessCompoent(X,point);
            case 'b'|'B':
                return new BishopChessCompoent(X,point);
            case 'r'|'R':
                return new RookChessCompoent(X,point);
            default:
                return new EmptySlotComponent(X,point);
        }
    }
    private void setCurrentPlayer(char X ){
        switch (X){
            case 'w':
                this.currentPlayer = ChessColor.WHITE;
                break;
            case 'b':
                this.currentPlayer = ChessColor.BLACK;
                break;
            default:
                this.currentPlayer = ChessColor.NONE;
                break;
        }
    }

//

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                chessComponents[i][j] = setChessComponent(chessboard.get(i).charAt(j),new ChessboardPoint(i,j));
            }
        }
        setCurrentPlayer(chessboard.get(8).charAt(0));
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                builder.append(chessComponents[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

//
    private String printChess(int[] x,int y){
        StringBuilder builder = new StringBuilder();

        if (y == 0) {
            if (x[0] != 1) {
                builder.append("k 1\n");
            }
            if (x[1] != 1) {
                builder.append("q 1\n");
            }
            if (x[2] != 2) {
                int x2 = 2 - x[2];
                builder.append("r ").append(x2).append("\n");
            }
            if (x[3] != 2) {
                int x3 = 2 - x[3];
                builder.append("b ").append(x3).append("\n");
            }
            if (x[4] != 2) {
                int x4 = 2 - x[4];
                builder.append("n ").append(x4).append("\n");
            }
            if (x[5] != 8) {
                int x5 = 8 - x[5];
                builder.append("p ").append(x5).append("\n");
            }
        }else {
            if (x[0] != 1) {
                builder.append("K 1\n");
            }
            if (x[1] != 1) {
                builder.append("Q 1\n");
            }
            if (x[2] != 2) {
                int x2 = 2 - x[2];
                builder.append("R ").append(x2).append("\n");
            }
            if (x[3] != 2) {
                int x3 = 2 - x[3];
                builder.append("B ").append(x3).append("\n");
            }
            if (x[4] != 2) {
                int x4 = 2 - x[4];
                builder.append("N ").append(x4).append("\n");
            }
            if (x[5] != 8) {
                int x5 = 8 - x[5];
                builder.append("P ").append(x5).append("\n");
            }

        }
        return builder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] whiteChessExisted = new  int[]{0,0,0,0,0,0};
        int[] blackChessExisted = new  int[]{0,0,0,0,0,0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (getChess(i,j).getName()){
                    case 'k':
                        whiteChessExisted[0] = 1;
                        break;
                    case 'K':
                        blackChessExisted[0] = 1;
                        break;
                    case 'q':
                        whiteChessExisted[1] = 1;
                        break;
                    case 'Q':
                        blackChessExisted[1] = 1;
                        break;
                    case 'r':
                        whiteChessExisted[2]+=1;
                        break;
                    case 'R':
                        blackChessExisted[2]+=1;
                        break;
                    case 'b':
                        whiteChessExisted[3]+=1;
                        break;
                    case 'B':
                        blackChessExisted[3]+=1;
                        break;
                    case 'n':
                        whiteChessExisted[4]+=1;
                        break;
                    case 'N':
                        blackChessExisted[4]+=1;
                        break;
                    case 'p':
                        whiteChessExisted[5]+=1;
                        break;
                    case 'P':
                        blackChessExisted[5]+=1;
                        break;
                    default:
                        break;
                }
            }
        }
            if (player == ChessColor.WHITE){
                return printChess(whiteChessExisted,0);
            }
            else if(player == ChessColor.BLACK){
                return printChess(blackChessExisted,1);
            }
            else {
                return null;
            }

        }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

}