package paiement;

public class PaiementCarteClub implements IMoyenPaiement
{
	public String paid(double value)
	{
		return value + " euros sera d�bit� de votre carte club";
	}
}
