import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame()
    {
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard)
    {
        int j=0;
        for(j=0;j<chessComponents.length;j++)
        {
            String str=chessboard.get(j);
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='R'||str.charAt(i)=='r')
                {
                    if(str.charAt(i)=='R') {
                        chessComponents[j][i] = new RookChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'R');
                    }else
                    {
                        chessComponents[j][i] = new RookChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'r');
                    }
                }
               else if(str.charAt(i)=='N'||str.charAt(i)=='n')
                {
                    if(str.charAt(i)=='N') {
                        chessComponents[j][i] = new KnightChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'N');
                    }else
                    {
                        chessComponents[j][i] = new KnightChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'n');
                    }
                }
                else if(str.charAt(i)=='B'||str.charAt(i)=='b')
                {
                    if(str.charAt(i)=='B') {
                        chessComponents[j][i] = new BishopChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'B');
                    }else
                    {
                        chessComponents[j][i] = new BishopChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'b');
                    }
                }
               else if(str.charAt(i)=='Q'||str.charAt(i)=='q')
                {
                    if(str.charAt(i)=='Q') {
                        chessComponents[j][i] = new QueenChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'Q');
                    }else
                    {
                        chessComponents[j][i] = new QueenChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'q');
                    }
                }
               else if(str.charAt(i)=='K'||str.charAt(i)=='k')
                {
                    if(str.charAt(i)=='K') {
                        chessComponents[j][i] = new KingChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'K');
                    }else
                    {
                        chessComponents[j][i] = new KingChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'k');
                    }
                }
                else if(str.charAt(i)=='P'||str.charAt(i)=='p')
                {
                    if(str.charAt(i)=='P') {
                        chessComponents[j][i] = new PawnChessComponent(new ChessboardPoint(j,i),ChessColor.BLACK,'P');
                    }else
                    {
                        chessComponents[j][i] = new PawnChessComponent(new ChessboardPoint(j,i),ChessColor.WHITE,'p');
                    }
                }
                else
                {
                    chessComponents[j][i] = new EmptySlotComponent(new ChessboardPoint(j,i),ChessColor.NONE,'_');
                }
            }
        }
        String str=chessboard.get(j);
        if(str.equals("w"))this.currentPlayer=ChessColor.WHITE;
        else this.currentPlayer=ChessColor.BLACK;
    }
    public ChessColor getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    public String getChessboardGraph()
    {
        String res="";
        for(int i=0;i<chessComponents.length;i++)
        {
            for(int j=0;j<chessComponents[i].length;j++)
            {
                res+=chessComponents[i][j].name;
            }
            if(i!=7)res+="\n";
        }
        return res;
    }
    public ChessComponent getChess(int x, int y)
    {
        return chessComponents[x][y];
    }
    public String getCapturedChess(ChessColor player)
    {
        String res="";
        Map<Character, Integer>map=new HashMap<>();
        for(int i=0;i<chessComponents.length;i++)
            {
                for(int j=0;j<chessComponents[i].length;j++) {
                     if(chessComponents[i][j].getChessColor()==player)
                     {
                         //System.out.println(chessComponents[i][j].name);
                         if(map.containsKey(chessComponents[i][j].name))
                         {
                             map.put(chessComponents[i][j].name,map.get(chessComponents[i][j].name)+1);
                         }
                         else
                         {
                             map.put(chessComponents[i][j].name,1);
                         }
                     }
                }
            }
        if(player==ChessColor.BLACK)
        {
            if(!map.containsKey('K'))res+="K 1\n";
            if(!map.containsKey('Q'))res+="Q 1\n";
            if(!map.containsKey('R'))res+="R 2\n";
            else if(map.get('R')<2)res+="R 1\n";
            if(!map.containsKey('B'))res+="B 2\n";
            else if(map.get('B')<2)res+="B 1\n";
            if(!map.containsKey('N'))res+="N 2\n";
            else if(map.get('N')<2)res+="N 1\n";
            if(!map.containsKey('P'))res+="P 8\n";
            else if(map.get('P')<8)res+="P "+String.valueOf(8-map.get('P'));
        }
        else
        {
            if(!map.containsKey('k'))res+="k 1\n";
            if(!map.containsKey('q'))res+="q 1\n";
            if(!map.containsKey('r'))res+="r 2\n";
            else if(map.get('r')<2)res+="r 1\n";
            if(!map.containsKey('b'))res+="b 2\n";
            else if(map.get('b')<2)res+="b 1\n";
            if(!map.containsKey('n'))res+="n 2\n";
            else if(map.get('n')<2)res+="n 1\n";
            if(!map.containsKey('p'))res+="p 8\n";
            else if(map.get('p')<8)res+="p "+String.valueOf(8-map.get('p'));
        }
        return res;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
    {
        if(chessComponents[sourceX][sourceY].getChessColor()!=this.currentPlayer||chessComponents[targetX][targetY].getChessColor()==this.currentPlayer)return false;
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].getSource().setX(targetX);
        chessComponents[targetX][targetY].getSource().setY(targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
        return true;

    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)
    {
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo(chessComponents);
    }


  /*  public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("RNBQKBNR");
        list.add("PPPPPPPP");
        list.add("________");
        list.add("________");
        list.add("________");
        list.add("________");
        list.add("pppppppp");
        list.add("rnbqkbnr");
        list.add("w");
        ConcreteChessGame concreteChessGame=new ConcreteChessGame();
        concreteChessGame.loadChessGame(list);
        System.out.println(concreteChessGame.getChessboardGraph());
        System.out.println(concreteChessGame.currentPlayer);
        System.out.println(concreteChessGame.getCapturedChess(ChessColor.BLACK));
    }*/

}
