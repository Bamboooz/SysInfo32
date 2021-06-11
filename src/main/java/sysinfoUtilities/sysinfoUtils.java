package sysinfoUtilities;

import java.io.File;
import java.io.IOException;

public class sysinfoUtils {

    public static void taskMgr() {
        ProcessBuilder startTaskMgr = new ProcessBuilder("taskmgr");
        try {
            startTaskMgr.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cmdExe() throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c start");
    }

    public static void msConfig() {
        ProcessBuilder startMsConfig = new ProcessBuilder("msconfig");
        try {
            startMsConfig.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void controlPanel() {
        ProcessBuilder startControlPanel = new ProcessBuilder("control");
        try {
            startControlPanel.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void regedit() {
        ProcessBuilder startRegedit = new ProcessBuilder("regedit");
        try {
            startRegedit.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void powerShell() throws IOException {
        ProcessBuilder startPowerShell = new ProcessBuilder("cmd.exe", "/c" , "start");
        startPowerShell.directory(new File("C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe"));
        startPowerShell.start();
    }

    public static void explorer() {
        ProcessBuilder startExplorer = new ProcessBuilder("explorer");
        try {
            startExplorer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
