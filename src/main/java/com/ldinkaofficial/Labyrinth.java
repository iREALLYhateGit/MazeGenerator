package com.ldinkaofficial;

import java.util.*;

public class Labyrinth {

    private final int mazeSize;


    private Random random = new Random();

    public Labyrinth(int mazeSize) {
        this.mazeSize = mazeSize;
        fillMaze();
        generateMaze();
    }

    public HashMap<Pair,Cell> cellMap = new HashMap<>();
    ArrayList<Pair> pairList = new ArrayList<>();
    private void fillMaze(){
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                cellMap.put(new Pair(i,j), new Cell());
            }
        }
    }
    private void generateMaze(){
        Pair currentPair;
        Pair oppositePair = new Pair(0,0);

        Cell currentCell;
        Cell oppositeCell;

        int randomNumberOfPair;

        pairList.add(new Pair(random.nextInt(0,mazeSize),
                    random.nextInt(0,mazeSize)));

        while(!pairList.isEmpty()){

            randomNumberOfPair  = random.nextInt(0,pairList.size());//= pairList.size() - 1;

            currentPair = pairList.get(randomNumberOfPair);
            currentCell  = cellMap.get(currentPair);


            oppositePair.setLocation(currentPair.getI(), currentPair.getJ() + 1);
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasRightWall() && currentPair.getJ() + 1 < mazeSize
                    && !oppositeCell.isRiched()){
                currentCell.setRightWall(false);
                cellMap.get(oppositePair).setLeftWall(false);
                oppositeCell.setRiched();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
                System.out.println("RIGHTwall  " + currentPair + "  |||||   " + oppositePair);
            }

            oppositePair.setLocation(currentPair.getI(), currentPair.getJ() - 1);
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasLeftWall() && currentPair.getJ() - 1 >= 0
                    && !oppositeCell.isRiched()){
                currentCell.setLeftWall(false);
                cellMap.get(oppositePair).setRightWall(false);
                oppositeCell.setRiched();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
                System.out.println("LEFTwall  " +  currentPair + "  |||||  " + oppositePair);
            }

            oppositePair.setLocation(currentPair.getI() + 1, currentPair.getJ());
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasDownWall() && currentPair.getI() + 1 < mazeSize
                    && !oppositeCell.isRiched()){
                currentCell.setDownWall(false);
                cellMap.get(oppositePair).setUpWall(false);
                oppositeCell.setRiched();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
                System.out.println("DOWNwall  " + currentPair + "  |||||  " + oppositePair);
            }

            oppositePair.setLocation(currentPair.getI() - 1, currentPair.getJ());
            oppositeCell  = cellMap.get(oppositePair);
            if(currentCell.hasUpWall() && currentPair.getI() - 1 >= 0
                    && !oppositeCell.isRiched()){
                currentCell.setUpWall(false);
                cellMap.get(oppositePair).setDownWall(false);
                oppositeCell.setRiched();
                pairList.add(new Pair(oppositePair.getI(), oppositePair.getJ()));
                System.out.println("UPwall  " + currentPair + "  |||||  " + oppositePair);
            }
            pairList.remove(currentPair);
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
