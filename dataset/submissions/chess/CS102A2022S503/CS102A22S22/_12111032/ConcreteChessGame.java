import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ArrayList<String> chessboard = new ArrayList<>();
    private ChessColor currentPlayer;
    public static ChessComponent[][] a = new ChessComponent[8][8];

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
//        chessboard.add("RNBQKBNR");
//        chessboard.add("PPPPPPPP");
//        for (int i = 0; i < 4; i++) {
//            chessboard.add("________");
//        }
//        chessboard.add("pppppppp");
//        chessboard.add("rnbqkbnr");
//        chessboard.add("w");
//        chessboard.add("b");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        break;
                }
            }
//
        }
        a = chessComponents;
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    //    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        String graph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                graph +=chessComponents[i][j].getName();
            }
            graph += "\n";
        }
       return graph;
    }
@Override
    public String getCapturedChess(ChessColor player) {
        int[] lost = {0,0,0,0,0,0};
        int[] live = {1, 1, 2, 2, 2, 8};
        char[] name1 = {'K', 'Q', 'R', 'B', 'N', 'P'};
        char[] name2 = {'k', 'q', 'r', 'b', 'n', 'p'};
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        lost[0] += 1;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        lost[1] += 1;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        lost[2] += 1;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        lost[3] += 1;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        lost[4] += 1;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        lost[5] += 1;
                    }
                }
            }
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        lost[0] += 1;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        lost[1] += 1;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        lost[2] += 1;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        lost[3] += 1;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        lost[4] += 1;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        lost[5] += 1;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (lost[i] != live[i]) {
                    result.append(name1[i]);
                    result.append(' ');
                    result.append(live[i]-lost[i]);
                    result.append('\n');
                }
            }
        } else {
            for (int i = 0; i < 6; i++) {
                if (lost[i] != live[i]) {
                    result.append(name2[i]);
                    result.append(' ');
                    result.append(live[i]-lost[i]);
                    result.append('\n');
                }
            }
//            String answer = "K " + lost[0] + "\n" + "Q " + lost[1] +"\n" +"R " + lost[2] + "\n" + "B " + lost[3] + "\n" + "N " + lost[4] + "\n" + "P " + lost[5] + "\n";
//        }else {
//            String answer = "k " + lost[0] + "\n" + "q " + lost[1] + "\n" + "r " + lost[2] + "\n" + "b " + lost[3] + "\n" + "n" + lost[4] + "\n" + "p " + lost[5] + "\n";
//        }
        }
        return result.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public static ChessComponent[][] geta() {
        return a;
    }

   
 public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer() == getChessComponents()[sourceX][sourceY].getChessColor()) {
            List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX ,sourceY ));
            if(move.size()==0){return false;}
            for (int i = 0; i < move.size(); i++) {
                if (move.get(i).getX() == targetX && move.get(i).getY() == targetY) {
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                    a[sourceX][sourceY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    a[targetX][targetY] = a[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    a[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    if (getCurrentPlayer() == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            } return false;
        }
        return false;
    }
public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int sourceX = source.getX();
        int sourceY = source.getY();
        List<ChessboardPoint> canMovePoints =getChessComponents()[sourceX][sourceY].canMoveTo();
        //System.out.println(canMovePoints);
        if(canMovePoints.size()==0){return new ArrayList<>();}
        List<ChessboardPoint> answer = new ArrayList<>();
        int[] x = new int[canMovePoints.size()];
        int[] y = new int[canMovePoints.size()];
        //List<Integer> l = new ArrayList<Integer>();
        int[] distance = new int[canMovePoints.size()];
        for (int i = 0; i < canMovePoints.size(); i++) {
            x[i] = canMovePoints.get(i).getX();
            y[i] = canMovePoints.get(i).getY();
            distance[i] = 10 * x[i] + y[i];
            //l.add(10 * x[i] + y[i]);
        }
        Arrays.sort(distance);
//        for (int i = 0; i <distance.length ; i++) {
//            System.out.println(distance[i]);
//        }

        for (int i = 0; i < canMovePoints.size(); i++) {
            int x1=0;
            int y1=0;
            if(distance[i]<10){y1=distance[i];x1=0;}else{
                y1=distance[i] % 10;
                x1=(distance[i] )/ 10;
            }
            answer.add(new ChessboardPoint(x1 ,y1 ));
//            if (distance[i] % 10 == y[i] && distance[i] - y[i] / 10 == x[i]) {
//                answer.add(new ChessboardPoint(x[i], y[i]));
//            }
        }
//        System.out.println("answer:" + answer);
        return answer;
    }
}
