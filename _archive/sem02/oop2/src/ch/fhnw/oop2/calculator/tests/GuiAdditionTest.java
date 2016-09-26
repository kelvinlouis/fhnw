package ch.fhnw.oop2.calculator.tests;

import ch.fhnw.oop2.calculator.ApplicationUI;
import javafx.scene.Parent;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

/**
 * Created by Kelvin on 19-Apr-16.
 */
public class GuiAdditionTest extends GuiTest {
    @Override
    protected Parent getRootNode() {
        return new ApplicationUI();
    }

    @Test
    public void testAddition() {
        // click on buttons
        click("1").click("+").click("3").click("=");
        // check result
        verifyThat(find("#label"), hasText("4.0"));
    }
}
