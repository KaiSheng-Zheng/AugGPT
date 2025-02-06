import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private  ChessColor currentPlayer;
    private StringBuilder chessboardTxt=new StringBuilder();
    private String[][] stringComponents=new String[8][8];


    public void loadChessGame(List<String> chessboard){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
        for(int i=0;i<=7;i++){
            String s=chessboard.get(i);
            chessboardTxt.append(chessboard.get(i));
            for(int j=0;j<=7;j++){
                chessComponents[i][j]=judgeChessComponent(s.charAt(j),i,j);
                stringComponents[i][j]= String.valueOf(s.charAt(j));
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sc=new StringBuilder();
        for(int i=0;i<=7;i++){
            for(int j=0;j<=7;j++){
                sc.append(stringComponents[i][j]);
            }
            sc.append("\n");
        }
        return sc.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player==ChessColor.BLACK){
            int[] irr=viewBlack();
            StringBuilder s=new StringBuilder();
            if(irr[0]!=0){
                s.append("K 1\n");
            }
            if(irr[1]!=0){
                s.append("Q 1\n");
            }
            if(irr[2]!=0){
                s.append("R "+irr[2]+"\n");
            }
            if(irr[3]!=0){
                s.append("B "+irr[3]+"\n");
            }
            if(irr[4]!=0){
                s.append("N "+irr[4]+"\n");
            }
            if(irr[5]!=0){
                s.append("P "+irr[5]+"\n");
            }
            return s.toString();
        }else{
            int[] irr=viewWhite();
            StringBuilder s=new StringBuilder();
            if(irr[0]!=0){
                s.append("k 1\n");
            }
            if(irr[1]!=0){
                s.append("q 1\n");
            }
            if(irr[2]!=0){
                s.append("r "+irr[2]+"\n");
            }
            if(irr[3]!=0){
                s.append("b "+irr[3]+"\n");
            }
            if(irr[4]!=0){
                s.append("n "+irr[4]+"\n");
            }
            if(irr[5]!=0){
                s.append("p "+irr[5]+"\n");
            }
            return s.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if(chessComponents[source.getX()][source.getY()].canMoveTo().size()!=0){
            return chessComponents[source.getX()][source.getY()].canMoveTo();
        }
        else return new ArrayList<>();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            for(ChessboardPoint chessboardPoint:chessComponents[sourceX][sourceY].canMoveTo()){
                if(chessboardPoint.getX()==targetX&&chessboardPoint.getY()==targetY){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                    for(int i=0;i<8;i++){
                       for(int j=0;j<8;j++){
                           chessComponents[i][j].setChessComponents(this.chessComponents);
                       }
                    }
                    if(currentPlayer==ChessColor.BLACK){
                        currentPlayer=ChessColor.WHITE;
                    }else if(currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }
                    upDatePrint(chessComponents);
                    return true;
                }
            }
        }
        return false;
    }

    public ChessComponent judgeChessComponent(char c,int x,int y){
        switch (c){
            case('B'):
                return new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('b'):
                return new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
            case('K'):
                return new KingChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('k'):
                return new KingChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
            case('_'):
                return new EmptySlotComponent(new ChessboardPoint(x,y));
            case('Q'):
                return new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('q'):
                return new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
            case('N'):
                return new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('n'):
                return new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
            case('P'):
                return new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('p'):
                return new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
            case('R'):
                return new RookChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,chessComponents);
            case('r'):
                return new RookChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,chessComponents);
        }
        return null;
    }

    public int[] viewBlack(){
        int k=0,q=0,r=0,b=0,n=0,p=0;
        for(int i=0;i<chessboardTxt.length();i++){
            if(chessboardTxt.charAt(i)=='K'){
                k++;
            }
            if(chessboardTxt.charAt(i)=='Q'){
                q++;
            }
            if(chessboardTxt.charAt(i)=='R'){
                r++;
            }
            if(chessboardTxt.charAt(i)=='B'){
                b++;
            }
            if(chessboardTxt.charAt(i)=='N'){
                n++;
            }
            if(chessboardTxt.charAt(i)=='P'){
                p++;
            }
        }
        int[] irr=new int[6];
        irr[0]=1-k;
        irr[1]=1-q;
        irr[2]=2-r;
        irr[3]=2-b;
        irr[4]=2-n;
        irr[5]=8-p;
        return irr;
    }

    public int[] viewWhite(){
        int k=0,q=0,r=0,b=0,n=0,p=0;
        for(int i=0;i<chessboardTxt.length();i++){
            if(chessboardTxt.charAt(i)=='k'){
                k++;
            }
            if(chessboardTxt.charAt(i)=='q'){
                q++;
            }
            if(chessboardTxt.charAt(i)=='r'){
                r++;
            }
            if(chessboardTxt.charAt(i)=='b'){
                b++;
            }
            if(chessboardTxt.charAt(i)=='n'){
                n++;
            }
            if(chessboardTxt.charAt(i)=='p'){
                p++;
            }
        }
        int[] irr=new int[6];
        irr[0]=1-k;
        irr[1]=1-q;
        irr[2]=2-r;
        irr[3]=2-b;
        irr[4]=2-n;
        irr[5]=8-p;
        return irr;
    }

    public void upDatePrint(ChessComponent[][] chessComponents){
        chessboardTxt=new StringBuilder();
        for(int i=0;i<=7;i++){
            for(int j=0;j<=7;j++){
                stringComponents[i][j]= String.valueOf(chessComponents[i][j].name);
                chessboardTxt.append(chessComponents[i][j].toString());
            }
        }
    }
}
