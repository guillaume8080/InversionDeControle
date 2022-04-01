package com.adaptionsoft.games.uglytrivia;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMaster {

    Map<String, String> Records = new HashMap<String , String>();
    int  nombrePartie = 100;
    private static boolean notAWinner;

    @Test
    public  void runTest1(){
        Game aGame = new Game();

        assertEquals(1,1);

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Records.put("nombre Players", Integer.toString(aGame.howManyPlayers()) );
        Records.put("est jouable" , new Boolean(aGame.isPlayable()).toString());

        Random rand = new Random();






        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }



        } while (notAWinner);

    }


}
