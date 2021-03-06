package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import metrics.Metrics;
import metrics.GeneralInformation;
import metrics.GeneralSimulationInformation;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import src.MetaDataHandler;
import src.TraceFileInfo;

/**
 * This class handles the export operations that are requested from the GUI.
 *
 * @author charalampi
 */
public class ExportData {

    //private String path = getClass().getClassLoader().getResource(".").getPath();
    private String path = System.getProperty("user.dir");
    private TraceFileInfo traceFile;
    private Statement st;
    private MetaDataHandler metaHandler;

    public ExportData() {
    }

    public ExportData(TraceFileInfo TraceFile, Statement st, MetaDataHandler metahandler) {
        this.traceFile = TraceFile;
        this.st = st;
        this.metaHandler = metahandler;
    }

    /**
     * This method saves a chart in jpeg format.
     *
     * @param chart the chart to be saved.
     * @param chartType String, the type of chart
     * @return boolean, true if the transfer was successful, false otherwise
     */
    public boolean exportChart(JFreeChart chart, String chartType) {
        try {
            if (traceFile.getTraceFileName() == null) {
                return false;
            }
            File file = createFile(".jpg");
            if (file == null) {
                return false;
            }
            ChartUtilities.saveChartAsJPEG(file, chart, 500, 300);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method exports the contents of the trace file to an excel file.
     *
     * @return boolean, true if the transfer was successful, false otherwise
     */
    public boolean exportToExcell() {
        if (traceFile.getTraceFileName() == null) {
            return false;
        }
        File file = createFile(".xls");
        if (file == null) {
            return false;
        }
        transferData(file, ".xls");
        return true;
    }

    /**
     * This method exports the contents of the trace file to a text file.
     *
     * @return boolean, true if the transfer was successful, false otherwise
     */
    public boolean exportToTextFile() {
        if (traceFile.getTraceFileName() == null) {
            return false;
        }
        File file = createFile(".txt");
        if (file == null) {
            return false;
        }
        transferData(file, ".txt");
        return true;
    }

    /**
     * This method exports the simulation information of a trace file to a text
     * file.
     *
     * @param simInfo an instance of the GeneralSimulationInformation class
     * @return boolean, true if the transfer was successful, false otherwise
     */
    public boolean exportSimulationInformation(GeneralSimulationInformation simInfo) {
        try {

            if (traceFile.getTraceFileName() == null) {
                return false;
            }
            File file = createFile(".txt");
            if (file == null) {
                return false;
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("Start Time: " + simInfo.getStartTime() + "\r\n");
            out.write("End Time: " + simInfo.getEndTime() + "\r\n");
            out.write("Overall Time: " + simInfo.getSimulationTime() + "\r\n");
            out.write("Number of Nodes: " + simInfo.getNumberOfNodes() + "\r\n");
            out.write("Number of Sending Nodes: " + simInfo.getNumberOfSendingNodes() + "\r\n");
            out.write("Average Packet Size: " + simInfo.getAveragePacketSize() + "\r\n");
            out.write("Maximum Packet Size: " + simInfo.getMaximumPacketSize() + "\r\n");
            out.write("Minimum Packet Size: " + simInfo.getMinimumPacketSize() + "\r\n");
            out.write("Number of Generated Packets: " + simInfo.getNumberOfGeneratedPackets() + "\r\n");
            out.write("Number of Generated Bytes: " + simInfo.getNumberOfGeneratedBytes() + "\r\n");
            out.write("Number of Sent Packets: " + simInfo.getNumberOfSentPackets() + "\r\n");
            out.write("Number of Sent Bytes: " + simInfo.getNumberOfSentBytes() + "\r\n");
            out.write("Number of Received Packets: " + simInfo.getNumberOfReceivedPackets() + "\r\n");
            out.write("Number of Received Bytes: " + simInfo.getNumberOfReceivedBytes() + "\r\n");
            out.write("Number of Forwarded Packets: " + simInfo.getNumberOfForwardedPackets() + "\r\n");
            out.write("Number of Forwarded Bytes: " + simInfo.getNumberOfForwardedBytes() + "\r\n");
            out.write("Number of Dropped Packets: " + simInfo.getNumberOfDroppedPackets() + "\r\n");
            out.write("Number of Dropped Bytes: " + simInfo.getNumberOfDroppedBytes() + "\r\n");
            out.write("Number of Generated Packets AGT: " + simInfo.getGeneratedPacketsAGT() + "\r\n");
            out.write("Number of Generated Packets RTR: " + simInfo.getGeneratedPacketsRTR() + "\r\n");
            out.write("Number of Generated Packets MAC: " + simInfo.getGeneratedPacketsMAC() + "\r\n");
            out.write("Number of Generated Bytes AGT: " + simInfo.getGeneratedPacketsSizeAGT() + "\r\n");
            out.write("Number of Generated Bytes RTR: " + simInfo.getGeneratedPacketsSizeRTR() + "\r\n");
            out.write("Number of Generated Bytes MAC: " + simInfo.getGeneratedPacketsSizeMAC() + "\r\n");
            out.write("Number of Received Packets AGT: " + simInfo.getReceivedPacketsAGT() + "\r\n");
            out.write("Number of Received Packets RTR: " + simInfo.getReceivedPacketsRTR() + "\r\n");
            out.write("Number of Received Packets RTR: " + simInfo.getReceivedPacketsMAC() + "\r\n");
            out.write("Number of Received Bytes AGT: " + simInfo.getReceivedPacketsSizeAGT() + "\r\n");
            out.write("Number of Received Bytes RTR: " + simInfo.getReceivedPacketsSizeRTR() + "\r\n");
            out.write("Number of Received Bytes MAC: " + simInfo.getReceivedPacketsSizeRTR() + "\r\n");

            out.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method exports the metrics calculated for a trace file to a text
     * file.
     *
     * @param metric an instance of the Metrics class
     * @return boolean, true if the transfer was successful, false otherwise
     */
    public boolean exportMetrics(Metrics metric) {
        try {

            if (traceFile.getTraceFileName() == null) {
                return false;
            }
            File file = createFile("Metrics.txt");
            if (file == null) {
                return false;
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write("Throughput(packets/sec): " + metric.getThroughput() + "\r\n");
            out.write("Minimum End to End Delay(sec): " + metric.getMinEndToEndDelay() + "\r\n");
            out.write("Maximum End to End Delay(sec): " + metric.getMaxEndToEndDealy() + "\r\n");
            out.write("Average End to End Delay(sec): " + metric.getAverageEndToEndDelay() + "\r\n");
            out.write("Delay Jitter(sec): " + metric.getDelayJitter() + "\r\n");
            out.write("Minimum Delay Jitter(sec): " + metric.getMinDelayJitter() + "\r\n");
            out.write("Maximum Delay Jitter(sec): " + metric.getMaxDelayJitter() + "\r\n");
            out.write("Average Delay Jitter(sec): " + metric.getAverageDelayJitter() + "\r\n");

            out.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean exportSimulationResults(String message) {
        try {
            File file = createFile(".txt");
            if (file == null) {
                return false;
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(message);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    /**
     * This method is called by all other methods of this class when they need
     * to create the file to export the data. When called it creates the
     * appropriate file.
     *
     * @param extension String, the type of file to be created
     * @return File, the reference to the file created
     */
    private File createFile(String extension) {
        File file = null;
        final JFileChooser fc = new JFileChooser(PathLocator.getExportPath(System.getProperty("user.dir")));
        try {
            int returnVal = fc.showSaveDialog(fc);
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                return null;
            }
            path = fc.getSelectedFile() + extension;
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("[" + GeneralInformation.NOW() + "] Created new empty file.");
                return file;
            } else {
                int response = JOptionPane.showConfirmDialog(null, "<html>The file you have selected already exists.<br/>Do you want to ovewrite it?</html>");
                if (response == 0) {
                    file.delete();
                    System.out.println("[" + GeneralInformation.NOW() + "] Discarding previous file.");
                    file.createNewFile();
                    System.out.println("[" + GeneralInformation.NOW() + "] Created new empty file.");
                    return file;
                } else {
                    return null;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            return file;
        }
    }

    /**
     * This method is used to export the data of a trace file to an external
     * source and is called by the methods that transfer the data of the trace
     * file.
     *
     * @param file the file to which the data will be exported
     * @param extension the type of file that the data will be exported.
     */
    private void transferData(File file, String extension) {
        try {
            String columnSpace;
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            ResultSet rs;
            out.flush();
            int length = -1;
            int tempCounter = 0;
            if (extension.equalsIgnoreCase(".txt")) {
                columnSpace = "\t";
            } else {
                columnSpace = " ";
            }
            st.execute("select linecounter from tracefiles where name='" + traceFile.getTraceFileName() + "'");
            rs = st.getResultSet();
            while (rs.next()) {
                length = rs.getInt(1);
            }
            if ((length != -1) && (length <= 10000)) {
                st.execute("select * from " + traceFile.getTraceFileName());
                rs = st.getResultSet();
                while (rs.next()) {
                    for (int i = 0; i < metaHandler.getModel().length; i++) {
                        out.write(rs.getString(i + 2) + "\t");
                    }
                    out.write("\n");
                }
                out.close();
            } else {
                while (length > 0) {
                    st.execute("select * from " + traceFile.getTraceFileName() + " limit " + tempCounter + "," + (tempCounter + 10000) + ";");
                    rs = st.getResultSet();
                    while (rs.next()) {
                        for (int i = 0; i < metaHandler.getModel().length; i++) {
                            out.write(rs.getString(i + 2) + columnSpace);
                        }
                        out.write("\n");
                    }
                    length -= 10000;
                    tempCounter += 10001;
                }
                out.close();
            }

            System.out.println("[" + GeneralInformation.NOW() + "] Succesfully exported data.");
        } catch (IOException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex2) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex2);
        }

    }
}
