import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    @Override
    public void loadChessGame(List<String> chessboard) {
        String row;
        char name;
        ChessboardPoint point;
        ChessComponent cc;
        for(int x = 0; x < 8; x++){
            row = chessboard.get(x);
            for(int y = 0; y < 8; y++){
                name = row.charAt(y);
                point = new ChessboardPoint(x,y);
                switch (name){
                    case 'p','P':
                        cc = new PawnChessComponent(point,name,chessComponents);
                        break;
                    case 'r','R':
                        cc = new RookChessComponent(point,name,chessComponents);
                        break;
                    case 'n','N':
                        cc = new KnightChessComponent(point,name,chessComponents);
                        break;
                    case 'b','B':
                        cc = new BishopChessComponent(point,name,chessComponents);
                        break;
                    case 'q','Q':
                        cc = new QueenChessComponent(point,name,chessComponents);
                        break;
                    case 'k','K':
                        cc = new KingChessComponent(point,name,chessComponents);
                        break;
                    default:
                        cc = new EmptySlotComponent(point,name,chessComponents);
                        break;
                }
                chessComponents[x][y] = cc;
            }
        }

        char color = chessboard.get(8).charAt(0);
        if(color == 'w'){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
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
        StringBuilder sb = new StringBuilder();
        for(int x= 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                sb.append(chessComponents[x][y]);
            }
            if(x==7){
                break;
            }else{
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int pawnCount = 8;
        int knightCount = 2;
        int bishopCount = 2;
        int rookCount = 2;
        int queenCount = 1;
        int kingCount = 1;

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessComponent cc = chessComponents[x][y];

                if (cc.getColor()!=player){
                    continue;
                }

                if(cc instanceof PawnChessComponent) --pawnCount;
                if(cc instanceof KnightChessComponent) --knightCount;
                if(cc instanceof BishopChessComponent) --bishopCount;
                if(cc instanceof RookChessComponent) --rookCount;
                if(cc instanceof QueenChessComponent) --queenCount;
                if(cc instanceof KingChessComponent) --kingCount;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (kingCount > 0) sb.append("K ").append(kingCount).append("\n");
        if (queenCount > 0) sb.append("Q ").append(queenCount).append("\n");
        if (rookCount > 0) sb.append("R ").append(rookCount).append("\n");
        if (bishopCount > 0) sb.append("B ").append(bishopCount).append("\n");
        if (knightCount > 0) sb.append("N ").append(knightCount).append("\n");
        if (pawnCount > 0) sb.append("P ").append(pawnCount).append("\n");

        if(player == ChessColor.BLACK){
            return sb.toString();
        }else{
            return sb.toString().toLowerCase();
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent cc = chessComponents[sourceX][sourceY];
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        if(cc.getColor()!=currentPlayer || !cc.canMoveTo().contains(target)){
            return false;
        }else {
            chessComponents[targetX][targetY] = cc;
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));

//            if (currentPlayer == ChessColor.BLACK) {
//                currentPlayer = ChessColor.WHITE;
//            }
//
//            if (currentPlayer == ChessColor.WHITE) {
//                currentPlayer = ChessColor.BLACK;
//            }
            currentPlayer = currentPlayer.changeTurn();
            return true;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMoveList = getChess(source.getX(),source.getY()).canMoveTo();

        canMoveList.sort((i1,i2) ->
            (i1.getX()-i2.getX())*8 + (i1.getY()-i2.getY())
        );
        return canMoveList;
    }
}

























