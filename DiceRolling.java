package coursera;

import java.util.Random;

/**
 * Created by Роман Лотоцький on 13.12.2016.
 */
public class DiceRolling {

    public void simpleSimulate(int rolls){
        Random rand = new Random();
        int twos = 0;
        int twelves = 0;
        for (int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            if(d1 + d2 == 2){
                twos += 1;
            } else if(d1 + d2 == 12){
                twelves += 1;
            }
        }
        System.out.println("2's=\t" + twos + "\t" + 100*twos/rolls);
        System.out.println("12's=\t" + twelves + "\t" + 100*twelves/rolls);
    }

    public void simulate(int rolls){
        Random rand = new Random();
        int[] counts = new int[13];

        for (int i = 0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            //System.out.println(d1 + " " + d2);
            counts[d1 + d2] += 1;
        }
        for (int k = 2; k < counts.length; k++) {
            System.out.println(k + "'s=" + "\t" + counts[k] + "\t" +
                    100*counts[k]/rolls);
        }
    }

    public static void main(String[] args) {
        DiceRolling dice = new DiceRolling();
        //dice.simpleSimulate(10);
        dice.simulate(1000);
    }
}
