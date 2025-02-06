import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard=new ArrayList<>();




    public ConcreteChessGame(){
        currentPlayer=ChessColor.WHITE;
        chessComponents=new ChessComponent[8][8];
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;++i){
            for (int j=0;j<8;++j){
                chessComponents[i][j]=ChessComponent.transbyChar(i,j,chessboard.get(i).charAt(j));
            }
        }if (chessboard.get(8).equals("w")){currentPlayer=ChessColor.WHITE;}
        else if (chessboard.get(8).equals("b")){currentPlayer=ChessColor.BLACK;}
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String result="";
        for (int i=0;i<8;++i) {
            for (int j = 0; j < 8; ++j) {
                result=result.concat(String.valueOf(chessComponents[i][j].name));
            }result=result.concat("\n");
        }
        return result;
        //return chessboard.get(0)+"\n"+chessboard.get(1)+"\n"+chessboard.get(2)+"\n"+chessboard.get(3)+"\n"+chessboard.get(4)+"\n"+chessboard.get(5)+"\n"+chessboard.get(6)+"\n"+chessboard.get(7)+"\n";
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String getCapturedChess(ChessColor player){
        List<ChessComponent> captured= new ArrayList<>();
        String result= "";
        captured.add(new KingChessComponent(player));
        captured.add(new QueenChessComponent(player));
        captured.add(new RookChessComponent(player));
        captured.add(new BishopChessComponent(player));
        captured.add(new KnightChessComponent(player));
        captured.add(new PawnChessComponent(player));
        int[] count = new int[]{1,1,2,2,2,8};
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (chessComponents[i][j].getChessColor()==player){
                    if (chessComponents[i][j].name=='K'||chessComponents[i][j].name=='k'){
                        count[0]-=1;
                    }else if (chessComponents[i][j].name=='Q'||chessComponents[i][j].name=='q'){
                        count[1]-=1;
                    }else if (chessComponents[i][j].name=='R'||chessComponents[i][j].name=='r'){
                        count[2]-=1;
                    }else if (chessComponents[i][j].name=='B'||chessComponents[i][j].name=='b'){
                        count[3]-=1;
                    }else if (chessComponents[i][j].name=='N'||chessComponents[i][j].name=='n'){
                        count[4]-=1;
                    }else if (chessComponents[i][j].name=='P'||chessComponents[i][j].name=='p'){
                        count[5]-=1;
                    }
                }
            }
        }for (int i=0;i<6;++i){
            if (count[i]!=0){
                result=result.concat(captured.get(i).getName()+" "+count[i]+"\n");
            }
        }return result;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer()){
            int dx = targetX-sourceX;
            int dy = targetY-sourceY;
            if (legal(chessComponents[sourceX][sourceY].canMoveTo(),targetX,targetY)){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(chessComponents[sourceX][sourceY].getSource().offset(dx, dy));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
                swapColor();
                return true;
            }
        }
        return false;
    }
    public void swapColor() {
        this.currentPlayer = this.currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }
    public boolean legal(List<ChessboardPoint> listpoint,int x,int y){
        for (ChessboardPoint point : listpoint){
            if (point.getX()==x&&point.getY()==y){
                return true;
            }
        }return false;
    }
}