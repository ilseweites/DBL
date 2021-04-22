/**
 * CircleDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author huub
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

class CardDingus extends Dingus {
    protected boolean filled; //true: filled, false: outline
    protected Color c; //color of filled inner border card
    Random r = new Random(); //random which will be used for picking random card value

    public CardDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        c = new Color(255, 0, 0, 50); //set color and transparacy of inner border card
    }

    @Override
    void draw(Graphics g) {
        char[] cardDeck = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'B', 'Q', 'K', 'J'}; //all possible card values
        int randomCard =  new Random().nextInt(cardDeck.length); //random int to pick random card value
        char cardValue = cardDeck[randomCard]; //picks random card value on index of the random int
        Font font = new Font("Serif", Font.BOLD, 55); //sets font to serif, bold and size 55
        
        g.setColor(color.BLACK); //makes outer border black
        g.drawRect(0, 0, 450, 800); //draws outer border (rectangle) from x,y: 0,0 up to x,y: 450,800

        g.setColor(color.BLACK); //makes inner border black
        g.drawRect(50, 50, 350, 700); //draws inner border (rectangle) from x,y: 50,50 up to x,y: 350,700

        g.setColor(c); //sets color which inner rectangle will be filled with
        g.fillRect(50, 50, 350, 700); //fills inner border (rectangle) with color c from x,y: 50,50 up to x,y: 350,700

        g.setColor(color.BLACK); //sets color of text to black
        g.setFont(font); //sets font of text to specified above
        g.drawString(String.valueOf(cardValue), 410, 50); //draws string value of randomized card at index 410, 50
        g.drawString(String.valueOf(cardValue), 10, 800); //draws string value of randomized card at index 10, 800
    }
}
