import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for(int i = 0 ; i < 8 ; i ++ ) {
            for (int j = 0; j < 8 ; j++) {
                if(chessboard.get(i).charAt(j) == 'n') {
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'n';
                    KnightChessComponent chess = new KnightChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'N'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'N';
                    KnightChessComponent chess = new KnightChessComponent(source ,chessColor,name,chessComponents );
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'k'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'k';
                    KingChessComponent chess = new KingChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'K'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'K';
                    KingChessComponent chess = new KingChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'b'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'b';
                    BishopChessComponent chess = new BishopChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'B'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'B';
                    BishopChessComponent chess = new BishopChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'q'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'q';
                    QueenChessComponent chess = new QueenChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }

                if(chessboard.get(i).charAt(j) == 'Q'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'Q';
                    QueenChessComponent chess = new QueenChessComponent(source ,chessColor,name,chessComponents );
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'r'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'r';
                    RookChessComponent chess = new RookChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'R'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'R';
                    RookChessComponent chess = new RookChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'p'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.WHITE;
                    char name = 'p';
                    PawnChessComponent chess = new PawnChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == 'P'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.BLACK;
                    char name = 'P';
                    PawnChessComponent chess = new PawnChessComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(i).charAt(j) == '_'){
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    ChessColor chessColor = ChessColor.NONE;
                    char name = '_';
                    EmptySlotComponent chess = new EmptySlotComponent(source ,chessColor,name,chessComponents);
                    chessComponents[i][j] = chess;
                }
                if(chessboard.get(8).charAt(0) == 'w'){
                    currentPlayer = ChessColor.WHITE;
                }
                if(chessboard.get(8).charAt(0) == 'b'){
                    currentPlayer = ChessColor.BLACK;
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder chessOnBoard = new StringBuilder();
        for(int i = 0 ; i < 8 ; i ++ ){
            for (int j = 0 ; j < 8 ; j ++ ){
                chessOnBoard.append(chessComponents[i][j].toString());
            }
        }
        String a1 = chessOnBoard.substring(0,8);
        String a2 = chessOnBoard.substring(8,16);
        String a3 = chessOnBoard.substring(16,24);
        String a4 = chessOnBoard.substring(24,32);
        String a5 = chessOnBoard.substring(32,40);
        String a6 = chessOnBoard.substring(40,48);
        String a7 = chessOnBoard.substring(48,56);
        String a8 = chessOnBoard.substring(56,64);
        return a1+"\n"+a2+"\n"+a3+"\n"+a4+"\n"+a5+"\n"+a6+"\n"+a7+"\n"+a8;
    }

    public String getCapturedChess(ChessColor player) {
        int count1 = 1;
        int count2 = 1;
        int count3 = 2;
        int count4 = 2;
        int count5 = 2;
        int count6 = 8;
        if (player == ChessColor.BLACK) {
            //check for normal chess for black
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K")) {
                        count1 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("Q")) {
                        count2 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("R")) {
                        count3 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("B")) {
                        count4 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("N")) {
                        count5 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("P")) {
                        count6 -= 1;
                    }
                }
            }//count1 = 0 ; count 2 = 0; count3 = 0; count4 = 1;count5 = 1; count6 =2;
            String a1, a2, a3, a4, a5, a6;
            if (count1 != 0) {
                a1 = "K " + count1 + "\n";
            } else {
                a1 = "";
            }
            if (count2 != 0) {
                a2 = "Q " + count2 + "\n";
            } else {
                a2 = "";
            }
            if (count3 != 0) {
                a3 = "R " + count3 + "\n";
            } else {
                a3 = "";
            }
            if (count4 != 0) {
                a4 = "B " + count4 + "\n";
            } else {
                a4 = "";
            }
            if (count5 != 0) {
                a5 = "N " + count5 + "\n";
            } else {
                a5 = "";
            }
            if (count6 != 0) {
                a6 = "P " + count6 + "\n";
            } else {
                a6 = "";
            }
            return a1 + a2 + a3 + a4 + a5 + a6 ;
        }//missingChess1 = N B Q B P P
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k")) {
                        count1 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("q")) {
                        count2 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("r")) {
                        count3 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("b")) {
                        count4 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("n")) {
                        count5 -= 1;
                    }
                    if (chessComponents[i][j].toString().equals("p")) {
                        count6 -= 1;
                    }
                }
            }
            String a1, a2, a3, a4, a5, a6;
            if (count1 != 0) {
                a1 = "k " + count1 + "\n";
            } else {
                a1 = "";
            }
            if (count2 != 0) {
                a2 = "q " + count2 + "\n";
            } else {
                a2 = "";
            }
            if (count3 != 0) {
                a3 = "r " + count3 + "\n";
            } else {
                a3 = "";
            }
            if (count4 != 0) {
                a4 = "b " + count4 + "\n";
            } else {
                a4 = "";
            }
            if (count5 != 0) {
                a5 = "n " + count5 + "\n";
            } else {
                a5 = "";
            }
            if (count6 != 0) {
                a6 = "p " + count6 + "\n";
            } else {
                a6 = "";
            }
            return a1 + a2 + a3 + a4 + a5 + a6 ;
        }
    }

    private List<ChessboardPoint> sort(List<ChessboardPoint> initialChessList) {
        //sort according to x
        for(int i = 0 ; i < initialChessList.size() -1 ; i++ ) {
            for(int j = 0 ; j < initialChessList.size() - 1 - i ; j++ ) {
                if( initialChessList.get(j).getX() > initialChessList.get(j+1).getX()){
                    ChessboardPoint temp = initialChessList.get(j);
                    initialChessList.set(j,initialChessList.get(j+1));
                    initialChessList.set(j+1,temp);
                }
            }
        }
        //if x is the same, sort according to y
        for(int i = 0 ; i < initialChessList.size() -1 ; i++ ) {
            for(int j = 0 ; j < initialChessList.size() - 1 - i ; j++ ) {
                if(initialChessList.get(j).getX() == initialChessList.get(j+1).getX()){
                    if( initialChessList.get(j).getY() > initialChessList.get(j+1).getY()){
                        ChessboardPoint temp = initialChessList.get(j);
                        initialChessList.set(j,initialChessList.get(j+1));
                        initialChessList.set(j+1,temp);
                    }
                }
            }
        }
        return initialChessList;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessOnBoard = chessComponents[source.getX()][source.getY()];
        if(!(chessOnBoard == null )){
            return sort(chessOnBoard.canMoveTo());
        }
       return new ArrayList<>();
    }

    private void swapCurrentPlayer(){
        if(getCurrentPlayer().equals(ChessColor.WHITE)){
            currentPlayer = ChessColor.BLACK;
        }else {
            currentPlayer = ChessColor.WHITE;
        }
    }
    // whether a chess piece at source can move to target
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessComponent chessOnBoard = chessComponents [sourceX] [sourceY];
        ChessComponent emptyChess = new EmptySlotComponent(source,ChessColor.NONE,'_',chessComponents);
        ChessboardPoint destination = new ChessboardPoint( targetX,targetY );
       if (!(chessOnBoard == null)){
        if(getCurrentPlayer().equals(getChess(sourceX,sourceY).chessColor)){ // currentPlayer = chessColor
            //if(!(getChess(targetX,targetY).chessColor.equals(getChess(sourceX,sourceY).chessColor))) { // same color
                    for (int i = 0; i < chessOnBoard.canMoveTo().size(); i++) {
                        if (destination.toString().equals(chessOnBoard.canMoveTo().get(i).toString())) {
                            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                            chessComponents[sourceX][sourceY] = emptyChess;
                            swapCurrentPlayer();
                            return true;
                        }
                    }
                }
            }
        return false;
    }
    //all the points that chess piece at "source" point can move to
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
