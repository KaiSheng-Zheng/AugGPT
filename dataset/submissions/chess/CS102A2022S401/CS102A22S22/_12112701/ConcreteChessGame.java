import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        chessComponents=new ChessComponent[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j]=new KingChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j]=new QueenChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j]=new RookChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j]=new BishopChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j]=new KnightChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setColor(ChessColor.BLACK);
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j]=new PawnChessComponent();
                    chessComponents[i][j].setColor(ChessColor.WHITE);
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setSource(i,j);
                }
                if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j]=new EmptySlotComponent();
                    chessComponents[i][j].setColor(ChessColor.NONE);
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setSource(i,j);
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else currentPlayer=ChessColor.BLACK;

    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String Graph="";
        String[][] graph =new String[8][8];
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].name=='K'){
                    graph[i][j]="K";
                }
                if (chessComponents[i][j].name=='k'){
                    graph[i][j]="k";
                }
                if (chessComponents[i][j].name=='Q'){
                    graph[i][j]="Q";
                }
                if (chessComponents[i][j].name=='q'){
                    graph[i][j]="q";
                }
                if (chessComponents[i][j].name=='R'){
                    graph[i][j]="R";
                }
                if (chessComponents[i][j].name=='r'){
                    graph[i][j]="r";
                }
                if (chessComponents[i][j].name=='N'){
                    graph[i][j]="N";
                }
                if (chessComponents[i][j].name=='n'){
                    graph[i][j]="n";
                }
                if (chessComponents[i][j].name=='P'){
                    graph[i][j]="P";
                }
                if (chessComponents[i][j].name=='p'){
                    graph[i][j]="p";
                }
                if (chessComponents[i][j].name=='B'){
                    graph[i][j]="B";
                }
                if (chessComponents[i][j].name=='b'){
                    graph[i][j]="b";
                }
                if (chessComponents[i][j].name=='_'){
                    graph[i][j]="_";
                }
            }
        }
        for (int i=0;i<8;i++){
            Graph+=graph[0][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[1][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[2][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[3][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[4][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[5][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[6][i];
        }
        Graph+="\n";
        for (int i=0;i<8;i++){
            Graph+=graph[7][i];
        }
        Graph+="\n";
        return Graph;
    }

    public String getCapturedChess(ChessColor player){
        String CapturedChess="";
        String graph=getChessboardGraph();
        if(player.equals(ChessColor.WHITE)){
            int king =1;
            int queen=1;
            int rook=2;
            int pawn=8;
            int knight=2;
            int bishop=2;
            for (int i=0;i<graph.length();i++){
                if(graph.charAt(i)=='k'){king-=1;}
                if(graph.charAt(i)=='q'){queen-=1;}
                if(graph.charAt(i)=='r'){rook-=1;}
                if(graph.charAt(i)=='p'){pawn-=1;}
                if(graph.charAt(i)=='n'){knight-=1;}
                if(graph.charAt(i)=='b'){bishop-=1;}
            }
            if(king!=0){CapturedChess+="k "+king;}
            if(queen!=0){CapturedChess+="\n"+"q "+queen;}
            if(rook!=0){CapturedChess+="\n"+"r "+rook;}
            if(bishop!=0){CapturedChess+="\n"+"b "+bishop;}
            if(knight!=0){CapturedChess+="\n"+"n "+knight;}
            if(pawn!=0){CapturedChess+="\n"+"p "+pawn;}
        }

        if(player.equals(ChessColor.BLACK)){
            int king =1;
            int queen=1;
            int rook=2;
            int pawn=8;
            int knight=2;
            int bishop=2;
            for (int i=0;i<graph.length();i++){
                if(graph.charAt(i)=='K'){king-=1;}
                if(graph.charAt(i)=='Q'){queen-=1;}
                if(graph.charAt(i)=='R'){rook-=1;}
                if(graph.charAt(i)=='P'){pawn-=1;}
                if(graph.charAt(i)=='N'){knight-=1;}
                if(graph.charAt(i)=='B'){bishop-=1;}
            }
            if(king!=0){CapturedChess+="K "+king;}
            if(queen!=0){CapturedChess+="\n"+"Q "+queen;}
            if(rook!=0){CapturedChess+="\n"+"R "+rook;}
            if(bishop!=0){CapturedChess+="\n"+"B "+bishop;}
            if(knight!=0){CapturedChess+="\n"+"N "+knight;}
            if(pawn!=0){CapturedChess+="\n"+"P "+pawn;}
        }
        return CapturedChess;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        if(canMovePoints.size()>0){
            for(int i=0;i<canMovePoints.size()-1;i++){
                for(int j=i+1;j<canMovePoints.size();j++){
                    if(canMovePoints.get(i).Calculate()>canMovePoints.get(j).Calculate()){
                        int a=canMovePoints.get(i).getX();
                        int b=canMovePoints.get(i).getY();
                        canMovePoints.remove(i);
                        canMovePoints.add(i,new ChessboardPoint(canMovePoints.get(j-1).getX(),canMovePoints.get(j-1).getY()));
                        canMovePoints.remove(j);
                        canMovePoints.add(j,new ChessboardPoint(a,b));
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean whether=false;
        if(chessComponents[sourceX][sourceY].getColor()==this.currentPlayer){
            for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
                if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(targetX,targetY);
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setName('_');
                    chessComponents[sourceX][sourceY].setColor(ChessColor.NONE);
                    chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                    chessComponents[targetX][targetY].setChessComponents(chessComponents);
                    chessComponents[sourceX][sourceY].setChessComponents(chessComponents);
                    if(this.getCurrentPlayer().equals(ChessColor.WHITE)){
                        this.currentPlayer=ChessColor.BLACK;
                    }
                    else if(this.getCurrentPlayer().equals(ChessColor.BLACK)){
                        this.currentPlayer=ChessColor.WHITE;
                    }
                    whether=true;
                    break;
                }
            }
        }
        return whether;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }




}
