import java.util.List;

public class ConcreteChessGame implements ChessGame
{
    public static void swap(List<ChessboardPoint> list, int i, int j)
    {
        ChessboardPoint temp1;
        ChessboardPoint temp2;
        temp1=list.get(i);
        temp2=list.get(j);
        list.remove(i);
        list.remove(j);
        list.add(j,temp1);
        list.add(i,temp2);
    }
    public static void sort(List<ChessboardPoint> list)
    {
        for(int i=1;i<list.size();i++)
        {
            for(int j=i;j>0;j--)
            {
                if(list.get(j).getX()< list.get(j-1).getX())
                {
                    swap(list,j,j-1);
                }
                else if(list.get(j).getX()==list.get(j-1).getX()&&list.get(j).getY()< list.get(j-1).getY())
                {
                    swap(list,j,j-1);
                }
            }
        }
    }
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer = ChessColor.WHITE;
    private List<String> list;
    public ConcreteChessGame()
    {
        chessComponents=new ChessComponent[8][8];
    }

    public ChessComponent[][] getChessComponents()
    {

        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard)
    {
        for(int i = 0;i<chessboard.size()-1;i++ )
        {
            for(int j = 0;j<chessboard.get(i).length();j++)
            {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(chessComponents, i, j, ChessColor.BLACK);
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(chessComponents, i, j, ChessColor.WHITE);
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(chessComponents, i, j);
                }
            }
        }
        list = chessboard;
        currentPlayer=(chessboard.get(8).equals("w"))?ChessColor.WHITE:ChessColor.BLACK;
    }
    public ChessColor getCurrentPlayer()
    {
        return this.currentPlayer;

    }
    public String getChessboardGraph()
    {
        return list.get(0)+"\n"+list.get(1)+"\n"+list.get(2)+"\n"+list.get(3)+"\n"+list.get(4)+"\n"+list.get(5)+"\n"+list.get(6)+"\n"+list.get(7);
    }
    public String getCapturedChess(ChessColor player)
    {

        int countK = 1;
        int countQ = 1;
        int countR = 2;
        int countB = 2;
        int countN = 2;
        int countP = 8;
        StringBuilder str = new StringBuilder();
        String str0= new String();
        if (player == ChessColor.BLACK)
        {
            for(int i = 0;i<8;i++)
            {
                for(int j = 0;j<8;j++)
                {
                    switch(chessComponents[i][j].name)
                    {
                        case'K':countK--;break;
                        case'Q':countQ--;break;
                        case'R':countR--;break;
                        case'B':countB--;break;
                        case'N':countN--;break;
                        case'P':countP--;
                    }
                }
            }
            if(countK!=0){str.append("K "+countK);}
            if(countQ!=0){str.append("\nQ "+countQ);}
            if(countR!=0){str.append("\nR "+countR);}
            if(countB!=0){str.append("\nB "+countB);}
            if(countN!=0){str.append("\nN "+countN);}
            if(countP!=0){str.append("\nP "+countP);}
            str0=str.toString();
        }
        if (player == ChessColor.WHITE)
        {
            for(int i = 0;i<8;i++)
            {
                for(int j = 0;j<8;j++)
                {
                    switch(chessComponents[i][j].name)
                    {
                        case'k':countK--;break;
                        case'q':countQ--;break;
                        case'r':countR--;break;
                        case'b':countB--;break;
                        case'n':countN--;break;
                        case'p':countP--;
                    }
                }
            }
            if(countK!=0){str.append("k "+countK);}
            if(countQ!=0){str.append("\nq "+countQ);}
            if(countR!=0){str.append("\nr "+countR);}
            if(countB!=0){str.append("\nb "+countB);}
            if(countN!=0){str.append("\nn "+countN);}
            if(countP!=0){str.append("\np "+countP);}
            str0=str.toString();
        }
        return str0;

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> list = chessComponents[source.getX()][source.getY()].canMoveTo();
        sort(list);
        return list;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        boolean canMove =false;
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
        {
            canMove = false;
        }
       else{
           for(int i =0;i<getCanMovePoints(source).size();i++)
       {
           if(getCanMovePoints(source).get(i).getX()==targetX&&getCanMovePoints(source).get(i).getY()==targetY)
           {
               switch (chessComponents[sourceX][sourceY].name)
               {
                   case 'R'-> chessComponents[targetX][targetY] = new RookChessComponent(chessComponents, targetX, targetY, ChessColor.BLACK);
                   case 'r'-> chessComponents[targetX][targetY] = new RookChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case 'K'-> chessComponents[targetX][targetY] = new KingChessComponent(chessComponents, targetX, targetY, ChessColor.BLACK);
                   case 'k'-> chessComponents[targetX][targetY] = new KingChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case 'P'-> chessComponents[targetX][targetY] = new PawnChessComponent(chessComponents, targetX, targetY,ChessColor.BLACK);
                   case 'p'-> chessComponents[targetX][targetY] = new PawnChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case 'Q'-> chessComponents[targetX][targetY] = new QueenChessComponent(chessComponents, targetX, targetY, ChessColor.BLACK);
                   case 'q'-> chessComponents[targetX][targetY] = new QueenChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case 'B' -> chessComponents[targetX][targetY] = new BishopChessComponent(chessComponents, targetX, targetY, ChessColor.BLACK);
                   case 'b' -> chessComponents[targetX][targetY] = new BishopChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case 'N' -> chessComponents[targetX][targetY] = new KnightChessComponent(chessComponents, targetX, targetY, ChessColor.BLACK);
                   case 'n' -> chessComponents[targetX][targetY] = new KnightChessComponent(chessComponents, targetX, targetY, ChessColor.WHITE);
                   case '_' -> chessComponents[targetX][targetY] = new EmptySlotComponent(chessComponents, targetX, targetY);
               }

               chessComponents[sourceX][sourceY]=new EmptySlotComponent(chessComponents,sourceX,sourceY);
               canMove = true;
               break;
           }
           else {canMove=false;}
       }
       }
       if(canMove){
           boolean white = currentPlayer==ChessColor.WHITE;
       currentPlayer = (white)?ChessColor.BLACK:ChessColor.WHITE;
       }
       return canMove;
    }

    public ChessComponent getChess(int x, int y)
    {
        return chessComponents[x][y];
    }



}
