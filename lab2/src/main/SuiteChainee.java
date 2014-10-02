package main;

public interface SuiteChainee {
	public void build(String path, String op,int val1, int val2,int taille,Boolean etatVide) throws Exception;
	public boolean isValid(String path) throws Exception;

}
