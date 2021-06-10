package pl.taskmgr;

/*** Class Run.java ***/
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static pl.systemInfo.Code.sysinfoEngine.stringsAndLabels.*;

public class Run {
    public static Timer taskKill() {

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                Run.taskKill((selectedTask + "*"));
            }
        };
        Timer timer = new Timer("MyTimer");  //create a new Timer
        timer.scheduleAtFixedRate(timerTask, 30, 10000);  //this line starts the timer at the same time its executed

        return timer;
    }


    /*** Task Tools ***/

    //Kill ONE task
    public static void taskKill(String strProcessName) {
        String strCmdLine = null;
        strCmdLine = String.format("TaskKill /F /IM " + strProcessName);
        Run.runCmd(strCmdLine);
    }

    //Holly shit! Don't use it! It can take down your pc!
    public static boolean taskKillExcept(String... except) {
        List<String> list = Run.taskList(except);
        if(list == null) {
            return false;
        }

        int len = list.size();
        String c;
        for(int i = 0; i < len; i++) {
            c = list.get(i);
            Run.taskKill(c);
        }
        c = null;
        return true;
    }

    public static List<String> taskList(String... except) {
        List<String> list = new ArrayList<String>();
        List<String> exc = new ArrayList<String>();

        int len = except.length;
        String c;
        for(int i = 0; i < len; i++) {
            c = except[i];
            if(c.endsWith("*")) {
                c = c.substring(0, c.length() - 1);
            }
            exc.add(c);
        }
        c = null;

        String out = Run.runCmd("TaskList");
        if(out == null) {
            System.err.println("Something went wrong.");
            return null;
        }
        String[] cmds = out.split("\n");
        len = cmds.length;
        int e;
        for(int i = 3; i < len; i++) {
            c = cmds[i];
            e = c.indexOf(' ');
            c = c.substring(0, e).trim();
            //System.out.println("Has: " + c);
            if(c.endsWith(".exe") && Run.isIn(exc, c) == false) {
                list.add(c);
            }
            exc.add(c);
        }
        c = null;


        return list;
    }


    /*** Utl ***/

    public static boolean isIn(List<String> arr, String what) {
        int len = arr.size();
        String c;
        for(int i = 0; i < len; i++) {
            c = arr.get(i);
            if(what.startsWith(c)) {
                return true;
            }
        }
        c = null;
        return false;
    }

    public static String runCmd(String cmd) {
        try {
            final Process p = Runtime.getRuntime().exec(cmd);
            final ProcessResultReader stderr = new ProcessResultReader(p.getErrorStream(), "STDERR");
            final ProcessResultReader stdout = new ProcessResultReader(p.getInputStream(), "STDOUT");
            stderr.start();
            stdout.start();
            final int exitValue = p.waitFor();
            if (exitValue == 0) {
                return stdout.toString();
            } else {
                return stderr.toString();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /*** Run ***/

    public static void main(String... run) {
        System.out.println("Test: RunCmd: " + Run.runCmd("TaskList"));

        List<String> list = Run.taskList();
        System.out.println("Test: Process List: " + list);

        Run.taskKill();
    }
}