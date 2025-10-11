package soal1;
import java.util.Random;

public class Dadu {
	private int nilai;
	private Random rand = new Random();
	
	public Dadu() {
		acakNilai();
	}
	public void setNilai(int nilai) {
		if (nilai >= 1 && nilai <= 6) {
			this.nilai = nilai;
		}else {
			acakNilai();
		}
	}
	
	public int getNilai() {
		return nilai;
	}
	
	private void acakNilai() {
		Random rand = new Random();
		this.nilai = rand.nextInt(6) + 1;
	}

}
