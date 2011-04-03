package ovida.common;

import java.io.Serializable;

public class EngWordEntry extends WordEntry implements Serializable {

	/**
	 * serial number of the class
	 */
	private static final long serialVersionUID = 1L;
	
	private POS_ENG POS;
	
	/**
	 * initializeObject - initializes the variable of the object
	 * @param word - word to be set
	 * @param pos - parts of speech to be set
	 * @param editLevel - current edit level for the word
	 */
	private void initializeObject(String word, POS_ENG pos, EDIT_LEVEL editLevel) {
		this.setWord(word);
		this.setPOS(pos);
		this.setEditLevel(editLevel);
	}
	
	/**
	 * EngWordEntry - constructor to initialize the object
	 * @param word - word to set
	 * @param pos - parts of speech of the word
	 * @param editLevel - current edit level of the word
	 */
	public EngWordEntry(String word, POS_ENG pos, EDIT_LEVEL editLevel) {
		initializeObject(word, pos, editLevel);
	}
	
	
	public EngWordEntry(String word, POS_ENG pos) {
		initializeObject(word, pos, EDIT_LEVEL.INITIALE);
	}
	
	public POS_ENG getPOS() {
		return POS;
	}
	
	public void setPOS(POS_ENG POS) {
		this.POS = POS;
	}

}