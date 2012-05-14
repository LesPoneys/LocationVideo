package paiement;
import com.google.inject.Inject;


public class Reglement
{
	
	private IMoyenPaiement moyPaiement;
	
	@Inject
	public void setReglement(IMoyenPaiement _moyPaiement)
	{
		moyPaiement = _moyPaiement;
	}

	public IMoyenPaiement getReglement()
	{
		return moyPaiement;
	}

	
	public String doPayment (double montant)
	{
		return moyPaiement.paid(montant);
	}
	
}
