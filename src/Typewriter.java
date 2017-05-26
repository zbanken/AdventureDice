import objectdraw.*; // Where active object comes from.
import javax.swing.JTextArea;

public class Typewriter extends ActiveObject {

    private JTextArea out;
    private String in;

    public Typewriter(String s, JTextArea output) {

        in = s;
        out = output;
        start();

    }

    public void run() {

        synchronized (out) {
            for (int i = 0; i < in.length(); i++) {
                out.append(in.substring(i, i + 1));

                if (in.charAt(i) == '.') {
                    pause(30);
                } else {
                    pause(200);
                }
            }
        }
    }
}