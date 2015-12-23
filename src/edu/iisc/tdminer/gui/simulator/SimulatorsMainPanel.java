/*
 * SimulatorsMainPanel.java
 *
 * Created on March 30, 2006, 2:06 PM
 */

package edu.iisc.tdminer.gui.simulator;

import edu.iisc.tdminer.data.StateInfo;
import edu.iisc.tdminer.gui.ITaskPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author  Deb
 */
public class SimulatorsMainPanel extends javax.swing.JPanel implements ITaskPanel
{
    private PoissonSimulatorComponent poissonSimulator;
    private RigatSimulatorComponent rigatSimulator;
    private IzhikevichSimulatorComponent izhikevichSimulator;
    
    private StateInfo stateInfo;
    private JLabel jLabelStatus;
    private JFrame frame;   
    
    /** Creates new form SimulatorsMainPanel */
    public SimulatorsMainPanel()
    {
	initComponents();
        poissonSimulator = new PoissonSimulatorComponent();
        rigatSimulator = new RigatSimulatorComponent();
        izhikevichSimulator = new IzhikevichSimulatorComponent();
        jTabbedPaneSimulators.addTab("Poisson Model", poissonSimulator);
        jTabbedPaneSimulators.addTab("Rigat Model", rigatSimulator);
        jTabbedPaneSimulators.addTab("Izhikevich Model", izhikevichSimulator);
        add(jTabbedPaneSimulators, java.awt.BorderLayout.CENTER);        
    }
    
    public void registerAsView(JPanel view) {}
    
    public void setStateInfo(StateInfo stateInfo)
    {
	this.stateInfo = stateInfo;
        for (int i = 0; i < jTabbedPaneSimulators.getTabCount(); i++)
        {
            ISimulatorPanel panel = (ISimulatorPanel)jTabbedPaneSimulators.getComponentAt(i);
            panel.setStateInfo(stateInfo);
        }
    }
    
    public void setJLabelStatus(JLabel jLabelStatus)
    {
	this.jLabelStatus = jLabelStatus;
        for (int i = 0; i < jTabbedPaneSimulators.getTabCount(); i++)
        {
            ISimulatorPanel panel = (ISimulatorPanel)jTabbedPaneSimulators.getComponentAt(i);
            panel.setJLabelStatus(jLabelStatus);
            
        }
    }
    
    public void setFrame(JFrame frame)
    {
	this.frame = frame;
        for (int i = 0; i < jTabbedPaneSimulators.getTabCount(); i++)
        {
            ISimulatorPanel panel = (ISimulatorPanel)jTabbedPaneSimulators.getComponentAt(i);
            panel.setFrame(frame);
            
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        jTabbedPaneSimulators = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());

        add(jTabbedPaneSimulators, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents
    
    public void refreshState()
    {
    }
    
    public void handleTaskCompletion(int taskIndex)
    {
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPaneSimulators;
    // End of variables declaration//GEN-END:variables
}
