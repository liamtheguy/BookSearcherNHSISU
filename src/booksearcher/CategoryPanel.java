package booksearcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author 071568307
 */
public class CategoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form CategoryPanel
     */
    public CategoryPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        categoryEditorPanel = new javax.swing.JEditorPane("text/html", "");
        categorySearchButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        catComboBox = new javax.swing.JComboBox<>();
        catLabel = new javax.swing.JLabel();

        categoryEditorPanel.setEditable(false);
        jScrollPane1.setViewportView(categoryEditorPanel);

        categorySearchButton.setText("Search");
        categorySearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySearchButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        catLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        catLabel.setText("Category: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(151, 151, 151))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(catComboBox, 0, 174, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(categorySearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGap(248, 248, 248))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catComboBox)
                    .addComponent(categorySearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(catLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * searches all books in database that matches the chosen category and sorts
     * by users reviews
     *
     * @param evt
     */
    private void categorySearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySearchButtonActionPerformed
        try {
            String[] categories = BookSearcher.getCategory(catComboBox.getSelectedItem().toString()); //Gets all the books in the specific category
            String[][] catInfo = new String[categories.length][2]; //Array of books and average ratings
            for (int i = 0; i < categories.length; i++) { //Puts all data into the double array
                catInfo[i][0] = Integer.toString(BookSearcher.getAverageRatings(categories[i]));
                catInfo[i][1] = categories[i];
            }
            Arrays.sort(catInfo, new ColumnComparator(0)); //Sort books based on 

            int booksPerLine = categoryEditorPanel.getWidth() / 400; //books per line based on screen resolution
            String temp = "";
            for (int x = 0; x < categories.length; x += booksPerLine) { //Prints all of the book covers on one line
                for (int i = x; i < categories.length && i < (x + booksPerLine); i++) {
                    temp += "<html> <img src= " + BookSearcher.getBookImageString(catInfo[i][1]) + "/>";
                    for (int y = 0; y < booksPerLine * 4; y++) {
                        temp += " &nbsp; "; //Spaces between books based on screen resolution
                    }
                }
                temp += "<br>";
                for (int i = x; i < categories.length && i < (x + booksPerLine); i++) { //Print all of the book names and hyperlinks to be able to click on books
                    String title = BookSearcher.getBookInfo(catInfo[i][1])[0];
                    if (title.length() > 17) { // Shortens title to tidy up the graphics
                        title = title.substring(0, 17); //Ensures titles are not too long
                        title += "...";
                    }
                    if (catInfo[i][0].equals("0")) { // Only show reviews that have user reviews
                        temp += "<a href=" + catInfo[i][1] + ">" + title + " - N/R </a>"; //Shows N/R when no review
                    } else {
                        temp += "<a href=" + catInfo[i][1] + ">" + title + " - " + catInfo[i][0] + "/5 </a>"; //Display review out of 5 stars
                    }

                    for (int y = 0; y < booksPerLine * 3.8; y++) {
                        temp += " &nbsp; ";
                    }
                    if (title.length() < 17) { //Adds to small title books to ensure 
                        for (int z = title.length(); z < 18; z++) {
                            title += "&nbsp";
                        }
                    }
                }
                temp += "<br>"; //Adds a space between books
            }
            categoryEditorPanel.setText(temp);
            categoryEditorPanel.addHyperlinkListener(new HyperlinkListener() { //Hyperlink so users can click and search for book information
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) { //Search ISBN of clicked book
                        Frame.toScreen2();
                        BookSearcherPanel.ISBNField.setText(e.getDescription());
                        BookSearcherPanel.SearchButton.doClick();
                    }
                }
            });
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error 4  - Please wait 30 seconds before performing any more searches!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_categorySearchButtonActionPerformed

    /**
     * Changes back to the menu panel
     *
     * @param evt
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Frame.toScreen1();
        Startup.toBookSearcher.requestFocus();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    static javax.swing.JComboBox<String> catComboBox;
    private javax.swing.JLabel catLabel;
    private javax.swing.JEditorPane categoryEditorPanel;
    public static javax.swing.JButton categorySearchButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

class ColumnComparator implements Comparator {

    int columnToSort;

    ColumnComparator(int columnToSort) {
        this.columnToSort = columnToSort;
    }

    @Override
    public int compare(Object o1, Object o2) {
        String[] row1 = (String[]) o1;
        String[] row2 = (String[]) o2;
        return row2[columnToSort].compareTo(row1[columnToSort]);
    }
}
