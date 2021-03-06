/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Simulations.TclDesignNode;
import java.util.ArrayList;

/**
 *
 * @author Drakoulelis
 */
public class NodePropertiesWindow extends javax.swing.JFrame {

    private static int agentID = 0;
    private static int appID = 0;
    private TclDesignNode node;

    /**
     * Creates new form NodePropertiesWindow
     */
    public NodePropertiesWindow(TclDesignNode node) {
        initComponents();
        nodeParametersPanel.setVisible(false);
        cbrParametersPanel.setVisible(true);
        ftpParametersPanel.setVisible(false);
        expoParametersPanel.setVisible(false);
        nodeNameField.setText(null);

        this.node = node;
        node.setAttachedApp(appBox.getSelectedItem().toString().toLowerCase() + appID++);
    }

    public NodePropertiesWindow(TclDesignNode node, String agent, String agentType, String app, String appType, ArrayList<String[]> settings) {
        initComponents();

        this.node = node;
        nodeNameField.setText(node.getName());
        switch (agentType) {
            case "TCP":
                agentBox.setSelectedItem("TCP");
                break;
            case "UDP":
                agentBox.setSelectedItem("UDP");
                break;
            default:
                agentBox.setSelectedItem("Null");
                break;
        }

        node.setAttachedAgent(agent);
        if (app != null) {
            node.setAttachedApp(app);
            if (appType.contains("Telnet")) {
                appBox.setSelectedItem("Telnet");
            } else if (appType.contains("FTP")) {
                appBox.setSelectedItem("FTP");
            } else if (appType.contains("Pareto")) {
                appBox.setSelectedItem("Pareto");
            } else if (appType.contains("Exponential")) {
                appBox.setSelectedItem("Exponential");
            } else if (appType.contains("Trace")) {
                appBox.setSelectedItem("Trace");
            } else {
                appBox.setSelectedItem("CBR");
            }

            for (String[] str : settings) {
                switch (str[0]) {
                    case "packetSize":
                        packetSize.setText(str[1]);
                        expoPacketSize.setText(str[1]);
                        break;
                    case "rate":
                        sendingRate.setText(str[1]);
                        rateRadioButton.setSelected(true);
                        expoSendingRate.setText(str[1]);
                        break;
                    case "interval":
                        sendingInterval.setText(str[1]);
                        intervalRadioButton.setSelected(true);
                        telnetInterval.setText(str[1]);
                        break;
                    case "random":
                        if (str[1].equals("1")) {
                            randomBox.setSelected(true);
                        }
                        break;
                    case "maxpkts":
                        FTPpacketNumber.setText(str[1]);
                        break;
                    case "burst_time":
                        burstTime.setText(str[1]);
                        break;
                    case "idle_time":
                        idleTime.setText(str[1]);
                        break;
                    case "shape":
                        paretoShape.setText(str[1]);
                        break;
                    case "start":
                        appStartTime.setText(str[1]);
                    case "stop":
                        appStopTime.setText(str[1]);
                    default:
                        break;
                }
            }
        }
    }

