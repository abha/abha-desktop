package ovida.backend.dal.db.english;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import ovida.backend.dal.filehandler.FileOperation;
import ovida.common.EngWordEntry;

public class DBEnglishWords {
	private Hashtable<Integer, EngWordEntry> engWordMap = null;
	private Integer topOfMap = -1;
	
	private static DBEnglishWords thisInstacne = null;
	
	/**
	 * {@link DBEnglishWords} - constructor to create the object
	 */
	public DBEnglishWords() {
		if (DBEnglishWords.thisInstacne == null) {
			engWordMap = new Hashtable<Integer, EngWordEntry>();
			topOfMap = 1;
			// check whether the db already exists or not
			if (isEngDBExists()) {
				loadDB();	// db exists, so load the db
			}
		}
	}
	
	/**
	 * getInstance - returns the current instance of the database
	 * @return - {@link DBEnglishWords}
	 */
	public static DBEnglishWords getInstance() {
		if (thisInstacne != null)
			return thisInstacne;
		thisInstacne = new DBEnglishWords();
		return thisInstacne;
	}
	
	private void nextTopOfMap() {
		topOfMap++;
	}
	
	private boolean isEngDBExists() {
		FileOperation fO = new FileOperation();
		return fO.isDBFileExists();
	}
	
	private void loadDB() {
		if (engWordMap == null)
			return;
		FileOperation fO = new FileOperation();
		try {
			fO.openEngFile('r');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		EngWordEntry [] wordLists = fO.readEngWords();
		if (wordLists == null)
			return;
		int totalWords = wordLists.length;
		
		for(int i=0;i <totalWords; i++) {
			putWord(wordLists[i]);
		}
	}
	
	/**
	 * putWord - adds the word at the end of the Hashtable 
	 * @param word - add to be added
	 * @throws IllegalArgumentException - if the word already exists (POS)
	 */
	public void putWord(EngWordEntry word) throws IllegalArgumentException {
		if (engWordMap.containsValue(word)) {
			throw new IllegalArgumentException("Word already exists");
		}
		Set<Integer> keys = engWordMap.keySet();
		Iterator<Integer> it = keys.iterator();
		int count = 1;
		boolean found = false;
		while(it.hasNext()) {
			Integer curKey = it.next();
			EngWordEntry curObj = engWordMap.get(curKey);
			if (curObj.getWord().compareTo(word.getWord()) == 0) {
				found = true;
				count = curObj.getCount() + 1;
			} else if (found) {
				break;
			}
		}
		word.setCount(count);
		word.setWordID(topOfMap);
		nextTopOfMap();
		engWordMap.put(topOfMap, word);
	}
	
	public EngWordEntry getWordAt(Integer wordId) {
		return engWordMap.get(wordId);
	}
	
	public Hashtable<Integer, EngWordEntry> getWordMap() {
		return engWordMap;
	}
}
