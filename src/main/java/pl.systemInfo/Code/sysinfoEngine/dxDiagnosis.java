package pl.systemInfo.Code.sysinfoEngine;

import java.io.IOException;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.File;

import static pl.systemInfo.Code.sysinfoEngine.stringsAndLabels.*;

public class dxDiagnosis {

    public static void startDxDiagnosis() {

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> {
            try {
                String filePath = "./src/main/resources/dxdiagOutputs/dxdiagOutput.txt";
                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath);
                Process p = pb.start();
                p.waitFor();
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br.close();
                        File file = new File(filePath);
                        if (file.delete()) System.out.println("File deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line = br.readLine()) != null) {
                    if (line.trim().startsWith("Processor:")) {
                        lineTrim = line.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br.close();
                File file = new File(filePath);
                if (file.delete()) System.out.println("File deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }

        });

        ExecutorService service1 = Executors.newCachedThreadPool();

        service1.submit(() -> {
            try {
                String filePath1 = "./src/main/resources/dxdiagOutputs/dxdiagOutput1.txt";
                ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath1);
                Process p1 = pb1.start();
                p1.waitFor();
                BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
                String line1;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br1.close();
                        File file1 = new File(filePath1);
                        if (file1.delete()) System.out.println("File 1 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line1 = br1.readLine()) != null) {
                    if (line1.trim().startsWith("Operating System:")) {
                        line1Trim = line1.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br1.close();
                File file1 = new File(filePath1);
                if (file1.delete()) System.out.println("File 1 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service2 = Executors.newCachedThreadPool();

        service2.submit(() -> {
            try {
                String filePath2 = "./src/main/resources/dxdiagOutputs/dxdiagOutput2.txt";
                ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath2);
                Process p2 = pb2.start();
                p2.waitFor();
                BufferedReader br2 = new BufferedReader(new FileReader(filePath2));
                String line2;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br2.close();
                        File file2 = new File(filePath2);
                        if (file2.delete()) System.out.println("File 2 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line2 = br2.readLine()) != null) {
                    if (line2.trim().startsWith("System Model:")) {
                        line2Trim = line2.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br2.close();
                File file2 = new File(filePath2);
                if (file2.delete()) System.out.println("File 2 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service3 = Executors.newCachedThreadPool();

        service3.submit(() -> {
            try {
                String filePath3 = "./src/main/resources/dxdiagOutputs/dxdiagOutput3.txt";
                ProcessBuilder pb3 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath3);
                Process p3 = pb3.start();
                p3.waitFor();
                BufferedReader br3 = new BufferedReader(new FileReader(filePath3));
                String line3;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br3.close();
                        File file3 = new File(filePath3);
                        if (file3.delete()) System.out.println("File 3 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line3 = br3.readLine()) != null) {
                    if (line3.trim().startsWith("BIOS:")) {
                        line3Trim = line3.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br3.close();
                File file3 = new File(filePath3);
                if (file3.delete()) System.out.println("File 3 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service4 = Executors.newCachedThreadPool();

        service4.submit(() -> {
            try {
                String filePath4 = "./src/main/resources/dxdiagOutputs/dxdiagOutput4.txt";
                ProcessBuilder pb4 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath4);
                Process p4 = pb4.start();
                p4.waitFor();
                BufferedReader br4 = new BufferedReader(new FileReader(filePath4));
                String line4;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br4.close();
                        File file4 = new File(filePath4);
                        if (file4.delete()) System.out.println("File 4 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line4 = br4.readLine()) != null) {
                    if (line4.trim().startsWith("Card name:")) {
                        line4Trim = line4.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br4.close();
                File file4 = new File(filePath4);
                if (file4.delete()) System.out.println("File 4 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service5 = Executors.newCachedThreadPool();

        service5.submit(() -> {
            try {
                String filePath5 = "./src/main/resources/dxdiagOutputs/dxdiagOutput5.txt";
                ProcessBuilder pb5 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath5);
                Process p5 = pb5.start();
                p5.waitFor();
                BufferedReader br5 = new BufferedReader(new FileReader(filePath5));
                String line5;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br5.close();
                        File file5 = new File(filePath5);
                        if (file5.delete()) System.out.println("File 5 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line5 = br5.readLine()) != null) {
                    if (line5.trim().startsWith("Display Memory:")) {
                        line5Trim = line5.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br5.close();
                File file5 = new File(filePath5);
                if (file5.delete()) System.out.println("File 5 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service6 = Executors.newCachedThreadPool();

        service6.submit(() -> {
            try {
                String filePath6 = "./src/main/resources/dxdiagOutputs/dxdiagOutput6.txt";
                ProcessBuilder pb6 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath6);
                Process p6 = pb6.start();
                p6.waitFor();
                BufferedReader br6 = new BufferedReader(new FileReader(filePath6));
                String line6;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br6.close();
                        File file6 = new File(filePath6);
                        if (file6.delete()) System.out.println("File 6 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line6 = br6.readLine()) != null) {
                    if (line6.trim().startsWith("System Model:")) {
                        line6Trim = line6.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br6.close();
                File file6 = new File(filePath6);
                if (file6.delete()) System.out.println("File 6 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service7 = Executors.newCachedThreadPool();

        service7.submit(() -> {
            try {
                String filePath7 = "./src/main/resources/dxdiagOutputs/dxdiagOutput7.txt";
                ProcessBuilder pb7 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath7);
                Process p7 = pb7.start();
                p7.waitFor();
                BufferedReader br7 = new BufferedReader(new FileReader(filePath7));
                String line7;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br7.close();
                        File file7 = new File(filePath7);
                        if (file7.delete()) System.out.println("File 7 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line7 = br7.readLine()) != null) {
                    if (line7.trim().startsWith("Machine Id:")) {
                        line7Trim = line7.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br7.close();
                File file7 = new File(filePath7);
                if (file7.delete()) System.out.println("File 7 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });


        ExecutorService service8 = Executors.newCachedThreadPool();

        service8.submit(() -> {
            try {
                String filePath8 = "./src/main/resources/dxdiagOutputs/dxdiagOutput8.txt";
                ProcessBuilder pb8 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath8);
                Process p8 = pb8.start();
                p8.waitFor();
                BufferedReader br8 = new BufferedReader(new FileReader(filePath8));
                String line8;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br8.close();
                        File file8 = new File(filePath8);
                        if (file8.delete()) System.out.println("File 8 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line8 = br8.readLine()) != null) {
                    if (line8.trim().startsWith("Manufacturer:")) {
                        line8Trim = line8.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br8.close();
                File file8 = new File(filePath8);
                if (file8.delete()) System.out.println("File 8 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service9 = Executors.newCachedThreadPool();

        service9.submit(() -> {
            try {
                String filePath9 = "./src/main/resources/dxdiagOutputs/dxdiagOutput9.txt";
                ProcessBuilder pb9 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath9);
                Process p9 = pb9.start();
                p9.waitFor();
                BufferedReader br9 = new BufferedReader(new FileReader(filePath9));
                String line9;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br9.close();
                        File file9 = new File(filePath9);
                        if (file9.delete()) System.out.println("File 9 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line9 = br9.readLine()) != null) {
                    if (line9.trim().startsWith("DAC type:")) {
                        line9Trim = line9.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br9.close();
                File file9 = new File(filePath9);
                if (file9.delete()) System.out.println("File 9 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service10 = Executors.newCachedThreadPool();

        service10.submit(() -> {
            try {
                String filePath10 = "./src/main/resources/dxdiagOutputs/dxdiagOutput10.txt";
                ProcessBuilder pb10 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath10);
                Process p10 = pb10.start();
                p10.waitFor();
                BufferedReader br10 = new BufferedReader(new FileReader(filePath10));
                String line10;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br10.close();
                        File file10 = new File(filePath10);
                        if (file10.delete()) System.out.println("File 10 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line10 = br10.readLine()) != null) {
                    if (line10.trim().startsWith("Device Type:")) {
                        line10Trim = line10.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br10.close();
                File file10 = new File(filePath10);
                if (file10.delete()) System.out.println("File 10 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service11 = Executors.newCachedThreadPool();

        service11.submit(() -> {
            try {
                String filePath11 = "./src/main/resources/dxdiagOutputs/dxdiagOutput11.txt";
                ProcessBuilder pb11 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath11);
                Process p11 = pb11.start();
                p11.waitFor();
                BufferedReader br11 = new BufferedReader(new FileReader(filePath11));
                String line11;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br11.close();
                        File file11 = new File(filePath11);
                        if (file11.delete()) System.out.println("File 11 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line11 = br11.readLine()) != null) {
                    if (line11.trim().startsWith("Dedicated Memory:")) {
                        line11Trim = line11.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br11.close();
                File file11 = new File(filePath11);
                if (file11.delete()) System.out.println("File 11 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service12 = Executors.newCachedThreadPool();

        service12.submit(() -> {
            try {
                String filePath12 = "./src/main/resources/dxdiagOutputs/dxdiagOutput12.txt";
                ProcessBuilder pb12 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath12);
                Process p12 = pb12.start();
                p12.waitFor();
                BufferedReader br12 = new BufferedReader(new FileReader(filePath12));
                String line12;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br12.close();
                        File file12 = new File(filePath12);
                        if (file12.delete()) System.out.println("File 12 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line12 = br12.readLine()) != null) {
                    if (line12.trim().startsWith("Shared Memory:")) {
                        line12Trim = line12.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br12.close();
                File file12 = new File(filePath12);
                if (file12.delete()) System.out.println("File 12 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service13 = Executors.newCachedThreadPool();

        service13.submit(() -> {
            try {
                String filePath13 = "./src/main/resources/dxdiagOutputs/dxdiagOutput13.txt";
                ProcessBuilder pb13 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath13);
                Process p13 = pb13.start();
                p13.waitFor();
                BufferedReader br13 = new BufferedReader(new FileReader(filePath13));
                String line13;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br13.close();
                        File file13 = new File(filePath13);
                        if (file13.delete()) System.out.println("File 13 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line13 = br13.readLine()) != null) {
                    if (line13.trim().startsWith("Virtualization:")) {
                        line13Trim = line13.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br13.close();
                File file13 = new File(filePath13);
                if (file13.delete()) System.out.println("File 13 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service14 = Executors.newCachedThreadPool();

        service14.submit(() -> {
            try {
                String filePath14 = "./src/main/resources/dxdiagOutputs/dxdiagOutput14.txt";
                ProcessBuilder pb14 = new ProcessBuilder("cmd.exe", "/c", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath14);
                Process p14 = pb14.start();
                p14.waitFor();
                BufferedReader br14 = new BufferedReader(new FileReader(filePath14));
                String line14;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br14.close();
                        File file14 = new File(filePath14);
                        if (file14.delete()) System.out.println("File 14 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line14 = br14.readLine()) != null) {
                    if (line14.trim().startsWith("Chip type:")) {
                        line14Trim = line14.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br14.close();
                File file14 = new File(filePath14);
                if (file14.delete()) System.out.println("File 14 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        ExecutorService service15 = Executors.newCachedThreadPool();

        service15.submit(() -> {
            try {
                String filePath15 = "./src/main/resources/dxdiagOutputs/dxdiagOutput15.txt";
                ProcessBuilder pb15 = new ProcessBuilder("cmd.exe", "cmd.exe", "/c", "dxdiag", "/dontskip", "/whql:off", "/64bit", "/t", filePath15);
                Process p15 = pb15.start();
                p15.waitFor();
                BufferedReader br15 = new BufferedReader(new FileReader(filePath15));
                String line15;

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    try {
                        br15.close();
                        File file15 = new File(filePath15);
                        if (file15.delete()) System.out.println("File 15 deleted.");
                        else System.out.println("Problem");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, "Shutdown-thread"));

                while ((line15 = br15.readLine()) != null) {
                    if (line15.trim().startsWith("System Manufacturer:")) {
                        line15Trim = line15.trim();
                        runIfDxDiagFinished++;
                        if (runIfDxDiagFinished == 16) {
                            isDxDiagFinished = "yes";
                        }
                    }
                }
                br15.close();
                File file15 = new File(filePath15);
                if (file15.delete()) System.out.println("File 15 deleted.");
                else System.out.println("Problem");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

    }

}
