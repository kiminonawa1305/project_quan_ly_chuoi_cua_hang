package model.system;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericInputOnlyDocument extends PlainDocument {

	@Override
	public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {
		// TODO Auto-generated method stub

		if (str == null) {
			return;
		}

		// Check if the string contains only numeric characters
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return;
			}
		}

		// If the string contains only numeric characters, insert it into the document
		super.insertString(offs, str, attr);
	}
}
