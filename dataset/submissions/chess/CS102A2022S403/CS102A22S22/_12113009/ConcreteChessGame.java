import java.awt.*;
import java.util.*;
import java.util.List;

public  class ConcreteChessGame implements ChessGame {
    //A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;//the twp dimensional array whose content is chesscomponent, the catogories of chess
    // What's the current player's color, black or white
// should be initialized in your construct method.
// by default, set the color to white
    private ChessColor currentPlayer;

    public  ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {//whether it should be initialized by ourselves
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

               C: switch(chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK) ;
                        break C;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK) ;
                        break C;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK) ;


                        break C;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK) ;
                        break C;
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK) ;
                        break C;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK);
                        break C;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE) ;
                        break C;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE);
                        break C;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE) ;
                        break C;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE) ;
                        break C;
                    case 'k':

                        chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE) ;
                        break C;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE) ;
                        break C;
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(i,j,ChessColor.NONE) ;
                        break C;
                }
                chessComponents[i][j].Load(chessComponents);
            }
        }
if(chessboard.get(8).charAt(0)=='w')this.currentPlayer=ChessColor.WHITE;
        if(chessboard.get(8).charAt(0)=='b')this.currentPlayer=ChessColor.BLACK;
    }
    @Override
    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];//a category of chess at a certain point
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        if(chessComponents[source.getX()][source.getY()].canMoveTo().size()!=0){
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>(){
            public int compare(ChessboardPoint o1,ChessboardPoint o2){
                if(o1.getX()-o2.getX()>0)
                    return 2;
                else if(o1.getX()-o2.getX()<0)
                    return -1;
                else return Integer.compare(o1.getY()-o2.getY(),0);
            }
        });}
        return canMovePoints;
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }
    @Override
    public  String getChessboardGraph(){
        String[]chessboard=new String[8];
        for(int i=0;i<8;i++){
            chessboard[i]="";
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].getName()=='K'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
chessboard[i]=chessboard[i]+'K';
                }
                if(chessComponents[i][j].getName()=='Q'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    chessboard[i]=chessboard[i]+'Q';
                }
                if(chessComponents[i][j].getName()=='N'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    chessboard[i]=chessboard[i]+'N';
                }
                if(chessComponents[i][j].getName()=='P'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    chessboard[i]=chessboard[i]+'P';
                }
                if(chessComponents[i][j].getName()=='B'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    chessboard[i]=chessboard[i]+'B';
                }
                if(chessComponents[i][j].getName()=='R'&&chessComponents[i][j].getChessColor()== ChessColor.BLACK){
                    chessboard[i]=chessboard[i]+'R';
                }
                if(chessComponents[i][j].getName()=='k'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'k';
                }
                if(chessComponents[i][j].getName()=='q'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'q';
                }
                if(chessComponents[i][j].getName()=='n'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'n';
                }
                if(chessComponents[i][j].getName()=='p'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'p';
                }
                if(chessComponents[i][j].getName()=='b'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'b';
                }
                if(chessComponents[i][j].getName()=='r'&&chessComponents[i][j].getChessColor()== ChessColor.WHITE){
                    chessboard[i]=chessboard[i]+'r';
                }
                if(chessComponents[i][j].getName()=='_'){
                    chessboard[i]=chessboard[i]+'_';

                }
            }
        }

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",chessboard[0],chessboard[1],chessboard[2],chessboard[3],chessboard[4],chessboard[5],chessboard[6],chessboard[7]);
    }
    public  String getCapturedChess(ChessColor player){
        String outcome;
        int p=8;int k=1;int q=1; int r=2;int n=2; int b=2;String P="";String R="";String K="";String N="";String B="";String Q="";
        if(player==ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='R'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){r--;}
                    if (chessComponents[i][j].getName()=='K'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){k--;}
                    if (chessComponents[i][j].getName()=='Q'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){q--;}
                    if (chessComponents[i][j].getName()=='B'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){b--;}
                    if (chessComponents[i][j].getName()=='P'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){p--;}
                    if (chessComponents[i][j].getName()=='N'&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){n--;}
                }
            }

            if(k!=0) K=String.format("K %d\n",k);
            if(b!=0) B=String.format("B %d\n",b);
            if(q!=0) Q=String.format("Q %d\n",q);
            if(n!=0) N=String.format("N %d\n",n);
            if(p!=0) P=String.format("P %d\n",p);
            if(r!=0) R=String.format("R %d\n",r);

            outcome=K+Q+R+B+N+P;
            return outcome;
        }
        if(player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='r'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){r--;}
                    if (chessComponents[i][j].getName()=='k'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){k--;}
                    if (chessComponents[i][j].getName()=='q'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){q--;}
                    if (chessComponents[i][j].getName()=='b'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){b--;}
                    if (chessComponents[i][j].getName()=='p'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){p--;}
                    if (chessComponents[i][j].getName()=='n'&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){n--;}
                }
            }

            if(k!=0) K=String.format("k %d\n",k);
            if(b!=0) B=String.format("b %d\n",b);
            if(q!=0) Q=String.format("q %d\n",q);
            if(n!=0) N=String.format("n %d\n",n);
            if(p!=0) P=String.format("p %d\n",p);
            if(r!=0) R=String.format("r %d\n",r);

            outcome=K+Q+R+B+N+P;
            return outcome;
        }

       else return"";
    }
public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){

    ChessboardPoint target=new ChessboardPoint(targetX,targetY);

        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
        if(contain(chessComponents[sourceX][sourceY].canMoveTo(),target)){

//            chessComponents[sourceX][sourceY].setSource(target);
            chessComponents[targetX][targetY].Load(chessComponents);
            if(chessComponents[sourceX][sourceY].getName()=='K'||chessComponents[sourceX][sourceY].getName()=='k')
                chessComponents[targetX][targetY]=new KingChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );
            if(chessComponents[sourceX][sourceY].getName()=='Q'||chessComponents[sourceX][sourceY].getName()=='q')
                chessComponents[targetX][targetY]=new QueenChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );
            if(chessComponents[sourceX][sourceY].getName()=='N'||chessComponents[sourceX][sourceY].getName()=='n')
                chessComponents[targetX][targetY]=new KnightChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );
            if(chessComponents[sourceX][sourceY].getName()=='R'||chessComponents[sourceX][sourceY].getName()=='r')
                chessComponents[targetX][targetY]=new RookChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );
            if(chessComponents[sourceX][sourceY].getName()=='B'||chessComponents[sourceX][sourceY].getName()=='b')
                chessComponents[targetX][targetY]=new BishopChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );
            if(chessComponents[sourceX][sourceY].getName()=='P'||chessComponents[sourceX][sourceY].getName()=='p')
                chessComponents[targetX][targetY]=new PawnChessComponent(targetX,targetY,chessComponents[sourceX][sourceY].getChessColor() );



            chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE);
            chessComponents[sourceX][sourceY].Load(chessComponents);
            chessComponents[targetX][targetY].Load(chessComponents);
            if(currentPlayer==ChessColor.BLACK)currentPlayer=ChessColor.WHITE;
            else currentPlayer=ChessColor.BLACK;
            return true;
        }else return false;
        }
       else return  false;
}

    public boolean contain( List <ChessboardPoint>list,ChessboardPoint source){
     for(int i=0;i<list.size();i++){
    if(list.get(i).getX()== source.getX()&&list.get(i).getY()== source.getY()){
        return true;
    }
}
return false;
    }
}

