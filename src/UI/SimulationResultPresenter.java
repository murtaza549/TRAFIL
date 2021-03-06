/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utilities.ExportData;
import utilities.PathLocator;

/**
 *
 * @author charalampi
 */
public class SimulationResultPresenter extends javax.swing.JFrame {

    /**
     * Creates new form VideoSimulationResult
     */
    ArrayList<File> simulationOutputFiles = new ArrayList<File>();
    public DefaultListModel model = new DefaultListModel();
    String simulationResult;
    TRAFIL mainFrame;
    Map<String, ArrayList<File>> outputs;
    String resultsFolderPath;

    public SimulationResultPresenter(TRAFIL mainFrame, Map<String, ArrayList<File>> simulationOutputFiles, String resultsPath) {
        initComponents();
        this.setVisible(true);
        this.mainFrame = mainFrame;
        outputs = simulationOutputFiles;
        resultsFolderPath = resultsPath;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveFilesTo = new javax.swing.JButton();
        deleteSelectedButton = new javax.swing.JButton();
        deleteAllButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultFilesList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        videoSimulationOutput = new javax.swing.JTextArea();
        clearResults = new javax.swing.JButton();
        saveResults = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultsPath = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simulation Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), java.awt.Color.blue)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simulation Output Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), java.awt.Color.blue)); // NOI18N

        saveFilesTo.setText("Save to");
        saveFilesTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFilesToActionPerformed(evt);
            }
        });

        deleteSelectedButton.setText("Delete Selected");
        deleteSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedButtonActionPerformed(evt);
            }
        });

        deleteAllButton.setText("Delete All");
        deleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(resultFilesList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 339, Short.MAX_VALUE)
                        .addComponent(deleteAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveFilesTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteSelectedButton)
                        .addGap(2, 2, 2))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteAllButton)
                    .addComponent(saveFilesTo)
                    .addComponent(deleteSelectedButton))
                .addContainerGap())
        );

        jLabel1.setText("The simulation output files are located at:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simulation Output", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), java.awt.Color.blue)); // NOI18N

        videoSimulationOutput.setColumns(20);
        videoSimulationOutput.setEditable(false);
        videoSimulationOutput.setRows(5);
        jScrollPane1.setViewportView(videoSimulationOutput);

        clearResults.setText("Clear");
        clearResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearResultsActionPerformed(evt);
            }
        });

        saveResults.setText("Save");
        saveResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveResults)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearResults)
                    .addComponent(saveResults))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resultsPath.setColumns(1);
        resultsPath.setEditable(false);
        resultsPath.setRows(1);
        jScrollPane3.setViewportView(resultsPath);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearResultsActionPerformed
        videoSimulationOutput.setText("");
    }//GEN-LAST:event_clearResultsActionPerformed

    private void saveResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveResultsActionPerformed
        ExportData exportResult = new ExportData();
        exportResult.exportSimulationResults(simulationResult);
    }//GEN-LAST:event_saveResultsActionPerformed

    private void deleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllButtonActionPerformed
        File dir = new File(resultsFolderPath);
        File[] childrenFiles = dir.listFiles();
        int i = 0;
        for (File file : childrenFiles) {
            if (file.delete()) {
                i++;
            }
        }
        if (outputs != null) {
            outputs.clear();
            mainFrame.updateVideoSimulationResults(outputs);
        }

        model.clear();
        JOptionPane.showMessageDialog(null, i + " files deleted successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteAllButtonActionPerformed

    private void saveFilesToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFilesToActionPerformed
        int[] selectedFiles = resultFilesList.getSelectedIndices();
        JFileChooser saveOutputChooser = new JFileChooser();
        saveOutputChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = saveOutputChooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                for (int i = 0; i < selectedFiles.length; i++) {
                    Object selectedFile = resultFilesList.getModel().getElementAt(selectedFiles[i]);
                    File sourceFile = new File(resultsFolderPath + selectedFile.toString());
                    File outputFile = new File(saveOutputChooser.getSelectedFile().getCanonicalPath().toString() + "/" + selectedFile.toString());
                    FileReader in = new FileReader(sourceFile);
                    FileWriter out = new FileWriter(outputFile);
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                    in.close();
                    out.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TRAFIL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveFilesToActionPerformed

    private void deleteSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedButtonActionPerformed
        int[] selectedFiles = resultFilesList.getSelectedIndices();
        int i = 0;
        for (int j = (selectedFiles.length - 1); j >= 0; j--) {
            Object selectedFile = resultFilesList.getModel().getElementAt(selectedFiles[j]);
            File file = new File(resultsFolderPath + selectedFile.toString());
            if (file.delete()) {
                model.remove(model.indexOf(selectedFile));
                if (outputs != null) {
                    Set<Map.Entry<String, ArrayList<File>>> set = outputs.entrySet();
                    for (Map.Entry<String, ArrayList<File>> entry : set) {
                        ArrayList<File> tempList = entry.getValue();
                        for (int fileC = (tempList.size() - 1); fileC >= 0; fileC--) {
                            if (tempList.get(fileC).getName().equalsIgnoreCase(selectedFile.toString())) {
                                //JOptionPane.showMessageDialog(this, "Deleting:" + selectedFile + "Deleting:" + tempList.get(fileC).getName());
                                tempList.remove(fileC);
                                //overwriting the current Map entry for the specific key.
                                outputs.put(entry.getKey(), tempList);
                                break;
                            }
                        }
                    }
                }
                i++;
            }
        }
        if (outputs != null) {
            mainFrame.updateVideoSimulationResults(outputs);
        }
        JOptionPane.showMessageDialog(null, i + " files deleted successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteSelectedButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearResults;
    private javax.swing.JButton deleteAllButton;
    private javax.swing.JButton deleteSelectedButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList resultFilesList;
    private javax.swing.JTextArea resultsPath;
    private javax.swing.JButton saveFilesTo;
    private javax.swing.JButton saveResults;
    private javax.swing.JTextArea videoSimulationOutput;
    // End of variables declaration//GEN-END:variables

    public void setSimulationOuput(String result) {
        this.simulationResult = result;
        videoSimulationOutput.setText(result);
        retrieveOutputtedFiles();
    }

    public void retrieveOutputtedFiles() {
        File dir = new File(resultsFolderPath);
        File[] childrenFiles = dir.listFiles();
        model.clear();
        for (int i = 0; i < childrenFiles.length; i++) {
            if (childrenFiles[i].isFile()) {
                simulationOutputFiles.add(childrenFiles[i]);
            }
        }
        for (File file : simulationOutputFiles) {
            model.addElement(file.getName());
        }
        resultFilesList.setModel(model);
        resultsPath.setText(resultsFolderPath);
    }
}
