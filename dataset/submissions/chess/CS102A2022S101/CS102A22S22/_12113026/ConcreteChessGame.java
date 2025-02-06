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
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.NONE;
        ChessComponent.setChessboardPoints(this.chessComponents);
    }

    public void loadChessGame(List<String> chessboard) {
        for(int i=0; i<8; i++){
            String row = chessboard.get(i);
            for(int j=0; j<8; j++){
                ChessComponent component;

                switch(row.charAt(j)){
                    case 'R':
                        component = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'r':
                        component = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'N':
                        component = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'n':
                        component = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'B':
                        component = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'b':
                        component = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'Q':
                        component = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'q':
                        component = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'K':
                        component = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'k':
                        component = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    case 'P':
                        component = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                        break;
                    case 'p':
                        component = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                        break;
                    default:
                        component = new EmptySlotComponent(new ChessboardPoint(i, j));
                        break;
                }

                this.chessComponents[i][j] = component;
            }
        }

        if(chessboard.get(8).equals("w"))
            currentPlayer = ChessColor.WHITE;
        else
            currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                graph.append(chessComponents[i][j].toString());
            }
            graph.append('\n');
        }
        graph.deleteCharAt(graph.length()-1);
        return graph.toString();
    }

    public String getCapturedChess(ChessColor player){
        int k=1, q=1, r=2, b=2, n=2, p=8;

        for(ChessComponent[] row : chessComponents){
            for(ChessComponent component : row){
                if(component.getChessColor() != player) continue;

                if(component instanceof PawnChessComponent)
                    p--;
                else if(component instanceof RookChessComponent)
                    r--;
                else if(component instanceof BishopChessComponent)
                    b--;
                else if(component instanceof KnightChessComponent)
                    n--;
                else if(component instanceof QueenChessComponent)
                    q--;
                else if(component instanceof KingChessComponent)
                    k--;
            }
        }

        StringBuilder capturedString = new StringBuilder();
        String c = (player == ChessColor.BLACK) ? "KQRBNP" : "kqrbnp";

        if(k != 0)
            capturedString
                    .append(c.charAt(0))
                    .append(' ')
                    .append(k)
                    .append('\n');

        if(q != 0)
            capturedString
                    .append(c.charAt(1))
                    .append(' ')
                    .append(q)
                    .append('\n');

        if(r != 0)
            capturedString
                    .append(c.charAt(2))
                    .append(' ')
                    .append(r)
                    .append('\n');

        if(b != 0)
            capturedString
                    .append(c.charAt(3))
                    .append(' ')
                    .append(b)
                    .append('\n');

        if(n != 0)
            capturedString
                    .append(c.charAt(4))
                    .append(' ')
                    .append(n)
                    .append('\n');

        if(p != 0)
            capturedString
                    .append(c.charAt(5))
                    .append(' ')
                    .append(p)
                    .append('\n');

        return capturedString.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        int size = canMovePoints.size();
        for(int i=0; i<size-1; i++){
            ChessboardPoint a = canMovePoints.get(i);
            int ax = a.getX();
            int ay = a.getY();
            for(int j=i+1; j<size; j++){
                ChessboardPoint b = canMovePoints.get(j);
                int bx = b.getX();
                int by = b.getY();

                if(bx < ax || (bx == ax && by < ay)) {
                    canMovePoints.set(i, b);
                    canMovePoints.set(j, a);

                    a = b;
                    ax = bx;
                    ay = by;
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!ChessboardPoint.isValidPoint(sourceX, sourceY) || !ChessboardPoint.isValidPoint(targetX, targetY))
            return false;

        ChessComponent source = getChess(sourceX, sourceY);
        ChessComponent target = getChess(targetX, targetY);

        if(source.getChessColor() == this.currentPlayer &&
                contains(source.canMoveTo(), target.getSource())){
            source.setSource(new ChessboardPoint(targetX, targetY));
            target.setSource(new ChessboardPoint(sourceX, sourceY));
            this.chessComponents[targetX][targetY] = source;

            if(target instanceof EmptySlotComponent)
                this.chessComponents[sourceX][sourceY] = target;
            else
                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));

            this.currentPlayer = (this.currentPlayer == ChessColor.BLACK)? ChessColor.WHITE : ChessColor.BLACK;
            return true;
        }
        return false;
    }
    private boolean contains(List<ChessboardPoint> points, ChessboardPoint point){
        for( ChessboardPoint p : points){
            if (p.getX() == point.getX() && p.getY() == point.getY())
                return true;
        }
        return false;
    }
}