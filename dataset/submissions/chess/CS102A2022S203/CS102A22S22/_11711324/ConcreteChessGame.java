import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private String blackItems="KQRBNP";
    private String whiteItems="kqrbnp";
    public ConcreteChessGame(){
        this.currentPlayer=ChessColor.NONE;
        chessComponents=new ChessComponent[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<0;j++){
                chessComponents[i][j]=new EmptySlotComponent();
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        //upper case->black lower case->white
        int n=chessboard.size();
        if(Objects.equals(chessboard.get(n - 1), "w")){
            this.currentPlayer=ChessColor.WHITE;
        }
        else this.currentPlayer=ChessColor.BLACK;
        for(int i=0;i<n-1;i++){
            String current=chessboard.get(i);
            for(int j=0;j<8;j++){
                if(current.charAt(j)=='k')
                    chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='K')
                    chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='Q')
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='q')
                    chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='N')
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='n')
                    chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='p')
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='P')
                    chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='b')
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='B')
                    chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='R')
                    chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                else if(current.charAt(j)=='r')
                    chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                else chessComponents[i][j]=new EmptySlotComponent();
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++)
                chessComponents[i][j].setChessComponents(chessComponents);
        }
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
        String result="";
        for(int i=0;i<8;i++){
            if(i!=0) result+="\n";
            for(int j=0;j<8;j++){
                result+= new String(String.valueOf(chessComponents[i][j].name));
            }
        }
        return result;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String target;
        if(player==ChessColor.BLACK){
            target=blackItems;
        }
        else target=whiteItems;
        String ans="";
        for(int i=0;i<target.length();i++){
            char cur=target.charAt(i);
            int cnt=0;
            for(int j=0;j<8;j++){
                for(int k=0;k<8;k++){
                    if(chessComponents[j][k].name==cur){
                        cnt+=1;
                    }
                }
            }
            if(i<2&&cnt==0) ans+=String.format("%c %d\n",cur,1-cnt);
            if(i<5&&i>=2&&cnt!=2) ans+=String.format("%c %d\n",cur,2-cnt);
            if(i==5&&cnt!=8) ans+=String.format("%c %d\n",cur,8-cnt);
        }
        return ans;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        List<ChessboardPoint> possible=chessComponents[source.getX()][source.getY()].canMoveTo();
        List<ChessboardPoint> ans=new ArrayList<>();
        for(ChessboardPoint cp: possible){
            if(check(source.getX(),source.getY(), cp.getX(),cp.getY()))
                ans.add(cp);
        }
        Collections.sort(ans, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()!=o2.getX())
                return o1.getX()- o2.getX();
                return o1.getY()-o2.getY();
            }
        });
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(getChess(sourceX,sourceY).getColor()!=currentPlayer)
            return false;
        boolean result=check(sourceX,sourceY,targetX,targetY);
         if(result){
             chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
             chessComponents[targetX][targetY].moveTo(new ChessboardPoint(targetX,targetY));
             chessComponents[sourceX][sourceY]=new EmptySlotComponent();
             chessComponents[targetX][targetY].setChessComponents(chessComponents);
             if(currentPlayer==ChessColor.BLACK) currentPlayer=ChessColor.WHITE;
             else currentPlayer=ChessColor.BLACK;
         }
         return result;
    }
    boolean check(int sourceX, int sourceY, int targetX, int targetY){
        boolean result=false;
        List<ChessboardPoint> possible=chessComponents[sourceX][sourceY].canMoveTo();
        for(ChessboardPoint cp:possible){
            if(targetX==cp.getX()&&targetY==cp.getY()) {
                result = true;
                break;
            }
        }

        return result;
    }
}
