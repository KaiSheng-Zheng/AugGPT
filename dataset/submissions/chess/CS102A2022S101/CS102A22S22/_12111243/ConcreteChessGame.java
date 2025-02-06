import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }
    public ConcreteChessGame(){
    }


    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            char[] row = chessboard.get(i).toCharArray();
            for (int j = 0; j < 8; j++){
                char c = row[j];
                if (c == '_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(chessComponents);
                }
                else if (c == 'R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'b'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                else if (c == 'p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        } else{
            this.currentPlayer=ChessColor.BLACK;}
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
    public String getCapturedChess(ChessColor player) {
        int RR=2,NN=2,BB=2,QQ=1,KK=1,PP=8;
        int rr=2,nn=2,bb=2,qq=1,kk=1,pp=8;
        StringBuilder captured = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].getName()=='R')
                        RR--;
                if(chessComponents[i][j].getName()=='N')
                        NN--;
                if(chessComponents[i][j].getName()=='B')
                        BB--;
                if(chessComponents[i][j].getName()=='Q')
                        QQ--;
                if(chessComponents[i][j].getName()=='K')
                        KK--;
                if(chessComponents[i][j].getName()=='P')
                        PP--;
                if(chessComponents[i][j].getName()=='r')
                        rr--;
                if(chessComponents[i][j].getName()=='n')
                        nn--;
                if(chessComponents[i][j].getName()=='b')
                        bb--;
                if(chessComponents[i][j].getName()=='q')
                        qq--;
                if(chessComponents[i][j].getName()=='k')
                        kk--;
                if(chessComponents[i][j].getName()=='p')
                        pp--;
            }
        }
        if(player==ChessColor.WHITE){
            if(kk!=0) captured.append(String.format("k %d\n",1));
            if(qq!=0) captured.append(String.format("q %d\n",1));
            if(rr!=0) captured.append(String.format("r %d\n",rr));
            if(bb!=0) captured.append(String.format("b %d\n",bb));
            if(nn!=0) captured.append(String.format("n %d\n",nn));
            if(pp!=0) captured.append(String.format("p %d\n",pp));
            return captured.toString();

        }
        else{
            if(KK!=0) captured.append(String.format("K %d\n",1));
            if(QQ!=0) captured.append(String.format("Q %d\n",1));
            if(RR!=0) captured.append(String.format("R %d\n",RR));
            if(BB!=0) captured.append(String.format("B %d\n",BB));
            if(NN!=0) captured.append(String.format("N %d\n",NN));
            if(PP!=0) captured.append(String.format("P %d\n",PP));
            return captured.toString();
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
        ChessboardPoint loc = new ChessboardPoint(sourceX,sourceY);
        List<ChessboardPoint> pos = this.getCanMovePoints(loc);
        int flag = 0;
        for(int i=0;i<pos.size();i++){
            if(pos.get(i).getX()==targetX&&pos.get(i).getY()==targetY)
              flag++;
        }
        if(flag==0)
            return false;
        else{
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            if(currentPlayer.equals(ChessColor.BLACK)){
                currentPlayer = ChessColor.WHITE;
            }
            else{
                currentPlayer = ChessColor.BLACK;
            }
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            return true;
        }
        }
        else
            return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());//chess.canMoveTo()
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for(int i=0;i<canMovePoints.size()-1;i++){
            for(int j=0;j<canMovePoints.size()-1-i;j++){
                if(SetSortRule(canMovePoints.get(j),canMovePoints.get(j+1))==true) {
                    ChessboardPoint tmp = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,tmp);
                }
            }
        }
        return canMovePoints;
    }
    public boolean SetSortRule(ChessboardPoint p1,ChessboardPoint p2) {
        if (p1.getX() > p2.getX()) {
            return true;
        }
        else if (p1.getX() == p2.getX()) {
            return (p1.getY() > p2.getY());
        }
        else {
            return false;
        }
    }

    @Override
    public String getChessboardGraph(){
        String[] ans = new String[8];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                res.append(chessComponents[i][j].getName());
            }
            ans[i] = res.toString();
            res.delete(0,res.length());
        }
        for(int i=0;i<8;i++){
            res.append(ans[i]+"\n");
        }
        return res.toString();
    }
}