    public final void setNewAgent() {
        String selectedAgent = (String) agentBox.getSelectedItem();
        node.setAttachedAgent(selectedAgent.toLowerCase() + agentID++);
        if ("Null".equals(selectedAgent)) {
            nodeParametersPanel.setVisible(false);
            try {
                node.removeFromConnectedAgents();
                for (TclDesignNode adjacentNode : node.getAdjacentNodes()) {
                    adjacentNode.updateAdjacentNodes();
                }
            } catch (Exception ex) {
            }
        } else {
            nodeParametersPanel.setVisible(true);
            try {
                node.addToConnectedAgents();
                for (TclDesignNode adjacentNode : node.getAdjacentNodes()) {
                    adjacentNode.updateAdjacentNodes();
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbrRateIntervalGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        agentBox = new javax.swing.JComboBox();
        nodeParametersPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        appBox = new javax.swing.JComboBox();
        cbrParametersPanel = new javax.swing.JPanel();
        rateRadioButton = new javax.swing.JRadioButton();
        sendingRate = new javax.swing.JTextField();
        intervalRadioButton = new javax.swing.JRadioButton();
        sendingInterval = new javax.swing.JTextField();
        randomBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        packetSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        packetNumberBox = new javax.swing.JTextField();
        ftpParametersPanel = new javax.swing.JPanel();
        FTPpacketNumberLabel = new javax.swing.JLabel();
        FTPpacketNumber = new javax.swing.JTextField();
        telnetIntervalLabel = new javax.swing.JLabel();
        telnetInterval = new javax.swing.JTextField();
        expoParametersPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        expoSendingRate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        expoPacketSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        burstTime = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        idleTime = new javax.swing.JTextField();
        shapeLabel = new javax.swing.JLabel();
        paretoShape = new javax.swing.JTextField();
        timeParametersPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        appStartTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        appStopTime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nodeNameField = new javax.swing.JTextField();

        setTitle("Node Parameters");
        setAlwaysOnTop(true);

        jLabel1.setText("Agent:");

        agentBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Null", "TCP", "UDP" }));
        agentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agentBoxActionPerformed(evt);
            }
        });

        nodeParametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Application:");

        appBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CBR", "Telnet", "FTP", "Pareto", "Exponential", "Trace" }));
        appBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appBoxActionPerformed(evt);
            }
        });

        cbrRateIntervalGroup.add(rateRadioButton);
        rateRadioButton.setText("Rate:");

        cbrRateIntervalGroup.add(intervalRadioButton);
        intervalRadioButton.setText("Interval:");

        randomBox.setText("Random noise");

        jLabel3.setText("Packet Size:");

        jLabel4.setText("Number of Packets:");

        javax.swing.GroupLayout cbrParametersPanelLayout = new javax.swing.GroupLayout(cbrParametersPanel);
        cbrParametersPanel.setLayout(cbrParametersPanelLayout);
        cbrParametersPanelLayout.setHorizontalGroup(
            cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbrParametersPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(randomBox)
                    .addGroup(cbrParametersPanelLayout.createSequentialGroup()
                        .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(intervalRadioButton)
                            .addComponent(rateRadioButton))
                        .addGap(79, 79, 79)
                        .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sendingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendingInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(packetSize, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(packetNumberBox))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        cbrParametersPanelLayout.setVerticalGroup(
            cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbrParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rateRadioButton)
                    .addComponent(sendingRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(packetSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cbrParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intervalRadioButton)
                    .addComponent(sendingInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(packetNumberBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FTPpacketNumberLabel.setText("Number of Packets:");

        telnetIntervalLabel.setText("Interval:");

        javax.swing.GroupLayout ftpParametersPanelLayout = new javax.swing.GroupLayout(ftpParametersPanel);
        ftpParametersPanel.setLayout(ftpParametersPanelLayout);
        ftpParametersPanelLayout.setHorizontalGroup(
            ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ftpParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FTPpacketNumberLabel)
                    .addComponent(telnetIntervalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telnetInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FTPpacketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ftpParametersPanelLayout.setVerticalGroup(
            ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ftpParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FTPpacketNumberLabel)
                    .addComponent(FTPpacketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ftpParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telnetIntervalLabel)
                    .addComponent(telnetInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Rate:");

        jLabel10.setText("Packet Size:");

        jLabel11.setText("Burst time:");

        jLabel12.setText("Idle time:");

        shapeLabel.setText("Shape:");

        javax.swing.GroupLayout expoParametersPanelLayout = new javax.swing.GroupLayout(expoParametersPanel);
        expoParametersPanel.setLayout(expoParametersPanelLayout);
        expoParametersPanelLayout.setHorizontalGroup(
            expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expoParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expoParametersPanelLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(116, 116, 116))
                        .addGroup(expoParametersPanelLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(75, 75, 75)))
                    .addGroup(expoParametersPanelLayout.createSequentialGroup()
                        .addComponent(shapeLabel)
                        .addGap(106, 106, 106)))
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(paretoShape, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(burstTime, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(expoSendingRate))
                .addGap(18, 18, 18)
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idleTime, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(expoPacketSize))
                .addContainerGap())
        );
        expoParametersPanelLayout.setVerticalGroup(
            expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expoParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(expoSendingRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(expoPacketSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(burstTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(idleTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expoParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shapeLabel)
                    .addComponent(paretoShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Start time:");

        appStartTime.setText("0.5");

        jLabel7.setText("Stop time:");

        appStopTime.setText("1.0");

        javax.swing.GroupLayout timeParametersPanelLayout = new javax.swing.GroupLayout(timeParametersPanel);
        timeParametersPanel.setLayout(timeParametersPanelLayout);
        timeParametersPanelLayout.setHorizontalGroup(
            timeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(78, 78, 78)
                .addComponent(appStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(98, 98, 98)
                .addComponent(appStopTime, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );
        timeParametersPanelLayout.setVerticalGroup(
            timeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(appStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(appStopTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout nodeParametersPanelLayout = new javax.swing.GroupLayout(nodeParametersPanel);
        nodeParametersPanel.setLayout(nodeParametersPanelLayout);
        nodeParametersPanelLayout.setHorizontalGroup(
            nodeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cbrParametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ftpParametersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(expoParametersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeParametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nodeParametersPanelLayout.setVerticalGroup(
            nodeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeParametersPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(nodeParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(appBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbrParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftpParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expoParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Name:");

        nodeNameField.setEditable(false);
        nodeNameField.setText("unnamed node");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nodeParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nodeNameField)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nodeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(agentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nodeParametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agentBoxActionPerformed
        setNewAgent();
    }//GEN-LAST:event_agentBoxActionPerformed

    private void appBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appBoxActionPerformed
        String selectedApp = (String) appBox.getSelectedItem();
        node.setAttachedApp(selectedApp.toLowerCase() + appID++);
        if (selectedApp.equals("CBR")) {
            cbrParametersPanel.setVisible(true);
            ftpParametersPanel.setVisible(false);
            expoParametersPanel.setVisible(false);
            timeParametersPanel.setVisible(true);
        } else if (selectedApp.equals("FTP")) {
            cbrParametersPanel.setVisible(false);
            ftpParametersPanel.setVisible(true);
            expoParametersPanel.setVisible(false);
            timeParametersPanel.setVisible(true);
            FTPpacketNumber.setVisible(true);
            FTPpacketNumberLabel.setVisible(true);
            telnetIntervalLabel.setVisible(false);
            telnetInterval.setVisible(false);
        } else if (selectedApp.equals("Exponential")) {
            cbrParametersPanel.setVisible(false);
            ftpParametersPanel.setVisible(false);
            expoParametersPanel.setVisible(true);
            timeParametersPanel.setVisible(true);
            paretoShape.setVisible(false);
            shapeLabel.setVisible(false);
        } else if (selectedApp.equals("Trace")) {
            cbrParametersPanel.setVisible(false);
            ftpParametersPanel.setVisible(false);
            expoParametersPanel.setVisible(false);
            timeParametersPanel.setVisible(false);
        } else if (selectedApp.equals("Telnet")) {
            cbrParametersPanel.setVisible(false);
            ftpParametersPanel.setVisible(true);
            expoParametersPanel.setVisible(false);
            timeParametersPanel.setVisible(true);
            telnetIntervalLabel.setVisible(false);
            telnetInterval.setVisible(false);
            FTPpacketNumber.setVisible(false);
            FTPpacketNumberLabel.setVisible(false);
            telnetInterval.setVisible(true);
            telnetIntervalLabel.setVisible(true);
        } else if (selectedApp.equals("Pareto")) {
            cbrParametersPanel.setVisible(false);
            ftpParametersPanel.setVisible(false);
            expoParametersPanel.setVisible(true);
            timeParametersPanel.setVisible(true);
            paretoShape.setVisible(true);
            shapeLabel.setVisible(true);
        }
    }//GEN-LAST:event_appBoxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FTPpacketNumber;
    private javax.swing.JLabel FTPpacketNumberLabel;
    private javax.swing.JComboBox agentBox;
    private javax.swing.JComboBox appBox;
    private javax.swing.JTextField appStartTime;
    private javax.swing.JTextField appStopTime;
    private javax.swing.JTextField burstTime;
    private javax.swing.JPanel cbrParametersPanel;
    private javax.swing.ButtonGroup cbrRateIntervalGroup;
    private javax.swing.JTextField expoPacketSize;
    private javax.swing.JPanel expoParametersPanel;
    private javax.swing.JTextField expoSendingRate;
    private javax.swing.JPanel ftpParametersPanel;
    private javax.swing.JTextField idleTime;
    private javax.swing.JRadioButton intervalRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nodeNameField;
    private javax.swing.JPanel nodeParametersPanel;
    private javax.swing.JTextField packetNumberBox;
    private javax.swing.JTextField packetSize;
    private javax.swing.JTextField paretoShape;
    private javax.swing.JCheckBox randomBox;
    private javax.swing.JRadioButton rateRadioButton;
    private javax.swing.JTextField sendingInterval;
    private javax.swing.JTextField sendingRate;
    private javax.swing.JLabel shapeLabel;
    private javax.swing.JTextField telnetInterval;
    private javax.swing.JLabel telnetIntervalLabel;
    private javax.swing.JPanel timeParametersPanel;
    // End of variables declaration//GEN-END:variables

    public JCheckBox getRandomBox() {
        return randomBox;
    }

    public JTextField getSendingInterval() {
        return sendingInterval;
    }

    public JTextField getSendingRate() {
        return sendingRate;
    }

    public JRadioButton getRateRadioButton() {
        return rateRadioButton;
    }

    public JTextField getPacketNumberBox() {
        return packetNumberBox;
    }

    public JTextField getPacketSize() {
        return packetSize;
    }

    public JTextField getAppStartTime() {
        return appStartTime;
    }

    public JTextField getAppStopTime() {
        return appStopTime;
    }

    public JComboBox getAgentBox() {
        return agentBox;
    }

    public JComboBox getAppBox() {
        return appBox;
    }

    public JTextField getNodeNameField() {
        return nodeNameField;
    }

    public JTextField getTelnetInterval() {
        return telnetInterval;
    }

    public JTextField getFTPpacketNumber() {
        return FTPpacketNumber;
    }

    public JTextField getBurstTime() {
        return burstTime;
    }

    public JTextField getExpoPacketSize() {
        return expoPacketSize;
    }

    public JTextField getExpoSendingRate() {
        return expoSendingRate;
    }

    public JTextField getIdleTime() {
        return idleTime;
    }

    public JTextField getParetoShape() {
        return paretoShape;
    }
}
