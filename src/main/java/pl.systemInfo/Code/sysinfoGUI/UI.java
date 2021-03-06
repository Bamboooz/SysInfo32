package pl.systemInfo.Code.sysinfoGUI;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

import static pl.systemInfo.Code.sysinfoEngine.dxDiagnosis.*;
import static pl.systemInfo.Code.sysinfoEngine.otherHardwareGatherer.*;
import static pl.systemInfo.Code.sysinfoEngine.stringsAndLabels.*;
import static sysinfoUtilities.sysinfoUtils.*;

public class UI extends JFrame{

    public static void main(String[] args) throws IOException {

            //.....................................................//
            //               JFrame i Jego Ustawienia              //
            //.....................................................//

            JFrame frame = new JFrame("| SysInfo v.3.7.2 | Loading Libraries. Please Wait To Use Program |");

            Image icon = Toolkit.getDefaultToolkit().getImage(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/SysInfo32Icon.png")));
            frame.setIconImage(icon);

            frame.setLayout(new BorderLayout());
            frame.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/SysInfo32 Design.png")))));

            frame.pack();
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("| SysInfo v.3.7.2 | Loading Libraries. Please Wait To Use Program |");
            frame.setSize(748, 549);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar utilsMenu = new JMenuBar();
            utilsMenu.setVisible(true);
            frame.add(utilsMenu);
            frame.setJMenuBar(utilsMenu);
            JMenu menu = new JMenu("Utils");
            utilsMenu.add(menu);

            final JMenuItem taskMgr = new JMenuItem("Task Manager");
            taskMgr.addActionListener((e -> taskMgr()));

            final JMenuItem cmdExe = new JMenuItem("Cmd");
            cmdExe.addActionListener((e -> {
                    try {
                            cmdExe();
                    } catch (IOException ioException) {
                            ioException.printStackTrace();
                    }
            }));

            final JMenuItem msConfig = new JMenuItem("MsConfig");
            msConfig.addActionListener((e -> msConfig()));

            final JMenuItem controlPanel = new JMenuItem("Control Panel");
            controlPanel.addActionListener((e -> controlPanel()));

            final JMenuItem regedit = new JMenuItem("Regedit");
            regedit.addActionListener((e -> regedit()));

            final JMenuItem powerShell = new JMenuItem("PowerShell");
            powerShell.addActionListener((e -> {
                    try {
                            powerShell();
                    } catch (IOException ioException) {
                            ioException.printStackTrace();
                    }
            }));

            final JMenuItem explorer = new JMenuItem("Explorer");
            explorer.addActionListener((e -> explorer()));

            menu.add(taskMgr);
            menu.add(cmdExe);
            menu.add(msConfig);
            menu.add(controlPanel);
            menu.add(regedit);
            menu.add(powerShell);
            menu.add(explorer);

            Color colorFg = new Color(121, 145, 161);
            Color color = new Color(91, 91, 91);

            //.....................................................//

            //.....................................................//
            //      Wszystko Co Jest O Informacjach O Systemie     //
            //.....................................................//

            JLabel winIconLbl = new JLabel();
            winIconLbl.setVisible(false);
            frame.add(winIconLbl);
            ImageIcon winIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/winIcon.png")));
            winIconLbl.setIcon(winIcon);
            winIconLbl.setBounds(248, 30, 23, 20);

            JLabel OperatingSystem = new JLabel();
            frame.add(OperatingSystem);
            OperatingSystem.setBackground(color);
            OperatingSystem.setForeground(colorFg);
            OperatingSystem.setVisible(false);
            OperatingSystem.setBounds(270, 30, 110, 20);
            OperatingSystem.setText("Operating System");

            JLabel SystemName = new JLabel();
            frame.add(SystemName);
            SystemName.setBackground(color);
            SystemName.setForeground(colorFg);
            SystemName.setVisible(true);
            SystemName.setBounds(290, 74, 210, 20);

            JLabel SysVer = new JLabel();
            frame.add(SysVer);
            SysVer.setBackground(color);
            SysVer.setForeground(colorFg);
            SysVer.setVisible(true);
            SysVer.setBounds(290, 52, 410, 20);

            JLabel SysArch = new JLabel();
            frame.add(SysArch);
            SysArch.setVisible(false);
            SysArch.setBackground(color);
            SysArch.setForeground(colorFg);
            SysArch.setBounds(290, 72, 280, 20);
            SysArch.setText("System Architecture: " + System.getProperty("os.arch"));

            JLabel SysName = new JLabel();
            frame.add(SysName);
            SysName.setVisible(false);
            SysName.setBackground(color);
            SysName.setForeground(colorFg);
            SysName.setBounds(290, 52, 410, 20);

            JLabel systemLabelMachineModel = new JLabel();
            frame.add(systemLabelMachineModel);
            systemLabelMachineModel.setBackground(color);
            systemLabelMachineModel.setForeground(colorFg);
            systemLabelMachineModel.setVisible(false);
            systemLabelMachineModel.setBounds(290, 112, 410, 20);

            JLabel systemLabelMachineId = new JLabel();
            frame.add(systemLabelMachineId);
            systemLabelMachineId.setVisible(false);
            systemLabelMachineId.setBackground(color);
            systemLabelMachineId.setForeground(colorFg);
            systemLabelMachineId.setBounds(290, 132, 480, 20);

            JLabel systemLabelLanguage = new JLabel();
            frame.add(systemLabelLanguage);
            systemLabelLanguage.setVisible(false);
            systemLabelLanguage.setBackground(color);
            systemLabelLanguage.setForeground(colorFg);
            systemLabelLanguage.setText("System Language: " + Locale.getDefault().getLanguage());
            systemLabelLanguage.setBounds(290, 152, 410, 20);

            JLabel systemLabelWinDir = new JLabel();
            frame.add(systemLabelWinDir);
            systemLabelWinDir.setVisible(false);
            systemLabelWinDir.setBackground(color);
            systemLabelWinDir.setForeground(colorFg);
            systemLabelWinDir.setText("Windows Directory: " + System.getenv("windir"));
            systemLabelWinDir.setBounds(290, 172, 410, 20);

            JLabel SysNameLabel = new JLabel();
            frame.add(SysNameLabel);
            SysNameLabel.setVisible(false);
            SysNameLabel.setBackground(color);
            SysNameLabel.setForeground(colorFg);
            SysNameLabel.setBounds(270, 30, 280, 20);
            SysNameLabel.setText("Operating System Info");

            JLabel SysArchLabel = new JLabel();
            frame.add(SysArchLabel);
            SysArchLabel.setVisible(false);
            SysArchLabel.setBackground(color);
            SysArchLabel.setForeground(colorFg);
            SysArchLabel.setBounds(290, 72, 280, 20);
            SysArchLabel.setText("System Architecture: " + System.getProperty("os.arch"));

            JLabel hostnameLabel = new JLabel();
            frame.add(hostnameLabel);
            hostnameLabel.setVisible(false);
            hostnameLabel.setBackground(color);
            hostnameLabel.setForeground(colorFg);
            hostnameLabel.setBounds(290, 92, 280, 20);

            getAllHostNames();

            hostnameLabel.setText("Hostname: " + hostname1);

            JLabel winIconLabel = new JLabel();
            winIconLabel.setVisible(false);
            frame.add(winIconLabel);
            ImageIcon winIcon1 = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/winIcon.png")));
            winIconLabel.setIcon(winIcon1);
            winIconLabel.setBounds(248, 30, 23, 20);

            //.....................................................//

            //.....................................................//
            //         Wszystko Co Jest O Informacjach O CPU       //
            //.....................................................//
            JLabel CPUModel = new JLabel();
            frame.add(CPUModel);
            CPUModel.setBackground(color);
            CPUModel.setForeground(colorFg);
            CPUModel.setVisible(false);
            CPUModel.setBounds(270, 104, 500, 20);
            CPUModel.setText("CPU Model");

            JLabel CPUModelText = new JLabel();
            frame.add(CPUModelText);
            CPUModelText.setBackground(color);
            CPUModelText.setForeground(colorFg);
            CPUModelText.setVisible(false);
            CPUModelText.setBounds(290, 124, 500, 20);
            CPUModelText.setText("CPU Model");

            JLabel CPUArch = new JLabel();
            JLabel CPUNumber = new JLabel();
            frame.add(CPUArch);
            frame.add(CPUNumber);
            CPUArch.setVisible(false);
            CPUNumber.setVisible(false);
            CPUNumber.setText("Logic Processors: " + System.getenv("NUMBER_OF_PROCESSORS"));
            CPUArch.setBackground(color);
            CPUNumber.setBackground(color);
            CPUArch.setForeground(colorFg);
            CPUNumber.setForeground(colorFg);
            CPUArch.setBounds(290, 126, 500, 20);
            CPUNumber.setBounds(290, 144, 500, 20);

            JLabel cpuIconLbl = new JLabel();
            cpuIconLbl.setVisible(false);
            frame.add(cpuIconLbl);
            ImageIcon cpuIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/cpuIcon.png")));
            cpuIconLbl.setIcon(cpuIcon);
            cpuIconLbl.setBounds(248, 104, 23, 20);

            //.....................................................//

            //.....................................................//
            //         Wszystko Co Jest O Informacjach O RAM       //
            //.....................................................//

            JLabel MBModelText = new JLabel();
            frame.add(MBModelText);
            MBModelText.setBackground(color);
            MBModelText.setForeground(colorFg);
            MBModelText.setVisible(false);
            MBModelText.setBounds(290, 195, 500, 20);
            MBModelText.setText("Motherboard Model");

            JLabel ramIconLbl = new JLabel();
            ramIconLbl.setVisible(false);
            frame.add(ramIconLbl);
            ImageIcon ramIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/ramIcon.png")));
            ramIconLbl.setIcon(ramIcon);
            ramIconLbl.setBounds(248, 360, 23, 20);

            getStorageInfo();
            getRamInfo();

            JLabel cSize = new JLabel();
            frame.add(cSize);
            cSize.setBackground(color);
            cSize.setForeground(colorFg);
            cSize.setVisible(false);
            cSize.setBounds(290, 324, 380, 20);
            cSize.setText(totalSpace);

            JLabel RAMInfoText = new JLabel();
            RAMInfoText.setForeground(colorFg);
            frame.add(RAMInfoText);
            RAMInfoText.setVisible(false);
            RAMInfoText.setBackground(color);
            RAMInfoText.setBounds(270, 360, 280, 20);
            RAMInfoText.setText("RAM Info");
            JLabel ramSize = new JLabel();
            ramSize.setVisible(false);
            ramSize.setBackground(color);
            frame.add(ramSize);
            ramSize.setForeground(colorFg);
            ramSize.setBounds(290, 388, 280, 20);
            ramSize.setText("RAM Size = " + ramCapacity);

            JLabel BIOSModelText = new JLabel();
            frame.add(BIOSModelText);
            BIOSModelText.setBackground(color);
            BIOSModelText.setForeground(colorFg);
            BIOSModelText.setVisible(false);
            BIOSModelText.setBounds(290, 215, 500, 20);
            BIOSModelText.setText("BIOS Model");
            //.....................................................//

            //.....................................................//
            //           Strona Z Informacjami O GPU               //
            //.....................................................//

            JLabel gpuInfo = new JLabel("GPU Info");
            gpuInfo.setVisible(false);
            frame.add(gpuInfo);
            gpuInfo.setBackground(color);
            gpuInfo.setForeground(colorFg);
            gpuInfo.setBounds(272, 30, 177, 20);

            JLabel gpuIconLbl = new JLabel();
            gpuIconLbl.setVisible(false);
            frame.add(gpuIconLbl);
            ImageIcon gpuIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/gpuIcon.png")));
            gpuIconLbl.setIcon(gpuIcon);
            gpuIconLbl.setBounds(248, 240, 23, 20);

            JLabel GPUChipText = new JLabel();
            frame.add(GPUChipText);
            GPUChipText.setBackground(color);
            GPUChipText.setForeground(colorFg);
            GPUChipText.setVisible(false);
            GPUChipText.setBounds(290, 230, 500, 80);
            GPUChipText.setText("Chip text");

            JLabel GPUDisplayMemory = new JLabel();
            frame.add(GPUDisplayMemory);
            GPUDisplayMemory.setBackground(color);
            GPUDisplayMemory.setForeground(colorFg);
            GPUDisplayMemory.setVisible(false);
            GPUDisplayMemory.setBounds(290, 280, 500, 20);
            GPUDisplayMemory.setText("Display Memory");

            JLabel gpuInfoLabel = new JLabel();
            gpuInfoLabel.setVisible(false);
            frame.add(gpuInfoLabel);
            gpuInfoLabel.setIcon(gpuIcon);
            gpuInfoLabel.setBackground(color);
            gpuInfoLabel.setForeground(colorFg);
            gpuInfoLabel.setBounds(248, 30, 177, 20);

            JLabel GPUModel = new JLabel();
            frame.add(GPUModel);
            GPUModel.setBackground(color);
            GPUModel.setForeground(colorFg);
            GPUModel.setVisible(false);
            GPUModel.setBounds(270, 240, 280, 20);
            GPUModel.setText("Graphics Card Model");
            //.....................................................//

            //.....................................................//
            //      Strona Z Informacjami O P??ycie G????wnej         //
            //.....................................................//
            JLabel mbIconLbl = new JLabel();
            mbIconLbl.setVisible(false);
            frame.add(mbIconLbl);
            ImageIcon mbIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/mbIcon.png")));
            mbIconLbl.setIcon(mbIcon);
            mbIconLbl.setBounds(248, 175, 23, 20);

            JLabel MBModel = new JLabel();
            frame.add(MBModel);
            MBModel.setBackground(color);
            MBModel.setForeground(colorFg);
            MBModel.setVisible(false);
            MBModel.setBounds(270, 175, 210, 20);
            MBModel.setText("Motherboard Model");
            //.....................................................//

            //.....................................................//
            //           Strona Z Informacjami O Pami??ci           //
            //.....................................................//
            JLabel discIconLbl = new JLabel();
            discIconLbl.setVisible(false);
            frame.add(discIconLbl);
            ImageIcon discIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/discIcon.png")));
            discIconLbl.setIcon(discIcon);
            discIconLbl.setBounds(248, 300, 23, 20);

            JLabel storageInfo = new JLabel("Storage Info");
            storageInfo.setVisible(false);
            frame.add(storageInfo);
            storageInfo.setBackground(color);
            storageInfo.setForeground(colorFg);
            storageInfo.setBounds(272, 30, 177, 20);

            JLabel storageInfoLabel = new JLabel();
            storageInfoLabel.setVisible(false);
            frame.add(storageInfoLabel);
            ImageIcon storageIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/storageIcon.png")));
            storageInfoLabel.setIcon(storageIcon);
            storageInfoLabel.setBackground(color);
            storageInfoLabel.setForeground(colorFg);
            storageInfoLabel.setBounds(248, 30, 177, 20);

            JLabel StorageInfoText = new JLabel();
            frame.add(StorageInfoText);
            StorageInfoText.setBackground(color);
            StorageInfoText.setForeground(colorFg);
            StorageInfoText.setVisible(false);
            StorageInfoText.setBounds(270, 300, 180, 20);
            StorageInfoText.setText("Storage Info");

            JLabel storageLabelStorageDescription = new JLabel();
            storageLabelStorageDescription.setVisible(false);
            frame.add(storageLabelStorageDescription);
            storageLabelStorageDescription.setBackground(color);
            storageLabelStorageDescription.setForeground(colorFg);
            storageLabelStorageDescription.setBounds(290, 50, 277, 20);
            storageLabelStorageDescription.setText(totalSpace);

            JLabel storageLabelStorageLabel = new JLabel();
            storageLabelStorageLabel.setVisible(false);
            frame.add(storageLabelStorageLabel);
            storageLabelStorageLabel.setBackground(color);
            storageLabelStorageLabel.setForeground(colorFg);
            storageLabelStorageLabel.setBounds(290, 70, 277, 20);
            storageLabelStorageLabel.setText(freeSpace);

            JLabel storageLabelStorageLogicalVolume = new JLabel();
            storageLabelStorageLogicalVolume.setVisible(false);
            frame.add(storageLabelStorageLogicalVolume);
            storageLabelStorageLogicalVolume.setBackground(color);
            storageLabelStorageLogicalVolume.setForeground(colorFg);
            storageLabelStorageLogicalVolume.setBounds(290, 90, 277, 20);
            storageLabelStorageLogicalVolume.setText(usableSpace);

            //.....................................................//

            //.....................................................//
            //           Strona Z Informacjami O Sieci             //
            //.....................................................//

            JLabel networkInfo = new JLabel("Network Info");
            networkInfo.setVisible(false);
            frame.add(networkInfo);
            networkInfo.setBackground(color);
            networkInfo.setForeground(colorFg);
            networkInfo.setBounds(272, 30, 177, 20);

            JLabel networkInfoLabel = new JLabel();
            networkInfoLabel.setVisible(false);
            frame.add(networkInfoLabel);
            ImageIcon networkIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/networkIcon.png")));
            networkInfoLabel.setIcon(networkIcon);
            networkInfoLabel.setBackground(color);
            networkInfoLabel.setForeground(colorFg);
            networkInfoLabel.setBounds(248, 30, 177, 20);

            JLabel networkConnectionLabel = new JLabel();
            networkConnectionLabel.setVisible(false);
            frame.add(networkConnectionLabel);
            networkConnectionLabel.setBackground(color);
            networkConnectionLabel.setForeground(colorFg);
            networkConnectionLabel.setBounds(290, 50, 277, 20);

            JLabel networkLabelOsName = new JLabel();
            networkLabelOsName.setVisible(false);
            frame.add(networkLabelOsName);
            networkLabelOsName.setBackground(color);
            networkLabelOsName.setForeground(colorFg);
            networkLabelOsName.setBounds(290, 70, 277, 20);

            JLabel networkLabelIpAdress = new JLabel();
            networkLabelIpAdress.setVisible(false);
            frame.add(networkLabelIpAdress);
            networkLabelIpAdress.setBackground(color);
            networkLabelIpAdress.setForeground(colorFg);
            networkLabelIpAdress.setBounds(290, 90, 277, 20);

            JLabel networkLabelHostAddress = new JLabel();
            networkLabelHostAddress.setVisible(false);
            frame.add(networkLabelHostAddress);
            networkLabelHostAddress.setBackground(color);
            networkLabelHostAddress.setForeground(colorFg);
            networkLabelHostAddress.setBounds(290, 110, 277, 20);

            JLabel networkLabelisAnyLocalAddress = new JLabel();
            networkLabelisAnyLocalAddress.setVisible(false);
            frame.add(networkLabelisAnyLocalAddress);
            networkLabelisAnyLocalAddress.setBackground(color);
            networkLabelisAnyLocalAddress.setForeground(colorFg);
            networkLabelisAnyLocalAddress.setBounds(290, 130, 277, 20);

            JLabel networkLabelisLinkLocalAddress = new JLabel();
            networkLabelisLinkLocalAddress.setVisible(false);
            frame.add(networkLabelisLinkLocalAddress);
            networkLabelisLinkLocalAddress.setBackground(color);
            networkLabelisLinkLocalAddress.setForeground(colorFg);
            networkLabelisLinkLocalAddress.setBounds(290, 150, 277, 20);

            JLabel networkLabelisLoopbackAddress = new JLabel();
            networkLabelisLoopbackAddress.setVisible(false);
            frame.add(networkLabelisLoopbackAddress);
            networkLabelisLoopbackAddress.setBackground(color);
            networkLabelisLoopbackAddress.setForeground(colorFg);
            networkLabelisLoopbackAddress.setBounds(290, 170, 277, 20);

            JLabel networkLabelisMCGlobal = new JLabel();
            networkLabelisMCGlobal.setVisible(false);
            frame.add(networkLabelisMCGlobal);
            networkLabelisMCGlobal.setBackground(color);
            networkLabelisMCGlobal.setForeground(colorFg);
            networkLabelisMCGlobal.setBounds(290, 190, 277, 20);

            JLabel networkLabelisMCLinkLocal = new JLabel();
            networkLabelisMCLinkLocal.setVisible(false);
            frame.add(networkLabelisMCLinkLocal);
            networkLabelisMCLinkLocal.setBackground(color);
            networkLabelisMCLinkLocal.setForeground(colorFg);
            networkLabelisMCLinkLocal.setBounds(290, 210, 277, 20);

            JLabel networkLabelisMCNodeLocal = new JLabel();
            networkLabelisMCNodeLocal.setVisible(false);
            frame.add(networkLabelisMCNodeLocal);
            networkLabelisMCNodeLocal.setBackground(color);
            networkLabelisMCNodeLocal.setForeground(colorFg);
            networkLabelisMCNodeLocal.setBounds(290, 230, 277, 20);

            JLabel networkLabelisMCOrgLocal = new JLabel();
            networkLabelisMCOrgLocal.setVisible(false);
            frame.add(networkLabelisMCOrgLocal);
            networkLabelisMCOrgLocal.setBackground(color);
            networkLabelisMCOrgLocal.setForeground(colorFg);
            networkLabelisMCOrgLocal.setBounds(290, 250, 277, 20);

            JLabel networkLabelisMCSiteLocal = new JLabel();
            networkLabelisMCSiteLocal.setVisible(false);
            frame.add(networkLabelisMCSiteLocal);
            networkLabelisMCSiteLocal.setBackground(color);
            networkLabelisMCSiteLocal.setForeground(colorFg);
            networkLabelisMCSiteLocal.setBounds(290, 270, 277, 20);

            JLabel networkLabelisMulticastAddress = new JLabel();
            networkLabelisMulticastAddress.setVisible(false);
            frame.add(networkLabelisMulticastAddress);
            networkLabelisMulticastAddress.setBackground(color);
            networkLabelisMulticastAddress.setForeground(colorFg);
            networkLabelisMulticastAddress.setBounds(290, 290, 277, 20);

            JLabel networkLabelisSiteLocalAddress = new JLabel();
            networkLabelisSiteLocalAddress.setVisible(false);
            frame.add(networkLabelisSiteLocalAddress);
            networkLabelisSiteLocalAddress.setBackground(color);
            networkLabelisSiteLocalAddress.setForeground(colorFg);
            networkLabelisSiteLocalAddress.setBounds(290, 310, 277, 20);

            getInet6Address();

            if (isConnectionSuccesfull == 1) {
                networkConnectionLabel.setText("You Are Connected To Internet");
                networkLabelOsName.setText(osName);
                networkLabelIpAdress.setText(ipAddress);
                networkLabelHostAddress.setText(hostAddress);
                networkLabelisAnyLocalAddress.setText(anyLocalAddress);
                networkLabelisLinkLocalAddress.setText(linkLocalAddress);
                networkLabelisLoopbackAddress.setText(loopbackAddress);
                networkLabelisMCGlobal.setText(mcGlobal);
                networkLabelisMCLinkLocal.setText(mcLinkLocal);
                networkLabelisMCNodeLocal.setText(mcNodeLocal);
                networkLabelisMCOrgLocal.setText(mcOrgLocal);
                networkLabelisMCSiteLocal.setText(mcSiteLocal);
                networkLabelisMulticastAddress.setText(multicastAddress);
                networkLabelisSiteLocalAddress.setText(siteLocalAddress);
            } else {
                networkConnectionLabel.setText("You Are Not Connected To Internet");
                networkLabelOsName.setText("...");
                networkLabelIpAdress.setText("...");
                networkLabelHostAddress.setText("...");
                networkLabelisAnyLocalAddress.setText("...");
                networkLabelisLinkLocalAddress.setText("...");
                networkLabelisLoopbackAddress.setText("...");
                networkLabelisMCGlobal.setText("...");
                networkLabelisMCLinkLocal.setText("...");
                networkLabelisMCNodeLocal.setText("...");
                networkLabelisMCOrgLocal.setText("...");
                networkLabelisMCSiteLocal.setText("...");
                networkLabelisMulticastAddress.setText("...");
                networkLabelisSiteLocalAddress.setText("...");
            }

            //.....................................................//

            //.....................................................//
            //                 Strona Z Info O CPU                 //
            //.....................................................//

            JLabel cpuLabelInfoText = new JLabel("CPU Info");
            cpuLabelInfoText.setVisible(false);
            frame.add(cpuLabelInfoText);
            cpuLabelInfoText.setBackground(color);
            cpuLabelInfoText.setForeground(colorFg);
            cpuLabelInfoText.setBounds(272, 30, 177, 20);
            cpuLabelInfoText.setText("CPU Info");

            JLabel cpuLabel = new JLabel();
            cpuLabel.setVisible(false);
            frame.add(cpuLabel);
            cpuLabel.setIcon(cpuIcon);
            cpuLabel.setBackground(color);
            cpuLabel.setForeground(colorFg);
            cpuLabel.setBounds(248, 30, 177, 20);

            JLabel cpuLabelCpuModel = new JLabel("CPU Model: ");
            cpuLabelCpuModel.setVisible(false);
            frame.add(cpuLabelCpuModel);
            cpuLabelCpuModel.setBackground(color);
            cpuLabelCpuModel.setForeground(colorFg);
            cpuLabelCpuModel.setBounds(290, 50, 377, 20);

            JLabel cpuLabelCpuArch = new JLabel("CPU Architecture: ");
            cpuLabelCpuArch.setVisible(false);
            frame.add(cpuLabelCpuArch);
            cpuLabelCpuArch.setBackground(color);
            cpuLabelCpuArch.setForeground(colorFg);
            cpuLabelCpuArch.setBounds(290, 70, 377, 20);
            cpuLabelCpuArch.setText("CPU Architecture: " + System.getenv("PROCESSOR_ARCHITECTURE"));

            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
            CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();

            JLabel cpuLabelCpuCores = new JLabel("CPU Cores: ");
            cpuLabelCpuCores.setVisible(false);
            frame.add(cpuLabelCpuCores);
            cpuLabelCpuCores.setBackground(color);
            cpuLabelCpuCores.setForeground(colorFg);
            cpuLabelCpuCores.setBounds(290, 90, 377, 20);
            cpuLabelCpuCores.setText("CPU Cores: " + centralProcessor.getPhysicalProcessorCount());

            JLabel cpuLabelLogicProcessors = new JLabel("CPU Threads: ");
            cpuLabelLogicProcessors.setVisible(false);
            frame.add(cpuLabelLogicProcessors);
            cpuLabelLogicProcessors.setBackground(color);
            cpuLabelLogicProcessors.setForeground(colorFg);
            cpuLabelLogicProcessors.setBounds(290, 110, 377, 20);
            cpuLabelLogicProcessors.setText("CPU Threads: " + System.getenv("NUMBER_OF_PROCESSORS"));

            JLabel cpuLabelCpuTemp = new JLabel("CPU Temperature: ");
            cpuLabelCpuTemp.setVisible(false);
            frame.add(cpuLabelCpuTemp);
            cpuLabelCpuTemp.setBackground(color);
            cpuLabelCpuTemp.setForeground(colorFg);
            cpuLabelCpuTemp.setBounds(290, 130, 377, 20);

            JLabel cpuLabelProcessorIdentifier = new JLabel("Processor Identifier: ");
            cpuLabelProcessorIdentifier.setVisible(false);
            frame.add(cpuLabelProcessorIdentifier);
            cpuLabelProcessorIdentifier.setBackground(color);
            cpuLabelProcessorIdentifier.setForeground(colorFg);
            cpuLabelProcessorIdentifier.setBounds(290, 150, 377, 20);
            cpuLabelProcessorIdentifier.setText("Processor Identifier: " + System.getenv("PROCESSOR_IDENTIFIER"));

            //.....................................................//

            //.....................................................//
            //                 Strona Z Info O GPU                 //
            //.....................................................//

            JLabel gpuLabelGpuModel = new JLabel("GPU Model");
            gpuLabelGpuModel.setVisible(false);
            frame.add(gpuLabelGpuModel);
            gpuLabelGpuModel.setBackground(color);
            gpuLabelGpuModel.setForeground(colorFg);
            gpuLabelGpuModel.setBounds(290, 50, 377, 20);
            gpuLabelGpuModel.setText("GPU Model: ");

            JLabel gpuLabelGpuManufacturer = new JLabel("GPU Manufacturer");
            gpuLabelGpuManufacturer.setVisible(false);
            frame.add(gpuLabelGpuManufacturer);
            gpuLabelGpuManufacturer.setBackground(color);
            gpuLabelGpuManufacturer.setForeground(colorFg);
            gpuLabelGpuManufacturer.setBounds(290, 70, 377, 20);
            gpuLabelGpuManufacturer.setText("GPU Manufacturer: ");

            JLabel gpuLabelGpuChipType = new JLabel("GPU Chip Type");
            gpuLabelGpuChipType.setVisible(false);
            frame.add(gpuLabelGpuChipType);
            gpuLabelGpuChipType.setBackground(color);
            gpuLabelGpuChipType.setForeground(colorFg);
            gpuLabelGpuChipType.setBounds(290, 90, 377, 20);
            gpuLabelGpuChipType.setText("GPU Chip Type: ");

            JLabel gpuLabelGpuDacType = new JLabel("GPU Dac Type");
            gpuLabelGpuDacType.setVisible(false);
            frame.add(gpuLabelGpuDacType);
            gpuLabelGpuDacType.setBackground(color);
            gpuLabelGpuDacType.setForeground(colorFg);
            gpuLabelGpuDacType.setBounds(290, 110, 377, 20);
            gpuLabelGpuDacType.setText("GPU Dac Type: ");

            JLabel gpuLabelGpuDeviceType = new JLabel("GPU Device Type");
            gpuLabelGpuDeviceType.setVisible(false);
            frame.add(gpuLabelGpuDeviceType);
            gpuLabelGpuDeviceType.setBackground(color);
            gpuLabelGpuDeviceType.setForeground(colorFg);
            gpuLabelGpuDeviceType.setBounds(290, 130, 377, 20);
            gpuLabelGpuDeviceType.setText("GPU Device Type: ");

            JLabel gpuLabelGpuDisplayMemory = new JLabel("GPU Display Memory");
            gpuLabelGpuDisplayMemory.setVisible(false);
            frame.add(gpuLabelGpuDisplayMemory);
            gpuLabelGpuDisplayMemory.setBackground(color);
            gpuLabelGpuDisplayMemory.setForeground(colorFg);
            gpuLabelGpuDisplayMemory.setBounds(290, 150, 377, 20);
            gpuLabelGpuDisplayMemory.setText("GPU Display Memory: ");

            JLabel gpuLabelGpuDedicatedMemory = new JLabel("GPU Dedicated Memory");
            gpuLabelGpuDedicatedMemory.setVisible(false);
            frame.add(gpuLabelGpuDedicatedMemory);
            gpuLabelGpuDedicatedMemory.setBackground(color);
            gpuLabelGpuDedicatedMemory.setForeground(colorFg);
            gpuLabelGpuDedicatedMemory.setBounds(290, 170, 377, 20);
            gpuLabelGpuDedicatedMemory.setText("GPU Dedicated Memory: ");

            JLabel gpuLabelGpuSharedMemory = new JLabel("GPU Shared Memory");
            gpuLabelGpuSharedMemory.setVisible(false);
            frame.add(gpuLabelGpuSharedMemory);
            gpuLabelGpuSharedMemory.setBackground(color);
            gpuLabelGpuSharedMemory.setForeground(colorFg);
            gpuLabelGpuSharedMemory.setBounds(290, 190, 377, 20);
            gpuLabelGpuSharedMemory.setText("GPU Shared Memory: ");

            JLabel gpuLabelGpuVirtualization = new JLabel("GPU Virtualization");
            gpuLabelGpuVirtualization.setVisible(false);
            frame.add(gpuLabelGpuVirtualization);
            gpuLabelGpuVirtualization.setBackground(color);
            gpuLabelGpuVirtualization.setForeground(colorFg);
            gpuLabelGpuVirtualization.setBounds(290, 210, 377, 20);
            gpuLabelGpuVirtualization.setText("GPU Virtualization: ");

            //.....................................................//

            //.....................................................//
            //             Strona Z Info O Wy??wietlaniu            //
            //.....................................................//

            JLabel displayLabelDisplayInfoText = new JLabel("Display Info");
            displayLabelDisplayInfoText.setVisible(false);
            frame.add(displayLabelDisplayInfoText);
            displayLabelDisplayInfoText.setBackground(color);
            displayLabelDisplayInfoText.setForeground(colorFg);
            displayLabelDisplayInfoText.setBounds(272, 30, 377, 20);
            displayLabelDisplayInfoText.setText("Display Info");

            JLabel displayLabelDisplayInfoLabel = new JLabel();
            displayLabelDisplayInfoLabel.setVisible(false);
            frame.add(displayLabelDisplayInfoLabel);
            ImageIcon displayIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/displayIcon.png")));
            displayLabelDisplayInfoLabel.setIcon(displayIcon);
            displayLabelDisplayInfoLabel.setBackground(color);
            displayLabelDisplayInfoLabel.setForeground(colorFg);
            displayLabelDisplayInfoLabel.setBounds(248, 30, 377, 20);

            JLabel displayLabelCardName = new JLabel("Card Name");
            displayLabelCardName.setVisible(false);
            frame.add(displayLabelCardName);
            displayLabelCardName.setBackground(color);
            displayLabelCardName.setForeground(colorFg);
            displayLabelCardName.setBounds(290, 50, 377, 20);
            displayLabelCardName.setText("Card Name: ");

            JLabel displayLabelManufacturer = new JLabel("Manufacturer");
            displayLabelManufacturer.setVisible(false);
            frame.add(displayLabelManufacturer);
            displayLabelManufacturer.setBackground(color);
            displayLabelManufacturer.setForeground(colorFg);
            displayLabelManufacturer.setBounds(290, 70, 377, 20);
            displayLabelManufacturer.setText("Manufacturer: ");

            JLabel displayLabelChipType = new JLabel("Chip Type");
            displayLabelChipType.setVisible(false);
            frame.add(displayLabelChipType);
            displayLabelChipType.setBackground(color);
            displayLabelChipType.setForeground(colorFg);
            displayLabelChipType.setBounds(290, 90, 377, 20);
            displayLabelChipType.setText("Chip Type: ");

            JLabel displayLabelDacType = new JLabel("Dac Type");
            displayLabelDacType.setVisible(false);
            frame.add(displayLabelDacType);
            displayLabelDacType.setBackground(color);
            displayLabelDacType.setForeground(colorFg);
            displayLabelDacType.setBounds(290, 110, 377, 20);
            displayLabelDacType.setText("Dac Type: ");

            JLabel displayLabelDeviceType = new JLabel("Device Type");
            displayLabelDeviceType.setVisible(false);
            frame.add(displayLabelDeviceType);
            displayLabelDeviceType.setBackground(color);
            displayLabelDeviceType.setForeground(colorFg);
            displayLabelDeviceType.setBounds(290, 130, 377, 20);
            displayLabelDeviceType.setText("Device Type: ");

            JLabel displayLabelDisplayMemory = new JLabel("Display Memory");
            displayLabelDisplayMemory.setVisible(false);
            frame.add(displayLabelDisplayMemory);
            displayLabelDisplayMemory.setBackground(color);
            displayLabelDisplayMemory.setForeground(colorFg);
            displayLabelDisplayMemory.setBounds(290, 150, 377, 20);
            displayLabelDisplayMemory.setText("Display Memory: ");

            JLabel displayLabelDedicatedMemory = new JLabel("Dedicated Memory");
            displayLabelDedicatedMemory.setVisible(false);
            frame.add(displayLabelDedicatedMemory);
            displayLabelDedicatedMemory.setBackground(color);
            displayLabelDedicatedMemory.setForeground(colorFg);
            displayLabelDedicatedMemory.setBounds(290, 170, 377, 20);
            displayLabelDedicatedMemory.setText("Dedicated Memory: ");

            JLabel displayLabelSharedMemory = new JLabel("Shared Memory");
            displayLabelSharedMemory.setVisible(false);
            frame.add(displayLabelSharedMemory);
            displayLabelSharedMemory.setBackground(color);
            displayLabelSharedMemory.setForeground(colorFg);
            displayLabelSharedMemory.setBounds(290, 190, 377, 20);
            displayLabelSharedMemory.setText("Shared Memory: ");

            JLabel displayLabelCurrentMode = new JLabel("Current Mode");
            displayLabelCurrentMode.setVisible(false);
            frame.add(displayLabelCurrentMode);
            displayLabelCurrentMode.setBackground(color);
            displayLabelCurrentMode.setForeground(colorFg);
            displayLabelCurrentMode.setBounds(290, 210, 377, 20);
            displayLabelCurrentMode.setText("Current Mode: ");

            JLabel displayLabelHDRSupport = new JLabel("HDR Support");
            displayLabelHDRSupport.setVisible(false);
            frame.add(displayLabelHDRSupport);
            displayLabelHDRSupport.setBackground(color);
            displayLabelHDRSupport.setForeground(colorFg);
            displayLabelHDRSupport.setBounds(290, 230, 377, 20);
            displayLabelHDRSupport.setText("HDR Support: ");

            JLabel displayLabelDisplayTopology = new JLabel("Display Topology");
            displayLabelDisplayTopology.setVisible(false);
            frame.add(displayLabelDisplayTopology);
            displayLabelDisplayTopology.setBackground(color);
            displayLabelDisplayTopology.setForeground(colorFg);
            displayLabelDisplayTopology.setBounds(290, 250, 377, 20);
            displayLabelDisplayTopology.setText("Display Topology: ");

            JLabel displayLabelMonitorName = new JLabel("Monitor Name");
            displayLabelMonitorName.setVisible(false);
            frame.add(displayLabelMonitorName);
            displayLabelMonitorName.setBackground(color);
            displayLabelMonitorName.setForeground(colorFg);
            displayLabelMonitorName.setBounds(290, 270, 377, 20);
            displayLabelMonitorName.setText("Monitor Name: ");

            JLabel displayLabelMonitorId = new JLabel("Monitor Id");
            displayLabelMonitorId.setVisible(false);
            frame.add(displayLabelMonitorId);
            displayLabelMonitorId.setBackground(color);
            displayLabelMonitorId.setForeground(colorFg);
            displayLabelMonitorId.setBounds(290, 290, 377, 20);
            displayLabelMonitorId.setText("Monitor Id: ");

            JLabel displayLabelNativeMode = new JLabel("Native Mode");
            displayLabelNativeMode.setVisible(false);
            frame.add(displayLabelNativeMode);
            displayLabelNativeMode.setBackground(color);
            displayLabelNativeMode.setForeground(colorFg);
            displayLabelNativeMode.setBounds(290, 310, 377, 20);
            displayLabelNativeMode.setText("Native Mode: ");

            JLabel displayLabelOutputType = new JLabel("Output Type");
            displayLabelOutputType.setVisible(false);
            frame.add(displayLabelOutputType);
            displayLabelOutputType.setBackground(color);
            displayLabelOutputType.setForeground(colorFg);
            displayLabelOutputType.setBounds(290, 330, 377, 20);
            displayLabelOutputType.setText("Output Type: ");

            JLabel displayLabelMonitorCapabilities = new JLabel("Monitor Capabilities");
            displayLabelMonitorCapabilities.setVisible(false);
            frame.add(displayLabelMonitorCapabilities);
            displayLabelMonitorCapabilities.setBackground(color);
            displayLabelMonitorCapabilities.setForeground(colorFg);
            displayLabelMonitorCapabilities.setBounds(290, 350, 377, 20);
            displayLabelMonitorCapabilities.setText("Monitor Capabilities: ");

            JLabel displayLabelVirtualization = new JLabel("Virtualization");
            displayLabelVirtualization.setVisible(false);
            frame.add(displayLabelVirtualization);
            displayLabelVirtualization.setBackground(color);
            displayLabelVirtualization.setForeground(colorFg);
            displayLabelVirtualization.setBounds(290, 370, 377, 20);
            displayLabelVirtualization.setText("Virtualization: ");

            //.....................................................//

            //.....................................................//
            //           Strona Z Info O P??ycie G????wnej            //
            //.....................................................//

            JLabel motherboardLabelMotherboardInfo = new JLabel("Motherboard Info");
            motherboardLabelMotherboardInfo.setVisible(false);
            frame.add(motherboardLabelMotherboardInfo);
            motherboardLabelMotherboardInfo.setBackground(color);
            motherboardLabelMotherboardInfo.setForeground(colorFg);
            motherboardLabelMotherboardInfo.setBounds(272, 30, 177, 20);
            motherboardLabelMotherboardInfo.setText("Motherboard Info: ");

            JLabel motherboardLabelMotherboardIcon = new JLabel();
            motherboardLabelMotherboardIcon.setVisible(false);
            frame.add(motherboardLabelMotherboardIcon);
            motherboardLabelMotherboardIcon.setIcon(mbIcon);
            motherboardLabelMotherboardIcon.setBackground(color);
            motherboardLabelMotherboardIcon.setForeground(colorFg);
            motherboardLabelMotherboardIcon.setBounds(248, 30, 177, 20);

            JLabel motherboardLabelSystemManufacturer = new JLabel("System Manufacturer");
            motherboardLabelSystemManufacturer.setVisible(false);
            frame.add(motherboardLabelSystemManufacturer);
            motherboardLabelSystemManufacturer.setBackground(color);
            motherboardLabelSystemManufacturer.setForeground(colorFg);
            motherboardLabelSystemManufacturer.setBounds(290, 50, 477, 20);
            motherboardLabelSystemManufacturer.setText("System Manufacturer: ");

            JLabel motherboardLabelBios = new JLabel("BIOS");
            motherboardLabelBios.setVisible(false);
            frame.add(motherboardLabelBios);
            motherboardLabelBios.setBackground(color);
            motherboardLabelBios.setForeground(colorFg);
            motherboardLabelBios.setBounds(290, 70, 477, 20);
            motherboardLabelBios.setText("BIOS: ");

            JLabel motherboardLabelSystemModel = new JLabel("System Model");
            motherboardLabelSystemModel.setVisible(false);
            frame.add(motherboardLabelSystemModel);
            motherboardLabelSystemModel.setBackground(color);
            motherboardLabelSystemModel.setForeground(colorFg);
            motherboardLabelSystemModel.setBounds(290, 90, 477, 20);
            motherboardLabelSystemModel.setText("System Model: ");

            JLabel motherboardLabelMotherboardSerialNumber = new JLabel("Motherboard Serial Number");
            motherboardLabelMotherboardSerialNumber.setVisible(false);
            frame.add(motherboardLabelMotherboardSerialNumber);
            motherboardLabelMotherboardSerialNumber.setBackground(color);
            motherboardLabelMotherboardSerialNumber.setForeground(colorFg);
            motherboardLabelMotherboardSerialNumber.setBounds(290, 110, 577, 20);
            String motherBoard_SerialNumber = getSystemMotherBoard_SerialNumber();
            motherboardLabelMotherboardSerialNumber.setText("Motherboard Serial Number : "+motherBoard_SerialNumber);
            //.....................................................//

            //.....................................................//
            //                 Strona Z Info O RAM                 //
            //.....................................................//
            JLabel ramLabelRamInfoLabel = new JLabel("Ram Info");
            ramLabelRamInfoLabel.setVisible(false);
            frame.add(ramLabelRamInfoLabel);
            ramLabelRamInfoLabel.setBackground(color);
            ramLabelRamInfoLabel.setForeground(colorFg);
            ramLabelRamInfoLabel.setBounds(272, 30, 377, 20);
            ramLabelRamInfoLabel.setText("Ram Info");

            JLabel ramLabelRamIcon = new JLabel();
            ramLabelRamIcon.setVisible(false);
            frame.add(ramLabelRamIcon);
            ramLabelRamIcon.setIcon(ramIcon);
            ramLabelRamIcon.setBackground(color);
            ramLabelRamIcon.setForeground(colorFg);
            ramLabelRamIcon.setBounds(248, 30, 377, 20);

            JLabel ramLabelRamManufacturer = new JLabel("Ram Manufacturer");
            ramLabelRamManufacturer.setVisible(false);
            frame.add(ramLabelRamManufacturer);
            ramLabelRamManufacturer.setBackground(color);
            ramLabelRamManufacturer.setForeground(colorFg);
            ramLabelRamManufacturer.setBounds(272, 50, 377, 20);
            ramLabelRamManufacturer.setText(ramManufacturer);

            JLabel ramLabelMemoryType = new JLabel("Ram Type");
            ramLabelMemoryType.setVisible(false);
            frame.add(ramLabelMemoryType);
            ramLabelMemoryType.setBackground(color);
            ramLabelMemoryType.setForeground(colorFg);
            ramLabelMemoryType.setBounds(272, 70, 377, 20);
            ramLabelMemoryType.setText(ramMemoryType);

            JLabel ramLabelRamBankSlotLabel = new JLabel("Ram Bank/Slot Label: ");
            ramLabelRamBankSlotLabel.setVisible(false);
            frame.add(ramLabelRamBankSlotLabel);
            ramLabelRamBankSlotLabel.setBackground(color);
            ramLabelRamBankSlotLabel.setForeground(colorFg);
            ramLabelRamBankSlotLabel.setBounds(272, 90, 377, 20);
            ramLabelRamBankSlotLabel.setText(ramBankSlotLabel);

            JLabel ramLabelRamCapacity = new JLabel("Ram Capacity");
            ramLabelRamCapacity.setVisible(false);
            frame.add(ramLabelRamCapacity);
            ramLabelRamCapacity.setBackground(color);
            ramLabelRamCapacity.setForeground(colorFg);
            ramLabelRamCapacity.setBounds(272, 110, 377, 20);
            ramLabelRamCapacity.setText(ramCapacity);

            JLabel ramLabelRamClockSpeed = new JLabel("Ram Clock Speed");
            ramLabelRamClockSpeed.setVisible(false);
            frame.add(ramLabelRamClockSpeed);
            ramLabelRamClockSpeed.setBackground(color);
            ramLabelRamClockSpeed.setForeground(colorFg);
            ramLabelRamClockSpeed.setBounds(272, 130, 377, 20);
            ramLabelRamClockSpeed.setText(ramClockSpeed);

            //.....................................................//

            //.....................................................//
            //             Strona Z Info O Peryferiach             //
            //.....................................................//

            JLabel peripheralsLabelPeripheralsInfoText = new JLabel("Peripherals Info");
            peripheralsLabelPeripheralsInfoText.setVisible(false);
            frame.add(peripheralsLabelPeripheralsInfoText);
            peripheralsLabelPeripheralsInfoText.setBackground(color);
            peripheralsLabelPeripheralsInfoText.setForeground(colorFg);
            peripheralsLabelPeripheralsInfoText.setBounds(272, 30, 377, 20);
            peripheralsLabelPeripheralsInfoText.setText("Peripherals Info");

            /*
            *ImageIcon peripheralsIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/peripheralsIcon.png")));
            *peripheralsLabelPeripheralsInfoLabel.setIcon(peripheralsIcon);
            */

            JLabel peripheralsLabelPeripheralsInfoLabel = new JLabel();
            peripheralsLabelPeripheralsInfoLabel.setVisible(false);
            frame.add(peripheralsLabelPeripheralsInfoLabel);
            peripheralsLabelPeripheralsInfoLabel.setBackground(color);
            peripheralsLabelPeripheralsInfoLabel.setForeground(colorFg);
            peripheralsLabelPeripheralsInfoLabel.setBounds(248, 30, 377, 20);

            //.....................................................//

            //.....................................................//
            //                Strona Z Info O D??wi??ku              //
            //.....................................................//

            JLabel soundLabelSoundInfo = new JLabel("Sound Info");
            soundLabelSoundInfo.setVisible(false);
            frame.add(soundLabelSoundInfo);
            soundLabelSoundInfo.setBackground(color);
            soundLabelSoundInfo.setForeground(colorFg);
            soundLabelSoundInfo.setBounds(272, 30, 377, 20);
            soundLabelSoundInfo.setText("Sound Info");

            JLabel soundLabelSoundIcon = new JLabel();
            soundLabelSoundIcon.setVisible(false);
            frame.add(soundLabelSoundIcon);
            ImageIcon soundIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/soundIcon.png")));
            soundLabelSoundIcon.setIcon(soundIcon);
            soundLabelSoundIcon.setBackground(color);
            soundLabelSoundIcon.setForeground(colorFg);
            soundLabelSoundIcon.setBounds(248, 30, 377, 20);

            JLabel soundLabelDescription = new JLabel("Description");
            soundLabelDescription.setVisible(false);
            frame.add(soundLabelDescription);
            soundLabelDescription.setBackground(color);
            soundLabelDescription.setForeground(colorFg);
            soundLabelDescription.setBounds(290, 50, 377, 20);
            soundLabelDescription.setText("Description: ");

            JLabel soundLabelDefaultSoundPlayback = new JLabel("Default Sound Playback");
            soundLabelDefaultSoundPlayback.setVisible(false);
            frame.add(soundLabelDefaultSoundPlayback);
            soundLabelDefaultSoundPlayback.setBackground(color);
            soundLabelDefaultSoundPlayback.setForeground(colorFg);
            soundLabelDefaultSoundPlayback.setBounds(290, 70, 377, 20);
            soundLabelDefaultSoundPlayback.setText("Default Sound Playback: ");

            JLabel soundLabelDefaultVoicePlayback = new JLabel("Default Voice Playback");
            soundLabelDefaultVoicePlayback.setVisible(false);
            frame.add(soundLabelDefaultVoicePlayback);
            soundLabelDefaultVoicePlayback.setBackground(color);
            soundLabelDefaultVoicePlayback.setForeground(colorFg);
            soundLabelDefaultVoicePlayback.setBounds(290, 90, 377, 20);
            soundLabelDefaultVoicePlayback.setText("Default Voice Playback: ");

            JLabel soundLabelHardwareID = new JLabel("Hardware ID");
            soundLabelHardwareID.setVisible(false);
            frame.add(soundLabelHardwareID);
            soundLabelHardwareID.setBackground(color);
            soundLabelHardwareID.setForeground(colorFg);
            soundLabelHardwareID.setBounds(290, 110, 377, 20);
            soundLabelHardwareID.setText("Hardware ID: ");

            JLabel soundLabelDriverProvider = new JLabel("Driver Provider");
            soundLabelDriverProvider.setVisible(false);
            frame.add(soundLabelDriverProvider);
            soundLabelDriverProvider.setBackground(color);
            soundLabelDriverProvider.setForeground(colorFg);
            soundLabelDriverProvider.setBounds(290, 130, 377, 20);
            soundLabelDriverProvider.setText("Driver Provider: ");

            JLabel soundLabelHWAccelLevel = new JLabel("HW Accel Level");
            soundLabelHWAccelLevel.setVisible(false);
            frame.add(soundLabelHWAccelLevel);
            soundLabelHWAccelLevel.setBackground(color);
            soundLabelHWAccelLevel.setForeground(colorFg);
            soundLabelHWAccelLevel.setBounds(290, 150, 377, 20);
            soundLabelHWAccelLevel.setText("HW Accel Level: ");

            JLabel soundLabelVoiceManagement = new JLabel("Voice Management");
            soundLabelVoiceManagement.setVisible(false);
            frame.add(soundLabelVoiceManagement);
            soundLabelVoiceManagement.setBackground(color);
            soundLabelVoiceManagement.setForeground(colorFg);
            soundLabelVoiceManagement.setBounds(290, 170, 377, 20);
            soundLabelVoiceManagement.setText("Voice Management: ");

            JLabel soundLabelEAX20 = new JLabel("EAX(tm) 2.0 Listen/Src");
            soundLabelEAX20.setVisible(false);
            frame.add(soundLabelEAX20);
            soundLabelEAX20.setBackground(color);
            soundLabelEAX20.setForeground(colorFg);
            soundLabelEAX20.setBounds(290, 190, 377, 20);
            soundLabelEAX20.setText("EAX(tm) 2.0 Listen/Src: ");

            JLabel soundLabelI3DL2 = new JLabel("I3DL2(tm) Listen/Src");
            soundLabelI3DL2.setVisible(false);
            frame.add(soundLabelI3DL2);
            soundLabelI3DL2.setBackground(color);
            soundLabelI3DL2.setForeground(colorFg);
            soundLabelI3DL2.setBounds(290, 210, 377, 20);
            soundLabelI3DL2.setText("I3DL2(tm) Listen/Src: ");

            JLabel soundLabelSensauraZoomFX = new JLabel("Sensaura(tm) ZoomFX(tm)");
            soundLabelSensauraZoomFX.setVisible(false);
            frame.add(soundLabelSensauraZoomFX);
            soundLabelSensauraZoomFX.setBackground(color);
            soundLabelSensauraZoomFX.setForeground(colorFg);
            soundLabelSensauraZoomFX.setBounds(290, 230, 377, 20);
            soundLabelSensauraZoomFX.setText("Sensaura(tm) ZoomFX(tm): ");

            //.....................................................//

            //.....................................................//
            //                 Info O Temperaturze                 //
            //.....................................................//
            JLabel tempLabelText = new JLabel("Temperature Info");
            tempLabelText.setVisible(false);
            frame.add(tempLabelText);
            tempLabelText.setBackground(color);
            tempLabelText.setForeground(colorFg);
            tempLabelText.setBounds(272, 30, 177, 20);

            JLabel tempLabel = new JLabel();
            tempLabel.setVisible(false);
            frame.add(tempLabel);
            ImageIcon tempIcon = new ImageIcon(Objects.requireNonNull(UI.class.getClassLoader().getResource("Graphics/tempIcon.png")));
            tempLabel.setIcon(tempIcon);
            tempLabel.setBackground(color);
            tempLabel.setForeground(colorFg);
            tempLabel.setBounds(248, 30, 177, 20);

            JLabel tempLabelCPUTemp = new JLabel("CPU Temp: ");
            tempLabelCPUTemp.setVisible(false);
            frame.add(tempLabelCPUTemp);
            tempLabelCPUTemp.setBackground(color);
            tempLabelCPUTemp.setForeground(colorFg);
            tempLabelCPUTemp.setBounds(290, 50, 277, 20);

            JLabel tempLabelGPUTemp = new JLabel("GPU Temp: ");
            tempLabelGPUTemp.setVisible(false);
            frame.add(tempLabelGPUTemp);
            tempLabelGPUTemp.setBackground(color);
            tempLabelGPUTemp.setForeground(colorFg);
            tempLabelGPUTemp.setBounds(290, 70, 277, 20);

            JLabel tempLabelMotherboardTemp = new JLabel("Motherboard Temp: ");
            tempLabelMotherboardTemp.setVisible(false);
            frame.add(tempLabelMotherboardTemp);
            tempLabelMotherboardTemp.setBackground(color);
            tempLabelMotherboardTemp.setForeground(colorFg);
            tempLabelMotherboardTemp.setBounds(290, 90, 277, 20);

            JLabel tempLabelRAMTemp = new JLabel("RAM Temp: ");
            tempLabelRAMTemp.setVisible(false);
            frame.add(tempLabelRAMTemp);
            tempLabelRAMTemp.setBackground(color);
            tempLabelRAMTemp.setForeground(colorFg);
            tempLabelRAMTemp.setBounds(290, 110, 277, 20);

            JLabel tempLabelDiscTemp = new JLabel("Storage Temp: ");
            tempLabelDiscTemp.setVisible(false);
            frame.add(tempLabelDiscTemp);
            tempLabelDiscTemp.setBackground(color);
            tempLabelDiscTemp.setForeground(colorFg);
            tempLabelDiscTemp.setBounds(290, 130, 277, 20);

            //.....................................................//

            //.....................................................//
            //                 Rzeczy z Ustawie??                   //
            //.....................................................//
            JButton C = new JButton("Celsius");
            C.setBackground(color);
            C.setForeground(colorFg);
            frame.add(C);
            C.setBounds(270, 75, 110, 20);
            JButton F = new JButton("Fahrenheit");
            F.setBackground(color);
            F.setForeground(colorFg);
            frame.add(F);
            F.setBounds(490, 75, 110, 20);

            C.setVisible(false);
            F.setVisible(false);
            //.....................................................//

            //.....................................................//
            //                    Rzeczy Z DirectX                 //
            //.....................................................//

            startDxDiagnosis();

            while (true) {
                    if (isDxDiagFinished.equals("yes")) {
                            CPUModel.setVisible(true);
                            CPUNumber.setVisible(true);
                            CPUModelText.setVisible(true);
                            frame.setTitle("| SysInfo v.3.7.2  | Ready To Use. |");
                            MBModelText.setVisible(true);
                            BIOSModelText.setVisible(true);
                            GPUChipText.setVisible(true);
                            GPUDisplayMemory.setVisible(true);
                            SysName.setVisible(true);
                            SysArch.setVisible(true);
                            storageInfoLabel.setVisible(true);
                            discIconLbl.setVisible(true);
                            mbIconLbl.setVisible(true);
                            gpuIconLbl.setVisible(true);
                            ramIconLbl.setVisible(true);
                            cpuIconLbl.setVisible(true);
                            winIconLbl.setVisible(true);
                            RAMInfoText.setVisible(true);
                            cSize.setVisible(true);
                            StorageInfoText.setVisible(true);
                            GPUModel.setVisible(true);
                            MBModel.setVisible(true);
                            OperatingSystem.setVisible(true);
                            ramSize.setVisible(true);
                            displayLabelDisplayInfoText.setVisible(false);
                            displayLabelDisplayInfoLabel.setVisible(false);
                            gpuLabelGpuModel.setVisible(false);
                            gpuLabelGpuManufacturer.setVisible(false);
                            gpuLabelGpuChipType.setVisible(false);
                            gpuLabelGpuDacType.setVisible(false);
                            gpuLabelGpuDeviceType.setVisible(false);
                            gpuLabelGpuDisplayMemory.setVisible(false);
                            gpuLabelGpuDedicatedMemory.setVisible(false);
                            gpuLabelGpuSharedMemory.setVisible(false);
                            gpuLabelGpuVirtualization.setVisible(false);
                            cpuLabelCpuTemp.setVisible(false);
                            cpuLabel.setVisible(false);
                            cpuLabelCpuModel.setVisible(false);
                            cpuLabelCpuArch.setVisible(false);
                            cpuLabelCpuCores.setVisible(false);
                            cpuLabelInfoText.setVisible(false);
                            cpuLabelLogicProcessors.setVisible(false);
                            cpuLabelProcessorIdentifier.setVisible(false);
                            tempLabelText.setVisible(false);
                            tempLabel.setVisible(false);
                            tempLabelCPUTemp.setVisible(false);
                            tempLabelGPUTemp.setVisible(false);
                            tempLabelMotherboardTemp.setVisible(false);
                            tempLabelRAMTemp.setVisible(false);
                            tempLabelDiscTemp.setVisible(false);
                            systemLabelMachineModel.setVisible(false);
                            systemLabelMachineId.setVisible(false);
                            systemLabelLanguage.setVisible(false);
                            systemLabelWinDir.setVisible(false);
                            gpuInfo.setVisible(false);
                            gpuInfoLabel.setVisible(false);
                            storageInfo.setVisible(false);
                            networkConnectionLabel.setVisible(false);
                            networkLabelHostAddress.setVisible(false);
                            networkLabelisAnyLocalAddress.setVisible(false);
                            networkLabelisLinkLocalAddress.setVisible(false);
                            networkLabelisLoopbackAddress.setVisible(false);
                            networkLabelisMCGlobal.setVisible(false);
                            networkLabelisMCLinkLocal.setVisible(false);
                            networkLabelisMCNodeLocal.setVisible(false);
                            networkLabelisMCOrgLocal.setVisible(false);
                            networkLabelisMCSiteLocal.setVisible(false);
                            networkLabelisMulticastAddress.setVisible(false);
                            networkLabelisSiteLocalAddress.setVisible(false);
                            networkLabelOsName.setVisible(false);
                            networkLabelIpAdress.setVisible(false);
                            networkInfo.setVisible(false);
                            networkInfoLabel.setVisible(false);
                            winIconLabel.setVisible(false);
                            hostnameLabel.setVisible(false);
                            SysArchLabel.setVisible(false);
                            SysNameLabel.setVisible(false);
                            C.setVisible(false);
                            F.setVisible(false);
                            SysVer.setVisible(false);
                            SystemName.setVisible(false);
                            CPUArch.setVisible(false);
                            displayLabelCardName.setVisible(false);
                            displayLabelManufacturer.setVisible(false);
                            displayLabelChipType.setVisible(false);
                            displayLabelDacType.setVisible(false);
                            displayLabelDeviceType.setVisible(false);
                            displayLabelDisplayMemory.setVisible(false);
                            displayLabelDedicatedMemory.setVisible(false);
                            displayLabelSharedMemory.setVisible(false);
                            displayLabelCurrentMode.setVisible(false);
                            displayLabelHDRSupport.setVisible(false);
                            displayLabelDisplayTopology.setVisible(false);
                            displayLabelMonitorName.setVisible(false);
                            displayLabelMonitorId.setVisible(false);
                            displayLabelNativeMode.setVisible(false);
                            displayLabelOutputType.setVisible(false);
                            displayLabelMonitorCapabilities.setVisible(false);
                            displayLabelVirtualization.setVisible(false);
                            motherboardLabelMotherboardInfo.setVisible(false);
                            motherboardLabelMotherboardIcon.setVisible(false);
                            motherboardLabelSystemManufacturer.setVisible(false);
                            motherboardLabelBios.setVisible(false);
                            motherboardLabelSystemModel.setVisible(false);
                            motherboardLabelMotherboardSerialNumber.setVisible(false);
                            soundLabelSoundInfo.setVisible(false);
                            soundLabelSoundIcon.setVisible(false);
                            soundLabelDescription.setVisible(false);
                            soundLabelDefaultSoundPlayback.setVisible(false);
                            soundLabelDefaultVoicePlayback.setVisible(false);
                            soundLabelHardwareID.setVisible(false);
                            soundLabelDriverProvider.setVisible(false);
                            soundLabelHWAccelLevel.setVisible(false);
                            soundLabelVoiceManagement.setVisible(false);
                            soundLabelEAX20.setVisible(false);
                            soundLabelI3DL2.setVisible(false);
                            soundLabelSensauraZoomFX.setVisible(false);
                            ramLabelRamInfoLabel.setVisible(false);
                            ramLabelRamIcon.setVisible(false);
                            ramLabelRamManufacturer.setVisible(false);
                            ramLabelMemoryType.setVisible(false);
                            ramLabelRamBankSlotLabel.setVisible(false);
                            ramLabelRamCapacity.setVisible(false);
                            ramLabelRamClockSpeed.setVisible(false);
                            storageLabelStorageDescription.setVisible(false);
                            storageLabelStorageLabel.setVisible(false);
                            storageLabelStorageLogicalVolume.setVisible(false);

                            CPUModelText.setText(lineTrim);
                            cpuLabelCpuModel.setText(lineTrim);
                            SysVer.setText(line1Trim);
                            SysName.setText(line1Trim);
                            MBModelText.setText(line2Trim);
                            motherboardLabelSystemModel.setText(line2Trim);
                            BIOSModelText.setText(line3Trim);
                            motherboardLabelBios.setText(line3Trim);
                            GPUChipText.setText(line4Trim);
                            gpuLabelGpuModel.setText(line4Trim);
                            GPUDisplayMemory.setText(line5Trim);
                            gpuLabelGpuDisplayMemory.setText(line5Trim);
                            systemLabelMachineModel.setText(line6Trim);
                            systemLabelMachineId.setText(line7Trim);
                            System.out.println(line8Trim);
                            System.out.println(line9Trim);
                            System.out.println(line10Trim);
                            System.out.println(line11Trim);
                            System.out.println(line12Trim);
                            System.out.println(line13Trim);
                            System.out.println(line14Trim);
                            motherboardLabelSystemManufacturer.setText(line15Trim);

                            isDxDiagFinished = "no";
                            runIfDxDiagFinished = 0;
                            break;
                    }
            }

            //.....................................................//

            //.....................................................//
            //                     Lista Guzik??w                   //
            //.....................................................//
            JButton MainInfo = new JButton("Summary");
            MainInfo.setForeground(colorFg);
            MainInfo.setBorderPainted(false);
            MainInfo.setBackground(color);
            frame.add(MainInfo);
            MainInfo.setBounds(35, 18, 177, 20);

            JButton SystemInfo = new JButton("Operating System");
            SystemInfo.setForeground(colorFg);
            SystemInfo.setBackground(color);
            SystemInfo.setBorderPainted(false);
            frame.add(SystemInfo);
            SystemInfo.setBounds(35, 44, 177, 20);

            JButton CPUInfo = new JButton("CPU Info");
            CPUInfo.setBackground(color);
            CPUInfo.setBorderPainted(false);
            CPUInfo.setForeground(colorFg);
            frame.add(CPUInfo);
            CPUInfo.setBounds(35, 70, 177, 20);

            JButton RAMInfo = new JButton("RAM Info");
            RAMInfo.setBackground(color);
            RAMInfo.setForeground(colorFg);
            RAMInfo.setBorderPainted(false);
            frame.add(RAMInfo);
            RAMInfo.setBounds(35, 96, 177, 20);

            JButton MBInfo = new JButton("Motherboard Info");
            MBInfo.setBackground(color);
            MBInfo.setForeground(colorFg);
            MBInfo.setBorderPainted(false);
            frame.add(MBInfo);
            MBInfo.setBounds(35, 122, 177, 20);

            JButton GPUInfo = new JButton("GPU Info");
            GPUInfo.setBackground(color);
            GPUInfo.setForeground(colorFg);
            GPUInfo.setBorderPainted(false);
            frame.add(GPUInfo);
            GPUInfo.setBounds(35, 148, 177, 20);

            JButton DisplayInfo = new JButton("Display Info");
            DisplayInfo.setBackground(color);
            DisplayInfo.setForeground(colorFg);
            DisplayInfo.setBorderPainted(false);
            frame.add(DisplayInfo);
            DisplayInfo.setBounds(35, 174, 177, 20);

            JButton StorageInfo = new JButton("Storage Info");
            StorageInfo.setBackground(color);
            StorageInfo.setForeground(colorFg);
            StorageInfo.setBorderPainted(false);
            frame.add(StorageInfo);
            StorageInfo.setBounds(35, 203, 177, 20);

            JButton OpticalDrives = new JButton("Optical Drives");
            OpticalDrives.setBackground(color);
            OpticalDrives.setForeground(colorFg);
            OpticalDrives.setBorderPainted(false);
            frame.add(OpticalDrives);
            OpticalDrives.setBounds(35, 230, 177, 20);

            JButton Temp = new JButton("Temperature");
            Temp.setBackground(color);
            Temp.setForeground(colorFg);
            Temp.setBorderPainted(false);
            frame.add(Temp);
            Temp.setBounds(35, 255, 177, 20);

            JButton Peripherals = new JButton("Peripherals");
            Peripherals.setBackground(color);
            Peripherals.setForeground(colorFg);
            Peripherals.setBorderPainted(false);
            frame.add(Peripherals);
            Peripherals.setBounds(35, 282, 177, 20);

            JButton Sound = new JButton("Sound");
            Sound.setBackground(color);
            Sound.setForeground(colorFg);
            Sound.setBorderPainted(false);
            frame.add(Sound);
            Sound.setBounds(35, 308, 177, 20);
            System.out.println();
            JButton Network = new JButton("Network");
            Network.setBackground(color);
            Network.setForeground(colorFg);
            Network.setBorderPainted(false);
            frame.add(Network);
            Network.setBounds(35, 336, 177, 20);

            JButton Options = new JButton("Options");
            Options.setBackground(color);
            Options.setForeground(colorFg);
            Options.setBorderPainted(false);
            frame.add(Options);
            Options.setBounds(35, 363, 177, 20);

            isSwitchContentPage = "0";

            //.....................................................//

            //.....................................................//
            //         Zmienianie Stron / Dzialanie guzik??w        //
            //.....................................................//

            MainInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(true);
                    CPUModelText.setVisible(true);
                    MBModelText.setVisible(true);
                    BIOSModelText.setVisible(true);
                    GPUChipText.setVisible(true);
                    GPUDisplayMemory.setVisible(true);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    SystemName.setVisible(true);
                    OperatingSystem.setVisible(true);
                    SysVer.setVisible(true);
                    CPUArch.setVisible(true);
                    CPUModel.setVisible(true);
                    CPUNumber.setVisible(true);
                    MBModel.setVisible(true);
                    GPUModel.setVisible(true);
                    StorageInfoText.setVisible(true);
                    cSize.setVisible(true);
                    RAMInfoText.setVisible(true);
                    ramSize.setVisible(true);
                    winIconLbl.setVisible(true);
                    cpuIconLbl.setVisible(true);
                    mbIconLbl.setVisible(true);
                    discIconLbl.setVisible(true);
                    ramIconLbl.setVisible(true);
                    gpuIconLbl.setVisible(true);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            SystemInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(true);
                    systemLabelMachineId.setVisible(true);
                    systemLabelLanguage.setVisible(true);
                    systemLabelWinDir.setVisible(true);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    winIconLabel.setVisible(true);
                    hostnameLabel.setVisible(true);
                    SysArchLabel.setVisible(true);
                    SysNameLabel.setVisible(true);
                    SysName.setVisible(true);
                    C.setVisible(false);
                    F.setVisible(false);
                    SystemName.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            CPUInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelInfoText.setVisible(true);
                    cpuLabel.setVisible(true);
                    cpuLabelCpuModel.setVisible(true);
                    cpuLabelCpuArch.setVisible(true);
                    cpuLabelCpuCores.setVisible(true);
                    cpuLabelCpuTemp.setVisible(true);
                    cpuLabelInfoText.setVisible(true);
                    cpuLabelLogicProcessors.setVisible(true);
                    cpuLabelProcessorIdentifier.setVisible(true);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    SystemName.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            RAMInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(true);
                    ramLabelRamIcon.setVisible(true);
                    ramLabelRamManufacturer.setVisible(true);
                    ramLabelMemoryType.setVisible(true);
                    ramLabelRamBankSlotLabel.setVisible(true);
                    ramLabelRamCapacity.setVisible(true);
                    ramLabelRamClockSpeed.setVisible(true);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            MBInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(true);
                    motherboardLabelMotherboardIcon.setVisible(true);
                    motherboardLabelSystemManufacturer.setVisible(true);
                    motherboardLabelBios.setVisible(true);
                    motherboardLabelSystemModel.setVisible(true);
                    motherboardLabelMotherboardSerialNumber.setVisible(true);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            GPUInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(true);
                    gpuLabelGpuManufacturer.setVisible(true);
                    gpuLabelGpuChipType.setVisible(true);
                    gpuLabelGpuDacType.setVisible(true);
                    gpuLabelGpuDeviceType.setVisible(true);
                    gpuLabelGpuDisplayMemory.setVisible(true);
                    gpuLabelGpuDedicatedMemory.setVisible(true);
                    gpuLabelGpuSharedMemory.setVisible(true);
                    gpuLabelGpuVirtualization.setVisible(true);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(true);
                    gpuInfoLabel.setVisible(true);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            DisplayInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(true);
                    displayLabelManufacturer.setVisible(true);
                    displayLabelChipType.setVisible(true);
                    displayLabelDacType.setVisible(true);
                    displayLabelDeviceType.setVisible(true);
                    displayLabelDisplayMemory.setVisible(true);
                    displayLabelDedicatedMemory.setVisible(true);
                    displayLabelSharedMemory.setVisible(true);
                    displayLabelCurrentMode.setVisible(true);
                    displayLabelHDRSupport.setVisible(true);
                    displayLabelDisplayTopology.setVisible(true);
                    displayLabelMonitorName.setVisible(true);
                    displayLabelMonitorId.setVisible(true);
                    displayLabelNativeMode.setVisible(true);
                    displayLabelOutputType.setVisible(true);
                    displayLabelMonitorCapabilities.setVisible(true);
                    displayLabelVirtualization.setVisible(true);
                    displayLabelDisplayInfoText.setVisible(true);
                    displayLabelDisplayInfoLabel.setVisible(true);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            StorageInfo.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(true);
                    storageInfoLabel.setVisible(true);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(true);
                    storageLabelStorageLabel.setVisible(true);
                    storageLabelStorageLogicalVolume.setVisible(true);
                }
            });
            OpticalDrives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            Temp.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(true);
                    tempLabel.setVisible(true);
                    tempLabelCPUTemp.setVisible(true);
                    tempLabelGPUTemp.setVisible(true);
                    tempLabelMotherboardTemp.setVisible(true);
                    tempLabelRAMTemp.setVisible(true);
                    tempLabelDiscTemp.setVisible(true);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            Peripherals.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            Sound.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(true);
                    soundLabelSoundIcon.setVisible(true);
                    soundLabelDescription.setVisible(true);
                    soundLabelDefaultSoundPlayback.setVisible(true);
                    soundLabelDefaultVoicePlayback.setVisible(true);
                    soundLabelHardwareID.setVisible(true);
                    soundLabelDriverProvider.setVisible(true);
                    soundLabelHWAccelLevel.setVisible(true);
                    soundLabelVoiceManagement.setVisible(true);
                    soundLabelEAX20.setVisible(true);
                    soundLabelI3DL2.setVisible(true);
                    soundLabelSensauraZoomFX.setVisible(true);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            Network.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(true);
                    networkLabelHostAddress.setVisible(true);
                    networkLabelisAnyLocalAddress.setVisible(true);
                    networkLabelisLinkLocalAddress.setVisible(true);
                    networkLabelisLoopbackAddress.setVisible(true);
                    networkLabelisMCGlobal.setVisible(true);
                    networkLabelisMCLinkLocal.setVisible(true);
                    networkLabelisMCNodeLocal.setVisible(true);
                    networkLabelisMCOrgLocal.setVisible(true);
                    networkLabelisMCSiteLocal.setVisible(true);
                    networkLabelisMulticastAddress.setVisible(true);
                    networkLabelisSiteLocalAddress.setVisible(true);
                    networkLabelOsName.setVisible(true);
                    networkLabelIpAdress.setVisible(true);
                    networkInfo.setVisible(true);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    networkInfoLabel.setVisible(true);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(false);
                    F.setVisible(false);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            Options.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    soundLabelSoundInfo.setVisible(false);
                    soundLabelSoundIcon.setVisible(false);
                    soundLabelDescription.setVisible(false);
                    soundLabelDefaultSoundPlayback.setVisible(false);
                    soundLabelDefaultVoicePlayback.setVisible(false);
                    soundLabelHardwareID.setVisible(false);
                    soundLabelDriverProvider.setVisible(false);
                    soundLabelHWAccelLevel.setVisible(false);
                    soundLabelVoiceManagement.setVisible(false);
                    soundLabelEAX20.setVisible(false);
                    soundLabelI3DL2.setVisible(false);
                    soundLabelSensauraZoomFX.setVisible(false);
                    motherboardLabelMotherboardInfo.setVisible(false);
                    motherboardLabelMotherboardIcon.setVisible(false);
                    motherboardLabelSystemManufacturer.setVisible(false);
                    motherboardLabelBios.setVisible(false);
                    motherboardLabelSystemModel.setVisible(false);
                    motherboardLabelMotherboardSerialNumber.setVisible(false);
                    displayLabelCardName.setVisible(false);
                    displayLabelManufacturer.setVisible(false);
                    displayLabelChipType.setVisible(false);
                    displayLabelDacType.setVisible(false);
                    displayLabelDeviceType.setVisible(false);
                    displayLabelDisplayMemory.setVisible(false);
                    displayLabelDedicatedMemory.setVisible(false);
                    displayLabelSharedMemory.setVisible(false);
                    displayLabelCurrentMode.setVisible(false);
                    displayLabelHDRSupport.setVisible(false);
                    displayLabelDisplayTopology.setVisible(false);
                    displayLabelMonitorName.setVisible(false);
                    displayLabelMonitorId.setVisible(false);
                    displayLabelNativeMode.setVisible(false);
                    displayLabelOutputType.setVisible(false);
                    displayLabelMonitorCapabilities.setVisible(false);
                    displayLabelVirtualization.setVisible(false);
                    displayLabelDisplayInfoText.setVisible(false);
                    displayLabelDisplayInfoLabel.setVisible(false);
                    gpuLabelGpuModel.setVisible(false);
                    gpuLabelGpuManufacturer.setVisible(false);
                    gpuLabelGpuChipType.setVisible(false);
                    gpuLabelGpuDacType.setVisible(false);
                    gpuLabelGpuDeviceType.setVisible(false);
                    gpuLabelGpuDisplayMemory.setVisible(false);
                    gpuLabelGpuDedicatedMemory.setVisible(false);
                    gpuLabelGpuSharedMemory.setVisible(false);
                    gpuLabelGpuVirtualization.setVisible(false);
                    cpuLabelCpuTemp.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabel.setVisible(false);
                    cpuLabelCpuModel.setVisible(false);
                    cpuLabelCpuArch.setVisible(false);
                    cpuLabelCpuCores.setVisible(false);
                    cpuLabelInfoText.setVisible(false);
                    cpuLabelLogicProcessors.setVisible(false);
                    cpuLabelProcessorIdentifier.setVisible(false);
                    tempLabelText.setVisible(false);
                    tempLabel.setVisible(false);
                    tempLabelCPUTemp.setVisible(false);
                    tempLabelGPUTemp.setVisible(false);
                    tempLabelMotherboardTemp.setVisible(false);
                    tempLabelRAMTemp.setVisible(false);
                    tempLabelDiscTemp.setVisible(false);
                    systemLabelMachineModel.setVisible(false);
                    systemLabelMachineId.setVisible(false);
                    systemLabelLanguage.setVisible(false);
                    systemLabelWinDir.setVisible(false);
                    SysArch.setVisible(false);
                    CPUModelText.setVisible(false);
                    MBModelText.setVisible(false);
                    BIOSModelText.setVisible(false);
                    GPUChipText.setVisible(false);
                    GPUDisplayMemory.setVisible(false);
                    gpuInfo.setVisible(false);
                    gpuInfoLabel.setVisible(false);
                    storageInfo.setVisible(false);
                    storageInfoLabel.setVisible(false);
                    networkConnectionLabel.setVisible(false);
                    networkLabelHostAddress.setVisible(false);
                    networkLabelisAnyLocalAddress.setVisible(false);
                    networkLabelisLinkLocalAddress.setVisible(false);
                    networkLabelisLoopbackAddress.setVisible(false);
                    networkLabelisMCGlobal.setVisible(false);
                    networkLabelisMCLinkLocal.setVisible(false);
                    networkLabelisMCNodeLocal.setVisible(false);
                    networkLabelisMCOrgLocal.setVisible(false);
                    networkLabelisMCSiteLocal.setVisible(false);
                    networkLabelisMulticastAddress.setVisible(false);
                    networkLabelisSiteLocalAddress.setVisible(false);
                    networkLabelOsName.setVisible(false);
                    networkLabelIpAdress.setVisible(false);
                    networkInfo.setVisible(false);
                    winIconLabel.setVisible(false);
                    hostnameLabel.setVisible(false);
                    SysArchLabel.setVisible(false);
                    networkInfoLabel.setVisible(false);
                    SysNameLabel.setVisible(false);
                    SysName.setVisible(false);
                    C.setVisible(true);
                    F.setVisible(true);
                    OperatingSystem.setVisible(false);
                    SystemName.setVisible(false);
                    SysVer.setVisible(false);
                    CPUArch.setVisible(false);
                    CPUModel.setVisible(false);
                    CPUNumber.setVisible(false);
                    MBModel.setVisible(false);
                    GPUModel.setVisible(false);
                    StorageInfoText.setVisible(false);
                    cSize.setVisible(false);
                    RAMInfoText.setVisible(false);
                    ramSize.setVisible(false);
                    winIconLbl.setVisible(false);
                    cpuIconLbl.setVisible(false);
                    mbIconLbl.setVisible(false);
                    discIconLbl.setVisible(false);
                    ramIconLbl.setVisible(false);
                    gpuIconLbl.setVisible(false);
                    ramLabelRamInfoLabel.setVisible(false);
                    ramLabelRamIcon.setVisible(false);
                    ramLabelRamManufacturer.setVisible(false);
                    ramLabelMemoryType.setVisible(false);
                    ramLabelRamBankSlotLabel.setVisible(false);
                    ramLabelRamCapacity.setVisible(false);
                    ramLabelRamClockSpeed.setVisible(false);
                    storageLabelStorageDescription.setVisible(false);
                    storageLabelStorageLabel.setVisible(false);
                    storageLabelStorageLogicalVolume.setVisible(false);
                }
            });
            //.....................................................//
        }

    }
