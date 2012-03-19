package metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Historique implements Serializable
{
	private int his_id;
	private Date his_dateVisu;
	private int his_idClient;
	private int his_idVideo;
	
	@Id @GeneratedValue
	public int getid() {
		return his_id;
	}
	
	public void setid(int his_id) {
		this.his_id = his_id;
	}
	
	public Date getdateVisu() {
		return his_dateVisu;
	}
	
	public void setdateVisu(Date his_dateVisu) {
		this.his_dateVisu = his_dateVisu;
	}
	
	public int getidClient() {
		return his_idClient;
	}
	
	public void setidClient(int his_idClient) {
		this.his_idClient = his_idClient;
	}

	public int getidVideo() {
		return his_idVideo;
	}

	public void setidVideo(int his_idVideo) {
		this.his_idVideo = his_idVideo;
	}
	

	
	
	
}
