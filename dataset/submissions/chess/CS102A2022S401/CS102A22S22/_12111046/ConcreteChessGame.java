import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private  ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        currentPlayer=ChessColor.WHITE;
        chessComponents=new ChessComponent[8][8];

    }
    void setChessColor(ChessColor color){
        this.currentPlayer=color;
    }
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<chessboard.size()-1;i++){
            String line=chessboard.get(i);
            for(int j=0;j<line.length();j++) {
                if (line.charAt(j) == 'R' || line.charAt(j) == 'r')
                    chessComponents[i][j] = new RookChessComponent(i, j, line.charAt(j),chessComponents);
                else if (line.charAt(j) == 'N' || line.charAt(j) == 'n')
                    chessComponents[i][j] = new KnightChessComponent(i, j, line.charAt(j),chessComponents);
                else if (line.charAt(j) == 'B' || line.charAt(j) == 'b')
                    chessComponents[i][j] = new BishopChessComponent(i, j, line.charAt(j),chessComponents);
                else if (line.charAt(j) == 'Q' || line.charAt(j) == 'q')
                    chessComponents[i][j] = new QueenChessComponent(i, j, line.charAt(j),chessComponents);
                else if (line.charAt(j) == 'K' || line.charAt(j) == 'k')
                    chessComponents[i][j] = new KingChessComponent(i, j, line.charAt(j),chessComponents);
                else if (line.charAt(j) == 'P' || line.charAt(j) == 'p')
                    chessComponents[i][j] = new PawnChessComponent(i, j, line.charAt(j),chessComponents);
                else
                    chessComponents[i][j] = new EmptySlotComponent(i, j, line.charAt(j));

            }
        }
        if(chessboard.get(chessboard.size()-1).charAt(0)=='w')
            this.currentPlayer=ChessColor.WHITE;
        else
            this.currentPlayer=ChessColor.BLACK;
    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }


    public ChessComponent getChess(int x, int y){
        return  chessComponents[x][y];
    }


    public String getChessboardGraph(){
        String graph="";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                graph+=String.valueOf(chessComponents[i][j].getName());
            }
            graph+="\n";
        }
        return graph;
    }

    private int numOfChar(String str,char ch){
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==ch)
                count+=1;
        }
        return count;
    }
    public String getCapturedChess(ChessColor player){
        String result="";
        String str="KQRBNP";
        if(player==ChessColor.WHITE)
            str=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            int count=numOfChar(getChessboardGraph(),str.charAt(i));
            if(str.charAt(i)=='K'||str.charAt(i)=='k'||str.charAt(i)=='Q'||str.charAt(i)=='q'){
                if(count==0)
                    result=result+str.charAt(i)+" 1\n";
            }
            else if(str.charAt(i)=='P'||str.charAt(i)=='p'){
                if(count!=8)
                    result=result+str.charAt(i)+" "+(8-count)+"\n";
            }
            else if(str.charAt(i)!='_')
            {
                if(count!=2)
                    result=result+str.charAt(i)+" "+(2-count)+"\n";
            }

        }
        return result;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints,new sortByX_Y());
        return canMovePoints;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
            return false;
        List<ChessboardPoint> canMovePoints=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        for(int i=0;i<canMovePoints.size();i++){
            System.out.println(canMovePoints.get(i));
            if(canMovePoints.get(i).getX()==targetX && canMovePoints.get(i).getY()==targetY)
            {
                ChessComponent tmp=getChess(sourceX,sourceY);
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY,'_');
                tmp.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=tmp;
                
                if(currentPlayer==ChessColor.BLACK)
                    currentPlayer=ChessColor.WHITE;
                else
                    currentPlayer=ChessColor.BLACK;
                return true;
            }
        }
        return false;}
    private ChessComponent getComponent(ChessboardPoint point){
        return chessComponents[point.getX()][point.getY()];
    }

}
