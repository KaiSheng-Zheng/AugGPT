import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private ChessColor currentPlayer;
    // What's the current player's color, black or white?

public ConcreteChessGame(){
    this.chessComponents= new ChessComponent[8][8];
    this.currentPlayer=ChessColor.WHITE;
}

    public void loadChessGame(List<String> chessboard) {
        if(chessboard.size()==9&&chessboard.get(0).length()==8&&chessboard.get(1).length()==8&&chessboard.get(2).length()==8
                &&chessboard.get(3).length()==8&&chessboard.get(4).length()==8&&chessboard.get(5).length()==8&&
                chessboard.get(6).length()==8&&chessboard.get(7).length()==8&&chessboard.get(8).length()==1)
        {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessboard.get(i).charAt(j)=='R'){
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='r'){
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='N'){
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='n'){
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='B'){
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='b'){
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='Q'){
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='q'){
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='K'){
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='k'){
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                    }
                    if(chessboard.get(i).charAt(j)=='P'){
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);

                    }
                    if(chessboard.get(i).charAt(j)=='p'){
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    }
                    if(chessboard.get(i).charAt(j)=='_'){
                        this.chessComponents[i][j] = new EmptySlotComponent(i,j);
                    }
                }
            }
            if(chessboard.get(8).equals("w"))
                currentPlayer = ChessColor.WHITE;
            if(chessboard.get(8).equals("b"))
                currentPlayer = ChessColor.BLACK;
            ChessComponent.setChessboard(chessComponents);
        }
    }




    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder Answer = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Answer.append(chessComponents[i][j].getName());
                if(j==7)
                    Answer.append('\n');
            }
        }
        return Answer.toString();
    }


    public String getCapturedChess(ChessColor player){
    int flagRook=0;
    int flagNight=0;
    int flagBishop=0;
    int flagQueen=0;
    int flagPawn=0;
    int flagKing=0;
    StringBuilder sb =new StringBuilder();

       if (player==ChessColor.BLACK) {
           for (int i = 0; i < 8; i++) {
               for (int j = 0; j < 8; j++) {
                  if (this.chessComponents[i][j].getName()=='R')
                      flagRook++;
                  if (this.chessComponents[i][j].getName()=='N')
                      flagNight++;
                  if(this.chessComponents[i][j].getName()=='B')
                      flagBishop++;
                  if (this.chessComponents[i][j].getName()=='Q')
                      flagQueen++;
                  if (this.chessComponents[i][j].getName()=='K')
                      flagKing++;
                  if (this.chessComponents[i][j].getName()=='P')
                      flagPawn++;
                   }
               }

           if (flagKing<1)
              sb.append("K 1\n");
           if (flagQueen<1)
               sb.append("Q 1\n");
           if (flagRook<2)
               sb.append("R ").append(2 - flagRook).append("\n");
           if (flagBishop<2)
               sb.append("B ").append(2 - flagBishop).append("\n");
           if (flagNight<2)
               sb.append("N ").append(2 - flagNight).append("\n");
           if (flagPawn<8)
               sb.append("P ").append(8 - flagPawn).append("\n");

           return sb.toString();
       }

        if (player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].getName()=='r')
                        flagRook++;
                    if (this.chessComponents[i][j].getName()=='n')
                        flagNight++;
                    if(this.chessComponents[i][j].getName()=='b')
                        flagBishop++;
                    if (this.chessComponents[i][j].getName()=='q')
                        flagQueen++;
                    if (this.chessComponents[i][j].getName()=='k')
                        flagKing++;
                    if (this.chessComponents[i][j].getName()=='p')
                        flagPawn++;
                    }
                }
            }
            if (flagKing<1)
                sb.append("k 1\n");
            if (flagQueen<1)
                sb.append("q 1\n");
            if (flagRook<2)
                sb.append("r ").append(2 - flagRook).append("\n");
            if (flagBishop<2)
                sb.append("b ").append(2 - flagBishop).append("\n");
            if (flagNight<2)
                sb.append("n ").append(2 - flagNight).append("\n");
            if (flagPawn<8)
                sb.append("p ").append(8 - flagPawn).append("\n");

        return sb.toString();
    }



    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
      return   chessComponents[source.getX()][source.getY()].canMoveTo();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.getChess(sourceX,sourceY).getChessColor()!=this.currentPlayer) {
            return false;
        }
        boolean flag=false;
        for (ChessboardPoint test:this.getChess(sourceX,sourceY).canMoveTo()){
            if (test.getX()==targetX&&test.getY()==targetY) {
                flag=true;
                break;
            }
        }
       
        if (flag){
            this.chessComponents[targetX][targetY]=this.getChess(sourceX,sourceY);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
            this.chessComponents[sourceX][sourceY].setName('_');
            this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            if (this.currentPlayer == ChessColor.BLACK) {
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
            ChessComponent.setChessboard(this.chessComponents);
        }
        return flag;
    }
}











