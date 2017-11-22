import javax.microedition.lcdui.*;

public class Penyewaan extends Form implements CommandListener {
	TextField tSewa;
	TextField tBiaya;
	TextField tDiskonPersen;
	TextField tDiskonRp;
	TextField tBiayaAdmin;
	TextField tTotalTagihan;
	TextField tPajak;
	TextField tBayar;
	Command btnHitung;
	Command btnProses;

	public Penyewaan() {
		super ("Penyewaan");
		tSewa = new TextField("Lama Sewa  ", "",10,TextField.NUMERIC);
		append(tSewa);

		tBiaya = new TextField("Biaya Sewa   ", "",10,TextField.NUMERIC);
		append(tBiaya);

		tDiskonPersen = new TextField("Diskon (%)    ", "",3,TextField.NUMERIC);
		append(tDiskonPersen);

		tDiskonRp = new TextField("Diskon (Rp)  ", "",10,TextField.NUMERIC);
		append(tDiskonRp);

		tBiayaAdmin = new TextField("Biaya Admin ", "10000",10,TextField.NUMERIC);
		append(tBiayaAdmin);;

		tTotalTagihan = new TextField("Total tagihan", "",10,TextField.NUMERIC);
		append(tTotalTagihan);

		tPajak = new TextField("Pajak (%)       ", "10",3,TextField.NUMERIC);
		append(tPajak);

		tBayar = new TextField("Total Bayar   ", "",10,TextField.NUMERIC);
		append(tBayar);

		btnHitung = new Command("Hitung",Command.OK,0);
		addCommand(btnHitung);

		btnProses = new Command("Proses",Command.OK,1);
		addCommand(btnProses);

		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable d) {

		if(cmd == btnHitung) {
			int sewa = Integer.parseInt(tSewa.getString());
			int biaya = 100000;
			int totalBiaya = sewa * biaya ;
			int diskonRp = 0;

			if(sewa >= 5 && sewa <= 9) {
				diskonRp = totalBiaya*5/100;
				tDiskonPersen.setString("5");
			}else if(sewa >= 10) {
				diskonRp = totalBiaya*15/100;
				tDiskonPersen.setString("15");
			} else {
				tDiskonPersen.setString("0"); 
			}

			int totalTagihan = totalBiaya - diskonRp + 10000;
			int bayar = totalTagihan + (totalTagihan*10/100);

			tBiaya.setString("100000");
			tDiskonRp.setString(diskonRp+"");
			tTotalTagihan.setString(totalTagihan+"");
			tBayar.setString(bayar+"");

		}

	}
}