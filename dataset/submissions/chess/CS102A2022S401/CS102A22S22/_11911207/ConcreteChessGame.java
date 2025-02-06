

import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)) {
                    case 'K' -> {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'Q' -> {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'R' -> {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'B' -> {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'N' -> {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'P' -> {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'k' -> {
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'q' -> {
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'r' -> {
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'b' -> {
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'n' -> {
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case 'p' -> {
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                    case '_' -> {
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setName('_');
                        chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                    }
                }
            }
        }

        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        else {
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

    public String getChessboardGraph(){
        StringBuilder graph = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                graph.append(chessComponents[i][j]);
            }
            if (i<7){
                graph.append("\n");
            }
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder print = new StringBuilder();
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        if (player==ChessColor.BLACK){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'K' -> k++;
                        case 'Q' -> q++;
                        case 'R' -> r++;
                        case 'B' -> b++;
                        case 'N' -> n++;
                        case 'P' -> p++;

                    }
                }
            }
            if (k==0){
                print.append("K 1\n");
            }
            if (q==0){
                print.append("Q 1\n");
            }
            if (r<2){
                print.append("R ").append(2 - r).append("\n");
            }
            if (b<2){
                print.append("B ").append(2 - b).append("\n");
            }
            if (n<2){
                print.append("N ").append(2 - n).append("\n");
            }
            if (p<8){
                print.append("P ").append(8 - p).append("\n");
            }
        }
        else if (player==ChessColor.WHITE){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'k' -> k++;
                        case 'q' -> q++;
                        case 'r' -> r++;
                        case 'b' -> b++;
                        case 'n' -> n++;
                        case 'p' -> p++;
                    }
                }
            }
            if (k==0){
                print.append("k 1\n");
            }
            if (q==0){
                print.append("q 1\n");
            }
            if (r<2){
                print.append("r ").append(2 - r).append("\n");
            }
            if (b<2){
                print.append("b ").append(2 - b).append("\n");
            }
            if (n<2){
                print.append("n ").append(2 - n).append("\n");
            }
            if (p<8){
                print.append("p ").append(8 - p).append("\n");
            }
        }
        return print.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer)){
            return false;
        }
        else if (targetX>7||targetX<0||targetY>7||targetY<0){
            System.out.println("out of bounds");
            return false;
        }
        else if (sourceX==targetX&&sourceY==targetY){
            System.out.println("you must move");
            return false;
        }
        else {
            if (Checkers.allCheck(chessComponents[sourceX][sourceY],chessComponents, String.valueOf(chessComponents[sourceX][sourceY].name),targetX,targetY,currentPlayer)){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                }
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }
                else if (currentPlayer==ChessColor.BLACK){
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
            else {
                System.out.println("wrong in move rules");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("R_BQK__R");
        input.add("PPPP_PPP");
        input.add("__N_P___");
        input.add("___Np___");
        input.add("_B_p____");
        input.add("___q_n__");
        input.add("ppp__ppp");
        input.add("rnb_kb_r");
        input.add("w");
        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(input);
        System.out.println(game.getChessboardGraph());
        System.out.println();
        System.out.println(game.getCurrentPlayer());
        game.moveChess(5,5,6,3);
        System.out.println(game.getChessboardGraph());
        System.out.println();
        System.out.println(game.getCurrentPlayer());
        game.moveChess(4,1,6,3);
        System.out.println(game.getChessboardGraph());
        System.out.println();
        System.out.println(game.getCurrentPlayer());
        game.moveChess(7,2,6,3);
        System.out.println(game.getChessboardGraph());
        System.out.println();
        System.out.println(game.getCurrentPlayer());
        game.moveChess(3,3,4,5);
        System.out.println(game.getChessboardGraph());
        System.out.println();
        System.out.println(game.getCurrentPlayer());
        game.moveChess(6,3,4,5);
        System.out.println(game.getChessboardGraph());
    }
}
