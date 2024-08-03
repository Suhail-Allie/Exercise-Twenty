package org.example;

import java.util.Random;

public class Main {
    private static final int NUM_SUITS = 4;
    private static final int CARDS_PER_SUIT = 13;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] suitCounts = new int[NUM_SUITS];
        int totalPicks = 0;
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] pickedCards = new String[NUM_SUITS * CARDS_PER_SUIT];

        while (!allSuitsCollected(suitCounts)) {
            int card = rand.nextInt(NUM_SUITS * CARDS_PER_SUIT);
            int suit = card / CARDS_PER_SUIT;
            suitCounts[suit]++;
            pickedCards[totalPicks++] = suits[suit] + " " + (card % CARDS_PER_SUIT + 1);
        }

        System.out.println("Number of picks needed: " + totalPicks);
        System.out.println("Cards picked:");
        for (int i = 0; i < totalPicks; i++) {
            System.out.println(pickedCards[i]);
        }
    }

    private static boolean allSuitsCollected(int[] suitCounts) {
        for (int count : suitCounts) {
            if (count < 4) return false;
        }
        return true;
    }
}