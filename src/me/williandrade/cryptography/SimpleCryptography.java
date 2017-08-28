package me.williandrade.cryptography;

import java.util.ArrayList;
import java.util.List;

public class SimpleCryptography implements Cryptography {
	public static List<String> ascii = new ArrayList<>();

	public SimpleCryptography() {
		super();
		this.initAscii();
	}

	@Override
	public String encript(String input, Integer key) throws Exception {
		char[] letters = input.toCharArray();

		char[] toBeConverted = letters;
		char[] converting = new char[letters.length];

		for (int i = 0; i < toBeConverted.length; i++) {
			char letter = toBeConverted[i];

			Integer index = indexOf(ascii, String.valueOf(letter));

			if (index == null) {
				throw new Exception("Não está no dicionário esse caractere " + letter);
			}

			Integer nextIndex = indexOffIncremental(ascii, index, key);

			converting[i] = ascii.get(nextIndex).toCharArray()[0];
		}
		return String.valueOf(converting);
	}

	@Override
	public String decript(String input, Integer key) throws Exception {
		char[] letters = input.toCharArray();

		char[] toBeConverted = letters;
		char[] converting = new char[letters.length];

		for (int i = 0; i < toBeConverted.length; i++) {
			char letter = toBeConverted[i];

			Integer index = indexOf(ascii, String.valueOf(letter));

			if (index == null) {
				throw new Exception("Não está no dicionário esse caractere " + letter);
			}

			Integer nextIndex = indexOffDecremental(ascii, index, key);

			converting[i] = ascii.get(nextIndex).toCharArray()[0];
		}
		return String.valueOf(converting);
	}

	private void initAscii() {
		for (int i = 0; i < 256; i++) {
			char temp = (char) i;
			ascii.add(Character.toString(temp));
		}
	}

	private Integer indexOf(List<String> arr, String element) {
		Integer result = null;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equalsIgnoreCase(element)) {
				result = i;
			}
		}

		return result;
	}

	private Integer indexOffIncremental(final List<?> source, final int start, final int length) {
		int index = start;
		Integer result = null;
		for (int i = 0; i < length; i++) {
			result = index++;
			if (index == source.size()) {
				index = 0;
			}
		}
		return result;
	}

	private Integer indexOffDecremental(final List<?> source, final int start, final int length) {
		int index = start;
		Integer result = null;
		for (int i = 0; i < length; i++) {
			result = index--;
			if (index == 0) {
				index = source.size();
			}
		}
		return result;
	}

}
