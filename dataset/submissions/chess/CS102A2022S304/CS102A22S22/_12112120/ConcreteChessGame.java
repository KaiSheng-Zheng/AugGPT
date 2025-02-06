
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private final ChessColor b=ChessColor.BLACK;
    private final ChessColor w=ChessColor.WHITE;
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.BLACK;
    }

    public ChessComponent[][] getChessComponents(){return chessComponents;}

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                this.chessComponents[i][j]=turn(chessboard.get(i).charAt(j),new ChessboardPoint(i,j));
            }
        }
        if(chessboard.get(8).equals("w")){currentPlayer=ChessColor.WHITE;}
        else{currentPlayer=ChessColor.BLACK;}
    }

    public ChessComponent turn(char a,ChessboardPoint point){
        switch (a){
            case 'P':return new PawnChessComponent(point,b,this.chessComponents);
            case 'R':return new RookChessComponent(point,b,this.chessComponents);
            case 'N':return new KnightChessComponent(point,b,this.chessComponents);
            case 'B':return new BishopChessComponent(point,b,this.chessComponents);
            case 'Q':return new QueenChessComponent(point,b,this.chessComponents);
            case 'K':return new KingChessComponent(point,b,this.chessComponents);
            case '_':return new EmptySlotComponent(point,ChessColor.NONE,this.chessComponents);
            case 'p':return new PawnChessComponent(point,w,this.chessComponents);
            case 'r':return new RookChessComponent(point,w,this.chessComponents);
            case 'n':return new KnightChessComponent(point,w,this.chessComponents);
            case 'b':return new BishopChessComponent(point,w,this.chessComponents);
            case 'q':return new QueenChessComponent(point,w,this.chessComponents);
            case 'k':return new KingChessComponent(point,w,this.chessComponents);
            default:return null;
        }
    }



    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(this.chessComponents[i][j]);
            }
            s.append("\n");
        }
        return s.toString();
    }


    public int zhao(String s,char a){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==a)   count++;
        }
        return count;
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int[] t=new int[]{1,1,2,2,2,8}  ;StringBuilder S=new StringBuilder();StringBuilder s=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                S.append(this.chessComponents[i][j]);
            }
        }
        if(player==ChessColor.BLACK){
            t[0]-=zhao(String.valueOf(S),'K');
            t[1]-=zhao(String.valueOf(S),'Q');
            t[2]-=zhao(String.valueOf(S),'R');
            t[3]-=zhao(String.valueOf(S),'B');
            t[4]-=zhao(String.valueOf(S),'N');
            t[5]-=zhao(String.valueOf(S),'P');
            char[] c=new char[]{'K','Q','R','B','N','P'};
            for (int i = 0; i < 6; i++) {
                if(t[i]!=0) s.append(c[i]+" "+t[i]+"\n");
            }
        }else if(player==ChessColor.WHITE){
            t[0]-=zhao(String.valueOf(S),'k');
            t[1]-=zhao(String.valueOf(S),'q');
            t[2]-=zhao(String.valueOf(S),'r');
            t[3]-=zhao(String.valueOf(S),'b');
            t[4]-=zhao(String.valueOf(S),'n');
            t[5]-=zhao(String.valueOf(S),'p');
            char[] c=new char[]{'k','q','r','b','n','p'};
            for (int i = 0; i < 6; i++) {
                if(t[i]!=0) s.append(c[i]+" "+t[i]+"\n");
            }
        }
        return s.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        //if(this.chessComponents[source.getX()][source.getY()].getChessColor()==currentPlayer)
        return chessComponents[source.getX()][source.getY()].canMoveTo();
        //else return new ArrayList<ChessboardPoint>();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean can=false;
        if(this.chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
            for(ChessboardPoint point:this.chessComponents[sourceX][sourceY].canMoveTo()){
                if (point.getX() == targetX && point.getY() == targetY/*&& chessComponents[sourceX][sourceY].getChessColor()==currentPlayer*/) {
                    can = true;
                    break;
                }
            }
            if(can){chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,this.chessComponents);}
            if(can) currentPlayer=currentPlayer==ChessColor.BLACK?ChessColor.WHITE:ChessColor.BLACK;
        }
        return can;
    }
}


