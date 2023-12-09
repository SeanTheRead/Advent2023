package objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class CubeConundrum {
    private final String idSeparator;
    private final String subsetSeparator;
    private final String cubeSeparator;
    private List<CubeGame> cubeGames;
    public CubeConundrum(String idSeparator, String subsetSeparator, String cubeSeparator){
        this.idSeparator=idSeparator;
        this.subsetSeparator=subsetSeparator;
        this.cubeSeparator=cubeSeparator;
    }

    public void loadGamesList(String file){
        try {
            List<String> gameLines = Files.readAllLines(Paths.get(file));
            this.cubeGames = new ArrayList<CubeGame>();
            //create CubeGame objects and add them to a list
            for(String line:gameLines){
                CubeGame game = new CubeGame();
                //split game number and cubes
                String[] gameDetails = line.split(idSeparator);
                String[] gameNumber = gameDetails[0].split(" ");
                String [] cubeSubsets = gameDetails[1].split(subsetSeparator);

                game.setGameNumber(Integer.parseInt(gameNumber[1]));
                buildCubeSet(game, cubeSubsets);
                //System.out.println(game.toString());
                this.cubeGames.add(game);

            }
            System.out.println("Total Games Found: "+this.cubeGames.size()+System.lineSeparator());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void buildCubeSet(CubeGame game, String[] cubeArray){
        List<CubeSet> cubeSets = new ArrayList<>();
        for(String subset:cubeArray){
            String[] cubes = subset.split(cubeSeparator);
            CubeSet set = new CubeSet();
            for(String cube:cubes){

                if(cube.toLowerCase().endsWith("blue")){
                    set.addBlueCubes(Integer.parseInt(cube.replace(" blue","").trim()));
                } else if (cube.toLowerCase().endsWith("red")) {
                    set.addRedCubes(Integer.parseInt(cube.replace(" red","").trim()));
                } else if (cube.toLowerCase().endsWith("green")) {
                    set.addGreenCubes(Integer.parseInt(cube.replace(" green","").trim()));
                }
            }
            game.addCubeSet(set);
        }

    }
    public Map<String,List<CubeGame>> getValidGames(int blueCubes,int redCubes, int greenCubes){
        List<CubeGame> validGames = new ArrayList<CubeGame>();
        List<CubeGame> invalidGames = new ArrayList<CubeGame>();
        //add game to validGames if it has more/same cubes as input cube count
        for(CubeGame game:this.cubeGames){
            boolean gameIsValid = true;
            int setCount = 0;
            while(setCount<game.getCubeSets().size()&&gameIsValid){
                if(game.getCubeSets().get(setCount).getBlueCubeCount()>blueCubes
                        ||game.getCubeSets().get(setCount).getGreenCubeCount()>greenCubes
                        ||game.getCubeSets().get(setCount).getRedCubeCount()>redCubes){

                    gameIsValid = false;
                }
                setCount++;
            }
            if(gameIsValid){
                validGames.add(game);
            }else{
                invalidGames.add(game);
            }

        }
        return Map.ofEntries(entry("valid",validGames),entry("invalid",invalidGames));
    }

    public int getSumValidGames(int blueCubes,int redCubes,int greenCubes){
        //get sum of valid games
        int sum = 0;
        Map<String,List<CubeGame>> gameMap = this.getValidGames(blueCubes,redCubes,greenCubes);
        for(CubeGame game: gameMap.get("valid")){
            sum+=game.getGameNumber();
        }
        return sum;
    }

    public double getSumMinimumPower(){
        double sum = 0.0;
        for(CubeGame game:this.cubeGames){
            sum+=game.getMinumumSet().getPower();
        }
        return sum;
    }

}
