/*
 * EventDataStreamTimeConstraintDialog.java
 *
 * Created on January 30, 2007, 10:45 AM
 */

package edu.iisc.tdminer.gui;

import edu.iisc.tdminer.data.StateInfo;

import edu.iisc.tdminercore.data.IEventDataStream;
import edu.iisc.tdminercore.data.IEventDataStream.CONSTRAINT_MODE;
import edu.iisc.tdminercore.util.TimeConstraint;
import edu.iisc.tdminercore.util.TimeConstraint.Constraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author phreed@gmail.com
 */
public class EventDataStreamTimeConstraintDialog extends javax.swing.JDialog
{
    private static String[] columnNames = {
        "Remove", "Start", "Stop", "Load", "Prospect", "Extract"
    };
    private Class[] types = new Class [] {
	Boolean.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class
    };
      
    private TimeConstraint<CONSTRAINT_MODE> constraints;
    private StateInfo state;
    
    /** 
     * Creates new form EpisodeExportDialog 
     */
    public EventDataStreamTimeConstraintDialog(java.awt.Frame frame, boolean modal,
            StateInfo stateinfo)
    {
        super(frame, "Time Constraint Dialog", modal);
        this.state = stateinfo;
        this.constraints = stateinfo.getSession().getTimeConstraints();

        initComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600,400);
        if (frame != null)
        {
            int x = (int)(frame.getLocation().getX() + (frame.getSize().getWidth() - getSize().getWidth())/2);
            int y = (int)(frame.getLocation().getY() + (frame.getSize().getHeight() - getSize().getHeight())/2);
            setLocation(x,y);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupScopeMode = new javax.swing.ButtonGroup();
        jPanelAction = new javax.swing.JPanel();
        jButtonAddConstraint = new javax.swing.JButton();
        jCheckBoxActivation = new javax.swing.JCheckBox();
        jButtonClose = new javax.swing.JButton();
        jScrollPaneTimeFrames = new javax.swing.JScrollPane();
        jTableTimeFrame = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Time Frame Constraints");
        jPanelAction.setLayout(new java.awt.GridBagLayout());

        jButtonAddConstraint.setText("Add");
        jButtonAddConstraint.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonAddConstraint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConstraintActionPerformed(evt);
            }
        });

        jPanelAction.add(jButtonAddConstraint, new java.awt.GridBagConstraints());

        jCheckBoxActivation.setSelected(true);
        jCheckBoxActivation.setText("Activate");
        jCheckBoxActivation.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxActivation.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxActivation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActivationActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelAction.add(jCheckBoxActivation, gridBagConstraints);

        jButtonClose.setText("Close");
        jButtonClose.setToolTipText("Close the dialog");
        jButtonClose.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonClose.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jPanelAction.add(jButtonClose, new java.awt.GridBagConstraints());

        theLocalTableModel = new LocalTableModel();
        jTableTimeFrame.setModel(theLocalTableModel);
        jScrollPaneTimeFrames.setViewportView(jTableTimeFrame);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jScrollPaneTimeFrames, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanelAction, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelAction, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPaneTimeFrames, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddConstraintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConstraintActionPerformed
        theLocalTableModel.addRow();
    }//GEN-LAST:event_jButtonAddConstraintActionPerformed

    private void jCheckBoxActivationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActivationActionPerformed
        try {
            this.constraints.isActive = jCheckBoxActivation.isSelected();
            if (this.state == null) return;
            this.state.getSession().setTimeConstraints(this.constraints);
        }
        catch (Exception ex) {
            System.out.println("Constraint update failed: " + ex.getMessage());
        }
    }//GEN-LAST:event_jCheckBoxActivationActionPerformed

    
    /**
     * The apply button applies the time constraints to the IEventDataStream.
     */
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupScopeMode;
    private javax.swing.JButton jButtonAddConstraint;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JCheckBox jCheckBoxActivation;
    private javax.swing.JPanel jPanelAction;
    private javax.swing.JScrollPane jScrollPaneTimeFrames;
    private javax.swing.JTable jTableTimeFrame;
    // End of variables declaration//GEN-END:variables
    private LocalTableModel theLocalTableModel;
    
    public class LocalTableModel 
            extends javax.swing.table.AbstractTableModel
    {
        public static final int REMOVE_COLUMN = 0;
        public static final int START_COLUMN = 1;
        public static final int STOP_COLUMN = 2;
        public static final int LOAD_ACTIVATION_COLUMN = 3;
        public static final int PROSPECT_ACTIVATION_COLUMN = 4;
        public static final int EXTRACT_ACTIVATION_COLUMN = 5;

        public LocalTableModel()
        {
            //this.parent = parent;
        }

        public int getColumnCount()
        {
            return columnNames.length;
        }

        public int getRowCount()
        {
            if (constraints != null) return constraints.getSize();
            return 0;
        }

        public String getColumnName(int col) { return columnNames[col]; }

        public Object getValueAt(int row, int col)
        {
            TimeConstraint<CONSTRAINT_MODE>.Constraint constraint 
                    = constraints.getAt(row);
            switch (col) {
                case REMOVE_COLUMN:
                    return false;
                case START_COLUMN:
                    return constraint.getTimeStart();
                case STOP_COLUMN:
                    return constraint.getTimeStop();
                case LOAD_ACTIVATION_COLUMN:
                    return constraint.isActivated(CONSTRAINT_MODE.LOAD);
                case PROSPECT_ACTIVATION_COLUMN:
                    return constraint.isActivated(CONSTRAINT_MODE.PROSPECT);
                case EXTRACT_ACTIVATION_COLUMN:
                    return constraint.isActivated(CONSTRAINT_MODE.EXTRACT);
            }
            return null;
        }

        /*
         * JTable uses this method to determine the default renderer/editor
         * editor for each cell. 
         */
        public Class getColumnClass(int col) { return types [col]; }

        public boolean isCellEditable(int row, int col) { return true; } 

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col)
        {
            TimeConstraint<CONSTRAINT_MODE>.Constraint constraint 
                    = constraints.getAt(row);
            switch (col) {
                case REMOVE_COLUMN: {
                    constraints.remove(row);
                } break;
                
                case START_COLUMN: {
                    double val = ((Double)value).doubleValue();
                    constraint.setTimeStart(val);
                } break;
                case STOP_COLUMN: {
                    double val = ((Double)value).doubleValue();
                    constraint.setTimeStop(val);
                } break;
               
                case EXTRACT_ACTIVATION_COLUMN: {
                    boolean val = ((Boolean)value).booleanValue();
                    constraint.setActivation(CONSTRAINT_MODE.EXTRACT, val);
                } break;
                case PROSPECT_ACTIVATION_COLUMN: {
                    boolean val = ((Boolean)value).booleanValue();
                    constraint.setActivation(CONSTRAINT_MODE.PROSPECT, val);
                } break;
                case LOAD_ACTIVATION_COLUMN: {
                    boolean val = ((Boolean)value).booleanValue();
                    constraint.setActivation(CONSTRAINT_MODE.LOAD, val);
                } break;
                default: break;
            }
            this.fireTableDataChanged();
        }
        
        public void addRow() {
            constraints.add(CONSTRAINT_MODE.class);
            this.fireTableDataChanged();
        }
    }
}
