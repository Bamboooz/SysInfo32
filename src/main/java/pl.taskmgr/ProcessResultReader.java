package pl.taskmgr;

/*** Class ProcessResultReader.java from http://stackoverflow.com/questions/7637290/get-command-prompt-output-to-string-in-java ***/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessResultReader extends Thread {
    final InputStream is;
    final String type;
    final StringBuilder sb;

    ProcessResultReader(final InputStream is, String type) {
        this.is = is;
        this.type = type;
        this.sb = new StringBuilder();
    }

    public void run() {
        try {
            final InputStreamReader isr = new InputStreamReader(is);
            final BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                this.sb.append(line).append("\n");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }
}