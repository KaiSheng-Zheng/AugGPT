

import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public static ChessComponent[][] chesscomponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                    if(chessboard.get(i).charAt(j)=='_');{
                         ChessboardPoint sources = new ChessboardPoint(i,j);
                         ChessComponent chess = new EmptySlotComponent(sources,ChessColor.NONE);
                         chess.setName('_');
                        chessComponents[i][j]=chess;
                        chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='R'){
                        ChessboardPoint sources = new ChessboardPoint(i,j);
                        ChessComponent chess = new RookChessComponent(sources,ChessColor.BLACK);
                        chess.setName('R');
                        chessComponents[i][j]=chess;
                        chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='r'){
                        ChessboardPoint sources = new ChessboardPoint(i,j);
                        ChessComponent chess = new RookChessComponent(sources,ChessColor.WHITE);
                        chess.setName('r');
                        chessComponents[i][j]=chess;
                        chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='B'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new BishopChessComponent(sources,ChessColor.BLACK);
                        chess.setName('B');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='b'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new BishopChessComponent(sources,ChessColor.WHITE);
                    chess.setName('b');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='P'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new PawnChessComponent(sources,ChessColor.BLACK);
                    chess.setName('P');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='p'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new PawnChessComponent(sources,ChessColor.WHITE);
                    chess.setName('p');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }

                    if(chessboard.get(i).charAt(j)=='N'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new KnightChessComponent(sources,ChessColor.BLACK);
                        chess.setName('N');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='n'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new KnightChessComponent(sources,ChessColor.WHITE);
                        chess.setName('n');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='K'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new KingChessComponent(sources,ChessColor.BLACK);
                        chess.setName('K');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='k'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new KingChessComponent(sources,ChessColor.WHITE);
                        chess.setName('k');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='Q'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new QueenChessComponent(sources,ChessColor.BLACK);
                        chess.setName('Q');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
                    if(chessboard.get(i).charAt(j)=='q'){
                    ChessboardPoint sources = new ChessboardPoint(i,j);
                    ChessComponent chess = new QueenChessComponent(sources,ChessColor.WHITE);
                        chess.setName('q');
                    chessComponents[i][j]=chess;
                    chesscomponents[i][j]=chess;
                    }
            }
        }
        char player = chessboard.get(8).charAt(0);
        if (player == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.append(chessComponents[i][j].name);
            }
            board.append("\n");
        }
        return board.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int R=0; int r=0;
        int B=0; int b=0;
        int K=0; int k=0;
        int Q=0; int q=0;
        int N=0; int n=0;
        int P=0; int p=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getName()=='R'){R++;}
                if(chessComponents[i][j].getName()=='K'){K++;}
                if(chessComponents[i][j].getName()=='B'){B++;}
                if(chessComponents[i][j].getName()=='N'){N++;}
                if(chessComponents[i][j].getName()=='P'){P++;}
                if(chessComponents[i][j].getName()=='Q'){Q++;}
                if(chessComponents[i][j].getName()=='r'){r++;}
                if(chessComponents[i][j].getName()=='b'){b++;}
                if(chessComponents[i][j].getName()=='k'){k++;}
                if(chessComponents[i][j].getName()=='q'){q++;}
                if(chessComponents[i][j].getName()=='p'){p++;}
                if(chessComponents[i][j].getName()=='n'){n++;}
            }
        }
        if(player==ChessColor.BLACK){
            String capR;
            String capB;
            String capN;
            String capP;
            String capQ;
            String capK;
            if(K-1!=0){capK = "K "+String.valueOf(1-K)+"\n";}else {capK = "";}
            if(Q-1!=0){capQ = "Q "+String.valueOf(1-Q)+"\n";}else {capQ = "";}
            if(R-2!=0){capR = "R "+String.valueOf(2-R)+"\n";}else {capR = "";}
            if(B-2!=0){capB = "B "+String.valueOf(2-B)+"\n";}else {capB = "";}
            if(N-2!=0){capN = "N "+String.valueOf(2-N)+"\n";}else {capN = "";}
            if(P-8!=0){capP = "P "+String.valueOf(8-P)+"\n";}else {capP = "";}


            String black = capK+capQ+capR+capB+capN+capP;
            return black;
            }
        if(player==ChessColor.WHITE){
            String capr;
            String capb;
            String capn;
            String capp;
            String capq;
            String capk;
            if(k-1!=0){capk = "k "+String.valueOf(1-k)+"\n";}else {capk = "";}
            if(q-1!=0){capq = "q "+String.valueOf(1-q)+"\n";}else {capq = "";}
            if(r-2!=0){capr = "r "+String.valueOf(2-r)+"\n";}else {capr = "";}
            if(b-2!=0){capb = "b "+String.valueOf(2-b)+"\n";}else {capb = "";}
            if(n-2!=0){capn = "n "+String.valueOf(2-n)+"\n";}else {capn = "";}
            if(p-8!=0){capp = "p "+String.valueOf(8-p)+"\n";}else {capp = "";}


            String white = capk+capq+capr+capb+capn+capp;
            return white;
        }
        else {return null;}
    }



    public ChessComponent getChess(int x, int y){
        ChessComponent chessComponent=chessComponents[x][y];
        return chessComponent;
    }



    //q4
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(), source.getY()).canMoveTo();
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY()) {
                        return 1;
                    } else if (o1.getY() < o2.getY()) {
                        return -1;
                    }
                }
                return 0;
            }
        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent fu = chessComponents[sourceX][sourceY];
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        if (fu.getChessColor() == currentPlayer) {
            List<ChessboardPoint> list = fu.canMoveTo();
            for (ChessboardPoint point : list)
                if (target.getX() == point.getX() && target.getY() == point.getY()) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(target);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setName('_');
                    if (currentPlayer == ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chesscomponents=chessComponents;
                    return true;
            }
        }
        return false;
    }
}



