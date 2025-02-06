import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent implements CanEat {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        super(source, chessColor, name, id);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int sourceX = this.getSource().getX();
        int sourceY = this.getSource().getY();
        if (this.getChessColor() == ChessColor.BLACK) {
            switch (sourceX) {
                case 1:{
                    if (this.getChessboard()[sourceX + 1][sourceY] instanceof EmptySlotComponent) {
                        chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY));
                        if (this.getChessboard()[sourceX + 2][sourceY] instanceof EmptySlotComponent) {
                            chessboardPoints.add(new ChessboardPoint(sourceX + 2, sourceY));
                        }
                    }

                    if (sourceY - 1 >= 0) {
                        if (this.getChessboard()[sourceX + 1][sourceY - 1].getChessColor() == ChessColor.WHITE) {
                            chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY - 1));
                        }
                        if (sourceY + 1 <= 7) {
                            if (this.getChessboard()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE) {
                                chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
                            }
                        }
                    } else {
                        if (this.getChessboard()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE) {
                            chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
                        }
                    }
                    break;
            }
                default:
                    if (this.getChessboard()[sourceX + 1][sourceY] instanceof EmptySlotComponent) {
                        chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY));
                    }
                    if (sourceY - 1 >= 0) {
                        if (this.getChessboard()[sourceX + 1][sourceY - 1].getChessColor() == ChessColor.WHITE) {
                            chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY - 1));
                        }
                        if (sourceY + 1 <= 7) {
                            if (this.getChessboard()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE) {
                                chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
                            }
                        }
                    } else {
                        if (this.getChessboard()[sourceX + 1][sourceY + 1].getChessColor() == ChessColor.WHITE) {
                            chessboardPoints.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
                        }
                    }


            }

        } else
            switch (sourceX) {
                case 6: {
                    if (this.getChessboard()[sourceX - 1][sourceY] instanceof EmptySlotComponent) {
                        chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY));
                        if (this.getChessboard()[sourceX - 2][sourceY] instanceof EmptySlotComponent) {
                            chessboardPoints.add(new ChessboardPoint(sourceX - 2, sourceY));
                        }
                    }
                    if (sourceY - 1 >= 0) {
                        if (this.getChessboard()[sourceX - 1][sourceY - 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY - 1));
                        }
                        if (sourceY + 1 <= 7) {
                            if (this.getChessboard()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK) {
                                chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
                            }
                        }
                    } else {
                        if (this.getChessboard()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
                        }
                    }
                    break;
                }
                default:
                    if (this.getChessboard()[sourceX - 1][sourceY] instanceof EmptySlotComponent) {
                        chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY));
                    }
                    if (sourceY - 1 >= 0) {
                        if (this.getChessboard()[sourceX - 1][sourceY - 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY - 1));
                        }
                        if (sourceY + 1 <= 7) {
                            if (this.getChessboard()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK) {
                                chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
                            }
                        }
                    } else {
                        if (this.getChessboard()[sourceX - 1][sourceY + 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
                        }
                    }

            }

        return chessboardPoints;
    }

    @Override
    public boolean canEat(int x, int y) {
        if (!((this.getChessboard()[x][y]) instanceof EmptySlotComponent)) {
            if (this.getChessColor() != this.getChessboard()[x][y].getChessColor()) {
                return true;
            } else
                return false;
        } else
            return true;
    }
}