import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j)=='R'){chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='r'){chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='K'){chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='k'){chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='Q'){chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='q'){chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='_'){chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='N'){chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='n'){chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='P'){chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='p'){chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='B'){chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessboard.get(i).charAt(j));}
                if(chessboard.get(i).charAt(j)=='b'){chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessboard.get(i).charAt(j));}
                chessComponents[i][j].setChessComponent(chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){currentPlayer=ChessColor.WHITE;}else {currentPlayer=ChessColor.BLACK;}
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder c=new StringBuilder();
        for (int i=0;i<8;i++){
            c.append(chessComponents[0][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[1][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[2][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[3][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[4][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[5][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[6][i].toString());
        }c.append("\n");
        for (int i=0;i<8;i++){
            c.append(chessComponents[7][i].toString());
        }
        return c.toString();
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder str=new StringBuilder();
        if(player==ChessColor.BLACK){
            int K=1,Q=1,R=2,B=2,N=2,P=8;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if(chessComponents[i][j].toString().equals("K")){K--;}
                    if(chessComponents[i][j].toString().equals("Q")){Q--;}
                    if(chessComponents[i][j].toString().equals("R")){R--;}
                    if(chessComponents[i][j].toString().equals("B")){B--;}
                    if(chessComponents[i][j].toString().equals("N")){N--;}
                    if(chessComponents[i][j].toString().equals("P")){P--;}
                }
            }
            if(K>0){str.append("K");str.append(" ");str.append(K);str.append("\n");}
            if(Q>0){str.append("Q");str.append(" ");str.append(Q);str.append("\n");}
            if(R>0){str.append("R");str.append(" ");str.append(R);str.append("\n");}
            if(B>0){str.append("B");str.append(" ");str.append(B);str.append("\n");}
            if(N>0){str.append("N");str.append(" ");str.append(N);str.append("\n");}
            if(P>0){str.append("P");str.append(" ");str.append(P);str.append("\n");}
        }else {
            int k=1,q=1,r=2,b=2,n=2,p=8;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if(chessComponents[i][j].toString().equals("k")){k--;}
                    if(chessComponents[i][j].toString().equals("q")){q--;}
                    if(chessComponents[i][j].toString().equals("r")){r--;}
                    if(chessComponents[i][j].toString().equals("b")){b--;}
                    if(chessComponents[i][j].toString().equals("n")){n--;}
                    if(chessComponents[i][j].toString().equals("p")){p--;}
                }
            }
            if(k>0){str.append("k");str.append(" ");str.append(k);str.append("\n");}
            if(q>0){str.append("q");str.append(" ");str.append(q);str.append("\n");}
            if(r>0){str.append("r");str.append(" ");str.append(r);str.append("\n");}
            if(b>0){str.append("b");str.append(" ");str.append(b);str.append("\n");}
            if(n>0){str.append("n");str.append(" ");str.append(n);str.append("\n");}
            if(p>0){str.append("p");str.append(" ");str.append(p);str.append("\n");}
        }
        return str.toString();
    }
    public ChessComponent getChess(int x, int y){return chessComponents[x][y];}
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints=chessComponents[source.getX()][source.getY()].canMoveTo();
        for (int i=0;i<canMovePoints.size()-1;i++){
            for (int j=i+1;j<canMovePoints.size();j++){
                if((canMovePoints.get(i).getX()>canMovePoints.get(j).getX())||(canMovePoints.get(i).getX()==canMovePoints.get(j).getX()&&canMovePoints.get(i).getY()>canMovePoints.get(j).getY())){
                    ChessboardPoint m1=canMovePoints.get(i);
                    ChessboardPoint m2=canMovePoints.get(j);
                    canMovePoints.set(i,m2);
                    canMovePoints.set(j,m1);
                }
            }
        }
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        boolean m=false;List<ChessboardPoint> move=getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        if((chessComponents[sourceX][sourceY].getName()>='A'&&chessComponents[sourceX][sourceY].getName()<='Z'&&currentPlayer==ChessColor.WHITE)||
                (chessComponents[sourceX][sourceY].getName()>='a'&&chessComponents[sourceX][sourceY].getName()<='z'&&currentPlayer==ChessColor.BLACK)){
            return false;
        }
        else {
            for (ChessboardPoint chessboardPoint : move) {
                if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                    m = true;
                    break;
                }
            }
            for (int i=0;i<1;i++){
                if(m&&currentPlayer==ChessColor.BLACK){currentPlayer=ChessColor.WHITE;break;}
                if(m&&currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;break;}
            }
            return m;
        }
    }
}
