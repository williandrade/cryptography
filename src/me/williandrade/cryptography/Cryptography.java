package me.williandrade.cryptography;

public interface Cryptography {

	public String encript(String input, Integer key) throws Exception;

	public String decript(String input, Integer key) throws Exception;

}
