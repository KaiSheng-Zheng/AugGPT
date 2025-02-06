import java.util.List;

public class ConcreteChessGame implements  ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.NONE;

    @Override
    public void loadChessGame(List<String> chessboard){
        if(chessboard==null) return;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                char a=chessboard.get(i).charAt(j);
                ChessColor color;
                ChessboardPoint point=new ChessboardPoint(i,j);
                if(a>='A'&&a<='Z') color=ChessColor.BLACK;
                else if(a>='a'&&a<='z') color=ChessColor.WHITE;
                else color=ChessColor.NONE;
                if(a=='R'||a=='r')
                    chessComponents[i][j]= new RookChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='N'||a=='n')
                    chessComponents[i][j]= new KnightChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='B'||a=='b')
                    chessComponents[i][j]= new BishopChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='Q'||a=='q')
                    chessComponents[i][j]= new QueenChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='K'||a=='k')
                    chessComponents[i][j]= new KingChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='P'||a=='p')
                    chessComponents[i][j]= new PawnChessComponent(point, color, chessboard.get(i).charAt(j),this);
                if(a=='_')
                    chessComponents[i][j]= new EmptySlotComponent(point, color, chessboard.get(i).charAt(j),this);
            }
        if(chessboard.get(8).charAt(0)=='w')currentPlayer=ChessColor.WHITE;
        else currentPlayer=ChessColor.BLACK;
    }
    @Override
    public String getChessboardGraph() {
        StringBuilder a=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                a.append(chessComponents[i][j].getName());
            a.append('\n');
        }
        return a.toString();
    }
    @Override
    public String getCapturedChess(ChessColor player){
        int[] num={1,1,2,2,2,8};
        StringBuilder ans=new StringBuilder();
        if(player==ChessColor.BLACK){
            char[] sor={'K','Q','R','B','N','P'};
            for(int i=0;i<6;i++){
                int Num=0;
                for(int j=0;j<8;j++){
                    for(int k=0;k<8;k++)
                        if(chessComponents[j][k].getName()==sor[i])
                            Num++;
                }
                if(Num<num[i])
                    ans.append(String.format("%c %d\n",sor[i],num[i]-Num));
            }
        }
        if(player==ChessColor.WHITE){
            char[] sor={'k','q','r','b','n','p'};
            for(int i=0;i<6;i++){
                int Num=0;
                for(int j=0;j<8;j++){
                    for(int k=0;k<8;k++)
                        if(chessComponents[j][k].getName()==sor[i])
                            Num++;
                }
                if(Num<num[i])
                    ans.append(String.format("%c %d\n",sor[i],num[i]-Num));
            }
        }
        return ans.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        ChessboardPoint.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=chessComponents[sourceX][sourceY];
        if(!ChessboardPoint.ontheboard(sourceX,sourceY)&&!ChessboardPoint.ontheboard(targetX,targetY))
            return false;
        if(chess.getChessColor()!=currentPlayer) return false;
        List<ChessboardPoint> list=chess.canMoveTo();
        int n= list.size();
        for(int i=0;i<n;i++) {
            int x=list.get(i).getX(),y=list.get(i).getY();
            if (x == targetX && y == targetY) {
                chess.setSource(new ChessboardPoint(x, y));
                ChessComponent chessComponent=chess;
                if(chess instanceof BishopChessComponent) chessComponent=new BishopChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());
                else if(chess instanceof KingChessComponent) chessComponent=new KingChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());
                else if(chess instanceof KnightChessComponent) chessComponent=new KnightChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());
                else if(chess instanceof PawnChessComponent) chessComponent=new PawnChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());
                else if(chess instanceof QueenChessComponent) chessComponent=new QueenChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());
                else if(chess instanceof RookChessComponent) chessComponent=new RookChessComponent(chess.getSource(),chess.getChessColor(),chess.name,chess.getConcreteChessGame());

                chessComponents[x][y] = chessComponent;//?keyima
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_', this);
                changeCurrentPlayer();
                return true;
            }
        }
        return false;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        if(x>=0&&x<8&&y>=0&&y<8) return chessComponents[x][y];
        return null;
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public void changeCurrentPlayer() {
        currentPlayer = (currentPlayer==ChessColor.WHITE)?ChessColor.BLACK:ChessColor.WHITE;
    }

    public boolean canadd(ChessComponent chessComponent, int dx, int dy){
        ChessboardPoint chessboardPoint=chessComponent.getSource();
        if(!chessboardPoint.ontheboard(chessboardPoint.getX()+dx,chessboardPoint.getY()+dy)) return false;
        ChessComponent chess=getChess(chessboardPoint.getX()+dx,chessboardPoint.getY()+dy);
        if(chess.getChessColor()==chessComponent.getChessColor()) return false;
        return true;
    }
}