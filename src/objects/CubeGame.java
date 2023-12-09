package objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CubeGame {
    private int gameNumber;
    private List<CubeSet> cubeSets;
    private CubeSet minumumSet;

    public CubeGame(){
        cubeSets= new ArrayList<CubeSet>();
    }

    //setters

    /**
     *
     * @param gameNumber
     */
    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
    public void setCubeSets(List<CubeSet>cubeSets){
        this.cubeSets=cubeSets;
    }



    //getters

    /**
     *
     * @return int game number
     */
    public int getGameNumber() {
        return gameNumber;
    }

    public void addCubeSet(CubeSet set){
        this.cubeSets.add(set);
        if(this.minumumSet == null){
            this.minumumSet=set;
        }else {
            if(this.minumumSet.getBlueCubeCount()<set.getBlueCubeCount()){
                this.minumumSet.setBlueCubes(set.getBlueCubeCount());
            }
            if(this.minumumSet.getRedCubeCount()<set.getRedCubeCount()){
                this.minumumSet.setRedCubes(set.getRedCubeCount());
            }
            if(this.minumumSet.getGreenCubeCount()<set.getGreenCubeCount()){
                this.minumumSet.setGreenCubes(set.getGreenCubeCount());
            }
        }
    }

    public CubeSet getMinumumSet(){
        return this.minumumSet;
    }

    public List<CubeSet> getCubeSets() {
        return cubeSets;
    }



    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append("GameId: ").append(this.gameNumber).append(System.lineSeparator());
        for(CubeSet set:this.cubeSets){
            returnString.append("Blue Cubes: ").append(set.getBlueCubeCount()).append(", ");
            returnString.append("Red Cubes: ").append(set.getRedCubeCount()).append(", ");
            returnString.append("Green Cubes: ").append(set.getGreenCubeCount()).append(System.lineSeparator());
        }


        return returnString.toString();
    }

}
