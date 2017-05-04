package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by Administrator on 01.05.2017.
 */
public class Model
{
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private boolean isSaveNeeded = true;
    Stack<Tile[][]> previousStates = new Stack ( );
    Stack<Integer>  previousScores = new Stack ( );
    int             score          = 0;
    int             maxTile        = 0;


    public Model()
        {
        resetGameTiles ( );
        }

    public void resetGameTiles()
        {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile ( );
        addTile ( );
        addTile ( );
        score = 0;
        maxTile = 2;
        }

    private List<Tile> getEmptyTiles()
        {
        List<Tile> list = new ArrayList<> ( );
        for (int i = 0; i < FIELD_WIDTH; i++)
            {
                for (int j = 0; j < FIELD_WIDTH; j++)
                    {
                        if (gameTiles[i][j].isEmpty ( ))
                            {
                                list.add (gameTiles[i][j]);
                            }
                    }
            }
        return list;
        }

    private void addTile()
        {
        List<Tile> list = getEmptyTiles ( );
        if (list == null)
            return;
        if (list.size ( ) != 0)
            {
                list.get ((int) (list.size ( ) * Math.random ( ))).value = Math.random ( ) < 0.9 ? 2 : 4;
            }
        }

    private boolean compressTiles(Tile[] tiles)
        {
        boolean change = false;
        for (int k = 0; k < tiles.length - 1; k++)
            {
                for (int i = 0; i < tiles.length - 1; i++)
                    {
                        if (tiles[i].isEmpty ( ) && !tiles[i + 1].isEmpty ( ))
                            {
                                change = true;
                                tiles[i] = tiles[i + 1];
                                tiles[i + 1] = new Tile ( );
                            }
                    }
            }
        return change;
        }

    private boolean mergeTiles(Tile[] tiles)
        {
        boolean change = false;
        for (int i = 0; i < tiles.length - 1; i++)
            {
                if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty ( ) && !tiles[i + 1].isEmpty ( ))
                    {
                        change = true;
                        tiles[i].value *= 2;
                        tiles[i + 1] = new Tile ( );
                        maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                        score += tiles[i].value;
                        compressTiles (tiles);
                    }
            }
        return change;
        }

    public void left()
        {
        if (isSaveNeeded)
            saveState (gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++)
            {
                if (compressTiles (gameTiles[i]) || mergeTiles (gameTiles[i]))
                    {
                        isChanged = true;
                    }
            }
        if (isChanged)
            addTile ( );
        }

    private void rotateToRight()
        {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++)
            {
                for (int j = i; j < FIELD_WIDTH - 1 - i; j++)
                    {
                        tmp = gameTiles[i][j];
                        gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                        gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                        gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                        gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
                    }
            }
        }

    void right()
        {
        saveState (gameTiles);
        rotateToRight ( );
        rotateToRight ( );
        left ( );
        rotateToRight ( );
        rotateToRight ( );
        }

    void up()
        {
        saveState (gameTiles);
        rotateToRight ( );
        rotateToRight ( );
        rotateToRight ( );
        left ( );
        rotateToRight ( );
        }

    void down()
        {
        saveState (gameTiles);
        rotateToRight ( );
        left ( );
        rotateToRight ( );
        rotateToRight ( );
        rotateToRight ( );
        }


    boolean canMove()
        {
        if (!getEmptyTiles ( ).isEmpty ( ))
            return true;
        for (int i = 0; i < gameTiles.length; i++)
            {
                for (int j = 1; j < gameTiles.length; j++)
                    {
                        if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                            return true;
                    }
            }
        for (int i = 0; i < gameTiles.length; i++)
            {
                for (int j = 1; j < gameTiles.length; j++)
                    {
                        if (gameTiles[j][i].value == gameTiles[j - 1][i].value)
                            return true;
                    }
            }
        return false;
        }


    public Tile[][] getGameTiles()
        {
        return gameTiles;
        }

    private void saveState(Tile[][] tiles)
        {
        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int y = 0; y < tiles.length; y++)
            {
                for (int x = 0; x < tiles[y].length; x++)
                    {
                        newTiles[y][x] = new Tile (tiles[y][x].value);
                    }
            }
        previousStates.push (newTiles);
        previousScores.push (score);
        isSaveNeeded = false;
        }

    public void rollback()
        {
        if (!previousStates.empty ( ) && !previousScores.empty ( ))
            {
                gameTiles = previousStates.pop ( );
                score = previousScores.pop ( );
            }
        }

    public void randomMove()
        {
        int n = ((int) (Math.random ( ) * 100)) % 4;

        switch (n)
            {
            case 0:
                left ( );
                break;
            case 1:
                down ( );
                break;
            case 2:
                right ( );
                break;
            case 3:
                up ( );
                break;
            }

        }

    public boolean hasBoardChanged()
        {
        return countTotalWeigh (gameTiles) - countTotalWeigh (previousStates.peek ( )) != 0;
        }

    private int countTotalWeigh(Tile[][] tiles)
        {
        int total = 0;
        for (Tile[] row : tiles)
            {
                for (Tile tile : row)
                    {
                        total += tile.value;
                    }
            }
        return total;
        }

    public MoveEfficiency getMoveEfficiency(Move move)
        {
        move.move ( );
        int emptyTiles = -1;
        int sc         = 0;
        if (hasBoardChanged ( ))
            {
                emptyTiles = getEmptyTiles ( ).size ( );
                sc = score;
            }
        rollback ( );
        return new MoveEfficiency (emptyTiles, sc, move);
        }
    public void autoMove() {
    PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
    priorityQueue.offer(getMoveEfficiency(this::left));
    priorityQueue.offer(getMoveEfficiency(this::down));
    priorityQueue.offer(getMoveEfficiency(this::right));
    priorityQueue.offer(getMoveEfficiency(this::up));
    priorityQueue.poll().getMove().move();
    }
}
