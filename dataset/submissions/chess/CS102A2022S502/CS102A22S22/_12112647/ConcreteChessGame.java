
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
private ChessComponent [][] chessComponents;
private ChessColor currentPlayer ;

public ConcreteChessGame(){
    chessComponents=new ChessComponent[8][8];
    currentPlayer=ChessColor.WHITE;
}
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
           String row= chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char point =row.charAt(j);
                if(point=='R'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='N'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='B'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='K'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='P'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                }
                if(point=='r'){
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='n'){
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='b'){
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='q'){
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='k'){
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='p'){
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                }
                if(point=='_'){
                    chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j));
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else currentPlayer=ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

  public String getChessboardGraph(){
   StringBuilder ChessString=new StringBuilder();
      for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
              ChessString.append(chessComponents[i][j].toString());
          }
          ChessString.append("\n");
      }
      return ChessString.toString();
    }

    public String getCapturedChess(ChessColor player){
    int[] capture= {1,1,2,2,2,8};
    StringBuilder out= new StringBuilder();
    if(player==ChessColor.WHITE) {
        final char[] names={'k','q','r','b','n','p'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getPlayer()==ChessColor.WHITE){
                    if(chessComponents[i][j].toString().equals("k"))
                        capture[0]--;
                    if(chessComponents[i][j].toString().equals("q"))
                        capture[1]--;
                    if(chessComponents[i][j].toString().equals("r"))
                        capture[2]--;
                    if(chessComponents[i][j].toString().equals("b"))
                        capture[3]--;
                    if(chessComponents[i][j].toString().equals("n"))
                        capture[4]--;
                    if(chessComponents[i][j].toString().equals("p"))
                        capture[5]--;
                }

            }

        }
        for (int i = 0; i < 6; i++) {
            if(capture[i]!=0){
                out.append(names[i]).append(" ").append(capture[i]).append("\n");
            }
        }
        return out.toString();
    }
        else {
            final char[] names={'K','Q','R','B','N','P'};
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getPlayer()==ChessColor.BLACK){
                        if(chessComponents[i][j].toString().equals("K"))
                            capture[0]--;
                        if(chessComponents[i][j].toString().equals("Q"))
                            capture[1]--;
                        if(chessComponents[i][j].toString().equals("R"))
                            capture[2]--;
                        if(chessComponents[i][j].toString().equals("B"))
                            capture[3]--;
                        if(chessComponents[i][j].toString().equals("N"))
                            capture[4]--;
                        if(chessComponents[i][j].toString().equals("P"))
                            capture[5]--;
                    }
                }

            }
            for (int i = 0; i < 6; i++) {
                if(capture[i]!=0){
                    out.append(names[i]).append(" ").append(capture[i]).append("\n");
                }
            }
            return out.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);
        ArrayList<ChessboardPoint> result = (ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        return result;
}


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessboard(chessComponents);
        if(chessComponents[sourceX][sourceY].getPlayer()!=currentPlayer)
            return false;
        if(!chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY)))
            return false;
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX,targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
        if(currentPlayer==ChessColor.WHITE)
            currentPlayer=ChessColor.BLACK;
        else
            currentPlayer=ChessColor.WHITE;
        return true;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}


