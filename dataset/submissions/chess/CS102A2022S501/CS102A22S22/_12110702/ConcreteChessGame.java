import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
//    public int[] CapturedBlack=new int[6];
//    public int[] CapturedWhite=new int[6];

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a=chessboard.get(i).charAt(j);
                if (a=='R') {chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R',chessComponents);continue;}
                if (a=='r') {chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r',chessComponents);continue;}
                if (a=='K') {chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K',chessComponents);continue;}
                if (a=='k') {chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k',chessComponents);continue;}
                if (a=='B') {chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B',chessComponents);continue;}
                if (a=='b') {chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b',chessComponents);continue;}
                if (a=='Q') {chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q',chessComponents);continue;}
                if (a=='q') {chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q',chessComponents);continue;}
                if (a=='p') {
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p',chessComponents);
                    if (i!=6){((PawnChessComponent)chessComponents[i][j]).addcounter();}
                    continue;}
                if (a=='P') {
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P',chessComponents);
                    if (i!=1){((PawnChessComponent)chessComponents[i][j]).addcounter();}
                    continue;}
                if (a=='N') {chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N',chessComponents);continue;}
                if (a=='n') {chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n',chessComponents);continue;}
                if (a=='_') {chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_',chessComponents);continue;}
            }
        }
        char b=chessboard.get(8).charAt(0);
        if (b=='w'){this.currentPlayer=ChessColor.WHITE;}
        if (b=='b'){this.currentPlayer=ChessColor.BLACK;}
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
       String kk="";
        for (int i = 0; i <8; i++) {
            for (int j = 0; j <8; j++) {
                kk=kk.concat(Character.toString(chessComponents[i][j].getName()));
            }
            kk=kk.concat("\n");
        }
        return kk;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String str="";
        int[] arr=new int[6];
        if ((player==ChessColor.BLACK)){
            arr=counter('K','Q','R','B','N','P');
            if (arr[0]!=0){str=str.concat("K "+arr[0]+"\n");}
            if (arr[1]!=0){str=str.concat("Q "+arr[1]+"\n");}
            if (arr[2]!=0){str=str.concat("R "+arr[2]+"\n");}
            if (arr[3]!=0){str=str.concat("B "+arr[3]+"\n");}
            if (arr[4]!=0){str=str.concat("N "+arr[4]+"\n");}
            if (arr[5]!=0){str=str.concat("P "+arr[5]+"\n");}
        }
        else {
            arr=counter('k','q','r','b','n','p');
            if (arr[0]!=0){str=str.concat("k "+arr[0]+"\n");}
            if (arr[1]!=0){str=str.concat("q "+arr[1]+"\n");}
            if (arr[2]!=0){str=str.concat("r "+arr[2]+"\n");}
            if (arr[3]!=0){str=str.concat("b "+arr[3]+"\n");}
            if (arr[4]!=0){str=str.concat("n "+arr[4]+"\n");}
            if (arr[5]!=0){str=str.concat("p "+arr[5]+"\n");}
        }
        for (int i = 0; i < 6; i++) {
            arr[i]=0;
        }
        return str;
       }
        
        public boolean cont(ChessboardPoint ch,List<ChessboardPoint> li){
        for (int i = 0; i < li.size(); i++) {
            if(li.get(i).getX()==ch.getX()&&li.get(i).getY()==ch.getY()){return true;}
            }
        return false;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
            if (cont(new ChessboardPoint(targetX,targetY),chessComponents[sourceX][sourceY].canMoveTo())){
                if (chessComponents[sourceX][sourceY].getName()=='B'||chessComponents[sourceX][sourceY].getName()=='b'){chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'B':'b'),chessComponents);}
                if (chessComponents[sourceX][sourceY].getName()=='K'||chessComponents[sourceX][sourceY].getName()=='k'){chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'K':'k'),chessComponents);}
                if (chessComponents[sourceX][sourceY].getName()=='N'||chessComponents[sourceX][sourceY].getName()=='n'){chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'N':'n'),chessComponents);}
                if (chessComponents[sourceX][sourceY].getName()=='P'||chessComponents[sourceX][sourceY].getName()=='p'){((PawnChessComponent) chessComponents[sourceX][sourceY]).addcounter();
                                                                                      chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'P':'p'),chessComponents); ((PawnChessComponent)chessComponents[targetX][targetY]).addcounter();}
                if (chessComponents[sourceX][sourceY].getName()=='Q'||chessComponents[sourceX][sourceY].getName()=='q'){chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'Q':'q'),chessComponents);}
                if (chessComponents[sourceX][sourceY].getName()=='R'||chessComponents[sourceX][sourceY].getName()=='r'){chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),currentPlayer,(currentPlayer==ChessColor.BLACK?'R':'r'),chessComponents);}
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',chessComponents);
                SwitchCurrentPlayer();
                return true;}
            else {return false;}
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> kk=chessComponents[source.getX()][source.getY()].canMoveTo();
        ChessboardPoint[][] pp=new ChessboardPoint[8][8];
        List<ChessboardPoint> k=new ArrayList<>();
        for (int i = 0; i < kk.size(); i++) {
            pp[kk.get(i).getX()][kk.get(i).getY()]=new ChessboardPoint(kk.get(i).getX(),kk.get(i).getY());
        }
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pp[i][j]!=null){k.add(pp[i][j]);}
            }
        }
        return k;


    }

    int[] counter(char k,char q,char r,char b,char n,char p){
        int[] kk=new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName()==k){kk[0]++;continue;}
                if (chessComponents[i][j].getName()==q){kk[1]++;continue;}
                if (chessComponents[i][j].getName()==r){kk[2]++;continue;}
                if (chessComponents[i][j].getName()==b){kk[3]++;continue;}
                if (chessComponents[i][j].getName()==n){kk[4]++;continue;}
                if (chessComponents[i][j].getName()==p){kk[5]++;continue;}

            }
        }
        kk[0]=1-kk[0];
        kk[1]=1-kk[1];
        kk[2]=2-kk[2];
        kk[3]=2-kk[3];
        kk[4]=2-kk[4];
        kk[5]=8-kk[5];
        return kk;
    }
    public void SwitchCurrentPlayer(){
      currentPlayer=(currentPlayer==ChessColor.BLACK)?ChessColor.WHITE:ChessColor.BLACK;
    }
}


