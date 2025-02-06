import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame extends ChessComponent implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    private int countk=1,countq=1,countr=2,countb=2,countn=2,countp=8,countK=1,countQ=1,countR=2,countB=2,countN=2,countP=8;

    @Override
    public void loadChessGame(List<String> chessboard){
        if (chessboard.get(8).equals("w")){
            currentPlayer =ChessColor.WHITE;}
        if (chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;}
        for (int i = 0; i < 8; i++) {
            for(int j = 0;j < 8;j++){
                char name = chessboard.get(i).charAt(j);
                switch (name) {
                    case 'r' -> {
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countr--;
                    }
                    case 'n' -> {
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countn--;
                    }
                    case 'b' -> {
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countb--;
                    }
                    case 'q' -> {
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countq--;
                    }
                    case 'k' -> {
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countk--;
                    }
                    case 'p' -> {
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, name, chessComponents);
                        countp--;
                    }
                    case '_' -> this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, name, chessComponents);
                    case 'R' -> {
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countR--;
                    }
                    case 'N' -> {
                        this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countN--;
                    }
                    case 'B' -> {
                        this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countB--;
                    }
                    case 'Q' -> {
                        this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countQ--;
                    }
                    case 'K' -> {
                        this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countK--;
                    }
                    case 'P' -> {
                        this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, name, chessComponents);
                        countP--;
                    }
                }
            }
        }

    }

    public String getChessboardGraph(){
        StringBuilder chessboardGraph= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char  a = chessComponents[i][j].name;
                chessboardGraph.append(a);
            }
            chessboardGraph.append("\n");

        }
        return chessboardGraph.toString(); }
//public void getCount(ChessComponent[][] chessComponents){
//    for (int i = 0; i < 8; i++) {
//        for (int j = 0; j < 8; j++) {
//            switch (name) {
//                case 'r' -> countr--;
//                case 'n' -> countn--;
//                case 'b' -> countb--;
//                case 'q' -> countq--;
//                case 'k' -> countk--;
//                case 'p' ->countp--;
//                case '_' -> {
//                }
//                case 'R' -> countR--;
//                case 'N' -> countN--;
//                case 'B' -> countB--;
//                case 'Q' -> countQ--;
//                case 'K' -> countK--;
//                case 'P' -> countP--;
//            }
//        }
//    }}
    public String getCapturedChess(ChessColor player){
            String str = "";
        if (player == ChessColor.WHITE) {
            if (countk!=0) {
                str+='k'+" "+countk+"\n";
            }
            if (countq!=0) {str+='q'+" "+countq+"\n";
            }
            if (countr!=0) {str+='r'+" "+countr+"\n";
            }
            if (countb!=0) {str+='b'+" "+countb+"\n";
            }
            if (countn!=0) {str+='n'+" "+countn+"\n";
            }
            if (countp!=0) {str+='p'+" "+countp+"\n";
            }

        }if (player == ChessColor.BLACK) {
                if (countK!=0) {str+='K'+" "+countK+"\n";
                }
                if (countQ!=0) {str+='Q'+" "+countQ+"\n";
                }
                if (countR!=0) {str+='R'+" "+countR+"\n";
                }
                if (countB!=0) {str+='B'+" "+countB+"\n";
                }
                if (countN!=0) {str+='N'+" "+countN+"\n";
                }
                if (countP!=0) {str+='P'+" "+countP+"\n";
                }
        }return str;}

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y){return chessComponents[x][y];}

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y =source.getY();
        ChessComponent chess = getChess(x,y);
        return chess.canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        int n = 0;
        if(getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()){
            for (int i = 0; i < getCanMovePoints(source).size(); i++) {
               if(getCanMovePoints(source).get(i).getX()==targetX&&getCanMovePoints(source).get(i).getY()==targetY) n++;
            }
           if(n==1)
//        if(getCanMovePoints(source).contains(target))
        { switch (chessComponents[targetX][targetY].name){
            case 'r' -> countr++;
            case 'n' -> countn++;
            case 'b' -> countb++;
            case 'q' -> countq++;
            case 'k' -> countk++;
            case 'p' ->countp++;
            case '_' -> {
            }
            case 'R' -> countR++;
            case 'N' -> countN++;
            case 'B' -> countB++;
            case 'Q' -> countQ++;
            case 'K' -> countK++;
            case 'P' -> countP++;}
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
//            chessComponents[targetX][targetY].setSource(target);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(source,ChessColor.NONE,'_',chessComponents);
//            char name =  getChess(sourceX,sourceY).name;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
//                    char name = chessComponents[targetX][targetY].name;
                    switch (chessComponents[i][j].name) {
                        case 'r' -> this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'n' -> this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'b' -> this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'q' -> this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'k' -> this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'p' -> this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.WHITE, name, chessComponents);
                        case 'R' -> this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        case 'N' -> this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        case 'B' -> this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        case 'Q' -> this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        case 'K' -> this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        case 'P' -> this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j), ChessColor.BLACK, name, chessComponents);
                        default -> this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE, name, chessComponents);
                    }
                    }
                }
                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
            return true;
            }
           else return false;}
        else return false;
    }

}