package com.ldinkaofficial;

import java.util.*;

public class Labyrinth {

    private final int mazeSizeX;
    private final int mazeSizeY;
    private final int numberOfExits;


    private Random random = new Random();

    public Labyrinth(int mazeSizeX, int mazeSizeY, int numberOfExits) {
        this.mazeSizeX = mazeSizeX;
        this.mazeSizeY = mazeSizeY;
        this.numberOfExits = numberOfExits;
        fillMaze();
        generateMaze();
    }

    public HashMap<Pair,Cell> cellMap = new HashMap<>();
    ArrayList<Pair> pairList = new ArrayList<>();
    ArrayList<Pair> exitPairs = new ArrayList<>();
    private void fillMaze(){
        for (int i = 0; i < mazeSizeY; i++) {
            for (int j = 0; j < mazeSizeX; j++) {
                cellMap.put(new Pair(i,j), new Cell());
                if(i == 0 || i == mazeSizeY - 1 || j == 0 || j == mazeSizeX - 1)
                    exitPairs.add(new Pair(i,j));
            }
        }
    }
    private void generateMaze(){
        Pair currentPair;
        Pair oppositePair = new Pair(0,0);

        Cell currentCell;
        Cell oppositeCell;

        int randomNumberOfPair;

        pairList.add(new Pair(random.nextInt(0,mazeSizeY),
                    random.nextInt(0,mazeSizeX)));


        while(!pairList.isEmpty()){

            randomNumberOfPair  = random.nextInt(0,pairList.size());

            currentPair = pairList.get(randomNumberOfPair);
            currentCell  = cellMap.get(currentPair);

            oppositePair.setLocation(currentPair.getI(), currentPair.getJ() + 1);
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasRightWall() && currentPair.getJ() + 1 < mazeSizeX
                    && !oppositeCell.isInMaze()){
                currentCell.breakRightWall();
                cellMap.get(oppositePair).breakLeftWall();
                oppositeCell.setInMaze();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
            }

            oppositePair.setLocation(currentPair.getI(), currentPair.getJ() - 1);
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasLeftWall() && currentPair.getJ() - 1 >= 0
                    && !oppositeCell.isInMaze()){
                currentCell.breakLeftWall();
                cellMap.get(oppositePair).breakRightWall();
                oppositeCell.setInMaze();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
            }

            oppositePair.setLocation(currentPair.getI() + 1, currentPair.getJ());
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasDownWall() && currentPair.getI() + 1 < mazeSizeY
                    && !oppositeCell.isInMaze()){
                currentCell.breakDownWall();
                cellMap.get(oppositePair).breakUpWall();
                oppositeCell.setInMaze();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
            }

            oppositePair.setLocation(currentPair.getI() - 1, currentPair.getJ());
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasUpWall() && currentPair.getI() - 1 >= 0
                    && !oppositeCell.isInMaze()){
                currentCell.breakUpWall();
                cellMap.get(oppositePair).breakDownWall();
                oppositeCell.setInMaze();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
            }
            pairList.remove(currentPair);
        }

        //add exits
        for(int i = 0; i < numberOfExits; i++){
            currentPair = exitPairs.get(random.nextInt(0, exitPairs.size()));
            currentCell = cellMap.get(currentPair);
            if(currentPair.getI() == 0)
                currentCell.breakUpWall();
            else if(currentPair.getI() == mazeSizeY - 1)
                currentCell.breakDownWall();
            else if(currentPair.getJ() == 0)
                currentCell.breakLeftWall();
            else if(currentPair.getJ() == mazeSizeX - 1)
                currentCell.breakRightWall();
        }
    }
}
class Pair{
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setLocation(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return i == pair.i && j == pair.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
