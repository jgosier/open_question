/**
 *  Appfrica Labs Uganda Ltd Copyrigth @since 2009
 *  @version 2
 *
 * @author Ivan Kavuma
 */
/**
 * This class manages the Searching of databases (online and local)
 */

package questionbox;

import qbox.model.*;
import javax.swing.event.* ;
import javax.swing.JOptionPane;
import java.util.*;
import java.net.URL ;
import java.util.Vector;

public class Search extends javax.swing.JFrame {

    /** Static parameter to user in the follow of the form */
    private Vector<String> header;
    private Vector<Vector<String>> dataRows;
    private static int ResultPosX ;
    private static int ResultPosY;
    private static int ResultHeight = 630;
    private static int ResultsWidth = 590;
    private static int FormHeight = 800;
    private static int FormWidth = 750;
    private String OnlineResults = "";
    private URL Siteurl ;
    

   
    /**
     * The construct sets up a lot of the variables we need at the start.
     */
    public Search() {
        initComponents();
        lblCategory.setText("Category");
        btnSearch.setText("Search Query");
        btnEscalate.setText("Escalate & Save");
        btnSave.setText("Save");
        lblResults.setText("Database Results");
        rbSearchdb.setText("Search Database");
        rbSearchonline.setText("Search Online");
        this.setTitle("Search Query Form");
        btnBack.setText("<< Back");

        intializeCategory();
        resetResultsTable();
        StaticMain.ticket.setStartTime(Util.Now());

        showSearchdb();
        rbSearchdb.setSelected(true);
        setLocationRelativeTo(null);
        this.setSize(FormWidth, FormHeight);
        

    }

    /**
     * Result the results table by clearing out its contents.
     */
     private void resetResultsTable()
    {
        header = new Vector();
        header.add("AnswerID");
        header.add("Query");
        header.add("Answer");
        header.add("Relevance");

        dataRows = new Vector<Vector<String>>(); // Vector of rows
        tbResults.setModel(new javax.swing.table.DefaultTableModel( dataRows,header));
    }

