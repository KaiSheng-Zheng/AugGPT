import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;
    private List<String> chessboard;
    public ConcreteChessGame()
    {
        this.chessComponents=new ChessComponent[8][8];
          currentPlayer=getCurrentPlayer();
    }

    public void loadChessGame(List<String> chessboard)
    {
        this.chessboard=chessboard;
        for(int i=0;i<=7;i++)
        {
            for(int j=0;j<=7;j++)
            {
                char zi=chessboard.get(i).charAt(j);
                if(zi=='R')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    RookChessComponent z= new RookChessComponent(chessboardPoint,ChessColor.BLACK,'R',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='r')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    RookChessComponent z= new RookChessComponent(chessboardPoint,ChessColor.WHITE,'r',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='N')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    KnightChessComponent z= new KnightChessComponent(chessboardPoint,ChessColor.BLACK,'N',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='n')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    KnightChessComponent z= new KnightChessComponent(chessboardPoint,ChessColor.WHITE,'n',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='B')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    BishopChessComponent z= new BishopChessComponent(chessboardPoint,ChessColor.BLACK,'B',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='b')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    BishopChessComponent z= new BishopChessComponent(chessboardPoint,ChessColor.WHITE,'b',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='Q')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    QueenChessComponent z= new QueenChessComponent(chessboardPoint,ChessColor.BLACK,'Q',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='q')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    QueenChessComponent z= new QueenChessComponent(chessboardPoint,ChessColor.WHITE,'q',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='K')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    KingChessComponent z= new KingChessComponent(chessboardPoint,ChessColor.BLACK,'K',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='k')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    KingChessComponent z= new KingChessComponent(chessboardPoint,ChessColor.WHITE,'k',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='P')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    PawnChessComponent z= new PawnChessComponent(chessboardPoint,ChessColor.BLACK,'P',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='p')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    PawnChessComponent z= new PawnChessComponent(chessboardPoint,ChessColor.WHITE,'p',this.chessComponents);
                    chessComponents[i][j]=z;
                }
                if(zi=='_')
                {
                    ChessboardPoint chessboardPoint= new ChessboardPoint(i,j);
                    EmptySlotComponent z= new EmptySlotComponent(chessboardPoint,ChessColor.NONE,'_',this.chessComponents);
                    chessComponents[i][j]=z;
                }

            }
        }
        if(chessboard.get(8).charAt(0)=='w')
        {
            this.currentPlayer=ChessColor.WHITE;
        }
         if(chessboard.get(8).charAt(0)=='b')
        {
            this.currentPlayer=ChessColor.BLACK;
        }
    }
   // @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph()
    {

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",this.chessboard.get(0),this.chessboard.get(1),this.chessboard.get(2),this.chessboard.get(3),this.chessboard.get(4),this.chessboard.get(5),this.chessboard.get(6),this.chessboard.get(7));

//        for(int i=0;i<=7;i++)
//        {
//
//            for(int j=0;j<=7;j++)
//            {
//                System.out.print(chessComponents[i][j].toString());
//                if(j==7)
//                {
//                    System.out.print("\n");
//                }
//            }
//        }
    }
    public String getCapturedChess(ChessColor player)
    {
        StringBuilder sb=new StringBuilder();
        int[] counter= new int[6];
        counter[0]=1;counter[1]=1;counter[2]=2;counter[3]=2;counter[4]=2;counter[5]=8;
        if(player==ChessColor.BLACK) {
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if(chessComponents[i][j].name == 'K')  counter[0]--;
                    if(chessComponents[i][j].name == 'Q')  counter[1]--;
                    if(chessComponents[i][j].name == 'R')  counter[2]--;
                    if(chessComponents[i][j].name == 'B')  counter[3]--;
                    if(chessComponents[i][j].name == 'N')  counter[4]--;
                    if(chessComponents[i][j].name == 'P')  counter[5]--;
                }
            }
            if(counter[0]!=0)
            {
                sb.append("K ");
                sb.append(counter[0]);
                sb.append("\n");
            }
            if(counter[1]!=0)
            {
                sb.append("Q ");
                sb.append(counter[1]);
                sb.append("\n");
            }
            if(counter[2]!=0)
            {
                sb.append("R ");
                sb.append(counter[2]);
                sb.append("\n");
            }
            if(counter[3]!=0)
            {
                sb.append("B ");
                sb.append(counter[3]);
                sb.append("\n");
            }
            if(counter[4]!=0)
            {
                sb.append("N ");
                sb.append(counter[4]);
                sb.append("\n");
            }
            if(counter[5]!=0)
            {
                sb.append("P ");
                sb.append(counter[5]);
                sb.append("\n");
            }
        }
        if(player==ChessColor.WHITE)
        {
            for (int i = 0; i <=7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if(chessComponents[i][j].name == 'k')  counter[0]--;
                    if(chessComponents[i][j].name == 'q')  counter[1]--;
                    if(chessComponents[i][j].name == 'r')  counter[2]--;
                    if(chessComponents[i][j].name == 'b')  counter[3]--;
                    if(chessComponents[i][j].name == 'n')  counter[4]--;
                    if(chessComponents[i][j].name == 'p')  counter[5]--;
                }
            }
            if(counter[0]!=0)
            {
                sb.append("k ");
                sb.append(counter[0]);
                sb.append("\n");
            }
            if(counter[1]!=0)
            {
                sb.append("q ");
                sb.append(counter[1]);
                sb.append("\n");
            }
            if(counter[2]!=0)
            {
                sb.append("r ");
                sb.append(counter[2]);
                sb.append("\n");
            }
            if(counter[3]!=0)
            {
                sb.append("b ");
                sb.append(counter[3]);
                sb.append("\n");
            }
            if(counter[4]!=0)
            {
                sb.append("n ");
                sb.append(counter[4]);
                sb.append("\n");
            }
            if(counter[5]!=0)
            {
                sb.append("p ");
                sb.append(counter[5]);
                sb.append("\n");
            }
        }

       return sb.toString();
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int m=source.getX(),n=source.getY();
        List<ChessboardPoint> sb=chessComponents[m][n].canMoveTo();
        for(int i=0;i<sb.size()-1;i++){
            for(int j=i+1;j<sb.size();j++){
                if(sb.get(i).getX()>sb.get(j).getX()){
                    Collections.swap(sb,i,j);
                }
                else if(sb.get(i).getX()==sb.get(j).getX()&&sb.get(i).getY()>sb.get(j).getY())
                {
                        Collections.swap(sb,i,j);
                }
            }
        }

        return  sb;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(targetX<0||targetY<0||targetX>7||targetY>7||sourceX<0||sourceY<0||sourceX>7||sourceY>7||chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
        {return  false;}
            List<ChessboardPoint> sb=chessComponents[sourceX][sourceY].canMoveTo();

        for(int i=0;i<sb.size();i++)
        {
            if(sb.get(i).getX()==targetX&&sb.get(i).getY()==targetY)
            {
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }
                else if(currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                 chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',this.chessComponents);
              return true;
            }
        }
        return false;
    }


    public ChessComponent getChess(int x, int y)
    {
        return chessComponents[x][y];
    }

}
