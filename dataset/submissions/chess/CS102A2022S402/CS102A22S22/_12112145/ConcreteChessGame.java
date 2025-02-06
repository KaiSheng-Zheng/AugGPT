import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0;i < 8;i++){
            String s = chessboard.get(i);
            for (int j = 0;j<8;j++){
                char c = s.charAt(j);
                switch (c){
                    case 'R' : chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.BLACK);break;
                    case 'r' : chessComponents[i][j] = new RookChessComponent(i,j,ChessColor.WHITE);break;
                    case 'N' : chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.BLACK);break;
                    case 'n' : chessComponents[i][j] = new KnightChessComponent(i,j,ChessColor.WHITE);break;
                    case 'B' : chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.BLACK);break;
                    case 'b' : chessComponents[i][j] = new BishopChessComponent(i,j,ChessColor.WHITE);break;
                    case 'Q' : chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.BLACK);break;
                    case 'q' : chessComponents[i][j] = new QueenChessComponent(i,j,ChessColor.WHITE);break;
                    case 'K' : chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.BLACK);break;
                    case 'k' : chessComponents[i][j] = new KingChessComponent(i,j,ChessColor.WHITE);break;
                    case 'P' : chessComponents[i][j] = new PawnChessComponent(i,j,ChessColor.BLACK);break;
                    case 'p' : chessComponents[i][j] = new PawnChessComponent(i,j,ChessColor.WHITE);break;
                    case '_' : chessComponents[i][j] = new EmptySlotComponent(i,j);break;
                }
            }
        }
        String cur = chessboard.get(8);
        if (cur.equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<8;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<8;j++){
                sb.append(chessComponents[i][j].name);
            }
            sb.append("\n");
            result.append(sb);
        }

        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        Map<String,Integer> map = new HashMap();
        for (int i = 0; i<8;i++){
            for (int j = 0;j<8;j++){
                ChessComponent cc = chessComponents[i][j];
                if (cc.toString().equals("_")){
                    continue;
                }

                Integer count = map.get(cc.toString());
                if (null != count){
                    map.put(cc.toString(),count + 1);
                } else {
                    map.put(cc.toString(),1);

                }

            }
        }
        StringBuilder sb = new StringBuilder();


        Integer kCount = getCount(map, player, "K");
        if (null == kCount){
            sb.append(getKey(player,"K"));
            sb.append(" 1\n");
        }
        Integer qCount = getCount(map, player, "Q");
        if (null == qCount){
            sb.append(getKey(player,"Q"));
            sb.append(" 1\n");
        }
        Integer rCount = getCount(map, player, "R");
        if (null == rCount){
            rCount = 0;
        }
        if (rCount < 2){
            sb.append(getKey(player,"R "));
            sb.append(2 - rCount);
            sb.append("\n");
        }

        Integer bCount = getCount(map, player, "B");
        if (null == bCount){
            bCount = 0;
        }
        if (bCount < 2){
            sb.append(getKey(player,"B "));
            sb.append(2 - bCount);
            sb.append("\n");
        }

        Integer nCount = getCount(map, player, "N");
        if (null == nCount){
            nCount = 0;
        }
        if (nCount < 2){
            sb.append(getKey(player,"N "));
            sb.append(2 - nCount);
            sb.append("\n");
        }

        Integer pCount = getCount(map, player, "P");
        if (null == pCount){
            pCount = 0;
        }
        if (pCount < 8){
            sb.append(getKey(player,"P "));
            sb.append(8 - pCount);
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = chessComponents[x][y];

        List<ChessboardPoint> canMoveToList = chess.canMoveTo();


        List<ChessboardPoint> result = new ArrayList<>();
        if (canMoveToList.size() != 0){
            for (int i = 0;i< 8;i++){
                for (int j = 0; j<8;j++){
                    for(ChessboardPoint point: canMoveToList){
                        if (point.getX() == i && point.getY() == j){
                            result.add(point);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = chessComponents[sourceX][sourceY];
        ChessColor sourceChessColor = source.getChessColor();


        ChessComponent target = chessComponents[targetX][targetY];
        ChessColor targetChessColor = target.getChessColor();
        if (sourceChessColor == null || !sourceChessColor.equals(this.currentPlayer) ||
                (targetChessColor != null && targetChessColor.equals(this.currentPlayer))){
            return false;
        }

        List<ChessboardPoint> canMoveToList = source.canMoveTo();

        if (null == canMoveToList || canMoveToList.size() == 0){
            return false;
        }

        boolean flag = false;
        for (ChessboardPoint movePoint : canMoveToList) {
            int moveX = movePoint.getX();
            int moveY = movePoint.getY();
            if (moveX == targetX && moveY == targetY){
                flag = true;
            }
        }
        if (!flag){
            return false;
        }


        int xChange = Math.abs(targetX - sourceX);
        int yChange = Math.abs(targetY - sourceY);
        if (!((xChange == 1 && yChange == 2)
                || (xChange == 2 && yChange == 1))){
            if (!((xChange == 0 && yChange == 1)||(xChange == 1 && yChange == 0) || (xChange == 1 && yChange == 1))){
                int minY = min(sourceY, targetY);
                int maxY = max(sourceY, targetY);
                int minX = min(sourceX, targetX);
                int maxX = max(sourceX, targetX);
                if (xChange == 0){

                    for (int change = 1; minY+change<maxY ; change++){
                        ChessComponent passBy = chessComponents[targetX][minY + change];
                        ChessColor passByChessColor = passBy.getChessColor();
                        if (null != passByChessColor){
                            return false;
                        }
                    }
                }

                if (yChange == 0){

                    for (int change = 1; minX+change<maxX ; change++){
                        ChessComponent passBy = chessComponents[minX + change][targetY];
                        ChessColor passByChessColor = passBy.getChessColor();
                        if (null != passByChessColor){
                            return false;
                        }
                    }
                }

                if (isRightSideling(sourceX,sourceY,targetX,targetY)){
                    for (int x=minX,y=minY;x<maxX && y<maxY;x++,y++){
                        ChessComponent passBy = chessComponents[x][y];
                        ChessColor passByChessColor = passBy.getChessColor();
                        if (null != passByChessColor){
                            return false;
                        }
                    }
                } else {
                    for (int x=maxX,y=minY;x>minX && y<maxY;x--,y++){
                        ChessComponent passBy = chessComponents[x][y];
                        ChessColor passByChessColor = passBy.getChessColor();
                        if (null != passByChessColor){
                            return false;
                        }
                    }
                }
            }
        }
        
        source.setSource(new ChessboardPoint(targetX,targetY));
        chessComponents[targetX][targetY] = source;

        chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY);

        if (currentPlayer.equals(ChessColor.WHITE)){
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
        }

        return true;
    }


    private boolean isRightSideling(int sourceX, int sourceY, int targetX, int targetY){
        if ((sourceX > targetX && sourceY > targetY) || (targetX > sourceX && targetY > sourceY)){
            return true;
        } else {
            return false;
        }
    }

    private int min(int a,int b){
        return a<=b? a:b;
    }

    private int max(int a,int b){
        return a>=b? a:b;
    }

    private Integer getCount(Map<String,Integer> map,ChessColor player,String key){
        if (player.equals(ChessColor.BLACK)){
            key = key.toUpperCase();
        } else {
            key = key.toLowerCase();
        }
        return map.get(key);
    }

    private String getKey(ChessColor player,String key){
        if (player.equals(ChessColor.BLACK)){
            key = key.toUpperCase();
        } else {
            key = key.toLowerCase();
        }
        return key;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}
