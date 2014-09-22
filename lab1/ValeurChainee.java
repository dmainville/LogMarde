
public class ValeurChainee
{
	public int valeur;
	public ValeurChainee next;
	public ValeurChainee previous;

	public ValeurChainee(int valeur)
	{
		this.valeur = valeur;
		
		// instantiate to NULL
		this.next = null;
		this.previous = null;
	}
}
