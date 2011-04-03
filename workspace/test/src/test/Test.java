package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import ovida.backend.dal.filehandler.FileOperation;
import ovida.common.EngWordEntry;
import ovida.common.EDIT_LEVEL;
import ovida.common.POS_ENG;
import ovida.backend.dal.db.english.DBEnglishWords;

public class Test {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DBEnglishWords engWords = DBEnglishWords.getInstance();
		
		Set<Integer> keys = engWords.getWordMap().keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			Integer curKey = it.next();
			EngWordEntry word = engWords.getWordAt(curKey);
			System.out.println(word.getWord() + " " + word.getPOS() + " " + word.getCount());
		}
		
		/*
		EngWordEntry input1, input2;
		fO.openEngFile('r');
		input1 = fO.readEngWord();
		input2 = fO.readEngWord();
		System.out.println(input1.getWord());
		System.out.println(input2.getWord());
		*/
	}

}
