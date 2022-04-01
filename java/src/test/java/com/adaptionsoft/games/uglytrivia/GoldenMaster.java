package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMaster {

    Map<String, String> Records = new HashMap<String , String>();
    int  nombrePartie = 100;
    private static boolean notAWinner;

    @Test
    public  void runTest1(){
        Game aGame = new Game();



        assertEquals(1,1);

        int randomRoll;

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Records.put("nombre Players", Integer.toString(aGame.howManyPlayers()) );
        Records.put("est jouable" , new Boolean(aGame.isPlayable()).toString());

        Random rand = new Random();

        do {

              aGame.roll(randomRoll = rand.nextInt(5) + 1);
            if (randomRoll % 2 != 0){
                Records.put("isGettingOutOfPenaltyBox must be true" , new Boolean(aGame.isGettingOutOfPenaltyBox).toString());
            }
            if (randomRoll % 2 == 0){
                Records.put("isGettingOutOfPenaltyBox must be false" , new Boolean(aGame.isGettingOutOfPenaltyBox).toString());
            }


            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }



        } while (notAWinner);

        EcrireResultatTest(Records);

    }

    private void EcrireResultatTest(Map Records) {
        BufferedWriter bf = null;
        final String FILE_NAME = "/home/guillaume/Bureau/Dev/DevLogiciel/tpGolden/trivia/java/src/test/java/com/adaptionsoft/games/uglytrivia/resultatGoldenMatserTrue.txt";
        File targetFile = new File(FILE_NAME);

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(targetFile));

            // iterate map entries

            Set collection = Records.entrySet();
            Set lesKeys = Records.keySet();
            Collection lesvalues = Records.values();

            List<String> ListOfKeys = new ArrayList<String>(lesKeys);
            List<String> ListOfValues = new ArrayList<String>(lesvalues);

            for(int i = 0 ; i < collection.size(); i++){
                bf.write(ListOfKeys.get(i) + ": "  + ListOfValues.get(i));

                bf.newLine();
            }



            bf.flush();
        }
        catch (IOException e) {
            System.out.println(e);
        } finally {

            try {

                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }

    }


}
