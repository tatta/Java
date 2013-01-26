/**
 * Word represents the Finnish word and its translation.
 * 
 */
public class Word {
	private String suomeksi;
	private String ruotsiksi;
	private String infinitiv;

	public Word(String suomeksi, String ruotsiksi, String infinitiv) {
		this.suomeksi = suomeksi;
		this.ruotsiksi = ruotsiksi;
		this.infinitiv = infinitiv;

	}
	public String getInfinitiv(){
		return infinitiv;
	}

	@Override
	public String toString() {
		return suomeksi + ",  " + ruotsiksi + ",  " + infinitiv;
	}
}
