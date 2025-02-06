
import java.util.*;

/**
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class ConcreteChessGame implements ChessGame {


    /**
     *  A 2-dimension array to store all the chess components
     *  should be initialized in your construct method.
     *  i.e. = new ChessComponent[8][8]
     */
    private  ChessComponent[][] chessComponents;

    /**
     *   What's the current player's color, black or white?
     *  should be initialized in your construct method.
     *  by default, set the color to white.
     */
    private ChessColor currentPlayer;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private static  HashMap<Character,Integer> defaultNum;
    static{
        defaultNum = new HashMap<>();
        defaultNum.put('R',2);
        defaultNum.put('N',2);
        defaultNum.put('B',2);
        defaultNum.put('Q',1);
        defaultNum.put('K',1);
        defaultNum.put('P',8);

        defaultNum.put('r',2);
        defaultNum.put('n',2);
        defaultNum.put('b',2);
        defaultNum.put('q',1);
        defaultNum.put('k',1);
        defaultNum.put('p',8);
    }



    public ConcreteChessGame() {
        chessComponents = new ChessComponent[7 + 1][7 + 1];
        initDefaultBoard();
    }

    private void initDefaultBoard(){
        String[] defaultGraph = new String[]{
                "RNBQKBNR",
                "PPPPPPPP",
                "________",
                "________",
                "________",
                "________",
                "pppppppp",
                "rnbqkbnr",
                "w"};
        List<String> list = Arrays.asList(defaultGraph);
        loadChessGame(list);
    }

    private ChessComponent createChessPoint(int x,int y,char name){
        ChessboardPoint point = new ChessboardPoint(x,y);
        if(Character.isUpperCase(name)){
            switch (name){
                case 'R':
                    return new RookChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
                case 'N':
                    return new KnightChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
                case 'B':
                    return new BishopChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
                case 'Q':
                    return new QueenChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
                case 'K':
                    return new KingChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
                case 'P':
                    return new PawnChessComponent(point,ChessColor.BLACK,name,this.chessComponents);
            }
        }
        else {
            switch (name){
                case 'r':
                    return new RookChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case 'n':
                    return new KnightChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case 'b':
                    return new BishopChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case 'q':
                    return new QueenChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case 'k':
                    return new KingChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case 'p':
                    return new PawnChessComponent(point,ChessColor.WHITE,name,this.chessComponents);
                case '_':
                    return new PawnChessComponent(point,ChessColor.NONE,name,this.chessComponents);
            }
        }
        return null;
    }
    /**
     *
     */


    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0; i < chessboard.size() - 1; ++i){
            String s = chessboard.get(i);
            for(int j = 0; j < s.length(); ++j) {
                chessComponents[i][j] = createChessPoint(i,j,s.charAt(j));
            }
        }
        String p = chessboard.get(chessboard.size() - 1);
        if(p.equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        if(p.equals("B")) {
            this.currentPlayer = ChessColor.BLACK;
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

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i <= 7; ++i){
            for(int j = 0; j <= 7; ++j){
              //  System.out.println(i + " " + j);
                sb.append(chessComponents[i][j].name);
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int[] bucket = new int[300];

        for(int i = 0; i <= 7; ++i){
            for(int j = 0; j <= 7; ++j){
                char name = chessComponents[i][j].name;
                bucket[name]++;
            }
        }
        String check,order;
        if(player.equals(ChessColor.BLACK)) {check = "RNBQKP"; order = "KQRBNP";}
        else {
            check = "rnbqkp";
            order = "kqrbnp";
        }

        return printCapture(check,bucket,order);
    }


    private String printCapture(String check,int[] bucket,String order){
        StringBuilder sb = new StringBuilder("");

        List<String>li = new ArrayList<>();

        for(int i = 0; i < check.length(); ++i){
            char c = check.charAt(i);
            Integer t = defaultNum.get(c);
            String temp = "";
            if(t - bucket[c] != 0){
                temp += c + " ";
                temp += (t - bucket[c]);
                temp += "\n";
                li.add(temp);
            }
        }
        for(int i = 0; i < order.length(); ++i){
            for(String s : li) if(s.charAt(0) == order.charAt(i)) sb.append(s);
        }

        return sb.toString();
    }
    /**
     * This  method returns all the points that chess piece at "source" point can move to
     */

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);

        // 1. find chess according to source
        ChessComponent chess = chessComponents[source.getX()][source.getY()];

        // 2. as below statement:

        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        // 3.sort canMovePoints by x - y ascending order
        canMovePoints.sort((e1,e2) -> {
            if(e1.getX() != e2.getX()) return e1.getX() - e2.getX();
            return e1.getY() - e2.getY();
        });

        return canMovePoints;
    }

    /**
     * This  method returns whether a chess piece at source can move to target.
     * Detailed method is shown as follows
     */
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessboard(chessComponents);

        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer ){
            return false;
        }
        if (!chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
            return false;
        }
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source = new ChessboardPoint(targetX,targetY);
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
        if (currentPlayer==ChessColor.WHITE){
            currentPlayer = ChessColor.BLACK;
        }
        else{
            currentPlayer = ChessColor.WHITE;
        }
        return true;
    }

    private void swap(ChessComponent o1,ChessComponent o2){
        ChessComponent temp = o2;
        int x1 = o1.getSource().getX();
        int y1 = o1.getSource().getY();
        int x2 = o2.getSource().getY();
        int y2 = o2.getSource().getY();

        o1.getSource().setX(x2);
        o1.getSource().setY(y2);
        chessComponents[x2][y2] = o1;
        chessComponents[x1][y1] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(x1,y1));
        getChessboardGraph();
    }

    private boolean checkout(int location){
        return location >= 0 && location <= 7;
    }
}

