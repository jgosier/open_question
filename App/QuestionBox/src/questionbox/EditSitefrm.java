/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditSite.java
 *
 * Created on Jan 19, 2010, 11:12:00 AM
 */

package questionbox;

import org.jdesktop.application.Action;
import qbox.model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ivank
 */
public class EditSitefrm extends javax.swing.JFrame {

    //This this is set then the function is edit
    private  long siteId = 0;
    public EditSitefrm(long _siteid)
    {
        try{
        siteId = _siteid;
        startApp();
        if (siteId > 0)
        {
            RecommendedSite site = RecommendedSite.getSite(siteId);
            this.txtURL.setText(site.getUrl());
            this.txtDesc.setText(site.getName());
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Failed to open recommended site.\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void startApp()
    {
        initComponents();
        this.setTitle("Add/Edit Recommended Sites");
        setLocationRelativeTo(null);
    }
    
    /** Creates new form EditSite */
    public EditSitefrm() {
        startApp();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(questionbox.QuestionBoxApp.class).getContext().getResourceMap(EditSitefrm.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtURL.setText(resourceMap.getString("txtURL.text")); // NOI18N
        txtURL.setName("txtURL"); // NOI18N

        jLabel2.setText(resourceMap.getString("Description.text")); // NOI18N
        jLabel2.setName("Description"); // NOI18N

        txtDesc.setText(resourceMap.getString("txtDescription.text")); // NOI18N
        txtDesc.setName("txtDescription"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(questionbox.QuestionBoxApp.class).getContext().getActionMap(EditSitefrm.class, this);
        jButton1.setAction(actionMap.get("Savesite")); // NOI18N
        jButton1.setText(resourceMap.getString("btnSave.text")); // NOI18N
        jButton1.setName("btnSave"); // NOI18N

        jButton2.setAction(actionMap.get("cancelform")); // NOI18N
        jButton2.setText(resourceMap.getString("btnCancel.text")); // NOI18N
        jButton2.setName("btnCancel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDesc)
                    .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(97, 97, 97)
                .addComponent(jButton2)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSitefrm().setVisible(true);
            }
        });
    }

    @Action
    public void cancelform() {
        this.dispose();
    }

    @Action
    public void Savesite() {
        try{
        if (siteId > 0)
        {

            RecommendedSite site = new RecommendedSite();
            site.setRecommendedsiteid(siteId);
            site.setName(this.txtDesc.getText());
            site.setUrl(this.txtURL.getText());
            site.UpdateRecommendedSite();
            
        }
        else
        {
            RecommendedSite site = new RecommendedSite();
            site.setRecommendedsiteid(siteId);
            site.setName(this.txtDesc.getText());
            site.setUrl(this.txtURL.getText());
            site.AddRecommendedSite();

        }
         JOptionPane.showMessageDialog(this, "Site has been saved.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
         StaticMain.recsite.Refresh();
         this.dispose();
       }catch(Exception e)
       {

       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

}