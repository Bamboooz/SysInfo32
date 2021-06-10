package pl.systemInfo.Code.sysinfoEngine;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.util.FormatUtil;

import java.io.*;
import java.net.*;
import java.util.List;
import static pl.systemInfo.Code.sysinfoEngine.stringsAndLabels.*;

public class otherHardwareGatherer {

    public static void getRamInfo() {

        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();

        List<PhysicalMemory> physicalMemories = globalMemory.getPhysicalMemory();

        for (PhysicalMemory physicalMemory : physicalMemories) {
            ramManufacturer = ("Manufacturer: " + physicalMemory.getManufacturer());
            ramMemoryType = ("Memory type: " + physicalMemory.getMemoryType());
            ramBankSlotLabel = ("Bank/slot label: " + physicalMemory.getBankLabel());
            ramCapacity = ("Capacity: " + FormatUtil.formatBytes(physicalMemory.getCapacity()));
            ramClockSpeed = ("Clock speed: " + FormatUtil.formatHertz(physicalMemory.getClockSpeed()));
        }

    }

    public static void getStorageInfo() {
        File cDrive = new File("C:");

        totalSpace = ("Total space: " +  cDrive.getTotalSpace() /1073741824 + " GB");
        freeSpace = ("Free space: " +  cDrive.getFreeSpace() /1073741824 + " GB");
        usableSpace = ("Usable space: " +  cDrive.getUsableSpace() /1073741824 + " GB");

    }

    public static void getInet6Address() throws UnknownHostException {

        String host = "localhost";
        byte[] add = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

        Inet6Address ip1 = Inet6Address.getByAddress(host, add, 5);

        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            isConnectionSuccesfull = 1;
        } catch (IOException e) {
            isConnectionSuccesfull = 0;
        }

        osName = ("OS Name: " + hostname1);
        ipAddress = ("Ipv4: " + IpV4);
        hostAddress = ("Host Address: " + ip1.getHostAddress());
        anyLocalAddress = ("isAnyLocalAddress: " + ip1.isAnyLocalAddress());
        linkLocalAddress = ("isLinkLocalAddress: " + ip1.isLinkLocalAddress());
        loopbackAddress = ("isLoopbackAddress: " + ip1.isLoopbackAddress());
        mcGlobal = ("isMCGlobal: " + ip1.isMCGlobal());
        mcLinkLocal = ("isMCLinkLocal: " + ip1.isMCLinkLocal());
        mcNodeLocal = ("isMCNodeLocal: " + ip1.isMCNodeLocal());
        mcOrgLocal = ("isMCOrgLocal: " + ip1.isMCOrgLocal());
        mcSiteLocal = ("isMCSiteLocal: " + ip1.isMCSiteLocal());
        multicastAddress  = ("isMulticastAddress: " + ip1.isMulticastAddress());
        siteLocalAddress = ("isSiteLocalAddress: " + ip1.isSiteLocalAddress());

    }

    public static void getAllHostNames() throws UnknownHostException {

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname1 = addr.getHostName();
        } catch (UnknownHostException ex) {
            hostname1 = ("Hostname can not be resolved");
        }

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            hostname = ("Hostname can not be resolved");
        }
        InetAddress IP = InetAddress.getLocalHost();
        IpV4 = IP.getHostAddress();
    }

    public static String getSystemMotherBoard_SerialNumber(){
        try{
            String OSName=  System.getProperty("os.name");
            if(OSName.contains("Windows")){
                return (getWindowsMotherboard_SerialNumber());
            }
            else{
                return (GetLinuxMotherBoard_serialNumber());
            }
        }
        catch(Exception E){
            System.err.println("System MotherBoard Exp : "+E.getMessage());
            return null;
        }
    }

    /**
     * Method for get Windows Machine MotherBoard Serial Number
     */

    private static String getWindowsMotherboard_SerialNumber() {
        StringBuilder result = new StringBuilder();
        try {
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs =
                    "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                            + "Set colItems = objWMIService.ExecQuery _ \n"
                            + "   (\"Select * from Win32_BaseBoard\") \n"
                            + "For Each objItem in colItems \n"
                            + "    Wscript.Echo objItem.SerialNumber \n"
                            + "    exit for  ' do the first cpu only! \n"
                            + "Next \n";

            fw.write(vbs);
            fw.close();

            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result.append(line);
            }
            input.close();
        }
        catch(Exception E){
            System.err.println("Windows MotherBoard Exp : "+E.getMessage());
        }
        return result.toString().trim();
    }


    /**
     * Method for get Linux Machine MotherBoard Serial Number
     */
    private static String GetLinuxMotherBoard_serialNumber() {
        String command = "dmidecode -s baseboard-serial-number";
        String sNum;
        try {
            Process SerNumProcess = Runtime.getRuntime().exec(command);
            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
            sNum = sNumReader.readLine().trim();
            SerNumProcess.waitFor();
            sNumReader.close();
        }
        catch (Exception ex) {
            System.err.println("Linux Motherboard Exp : "+ex.getMessage());
            sNum =null;
        }
        return sNum;
    }

}