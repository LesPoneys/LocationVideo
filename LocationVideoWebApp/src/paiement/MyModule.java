package paiement;
import com.google.inject.Binder;
import com.google.inject.Module;


public class MyModule implements Module 
{
	public void configure(Binder binder) {
		binder.bind(IMoyenPaiement.class).to(PaiementCarteClub.class);
	}
}
