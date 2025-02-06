import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard){
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                char qp=chessboard.get(x).charAt(y);
                switch (qp){
                    case 'R':
                    case 'r':
                        chessComponents[x][y]=new RookChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case 'N':
                    case 'n':
                        chessComponents[x][y]=new KnightChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case 'B':
                    case 'b':
                        chessComponents[x][y]=new BishopChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case 'Q':
                    case 'q':
                        chessComponents[x][y]=new QueenChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case 'K':
                    case 'k':
                        chessComponents[x][y]=new KingChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case 'P':
                    case 'p':
                        chessComponents[x][y]=new PawnChessComponent(x,y);
                        chessComponents[x][y].setQiPan(this);
                        break;
                    case '_':
                        chessComponents[x][y]=new EmptyChessComponent(x,y);
                        chessComponents[x][y].setChessColor(ChessColor.NONE);
                        chessComponents[x][y].setQiPan(this);
                        break;
                }
                if (qp>40&&qp<91){
                    chessComponents[x][y].setChessColor(ChessColor.BLACK);
                }
                if (qp>96&&qp<123){
                    chessComponents[x][y].setChessColor(ChessColor.WHITE);
                }
            }
        }
        switch (chessboard.get(8).charAt(0)){
            case 'b':
                currentPlayer=ChessColor.BLACK;
                break;
            case 'w':
                currentPlayer=ChessColor.WHITE;
                break;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        StringBuilder answer=new StringBuilder();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                char ak = switch (getChess(x, y).getChessColor()) {
                    case BLACK -> getChess(x, y).name;
                    case WHITE -> (char) (getChess(x, y).name + 32);
                    case NONE -> '_';
                };
                answer.append(ak);
                if (y==7&&x!=7){
                    answer.append('\n');
                }
            }
        }
        return answer.toString();
    }
    @Override
    public String getCapturedChess(ChessColor chessColor){
        StringBuilder answer=new StringBuilder();
        final char[] agBlack={'K','Q','R','B','N','P'};
        final char[] agWhite={'k','q','r','b','n','p'};
        int[] ad={1,1,2,2,2,8};
        int[] ap=new int[100];ap['K']=0;ap['Q']=1;ap['R']=2;ap['B']=3;ap['N']=4;ap['P']=5;
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                if (getChess(x,y).getChessColor()==chessColor){
                    ad[ap[(int) getChess(x,y).name]]--;
                }
            }
        }
        for (int i=0;i<6;i++){
            if (ad[i]!=0){
                switch (chessColor){
                    case BLACK:
                        answer.append(agBlack[i]);answer.append(' ');answer.append(ad[i]);answer.append('\n');
                        break;
                    case WHITE:
                        answer.append(agWhite[i]);answer.append(' ');answer.append(ad[i]);answer.append('\n');
                        break;
                }
            }
        }
        return answer.toString();
    }
    @Override
    public boolean moveChess(int sourceX,int sourceY,int targetX,int targetY){
        boolean a=false;
        if (getChess(sourceX,sourceY).getChessColor()!=currentPlayer){
            return false;
        }
        for (int i=0;i<getChess(sourceX,sourceY).canMoveTo().size();i++){
            if (targetX==getChess(sourceX,sourceY).canMoveTo().get(i).getX()){
                if (targetY==getChess(sourceX,sourceY).canMoveTo().get(i).getY()){
                    a=true;break;
                }
            }
        }
        if (!a){
            return false;
        }
        chessComponents[targetX][targetY]=getChess(sourceX,sourceY);
        chessComponents[sourceX][sourceY]=new EmptyChessComponent(sourceX,sourceY);
        chessComponents[targetX][targetY].source.setXY(targetX,targetY);
        chessComponents[targetX][targetY].desecrate();
        if (getChess(targetX,targetY).getChessColor()==ChessColor.WHITE){
            currentPlayer=ChessColor.BLACK;
        }else {
            currentPlayer=ChessColor.WHITE;
        }
        return true;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ArrayList<ChessboardPoint> answer=(ArrayList<ChessboardPoint>) getChess(source.getX(),source.getY()).canMoveTo();
        Collections.sort(answer, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return (o1.getX()*8+o1.getY())-(o2.getX()*8+o2.getY());
            }
        });
        return answer;
    }
}