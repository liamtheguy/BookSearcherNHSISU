package booksearcher;

import java.util.Arrays;
/**
 *
 * @author 068685601
 */
public class Startup extends javax.swing.JPanel {

    /**
     * Creates new form Startup
     */
    public Startup() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        toBookSearcher = new javax.swing.JButton();
        toCategorySearcher = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHS BookSearcher");

        toBookSearcher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toBookSearcher.setText("Book Searcher");
        toBookSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBookSearcherActionPerformed(evt);
            }
        });

        toCategorySearcher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toCategorySearcher.setText("Category Searcher");
        toCategorySearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCategorySearcherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toCategorySearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toBookSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(toBookSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toCategorySearcher, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Switches to Book Searcher Panel and applies focus to ISBNField
     * @param evt 
     */
    private void toBookSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBookSearcherActionPerformed
        Frame.toScreen2();
        BookSearcherPanel.ISBNField.requestFocus();
    }//GEN-LAST:event_toBookSearcherActionPerformed
    /**
     * Switches to Category Panel and refreshes the items in then category box, also applies focus to search button.
     * @param evt 
     */
    private void toCategorySearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCategorySearcherActionPerformed
        Frame.toScreen3();
        String[] temp = BookSearcher.loadExistingCategories(); //Loads all categories and puts them into the drop-down menu
        Arrays.sort(temp);
        CategoryPanel.catComboBox.removeAllItems(); //Deletes all old categories from combo box to be able to add new ones
        for (String temp1 : temp) {
            CategoryPanel.catComboBox.addItem(temp1);
        }
        CategoryPanel.categorySearchButton.requestFocus(); //Sets default focus to search button
    }//GEN-LAST:event_toCategorySearcherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JButton toBookSearcher;
    private javax.swing.JButton toCategorySearcher;
    // End of variables declaration//GEN-END:variables
}
