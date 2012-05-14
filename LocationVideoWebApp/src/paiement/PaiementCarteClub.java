package paiement;

public class PaiementCarteClub implements IMoyenPaiement
{
	public String paid(double value)
	{
		return value + " euros sera débité de votre carte club";
	}
}
