public class Player {
        private final int id;
        private int score;
        private int steps;
        private Position position;
        private Map map;
        private static int count = 0;
        private int maxStepAllowed;

        public Player(Map map, Position initialPosition) {
            this.map = map;
            this.position = initialPosition;
            id = ++count;
            maxStepAllowed = Integer.MAX_VALUE;
            steps = 0;
            score = 0;
        }

        public Player(Map map, Position initialPosition, int maxStepAllowed) {
            this.map = map;
            this.position = initialPosition;
            id = ++count;
            this.maxStepAllowed = maxStepAllowed;
            steps = 0;
            score = 0;
        }

        public Position getPosition() {
            return position;
        }

        public int getScore() {
            return score;
        }

        public int getId() {
            return id;
        }

        public int getSteps() {
            return steps;
        }
        public boolean move(Direction direction, int steps) {
            if (!map.isActive())
                return false;
                int step = this.steps;
            if (this.steps + steps <= maxStepAllowed) {
                switch (direction) {
                    case UP : if (position.getRow() - steps >= 0) {
                        for (int i = 1; i <= steps; i++)
                        {
                            position.setRow(position.getRow() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&& this.steps < step + steps)
                                return false;
                        }
                        return true;
                    }
                    else
                    {
                        int row = position.getRow();
                        for (int i = 1; i <= row; i++)
                        {
                            position.setRow(position.getRow() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return false;
                    }
                    case DOWN : if (position.getRow() + steps < map.getRows()) {
                        for (int i = 1; i <= steps; i++)
                        {
                            position.setRow(position.getRow() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return true;
                    }
                    else
                    {
                        int row = position.getRow();
                        for (int i = 1; i < map.getRows() - row; i++)
                        {
                            position.setRow(position.getRow() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return false;
                    }
                    case LEFT : if (position.getCol() - steps >= 0) {
                        for (int i = 1; i <= steps; i++)
                        {
                            position.setCol(position.getCol() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return true;
                    }
                    else
                    {
                        int col = position.getCol();
                        for (int i = 1; i <= col; i++)
                        {
                            position.setCol(position.getCol() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return false;
                    }
                    case RIGHT : if (position.getCol() + steps < map.getColumns()) {
                        for (int i = 1; i <= steps; i++)
                        {
                            position.setCol(position.getCol() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return true;
                    }
                    else
                    {
                        int col = position.getCol();
                        for (int i = 1; i < map.getColumns() - col; i++)
                        {
                            position.setCol(position.getCol() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                        return false;
                    }
                }
            }
            else
            {
                switch (direction) {
                    case UP : if (position.getRow() - (maxStepAllowed - this.steps) >= 0) {
                        for (int i = 1; i <= maxStepAllowed - step; i++)
                        {
                            position.setRow(position.getRow() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                    }
                    else
                    {
                        int row = position.getRow();
                        if (row < maxStepAllowed - this.steps) {
                            for (int i = 1; i <= row; i++) {
                                position.setRow(position.getRow() - 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive() && this.steps < step + steps)
                                    return false;
                            }
                        }
                        else
                        {
                            for (int i = 1; i <= maxStepAllowed - step; i++)
                            {
                                position.setRow(position.getRow() - 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive()&&this.steps < step + steps)
                                    return false;
                            }
                        }
                    }
                        break;
                    case DOWN :
                        if (position.getRow() + maxStepAllowed - this.steps < map.getRows()) {
                            for (int i = 1; i <= maxStepAllowed - step; i++)
                            {
                                position.setRow(position.getRow() + 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive()&&this.steps < step + steps)
                                    return false;
                            }
                        }
                        else
                        {
                            int row = position.getRow();
                            if (map.getRows() - row < maxStepAllowed - this.steps) {
                                for (int i = 1; i < map.getRows() - row; i++) {
                                    position.setRow(position.getRow() + 1);
                                    score += map.hasTreasure(position);
                                    map.update(position);
                                    this.steps++;
                                    if (!map.isActive() && this.steps < step + steps)
                                        return false;
                                }
                            }
                            else
                            {
                                for (int i = 1; i <= maxStepAllowed - step; i++)
                                {
                                    position.setRow(position.getRow() + 1);
                                    score += map.hasTreasure(position);
                                    map.update(position);
                                    this.steps++;
                                    if (!map.isActive()&&this.steps < step + steps)
                                        return false;
                                }
                            }
                        }
                        break;
                    case LEFT :if (position.getCol() - (maxStepAllowed - this.steps) >= 0) {
                        for (int i = 1; i <= maxStepAllowed - step; i++)
                        {
                            position.setCol(position.getCol() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                    }
                    else
                    {
                        int col = position.getCol();
                        if (col < maxStepAllowed - this.steps) {
                            for (int i = 1; i <= col; i++) {
                                position.setCol(position.getCol() - 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive() && this.steps < step + steps)
                                    return false;
                            }
                        }
                        else {
                            for (int i = 1; i <= maxStepAllowed - step; i++)
                            {
                                position.setCol(position.getCol() - 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive()&&this.steps < step + steps)
                                    return false;
                            }
                        }
                    }
                        break;
                    case RIGHT :if (position.getCol() + maxStepAllowed - this.steps < map.getColumns()) {
                        for (int i = 1; i <= maxStepAllowed - step; i++)
                        {
                            position.setCol(position.getCol() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                            this.steps++;
                            if (!map.isActive()&&this.steps < step + steps)
                                return false;
                        }
                    }
                    else
                    {
                        int col = position.getCol();
                        if (map.getColumns() < maxStepAllowed - this.steps) {
                            for (int i = 1; i < map.getColumns() - col; i++) {
                                position.setCol(position.getCol() + 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive() && this.steps < step + steps)
                                    return false;
                            }
                        }
                        else
                        {
                            for (int i = 1; i <= maxStepAllowed - step; i++)
                            {
                                position.setCol(position.getCol() + 1);
                                score += map.hasTreasure(position);
                                map.update(position);
                                this.steps++;
                                if (!map.isActive()&&this.steps < step + steps)
                                    return false;
                            }
                        }
                    }
                        break;
                }
            }
            return false;
        }
        public boolean equals(Object player)
        {
            Player p = (Player) player;
            if (this.id == p.id)
                return true;
            return false;
        }
    }