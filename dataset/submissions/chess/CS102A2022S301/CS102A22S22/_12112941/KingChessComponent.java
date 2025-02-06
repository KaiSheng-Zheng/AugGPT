import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessColor color;
    ChessComponent[][] a;

    public KingChessComponent(ChessComponent[][] a) {
        this.a = a;
        if (name == 'K')
            color = ChessColor.BLACK;
        else if (name == 'k')
            color = ChessColor.WHITE;
    }

//    public ChessColor getColor() {
//        return color;
//    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        if (ConcreteChessGame.x - 1 > 0 && ConcreteChessGame.y - 1 > 0 && ConcreteChessGame.x + 1 < 7 && ConcreteChessGame.y + 1 < 7) {
            if (name == 'k') {
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                }
                if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                }
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name <= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                }
            } else {
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                }
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                }
                if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                }
                if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                }
                if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                    chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                }

            }
        } else if (ConcreteChessGame.x == 0) {
            if (ConcreteChessGame.y == 0) {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }

                }
            } else if (ConcreteChessGame.y == 7) {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }

                }
            } else {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y-1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y-1));
                    }
                    if (a[ConcreteChessGame.x ][ConcreteChessGame.y -1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x , ConcreteChessGame.y - 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y-1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y-1));
                    }
                    if (a[ConcreteChessGame.x ][ConcreteChessGame.y -1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x , ConcreteChessGame.y - 1));
                    }
                }
            }

        }
        else if (ConcreteChessGame.x==7){
            if (ConcreteChessGame.y == 0) {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x -1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y +1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x -1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y +1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }

                }
            } else if (ConcreteChessGame.y == 7) {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }

                }
            } else {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x ][ConcreteChessGame.y+1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x , ConcreteChessGame.y+1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                    }
                } else {
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x ][ConcreteChessGame.y+1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x , ConcreteChessGame.y+1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y + 1));
                    }
                }

            }
        }
        else {
            if (ConcreteChessGame.y==0) {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x-1][ConcreteChessGame.y - 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x-1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y ].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y ));
                    }
                } else {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x-1][ConcreteChessGame.y - 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x-1, ConcreteChessGame.y - 1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y ].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y ));
                    }
                }
            }
            else {
                if (name == 'k') {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x-1][ConcreteChessGame.y + 1].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x-1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y ].name <= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y ));
                    }
                } else {
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y));
                    }
                    if (a[ConcreteChessGame.x + 1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x + 1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x-1][ConcreteChessGame.y + 1].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x-1, ConcreteChessGame.y + 1));
                    }
                    if (a[ConcreteChessGame.x - 1][ConcreteChessGame.y ].name >= 95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x - 1, ConcreteChessGame.y ));
                    }
                }
            }
        }
        chessboardPointList.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()>o2.getX())
                    return 1;
                else if (o1.getX()<o2.getX())
                    return -1;
                else {
                    if (o1.getY() >o2.getY())
                        return 1;
                    else if (o1.getY() < o2.getY())
                        return -1;
                    else
                        return 0;
                }
            }
        });
        return chessboardPointList;
    }
}
