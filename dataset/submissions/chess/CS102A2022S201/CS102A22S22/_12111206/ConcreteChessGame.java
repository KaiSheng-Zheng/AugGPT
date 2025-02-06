import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private HashMap<ChessComponent, Character> reflect= new HashMap<>();
    /*public ChessComponent bigKing = new KingChessComponent(ChessColor.BLACK);
    private ChessComponent smallKing = new KingChessComponent(ChessColor.WHITE);
    private ChessComponent bigQueen = new QueenChessComponent(ChessColor.BLACK);
    private ChessComponent smallQueen = new QueenChessComponent (ChessColor.WHITE);
    private ChessComponent bigRook = new RookChessComponent(ChessColor.BLACK);
    private ChessComponent smallRook = new RookChessComponent(ChessColor.WHITE);
    private ChessComponent bigBishop = new BishopChessComponent(ChessColor.BLACK);
    private ChessComponent smallBishop = new BishopChessComponent(ChessColor.WHITE);
    private ChessComponent bigKnight = new KnightChessComponent(ChessColor.BLACK);
    private ChessComponent smallKnight = new KnightChessComponent(ChessColor.WHITE);
    private ChessComponent bigPawn = new PawnChessComponent(ChessColor.BLACK);
    private ChessComponent smallPawn = new PawnChessComponent(ChessColor.WHITE);
    private ChessComponent empty = new EmptySlotComponent(ChessColor.NONE);*/
    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        if(chessboard.get(8).equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j) == 'R'){
                     chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                     //chessComponents[i][j].setChessBoard(chessComponents);
                     reflect.put(chessComponents[i][j], 'R');
                }else if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'r');
                } else if(chessboard.get(i).charAt(j) == 'N' ){
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'N');
                }else if(chessboard.get(i).charAt(j) == 'n' ) {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'n');
                }else if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'B');
                }else if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'b');
                } else if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'Q');
                }else if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'q');
                } else if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'K');
                }else if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'k');
                } else if(chessboard.get(i).charAt(j) == 'P' ){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'P');
                }else if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i , j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], 'p');
                }
                else {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i,j));
                    //chessComponents[i][j].setChessBoard(chessComponents);
                    reflect.put(chessComponents[i][j], '_');
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessBoard(chessComponents);
            }
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph(){
        String result = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result += String.valueOf(reflect.get(chessComponents[i][j]));
            }
            result += "\n";
        }
        return result;
    }
    @Override
    public String getCapturedChess(ChessColor player){
        int numOfKing = 0; int numOfQueen = 0; int numOfRook = 0; int numOfBishop = 0;
        int numOfKnight = 0; int numOfPawn = 0;
        if(player == ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(reflect.get(chessComponents[i][j]) == 'R') numOfRook++;
                    if(reflect.get(chessComponents[i][j]) == 'K') numOfKing++;
                    if(reflect.get(chessComponents[i][j]) == 'Q') numOfQueen++;
                    if(reflect.get(chessComponents[i][j]) == 'B') numOfBishop++;
                    if(reflect.get(chessComponents[i][j]) == 'N') numOfKnight++;
                    if(reflect.get(chessComponents[i][j]) == 'P') numOfPawn++;
                }
            }
            String result = "";
            if(numOfKing == 0) result += "K 1\n";
            if(numOfQueen == 0) result += "Q 1\n";
            if(numOfRook < 2) result += "R " + (2-numOfRook) + "\n";
            if (numOfBishop < 2) result += "B " + (2-numOfBishop) + "\n";
            if (numOfKnight < 2) result += "N " + (2-numOfKnight) + "\n";
            if(numOfPawn < 8) result += "P " + (8-numOfPawn) + "\n";
            return result;
        }else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(reflect.get(chessComponents[i][j]) == 'r') numOfRook++;
                    if(reflect.get(chessComponents[i][j]) == 'k') numOfKing++;
                    if(reflect.get(chessComponents[i][j]) == 'q') numOfQueen++;
                    if(reflect.get(chessComponents[i][j]) == 'b') numOfBishop++;
                    if(reflect.get(chessComponents[i][j]) == 'n') numOfKnight++;
                    if(reflect.get(chessComponents[i][j]) == 'p') numOfPawn++;
                }
            }
            String result = "";
            if(numOfKing == 0) result += "k 1\n";
            if(numOfQueen == 0) result += "q 1\n";
            if(numOfRook < 2) result += "r " + (2-numOfRook) + "\n";
            if (numOfBishop < 2) result += "b " + (2-numOfBishop) + "\n";
            if (numOfKnight < 2) result += "n " + (2-numOfKnight) + "\n";
            if(numOfPawn < 8) result += "p " + (8-numOfPawn) + "\n";
            return result;
        }
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> sortList = new ArrayList<>();
        int len = chess.canMoveTo().size();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < len; k++) {
                    if(chess.canMoveTo().get(k).getX() == i && chess.canMoveTo().get(k).getY() == j){
                        sortList.add(chess.canMoveTo().get(k));
                    }
                }
            }
        }
        return sortList;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chess = getChess(sourceX, sourceY);
        ChessComponent substitution1;
        if(chess.getChessColor() != this.currentPlayer) {
            return false;
        }else {
            for (int i = 0; i < chess.canMoveTo().size(); i++) {
                if(chess.canMoveTo().get(i).getX() == targetX && chess.canMoveTo().get(i).getY() == targetY){
                    substitution1 = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(sourceX, sourceY));
                    reflect.put(chessComponents[sourceX][sourceY],'_');
                    substitution1.setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[targetX][targetY] = substitution1;
                    if(this.currentPlayer == ChessColor.BLACK){
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    else {
                        this.currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
            return false;
        }
    }
    
}
