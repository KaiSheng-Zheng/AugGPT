import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer= ChessColor.WHITE;
   /* private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
   // private ArrayList chessboard;
    public ConcreteChessGame(){}
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer){//,ArrayList chessboard
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
       // this.chessboard=new ArrayList();
    }

    */
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++)
                switch (chessboard.get(i).charAt(j)) {
                    case 98:chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b',this,chessComponents);
                        break;
                    case 113:chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q',this,chessComponents);
                        break;
                    case 110:chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n',this,chessComponents);
                        break;
                    case 107:chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k',this,chessComponents);
                        break;
                    case 112:chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p',this,chessComponents);
                        break;
                    case 114:chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r',this,chessComponents);
                        break;
                    case 66:chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B',this,chessComponents);
                        break;
                    case 81:chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q',this,chessComponents);
                        break;
                    case 78:chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N',this,chessComponents);
                        break;
                    case 75:chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K',this,chessComponents);
                        break;
                    case 80:chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P',this,chessComponents);
                        break;
                    case 82:chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R',this,chessComponents);
                        break;
                    case 95:chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_',this,chessComponents);
                        break;
                }
        if (chessboard.get(8).charAt(0)=='w')
            this.currentPlayer=ChessColor.WHITE;
        if (chessboard.get(8).charAt(0)=='b')
            this.currentPlayer=ChessColor.BLACK;
    }
    public ChessComponent KnowPoint(int x,int y){
        return chessComponents[x][y];
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        String a="",b="",c="",d="",e="",f="",g="",h="";
        for (int i=0;i<8;i++){
        a+=chessComponents[0][i].name;
        b+=chessComponents[1][i].name;
        c+=chessComponents[2][i].name;
        d+=chessComponents[3][i].name;
        e+=chessComponents[4][i].name;
        f+=chessComponents[5][i].name;
        g+=chessComponents[6][i].name;
        h+=chessComponents[7][i].name;}
        return a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f+"\n"+g+"\n"+h;
    }
    public String getCapturedChess(ChessColor player){
        int k=0,q=0,n=0,p=0,b=0,r=0,K=0,Q=0,N=0,P=0,B=0,R=0;
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].name=='k')k++;
                if (chessComponents[i][j].name=='q')q++;
                if (chessComponents[i][j].name=='n')n++;
                if (chessComponents[i][j].name=='p')p++;
                if (chessComponents[i][j].name=='b')b++;
                if (chessComponents[i][j].name=='r')r++;
                if (chessComponents[i][j].name=='K')K++;
                if (chessComponents[i][j].name=='Q')Q++;
                if (chessComponents[i][j].name=='N')N++;
                if (chessComponents[i][j].name=='P')P++;
                if (chessComponents[i][j].name=='B')B++;
                if (chessComponents[i][j].name=='R')R++;
            }
        String a="";//   K Q R B N P
        if (player==ChessColor.WHITE){
            if (1-k!=0)
                a+="k "+1+"\n";
            if (1-q!=0)
                a+="q "+1+"\n";
            if (2-r==1)
                a+="r "+1+"\n";
            if (2-r==2)
                a+="r "+2+"\n";
            if (2-b==1)
                a+="b "+1+"\n";
            if (2-b==2)
                a+="b "+2+"\n";
            if (2-n==1)
                a+="n "+1+"\n";
            if (2-n==2)
                a+="n "+2+"\n";
            for (int i=1;i<9;i++)
                if (8-p==i)
                    a+="p "+i+"\n";
        } if (player==ChessColor.BLACK){
            if (1-K==1)
                a+="K "+1+"\n";
            if (1-Q==1)
                a+="Q "+1+"\n";
            if (2-R==1)
                a+="R "+1+"\n";
            if (2-R==2)
                a+="R "+2+"\n";
            if (2-B==1)
                a+="B "+1+"\n";
            if (2-B==2)
                a+="B "+2+"\n";
            if (2-N==1)
                a+="N "+1+"\n";
            if (2-N==2)
                a+="N "+2+"\n";
            for (int i=1;i<9;i++)
                if (8-P==i)
                    a+="P "+i+"\n";
        }
        return a;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints=this.getChess(source.getX(),source.getY()).canMoveTo();
        for (int i=0;i<canMovePoints.size();i++)
            for(int j = 0; j < canMovePoints.size() - 1 - i ; j++)
                if (canMovePoints.get(j).getX()>canMovePoints.get(j+1).getX()) {
                    ChessboardPoint point = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,point);
                }
     for (int i=0;i<canMovePoints.size();i++)
            for(int j = 0; j < canMovePoints.size() - 1 - i ; j++)
                if (canMovePoints.get(j).getX()==canMovePoints.get(j+1).getX()&&canMovePoints.get(j).getY()>canMovePoints.get(j+1).getY()) {
                    ChessboardPoint point = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,point);
                }







                return canMovePoints;
    }

    public void loadGameContinue(ChessComponent[][] chessComponent){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                this.chessComponents[i][j].setChessboard(chessComponent);
            }
        }
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

//        List<ChessboardPoint> canMove=chessComponents[sourceX][sourceY].canMoveTo();
//                int length=canMove.size();
//                int have=0;
//                for (int i=0;i<length;i++){
//                    if (canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY);
//                    have++;
//                    break;
//                }
//                if (have== 1){
//                    chessComponents[targetX][targetY]=KnowPoint(sourceX,sourceY);
//                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',this,chessComponents);
//                    return true;
//
//                }
//                else
//            return false;
        List<ChessboardPoint> canMove=chessComponents[sourceX][sourceY].canMoveTo();
        int length=canMove.size();
        boolean judgement1=false;
        if (chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer()){
            judgement1=true;
        }
        boolean judgement2=false;
        for (int i=0;i<length;i++){
            if (canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                judgement2=true;
                break;
            }
        }
        boolean judgement=false;
        if (judgement1&&judgement2){
            judgement=true;
        }

        if (judgement) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].getSource().setX(targetX);
            chessComponents[targetX][targetY].getSource().setY(targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',this,chessComponents);
            if (this.currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else {
                this.currentPlayer = ChessColor.WHITE;
            }
            loadGameContinue(this.chessComponents);
        }
        return judgement;

    }
    }

