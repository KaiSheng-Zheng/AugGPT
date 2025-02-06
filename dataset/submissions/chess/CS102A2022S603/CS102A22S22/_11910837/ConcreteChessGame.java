import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;



    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                char chessChar=chessboard.get(i).charAt(j);
                switch (chessChar){
                    case '_':
                        EmptySlotComponent eChess=new EmptySlotComponent();
                        eChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=eChess;
                        break;
                    case 'K':
                        KingChessComponent KChess=new KingChessComponent(ChessColor.BLACK);
                        KChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=KChess;
                        break;
                    case 'k':
                        KingChessComponent kChess=new KingChessComponent();
                        kChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=kChess;
                        break;
                    case 'Q':
                        QueenChessComponent QChess=new QueenChessComponent(ChessColor.BLACK);
                        QChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=QChess;
                        break;
                    case 'q':
                        QueenChessComponent qChess=new QueenChessComponent();
                        qChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=qChess;
                        break;
                    case 'R':
                        RookChessComponent RChess=new RookChessComponent(ChessColor.BLACK);
                        RChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=RChess;
                        break;
                    case 'r':
                        RookChessComponent rChess=new RookChessComponent();
                        rChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=rChess;
                        break;
                    case 'B':
                        BishopChessComponent BChess=new BishopChessComponent(ChessColor.BLACK);
                        BChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=BChess;
                        break;
                    case 'b':
                        BishopChessComponent bChess=new BishopChessComponent();
                        bChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=bChess;
                        break;
                    case 'N':
                        KnightChessComponent NChess=new KnightChessComponent(ChessColor.BLACK);
                        NChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=NChess;break;
                    case 'n':
                        KnightChessComponent nChess=new KnightChessComponent();
                        nChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=nChess;break;
                    case 'P':
                        PawnChessComponent PChess=new PawnChessComponent(ChessColor.BLACK);
                        PChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=PChess;break;
                    case 'p':
                        PawnChessComponent pChess=new PawnChessComponent();
                        pChess.setSource(new ChessboardPoint(i,j));
                        chessComponents[i][j]=pChess;break;

                }
            }
        }

        String currentColor=chessboard.get(8);
        switch (currentColor){
            case "w":currentPlayer=ChessColor.WHITE;break;
            case "b":currentPlayer=ChessColor.BLACK;break;
        }
    }



    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }


    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public ChessComponent getChess(ChessboardPoint point){return chessComponents[point.getX()][point.getY()];}

    public String getChessboardGraph(){
        StringBuilder result=new StringBuilder();
        for (int i=0;i<7;i++){
            for (int j=0;j<8;j++){
                result.append(chessComponents[i][j].getName());
            }
            result.append("\n");
        }
        for (int j=0;j<8;j++){
            result.append(chessComponents[7][j].getName());
        }

        return String.valueOf(result);

    }

    @Override
    public String getCapturedChess(ChessColor player){
        int[]getCapturedChess={1, 1, 2, 2, 2, 8};
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].getChessColor()==player){
                    getCapturedChess[chessComponents[i][j].getID()]--;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        for (int i=0;i<5;i++){
            if (getCapturedChess[i]!=0){
                result.append(String.format("%s %d\n",ChessComponent.IDtoChessComponent(i,player).getName(),getCapturedChess[i]));
            }
        }
        if (getCapturedChess[5]!=0){
            result.append(String.format("%s %d",ChessComponent.IDtoChessComponent(5,player).getName(),getCapturedChess[5]));
        }

        return result.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean flag = false;
        ChessComponent selectedChess = getChess(sourceX, sourceY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        if (targetX>=0&&targetX<=7&&targetY>=0&&targetY<=7&&selectedChess.getChessColor()==currentPlayer){
            List<ChessboardPoint> canMoveList = getCanMovePoints(source);
            for (int i = 0; i < canMoveList.size(); i++) {
                if (canMoveList.get(i).getX() == targetX&&canMoveList.get(i).getY()==targetY) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
                selectedChess.setSource(target);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[targetX][targetY] = selectedChess;
            }
        }
        return flag;
    }

    public boolean canGoAcross(ChessboardPoint source, ChessboardPoint target){
        int sourceX=source.getX();int sourceY=source.getY();
        int targetX= target.getX();int targetY=target.getY();
        boolean flag=true;
        if (getChess(source).getChessColor()!=getChess(target).getChessColor()){
            int deltax=targetX-sourceX;int deltaY=targetY-sourceY;
            if (deltax==0){
                if (deltaY>0){
                    for (int i=1;i<deltaY;i++){
                        if (getChess(sourceX,sourceY+i).getID()!=6){flag=false;}
                    }
                }else {
                    for (int i=-1;i>deltaY;i--){
                        if (getChess(sourceX,sourceY+i).getID()!=6){flag=false;}
                    }
                }

            }else if (deltaY==0){
                if (deltax>0){
                    for (int i=1;i<deltax;i++){
                        if (getChess(sourceX+i,sourceY).getID()!=6){flag=false;}
                    }
                }else {
                    for (int i=-1;i>deltax;i--){
                        if (getChess(sourceX+i,sourceY).getID()!=6){flag=false;}
                    }
                }

            }else if (deltax==deltaY&&deltax>0){
                for (int i=1;i<deltax;i++){
                    if (getChess(sourceX+i,sourceY+i).getID()!=6){flag=false;}
                }
            }else if (deltax==deltaY&&deltax<0){
                for (int i=-1;i>deltax;i--){
                    if (getChess(sourceX+i,sourceY+i).getID()!=6){flag=false;}
                }
            }else if (deltax+deltaY==0&&deltax>0){
                for (int i=1;i<deltax;i++){
                    if (getChess(sourceX+i,sourceY-i).getID()!=6){flag=false;}
                }
            }else if (deltax+deltaY==0&&deltax<0){
                for (int i=1;i<deltaY;i++){
                    if (getChess(sourceX-i,sourceY+i).getID()!=6){flag=false;}
                }
            }

        }else{
            flag=false;
        }

        return flag;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();

        ChessComponent chess=getChess(source.getX(),source.getY());
        int[][] CanMove=new int[8][8];
        if (chess.getID()!=5&&chess.getID()!=4){
            for (int i=0;i<chess.canMoveTo().size();i++){
                ChessboardPoint targetLocation=chess.canMoveTo().get(i);
                if (canGoAcross(source,targetLocation)){
                    CanMove[targetLocation.getX()][targetLocation.getY()]=1;
                }
            }
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (CanMove[i][j]!=0&&chess.getChessColor()!=getChess(i,j).getChessColor()){
                        canMovePoints.add(new ChessboardPoint(i,j));
                    }
                }
            }

        }else if (chess.getID()==5){
            for (int i=0;i<chess.canMoveTo().size();i++) {
                ChessboardPoint targetLocation=chess.canMoveTo().get(i);
                if (canGoAcross(source,targetLocation)&&getChess(targetLocation).getChessColor()==ChessColor.NONE) {
                    CanMove[targetLocation.getX()][targetLocation.getY()]=1;
                }
            }
            if (getChess(source.getX()+ chess.getSgn(),source.getY()-1).getChessColor()!=ChessColor.NONE&&source.offset(chess.getSgn(),-1,1)&&getChess(source.getX()+ chess.getSgn(),source.getY()-1).getChessColor()!=chess.getChessColor()){
                CanMove[source.getX()+chess.getSgn()][source.getY()-1]=1;
            }
            if (getChess(source.getX()+chess.getSgn(),source.getY()+1).getChessColor()!=ChessColor.NONE&&source.offset(chess.getSgn(),1,1)&&getChess(source.getX()+chess.getSgn(),source.getY()+1).getChessColor()!=chess.getChessColor()){
                CanMove[source.getX()+chess.getSgn()][source.getY()+1]=1;
            }
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (CanMove[i][j]!=0&&chess.getChessColor()!=getChess(i,j).getChessColor()&&!(i==source.getX()&&j==source.getY())){
                        canMovePoints.add(new ChessboardPoint(i,j));
                    }
                }
            }


        }else if (chess.getID()==4){
            for (int i=0;i<chess.canMoveTo().size();i++){
                ChessboardPoint targetLocation=chess.canMoveTo().get(i);
                if (getChess(targetLocation).getChessColor()!=chess.getChessColor()){
                    CanMove[targetLocation.getX()][targetLocation.getY()]=1;
                }
            }
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (CanMove[i][j]!=0&&chess.getChessColor()!=getChess(i,j).getChessColor()){
                        canMovePoints.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }

        return canMovePoints;
    }


}



