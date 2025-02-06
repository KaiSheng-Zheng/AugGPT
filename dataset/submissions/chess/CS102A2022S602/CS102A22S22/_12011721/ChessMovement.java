import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class ChessMovement {
    Chessboard chessboard;
    ChessComponent chess;
    List<ChessboardPoint> list = new ArrayList<>();

    public ChessMovement(Chessboard chessboard, ChessComponent chess) {
        this.chessboard = chessboard;
        this.chess = chess;
    }

    public List<ChessboardPoint> Movemrent()
    {
        if(chess instanceof KingChessComponent)
            return KingMove();
        else if(chess instanceof KnightChessComponent)
            return KnightMove();
        else if(chess instanceof QueenChessComponent)
            return QueenMove();
        else if(chess instanceof PawnChessComponent)
            return PawnMove() ;
        else if(chess instanceof RookChessComponent)
            return RookMove();
        else if(chess instanceof BishopChessComponent)
            return BishopMove();
        else
            return new ArrayList<>();
    }

    private List<ChessboardPoint> KingMove()
    {
        moveU( 1);
        moveD( 1);
        moveL( 1);
        moveR( 1);
        moveUL( 1);
        moveUR( 1);
        moveDL( 1);
        moveDR( 1);

        return list;
    }

    private List<ChessboardPoint> KnightMove()
    {
        Kmove(1,2);
        Kmove(1,-2);
        Kmove(-1,2);
        Kmove(-1,-2);
        Kmove(2,1);
        Kmove(2,-1);
        Kmove(-2,1);
        Kmove(-2,-1);

        return list;
    }

    private List<ChessboardPoint> QueenMove()
    {
        moveU( 7);
        moveD( 7);
        moveL( 7);
        moveR( 7);
        moveUL( 7);
        moveUR( 7);
        moveDL( 7);
        moveDR( 7);

        return list;
    }

    private List<ChessboardPoint> PawnMove()
    {
        if(chess.getChessColor() == ChessColor.WHITE)
        {
            if(chess.getSource().getX() == 6)
            {
                for(int i = 1; i <=2; i ++)
                {
                    ChessboardPoint point = chess.getSource().offset(-i,0);
                    if(point != null)
                    {
                        if(chessboard.getChess(point).getName() != '_')
                            break;
                        list.add(point);
                    }
                }
            }
            else
            {
                ChessboardPoint point = chess.getSource().offset(-1,0);
                if(point != null)
                {
                    if(chessboard.getChess(point).getName() == '_')
                        list.add(point);
                }
            }

            ChessComponent e1 = chessboard.getChess(chess.getSource().offset(-1,1));
            ChessComponent e2 = chessboard.getChess(chess.getSource().offset(-1,-1));

            if(e1.getName() != '_' && e1.getChessColor() != chess.getChessColor())
                list.add(e1.source);
            if(e2.getName() != '_' && e2.getChessColor() != chess.getChessColor())
                list.add(e2.source);
        }
        else
        {
            if(chess.getSource().getX() == 1)
            {
                for(int i = 1; i <=2; i ++)
                {
                    ChessboardPoint point = chess.getSource().offset(i,0);
                    if(point != null)
                    {
                        if(chessboard.getChess(point).getName() != '_')
                            break;
                        list.add(point);
                    }
                }
                ((PawnChessComponent) chess).setFirst(false);
            }
            else
            {
                ChessboardPoint point = chess.getSource().offset(1,0);
                if(point != null)
                {
                    if(chessboard.getChess(point).getName() == '_')
                        list.add(point);
                }
            }

            ChessComponent e1 = chessboard.getChess(chess.getSource().offset(1,1));
            ChessComponent e2 = chessboard.getChess(chess.getSource().offset(1,-1));

            if(e1.getName() != '_' && e1.getChessColor() != chess.getChessColor())
                list.add(e1.source);
            if(e2.getName() != '_' && e2.getChessColor() != chess.getChessColor())
                list.add(e2.source);
        }


        return list;
    }

    private List<ChessboardPoint> BishopMove()
    {
        moveUL( 7);
        moveUR( 7);
        moveDL( 7);
        moveDR( 7);

        return list;
    }

    private List<ChessboardPoint> RookMove()
    {
        moveU( 7);
        moveD( 7);
        moveL( 7);
        moveR( 7);

        return list;
    }

    private void moveU( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(0,i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveD( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(0,-i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveR( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(-i,0);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveL( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(i,0);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveUR( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(i,i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveDR( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(i,-i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveUL( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(-i,i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void moveDL( int step)
    {
        for(int i = 1; i <=step; i ++)
        {
            ChessboardPoint point = chess.getSource().offset(-i,-i);
            if(point != null)
            {
                if(chessboard.getChess(point).getName() != '_')
                {
                    if(chessboard.getChess(point).chessColor != chess.getChessColor())
                        list.add(point);
                    break;
                }
                list.add(point);
            }
        }
    }

    private void Kmove(int x, int y)
    {
        ChessboardPoint point;
        point = chess.getSource().offset(x, y);
        if(point != null)
        {
            if(chessboard.getChess(point).getName() != '_') {
                if (chessboard.getChess(point).chessColor != chess.getChessColor())
                    list.add(point);
            }
            else
                list.add(point);
        }
    }
}
