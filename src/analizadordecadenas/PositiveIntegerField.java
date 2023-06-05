/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadordecadenas;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PositiveIntegerField extends JTextField {

    public PositiveIntegerField(int columns) {
        super(columns);
        ((AbstractDocument) getDocument()).setDocumentFilter(new PositiveIntegerFilter());
    }

    private class PositiveIntegerFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
            sb.insert(offset, string);

            if (isPositiveInteger(sb.toString())) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
            sb.replace(offset, offset + length, text);

            if (isPositiveInteger(sb.toString())) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isPositiveInteger(String str) {
            if (str.isEmpty()) {
                return true;
            }

            try {
                int value = Integer.parseInt(str);
                return value >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}