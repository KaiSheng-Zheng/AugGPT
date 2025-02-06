import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    public ConcreteChessGame()
    {
        chessComponents=new ChessComponent[8][8];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
    {
        chessComponents[sourceX][sourceY].xiazai(chessComponents);



        if(currentPlayer!=recievew(chessComponents[sourceX][sourceY].toString().charAt(0)))

            return false;


        ArrayList<ChessboardPoint> yidong=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if(!yidong.contains(new ChessboardPoint(targetX, targetY)))

            return false;


        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);

        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);

        if (currentPlayer==ChessColor.WHITE)

            currentPlayer=ChessColor.BLACK;
        else
            currentPlayer=ChessColor.WHITE;

        return true;
    }




    StringBuilder wei = new StringBuilder();

    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        for (int orion = 0; orion < 8; orion++) {
            for (int k = 0; k < 8; k++) {
                char row;

                char position = chessboard.get(orion).charAt(k);

                if (position == '_')
                    row = '_';
                else
                    row = (char) (position & (~32));

                switch (row){
                    case 'K':{
                        chessComponents[orion][k] = new KingChessComponent(new ChessboardPoint(orion, k), recievew(position));
                        break;}
                    case 'Q':{
                        chessComponents[orion][k] = new QueenChessComponent(new ChessboardPoint(orion, k), recievew(position));
                        break;
                    }
                    case 'R':{
                        chessComponents[orion][k] = new RookChessComponent(new ChessboardPoint(orion, k), recievew(position));
                        break;
                    }
                    case 'B':{
                        chessComponents[orion][k] = new BishopChessComponent(new ChessboardPoint(orion, k), recievew(position));
break;
                    }
                    case 'N':{
                        chessComponents[orion][k] = new KnightChessComponent(new ChessboardPoint(orion, k), recievew(position));
                        break;
                    }
                    case 'P':{
                        chessComponents[orion][k] = new PawnChessComponent(new ChessboardPoint(orion, k), recievew(position));
                        break;
                    }
                    default:
                        chessComponents[orion][k] = new EmptySlotComponent(new ChessboardPoint(orion, k), recievew(position));

                }

            }
        }

        if (chessboard.get(8).charAt(0)=='b')
            currentPlayer=ChessColor.BLACK;
        else
            currentPlayer=ChessColor.WHITE;
    }

    private ChessColor recievew(char position) {


        if ((position >= 'A' && position <= 'Z'))
            return ChessColor.BLACK;

        else if (position == '_')
            return ChessColor.NONE;

        else
            return ChessColor.WHITE;

    }


    public ChessColor getCurrentPlayer()
    {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                wei.append(chessComponents[k][i].toString());
            }
            if (k != 7)
                wei.append('\n');

        }

        return wei.toString();
    }
    public String getCapturedChess(ChessColor player)
    {
        StringBuilder noone= new StringBuilder();
        int[] xulie= new int[]{'K','Q','R','B','N','P'};
        int[] quanming= new int[]{1,1,2,2,2,8};
        int[] ptone= new int[128];


        for(int k=0;8>k;k++)
        {
            for(int f=0;8>f;f++)
            {
                if(recievew(chessComponents[k][f].toString().charAt(0))==  player)
                    ptone[chessComponents[k][f].toString().charAt(0)&(~32)]++;

            }
        }
        for(int k=0;k<xulie.length;k++)
        {
            char daan;
            if (player == ChessColor.WHITE)
                daan=32;
            else
                daan=0;
            if(ptone[xulie[k]]<quanming[k])
                noone.append((char) (xulie[k] | daan)).append(" ").append(quanming[k] - ptone[xulie[k]]).append("\n");

        }


        return noone.toString();
    }

    public ChessComponent getChess(int x, int y)
    {
        return chessComponents[x][y];
    }
    private static class paixu implements Comparator<ChessboardPoint>
    {

        public int compare(ChessboardPoint qo,ChessboardPoint qt){

            if (qo.getX()==qt.getX())
                return qo.getY()-qt.getY();
            else
                return qo.getX()-qt.getX();
        }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)
    {
        chessComponents[source.getX()][source.getY()].xiazai(chessComponents);
        ArrayList<ChessboardPoint> yidong=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        yidong.sort(new paixu());
        return yidong;
    }
}
