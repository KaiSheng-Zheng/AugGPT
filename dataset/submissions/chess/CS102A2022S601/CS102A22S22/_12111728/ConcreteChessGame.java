import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame
{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    List<String> chessboard;
    @Override
    public void loadChessGame(List<String> chessboard)
    {
        this.chessboard=chessboard;
        for(int i=0;i<=7;i++)
        {
            for(int j=0;j<=7;j++)
            {
                char a=chessboard.get(i).charAt(j);
                if(a=='K' || a=='k')
                {
                    if(a=='K') chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    else chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if(a=='Q' || a=='q')
                {
                    if(a=='Q') chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    if(a=='q') chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if(a=='R' || a=='r')
                {
                    if(a=='R') chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    if(a=='r') chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if (a=='B' || a=='b')
                {
                    if(a=='B') chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    if(a=='b') chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if(a=='N' || a=='n')
                {
                    if(a=='N') chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j),chessComponents);
                    if(a=='n') chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if(a=='P' || a=='p')
                {
                    if(a=='P') chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),chessComponents);
                    if(a=='p') chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),chessComponents);
                }
                else if(a=='_')
                {
                    chessComponents[i][j]=new EmptyChessComponent();
                }
            }
        }
        currentPlayer=(chessboard.get(8).charAt(0)=='w')?ChessColor.WHITE:ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer()
    {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y)
    {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph()
    {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",chessboard.get(0),chessboard.get(1),chessboard.get(2),chessboard.get(3),chessboard.get(4),chessboard.get(5),chessboard.get(6),chessboard.get(7));

    }

    @Override
    public String getCapturedChess(ChessColor player)
    {
        int king=1;
        int queen=1;
        int rook=2;
        int bishop=2;
        int knight=2;
        int pawn=8;
        for(int i=0;i<=7;i++)
        {
            for(int j=0;j<=7;j++)
            {
                ChessComponent a=chessComponents[i][j];
//                if(chessComponents[i][j] instanceof KingChessComponent &&) king--;
//                if(chessComponents[i][j] instanceof QueenChessComponent) queen--;
//                if(chessComponents[i][j] instanceof RookChessComponent) rook--;
//                if(chessComponents[i][j] instanceof KnightChessComponent) knight--;
//                if(chessComponents[i][j] instanceof BishopChessComponent) bishop--;
//                if(chessComponents[i][j] instanceof PawnChessComponent) pawn--;
                if(a instanceof KingChessComponent && a.getChessColor()==player) king--;
                if(a instanceof QueenChessComponent && a.getChessColor()==player) queen--;
                if(a instanceof RookChessComponent && a.getChessColor()==player) rook--;
                if(a instanceof KnightChessComponent && a.getChessColor()==player) knight--;
                if(a instanceof BishopChessComponent && a.getChessColor()==player) bishop--;
                if(a instanceof PawnChessComponent && a.getChessColor()==player) pawn--;
            }
        }
        StringBuffer a=new StringBuffer();
        if(king>0) a.append(player==ChessColor.BLACK?"K "+king+"\n":"k "+king+"\n");
        if(queen>0) a.append(player==ChessColor.BLACK?"Q "+queen+"\n":"q "+queen+"\n");
        if(rook>0) a.append(player==ChessColor.BLACK?"R "+rook+"\n":"r "+rook+"\n");
        if(bishop>0) a.append(player==ChessColor.BLACK?"B "+bishop+"\n":"b "+bishop+"\n");
        if(knight>0) a.append(player==ChessColor.BLACK?"N "+knight+"\n":"n "+knight+"\n");
        if(pawn>0) a.append(player==ChessColor.BLACK?"P "+pawn+"\n":"p "+pawn+"\n");
        return a.toString();
    }
    public static void kick(ChessboardPoint source,ChessComponent[][] chessComponents,List<ChessboardPoint> canMovePoints)
    {
        for(int i=canMovePoints.size()-1;i>=0;i--)
        {
            if(chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor())
                canMovePoints.remove(i);
        }
        if(chessComponents[source.getX()][source.getY()] instanceof QueenChessComponent ||chessComponents[source.getX()][source.getY()] instanceof BishopChessComponent ||chessComponents[source.getX()][source.getY()] instanceof RookChessComponent)
        {
            for(int i=canMovePoints.size()-1;i>=0;i--)
            {
                if(RookChessComponent.check(chessComponents,source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY()) || BishopChessComponent.check(chessComponents,source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY()))
                    continue;
                canMovePoints.remove(i);
            }
        }
        if(chessComponents[source.getX()][source.getY()] instanceof PawnChessComponent)
        {
            for(int i=canMovePoints.size()-1;i>=0;i--)
            {
                if(canMovePoints.get(i).getY()!=source.getY() && (chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()] instanceof EmptyChessComponent))
                {canMovePoints.remove(i);continue;}
                if(canMovePoints.get(i).getY()==source.getY() && !(chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()] instanceof EmptyChessComponent)) canMovePoints.remove(i);
            }
        }
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>()
        {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2)
            {
                if(o1.getX()>o2.getX()) return 1;
                else if(o1.getX()<o2.getX()) return -1;
                else if(o1.getY()>o2.getY()) return 1;
                else if(o1.getY()<o2.getY()) return -1;
                return 0;
            }
        });
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source)
    {
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
//        for(int i=canMovePoints.size()-1;i>=0;i--)
//        {
//            if(chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor())
//                canMovePoints.remove(i);
//        }
//        if(chessComponents[source.getX()][source.getY()] instanceof QueenChessComponent ||chessComponents[source.getX()][source.getY()] instanceof BishopChessComponent ||chessComponents[source.getX()][source.getY()] instanceof RookChessComponent)
//        {
//            for(int i=canMovePoints.size()-1;i>=0;i--)
//            {
//                if(RookChessComponent.check(chessComponents,source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY()) || BishopChessComponent.check(chessComponents,source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY()))
//                    continue;
//                canMovePoints.remove(i);
//            }
//        }
//        if(chessComponents[source.getX()][source.getY()] instanceof PawnChessComponent)
//        {
//            for(int i=canMovePoints.size()-1;i>=0;i--)
//            {
//                if(canMovePoints.get(i).getY()!=source.getY() && (chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()] instanceof EmptyChessComponent))
//                {canMovePoints.remove(i);continue;}
//                if(canMovePoints.get(i).getY()==source.getY() && !(chessComponents[canMovePoints.get(i).getX()][canMovePoints.get(i).getY()] instanceof EmptyChessComponent)) canMovePoints.remove(i);
//            }
//        }
//        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>()
//        {
//            @Override
//            public int compare(ChessboardPoint o1, ChessboardPoint o2)
//            {
//                if(o1.getX()>o2.getX()) return 1;
//                else if(o1.getX()<o2.getX()) return -1;
//                else if(o1.getY()>o2.getY()) return 1;
//                else if(o1.getY()<o2.getY()) return -1;
//                return 0;
//            }
//        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
    {
        if(sourceX==targetX && sourceY==targetY) return false;
        if(currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()) return false;
//        if(!chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))) return false;
        for(int i=chessComponents[sourceX][sourceY].canMoveTo().size()-1;i>=0;i--)
        {
            if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY)
            {
                break;
            }
            if(i==0) return false;
        }
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
        ChessComponent a=chessComponents[sourceX][sourceY];
        chessComponents[sourceX][sourceY]=new EmptyChessComponent();
        chessComponents[targetX][targetY]=a;
        currentPlayer=(currentPlayer==ChessColor.WHITE)?ChessColor.BLACK:ChessColor.WHITE;
        return true;
    }
}
