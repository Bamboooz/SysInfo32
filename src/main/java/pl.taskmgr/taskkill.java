package pl.taskmgr;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class taskkill {
    public static Timer taskkillClass() {

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                taskkill("notepad*");
            }
        };

        Timer timer = new Timer("MyTimer");  //create a new Timer

        timer.scheduleAtFixedRate(timerTask, 30, 10000);  //this line starts the timer at the same time its executed

        return timer;
    }

    public static void taskkill(String strProcessName) {
        String strCmdLine = null;
        strCmdLine = String.format("taskkill /FI \"WINDOWTITLE eq %s\" ", strProcessName);

        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(strCmdLine);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
