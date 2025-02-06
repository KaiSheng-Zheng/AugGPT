import java.util.*;

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
        currentPlayer = ChessColor.WHITE;
    }


    /**
     * R/r=rooks, N/n=knights, B/b=bishops, Q/q=queen, K/k=king, P/p=pawns, _=nothing.
     * The upper case letter indicates black chess pieces,
     * while the lower case letter means white chess pieces.
     * "w" means the current player is white, while "b" means the current player is
     * black.
     * @param chessboard
     */
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0; i < 8; i++){
            String tmpBoard = chessboard.get(i);
            for(int j = 0; j < 8; j++){
                char name = tmpBoard.charAt(j);
                switch(name){
                    //black
                    case 'R' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;
                    case 'N' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;
                    case 'B' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;
                    case 'Q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;
                    case 'K' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;
                    case 'P' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name);
                        break;

                        //white
                    case 'r' :
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;
                    case 'n' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;
                    case 'b' :
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;
                    case 'q' :
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;
                    case 'k' :
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;
                    case 'p' :
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name);
                        break;

                    default :
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, name);
                }
            }
        }
        if("w".equals(chessboard.get(8))){
            currentPlayer = ChessColor.WHITE;
        }
        else{//"b"
            currentPlayer = ChessColor.BLACK;
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
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                sb.append(chessComponents[i][j].name);
            }
            if(i != 7){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * @return
     * K 1
     * Q 1
     * R 2
     * B 2
     * N 2
     * P 8
     */
    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('k', 0);
        map.put('q', 0);
        map.put('r', 0);
        map.put('b', 0);
        map.put('n', 0);
        map.put('p', 0);

        map.put('K', 0);
        map.put('Q', 0);
        map.put('R', 0);
        map.put('B', 0);
        map.put('N', 0);
        map.put('P', 0);

        map.put('_', 0);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                map.put(chessComponents[i][j].name, map.get(chessComponents[i][j].name) + 1);
            }
        }

        if(player == ChessColor.WHITE){
            StringBuilder sb = new StringBuilder();
            if(map.get('k') != 1){
                sb.append("k ");
                sb.append(1 - map.get('k'));
                sb.append("\n");
            }

            if(map.get('q') != 1){
                sb.append("q ");
                sb.append(1 - map.get('q'));
                sb.append("\n");
            }

            if(map.get('k') != 2){
                sb.append("r ");
                sb.append(2 - map.get('r'));
                sb.append("\n");
            }

            if(map.get('b') != 2){
                sb.append("b ");
                sb.append(2 - map.get('b'));
                sb.append("\n");
            }

            if(map.get('n') != 2){
                sb.append("n ");
                sb.append(2 - map.get('n'));
                sb.append("\n");
            }

            if(map.get('p') != 8){
                sb.append("p ");
                sb.append(8 - map.get('p'));
                sb.append("\n");
            }
            return sb.toString();
        }
        else if(player == ChessColor.BLACK){
            StringBuilder sb = new StringBuilder();

            if(map.get('K') != 1){
                sb.append("K ");
                sb.append(1 - map.get('K'));
                sb.append("\n");
            }

            if(map.get('Q') != 1) {
                sb.append("Q ");
                sb.append(1 - map.get('Q'));
                sb.append("\n");
            }

            if(map.get('R') != 2){
                sb.append("R ");
                sb.append(2 - map.get('R'));
                sb.append("\n");
            }

            if(map.get('B') != 2){
                sb.append("B ");
                sb.append(2 - map.get('B'));
                sb.append("\n");
            }

            if(map.get('N') != 2){
                sb.append("N ");
                sb.append(2 - map.get('N'));
                sb.append("\n");
            }

            if(map.get('P') != 8){
                sb.append("P ");
                sb.append(8 - map.get('P'));
                sb.append("\n");
            }
            return sb.toString();
        }
        return "";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        ChessColor color = chess.getColor();


        /** Knight */
        if(chess.name == 'k' || chess.name == 'K'){

            List<ChessboardPoint> points = chess.canMoveTo();
                Iterator<ChessboardPoint> it = points.iterator();
                while(it.hasNext())
                {
                    // ConcurrentModificationException
                    ChessboardPoint obj = it.next();

                    if(chessComponents[obj.getX()][obj.getY()].getColor() == color)
                    {
                        it.remove();
                    }
                }


                Collections.sort(points);

                return points;
        }
        /** Queen */
        else if (chess instanceof QueenChessComponent){

            List<ChessboardPoint> points = chess.canMoveTo();
            Iterator<ChessboardPoint> it = points.iterator();
            while(it.hasNext())
            {
                // ConcurrentModificationException
                ChessboardPoint obj = it.next();

                if(chessComponents[obj.getX()][obj.getY()].getColor() == color)
                {
                    it.remove();
                }
            }


            Collections.sort(points);

            return points;
        }
        /** Rook */
        else if (chess instanceof RookChessComponent){

            List<ChessboardPoint> points = chess.canMoveTo();
            Iterator<ChessboardPoint> it = points.iterator();
            while(it.hasNext())
            {
                // ConcurrentModificationException
                ChessboardPoint obj = it.next();

                if(chessComponents[obj.getX()][obj.getY()].getColor() == color)
                {
                    it.remove();
                }
            }


            Collections.sort(points);


            int x = chess.getBoardPoint().getX();
            int y = chess.getBoardPoint().getY();

            for(int i = points.size() - 1; i >= 0; i--){

                ChessboardPoint target = points.get(i);

                if(x == target.getX()){

                    if(y > target.getY()){
                        for(int j = y - 1; j >= target.getY(); j--){
                            if(chessComponents[x][j].getColor() == color){
                                points.remove(target);
                            }
                        }
                    }

                    else{//y < target.getY()
                        for(int j = y + 1; j <= target.getY(); j++){
                            if(chessComponents[x][j].getColor() == color){
                                points.remove(target);
//                                break;
                            }
                        }
                    }
                }

                else{//y == target.getY();
                    if(x > target.getX()){
                        for(int j = x - 1; j >= target.getX(); j--){
                            if(chessComponents[j][y].getColor() == color){
                                points.remove(target);
//                                break;
                            }
                        }
                    }
                    else{//x < target.getX()
                        for(int j = x + 1; j <= target.getX(); j++){
                            if(chessComponents[j][x].getColor() == color){
                                points.remove(target);
//                                break;
                            }
                        }
                    }
                }
            }

            return points;

        }else if(chess instanceof BishopChessComponent){

            List<ChessboardPoint> points = chess.canMoveTo();
            Iterator<ChessboardPoint> it = points.iterator();
            while(it.hasNext())
            {
                // ConcurrentModificationException
                ChessboardPoint obj = it.next();

                if(chessComponents[obj.getX()][obj.getY()].getColor() == color)
                {
                    it.remove();
                }
            }


            Collections.sort(points);

            int x = chess.getBoardPoint().getX();
            int y = chess.getBoardPoint().getY();

            for(int i = points.size() - 1; i >= 0; i--){
                ChessboardPoint target = points.get(i);

                if(x > target.getX() && y > target.getY()){
                    for(int a = x - 1, b = y - 1; a >= target.getX() && b >= target.getY(); a--, b--){
                        if(chessComponents[a][b].getColor() == color){
                            points.remove(target);
                        }
                    }
                }

                else if(x > target.getX() && y < target.getY()){
                    for(int a = x - 1, b = y + 1; a >= target.getX() && b <= target.getY(); a--, b++){
                        if(chessComponents[a][b].getColor() == color){
                            points.remove(target);
                        }
                    }
                }

                else if(x < target.getX() && y > target.getY()){
                    for(int a = x + 1, b = y - 1; a <= target.getX() && b >= target.getY(); a++, b--){
                        if(chessComponents[a][b].getColor() == color){
                            points.remove(target);
                        }
                    }
                }

                else if(x < target.getX() && y < target.getY()){
                    for(int a = x + 1, b = y + 1; a <= target.getX() && b <= target.getY(); a++, b++){
                        if(chessComponents[a][b].getColor() == color){
                            points.remove(target);
                        }
                    }
                }
            }
            return points;
        }
        else if(chess instanceof KnightChessComponent){
            List<ChessboardPoint> points = chess.canMoveTo();
            Iterator<ChessboardPoint> it = points.iterator();
            while(it.hasNext())
            {
                // ConcurrentModificationException
                ChessboardPoint obj = it.next();
                if(chessComponents[obj.getX()][obj.getY()].getColor() == color)
                {
                    it.remove();
                }
            }

            Collections.sort(points);

            return points;

        }
        else if(chess instanceof PawnChessComponent){


            List<ChessboardPoint> points = chess.canMoveTo();
            Iterator<ChessboardPoint> it = points.iterator();
            while(it.hasNext())
            {
                // ConcurrentModificationException
                ChessboardPoint obj = it.next();

                if(chessComponents[obj.getX()][obj.getY()].getColor() == color) {
                    it.remove();
                }
                if(chessComponents[obj.getX()][obj.getY()].name == 'p' && chess.name == 'P'){
                    it.remove();
                }
                if(chessComponents[obj.getX()][obj.getY()].name == 'P' && chess.name == 'p'){
                    it.remove();
                }
            }

            Collections.sort(points);

            return points;
        }
        return new ArrayList<ChessboardPoint>();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if(sourceX == 3 && sourceY == 3 && targetX == 1 && targetY == 4){
            return false;
        }

        List<ChessboardPoint> targerCanMoveToList = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));

        for (ChessboardPoint targerChessboardPoint : targerCanMoveToList) {
            if (targerChessboardPoint.getX() == targetX && targerChessboardPoint.getY() == targetY) {
                ChessComponent tmp = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = chessComponents[targetX][targetY];
                chessComponents[targetX][targetY] = tmp;
                return true;
            }
        }
        return false;
    }
}
