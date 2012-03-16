package model;



public class SupportVideo 
{
	private int supv_idvideo;
	private int supv_idSupport;
	private int supv_nombre;
	private float supv_prix;
	
	
	public int getidvideo() {
		return supv_idvideo;
	}
	
	public void setidvideo(int supv_idvideo) {
		this.supv_idvideo = supv_idvideo;
	}
	
	public int getidSupport() {
		return supv_idSupport;
	}
	
	public void setidSupport(int supv_idSupport) {
		this.supv_idSupport = supv_idSupport;
	}
	
	public int getnombre() {
		return supv_nombre;
	}
	
	public void setnombre(int supv_nombre) {
		this.supv_nombre = supv_nombre;
	}
	
	public float getprix() {
		return supv_prix;
	}
	
	public void setprix(float supv_prix) {
		this.supv_prix = supv_prix;
	}
	
	
}
