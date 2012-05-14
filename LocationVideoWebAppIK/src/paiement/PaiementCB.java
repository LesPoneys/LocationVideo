package paiement;

public class PaiementCB implements IMoyenPaiement
{
	public String paid(double value)
	{
		return "Paiement par carte bancaire de " + value + " euros effectuée";
	}

}
