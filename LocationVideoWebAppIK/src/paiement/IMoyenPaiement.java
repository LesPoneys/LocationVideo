package paiement;
import com.google.inject.ImplementedBy;


@ImplementedBy(PaiementCB.class)
public interface IMoyenPaiement
{
	public String paid(double value);

}
