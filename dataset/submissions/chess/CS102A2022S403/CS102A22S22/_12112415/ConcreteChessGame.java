import java.util.List;
import java.util.Objects;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]= new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]= new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]= new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]= new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]= new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]= new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]= new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]= new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]= new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]= new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]= new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));
                }
                else if (chessboard.get(i).charAt(j)=='_') {
                    chessComponents[i][j]= new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,chessboard.get(i).charAt(j));
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
        else if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph() {
        String r0,r1,r2,r3,r4,r5,r6,r7;
        r0="";
        r1="";
        r2="";
        r3="";
        r4="";
        r5="";
        r6="";
        r7="";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i==0){
                    r0+=chessComponents[i][j].name;
                }
                else if (i==1){
                    r1+=chessComponents[i][j].name;
                }
                else if (i==2){
                    r2+=chessComponents[i][j].name;
                }
                else if (i==3){
                    r3+=chessComponents[i][j].name;
                }
                else if (i==4){
                    r4+=chessComponents[i][j].name;
                }
                else if (i==5){
                    r5+=chessComponents[i][j].name;
                }
                else if (i==6){
                    r6+=chessComponents[i][j].name;
                }
                else {
                    r7+=chessComponents[i][j].name;
                }
            }
        }
        return r0+"\n"+r1+"\n"+r2+"\n"+r3+"\n"+r4+"\n"+r5+"\n"+r6+"\n"+r7;
    }
    @Override
    public String getCapturedChess(ChessColor player){
        int countK,countQ,countR,countB,countN,countP,countk,countq,countr,countb,countn,countp;
        countK=1;countk=1;countQ=1;countq=1;
        countR=2;countr=2;countB=2;countb=2;countN=2;countn=2;
        countP=8;countp=8;
        String str="";
        if (player.equals(ChessColor.BLACK)){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K'){
                        countk--;
                    }
                    else if (chessComponents[i][j].name == 'Q'){
                        countq--;
                    }
                    else if (chessComponents[i][j].name == 'R'){
                        countr--;
                    }
                    else if (chessComponents[i][j].name == 'B'){
                        countb--;
                    }
                    else if (chessComponents[i][j].name == 'N'){
                        countn--;
                    }
                    else if (chessComponents[i][j].name == 'P'){
                        countp--;
                    }
                }
            }
            if (countP!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("P %d\n",countP));
                str=stringBuilder.toString();
            }
            if (countN!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("N %d\n",countN));
                str=stringBuilder.toString();
            }
            if (countB!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("B %d\n",countB));
                str=stringBuilder.toString();
            }
            if (countR!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("R %d\n",countR));
                str=stringBuilder.toString();
            }
            if (countQ!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("Q %d\n",countQ));
                str=stringBuilder.toString();
            }
            if (countK!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("K %d\n",countK));
                str=stringBuilder.toString();
            }
        }
        if (player.equals(ChessColor.WHITE)){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k'){
                        countk--;
                    }
                    else if (chessComponents[i][j].name == 'q'){
                        countq--;
                    }
                    else if (chessComponents[i][j].name == 'r'){
                        countr--;
                    }
                    else if (chessComponents[i][j].name == 'b'){
                        countb--;
                    }
                    else if (chessComponents[i][j].name == 'n'){
                        countn--;
                    }
                    else if (chessComponents[i][j].name == 'p'){
                        countp--;
                    }
                }
            }
            if (countp!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("p %d\n",countp));
                str=stringBuilder.toString();
            }
            if (countn!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("n %d\n",countn));
                str=stringBuilder.toString();
            }
            if (countb!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("b %d\n",countb));
                str=stringBuilder.toString();
            }
            if (countr!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("r %d\n",countr));
                str=stringBuilder.toString();
            }
            if (countq!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("q %d\n",countq));
                str=stringBuilder.toString();
            }
            if (countk!=0){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(str).insert(0,String.format("k %d\n",countk));
                str=stringBuilder.toString();
            }
        }
        return str;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        ChessboardPoint a=new ChessboardPoint(x,y);
        return chessComponents[x][y];
    }

}