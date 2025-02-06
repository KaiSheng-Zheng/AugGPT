
                import java.util.List;
                import java.util.Objects;

                public class ConcreteChessGame implements ChessGame{
                    private ChessComponent[][] chessComponents= new ChessComponent[8][8];

                    private ChessColor currentPlayer= ChessColor.WHITE;

                    public static ChessComponent[][] chessComponent;

                    public ConcreteChessGame() {
                    }

                    public void setChessComponents(ChessComponent[][] chessComponents) {
                        this.chessComponents = chessComponents;
                    }


                    public void setChessComponent(ChessComponent[][] chessComponents) {
                        chessComponent = chessComponents;
                    }

                    public void setCurrentPlayer(ChessColor currentPlayer) {
                        this.currentPlayer = currentPlayer;
                    }

                    public void loadChessGame(List<String> chessboard) {
                        ChessComponent[][] chessComponents=new ChessComponent[8][8];
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                switch (chessboard.get(i).charAt(j)) {
                                    case 'K' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), 'K', ChessColor.BLACK);
                                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), 'Q', ChessColor.BLACK);
                                    case 'R' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), 'R', ChessColor.BLACK);
                                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), 'B', ChessColor.BLACK);
                                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), 'N', ChessColor.BLACK);
                                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), 'P', ChessColor.BLACK);
                                    case 'k' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), 'k', ChessColor.WHITE);
                                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), 'q', ChessColor.WHITE);
                                    case 'r' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), 'r', ChessColor.WHITE);
                                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), 'b', ChessColor.WHITE);
                                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), 'n', ChessColor.WHITE);
                                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), 'p', ChessColor.WHITE);
                                    default -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE);

                                }

                            }


                        }
                        setChessComponents(chessComponents);
                        setChessComponent(chessComponents);
                        char b=chessboard.get(8).charAt(0);
                        if (Objects.equals(chessboard.get(8), "w")) {
                            currentPlayer = ChessColor.WHITE;
                        }
                        if (Objects.equals(chessboard.get(8), "b")) {
                            currentPlayer = ChessColor.BLACK;
                        }
                    }

                    public ChessColor getCurrentPlayer() {
                        return this.currentPlayer;
                    }
                    @Override
                    public String getChessboardGraph() {
                        char[][] graph = new char[8][8];
                        for (int i = 0;i < 8;i++)
                            for (int j = 0;j < 8;j++)
                                graph[i][j] = chessComponents[i][j].name;
                        return  String.valueOf(graph[0]) + "\n" +
                                String.valueOf(graph[1]) + "\n" +
                                String.valueOf(graph[2]) + "\n" +
                                String.valueOf(graph[3]) + "\n" +
                                String.valueOf(graph[4]) + "\n" +
                                String.valueOf(graph[5]) + "\n" +
                                String.valueOf(graph[6]) + "\n" +
                                String.valueOf(graph[7]);
                    }

                    @Override
                    public String getCapturedChess(ChessColor player) {
                        int K=0,Q=0,R=0,B=0,N=0,P=0,k=0,q=0,r=0,b=0,n=0,p=0;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (chessComponents[i][j].name=='K'){
                                    K++;
                                } if (chessComponents[i][j].name=='Q'){
                                    Q++;
                                } if (chessComponents[i][j].name=='R'){
                                    R++;
                                } if (chessComponents[i][j].name=='B'){
                                    B++;
                                } if (chessComponents[i][j].name=='N'){
                                    N++;
                                } if (chessComponents[i][j].name=='P'){
                                    P++;
                                } if (chessComponents[i][j].name=='k'){
                                    k++;
                                } if (chessComponents[i][j].name=='q'){
                                    q++;
                                } if (chessComponents[i][j].name=='r'){
                                    r++;
                                } if (chessComponents[i][j].name=='b'){
                                    b++;
                                } if (chessComponents[i][j].name=='n'){
                                    n++;
                                } if (chessComponents[i][j].name=='p'){
                                    p++;
                                }
                            }
                        }
                        StringBuilder stringBuilder=new StringBuilder();
                        if (player==ChessColor.BLACK){
                            if (1-K>0){
                                stringBuilder.append(String.format("K %d\n",1-K));
                            }if (1-Q>0){
                                stringBuilder.append(String.format("Q %d\n",1-Q));
                            }if (2-R>0){
                                stringBuilder.append(String.format("R %d\n",2-R));
                            }if (2-B>0){
                                stringBuilder.append(String.format("B %d\n",2-B));
                            }if (2-N>0){
                                stringBuilder.append(String.format("N %d\n",2-N));
                            }if (8-P>0){
                                stringBuilder.append(String.format("P %d\n",8-P));
                            }
                        }
                        else {if (1-k>0){
                            stringBuilder.append(String.format("k %d\n",1-k));
                        }if (1-q>0){
                            stringBuilder.append(String.format("q %d\n",1-q));
                        }if (2-r>0){
                            stringBuilder.append(String.format("r %d\n",2-r));
                        }if (2-b>0){
                            stringBuilder.append(String.format("b %d\n",2-b));
                        }if (2-n>0){
                            stringBuilder.append(String.format("n %d\n",2-n));
                        }if (8-p>0){
                            stringBuilder.append(String.format("p %d\n",8-p));
                        }

                        }
                        return stringBuilder.toString();
                    } public ChessComponent getChess(int x, int y){
                        return chessComponents[x][y];
                    }


                    @Override
                    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
                        return getChess(source.getX(),source.getY()).canMoveTo();
                    }

                    @Override
                    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
                        boolean Boolean1=false;
                        boolean Boolean2=false;
                        ChessboardPoint Mid = new ChessboardPoint(sourceX,sourceY);
                        ChessboardPoint Tem = new ChessboardPoint(targetX,targetY);
                        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
                        List<ChessboardPoint> list = getCanMovePoints(source);
                        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
                        if(list.size()!=0){
                            for (ChessboardPoint chessboardPoint : list) {
                                if (chessboardPoint.getX() == target.getX() && chessboardPoint.getY() == target.getY()) {
                                   Boolean1 = true;
                                    break;
                                }
                            }
                        }
                        if(getCurrentPlayer()==getChess(sourceX,sourceY).getChessColor()&& Boolean1){
                            if(getChess(sourceX,sourceY).getChessColor()==ChessColor.BLACK){setCurrentPlayer(ChessColor.WHITE);}
                            else{setCurrentPlayer(ChessColor.BLACK);}
                            chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                            chessComponents[targetX][targetY].setSource(Tem);
                            chessComponent[targetX][targetY] = getChess(sourceX,sourceY);
                            chessComponent[targetX][targetY].setSource(Tem);
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent(Mid,ChessColor.NONE);
                            chessComponent[sourceX][sourceY] = new EmptySlotComponent(Mid,ChessColor.NONE);
                            Boolean2 = true;
                        }
                        if (Boolean2){
                            return true;
                        }
                        else {
                            return false;
                        }
                    }


                }