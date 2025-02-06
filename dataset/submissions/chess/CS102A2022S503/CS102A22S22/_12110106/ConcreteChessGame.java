import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    private List<String> chessboard;
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];

    }



    private ChessColor getComponentColor(char name){
        if(name=='_'){
            return ChessColor.NONE;
        }
        else if(65<=name &&name<=90){
            return ChessColor.BLACK;
        }
        return ChessColor.WHITE;
    }



    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char chessComponent=chessboard.get(i).charAt(j);
                char name;
                if(chessComponent=='_'){name='_';}
                else{name= (char) (chessComponent&(~32));}
                switch(name){
                    case'K':
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case 'Q':
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case 'R':
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case'B':
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case 'N':
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case'P':
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                    case'_':
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i, j),getComponentColor(chessComponent));
                break;
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else{
             currentPlayer=ChessColor.BLACK;
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
        String chessboardGraph ="";
        for(int i=0; i<7;i++){
            for(int j=0;j<8;j++){
                chessboardGraph=chessboardGraph+chessComponents[i][j];
            }
            chessboardGraph=chessboardGraph+"\n";
        }
        for(int i=0;i<8 ;i++){
            chessboardGraph=chessboardGraph+chessComponents[7][i];
        }
        return chessboardGraph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String answer="";
        int[] name=new int[12];
        for(int i=0;i<12;i++){name[i]=0;}
        //1 to 6: k to p ; 7 to 12: K to P
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                switch(chessComponents[i][j].getName()){
                    case'k':
                        name[0]++;
                        break;
                    case'q':
                        name[1]++;
                        break;
                    case'r':
                        name[2]++;
                        break;
                    case'b':
                        name[3]++;
                        break;
                    case'n':
                        name[4]++;
                        break;
                    case'p':
                        name[5]++;
                        break;
                    case'K':
                        name[6]++;
                        break;
                    case'Q':
                        name[7]++;
                        break;
                    case'R':
                        name[8]++;
                        break;
                    case'B':
                        name[9]++;
                        break;
                    case'N':
                        name[10]++;
                        break;
                    case'P':
                        name[11]++;
                        break;
                }
            }
        }
        if(player.equals(ChessColor.WHITE)){
            answer="";
            if(name[0]<1){
                answer=answer+"k"+" "+(1-name[0])+"\n";
            }
            if(name[1]<1){
                answer=answer+"q"+" "+(1-name[1])+"\n";
            }
            if(name[2]<2){
                answer=answer+"r"+" "+(2-name[2])+"\n";
            }
            if(name[3]<2){
                answer=answer+"b"+" "+(2-name[3])+"\n";
            }
            if(name[4]<2){
                answer=answer+"n"+" "+(2-name[4])+"\n";
            }
            if(name[5]<8){
                answer=answer+"p"+" "+(8-name[5])+"\n";
            }
            return answer;
        }
        else{
            answer="";
            if(name[6]<1){
                answer=answer+"K"+" "+(1-name[6])+"\n";
            }
            if(name[7]<1){
                answer=answer+"Q"+" "+(1-name[7])+"\n";
            }
            if(name[8]<2){
                answer=answer+"R"+" "+(2-name[8])+"\n";
            }
            if(name[9]<2){
                answer=answer+"B"+" "+(2-name[9])+"\n";
            }
            if(name[10]<2){
                answer=answer+"N"+" "+(2-name[10])+"\n";
            }
            if(name[11]<8){
                answer=answer+"P"+" "+(8-name[11])+"\n";
            }
            return answer;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].load(chessComponents);
        ArrayList<ChessboardPoint> zero=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        zero.sort(new Sort());
        return zero;
    }
    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint a,ChessboardPoint b){
            if(a.getX()== b.getX()){return a.getY()-b.getY();}
            else return (a.getX()- b.getX());
        }
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].load(chessComponents);
        if(getComponentColor(chessComponents[sourceX][sourceY].getName())!=currentPlayer){
            return false;
        }
        ArrayList<ChessboardPoint> move=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();

        if(!move.contains(new ChessboardPoint(targetX, targetY))){return false;}

        //chizi
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);

        //huanzi
        if(currentPlayer==ChessColor.WHITE){
            currentPlayer=ChessColor.BLACK;
        }
        else{currentPlayer=ChessColor.WHITE;}
        return true;
    }
}