    /**
     * Initize the category combo box with the list of categories from the database.
     *
     */
    private void intializeCategory()
    {
        try{
            cmbCategory.removeAllItems();
                ArrayList<Category> cats = Category.getAllCategorys();
                for(Category c:cats)
                {
                    cmbCategory.addItem(c.getTitle());
                }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Loading categories Failed!\n","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }

    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSearchType = new javax.swing.ButtonGroup();
        rbSearchdb = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuery = new javax.swing.JTextArea();
        btnSearch = new javax.swing.JButton();
        btnEscalate = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox();
        lblCategory = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        rbSearchonline = new javax.swing.JRadioButton();
        pnldbResult = new javax.swing.JPanel();
        lblResults = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbResults = new javax.swing.JTable();
        pnlOnlineResults = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOnlineResults = new javax.swing.JEditorPane();
        lblOnlineResults = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        grpSearchType.add(rbSearchdb);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(questionbox.QuestionBoxApp.class).getContext().getResourceMap(Search.class);
        rbSearchdb.setText(resourceMap.getString("rbSearchdb.text")); // NOI18N
        rbSearchdb.setName("rbSearchdb"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtQuery.setColumns(20);
        txtQuery.setRows(5);
        txtQuery.setName("txtQuery"); // NOI18N
        jScrollPane1.setViewportView(txtQuery);

        btnSearch.setText(resourceMap.getString("btnSearch.text")); // NOI18N
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEscalate.setText(resourceMap.getString("btnEscalate.text")); // NOI18N
        btnEscalate.setName("btnEscalate"); // NOI18N
        btnEscalate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalateActionPerformed(evt);
            }
        });

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategory.setName("cmbCategory"); // NOI18N

        lblCategory.setText(resourceMap.getString("lblCategory.text")); // NOI18N
        lblCategory.setName("lblCategory"); // NOI18N

        btnSave.setText(resourceMap.getString("btnSave.text")); // NOI18N
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        grpSearchType.add(rbSearchonline);
        rbSearchonline.setText(resourceMap.getString("rbSearchonline.text")); // NOI18N
        rbSearchonline.setName("rbSearchonline"); // NOI18N

        pnldbResult.setName("pnldbResult"); // NOI18N
        pnldbResult.setPreferredSize(new java.awt.Dimension(750, 600));

        lblResults.setText(resourceMap.getString("lblResults.text")); // NOI18N
        lblResults.setName("lblResults"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tbResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbResults.setName("tbResults"); // NOI18N
        tbResults.setPreferredSize(new java.awt.Dimension(400, 500));
        tbResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbResults);

        javax.swing.GroupLayout pnldbResultLayout = new javax.swing.GroupLayout(pnldbResult);
        pnldbResult.setLayout(pnldbResultLayout);
        pnldbResultLayout.setHorizontalGroup(
            pnldbResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldbResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldbResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addComponent(lblResults))
                .addContainerGap())
        );
        pnldbResultLayout.setVerticalGroup(
            pnldbResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldbResultLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblResults, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlOnlineResults.setName("pnlOnlineResults"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        txtOnlineResults.setContentType(resourceMap.getString("txtOnlineResults.contentType")); // NOI18N
        txtOnlineResults.setEditable(false);
        txtOnlineResults.setName("txtOnlineResults"); // NOI18N
        txtOnlineResults.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                txtOnlineResultsHyperlinkUpdate(evt);
            }
        });
        jScrollPane3.setViewportView(txtOnlineResults);
        txtOnlineResults.getAccessibleContext().setAccessibleDescription(resourceMap.getString("txtOnlineResults.AccessibleContext.accessibleDescription")); // NOI18N

        lblOnlineResults.setText(resourceMap.getString("lblOnlineResults.text")); // NOI18N
        lblOnlineResults.setName("lblOnlineResults"); // NOI18N

        btnBack.setText(resourceMap.getString("btnBack.text")); // NOI18N
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOnlineResultsLayout = new javax.swing.GroupLayout(pnlOnlineResults);
        pnlOnlineResults.setLayout(pnlOnlineResultsLayout);
        pnlOnlineResultsLayout.setHorizontalGroup(
            pnlOnlineResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOnlineResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOnlineResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(pnlOnlineResultsLayout.createSequentialGroup()
                        .addComponent(lblOnlineResults)
                        .addGap(273, 273, 273)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        pnlOnlineResultsLayout.setVerticalGroup(
            pnlOnlineResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOnlineResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOnlineResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOnlineResults)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblSearch.setText(resourceMap.getString("lblSearch.text")); // NOI18N
        lblSearch.setName("lblSearch"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(rbSearchdb)
                .addGap(18, 18, 18)
                .addComponent(rbSearchonline)
                .addGap(74, 74, 74)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addGap(349, 349, 349)
                        .addComponent(lblCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnldbResult, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnEscalate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOnlineResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbSearchdb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbSearchonline))
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnldbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlOnlineResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEscalate)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * AddAnswerRows Gets answers from the array of results passed and add the answer details to
     * the results table with the corresponding score/ relevance for each answer.
     * @param results
     * @throws Exception
     */
    private void AddAnswerRows(ArrayList<Result> results) throws Exception
    {
        for( Result res : results)
           {
              Vector<String> cells = new Vector<String>();
              Answer answer = (Answer)res.Key;
              cells.add(Long.toString(answer.getAnswerid()));
              cells.add("");
              cells.add(answer.getDetails());
              cells.add(Float.toString(res.Value));
              dataRows.add(cells);

           }

    }

    /**
     *
     * AddTicketRows Gets tickets from the array of results passed and add the ticket details to
     * the results table with the corresponding score/ relevance for each ticket.
     * @param results
     * @throws Exception
     *
     * @see Array
     */
    private void AddTicketRows(ArrayList<Result> results) throws Exception
    {
        for( Result res : results)
           {
              Vector<String> cells = new Vector<String>();
              Ticket ticket = (Ticket)res.Key;
              cells.add(Long.toString(ticket.getAnserid()));
              cells.add(Query.getQuery(ticket.getQueryid()).getDetails());
              cells.add(Answer.getAnswer(ticket.getAnserid()).getDetails());
              cells.add(Float.toString(res.Value));
              dataRows.add(cells);

           }

    }
    /**
     * SetQuery set text into the query textbox. ready for the next search.
     * This is called from the ticket form when the "Search Again" button is clicked.
     * @param text
     */
    public void setQuery(String text)
    {
        this.txtQuery.setText(text);
    }

    /**
     *
     * This function performs the database Search for queries and user the category in the search.
     *
     */
    private void SearchDatabase()
    {
      try{
        String theQuery = txtQuery.getText();
        //categoryid to search
        long Categoryid = Category.getCategoryIDByTitle(cmbCategory.getSelectedItem().toString());

        //Search query class. pass the query the the number of results to return
        //is set to 3 but can be adjusted as required.
         ArrayList<Result> results = Query.Search(theQuery ,3 ,Categoryid );
         AddTicketRows(results);

         //Search query class. pass the query the the number of results to return
        //is set to 3 but can be adjusted as required.
          results = Answer.Search(theQuery ,3 ,Categoryid );
          AddAnswerRows(results);

          //assign all the rows collected to the table results to show to the user.
          tbResults.setModel(new javax.swing.table.DefaultTableModel( dataRows,header));

          tbResults.setAutoscrolls(true);

          if(results.isEmpty())
          {
              JOptionPane.showMessageDialog(this, "No results found in this category in the database!\n" +
                      "Change the category or keywords and try again." ,"Results",JOptionPane.INFORMATION_MESSAGE);
          }

        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(this, "Search failed!\n","Error",JOptionPane.ERROR_MESSAGE);
             System.out.println(e.getMessage());
        }


    }

    /**
     * Perform a search of both the database and online.
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //Reset all the results tables and text box at every start of the search.
        resetResultsTable();
        txtOnlineResults.setText("");
        txtOnlineResults.setEditable(false);
      
        if(rbSearchdb.isSelected()) //if database radio button is selected then search database
        {
            showSearchdb(); //toshow the table of results from the database.
            SearchDatabase();
        }
        else if(rbSearchonline.isSelected())//otherwise search online.
        {
            //SearchOnline();
           showOnlineResults();
           OnlineSearch onsearch = new OnlineSearch();
           OnlineResults = onsearch.YahooQuery(txtQuery.getText()); //Search online using the query typed.
           txtOnlineResults.setText(OnlineResults);
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * Save the ticket that has been in the background as we moved thought the query.
     * @param evt
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
        if(rbSearchdb.isSelected()) //if Search database. they save database result.
        {
            SaveResultsFromDB();
        }
        else if(rbSearchonline.isSelected()) //Otherwise save online results.
        {
            SaveOnlineResults();
        }
        //refresh the operator console and open it again.
        StaticMain.operatorconsole.refresh();
        StaticMain.operatorconsole.show();
      //  this.dispose();
    }

    /**
     * Create a new query to add the existing ticket.
     * @throws queries not in.
     * @return
     */
    private long AddQuery()
    {    Query qry = new Query();
        try
        {
            //Setup the query attributes
            qry.setCategoryid(Category.getCategoryIDByTitle(cmbCategory.getSelectedItem().toString()));
            qry.setDetails(txtQuery.getText());
            qry.AddQuery();//save it to the database.
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to save new query \n","Error",JOptionPane.ERROR_MESSAGE);
        }
        return qry.getQueryid();
    }

    /**
     * This function saves online results to the database.
     */
    private void SaveOnlineResults()
    {   try
        {
                 //setup all the information about this answer.
                Answer answer = new Answer();
                answer.setCategoryid(Category.getCategoryIDByTitle(cmbCategory.getSelectedItem().toString()));
                answer.setDetails(txtOnlineResults.getText());
                answer.setLink_to_answer(Siteurl.toString());
                answer.setSource(Siteurl.toString());
                answer.AddAnswer(); //Save answer to database.

                //get ticket from staticmain and assign more information to it.
                StaticMain.ticket.setAnserid(answer.getAnswerid());
                StaticMain.ticket.setEndTime(Util.Now());
                StaticMain.ticket.setQueryid(AddQuery());
                StaticMain.ticket.setStatusid(7); //Status id 7 is "Completed"
                if (StaticMain.ticket.getTicketid() == 0)
                    StaticMain.ticket.AddTicket(); //save new to database
                else
                    StaticMain.ticket.UpdateTicket();//Or update existing ticket to database.

                 JOptionPane.showMessageDialog(this, "Ticket has been saved successfully.","Ticket Saved",JOptionPane.INFORMATION_MESSAGE);
                 this.dispose();
           
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to save ticket new \n" +
                    "Please trim off the irelavant text and try saving again.","Error",JOptionPane.ERROR_MESSAGE);

        }


    }

    /**
     * Save database results to the database
     * This function points the new ticket to the answer found in the database.
     * It avoid repitition of answers already used for other queries.
     *
     */
    private void SaveResultsFromDB()
    {   try
        {
            if(tbResults.getSelectedRowCount() == 1 )
            {
                //setup all the information about this ticket.
                int Rowid = tbResults.getSelectedRow();
                long Anserid = Long.parseLong(dataRows.get(Rowid).get(0));
                
                StaticMain.ticket.setAnserid(Anserid);
                StaticMain.ticket.setEndTime(Util.Now());
                StaticMain.ticket.setQueryid(AddQuery());
                StaticMain.ticket.setStatusid(7); //Status id 7 is "Completed"
                if(StaticMain.ticket.getTicketid() == 0)
                 StaticMain.ticket.AddTicket();//save new to database
                else
                 StaticMain.ticket.UpdateTicket();//Or update existing ticket to database.
                
                 JOptionPane.showMessageDialog(this, "Ticket has been saved successfully.","Ticket Saved",JOptionPane.INFORMATION_MESSAGE);
                 this.dispose();
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Please select exactly one row.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to save new ticket\n","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * This function tries to reorganise the look and feel of the UI when the database
     * is being searched.
     * @param evt
     */
    private void showSearchdb()
    {

        pnlOnlineResults.setSize(ResultsWidth + 20, ResultHeight / 2+ 20);
        tbResults.setSize(ResultsWidth, FormHeight/2);
        pnldbResult.setSize(ResultsWidth + 20, (FormHeight/2)+20);
        pnldbResult.setLocation(ResultPosX, ResultPosY);

        pnldbResult.setVisible(true);
        this.validate();

    }
    
     /**
     * This function tries to reorganise the look and feel of the UI when the search is online.
     * @param evt
     */
    private void showOnlineResults()
    {
       pnldbResult.setVisible(false);
       txtOnlineResults.setSize(ResultsWidth, ResultHeight);
       pnlOnlineResults.setSize(ResultsWidth + 20, ResultHeight + 20);
       pnlOnlineResults.setLocation(ResultPosX, ResultPosY);
       pnlOnlineResults.setVisible(true);
       this.validate();
    }

    /**
     * This function renders the URL links clicked on in the txtOnlineResults.
     * @param evt
     */
    private void txtOnlineResultsHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_txtOnlineResultsHyperlinkUpdate
        // TODO add your handling code here:
     if ( evt.getEventType ( ) == HyperlinkEvent.EventType.ACTIVATED )
     {
        try{
            Siteurl = evt.getURL () ;
            this.txtOnlineResults.setPage ( Siteurl ) ;
            txtOnlineResults.setEditable(true);
        }
        catch(Exception e)
        {

        }
      }
    }//GEN-LAST:event_txtOnlineResultsHyperlinkUpdate

    /**
     * This function reloads the previously searched results,
     * Hence simulated a back in a web browser.
     * @param evt
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        txtOnlineResults.setText(OnlineResults);
        txtOnlineResults.setEditable(false);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * This function is used to display the details of the row clicked on in the results tables.
     * @param evt
     */
    private void tbResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultsMouseClicked
        // TODO add your handling code here:

        try
        {
                if(tbResults.getSelectedRowCount() == 1 )
                {
                    int Rowid = tbResults.getSelectedRow();
                    long Anserid = Long.parseLong(dataRows.get(Rowid).get(0));
               
                    txtOnlineResults.setText(Answer.getAnswer(Anserid).getDetails());
                    pnlOnlineResults.setSize(ResultsWidth + 20, ResultHeight + 20);
             
                }
                else
                {
                     JOptionPane.showMessageDialog(this, "Please select exactly one row.","Error",JOptionPane.ERROR_MESSAGE);
                }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Failed to view database Answer \n","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tbResultsMouseClicked

    /**
     * This function saves the ticket of the query and keeps the status unanswered.
     * This allows the ticket to appear on the admin console.
     * @param evt
     */
    private void btnEscalateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscalateActionPerformed
        // TODO add your handling code here:
        try
        {
            StaticMain.ticket.setQueryid(AddQuery());
            StaticMain.ticket.setEndTime(Util.Now());
            StaticMain.ticket.setStatusid(6); //Status id 7 is "UnAnswered"
            StaticMain.ticket.AddTicket();
            this.dispose();

        StaticMain.operatorconsole.refresh();
        StaticMain.operatorconsole.show();
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to view database Answer \n","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEscalateActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Search search = new Search();
                search.setResizable(false);
                search.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEscalate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.ButtonGroup grpSearchType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblOnlineResults;
    private javax.swing.JLabel lblResults;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlOnlineResults;
    private javax.swing.JPanel pnldbResult;
    private javax.swing.JRadioButton rbSearchdb;
    private javax.swing.JRadioButton rbSearchonline;
    private javax.swing.JTable tbResults;
    private javax.swing.JEditorPane txtOnlineResults;
    private javax.swing.JTextArea txtQuery;
    // End of variables declaration//GEN-END:variables

}