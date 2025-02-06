import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++){
            for (int j = 0; j < 8; j++){
                switch (chessboard.get(i).charAt(j)) {
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (chessboard.get(chessboard.size() - 1).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        }
        else
            currentPlayer = ChessColor.BLACK;
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
        String str = "";
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                str = str.concat(chessComponents[i][j].toString());
            }
            str = str.concat("\n");
        }
        return str;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        LinkedHashMap<Character,Integer> Map = new LinkedHashMap<>();
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        if (player == ChessColor.WHITE) {
            Map.put('k',1);
            Map.put('q',1);
            Map.put('r',2);
            Map.put('b',2);
            Map.put('n',2);
            Map.put('p',8);
            map.put('k',0);
            map.put('q',0);
            map.put('r',0);
            map.put('b',0);
            map.put('n',0);
            map.put('p',0);
            for (ChessComponent[] arr : chessComponents){
                for (ChessComponent chessComponent : arr){
                    char name = chessComponent.name;
                    if (map.containsKey(name)){
                        map.replace(name, map.get(name) + 1);
                    }
                }
            }

            String str = "";
            for (Map.Entry<Character,Integer> entry: Map.entrySet()){
                if (map.get(entry.getKey()) - entry.getValue() != 0){
                    str = str.concat(String.format("%c %d",entry.getKey(), entry.getValue() - map.get(entry.getKey())));
                    str = str.concat("\n");
                }
            }
            return str;
        }
        else {
            Map.put('K',1);
            Map.put('Q',1);
            Map.put('R',2);
            Map.put('B',2);
            Map.put('N',2);
            Map.put('P',8);
            map.put('K',0);
            map.put('Q',0);
            map.put('R',0);
            map.put('B',0);
            map.put('N',0);
            map.put('P',0);
            for (ChessComponent[] arr : chessComponents){
                for (ChessComponent chessComponent : arr){
                    char name = chessComponent.name;
                    if (map.containsKey(name)){
                        map.replace(name, map.get(name) + 1);
                    }
                }
            }

            String str = "";
            for (Map.Entry<Character,Integer> entry: Map.entrySet()){
                if (map.get(entry.getKey()) - entry.getValue() != 0){
                    str = str.concat(String.format("%c %d",entry.getKey(), entry.getValue() - map.get(entry.getKey())));
                    str = str.concat("\n");
                }
            }
            return str;
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int X = source.getX();
        int Y = source.getY();
        ChessComponent chess = chessComponents[X][Y];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();

        // Sorted
        canMovePoints.sort((o1, o2) -> {
            int dX = o1.getX() - o2.getX();
            int dY = o1.getY() - o2.getY();
            if (dX > 0) {
                return 1;
            } else if (dX < 0) {
                return -1;
            } else {
                return Integer.compare(dY, 0);
            }
        });

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> pointList = chess.canMoveTo();
        ChessboardPoint point = new ChessboardPoint(targetX, targetY);

        // Check match
        if (chess.getChessColor() != currentPlayer){
            return false;
        }

        // Check legal
        if (pointList.contains(point)){
            chess.setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[targetX][targetY] = chess;
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
            currentPlayer = (currentPlayer == ChessColor.WHITE? ChessColor.BLACK : ChessColor.WHITE);
            return true;
        }
        else {
            return false;
        }
    }
}