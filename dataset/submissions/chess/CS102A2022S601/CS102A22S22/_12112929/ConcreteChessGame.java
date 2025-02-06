import java.util.*;

public class ConcreteChessGame implements ChessGame {
   private ChessComponent[][] chessComponents=new ChessComponent[8][8];
   private ChessColor currentPlayer;
    @Override
    public void loadChessGame(List<String> chessboard) {
for(int i=0;i<8;i++){
    String row=chessboard.get(i);
    for(int j=0;j<8;j++){
        if(row.charAt(j)=='R'){
            chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='N'){
            chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='B'){
            chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        } if(row.charAt(j)=='Q'){
            chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='K'){
            chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='P'){
            chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='r'){
            chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='n'){
            chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='b'){
            chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='q'){
            chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='k'){
            chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='p'){
            chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
        }
        if(row.charAt(j)=='_'){
            chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j),chessComponents);
        }

    }
}
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
        if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph() {
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                s1.append(chessComponents[i][j].toString());
            }s1.append("\n");
        }
        s1.delete(s1.length()-1,s1.length()-1);
        String s= s1.toString();
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int C1=1,C2=1,C3=2,C4=2,C5=2,C6=8;
        int c1=1,c2=1,c3=2,c4=2,c5=2,c6=8;
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<getChessboardGraph().length();i++){
            if(getChessboardGraph().charAt(i)==('K')){
                C1-=1;
            }
            if(getChessboardGraph().charAt(i)==('Q')){
                C2-=1;
            }
            if(getChessboardGraph().charAt(i)==('R')){
                C3-=1;
            }
            if(getChessboardGraph().charAt(i)==('B')){
                C4-=1;
            }
            if(getChessboardGraph().charAt(i)==('N')){
                C5-=1;
            }
            if(getChessboardGraph().charAt(i)==('P')){
                C6-=1;
            }
            if(getChessboardGraph().charAt(i)==('k')){
                c1-=1;
            }
            if(getChessboardGraph().charAt(i)==('q')){
                c2-=1;
            }
            if(getChessboardGraph().charAt(i)==('r')){
                c3-=1;
            }
            if(getChessboardGraph().charAt(i)==('b')){
                c4-=1;
            }
            if(getChessboardGraph().charAt(i)==('n')){
                c5-=1;
            }
            if(getChessboardGraph().charAt(i)==('p')){
                c6-=1;
            }
        }
        if(player==ChessColor.BLACK){
            if(C1!=0){
                s1.append("K 1\n");
            }
            if(C2!=0){
                s1.append("Q 1\n");
            }
            if(C3!=0){
                if(C3==1)
                    s1.append("R 1\n");
                if(C3==2)
                    s1.append("R 2\n");
            }
            if(C4!=0){
                if(C4==1)
                    s1.append("B 1\n");
                if(C4==2)
                    s1.append("B 2\n");
            }
            if(C5!=0){
                if(C5==1)
                    s1.append("N 1\n");
                if(C5==2)
                    s1.append("N 2\n");
            }
            if(C6!=0){
                if(C6==1)
                    s1.append("P 1\n");
                if(C6==2)
                    s1.append("P 2\n");
                if(C6==3)
                    s1.append("P 3\n");
                if(C6==4)
                    s1.append("P 4\n");
                if(C6==5)
                    s1.append("P 5\n");
                if(C6==6)
                    s1.append("P 6\n");
                if(C6==7)
                    s1.append("P 7\n");
                if(C6==8)
                    s1.append("P 8\n");
            }
            String s=s1.toString();
            return s;
        }
        else if(player==ChessColor.WHITE){
            if(c1!=0){
                s1.append("k 1\n");
            }
            if(c2!=0){
                s1.append("q 1\n");
            }
            if(c3!=0){
                if(c3==1)
                    s1.append("r 1\n");
                if(c3==2)
                    s1.append("r 2\n");
            }
            if(c4!=0){
                if(c4==1)
                    s1.append("b 1\n");
                if(c4==2)
                    s1.append("b 2\n");
            }
            if(c5!=0){
                if(c5==1)
                    s1.append("n 1\n");
                if(c5==2)
                    s1.append("n 2\n");
            }
            if(c6!=0){
                if(c6==1)
                    s1.append("p 1\n");
                if(c6==2)
                    s1.append("p 2\n");
                if(c6==3)
                    s1.append("p 3\n");
                if(c6==4)
                    s1.append("p 4\n");
                if(c6==5)
                    s1.append("p 5\n");
                if(c6==6)
                    s1.append("p 6\n");
                if(c6==7)
                    s1.append("p 7\n");
                if(c6==8)
                    s1.append("p 8\n");
            }
            String s=s1.toString();
            return s;
        }else
            return null;
    }
    @Override
    public ChessComponent getChess(int x,int y) {

        return chessComponents[x][y];
    }
    public java.util.List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint>list=new ArrayList<>();
        list=chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(list, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()<o2.getX())
                    return -1;
                else if(o1.getX()>o2.getX())
                    return 1;
                else{
                    if(o1.getY()<o2.getY())
                        return -1;
                    else if(o1.getY()>o2.getY()) return 1;
                    else return 0;
                }
            }
        });
        ChessboardPoint c = source;
                   return list;
            //return chessComponents[source.getX()][source.getY()].canMoveTo();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int p=0;
        if(targetX>=8||targetY>=8){
            return false;
        }
        for(int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
            if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY)
                p=1;
        }
        if (sourceY == targetY && sourceX == targetX) {
            return false;
        } else if (chessComponents[sourceX][sourceY].getChessColor() == getCurrentPlayer() && (sourceY != targetY || sourceX != targetX)&&p==1) {
            if (currentPlayer == ChessColor.BLACK) {
                currentPlayer = ChessColor.WHITE;
            } else if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            }
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY].setSource(targetX, targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(sourceX, sourceY), chessComponents);
            return true;
        } else
            return false;
    }
}
