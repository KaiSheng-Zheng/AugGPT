import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    private void move(int sourceX, int sourceY, int targetX, int targetY){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            if (currentPlayer.equals(ChessColor.WHITE))
                currentPlayer = ChessColor.BLACK;
            else
                currentPlayer = ChessColor.WHITE;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent a = chessComponents[sourceX][sourceY];
        if (moveChess1(sourceX, sourceY, targetX, targetY) && currentPlayer.equals(a.getChessColor())){
            move(sourceX, sourceY, targetX, targetY);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean moveChess1(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX == targetX && sourceY == targetY){
            return false;
        }
        ChessComponent a = chessComponents[sourceX][sourceY];
//        if (!currentPlayer.equals(a.getChessColor()))
//            return false;
        if (targetX > 7 || targetX < 0 || targetY > 7 || targetY < 0)
            return false;
        ChessComponent b = chessComponents[targetX][targetY];
        if (a.getChessColor().equals(ChessColor.NONE))
            return false;
        boolean b1 = false;
        for (int i = 0;i < a.canMoveTo().size();i++){
            ChessboardPoint p = a.canMoveTo().get(i);
            if (p.getX() == targetX & p.getY() == targetY){
                b1 = true;
                break;
            }
        }
        if (b1){
            switch (Character.toUpperCase(a.name)){
                case 'R':
                    if (b.getChessColor().equals(a.getChessColor()))
                        return false;
                    if (sourceX == targetX){
                        if (sourceY > targetY){
                            for (int d = 1;d < sourceY - targetY;d++){
                                if (!chessComponents[sourceX][sourceY - d].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        else {
                            for (int d = 1;d < targetY - sourceY;d++){
                                if (!chessComponents[sourceX][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                    }
                    else {
                        if (sourceX > targetX){
                            for (int d = 1;d < sourceX - targetX;d++){
                                if (!chessComponents[sourceX - d][sourceY].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        else {
                            for (int d = 1;d < targetX - sourceX;d++){
                                if (!chessComponents[sourceX + d][sourceY].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                    }
                    return true;
                case 'Q':
                    if (b.getChessColor().equals(a.getChessColor()))
                        return false;
                    int dx = targetX - sourceX;
                    int dy = targetY - sourceY;
                    boolean xsign = dx > 0;
                    boolean ysign = dy > 0;
                    if (dx == 0){
                        if (sourceY > targetY){
                            for (int d = 1;d < sourceY - targetY;d++){
                                if (!chessComponents[sourceX][sourceY - d].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        else {
                            for (int d = 1;d < targetY - sourceY;d++){
                                if (!chessComponents[sourceX][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        return true;
                    }
                    if (dy == 0){
                        if (sourceX > targetX){
                            for (int d = 1;d < sourceX - targetX;d++){
                                if (!chessComponents[sourceX - d][sourceY].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        else {
                            for (int d = 1;d < targetX - sourceX;d++){
                                if (!chessComponents[sourceX + d][sourceY].getChessColor().equals(ChessColor.NONE))
                                    return false;
                            }
                        }
                        return true;
                    }
                    if (xsign && ysign){
                        for (int d = 1;d < dx;d++){
                            if (!chessComponents[sourceX + d][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    if (!xsign && ysign){
                        for (int d = 1;d < dy;d++){
                            if (!chessComponents[sourceX - d][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    //The third quadrant
                    if (!xsign){
                        for (int d = 1;d < -dy;d++){
                            if (!chessComponents[sourceX - d][sourceY - d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    //The fourth quadrant
                    for (int d = 1; d < dx; d++) {
                        if (!chessComponents[sourceX + d][sourceY - d].getChessColor().equals(ChessColor.NONE))
                            return false;
                    }
                    return true;
                //                case 'K':        // king cannot capture king
//                    break;
                case 'P':
                    if (b.getChessColor().equals(a.getChessColor()))
                        return false;
                    return b.getChessColor().equals(ChessColor.NONE);
                case 'B':
                    if (b.getChessColor().equals(a.getChessColor()))
                        return false;
                    int dbx = targetX - sourceX;
                    int dby = targetY - sourceY;
                    boolean xb = dbx > 0;
                    boolean yb = dby > 0;
                    if (xb && yb){
                        for (int d = 1;d < dbx;d++){
                            if (!chessComponents[sourceX + d][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    if (!xb && yb){
                        for (int d = 1;d < dby;d++){
                            if (!chessComponents[sourceX - d][sourceY + d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    //The third quadrant
                    if (!xb){
                        for (int d = 1;d < -dby;d++){
                            if (!chessComponents[sourceX - d][sourceY - d].getChessColor().equals(ChessColor.NONE))
                                return false;
                        }
                        return true;
                    }
                    //The fourth quadrant
                    for (int d = 1; d < dbx; d++) {
                        if (!chessComponents[sourceX + d][sourceY - d].getChessColor().equals(ChessColor.NONE))
                            return false;
                    }
                    return true;
                default:
                    return !b.getChessColor().equals(a.getChessColor());
            }
        }
        else{
            if (Character.toUpperCase(a.name) == 'P'){
                switch (a.getChessColor()){
                    case WHITE:
                        return (targetX == sourceX - 1 && (targetY == sourceY + 1 || targetY == sourceY - 1)) && b.getChessColor().equals(ChessColor.BLACK);
                    case BLACK:
                        return (targetX == sourceX + 1 && (targetY == sourceY + 1 || targetY == sourceY - 1)) && b.getChessColor().equals(ChessColor.WHITE);
                    default:
                        return false;
                }
            }
            else
                return false;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int tx = source.getX();
        int ty = source.getY();
        ChessComponent a = chessComponents[tx][ty];
        List<ChessboardPoint> can = new ArrayList<>();
        for (ChessboardPoint p : a.canMoveTo()){
            if (moveChess1(tx,ty,p.getX(),p.getY()))
                can.add(new ChessboardPoint(p.getX(),p.getY()));
        }
        if (Character.toUpperCase(a.name) == 'P'){
            for (ChessboardPoint p : a.getD()){
                if (moveChess1(tx,ty,p.getX(),p.getY()))
                    can.add(new ChessboardPoint(p.getX(),p.getY()));
            }
        }
        if (!(can.size() == 0 || can.size() == 1)) {
            for (int i = 1; i < can.size(); i++) {
                int j = i;
                while (j > 0 && !compare(can.get(j - 1), can.get(j))) {
                    ChessboardPoint c = can.get(j - 1);
                    can.set(j - 1, can.get(j));
                    can.set(j, c);
                    j--;
                }
            }
        }
        return can;
    }

    private boolean compare (ChessboardPoint a,ChessboardPoint b){
        if (a.getX() < b.getX())
            return true;
        else {
            if (a.getX() > b.getX())
                return false;
            else {
                return a.getY() <= b.getY();
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int x = 0;x < 8;x++){
            for (int y = 0;y < 8;y++){
                String s = chessboard.get(x);
                char c = s.charAt(y);
                ChessColor co = ChessColor.NONE;
                if (c == 95){
                    chessComponents[x][y] = new EmptySlotComponent(new ChessboardPoint(x,y));
                    continue;
                }
                if (c >= 97)
                    co = ChessColor.WHITE;
                if (c <= 90)
                    co = ChessColor.BLACK;
                switch (Character.toUpperCase(c)){
                    case 'R':
                        chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                    case 'N':
                        chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                    case 'B':
                        chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                    case 'Q':
                        chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                    case 'K':
                        chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                    case 'P':
                        chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x,y),co,c);
                        break;
                }
            }
        }
        currentPlayer = (chessboard.get(8).equals("w")) ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder a = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int x = 0;x < 8;x++){
            for (int y = 0;y < 8;y++){
                sb.append(chessComponents[x][y].name);
            }
            a.append(String.format("%s\n", sb));
            sb = new StringBuilder();
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] count = new int[]{1,1,2,2,2,8};
        char[] name = new char[]{'K','Q','R','B','N','P'};
        for (ChessComponent[] a : chessComponents){
            for (ChessComponent co : a){
                if (co.getChessColor().equals(player)){
                    switch (Character.toUpperCase(co.name)){
                        case 'R':
                            count[2]--;
                            break;
                        case 'N':
                            count[4]--;
                            break;
                        case 'B':
                            count[3]--;
                            break;
                        case 'Q':
                            count[1]--;
                            break;
                        case 'K':
                            count[0]--;
                            break;
                        case 'P':
                            count[5]--;
                            break;
                    }
                }
            }
        }
        StringBuilder c = new StringBuilder();
        for (int i = 0;i < 6;i++){
            if (0 != count[i]){
                c.append(String.format("%s %d\n",name[i],count[i]));
            }
        }
        return (player.equals(ChessColor.WHITE)) ? c.toString().toLowerCase() : c.toString();
    }
}
