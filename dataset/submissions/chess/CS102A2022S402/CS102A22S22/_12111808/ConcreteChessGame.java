
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char chess=chessboard.get(i).charAt(j);
                //RNBQKBNR P _
                if(chess=='R'){//
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if(chess=='N'){//knight
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                }
                else if(chess=='B'){//bishop
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                }
                else if(chess=='Q'){//queen
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                }
                else if(chess=='K'){//king
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                }
                else if(chess=='P'){//pawn
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                //white
                else if(chess=='r'){//
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(chess=='n'){//knight
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                }
                else if(chess=='b'){//bishop
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                }
                else if(chess=='q'){//queen
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                }
                else if(chess=='k'){//king
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                }
                else if(chess=='p'){//pawn
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else {
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                }

            }
        }
        if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        } else currentPlayer=ChessColor.WHITE;


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
        StringBuilder chessboardGraph=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessboardGraph.append(chessComponents[i][j].toString());
            }
            chessboardGraph.append("\n");
        }
        return chessboardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        //KQRBNP123456//kqrbnp789 11 12,_0
        int[] chessCounter=new int [13];

       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               char chessKind=chessComponents[i][j].name;
               if(chessKind=='K'){
                   chessCounter[1]++;
               }
               if(chessKind=='Q'){
                   chessCounter[2]++;
               }
               if(chessKind=='R'){
                   chessCounter[3]++;
               }
               if(chessKind=='B'){
                   chessCounter[4]++;
               }
               if(chessKind=='N'){
                   chessCounter[5]++;
               }
               if(chessKind=='P'){
                   chessCounter[6]++;
               }
               if(chessKind=='_'){
                   chessCounter[0]++;
               }
               if(chessKind=='k'){
                   chessCounter[7]++;
               }
               if(chessKind=='q'){
                   chessCounter[8]++;
               }
               if(chessKind=='r'){
                   chessCounter[9]++;
               }
               if(chessKind=='b'){
                   chessCounter[10]++;
               }
               if(chessKind=='n'){
                   chessCounter[11]++;
               }
               if(chessKind=='p'){
                   chessCounter[12]++;
               }
           }
       }
        StringBuilder capturedChess=new StringBuilder();
        if(player==ChessColor.BLACK){

            if(chessCounter[1]==0)capturedChess.append("K 1\n");

            if(chessCounter[2]==0)capturedChess.append("Q 1\n");

            if(chessCounter[3]!=2){
                capturedChess.append("R ");
                capturedChess.append(2-chessCounter[3]);
                capturedChess.append("\n");
            }
            if(chessCounter[4]!=2){
                capturedChess.append("B ");
                capturedChess.append(2-chessCounter[4]);
                capturedChess.append("\n");
            }
            if(chessCounter[5]!=2){
                capturedChess.append("N ");
                capturedChess.append(2-chessCounter[5]);
                capturedChess.append("\n");
            }
            if(chessCounter[6]!=8){
                capturedChess.append("P ");
                capturedChess.append(8-chessCounter[6]);
                capturedChess.append("\n");
            }

        }
        if(player==ChessColor.WHITE){

            if(chessCounter[7]==0)capturedChess.append("k 1\n");

            if(chessCounter[8]==0)capturedChess.append("q 1\n");

            if(chessCounter[9]!=2){
                capturedChess.append("r ");
                capturedChess.append(2-chessCounter[9]);
                capturedChess.append("\n");
            }
            if(chessCounter[10]!=2){
                capturedChess.append("b ");
                capturedChess.append(2-chessCounter[10]);
                capturedChess.append("\n");
            }
            if(chessCounter[11]!=2){
                capturedChess.append("n ");
                capturedChess.append(2-chessCounter[11]);
                capturedChess.append("\n");
            }
            if(chessCounter[12]!=8){
                capturedChess.append("p ");
                capturedChess.append(8-chessCounter[12]);
                capturedChess.append("\n");
            }

        }
        return capturedChess.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        chess.setChessboard(chessComponents);//
        List<ChessboardPoint>canMovePoints=chess.canMoveTo();
        canMovePoints.sort(new Sort());

        return canMovePoints;
    }
    private static class Sort implements  Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2) {
            if(p1.getX()==p2.getX()){
                return p1.getY()-p2.getY();
            }
            else return  p1.getX()-p2.getX();
        }
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chess=chessComponents[sourceX][sourceY];
        List <ChessboardPoint>canMovedPoints=getCanMovePoints(new ChessboardPoint(sourceX, sourceY ) );
        for(int i=0;i<canMovedPoints.size();i++){
            ChessboardPoint target=canMovedPoints.get(i);
            if(target.getX()==targetX&&target.getY()==targetY&&currentPlayer==chess.chessColor){
                chessComponents[targetX][targetY]=chess;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                chessComponents[targetX][targetY].source = new ChessboardPoint(targetX,targetY);
                if(currentPlayer==ChessColor.WHITE)currentPlayer=ChessColor.BLACK;
                else currentPlayer=ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

}

