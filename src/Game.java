import java.util.*;
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the GAME!");
        int charAttack = 10;
        int charDefense = 10;
        int charHealth = 100;

        int enemyAttack = random.nextInt(8)+7;
        int enemyDefense = random.nextInt(8)+7;
        int enemyHealth = random.nextInt(5)+98;
        boolean player = true;

        System.out.println("\nYour attack: "+ charAttack+ "\nDefense: "+ charDefense+ "\nHealth: "+ charHealth);
        System.out.println("\nYou encounter enemy!");
        System.out.println("Enemy attack: " + enemyAttack+ "\nDefense: "+ enemyDefense+"\nHealth: "+ enemyHealth);

        while (charHealth>0 && enemyHealth>0){
            boolean firstMove = random.nextBoolean();
            if (firstMove==player ) {
                System.out.println("\nattack or defense");
                String choice1 = sc.nextLine();
                // we hit enemy
                if (choice1.equals("attack")){
                    int charCritical = random.nextInt(100);
                    if (charCritical>= 65) {
                        System.out.println("\nYou hit critical");
                        enemyHealth -= (charAttack * 2);
                        System.out.println("\nEnemy health: " + enemyHealth);
                    }
                    else {
                        enemyHealth -= charAttack;
                        System.out.println("\nEnemy health: "+ enemyHealth);
                    }
                }
                else if (choice1.equals("defense")){
                    int enemyCritical= random.nextInt(100);
                    int charDodge = random.nextInt(100);

                    if (charDodge>=55){
                        enemyHealth -= charAttack*2;
                        System.out.println("\nYou DODGED\nAnd ATTACKED\nEnemy Health: "+enemyHealth);
                    }
                    else {
                        if (enemyCritical>=65){
                            charHealth -= enemyAttack*2;
                            System.out.println("\nEnemy HIT CRITICAL\nYour Health: "+ charHealth);
                        }
                        else {
                            charHealth -= enemyAttack;
                            System.out.println("Enemy Attacked\n Your health: "+charHealth );
                        }
                    }
                }
            }
            else {
                int eChoice1 = random.nextInt(2);
                if (eChoice1==1) {
                    //enemy hit us
                    System.out.println("\nEnemy attacking");
                    int enemyCritical = random.nextInt(100);
                    if (enemyCritical>= 65){
                        System.out.println("\nEnemy hit critical");
                        charHealth -= (enemyAttack*2);
                    }
                    else {
                        charHealth -= enemyAttack;
                    }
                    System.out.println("Your health: " + charHealth);
                }
                else {
                    System.out.println("\nEnemy is defending");
                    int enemyDodge = random.nextInt(100);
                    System.out.println("\nYou have to ATTACK!");
                    int charCritical = random.nextInt(100);
                    if (enemyDodge>= 55) {
                        charHealth -= enemyAttack*2;
                        System.out.println("\nEnemy DODGED\nAnd hit CRITIC\nYour health: "+ charHealth);
                    }
                    else {
                        if (charCritical>= 65){
                            enemyHealth-= charAttack*2;
                            System.out.println("You hit CRITIC\n Enemy health: "+ enemyHealth);
                        }
                        else {
                            enemyHealth -= charAttack;
                            System.out.println("You HIT\nEnemy health: "+ enemyHealth);
                        }
                    }
                }
            }
        }
        if (charHealth<=0){
            System.out.println("\nYou lost");
        } else {
            System.out.println("\nYou win\nYour health: " + charHealth);
        }
        sc.close();
    }
}