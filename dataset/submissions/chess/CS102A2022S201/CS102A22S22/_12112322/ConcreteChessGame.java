import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private static ChessComponent[][] chessComponents0;
    public ConcreteChessGame(){
        this.chessComponents= new  ChessComponent[8][8];
        this.currentPlayer= ChessColor.WHITE;
        this.chessComponents0= new  ChessComponent[8][8];
    }
    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents0[i][j]=new EmptySlotComponent();
                    }
                if (chessboard.get(i).charAt(j)=='K'||chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents0[i][j]=new KingChessComponent();
                }
                if (chessboard.get(i).charAt(j)=='Q'||chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents0[i][j]=new QueenChessComponent();
                }
                if (chessboard.get(i).charAt(j)=='N'||chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents0[i][j]=new KnightChessComponent();
                }
                if (chessboard.get(i).charAt(j)=='R'||chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents0[i][j]=new RookChessComponent();
                }
                if (chessboard.get(i).charAt(j)=='P'||chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents0[i][j]=new PawnChessComponent();
                }
                chessComponents[i][j].name=chessboard.get(i).charAt(j);
                chessComponents[i][j].setSource(i,j);
                if (chessboard.get(i).charAt(j)>=65&&chessboard.get(i).charAt(j)<=90){
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)>=97&&chessboard.get(i).charAt(j)<=122){
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                else chessComponents[i][j].setChessColor(ChessColor.NONE);
                chessComponents0[i][j]=chessComponents[i][j];
            }
        }

        if (Objects.equals(chessboard.get(8), "w")){currentPlayer=ChessColor.WHITE;}
        else if (Objects.equals(chessboard.get(8), "b")){currentPlayer=ChessColor.BLACK;}
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder a = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                a.append(chessComponents[i][j].name);
            }
        }
        ArrayList<String> chessboard1 = new ArrayList<>();
        for (int k=0;k<57;k+=8){
            chessboard1.add(a.substring(k,k+8));
        }
        return chessboard1.get(0)+"\n"+chessboard1.get(1)+"\n"+chessboard1.get(2)+"\n"+chessboard1.get(3)+"\n"+chessboard1.get(4)+"\n"+chessboard1.get(5)+"\n"+chessboard1.get(6)+"\n"+chessboard1.get(7)+"\n";
    }
    public String getCapturedChess(ChessColor player){
        int cR=0,cr=0,cN=0,cn=0,cB=0,cQ=0,cK=0,cP=0,cp=0,cb=0,cq=0,ck=0;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (String.valueOf(chessComponents[i][j].name).equals("R")){cR+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("N")){cN+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("B")){cB+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("K")){cK+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("Q")){cQ+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("P")){cP+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("r")){cr+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("n")){cn+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("b")){cb+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("k")){ck+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("q")){cq+=1;}
                if (String.valueOf(chessComponents[i][j].name).equals("p")){cp+=1;}
            }
        }
        String B = "";
        if ((1-cK)!=0){B=B.concat("K "+(1-cK)+"\n");}
        if ((1-cQ)!=0){B=B.concat("Q "+(1-cQ)+"\n");}
        if ((2-cR)!=0){B=B.concat("R "+(2-cR)+"\n");}
        if ((2-cB)!=0){B=B.concat("B "+(2-cB)+"\n");}
        if ((2-cN)!=0){B=B.concat("N "+(2-cN)+"\n");}
        if ((8-cP)!=0){B=B.concat("P "+(8-cP)+"\n");}
        String W = "";
        if ((1-ck)!=0){W=W.concat("k "+(1-ck)+"\n");}
        if ((1-cq)!=0){W=W.concat("q "+(1-cq)+"\n");}
        if ((2-cr)!=0){W=W.concat("r "+(2-cr)+"\n");}
        if ((2-cb)!=0){W=W.concat("b "+(2-cb)+"\n");}
        if ((2-cn)!=0){W=W.concat("n "+(2-cn)+"\n");}
        if ((8-cp)!=0){W=W.concat("p "+(8-cp)+"\n");}
        if (player==ChessColor.BLACK){
            return B;}
        else return W;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public static ChessComponent getChess0(int x, int y){
        return chessComponents0[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        for (int i=0;i<canMovePoints.size()-1;i++){
            for (int j=0;j<canMovePoints.size()-1-i;j++){
                int cnt = 0;
                if (canMovePoints.get(j).getX()>canMovePoints.get(j+1).getX()) {
                    cnt = canMovePoints.get(j).getX();
                    canMovePoints.get(j).setX(canMovePoints.get(j+1).getX());
                    canMovePoints.get(j+1).setX(cnt);
                }
            }
        }
        for (int i=0;i<canMovePoints.size()-1;i++){
            for (int j=0;j<canMovePoints.size()-1-i;j++){
                int cnt = 0;
                if ((canMovePoints.get(j).getY()>canMovePoints.get(j+1).getY())&&(canMovePoints.get(j).getX()==canMovePoints.get(j+1).getX())) {
                    cnt = canMovePoints.get(j).getY();
                    canMovePoints.get(j).setY(canMovePoints.get(j+1).getY());
                    canMovePoints.get(j+1).setY(cnt);
                }
            }
        }
        return canMovePoints;
    }
    public static boolean canMove(ChessComponent chess,ChessboardPoint source1){
        ChessComponent chess1 = getChess0(source1.getX(),source1.getY());
        if (chess.getChessColor()==chess1.getChessColor()){return false;}
        else return true;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chess = getChess(sourceX,sourceY);
        if (chess.getChessColor()==currentPlayer){
            return true;
        }
        else return false;
    }

}