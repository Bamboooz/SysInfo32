package pl.systemInfo.Code.engineFiles;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.util.FormatUtil;
import java.util.List;

public class otherHardwareGatherer {

    public static String ramManufacturer;
    public static String ramMemoryType;
    public static String ramBankSlotLabel;
    public static String ramCapacity;
    public static String ramClockSpeed;
    public static String storageDescription;
    public static String storageLabel;
    public static String storageLogicalVolume;
    public static String storageMount;
    public static String storageName;
    public static String storageOptions;
    public static String storageType;
    public static String storageUUID;
    public static String storageVolume;
    public static String storageFreeSpace;
    public static String storageTotalSpace;
    public static String storageUsableSpace;

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

}