import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]

    private static ChessComponent[][] chessComponents;
    //private ChessComponent[][] chessComponents;

    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int x = 0;x<8;x++){
            for (int y = 0;y<8;y++){
                chessComponents[x][y] = setChessComponent(chessboard.get(x).charAt(y), new ChessboardPoint(x,y));
            }
        }
        setCurrentPlayer(chessboard.get(8));
    }
    //there is a w/b left
    public void setCurrentPlayer(String color) {
        if (color.equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }else if (color.equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    private ChessComponent setChessComponent(char name,ChessboardPoint source){//add Chess with name and position
        if (name == 'P' | name == 'p'){
            return new PawnChessComponent(name,source);
        }else if (name == 'K' | name == 'k'){
            return new KingChessComponent(name,source);
        }else if (name == 'Q' | name == 'q'){
            return new QueenChessComponent(name,source);
        }else if (name == 'B' | name == 'b'){
            return new BishopChessComponent(name,source);
        }else if (name == 'N' | name == 'n'){
            return new KnightChessComponent(name,source);
        }else if (name == 'R' | name == 'r'){
            return new RookChessComponent(name,source);
        }else {
            return new EmptySlotComponent('_',source);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    //design for T4
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        // 1. find chess according to source
        ChessComponent chess = getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints(canMovePoints);
    }
    //design for T4
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        boolean flagForMoveChess = false;
        ChessComponent chess = getChess(sourceX,sourceY);
        for (int i = 0;i<chess.canMoveTo().size();i++){
            if (chess.canMoveTo().get(i).getX()==targetX && chess.canMoveTo().get(i).getY()==targetY){
                flagForMoveChess = true;
            }
        }
        if (flagForMoveChess && getCurrentPlayer().equals(chess.getChessColor())){
            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY));
            chessComponents[targetX][targetY] = setChessComponent(chess.name,new ChessboardPoint(targetX,targetY));
            if (chess.getChessColor().equals(ChessColor.BLACK)){setCurrentPlayer("w");}else {setCurrentPlayer("b");}
            return true;
        }else {return false;}
    }

    public String getChessboardGraph(){//use this method to print the situation of the game
        StringBuilder sb = new StringBuilder();
        for (int x = 0;x<8;x++){
            for (int y = 0;y<8;y++){
                sb.append(chessComponents[x][y]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public String getCapturedChess(ChessColor player){
        //{1, 1, 2, 2, 2, 8}
        int[] whiteArr = new int[]{1, 0, 0, 0, 0, 0};
        int[] blackArr = new int[]{1, 0, 0, 0, 0, 0};
        for (int x = 0;x<8;x++){
            for (int y = 0;y<8;y++) {
                if (chessComponents[x][y].getName() == 'q'){
                    whiteArr[1]++;
                }else if (chessComponents[x][y].getName() == 'r'){
                    whiteArr[2]++;
                }else if (chessComponents[x][y].getName() == 'b'){
                    whiteArr[3]++;
                }else if (chessComponents[x][y].getName() == 'n'){
                    whiteArr[4]++;
                }else if (chessComponents[x][y].getName() == 'p'){
                    whiteArr[5]++;
                }else if (chessComponents[x][y].getName() == 'Q'){
                    blackArr[1]++;
                }else if (chessComponents[x][y].getName() == 'R'){
                    blackArr[2]++;
                }else if (chessComponents[x][y].getName() == 'B'){
                    blackArr[3]++;
                }else if (chessComponents[x][y].getName() == 'N'){
                    blackArr[4]++;
                }else if (chessComponents[x][y].getName() == 'P'){
                    blackArr[5]++;
                }
            }
        }
        if (player == ChessColor.WHITE){
            return whiteChessBox(whiteArr);
        }else if (player == ChessColor.BLACK){
            return blackChessBox(blackArr);
        }else {return null;}
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String whiteChessBox(int[] whiteArr){
        StringBuilder sb = new StringBuilder();
        if (whiteArr[1] != 1){sb.append("q 1\n");}
        if (whiteArr[2] != 2){
            int lostR = 2 - whiteArr[2];
            sb.append("r ").append(lostR).append('\n');
        }
        if (whiteArr[3] != 2){
            int lostB = 2 - whiteArr[3];
            sb.append("b ").append(lostB).append('\n');
        }
        if (whiteArr[4] != 2){
            int lostN = 2 - whiteArr[4];
            sb.append("n ").append(lostN).append('\n');
        }
        if (whiteArr[5] != 8){
            int lostP = 8 - whiteArr[5];
            sb.append("p ").append(lostP).append('\n');
        }
        return sb.toString();
    }

    public String blackChessBox(int[] blackArr){
        StringBuilder sb = new StringBuilder();
        if (blackArr[1] != 1){sb.append("Q 1\n");}
        if (blackArr[2] != 2){
            int lostR = 2 - blackArr[2];
            sb.append("R ").append(lostR).append('\n');
        }
        if (blackArr[3] != 2){
            int lostB = 2 - blackArr[3];
            sb.append("B ").append(lostB).append('\n');
        }
        if (blackArr[4] != 2){
            int lostN = 2 - blackArr[4];
            sb.append("N ").append(lostN).append('\n');
        }
        if (blackArr[5] != 8){
            int lostP = 8 - blackArr[5];
            sb.append("P ").append(lostP).append('\n');
        }
        return sb.toString();
    }

    /*
    public static ChessComponent[][] getChessComponents() {
        ChessComponent[][] c = new ChessComponent[8][8];
        c = chessComponents;
        return c;
    }

     */
    public static ChessComponent[][] getChessComponents() {return chessComponents;}

    private List<ChessboardPoint> canMovePoints(List<ChessboardPoint> canMovePoints){
     ArrayList<ChessboardPoint> points= new ArrayList<>();
     for (int x = 0;x<8;x++){
         for (int y = 0;y<8;y++){
             for (int i = 0;i<canMovePoints.size();i++){
                 if (canMovePoints.get(i).getX() == x && canMovePoints.get(i).getY() == y){
                     points.add(new ChessboardPoint(x,y));
                 }
             }
         }
     }
     return points;
    }
}
