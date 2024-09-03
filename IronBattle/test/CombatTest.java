package IronBattle.test;

import IronBattle.src.main.Character;
import IronBattle.src.main.Combat;
import IronBattle.src.main.Warrior;
import IronBattle.src.main.Wizard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CombatTest {
    private Warrior warrior;
    private Wizard wizard;

    @Before
    public void setUp() {
        warrior = new Warrior("Warrior1");
        wizard = new Wizard("Wizard1");
    }

    @Test
    public void testCombatVictory() {
        // Arrange
        warrior.setHp(10);  // Set low health for testing
        wizard.setHp(100);  // Set high health for testing

        // Act
        Combat combat = new Combat(warrior, wizard);
        combat.startBattle();  // Execute the combat simulation

        // Assert
        // Check that the Wizard is still alive and the Warrior is defeated
        assertTrue(wizard.getIsAlive());
        assertFalse(warrior.getIsAlive());
    }

    @Test
    public void testEscape() {
        // Arrange
        warrior.setHp(100);
        wizard.setHp(100);

        // Simulate user input for escaping
        String simulatedInput = "n\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Act
        Combat combat = new Combat(warrior, wizard);
        combat.startBattle();

        // Assert
        // Check that the Wizard should be the winner, since Warrior escaped
        assertTrue(wizard.getIsAlive());
        //assertFalse(warrior.getIsAlive());
        //Mejorar este test, para que reconozca que ha terminado el combate y estan los dos vivos
    }
}