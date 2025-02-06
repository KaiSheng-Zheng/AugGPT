public class Circle extends Shape {
    private int radius;
    
    

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        
        fillGrids();
    }

    public void fillGrids() {
        this.grids = new char[this.radius * 2][this.radius * 2];
        this.countPattern = 0;
        for (int i = 0; i < this.radius * 2; i++) {
            for (int j = 0; j < this.radius * 2; j++) {
                this.grids[i][j] = ' ';
            }
        }
        
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                double xCenter = (double) j + 0.5;
                double xLeft = j;
                double xRight = (double) j + 1.0;
                double yCenter = (double) i + 0.5;
                double yUp = i;
                double yDown = (double) i + 1.0;
                double radiusSquare = this.radius * this.radius;

                double distanceCentersSquare = (radius - xCenter) * (radius - xCenter) + (radius - yCenter) * (radius - yCenter);
                
                if (distanceCentersSquare < radiusSquare) {
                    this.grids[i][j] = this.pattern;
                    this.countPattern++;
                } else {
                    if (xCenter < radius) {
                        
                        double distanceUpRightSquare = (radius - xRight) * (radius - xRight) + (radius - yUp) * (radius - yUp);
                        double distanceRightSquare = (radius - xRight) * (radius - xRight) + (radius - yCenter) * (radius - yCenter);
                        double distanceDownRightSquare = (radius - xRight) * (radius - xRight) + (radius - yDown) * (radius - yDown);
                        if (distanceUpRightSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        } else if (distanceRightSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        } else if (distanceDownRightSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        }
                    } else if (xCenter == radius) {
                        double distanceUpSquare = (radius - xCenter) * (radius - xCenter) + (radius - yUp) * (radius - yUp);
                        double distanceDownSquare = (radius - xCenter) * (radius - xCenter) + (radius - yDown) * (radius - yDown);
                        if (distanceUpSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        } else if (distanceDownSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        }
                    } else {
                        double distanceUpLeftSquare = (radius - xLeft) * (radius - xLeft) + (radius - yUp) * (radius - yUp);
                        double distanceLeftSquare = (radius - xLeft) * (radius - xLeft) + (radius - yCenter) * (radius - yCenter);
                        double distanceDownLeftSquare = (radius - xLeft) * (radius - xLeft) + (radius - yDown) * (radius - yDown);
                        if (distanceUpLeftSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        } else if (distanceLeftSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        } else if (distanceDownLeftSquare < radiusSquare) {
                            this.grids[i][j] = this.pattern;
                            this.countPattern++;
                        }
                    }
                }
            }
        }
    }

    public void enlarge() {
        this.radius += 1;
        fillGrids();
    }

    public void shrink() {
        this.radius -= 1;
        fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    public int area() {
        return countPattern;
    }

    public String toString() {
        return super.toString("Circle");
    }
}










