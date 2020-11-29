import java.util.Random;

public class Model
{
    private int gridSize;
    private boolean isFilled[][];
    public String winner;
    public String whoseTurn;

    public Model(int _gridSize, String _playersTurn)
    {
        this.whoseTurn = _playersTurn;
        this.winner = "";
        this.gridSize = _gridSize;
        isFilled = new boolean[_gridSize][_gridSize];

        for (int i = 0; i < _gridSize; ++i)
        {
            for (int j = 0; j < _gridSize; ++j)
            {
                isFilled[i][j] = false;
            }
        }
    }

    public String getPlayersTurn()
    {
        return this.whoseTurn;
    }

    public void setPlayer(String _player)
    {
        this.whoseTurn = _player;
    }

    public boolean isGameTableFull()
    {
        for (int i = 0; i < gridSize; ++i)
        {
            for (int j = 0; j < gridSize; ++j)
            {
                if (!isFilled[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean isTableFull()
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                if (!isFilled[i][j])
                    return false;
            }
        }
        winner = "There is no winner";

        return true;
    }

    public boolean isGameOver()
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                //same row
                if (MainWindow.grid[i][j].getText() == "X" && j + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 4].getText())
                {
                    winner = "Player 1 is the winner";
                    return true;
                }
                if (MainWindow.grid[i][j].getText() == "O" && j + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 4].getText())
                {
                    winner = "Player 2 is the winner";
                    return true;
                }

                //same column
                if (MainWindow.grid[i][j].getText() == "X" && i + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j].getText())
                {
                    winner = "Player 1 is the winner";
                    return true;
                }

                if (MainWindow.grid[i][j].getText() == "O" && i + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j].getText())
                {
                    winner = "Player 2 is the winner";
                    return true;
                }

                //diagonal to right
                if (MainWindow.grid[i][j].getText() == "X" && i + 4 < gridSize && j + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j + 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j + 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j + 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j + 4].getText())
                {
                    winner = "Player 1 is the winner";
                    return true;
                }

                if (MainWindow.grid[i][j].getText() == "O" && i + 4 < gridSize && j + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j + 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j + 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j + 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j + 4].getText())
                {
                    winner = "Player 2 is the winner";
                    return true;
                }

                //diagonal to left
                if (MainWindow.grid[i][j].getText() == "X" && j - 4 > -1 && j - 4 >= 0 && i + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j - 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j - 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j - 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j - 4].getText())
                {
                    winner = "Player 1 is the winner";
                    return true;
                }

                if (MainWindow.grid[i][j].getText() == "O" && j - 4 >= 0 && i + 4 < gridSize &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j - 1].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j - 2].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j - 3].getText() &&
                        MainWindow.grid[i][j].getText() == MainWindow.grid[i + 4][j - 4].getText())
                {
                    winner = "Player 2 is the winner";
                    return true;
                }
            }
        }
        return false;
    }

    public void canMark(int i, int j)
    {
        if (!isFilled[i][j])
        {
            MainWindow.updateTextOfButton(i, j, whoseTurn);
            isFilled[i][j] = true;
        }
    }

    public void switchTurns(/*boolean isPlayer1*/)
    {
        if (whoseTurn == "O")
            this.whoseTurn = "X";
        else
            this.whoseTurn = "O";
    }

    public void removeRandom(String whoseTurn, int i, int j)
    {
        Random rand = new Random();
        int randomI = rand.nextInt(gridSize - 1);
        int randomJ = rand.nextInt(gridSize - 1);

        while (MainWindow.grid[randomI][randomJ].getText() != whoseTurn)
        {
            randomI = rand.nextInt(gridSize - 1);
            randomJ = rand.nextInt(gridSize - 1);
        }
        MainWindow.updateTextOfButton(randomI, randomJ, "");
        isFilled[randomI][randomJ] = false;
    }

    private void checkRows(int buttonNumbers, String whoseTurn)
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                if (buttonNumbers == 4)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && j + 3 < gridSize &&                        //4 adjacent
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 2].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 3].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                        removeRandom(whoseTurn, i, j);
                    }
                }
                if (buttonNumbers == 3)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && j + 2 < gridSize &&       //3 adjacent
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i][j + 2].getText())
                    {
                        removeRandom(whoseTurn, i, j);

                    }
                }
            }
        }
    }

    private void checkColumns(int buttonNumbers, String whoseTurn)
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                if (buttonNumbers == 4)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && i + 3 < gridSize &&       //4 adjacent
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                        removeRandom(whoseTurn, i, j);
                    }
                }
                if (buttonNumbers == 3)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && i + 2 < gridSize &&       //4 adjacent
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                    }
                }
            }
        }
    }

    private void checkDiagonalToRight(int buttonNumbers, String whoseTurn)
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                if (buttonNumbers == 4)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && i + 3 < gridSize && j + 3 < gridSize &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j + 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j + 2].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j + 3].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                        removeRandom(whoseTurn, i, j);
                    }
                }
                if (buttonNumbers == 3)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && i + 2 < gridSize && j + 2 < gridSize &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j + 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j + 2].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                    }
                }
            }
        }
    }

    private void checkDiagonalToLeft(int buttonNumbers, String whoseTurn)
    {
        for (int i = 0; i < gridSize; ++i)  //row
        {
            for (int j = 0; j < gridSize; ++j)  //column
            {
                if (buttonNumbers == 4)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && j - 3 >= 0 && i + 3 < gridSize &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j - 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j - 2].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 3][j - 3].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                        removeRandom(whoseTurn, i, j);
                    }
                }
                if (buttonNumbers == 3)
                {
                    if (MainWindow.grid[i][j].getText() == whoseTurn && j - 2 >= 0 && i + 2 < gridSize &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 1][j - 1].getText() &&
                            MainWindow.grid[i][j].getText() == MainWindow.grid[i + 2][j - 2].getText())
                    {
                        removeRandom(whoseTurn, i, j);
                    }
                }
            }
        }
    }

    public void toRemoveRandomly()
    {
        checkRows(4, whoseTurn);
        checkColumns(4, whoseTurn);
        checkDiagonalToRight(4, whoseTurn);
        checkDiagonalToLeft(4, whoseTurn);
        checkRows(3, whoseTurn);
        checkColumns(3, whoseTurn);
        checkDiagonalToRight(3, whoseTurn);
        checkDiagonalToLeft(3, whoseTurn);
    }

    public void resetGrid()
    {
        for (int i = 0; i < gridSize; ++i)
        {
            for (int j = 0; j < gridSize; ++j)
            {
                MainWindow.updateTextOfButton(i, j, "");

                isFilled[i][j] = false;
            }
        }
    }
}