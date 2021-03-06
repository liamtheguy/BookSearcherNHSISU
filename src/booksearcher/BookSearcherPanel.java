package booksearcher;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author liam9
 */
public class BookSearcherPanel extends javax.swing.JPanel {

    static String sortBy = "LowToHigh";
    static Image starEmpty;
    static Image starFill;
    static int bookRating = 0;

    /**
     * Creates new form MainMenuPanel
     */
    public BookSearcherPanel() {
        initComponents();

        try {
            starEmpty = ImageIO.read(new File("starEmpty.png"));
            starFill = ImageIO.read(new File("starFill.png"));
        } catch (IOException ex) {
            System.out.println("Error! Star images not found!");
        }

        BookSearcher.initFileIO();
        BookSearcher.loadBadWords();
    }

    public void setFocusField() {
        ISBNField.requestFocusInWindow();
    }

    /**
     * Updates the reviews shown in the review display
     */
    public void updateReviews() {
        String[] reviews = BookSearcher.getReviews(ISBNField.getText());
        if (reviews.length == 0) {
            reviewTextArea.setText("No reviews");
            return;
        }
        Arrays.sort(reviews);
        String temp = "";
        switch (String.valueOf(reviewSortSel.getSelectedItem())) {

            case "LowToHigh":
                for (int i = 1; i < reviews.length; i++) {
                    temp += reviews[i] + "\n";
                }
                break;
            case "HighToLow":
                for (int i = reviews.length - 1; i > 0; i--) {
                    temp += reviews[i] + "\n";
                }
                break;
        }
        reviewTextArea.setText(temp);
        newReviewTextArea.setText("");
    }

    /**
     * Updates star rating graphics
     *
     * @param rating rating for stars to display
     */
    public void updateReviewStars(int rating) {
        if (rating != Integer.parseInt(Character.toString(currentSliderPosition.getText().charAt(0)))) { //Only updates if new star is selected
            starSelCanvas.getGraphics().clearRect(0, 0, starSelCanvas.getWidth(), starSelCanvas.getHeight());
            currentSliderPosition.setText(rating + "/5");
            for (int i = 0; i < rating; i++) {
                starSelCanvas.getGraphics().drawImage(starFill, starSelCanvas.getWidth() / 5 * i, 0, starSelCanvas.getWidth() / 5, starSelCanvas.getHeight(), null);
            }
            for (int x = rating; x < 5; x++) {
                starSelCanvas.getGraphics().drawImage(starEmpty, starSelCanvas.getWidth() / 5 * x, 0, starSelCanvas.getWidth() / 5, starSelCanvas.getHeight(), null);
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

        bookTitleLabel = new javax.swing.JLabel();
        googleRatingLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        publisherLabel = new javax.swing.JLabel();
        publishedDateLabel = new javax.swing.JLabel();
        ISBNField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        ISBNLabel = new javax.swing.JLabel();
        newReviewButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        newReviewTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        reviewLabel = new javax.swing.JLabel();
        createReviewLabel = new javax.swing.JLabel();
        currentSliderPosition = new javax.swing.JLabel();
        maxImageSize = new javax.swing.JLayeredPane();
        bookImageLabel = new javax.swing.JLabel();
        reviewSortSel = new javax.swing.JComboBox<>();
        starSelCanvas = new java.awt.Canvas();
        jScrollPane4 = new javax.swing.JScrollPane();
        descriptionEditorPane = new javax.swing.JEditorPane("text/html", "") {
            @Override
            public boolean getScrollableTracksViewportWidth()
            {
                return true;
            }
        };
        backButton = new javax.swing.JButton();

        bookTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookTitleLabel.setText("Title:");

        googleRatingLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        googleRatingLabel.setText("Google Rating:");

        authorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authorLabel.setText("Author:");

        categoryLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        categoryLabel.setText("Category:");

        publisherLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        publisherLabel.setText("Publisher:");

        publishedDateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        publishedDateLabel.setText("Published: ");

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ISBNLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ISBNLabel.setText("ISBN: ");

        newReviewButton.setText("Submit Review");
        newReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReviewButtonActionPerformed(evt);
            }
        });

        newReviewTextArea.setColumns(20);
        newReviewTextArea.setLineWrap(true);
        newReviewTextArea.setRows(5);
        newReviewTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(newReviewTextArea);

