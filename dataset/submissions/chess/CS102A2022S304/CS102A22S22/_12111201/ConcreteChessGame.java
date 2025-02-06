
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<chessComponents.length;i++){
            for (int j=0;j<chessComponents[i].length;j++){
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                }else if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }else if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }else if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }

            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer= ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
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

    @Override
    public String getChessboardGraph() {
        String ret="";
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ret+=chessComponents[i][j].toString();
            }
            ret+="\n";
        }
        return ret;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String ret="";
        int K=1,Q=1,R=2,B=2,N=2,P=8;
        int []a={1,1,2,2,2,8};
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[0]--;
                }else if(chessComponents[i][j] instanceof QueenChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[1]--;
                }else if (chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[2]--;
                }else if (chessComponents[i][j] instanceof BishopChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[3]--;
                }else if (chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[4]--;
                }else if (chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getChessColor().equals(player)){
                    a[5]--;
                }
            }
        }
        if(player.equals(ChessColor.BLACK)){
            for (int i=0;i<6;i++){
                if (a[i] > 0) {
                    String letter = "";
                    if (i == 0) {
                        letter = "K";
                    } else if (i == 1) {
                        letter = "Q";
                    } else if (i == 2) {
                        letter = "R";
                    } else if (i == 3) {
                        letter = "B";
                    } else if (i == 4) {
                        letter = "N";
                    } else if (i == 5) {
                        letter = "P";
                    }
                    ret += letter + " " + a[i] + "\n";
                }
            }
        }else {
            for (int i=0;i<6;i++){
                if (a[i] > 0) {
                    String letter = "";
                    if (i == 0) {
                        letter = "k";
                    } else if (i == 1) {
                        letter = "q";
                    } else if (i == 2) {
                        letter = "r";
                    } else if (i == 3) {
                        letter = "b";
                    } else if (i == 4) {
                        letter = "n";
                    } else if (i == 5) {
                        letter = "p";
                    }
                    ret += letter + " " + a[i] + "\n";
                }
            }
        }

        return ret;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessComponents(this.chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
 @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessComponents(this.chessComponents);
        if(currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor())){
            for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
                if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&(chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY)){
                    chessComponents[sourceX][sourceY].getSource().setX(targetX);
                    chessComponents[sourceX][sourceY].getSource().setY(targetY);
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    if(currentPlayer.equals(ChessColor.BLACK)){
                        currentPlayer=ChessColor.WHITE;
                    }else {
                        currentPlayer=ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}
