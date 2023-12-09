package objects;

public class CubeSet {
    private int blueCubeCount;
    private int redCubeCount;
    private int greenCubeCount;

    private int power;
    /**
     *
     * @param cubes
     */
    public void addBlueCubes(int cubes){
        this.blueCubeCount+=cubes;
        this.calculatePower();
    }
    public void setBlueCubes(int newValue){
        this.blueCubeCount=newValue;
        this.calculatePower();
    }

    /**
     *
     * @param cubes
     */
    public void addRedCubes(int cubes){
        this.redCubeCount+=cubes;
        this.calculatePower();
    }
    public void setRedCubes(int newValue){
        this.redCubeCount=newValue;
        this.calculatePower();
    }

    /**
     *
     * @param cubes
     */
    public void addGreenCubes(int cubes){
        this.greenCubeCount+=cubes;
        this.calculatePower();
    }
    public void setGreenCubes(int newValue){
        this.greenCubeCount=newValue;
        this.calculatePower();
    }

    /**
     *
     * @return int number of blue cubes
     */
    public int getBlueCubeCount() {
        return blueCubeCount;
    }

    /**
     *
     * @return int number of red cubes
     */
    public int getRedCubeCount() {
        return redCubeCount;
    }

    /**
     *
     * @return int number of green cubes
     */
    public int getGreenCubeCount() {
        return greenCubeCount;
    }

    private void calculatePower(){
        this.power=this.blueCubeCount*this.redCubeCount*this.greenCubeCount;
    }

    public int getPower(){
        return this.power;
    }
}
