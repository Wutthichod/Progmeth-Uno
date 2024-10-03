package application;

import logic.card.*;
import Enum.CardColor;
import logic.game.Player;

import java.util.Scanner;

import static Enum.CardColor.*;
import static Enum.CardColor.YELLOW;

public class GameIO {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CardColor[] colors = {RED, BLUE, GREEN, YELLOW};

    public static void printHand(Player currentPlayer) {
        System.out.println("========================================");
        System.out.println(currentPlayer.getName() + "'s hand: ");
        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            BaseCard card = currentPlayer.getHand().get(i);
            System.out.println(i + 1 + ": " + card);
        }
        System.out.println("========================================");
    }

    public static void printCard(BaseCard card) {
        System.out.println("========================================");
        System.out.println("Played " + card);
    }

    public static void printInvalidCardMessage() {
        System.out.println("========================================");
        System.out.println("Cannot play this card, choose again");
        System.out.println("========================================");
    }

    public static void printTurnStartInfo(Player currentPlayer, BaseCard topDiscard) {
        System.out.println("========================================");
        System.out.println(currentPlayer.getName() + "'s turn");
        System.out.println("Top card is " + topDiscard.toString());
    }

    public static void printDrawResult(Player currentPlayer, BaseCard drawnCard) {
        System.out.println("========================================");
        System.out.println(currentPlayer.getName() + " drew " + drawnCard.toString());

    }

    public static void printTopCard(BaseCard topCard){
        System.out.println("Top card is " + topCard.toString());
    }

    public static CardColor chooseColor(BaseWildCard card) {
        System.out.println("========================================");
        System.out.println("Choose Next Color");
        for (int i = 0; i < colors.length; i++) {
            System.out.println(i + 1 + ": " + colors[i]);
        }
        while (true) {
            try {
                int colorIndex = scanner.nextInt();
                if(colorIndex <= colors.length && colorIndex > 0) {
                    System.out.println("========================================");
                    return colors[colorIndex - 1];
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!!");
                scanner.nextLine();
            }
        }

    }

}
