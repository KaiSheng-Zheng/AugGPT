import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard){
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', chessComponents);
                        break;
                    case 'r' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', chessComponents);
                        break;
                    case 'N' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', chessComponents);
                        break;
                    case 'n' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', chessComponents);
                        break;
                    case 'B' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', chessComponents);
                        break;
                    case 'b' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', chessComponents);
                        break;
                    case 'Q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', chessComponents);
                        break;
                    case 'q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', chessComponents);
                        break;
                    case 'K' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', chessComponents);
                        break;
                    case 'k' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', chessComponents);
                        break;
                    case 'P' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', chessComponents);
                        break;
                    case 'p' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', chessComponents);
                        break;
                    case '_' :
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', chessComponents);
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
        updateChessComponent(chessComponents);
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder chessboard = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard.append(chessComponents[i][j].name);
            }
            if ( i != 7){
                chessboard.append("\n");
            }
        }
        return chessboard.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        StringBuilder capture = new StringBuilder();
        int k,q,r,b,n,p;

        if (player == ChessColor.BLACK){
            k = countNumber('K');
            q = countNumber('Q');
            r = countNumber('R');
            b = countNumber('B');
            n = countNumber('N');
            p = countNumber('P');
            if (k != 1){
                capture.append("K ").append(1 - k).append("\n");
            }if (q != 1){
                capture.append("Q ").append(1 - q).append("\n");
            }if (r != 2){
                capture.append("R ").append(2 - r).append("\n");
            }if (b != 2){
                capture.append("B ").append(2 - b).append("\n");
            }if (n != 2){
                capture.append("N ").append(2 - n).append("\n");
            }if (p != 8){
                capture.append("P ").append(8 - p).append("\n");
            }

        }else {
            k = countNumber('k');
            q = countNumber('q');
            r = countNumber('r');
            b = countNumber('b');
            n = countNumber('n');
            p = countNumber('p');
            if (k != 1){
                capture.append("k ").append(1 - k).append("\n");
            }if (q != 1){
                capture.append("q ").append(1 - q).append("\n");
            }if (r != 2){
                capture.append("r ").append(2 - r).append("\n");
            }if (b != 2){
                capture.append("b ").append(2 - b).append("\n");
            }if (n != 2){
                capture.append("n ").append(2 - n).append("\n");
            }if (p != 8){
                capture.append("p ").append(8 - p).append("\n");
            }

        }
        return capture.toString();
    }

    public int countNumber(char c){
        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == c){
                    n++;
                }
            }
        }
        return n;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

       canMovePoints.sort(new Comparator<ChessboardPoint>() {
           @Override
           public int compare(ChessboardPoint p1, ChessboardPoint p2) {
               if (p1.getX() > p2.getX()){
                   return 1;
               }else if (p1.getX() < p2.getX()){
                   return -1;
               }else if (p1.getY() > p2.getY()){
                   return 1;
               }else {
                   return -1;
               }
           }
       }
       );
       return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        List<ChessboardPoint> canMovePoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            if (chessComponents[targetX][targetY].getChessColor() == currentPlayer){
                return false;
            }
            if (canMovePoints.size() == 0){
                return false;
            }

            for (int n = 0; n < canMovePoints.size(); n++) {
                if (canMovePoints.get(n).getX() == targetX && canMovePoints.get(n).getY() == targetY){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', chessComponents);
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));

                    if (currentPlayer == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }else if (currentPlayer == ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }
                    updateChessComponent(chessComponents);
                    return true;
                }
            }
        }
        return false;
    }

    public static void updateChessComponent(ChessComponent[][] chessComponents){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'R' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', chessComponents);
                        break;
                    case 'r' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', chessComponents);
                        break;
                    case 'N' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', chessComponents);
                        break;
                    case 'n' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', chessComponents);
                        break;
                    case 'B' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', chessComponents);
                        break;
                    case 'b' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', chessComponents);
                        break;
                    case 'Q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', chessComponents);
                        break;
                    case 'q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', chessComponents);
                        break;
                    case 'K' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', chessComponents);
                        break;
                    case 'k' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', chessComponents);
                        break;
                    case 'P' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', chessComponents);
                        break;
                    case 'p' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', chessComponents);
                        break;
                    case '_' :
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', chessComponents);
                        break;
                }
            }
        }
    }


}