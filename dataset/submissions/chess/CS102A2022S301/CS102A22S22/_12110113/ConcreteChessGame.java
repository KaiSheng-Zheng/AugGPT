import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;

    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void loadGameContinue(ChessComponent[][] chessComponent){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                this.chessComponents[i][j].setChessboard(chessComponent);
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            String line=chessboard.get(i);
            for (int j=0;j<8;j++){
                if (line.charAt(j)=='R'){chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,i,j,'R');}
                else if (line.charAt(j)=='r'){chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,i,j,'r');}
                else if (line.charAt(j)=='N'){chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,i,j,'N');}
                else if (line.charAt(j)=='n'){chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,i,j,'n');}
                else if (line.charAt(j)=='B'){chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,i,j,'B');}
                else if (line.charAt(j)=='b'){chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,i,j,'b');}
                else if (line.charAt(j)=='Q'){chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,i,j,'Q');}
                else if (line.charAt(j)=='q'){chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,i,j,'q');}
                else if (line.charAt(j)=='K'){chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,i,j,'K');}
                else if (line.charAt(j)=='k'){chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,i,j,'k');}
                else if (line.charAt(j)=='P'){chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,i,j,'P');}
                else if (line.charAt(j)=='p'){chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,i,j,'p');}
                else if (line.charAt(j)=='_'){chessComponents[i][j]=new EmptySlotComponent(null,i,j,'_');}
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }
        else {this.currentPlayer=ChessColor.BLACK;}
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
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
    public String getChessboardGraph() {
        String graph="";
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                graph+=chessComponents[i][j].name;
            }
            graph+="\n";
        }
        return graph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        char[] list1=new char[6];
        int[] number1=new int[6];
        list1[0]='K';number1[0]=1;
        list1[1]='Q';number1[1]=1;
        list1[2]='R';number1[2]=2;
        list1[3]='B';number1[3]=2;
        list1[4]='N';number1[4]=2;
        list1[5]='P';number1[5]=8;
        char[] list2=new char[6];
        int[] number2=new int[6];
        list2[0]='k';number2[0]=1;
        list2[1]='q';number2[1]=1;
        list2[2]='r';number2[2]=2;
        list2[3]='b';number2[3]=2;
        list2[4]='n';number2[4]=2;
        list2[5]='p';number2[5]=8;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].name=='K'){number1[0]-=1;}
                else if (chessComponents[i][j].name=='k'){number2[0]-=1;}
                else if (chessComponents[i][j].name=='Q'){number1[1]-=1;}
                else if (chessComponents[i][j].name=='q'){number2[1]-=1;}
                else if (chessComponents[i][j].name=='R'){number1[2]-=1;}
                else if (chessComponents[i][j].name=='r'){number2[2]-=1;}
                else if (chessComponents[i][j].name=='B'){number1[3]-=1;}
                else if (chessComponents[i][j].name=='b'){number2[3]-=1;}
                else if (chessComponents[i][j].name=='N'){number1[4]-=1;}
                else if (chessComponents[i][j].name=='n'){number2[4]-=1;}
                else if (chessComponents[i][j].name=='P'){number1[5]-=1;}
                else if (chessComponents[i][j].name=='p'){number2[5]-=1;}
            }
        }
        String lost="";
        if (player==ChessColor.WHITE){
            for (int i=0;i<6;i++){
                if (number2[i]>0){
                    lost=lost+list2[i]+" "+number2[i]+"\n";
                }
            }
        }
        else {
            for (int i=0;i<6;i++){
                if (number1[i]>0){
                    lost=lost+list1[i]+" "+number1[i]+"\n";
                }
            }
        }
        return lost;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        int length=canMovePoints.size();
        int[] member=new int[length];
        for (int i=0;i<length;i++){
            member[i]=canMovePoints.get(i).getX()*10+canMovePoints.get(i).getY();
        }
        int temp1,temp2;
        int temp;
        ChessboardPoint Temp;
        for (int i=1;i<length;i++){
            Temp=canMovePoints.get(i);
            temp=member[i];
            int j=0;
            for (j=i-1;j>=0;j--){
                if (member[j]>temp){
                    member[j+1]=member[j];
                    canMovePoints.set(j+1,canMovePoints.get(j));
                }
                else {break;}
            }
            if (member[j+1]!=temp){
                member[j+1]=temp;
                canMovePoints.set(j+1,Temp);
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMove=chessComponents[sourceX][sourceY].canMoveTo();
        int length=canMove.size();
        boolean judgement1=false;
        if (chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer()){
            judgement1=true;
        }
        boolean judgement2=false;
        for (int i=0;i<length;i++){
            if (canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                judgement2=true;
                break;
            }
        }
        boolean judgement=false;
        if (judgement1&&judgement2){
            judgement=true;
        }

        if (judgement) {
            chessComponents[sourceX][sourceY].step += 1;
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].getSource().setX(targetX);
            chessComponents[targetX][targetY].getSource().setY(targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(null, sourceX, sourceY, '_');
            if (this.currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else {
                this.currentPlayer = ChessColor.WHITE;
            }
            loadGameContinue(this.chessComponents);
        }
        return judgement;

    }
}
