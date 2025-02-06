import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        String[] line;
        for (int x = 0; x < 8; x++) {
            line=chessboard.get(x).split("");
            for (int y = 0; y < 8; y++) {
                switch (line[y]){
                    case "R":
                        chessComponents[x][y]=new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "N":
                        chessComponents[x][y]=new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "B":
                        chessComponents[x][y]=new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "Q":
                        chessComponents[x][y]=new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "K":
                        chessComponents[x][y]=new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "P":
                        chessComponents[x][y]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "_":
                        chessComponents[x][y]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "r":
                        chessComponents[x][y]=new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "n":
                        chessComponents[x][y]=new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "b":
                        chessComponents[x][y]=new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "q":
                        chessComponents[x][y]=new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "k":
                        chessComponents[x][y]=new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                    case "p":
                        chessComponents[x][y]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(x,y),chessComponents);
                        break;
                }
            }
        }
        switch (chessboard.get(8)){
            case "w":
                currentPlayer=ChessColor.WHITE;
                break;
            case "b":
                currentPlayer=ChessColor.BLACK;
                break;
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
        String output_graph="";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                output_graph=output_graph.concat(chessComponents[x][y].toString());
            }
            output_graph=output_graph.concat("\n");
        }
        return output_graph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        char[] black = {'K','Q','R','B','N','P'};
        char[] white = {'k','q','r','b','n','p'};
        int[] count ={1,1,2,2,2,8};
        int[] orig={1,1,2,2,2,8};
        char[] current_color = player.equals(ChessColor.BLACK)?black:white;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                for (int type = 0; type < 6; type++) {
                    if (chessComponents[x][y].getName()==current_color[type]){
                        count[type]--;
                    }
                }
            }
        }
        String output="";
        for (int type = 0; type < 6; type++) {
            if (count[type]!=0){
                output=output.concat(String.valueOf(current_color[type])+" "+(count[type])+"\n");
            }
        }
        return output;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> list;
        list = chessComponents[source.getX()][source.getY()].canMoveTo();
        return list;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> list;
        if (chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
            return false;
        list = chessComponents[sourceX][sourceY].getmovable(new ChessboardPoint(sourceX,sourceY),chessComponents);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX()==targetX&&list.get(i).getY()==targetY){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY),chessComponents);
                if (currentPlayer==ChessColor.WHITE)
                    currentPlayer=ChessColor.BLACK;
                else
                    currentPlayer=ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }
}
