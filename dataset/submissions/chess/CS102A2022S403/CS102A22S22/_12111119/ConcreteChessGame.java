import java.util.*;

public class ConcreteChessGame implements ChessGame {

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    @Override
    public String toString() {
        return getChessboardGraph();
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE, this);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, this);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, this);
                        break;
                }
            }
            if (chessboard.get(8).charAt(0) == 'w') currentPlayer = ChessColor.WHITE;
            else currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    private String haha(ChessComponent[] cp){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 8 ; i ++){
            sb.append(cp[i]);
        }
        return String.valueOf(sb);
    }

    @Override
    public String getChessboardGraph() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
               haha(chessComponents[0]),
               haha(chessComponents[1]),
               haha(chessComponents[2]),
               haha(chessComponents[3]),
               haha(chessComponents[4]),
               haha(chessComponents[5]),
               haha(chessComponents[6]),
               haha(chessComponents[7])
                );
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 0, K = 0, q = 0, Q =0 , b =0 , B = 0, n =0 , N= 0, r=0 , R=0 , p=0 , P=0;
        StringBuilder result = new StringBuilder();
        if (player == ChessColor.BLACK){
            for (int row = 0 ; row < 8 ; row++){
                for (ChessComponent temp:chessComponents[row]){
                    switch (temp.name){
                        case 'k':
                        case '_':
                        case 'p':
                        case 'r':
                        case 'n':
                        case 'q':
                        case 'b':
                            break;
                        case 'K':
                            K++;
                            break;
                        case 'Q':
                            Q++;
                            break;
                        case 'B':
                            B++;
                            break;
                        case 'N':
                            N++;
                            break;
                        case 'R':
                            R++;
                            break;
                        case 'P':
                            P++;
                            break;
                    }
                }
            }
            if (K!=1) result.append("K ").append(1 - K).append("\n");
            if (Q!=1) result.append("Q ").append(1 - Q).append("\n");
            if (R!=2) result.append("R ").append(2 - R).append("\n");
            if (B!=2) result.append("B ").append(2 - B).append("\n");
            if (N!=2) result.append("N ").append(2 - N).append("\n");
            if (P!=8) result.append("P ").append(8 - P).append("\n");
        }else {
            for (int row = 0 ; row < 8 ; row++){
                for (ChessComponent temp:chessComponents[row]){
                    switch (temp.name){
                        case 'K':
                        case '_':
                        case 'P':
                        case 'R':
                        case 'N':
                        case 'B':
                        case 'Q':
                            break;
                        case 'k':
                            k++;
                            break;
                        case 'q':
                            q++;
                            break;
                        case 'b':
                            b++;
                            break;
                        case 'n':
                            n++;
                            break;
                        case 'r':
                            r++;
                            break;
                        case 'p':
                            p++;
                            break;
                    }
                }
            }
            if (k!=1) result.append("k ").append(1 - k).append("\n");
            if (q!=1) result.append("q ").append(1 - q).append("\n");
            if (r!=2) result.append("r ").append(2 - r).append("\n");
            if (b!=2) result.append("b ").append(2 - b).append("\n");
            if (n!=2) result.append("n ").append(2 - n).append("\n");
            if (p!=8) result.append("p ").append(8 - p).append("\n");
        }
        return String.valueOf(result);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent cp = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = cp.canMoveTo();
        ChessboardPoint temp;
        boolean flag = true;
        for (int i = 0 ; i < canMovePoints.size() ; i++){
            for (int j = 0 ; j < canMovePoints.size()-1-i ; j++){
                if (canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    temp = canMovePoints.get(j);
                    canMovePoints.set(j, canMovePoints.get(j+1));
                    canMovePoints.set(j+1, temp);
                    flag = false;
                }else if (canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()){
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j+1));
                        canMovePoints.set(j+1, temp);
                        flag = false;
                    }
                }
            }
            if (flag){
                break;
            }else{
                flag = true;
            }
        }
        return canMovePoints;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()){
            ChessComponent chess1 = chessComponents[sourceX][sourceY];
            ChessComponent chess2 = chessComponents[targetX][targetY];
            for (ChessboardPoint point : getCanMovePoints(chess1.getChessboardPoint())){
                if (point.getX() == targetX && point.getY() == targetY){
                    if (!(chess2 instanceof EmptySlotComponent)) {
                        chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), ChessColor.NONE, this);
                    }
                    chess1.swapLocation(chess2);
                    int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
                    chessComponents[row1][col1] = chess1;
                    int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
                    chessComponents[row2][col2] = chess2;
                    currentPlayer = (currentPlayer==ChessColor.BLACK) ? ChessColor.WHITE : ChessColor.BLACK;
                    return true;
                }
            }
        }
        return false;
    }
}
