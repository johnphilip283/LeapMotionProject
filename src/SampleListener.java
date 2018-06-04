import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.Type;
import java.io.IOException;

public class SampleListener extends Listener {

  public static final int SLEEP_TIME = 1000;

  @Override
  public void onConnect(Controller controller) {
    System.out.println("Connected");
  }

  @Override
  public void onFrame(Controller controller) {

    try {

      Frame frame = controller.frame();
      HandList hands = frame.hands();

      String command = "spotify ";

      Runtime proc = Runtime.getRuntime();

      switch (hands.count()) {
        case 1:
          command += "pause";
          break;
        case 2:
          command += "vol up";
          break;
      }

      proc.exec(command);

      if (hands.count() != 0) {
        Thread.sleep(SLEEP_TIME);
      }


    } catch (Exception e) {
      System.out.println("PROGRAM IS BROKE AF");
    }


  }

}
