import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    /*implement all the previously written abstract methods in detail.*/
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]

    private ChessComponent[][] chessComponents;

    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.

    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent [8][8];
        currentPlayer = ChessColor.WHITE;
    }

//    public static void main(String[] args){
//        List a=new ArrayList<>();
//        a.add("RNBQKBNR");
//        a.add("PPPPPPPP");
//        a.add("________");
//        a.add("________");
//        a.add("________");
//        a.add("________");
//        a.add("pppppppp");
//        a.add("rnbqkbnr");
//        a.add("w");
//        ConcreteChessGame b=new ConcreteChessGame();
//        b.loadChessGame(a);
//        System.out.println(b);
////        System.out.print(b.getChessboardGraph());
//
//
//    }

    public void loadChessGame(List<String> chessboard){
        
        /*
        The chess pieces are then arranged the same way each time.
        The second row (or rank) is filled with pawns.
        The rooks go in the corners, then the knights next to them, followed by the bishops,
        and finally the queen, who always goes on her own matching color
        (white queen on white, black queen on black), and the king on the remaining square.
         */

        for(int i=0;i<=7;i++){
            String line = chessboard.get(i);
            for(int j=0;j<=7;j++){
                char c = line.charAt(j);
                switch(c){
                    case'_':
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'R':
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'r':
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'Q':
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'q':
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'B':
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'b':
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'N':
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'n':
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'K':
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'k':
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'P':
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case'p':
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
//                        System.out.println(chessComponents[i][j].name );
                        break;
                }
            }
        }


        String lastLine = chessboard.get(8);
        if(lastLine.equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }

    }

    public ChessColor getCurrentPlayer() {return this.currentPlayer;}

    public String getChessboardGraph(){
        // returns the chessboard status.
        //return a 8-rows String in the same format with input chessboard. Use \n to separate 2 rows.
       

        ChessComponent[][] chessboard = chessComponents;
        String[] state = new String[8];
        for(int i=0;i<8;i++){
            state[i]="";
            for(int j=0;j<8;j++){
                state[i] = state[i] + chessboard[i][j].name;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0;i<8;i++){
            result.append(state[i]).append("\n");
        }
        return result.toString();
    }

    public String getCapturedChess(ChessColor player){
        //returns all the captured chess pieces.
        //pieces should be sort by the order of "King>Queen>Rooks>Bishops>Knights>Pawns".

        /*
        At the beginning of a game, the original count of those chess pieces of
        King, Queen, Rooks,Bishops, Knights, Pawns are 1, 1, 2, 2, 2, 8 respectively
        so that the captured chess are those whose have been lost from chessboard.
         */


        StringBuilder capturedChess = new StringBuilder();

        if (player == ChessColor.BLACK){
            int kingNumber =1;
            int queenNumber =1;
            int knightNumber =2;
            int bishopNumber =2;
            int rookNumber =2;
            int pawnNumber =8;

            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++) {
                    char c = chessComponents[i][j].name;
                    switch(c){
                        case'K':
                            kingNumber--;
                            break;
                        case'Q':
                            queenNumber--;
                            break;
                        case'N':
                            knightNumber--;
                            break;
                        case'B':
                            bishopNumber--;
                            break;
                        case'R':
                            rookNumber--;
                            break;
                        case'P':
                            pawnNumber--;
                            break;
                        case '_':
                            break;
                    }
                }
            }

            if(kingNumber !=0){
                capturedChess.append("K ").append(kingNumber).append("\n");
            }
            if(queenNumber !=0){
                capturedChess.append("Q ").append(queenNumber).append("\n");
            }
            if(rookNumber !=0){
                capturedChess.append("R ").append(rookNumber).append("\n");
            }
            if(bishopNumber !=0){
                capturedChess.append("B ").append(bishopNumber).append("\n");
            }
            if(knightNumber !=0){
                capturedChess.append("N ").append(knightNumber).append("\n");
            }
            if(pawnNumber !=0){
                capturedChess.append("P ").append(pawnNumber).append("\n");
            }


            return capturedChess.toString();
        }else{
            int kingNumber =1;
            int queenNumber =1;
            int knightNumber =2;
            int bishopNumber =2;
            int rookNumber =2;
            int pawnNumber =8;

            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++) {
                    char c = chessComponents[i][j].name;
                    switch(c){
                        case'k':
                            kingNumber--;
                            break;
                        case'q':
                            queenNumber--;
                            break;
                        case 'n':
                            knightNumber--;
                            break;
                        case 'b':
                            bishopNumber--;
                            break;
                        case 'r':
                            rookNumber--;
                            break;
                        case 'p':
                            pawnNumber--;
                            break;
                        case '_':
                            break;
                    }
                }
            }

            if(kingNumber !=0){
                capturedChess.append("k ").append(kingNumber).append("\n");
            }
            if(queenNumber !=0){
                capturedChess.append("q ").append(queenNumber).append("\n");
            }
            if(rookNumber !=0){
                capturedChess.append("r ").append(rookNumber).append("\n");
            }
            if(bishopNumber !=0){
                capturedChess.append("b ").append(bishopNumber).append("\n");
            }
            if(knightNumber !=0){
                capturedChess.append("n ").append(knightNumber).append("\n");
            }
            if(pawnNumber !=0){
                capturedChess.append("p ").append(pawnNumber).append("\n");
            }


            return capturedChess.toString();

        }

    }





    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        //find chess according to source
        chessComponents[source.getX()][source.getY()].loadChessboard(chessComponents);
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        canMovePoints.sort(new Comparator<ChessboardPoint>(){
            @Override
            public int compare( ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() != o2.getX()){
                    return Integer.compare(o1.getX(), o2.getX());
                }else{
                    return Integer.compare(o1.getY(),o2.getY());
                }
            }
        });

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadChessboard(chessComponents);
        if(currentPlayer != getComponentColor(chessComponents[sourceX][sourceY].name)){
            return false;
        }
        ArrayList<ChessboardPoint> canMoveTo = (ArrayList<ChessboardPoint>)  chessComponents[sourceX][sourceY].canMoveTo();
        if(!canMoveTo.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
        if(currentPlayer == ChessColor.BLACK){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }
        return true;
    }

    public ChessComponent getChess(int x, int y){
        // returns the concrete chess component from private ChessComponent[][] chessComponents; in (x, y) location.
        return chessComponents[x][y];
    }

    private ChessColor getComponentColor (char chess){
        if(chess == '_'){
            return ChessColor.NONE;
        }
        if(chess >='A' && chess <='Z'){
            return ChessColor.BLACK;
        }else{
            return ChessColor.WHITE;
        }
    }
}
