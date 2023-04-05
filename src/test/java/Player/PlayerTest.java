package Player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void loose_when_dice_number_is_low() {
        Dice dice = Mockito.mock(Dice.class); //Simulamos la clase dado.

        //El jugador gana con 3 pero el dado devuelve dos:
        Mockito.when(dice.roll()).thenReturn(2); //el dado devuelve dos.

        Player player = new Player(dice, 3); //el jugador pierde
        assertFalse(player.play());
    }

    @Test
    void wins_when_dice_number_is_big() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}