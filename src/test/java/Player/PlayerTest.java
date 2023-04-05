package Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void loose_when_dice_number_is_low() {
        Dice dice = new Dice(6);
        Player player = new Player(dice, 2);
        assertEquals(false, player.play());
    }
}