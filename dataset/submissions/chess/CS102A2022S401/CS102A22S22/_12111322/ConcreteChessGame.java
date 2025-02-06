import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private static ChessComponent[][] staticChessComponents = new ChessComponent[8][8];

    public static ChessColor getColor(ChessboardPoint source){
        return staticChessComponents[source.getX()][source.getY()].getChessColor();
    }
    public void setStaticChessComponents(){
        staticChessComponents = chessComponents;
    }
    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

   public void loadChessGame(List<String> chessboard){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessComponent chess = null;
                ChessboardPoint point = new ChessboardPoint(x,y);
                switch (chessboard.get(x).charAt(y)){
                    case 'r':
                        chess = new RookChessComponent(point,ChessColor.WHITE,'r');
                        break;
                    case 'n':
                        chess = new KnightChessComponent(point,ChessColor.WHITE,'n');
                        break;
                    case 'b':
                        chess = new BishopChessComponent(point,ChessColor.WHITE,'b');
                        break;
                    case 'q':
                        chess = new QueenChessComponent(point,ChessColor.WHITE,'q');
                        break;
                    case 'k':
                        chess = new KingChessComponent(point,ChessColor.WHITE,'k');
                        break;
                    case 'p':
                        chess = new PawnChessComponent(point,ChessColor.WHITE,'p');
                        break;
                    case '_':
                        chess = new EmptySlotComponent(point,ChessColor.NONE,'_');
                        break;
                    case 'R':
                        chess = new RookChessComponent(point,ChessColor.BLACK,'R');
                        break;
                    case 'N':
                        chess = new KnightChessComponent(point,ChessColor.BLACK,'N');
                        break;
                    case 'B':
                        chess = new BishopChessComponent(point,ChessColor.BLACK,'B');
                        break;
                    case 'Q':
                        chess = new QueenChessComponent(point,ChessColor.BLACK,'Q');
                        break;
                    case 'K':
                        chess = new KingChessComponent(point,ChessColor.BLACK,'K');
                        break;
                    case 'P':
                        chess = new PawnChessComponent(point,ChessColor.BLACK,'P');
                        break;
                }
                chessComponents[x][y]=chess;
                staticChessComponents[x][y]=chess;
            }
        }
        switch (chessboard.get(8)){
            case "w":
                this.currentPlayer=ChessColor.WHITE;
                break;
            case "b":
                this.currentPlayer=ChessColor.BLACK;
                break;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder ChessboardGraph = new StringBuilder();
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                ChessboardGraph.append(chessComponents[x][y].name);
            }
            ChessboardGraph.append("\n");
        }
        return ChessboardGraph.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder CapturedChess = new StringBuilder();
        int R = 0,N = 0,B = 0,Q = 0,K = 0,P = 0;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(player == ChessColor.WHITE){
                    switch (chessComponents[x][y].name){
                        case 'r':
                            R++;
                            break;
                        case 'n':
                            N++;
                            break;
                        case 'b':
                            B++;
                            break;
                        case 'q':
                            Q++;
                            break;
                        case 'k':
                            K++;
                            break;
                        case 'p':
                            P++;
                            break;
                    }
                }else if(player == ChessColor.BLACK){
                    switch (chessComponents[x][y].name){
                        case 'R':
                            R++;
                            break;
                        case 'N':
                            N++;
                            break;
                        case 'B':
                            B++;
                            break;
                        case 'Q':
                            Q++;
                            break;
                        case 'K':
                            K++;
                            break;
                        case 'P':
                            P++;
                            break;
                    }
                }
            }
        }
        if(player == ChessColor.WHITE){
            if(K!=1){
                CapturedChess.append(String.format("k %d\n",1-K));
            }
            if(Q!=1){
                CapturedChess.append(String.format("q %d\n",1-Q));
            }
            if(R!=2){
                CapturedChess.append(String.format("r %d\n",2-R));
            }
            if(B!=2){
                CapturedChess.append(String.format("b %d\n",2-B));
            }
            if(N!=2){
                CapturedChess.append(String.format("n %d\n",2-N));
            }
            if(P!=8){
                CapturedChess.append(String.format("p %d\n",8-P));
            }
        }
        else if (player == ChessColor.BLACK){
            if(K!=1){
                CapturedChess.append(String.format("K %d\n",1-K));
            }
            if(Q!=1){
                CapturedChess.append(String.format("Q %d\n",1-Q));
            }
            if(R!=2){
                CapturedChess.append(String.format("R %d\n",2-R));
            }
            if(B!=2){
                CapturedChess.append(String.format("B %d\n",2-B));
            }
            if(N!=2){
                CapturedChess.append(String.format("N %d\n",2-N));
            }
            if(P!=8){
                CapturedChess.append(String.format("P %d\n",8-P));
            }
        }
        return CapturedChess.toString();

    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessComponent sourceChess = chessComponents[sourceX][sourceY];
        boolean contains = false;
        List<ChessboardPoint> canMoveToPoints = sourceChess.canMoveTo();
        for (int i = 0;i<canMoveToPoints.size();i++){
            if(canMoveToPoints.get(i).getX()==targetX&&canMoveToPoints.get(i).getY()==targetY){
                contains=true;
                break;
            }
        }
        if(currentPlayer!=sourceChess.getChessColor()){
            return false;
        }
        if(contains==false){
            return false;
        }
            chessComponents[targetX][targetY]=sourceChess;
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(source,ChessColor.NONE,'_');
            chessComponents[targetX][targetY].setSource(target);
            setStaticChessComponents();
            switch (currentPlayer){
                case BLACK:
                    currentPlayer=ChessColor.WHITE;
                    break;
                case WHITE:
                    currentPlayer=ChessColor.BLACK;
                    break;
                default:
                    break;
            }
            return true;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort((o1, o2) -> (int)(o1.getX() * 10 + o1.getY() - o2.getX() * 10 - o2.getY()));
        return canMovePoints;
    }


}
