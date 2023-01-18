package CSE1322.assignment1;

import java.util.ArrayList;

class Poker {
    PlayingCards deck;
    ArrayList<String> hand1 = new ArrayList<String>();
    ArrayList<String> hand2 = new ArrayList<String>();

    public Poker() {
        deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }
    public Poker(ArrayList<String> Hand1, ArrayList<String> Hand2) {
        deck = new PlayingCards();
        hand1 = Hand1;
        hand2 = Hand2;
    }
    public void dealHands() {
        int handNum = 1; //used to swap between hands
        boolean h1 = false; //tracks length of hands
        boolean h2 = false;
        for(int i = 0; i < 10; i++) {
            if(h1 && h2) {
                break;
            }
            else if(handNum == 1) {
                hand1.add(deck.getNextCard());
                if(hand1.size() > 4) {
                    h1 = true;
                }
                handNum += 1;
            }
            else if(handNum ==2) {
                hand2.add(deck.getNextCard());
                if(hand2.size() > 4) {
                    h2 = true;
                }
                handNum -= 1;
            }
        }
    }
    public void showHand(int hand){
        if(hand == 1) {
            System.out.println("Player 1's hand:");
            for(String cards : hand1) {
                System.out.print(cards);
            }
            System.out.println();
        }
        else if (hand == 2) {
            System.out.println("Player 2's hand: ");
            for(String cards : hand2) {
                System.out.print(cards);
            }
            System.out.println();
        }
    }
}
