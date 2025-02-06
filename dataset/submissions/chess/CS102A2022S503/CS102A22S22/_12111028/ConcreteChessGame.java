
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private static ChessComponent[][] staticchessComponents=new ChessComponent[8][8];

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=  ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard){

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case'p':
//                        ChessComponent p=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
//                        chessComponents[i][j]=p;
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                        break;
                    case'P':
//                        ChessComponent P=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
//                        chessComponents[i][j]=P;
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                        break;
                    case'k':
//                        ChessComponent k = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
//                        chessComponents[i][j]=k;
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                        break;
                    case'K':
//                        ChessComponent K=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
//                        chessComponents[i][j]=K;
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                        break;
                    case'r':
//                        ChessComponent r=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
//                        chessComponents[i][j]=r;
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                        break;
                    case'R':
//                        ChessComponent R=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
//                        chessComponents[i][j]=R;
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        break;
                    case'q':
//                        ChessComponent q=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
//                        chessComponents[i][j]=q;
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                        break;
                    case'Q':
//                        ChessComponent Q=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
//                        chessComponents[i][j]=Q;
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                        break;
                    case'n':
//                        ChessComponent n=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
//                        chessComponents[i][j]=n;
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                        break;
                    case'N':
//                        ChessComponent N=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
//                        chessComponents[i][j]=N;
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                        break;
                    case'_':
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                        break;
                    case'B':
//                        ChessComponent B=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
//                        chessComponents[i][j]=B;
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                        break;
                    case 'b':
//                        ChessComponent b=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
//                        chessComponents[i][j]=b;
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                        break;
                }

            }
        }
        if(chessboard.get(8).charAt(0)=='w'){this.currentPlayer=ChessColor.WHITE;}
        else{ this.currentPlayer=ChessColor.BLACK;}
        staticchessComponents=chessComponents;
    }


    public String getChessboardGraph(){
        StringBuilder result= new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                result.append(this.chessComponents[i][j].getName());
            }
                    result.append("\n");
        }
        return result.toString();
    }


    public String getCapturedChess(ChessColor player){
        StringBuilder result=new StringBuilder();
        int K=0,Q=0,R=0,B=0,N=0,P=0,k=0,q=0,r=0,b=0,n=0,p=0;

        String graph=getChessboardGraph();
        for(int i =0;i<graph.length();i++){
            switch (graph.charAt(i)){
                case('K'):
                    K++;
                    break;
                case('Q'):
                    Q++;
                    break;
                case('R'):
                    R++;
                    break;
                case('B'):
                    B++;
                    break;
                case('N'):
                    N++;
                    break;
                case('P'):
                    P++;
                    break;
                case('k'):
                    k++;
                    break;
                case('q'):
                    q++;
                    break;
                case('b'):
                    b++;
                    break;
                case('n'):
                    n++;
                    break;
                case('p'):
                    p++;
                    break;
                case('r'):
                    r++;
                    break;
                case('_'):
                    break;
                case('\n'):
                    break;
            }
        }
        K=1-K;Q=1-Q;R=2-R;B=2-B;N=2-N;P=8-P;
        k=1-k;q=1-q;r=2-r;b=2-b;n=2-n;p=8-p;
        if(player==ChessColor.BLACK){
            if(K!=0){
                result.append("K ");
                result.append(K);
                result.append("\n");
            }
            if(Q!=0){
                result.append("Q ");
                result.append(Q);
                result.append("\n");
            }
            if(R!=0){
                result.append("R ");
                result.append(R);
                result.append("\n");
            }
            if(B!=0){
                result.append("B ");
                result.append(B);
                result.append("\n");
            }
            if(N!=0){
                result.append("N ");
                result.append(N);
                result.append("\n");
            }
            if(P!=0){
                result.append("P ");
                result.append(P);
                result.append("\n");
            }

        }
        else if(player==ChessColor.WHITE){
            if(k!=0){
                result.append("k ");
                result.append(k);
                result.append("\n");
            }
            if(q!=0){
                result.append("q ");
                result.append(q);
                result.append("\n");
            }
            if(r!=0){
                result.append("r ");
                result.append(r);
                result.append("\n");
            }
            if(b!=0){
                result.append("b ");
                result.append(b);
                result.append("\n");
            }
            if(n!=0){
                result.append("n ");
                result.append(n);
                result.append("\n");
            }
            if(p!=0){
                result.append("p ");
                result.append(p);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public static ChessComponent[][] getStaticchessComponents(){
        return staticchessComponents;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int
            targetY){
        ChessboardPoint des=new ChessboardPoint(targetX,targetY);
        ChessComponent a =chessComponents[sourceX][sourceY];
        Boolean contain=false;
        for(ChessboardPoint e :chessComponents[sourceX][sourceY].canMoveTo())
            {if (e.getX()==des.getX()&&e.getY()==des.getY())contain=true;}
        if(contain&&
                chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            a.setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[targetX][targetY]=a;
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
           if(this.currentPlayer==ChessColor.BLACK){currentPlayer=ChessColor.WHITE;}
            else currentPlayer=ChessColor.BLACK;
            return true;
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        List<ChessboardPoint> result=new ArrayList<>();
        for(int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                for(int i=0;i<canMovePoints.size();i++){
                    if (canMovePoints.get(i).getX()==x&&
                    canMovePoints.get(i).getY()==y){
                        result.add(canMovePoints.get(i));
                    }
                }
            }
        }
        return result;
    }

}
