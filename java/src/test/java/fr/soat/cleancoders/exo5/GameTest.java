package fr.soat.cleancoders.exo5;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GameTest {

    @Test
    public void testDefaultMove() {
        Game game = new Game("XOXOX-OXO");

        int result = game.move('X');

        Assertions.assertThat(result).isEqualTo(5);

        game = new Game("XOXOXOOX-");
        result = game.move('O');

        Assertions.assertThat(result).isEqualTo(8);

        game = new Game("---------");
        result = game.move('X');

        Assertions.assertThat(result).isEqualTo(0);

        game = new Game("XXXXXXXXX");
        result = game.move('X');

        Assertions.assertThat(result).isEqualTo(-1);
    }


    @Test
    public void testFindWinningMove() {
        Game game = new Game("XO-XX-OOX");

        int result = game.move('X');

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void testWinConditions() {
        Game game = new Game("---XXX---");

        char winner = game.winner();

        Assertions.assertThat(winner).isEqualTo('X');
    }
}