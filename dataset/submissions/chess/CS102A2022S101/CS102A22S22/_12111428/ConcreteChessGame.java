import java.util.*;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public static void main(String[] args){
        ConcreteChessGame game =new ConcreteChessGame();
        List<String> chessboard = new ArrayList<>();

        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("___B____");
        chessboard.add("___r____");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("________");
        chessboard.add("w");
        game.loadChessGame(chessboard);
        System.out.print(game.getCurrentPlayer());

        if(game.moveChess(4,3,3,3)){
            System.out.print("Fuck");
        }else {
            System.out.print("Noooo");
        }
        System.out.print(game.chessComponents[4][3]);

    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            String row = chessboard.get(i);
            char[] column =row.toCharArray();
            for(int j=0;j<8;j++){
                if (column[j] == 'P'){
                    Pawn pawn = new Pawn();
                    pawn.setChessColor(ChessColor.BLACK);
                    pawn.setName('P');
                    this.chessComponents[i][j]=pawn;
                    pawn.setSource(new ChessboardPoint(i,j));
                } else if (column[j] == 'R'){
                    Rook rook = new Rook();
                    rook.setChessColor(ChessColor.BLACK);
                    rook.setName('R');
                    this.chessComponents[i][j]=rook;
                    rook.setSource(new ChessboardPoint(i,j));
                } else if (column[j] == 'N'){
                    Knight knight = new Knight();
                    knight.setChessColor(ChessColor.BLACK);
                    knight.setName('N');
                    this.chessComponents[i][j]=knight;
                    knight.setSource(new ChessboardPoint(i,j));
                }else if (column[j] == 'B'){
                    Bishop bishop = new Bishop();
                    bishop.setChessColor(ChessColor.BLACK);
                    bishop.setName('B');
                    bishop.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=bishop;

                }else if (column[j] == 'Q'){
                    Queen queen = new Queen();
                    queen.setChessColor(ChessColor.BLACK);
                    queen.setName('Q');
                    queen.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=queen;

                }else if (column[j] == 'K'){
                    King king = new King();
                    king.setChessColor(ChessColor.BLACK);
                    king.setName('K');
                    king.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=king;
                }else if (column[j] == 'p'){
                    Pawn pawn = new Pawn();
                    pawn.setChessColor(ChessColor.WHITE);
                    pawn.setName('p');
                    pawn.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=pawn;
                }
                else if (column[j] == 'r'){
                    Rook rook = new Rook();
                    rook.setChessColor(ChessColor.WHITE);
                    rook.setName('r');
                    rook.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=rook;

                } else if (column[j] == 'n'){
                    Knight knight = new Knight();
                    knight.setChessColor(ChessColor.WHITE);
                    knight.setName('n');
                    knight.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=knight;

                }else if (column[j] == 'b'){
                    Bishop bishop = new Bishop();
                    bishop.setChessColor(ChessColor.WHITE);
                    bishop.setName('b');
                    bishop.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=bishop;

                }else if (column[j] == 'q'){
                    Queen queen = new Queen();
                    queen.setChessColor(ChessColor.WHITE);
                    queen.setName('q');
                    queen.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=queen;

                }else if (column[j] == 'k'){
                    King king = new King();
                    king.setChessColor(ChessColor.WHITE);
                    king.setName('k');
                    king.setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j]=king;
                }else if(column[j]=='_'){
                    EmptySpace empty =new EmptySpace();
                    empty.setName('_');
                    empty.setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j]=empty;

                }
            }
            if(chessboard.size()==9){
                if(Objects.equals(chessboard.get(8), "w")){
                    this.currentPlayer=ChessColor.WHITE;
                }else if(Objects.equals(chessboard.get(8), "b")){
                    this.currentPlayer=ChessColor.BLACK;
                }
            }

        }
    }

    @Override
    public ChessColor getCurrentPlayer() {

        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor x) {

        this.currentPlayer=x;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    };

    public void setChess(ChessComponent chess, int x,int y ){
        this.chessComponents[x][y]=chess;
    };

    @Override
    public String getChessboardGraph() {
        String answer = "";
        for (int i=0;i<chessComponents.length;i++) {
            StringBuilder x= new StringBuilder();

            for(int j=0;j<chessComponents.length;j++){
                x.append(chessComponents[i][j]);
            }
            answer=answer+x+"\n";
        }
        return answer;
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        String chessboardString =getChessboardGraph();
        List<String> chessboard = new ArrayList<String>(Arrays.asList(chessboardString.split("\n")));
        loadChessGame(chessboard);

        int PawnCounter = 0;
        int RookCounter =0;
        int KnightCounter =0;
        int BishopCounter = 0;
        int QueenCounter =0;
        int KingCounter= 0;

        if(player==ChessColor.BLACK){
            for(int i =0;i<8;i++){
                for(int j =0;j<8;j++){
                    if (Objects.equals(getChess(i,j).toString(), "P")){
                        PawnCounter+=1;

                    } else if (Objects.equals(getChess(i,j).toString(), "R")){
                        RookCounter+=1;
                    } else if (Objects.equals(getChess(i,j).toString(), "N")){
                        KnightCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "B")){
                        BishopCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "Q")){
                        QueenCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "K")){
                        KingCounter+=1;
                    }
                }
            }
        }else if (player==ChessColor.WHITE) {
            for(int i =0;i<8;i++){
                for(int j =0;j<8;j++){
                    if (Objects.equals(getChess(i,j).toString(), "p")){
                        PawnCounter+=1;
                    } else if (Objects.equals(getChess(i,j).toString(), "r")){
                        RookCounter+=1;
                    } else if (Objects.equals(getChess(i,j).toString(), "n")){
                        KnightCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "b")){
                        BishopCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "q")){
                        QueenCounter+=1;
                    }else if (Objects.equals(getChess(i,j).toString(), "k")){
                        KingCounter+=1;
                    }
                }
            }
        }

        int CapturedPawnCounter=8- PawnCounter;
        int CapturedRookCounter=2-RookCounter;
        int CapturedKnightCounter=2-KnightCounter;
        int CapturedBishopCounter=2-BishopCounter;
        int CapturedQueenCounter=1-QueenCounter;
        int CapturedKingCounter=1-KingCounter;

        ArrayList<Integer>counter = new ArrayList<>();
        counter.add(CapturedKingCounter);
        counter.add(CapturedQueenCounter);
        counter.add(CapturedRookCounter);
        counter.add(CapturedBishopCounter);
        counter.add(CapturedKnightCounter);
        counter.add(CapturedPawnCounter);
        String counters="";

        for(int i=0;i<counter.size();i++){

            if(counter.get(i)>0){
                if(player==ChessColor.BLACK){
                    if(counter.get(i)==0){
                    }else if(i==0){
                        counters=counters+ String.format("K %s\n",CapturedKingCounter);
                    }else if(i==1){
                        counters=counters+ String.format("Q %s\n",CapturedQueenCounter);

                    } else if(i==2){
                        counters=counters+ String.format("R %s\n",CapturedRookCounter);
                    }else if(i==3){
                        counters=counters+ String.format("B %s\n",CapturedBishopCounter);
                    }else if(i==4){
                        counters=counters+ String.format("N %s\n",CapturedKnightCounter);
                    }
                    else if(i==5){
                        counters=counters+ String.format("P %s\n",CapturedPawnCounter);
                    }

                }else if(player==ChessColor.WHITE){
                    if(counter.get(i)==0){
                    }else if(i==0){
                        counters=counters+ String.format("k %s\n",CapturedKingCounter);
                    }else if(i==1){
                        counters=counters+ String.format("q %s\n",CapturedQueenCounter);

                    } else if(i==2){
                        counters=counters+ String.format("r %s\n",CapturedRookCounter);
                    }else if(i==3){
                        counters=counters+ String.format("b %s\n",CapturedBishopCounter);
                    }else if(i==4){
                        counters=counters+ String.format("n %s\n",CapturedKnightCounter);
                    }
                    else if(i==5){
                        counters=counters+ String.format("p %s\n",CapturedPawnCounter);
                    }
                }
            }

        }
       return counters;
    }

    //Whether a piece can move to target
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        boolean canMove=false;
        ChessColor currentPlayer = getCurrentPlayer();

        if(sourceX>=0&& sourceX<8&&targetY<8&&targetY>=0){
            ChessComponent chessSource = getChess(sourceX,sourceY);

            ChessboardPoint sourcePoint =chessSource.getChessboardPoint();
            ChessComponent chessTarget = getChess(targetX,targetY);

            if(chessSource.getChessColor()==currentPlayer && chessTarget.getChessColor()!=currentPlayer){
                List<ChessboardPoint> pointList=getCanMovePoints(sourcePoint);
                for(ChessboardPoint point: pointList){
                    if(point.getX()==targetX&& point.getY()==targetY){
                        EmptySpace empty = new EmptySpace();
                        empty.setName('_');
                        setChess(empty,sourceX,sourceY);
                        setChess(chessSource,targetX,targetY);
                        canMove=true;

                        if(currentPlayer==ChessColor.BLACK){
                            setCurrentPlayer(ChessColor.WHITE);
                        }else if(currentPlayer==ChessColor.WHITE){
                            setCurrentPlayer(ChessColor.BLACK);
                        }
                        break;
                    }
                }
            }
            }

        return canMove;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        System.out.print("getCanMovePoints activated!");
        if(source!=null){
            int x = source.getX();
            int y= source.getY();

            PlayerRankingComparator comparator = new PlayerRankingComparator();
            PlayerRankingComparator2 comparator2 = new PlayerRankingComparator2();

            ChessComponent chess = getChess(x,y);
            chess.setChessComponent(chessComponents);

            // 1. find chess according to source
            // 2. as below statement:
            // 3.sort canMovePoints by x - y ascending order
            //System.out.print(source);
            List<ChessboardPoint> points = chess.canMoveTo();
            points.sort(comparator2);
            points.sort(comparator);

            return points;

        }else return new ArrayList<>();

    }
    public static class PlayerRankingComparator implements Comparator<ChessboardPoint> {

        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            return Integer.compare(o1.getX(), o2.getX());
        }

    }
    public static class PlayerRankingComparator2 implements Comparator<ChessboardPoint> {

        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            return Integer.compare(o1.getY(), o2.getY());
        }

    }
}