import java.util.ArrayList;
import java.util.List;
public  class ConcreteChessGame implements ChessGame
{
    private ChessComponent[][]chessComponents = new ChessComponent[8][8];

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessColor currentPlayer=ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i = 0 ;i<8;i++){
            for(int u = 0;u<8;u++){
                if(chessboard.get(i).charAt(u)=='k'){chessComponents[i][u]=new KingChessComponent();chessComponents[i][u].name='k';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='K'){chessComponents[i][u]=new KingChessComponent();chessComponents[i][u].name='K';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='p'){chessComponents[i][u]=new PawnChessComponent();chessComponents[i][u].name='p';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='P'){chessComponents[i][u]=new PawnChessComponent();chessComponents[i][u].name='P';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='q'){chessComponents[i][u]=new QueenChessComponent();chessComponents[i][u].name='q';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='Q'){chessComponents[i][u]=new QueenChessComponent();chessComponents[i][u].name='Q';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='B'){chessComponents[i][u]=new BishopChessComponent();chessComponents[i][u].name='B';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='b'){chessComponents[i][u]=new BishopChessComponent();chessComponents[i][u].name='b';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='N'){chessComponents[i][u]=new KnightChessComponent();chessComponents[i][u].name='N';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='n'){chessComponents[i][u]=new KnightChessComponent();chessComponents[i][u].name='n';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='R'){chessComponents[i][u]=new RookChessComponent();chessComponents[i][u].name='R';chessComponents[i][u].setChessColor(ChessColor.BLACK);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='r'){chessComponents[i][u]=new RookChessComponent();chessComponents[i][u].name='r';chessComponents[i][u].setChessColor(ChessColor.WHITE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
                if(chessboard.get(i).charAt(u)=='_'){chessComponents[i][u]=new EmptySlotComponent();chessComponents[i][u].name='_';chessComponents[i][u].setChessColor(ChessColor.NONE);chessComponents[i][u].setSource(new ChessboardPoint(i,u));chessComponents[i][u].belonging= this ;}
            }
        }
        if(chessboard.get(8).equals("w"))currentPlayer=ChessColor.WHITE;
        else currentPlayer=ChessColor.BLACK;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int i,u,v;
        for(i=0;i<8;i++){
            for(u=0;u<8;u++){
                for(v=0;v<chessComponents[source.getX()][source.getY()].canMoveTo().size();v++){
                    ChessboardPoint newChessPoint = new ChessboardPoint(i,u);
                    if(newChessPoint.getX()==chessComponents[source.getX()][source.getY()].canMoveTo().get(v).getX()
                            &&newChessPoint.getY()==chessComponents[source.getX()][source.getY()].canMoveTo().get(v).getY())
                        canMovePoints.add(new ChessboardPoint(i,u));
                }
            }
        }
        return canMovePoints;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        int e=0;
        for(int i = 0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++) {
            if (targetX == chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()&&
                    targetY== chessComponents[sourceX][sourceY].canMoveTo().get(i).getY())e++;
        }
        if(targetX<=7&&targetX>=0&&targetY<=7&&targetY>=0&&chessComponents[sourceX][sourceY].getChessColor()==currentPlayer&&e!=0){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            if (currentPlayer==ChessColor.BLACK) currentPlayer=ChessColor.WHITE;
            else currentPlayer=ChessColor.BLACK;
            return true;
        }
        else {return false;}
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder ChessboardGraph = new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int u =0;u<8;u++){
                if(chessComponents[i][u]instanceof KingChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('k');
                if(chessComponents[i][u]instanceof KingChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('K');
                if(chessComponents[i][u]instanceof PawnChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('p');
                if(chessComponents[i][u]instanceof PawnChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('P');
                if(chessComponents[i][u]instanceof QueenChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('q');
                if(chessComponents[i][u]instanceof QueenChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('Q');
                if(chessComponents[i][u]instanceof BishopChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('B');
                if(chessComponents[i][u]instanceof BishopChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('b');
                if(chessComponents[i][u]instanceof KnightChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('N');
                if(chessComponents[i][u]instanceof KnightChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('n');
                if(chessComponents[i][u]instanceof RookChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.BLACK)ChessboardGraph.append('R');
                if(chessComponents[i][u]instanceof RookChessComponent &&chessComponents[i][u].getChessColor()==ChessColor.WHITE)ChessboardGraph.append('r');
                if(chessComponents[i][u]instanceof EmptySlotComponent)ChessboardGraph.append('_');
            }
            if(i!=7)ChessboardGraph.append("\n");
        }
        return ChessboardGraph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player){
        int k1=1,p1=8,q1=1,b1=2,r1=2,n1=2,i,u;
        if (player == ChessColor.BLACK){
            for( i = 0;i<8;i++){
                for( u = 0; u<8;u++){
                    if(getChess(i,u).getChessColor()==ChessColor.BLACK){
                        if(getChess(i,u)instanceof KnightChessComponent)n1--;
                        if(getChess(i,u) instanceof KingChessComponent)k1--;
                        if(getChess(i,u) instanceof QueenChessComponent)q1--;
                        if(getChess(i,u) instanceof BishopChessComponent)b1--;
                        if(getChess(i,u) instanceof PawnChessComponent)p1--;
                        if(getChess(i,u) instanceof RookChessComponent)r1--;
                    }
                }
            }
            StringBuilder s = new StringBuilder();
            if(k1!=0){s.append("K ");s.append(k1);s.append("\n");}
            if(q1!=0){s.append("Q ");s.append(q1);s.append("\n");}
            if(r1!=0){s.append("R ");s.append(r1);s.append("\n");}
            if(b1!=0){s.append("B ");s.append(b1);s.append("\n");}
            if(n1!=0){s.append("N ");s.append(n1);s.append("\n");}
            if(p1!=0){s.append("P ");s.append(p1);s.append("\n");}
            return s.toString();
        }
        if (player == ChessColor.WHITE){
            for( i = 0;i<8;i++){
                for( u = 0; u<8;u++){
                    if(getChess(i,u).getChessColor()==ChessColor.WHITE){
                        if(getChess(i,u)instanceof KnightChessComponent)n1--;
                        if(getChess(i,u) instanceof KingChessComponent)k1--;
                        if(getChess(i,u) instanceof QueenChessComponent)q1--;
                        if(getChess(i,u) instanceof BishopChessComponent)b1--;
                        if(getChess(i,u) instanceof PawnChessComponent)p1--;
                        if(getChess(i,u) instanceof RookChessComponent)r1--;}

                }
            }
            StringBuilder s = new StringBuilder();
            if(k1!=0){s.append("k ");s.append(k1);s.append("\n");}
            if(q1!=0){s.append("q ");s.append(q1);s.append("\n");}
            if(r1!=0){s.append("r ");s.append(r1);s.append("\n");}
            if(b1!=0){s.append("b ");s.append(b1);s.append("\n");}
            if(n1!=0){s.append("n ");s.append(n1);s.append("\n");}
            if(p1!=0){s.append("p ");s.append(p1);s.append("\n");}
            return s.toString();
        }
        return null;
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
