package TestNgPratice;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SilkuliPratice {

	public static void main(String[] args) throws Throwable {

		Screen scr = new Screen();

		Pattern mini = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\minii.png");
		scr.click(mini);

		Pattern search = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\SearchBarr1.png");
		scr.type(search, "NotePad");

		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		Pattern page = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\emptypage2.png");
		scr.type(page, "QSPIDERS");

	}

}
