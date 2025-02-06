import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;
    private static ChessComponent[][] staticChessComponents;

    public void loadChessGame(List<String> chessboard){
        for(int i = 0;i < 8;i++) {
            for(int j = 0;j < 8;j++){
                switch(chessboard.get(i).charAt(j)){
                    case 'R':
                        this.chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,i,j,'R');
                        break;
                    case 'r':
                        this.chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,i,j,'r');
                        break;
                    case 'N':
                        this.chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,i,j,'N');
                        break;
                    case 'n':
                        this.chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,i,j,'n');
                        break;
                    case 'B':
                        this.chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,i,j,'B');
                        break;
                    case 'b':
                        this.chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,i,j,'b');
                        break;
                    case 'Q':
                        this.chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,i,j,'Q');
                        break;
                    case 'q':
                        this.chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,i,j,'q');
                        break;
                    case 'K':
                        this.chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,i,j,'K');
                        break;
                    case 'k':
                        this.chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,i,j,'k');
                        break;
                    case 'P':
                        this.chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,i,j,'P');
                        break;
                    case 'p':
                        this.chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,i,j,'p');
                        break;
                    default :
                        this.chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,i,j,'_');
                        break;
                }
            }
        }
        staticChessComponents = chessComponents;
        if(chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        String[] result = {"","","","","","","",""};
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++) {
                result[i] = result[i] + chessComponents[i][j];
            }
        }
        return result[0] + "\n" + result[1] + "\n" + result[2] + "\n" + result[3] + "\n" + result[4] + "\n" + result[5] + "\n" + result[6] + "\n" + result[7];
    }

    public String getCapturedChess(ChessColor player){
        int P = 8,R = 2,N = 2,B = 2,Q = 1,K = 1,p = 8,r = 2,n = 2,b = 2,q = 1,k = 1;
        if(player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].toString()) {
                        case "P":
                            P--;
                            break;
                        case "R":
                            R--;
                            break;
                        case "N":
                            N--;
                            break;
                        case "B":
                            B--;
                            break;
                        case "Q":
                            Q--;
                            break;
                        case "K":
                            K--;
                            break;
                        default:
                            break;
                    }
                }
            }
            String result = "";
            if (K != 0) {
                result+=String.format("K %s\n",K);
            }
            if(Q != 0){
                result+=String.format("Q %s\n",Q);
            }
            if(R != 0){
                result+=String.format("R %s\n",R);
            }
            if(B != 0){
                result+=String.format("B %s\n",B);
            }
            if(N != 0){
                result+=String.format("N %s\n",N);
            }
            if(P != 0){
                result+=String.format("P %s\n",P);
            }
            return result;
        }else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].toString()) {
                        case "p":
                            p--;
                            break;
                        case "r":
                            r--;
                            break;
                        case "n":
                            n--;
                            break;
                        case "b":
                            b--;
                            break;
                        case "q":
                            q--;
                            break;
                        case "k":
                            k--;
                            break;
                        default:
                            break;
                    }
                }
            }
            String result = "";
            if (k != 0) {
                result+=String.format("k %s\n",k);
            }
            if(q != 0){
                result+=String.format("q %s\n",q);
            }
            if(r != 0){
                result+=String.format("r %s\n",r);
            }
            if(b != 0){
                result+=String.format("b %s\n",b);
            }
            if(n != 0){
                result+=String.format("n %s\n",n);
            }
            if(p != 0){
                result+=String.format("p %s\n",p);
            }
            return result;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
            // 1. find chess according to source
            ChessComponent chess = getChess(source.getX(), source.getY());
            // 2. as below statement:
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            // 3.sort canMovePoints by x - y ascending order
            canMovePoints = canMovePoints.stream().sorted(Comparator.comparing(ChessboardPoint::getX)).collect(Collectors.toList());
            ArrayList<ChessboardPoint> resultCanMovePoints = new ArrayList<>();
            ArrayList<List> splitCanMovePoints = new ArrayList<>();
            ArrayList<ChessboardPoint> firstChessboardPoints = new ArrayList<>();
            if (canMovePoints.size() == 0) {
                return canMovePoints;
            } else {
                firstChessboardPoints.add(canMovePoints.get(0));
                splitCanMovePoints.add(firstChessboardPoints);
                int counter = 0;
                for (int i = 1; i < canMovePoints.size(); i++) {
                    if (canMovePoints.get(i).getX() == canMovePoints.get(i - 1).getX()) {
                        splitCanMovePoints.get(counter).add(canMovePoints.get(i));
                    } else {
                        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
                        chessboardPoints.add(canMovePoints.get(i));
                        splitCanMovePoints.add(chessboardPoints);
                        counter++;
                    }
                }
                for (int i = 0; i < splitCanMovePoints.size(); i++) {
                    List<ChessboardPoint> sortedChessboardPoints = new ArrayList<>();
                    sortedChessboardPoints = splitCanMovePoints.get(i);
                    sortedChessboardPoints = sortedChessboardPoints.stream().sorted(Comparator.comparing(ChessboardPoint::getY)).collect(Collectors.toList());
                    for (int j = 0; j < splitCanMovePoints.get(i).size(); j++) {
                        resultCanMovePoints.add(sortedChessboardPoints.get(j));
                    }
                }
                return resultCanMovePoints;
            }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer()) {
            List<ChessboardPoint> canMoveTo = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
            int counter = 0;
            for (int i = 0; i < canMoveTo.size(); i++) {
                if (targetX == canMoveTo.get(i).getX()&&targetY == canMoveTo.get(i).getY()) {
                    counter++;
                    ChessComponent sourcePoint = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY] = sourcePoint;
                    staticChessComponents[targetX][targetY] = sourcePoint;
                    chessComponents[targetX][targetY].setSource(targetX,targetY);
                    staticChessComponents[targetX][targetY].setSource(targetX,targetY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, sourceX, sourceY, '_');
                    staticChessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, sourceX, sourceY, '_');
                    if(getCurrentPlayer() == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }else{
                        currentPlayer = ChessColor.BLACK;
                    }
                    break;
                }
            }
            //System.out.println(counter);
            if (counter > 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static ChessComponent[][] getChessComponent(){
        return staticChessComponents;
    }
}