        reviewTextArea.setEditable(false);
        reviewTextArea.setColumns(20);
        reviewTextArea.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setRows(5);
        jScrollPane3.setViewportView(reviewTextArea);

        reviewLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        reviewLabel.setText("Reviews:");
        reviewLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        createReviewLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        createReviewLabel.setText("Create Review:");

        currentSliderPosition.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        currentSliderPosition.setText("5/5");

        bookImageLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        maxImageSize.setLayer(bookImageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout maxImageSizeLayout = new javax.swing.GroupLayout(maxImageSize);
        maxImageSize.setLayout(maxImageSizeLayout);
        maxImageSizeLayout.setHorizontalGroup(
            maxImageSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maxImageSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        maxImageSizeLayout.setVerticalGroup(
            maxImageSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maxImageSizeLayout.createSequentialGroup()
                .addComponent(bookImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        reviewSortSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LowToHigh", "HighToLow" }));
        reviewSortSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewSortSelActionPerformed(evt);
            }
        });

        starSelCanvas.setBackground(new java.awt.Color(240, 240, 240));
        starSelCanvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                starSelCanvasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                starSelCanvasMouseExited(evt);
            }
        });
        starSelCanvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                starSelCanvasMouseMoved(evt);
            }
        });

        descriptionEditorPane.setEditable(false);
        jScrollPane4.setViewportView(descriptionEditorPane);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(ISBNLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ISBNField, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(googleRatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(publisherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(publishedDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(maxImageSize)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createReviewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starSelCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentSliderPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reviewLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reviewSortSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(googleRatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publishedDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(maxImageSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ISBNLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ISBNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewLabel)
                    .addComponent(reviewSortSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currentSliderPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createReviewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(starSelCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Searches for a book in the text file, if it doesn't yet exist the book is
     * added to the text file
     *
     * @param evt button pushed
     */
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if (ISBNField.getText().equals("Mr. RD")) { //Easter egg
            newReviewButton.setEnabled(false);
            ImageIcon icon = new ImageIcon("rd.jpg");
            int height = icon.getIconHeight();
            int width = icon.getIconWidth();
            int maxHeight = bookImageLabel.getHeight();
            int maxWidth = bookImageLabel.getWidth();
            Dimension bookSize = new Dimension(width, height);
            Dimension maxSize = new Dimension(maxWidth, maxHeight);
            //Increases size of image, keeping ratio
            for (Dimension i = bookSize; i.height * 1.1 < maxSize.height && i.width * 1.1 < maxSize.width; i.setSize(i.width, i.height)) {
                i.height = (int) (i.height * 1.1);
                i.width = (int) (i.width * 1.1);
                bookSize.setSize(i.width, i.height);
            }
            Image scaleImage = icon.getImage().getScaledInstance(bookSize.width, bookSize.height, Image.SCALE_SMOOTH);
            bookImageLabel.setIcon(new ImageIcon(scaleImage));
            bookTitleLabel.setText("Title: Mr. RD");
            categoryLabel.setText("Coolest teacher");
            descriptionEditorPane.setText("A world famous computer science teacher at Newmarket High School");
        }
        if (!ISBNField.getText().equals("") && BookSearcher.isISBN(ISBNField.getText())) {
            newReviewButton.setEnabled(true);
            try {
                BookSearcher.addBook(ISBNField.getText());
                String[] info = BookSearcher.getBookInfo(ISBNField.getText());
                bookTitleLabel.setText("Title: " + info[0]);
                googleRatingLabel.setText("Google Rating: " + info[1]);
                authorLabel.setText("Author: " + info[2]);
                categoryLabel.setText("Category: " + info[3]);
                publisherLabel.setText("Publisher: " + info[4]);
                publishedDateLabel.setText("Pusblished: " + info[5]);
                descriptionEditorPane.setText(info[6] + "<br>MLA: " + info[7] + "<br>APA: " + info[8]);
                bookRating = BookSearcher.getAverageRatings(ISBNField.getText());
                ImageIcon icon = new ImageIcon(BookSearcher.getBookImage(ISBNField.getText())); // Gets book image and makes it a Icon
                // Set various dimensions for normal and max height
                int height = icon.getIconHeight();
                int width = icon.getIconWidth();
                int maxHeight = bookImageLabel.getHeight();
                int maxWidth = bookImageLabel.getWidth();
                Dimension bookSize = new Dimension(width, height);
                Dimension maxSize = new Dimension(maxWidth, maxHeight);
                //Increases size of image, keeping ratio
                for (Dimension i = bookSize; i.height * 1.1 < maxSize.height && i.width * 1.1 < maxSize.width; i.setSize(i.width, i.height)) {
                    i.height = (int) (i.height * 1.1);
                    i.width = (int) (i.width * 1.1);
                    bookSize.setSize(i.width, i.height);
                }
                // Svale and set image
                Image scaleImage = icon.getImage().getScaledInstance(bookSize.width, bookSize.height, Image.SCALE_SMOOTH);
                bookImageLabel.setIcon(new ImageIcon(scaleImage));
                bookRating = BookSearcher.getAverageRatings(ISBNField.getText());
                updateReviewStars(bookRating);
                ISBNField.selectAll();
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error 1 - Book not found in database!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error 4 - Please wait 30 seconds before performing any more searches!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
            }
            updateReviews();
        } else {
            JOptionPane.showMessageDialog(null, "Error 2 - Please enter a valid ISBN!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        }
        ISBNField.requestFocus();
        ISBNField.selectAll();
        newReviewTextArea.getDocument().putProperty("filterNewlines", Boolean.TRUE);
    }//GEN-LAST:event_SearchButtonActionPerformed
    /**
     * Calls update reviews
     *
     * @param evt
     */
    private void reviewSortSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewSortSelActionPerformed
        updateReviews();
    }//GEN-LAST:event_reviewSortSelActionPerformed
    /**
     * Shows stars when hovering over review
     *
     * @param evt
     */
    private void starSelCanvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starSelCanvasMouseMoved
        try {
            int starsSelected = (starSelCanvas.getMousePosition().x / (starSelCanvas.getSize().width / 5) + 1);
            updateReviewStars(starsSelected);
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_starSelCanvasMouseMoved
    /**
     * reset stars when mouse leaves canvas
     *
     * @param evt
     */
    private void starSelCanvasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starSelCanvasMouseExited
        updateReviewStars(bookRating);
    }//GEN-LAST:event_starSelCanvasMouseExited
    /**
     * sets users current review to that of the star clicked
     *
     * @param evt
     */
    private void starSelCanvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starSelCanvasMouseClicked
        bookRating = (starSelCanvas.getMousePosition().x / (starSelCanvas.getSize().width / 5) + 1);
    }//GEN-LAST:event_starSelCanvasMouseClicked
    /**
     * sends user back to main panel
     *
     * @param evt
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Frame.toScreen1();
        Startup.toBookSearcher.requestFocus();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * adds a review to a book if it is appropriate and valid
     *
     * @param evt button for creating reviews pushed
     */
    private void newReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReviewButtonActionPerformed
        int isbnLoc = BookSearcher.searchISBN(ISBNField.getText());
        if (newReviewTextArea.getText().length() > 0 && isbnLoc >= 0 && bookRating > 0) {
            if (BookSearcher.checkBadWord(newReviewTextArea.getText())) {
                BookSearcher.addReview(ISBNField.getText(), bookRating, newReviewTextArea.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Reviews cannot contain profanity!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (isbnLoc < 0) {
            JOptionPane.showMessageDialog(null, "Error 2 - Please enter a valid ISBN!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        } else if (newReviewTextArea.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Error 3 - Please enter a review first!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        } else if (bookRating == 0) {
            JOptionPane.showMessageDialog(null, "Error 5 - Please enter a valid rating", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
        }
        bookRating = BookSearcher.getAverageRatings(ISBNField.getText());
        updateReviewStars(bookRating);
        ISBNField.requestFocus();
        ISBNField.selectAll();
        updateReviews();
    }//GEN-LAST:event_newReviewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JTextField ISBNField;
    private javax.swing.JLabel ISBNLabel;
    static javax.swing.JButton SearchButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bookImageLabel;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel createReviewLabel;
    private javax.swing.JLabel currentSliderPosition;
    private javax.swing.JEditorPane descriptionEditorPane;
    private javax.swing.JLabel googleRatingLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLayeredPane maxImageSize;
    private javax.swing.JButton newReviewButton;
    private javax.swing.JTextArea newReviewTextArea;
    private javax.swing.JLabel publishedDateLabel;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JLabel reviewLabel;
    private javax.swing.JComboBox<String> reviewSortSel;
    private javax.swing.JTextArea reviewTextArea;
    static java.awt.Canvas starSelCanvas;
    // End of variables declaration//GEN-END:variables
}
