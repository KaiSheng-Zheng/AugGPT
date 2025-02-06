import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ConcreteChessGame implements ChessGame{
    private Chessboard chessboard = new Chessboard();
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0; i <= 7; i++)
        {
            String boardline = chessboard.get(i);
            for(int j = 0; j <= 7; j ++)
            {
                ChessboardPoint point = new ChessboardPoint(i,j);
                this.chessboard.setBoard(CreateChess(boardline.charAt(j),point),point);
            }
        }
        String boardLine = chessboard.get(8);
        if(boardLine.charAt(0) == 'w')
            currentPlayer = ChessColor.WHITE;
        else
            currentPlayer = ChessColor.BLACK;

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessboard.getChess(new ChessboardPoint(x,y));
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder Graph = new StringBuilder();
        for(int i = 0; i <=7; i ++)
        {
            for(int j = 0; j <= 7; j ++)
            {
                ChessboardPoint point = new ChessboardPoint(i,j);
//                Graph.append(CreateGraph(chessboard.getChess(point)));
                char name = chessboard.getChess(point).getName();
                if(chessboard.getChess(point).chessColor == ChessColor.WHITE)
                    name = Character.toLowerCase(name);
                Graph.append(name);
            }
            Graph.append("\n");
        }
        return Graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int Q = 0, K = 0, N = 0, P = 0, R = 0, B = 0;
        StringBuilder Capture = new StringBuilder();
        for(int i = 0; i <= 7; i ++)
        {
            for(int j = 0; j <= 7; j ++)
            {
                ChessComponent chess = chessboard.getChess(new ChessboardPoint(i,j));
                if(chess.getChessColor() == player){
                    if(chess instanceof KingChessComponent)
                        K++;
                    else if(chess instanceof KnightChessComponent)
                        N++;
                    else if(chess instanceof QueenChessComponent)
                        Q++;
                    else if(chess instanceof PawnChessComponent)
                        P++;
                    else if(chess instanceof RookChessComponent)
                        R++;
                    else if(chess instanceof BishopChessComponent)
                        B++;
                }

            }
        }

        if(K < 1)
            Capture.append("K ").append(1 - K).append("\n");
        if(Q < 1)
            Capture.append("Q ").append(1 - Q).append("\n");
        if(R < 2)
            Capture.append("R ").append(2 - R).append("\n");
        if(B < 2)
            Capture.append("B ").append(2 - B).append("\n");
        if(N < 2)
            Capture.append("N ").append(2 - N).append("\n");
        if(P < 8)
            Capture.append("P ").append(8 - P).append("\n");

        if(player == ChessColor.BLACK)
            return Capture.toString();
        else
            return Capture.toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessMovement move = new ChessMovement(chessboard, chessboard.getChess(source));
        List<ChessboardPoint> movelist = move.Movemrent();
        sort(movelist);
        return movelist;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> movelist = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        boolean canMove = false;
        ChessboardPoint moveto = new ChessboardPoint(targetX,targetY);
        if(chessboard.getChess(new ChessboardPoint(sourceX,sourceY)).getChessColor() != currentPlayer)
            return false;
        for(ChessboardPoint move : movelist)
        {
            if(move.getX() == targetX && move.getY() == targetY)
            {
                canMove = true;
                break;
            }
        }
        if(canMove)
        {
            ChessComponent old = chessboard.getChess(new ChessboardPoint(sourceX,sourceY));
            ChessComponent newC = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
            old.setSource(new ChessboardPoint(targetX,targetY));
            chessboard.setBoard(old,moveto);
            chessboard.setBoard(newC,new ChessboardPoint(sourceX,sourceY));
            if(currentPlayer == ChessColor.BLACK)
                currentPlayer = ChessColor.WHITE;
            else
                currentPlayer = ChessColor.BLACK;
            return true;
        }

        return false;
    }

    public ChessComponent CreateChess(char ChessC, ChessboardPoint point)
    {
        ChessColor color;
        ChessComponent Chess = new EmptySlotComponent(point);

        if(Character.isUpperCase(ChessC))
            color = ChessColor.BLACK;
        else
        {
            color = ChessColor.WHITE;
            ChessC = Character.toUpperCase(ChessC);
        }

        switch (ChessC)
        {
            case 'K':
                Chess = new KingChessComponent(color, point);
                break;
            case 'Q':
                Chess = new QueenChessComponent(color, point);
                break;
            case 'N':
                Chess = new KnightChessComponent(color, point);
                break;
            case 'P':
                Chess = new PawnChessComponent(color, point);
                break;
            case 'R':
                Chess = new RookChessComponent(color, point);
                break;
            case 'B':
                Chess = new BishopChessComponent(color, point);
                break;
            case 'E':
                Chess = new EmptySlotComponent(point);
                break;
        }
        return Chess;
    }

    public static void sort(List<ChessboardPoint> list)
    {
        for(int i = 0; i < list.size(); i ++)
        {
            for(int j = 0; j < list.size() - 1; j ++)
            {
                ChessboardPoint point1 = list.get(j);
                ChessboardPoint point2 = list.get(j + 1);
                if(point1.getX() > point2.getX())
                {
                    list.set(j, point2);
                    list.set(j + 1,point1);
                }
                else if(point1.getX() == point2.getX())
                {
                    if (point1.getY() > point2.getY())
                    {
                        list.set(j, point2);
                        list.set(j + 1,point1);
                    }
                }
            }
        }
    }

    /*public char CreateGraph(ChessComponent chess)
    {
        char chessC = 'e';
        if(chess instanceof KingChessComponent)
            chessC = 'K';
        else if(chess instanceof KnightChessComponent)
            chessC = 'N';
        else if(chess instanceof QueenChessComponent)
            chessC = 'Q';
        else if(chess instanceof PawnChessComponent)
            chessC = 'P';
        else if(chess instanceof RookChessComponent)
            chessC = 'R';
        else if(chess instanceof BishopChessComponent)
            chessC = 'B';
        else if(chess instanceof EmptySlotComponent)
            chessC = '_';

        if(chess.chessColor == ChessColor.WHITE)
            chessC = Character.toLowerCase(chessC);
        return chessC;
    }*/
}
