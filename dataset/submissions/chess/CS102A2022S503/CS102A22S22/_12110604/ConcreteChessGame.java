
        import java.util.List;

        public class ConcreteChessGame implements ChessGame{
            private ChessComponent[][] chessComponents= new ChessComponent[8][8];

            private ChessColor currentPlayer= ChessColor.WHITE;

            public static ChessComponent[][] chessComponent;

            public ConcreteChessGame() {
            }

            public void setChessComponents(ChessComponent[][] chessComponents) {
                this.chessComponents = chessComponents;
            }

            public static ChessComponent[][] getChessComponent() {
                return chessComponent;
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
                        ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                        char a=chessboard.get(i).charAt(j);
                        switch (a) {
                            case 'k' -> chessComponents[i][j] = new KingChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'K' -> chessComponents[i][j] = new KingChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            case 'q' -> chessComponents[i][j] = new QueenChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'Q' -> chessComponents[i][j] = new QueenChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            case 'r' -> chessComponents[i][j] = new RookChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'R' -> chessComponents[i][j] = new RookChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            case 'b' -> chessComponents[i][j] = new BishopChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'B' -> chessComponents[i][j] = new BishopChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            case 'n' -> chessComponents[i][j] = new KnightChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'N' -> chessComponents[i][j] = new KnightChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            case 'p' -> chessComponents[i][j] = new PawnChessComponent(chessboardPoint, ChessColor.WHITE, a);
                            case 'P' -> chessComponents[i][j] = new PawnChessComponent(chessboardPoint, ChessColor.BLACK, a);
                            default -> chessComponents[i][j] = new EmptySlotComponent(chessboardPoint, ChessColor.NONE, a);
                        }
                    }
                }
                setChessComponents(chessComponents);
                setChessComponent(chessComponents);
                char b=chessboard.get(8).charAt(0);
                if (b == 'w') {
                    this.currentPlayer = ChessColor.WHITE;
                }else{
                    this.currentPlayer = ChessColor.BLACK;
                }
            }

            public ChessColor getCurrentPlayer() {
                return this.currentPlayer;
            }

            /**
             *
             * @return
             */
            public String getChessboardGraph(){
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 8; j++) {
                        str.append(chessComponents[i][j].name);
                    }
                    str.append("\n");
                }
                for (int i = 0; i < 8; i++) {
                    str.append(chessComponents[7][i].name);
                }
                return str.toString();
            }

            public String getCapturedChess(ChessColor player) {
                StringBuilder str = new StringBuilder();
                if(player==ChessColor.WHITE){
                    int k = 0;
                    int q = 0;
                    int r = 0;
                    int b = 0;
                    int n = 0;
                    int p = 0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            char a = chessComponents[i][j].name;
                            switch (a) {
                                case 'k' -> k++;
                                case 'q' -> q++;
                                case 'b' -> b++;
                                case 'n' -> n++;
                                case 'r' -> r++;
                                case 'p' -> p++;
                            }
                        }
                    }

                    if(k==0){
                        str.append("k 1\n");
                    }if(q==0){
                        str.append("q 1\n");
                    } if(r<=1){
                        str.append("r ").append(2 - r).append("\n");
                    } if (b<=1){
                        str.append("b ").append(2 - b).append("\n");
                    } if(n<=1){
                        str.append("n ").append(2 - n).append("\n");
                    } if(p<=7){
                        str.append("p ").append(8 - p).append("\n");
                    }

                }else{
                    int K = 0;
                    int Q = 0;
                    int B = 0;
                    int N = 0;
                    int R = 0;
                    int P = 0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            char a = chessComponents[i][j].name;
                            switch (a) {
                                case 'K' -> K++;
                                case 'Q' -> Q++;
                                case 'B' -> B++;
                                case 'N' -> N++;
                                case 'R' -> R++;
                                case 'P' -> P++;
                            }
                        }
                    }

                    if(K==0){
                        str.append("K 1\n");
                    } if(Q==0){
                        str.append("Q 1\n");
                    } if(R<=1){
                        str.append("R ").append(2 - R).append("\n");
                    } if (B<=1){
                        str.append("B ").append(2 - B).append("\n");
                    } if(N<=1){
                        str.append("N ").append(2 - N).append("\n");
                    } if(P<=7){
                        str.append("P ").append(8 - P).append("\n");
                    }

                }
                return str.toString();
            }

            @Override
            public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
                return getChess(source.getX(),source.getY()).canMoveTo();
            }

            @Override
            public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
                ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
                List<ChessboardPoint> list = getCanMovePoints(source);
                ChessboardPoint target = new ChessboardPoint(targetX,targetY);

                boolean b1 = false;
                if(list.size()!=0){
                    for (ChessboardPoint chessboardPoint : list) {
                        if (chessboardPoint.getX() == target.getX() && chessboardPoint.getY() == target.getY()) {
                            b1 = true;
                            break;
                        }
                    }
                }

                boolean b2 = false;
                if(getCurrentPlayer()==getChess(sourceX,sourceY).getChessColor()&& b1){
                    if(getChess(sourceX,sourceY).getChessColor()==ChessColor.WHITE){
                        setCurrentPlayer(ChessColor.BLACK);
                    }else{
                        setCurrentPlayer(ChessColor.WHITE);
                    }
                    b2 = true;

                    ChessboardPoint point = new ChessboardPoint(targetX,targetY);
                    chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                    chessComponents[targetX][targetY].setSource(point);
                    chessComponent[targetX][targetY] = getChess(sourceX,sourceY);
                    chessComponent[targetX][targetY].setSource(point);

                    ChessboardPoint point1 = new ChessboardPoint(sourceX,sourceY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(point1,ChessColor.NONE,'_');

                    chessComponent[sourceX][sourceY] = new EmptySlotComponent(point1,ChessColor.NONE,'_');

                }
                return b2;
            }

            public ChessComponent getChess(int x, int y){
                return chessComponents[x][y];
            }

        }
