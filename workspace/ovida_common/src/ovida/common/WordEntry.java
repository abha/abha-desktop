/**
 * 
 */
package ovida.common;

import java.io.Serializable;

/**
 * @author fadedreamz
 * @version 1.0
 * @since 4th March, 2011
 * 
 * WordEntry - base class for entering word
 * 
 */
public abstract class WordEntry implements Serializable{

	/**
	 * auto generated serial id
	 */
	private static final long serialVersionUID = 3007689617093623894L;
	
	private int wordID = -1;
	private String word = null;
	private int count = -1;
	private String meaning = null;
	private String menomic = null;
	private String origin = null;
	
	private EDIT_LEVEL editLevel;
	
	/**
	 * getWordID - gets the current word ID
	 * @return int - indicating the word's ID
	 */
	public int getWordID() {
		return wordID;
	}
	
	
	/**
	 * setWordID - sets the word id
	 * @param wordId - integer value which has to be set as word id
	 */
	public void setWordID(int wordId) {
		this.wordID = wordId;
	}
	
	/**
	 * getWord - returns the original word
	 * @return String - indicating the original word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * setWord - set the current word
	 * @param word - the word which has to be set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getMeaning() {
		return meaning;
	}
	
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	public String getMenomic() {
		return menomic;
	}
	
	public void setMenomic(String menomic) {
		this.menomic = menomic;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public EDIT_LEVEL getEditLevel() {
		return editLevel;
	}
	
	public void setEditLevel(EDIT_LEVEL editLevel) {
		this.editLevel = editLevel;
	}
	
}
