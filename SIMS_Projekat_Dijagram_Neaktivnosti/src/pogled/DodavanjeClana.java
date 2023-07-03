package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import enumeracije.TipClana;
import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.UniqueValueException;
import kontroleri.KorisnikKontroler;
import model.Biblioteka;
import model.Clan;
import model.Nalog;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;
import repozitorijumi.NalogRepo;

public class DodavanjeClana extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//osoba
	private TekstPolje tfIme;
	private TekstPolje tfPrezime;
	private TekstPolje tfJMBG;
	private TekstPolje tfMejl;
	private TekstPolje tfTelefon;
	
	//adresa
	private TekstPolje tfUlica;
	private TekstPolje tfBroj;
	private TekstPolje tfMesto;
	private TekstPolje tfPTT;
	
	//nalog
	private TekstPolje tfKorIme;
	private TekstPolje tfLozinka;
	
	//clan
	private TekstPolje tfClKarta;
	private PadajucaLista tfTipClanstva;
	
	private String staroKorIme;
	private String staraClKarta;
	
	private KorisnikKontroler korisnikKontroler;

	public DodavanjeClana(Biblioteka biblioteka, Clan... clan) throws IOException {
		setSize(new Dimension(800, 600));
		setTitle("Dodavanje clana");
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.korisnikKontroler = new KorisnikKontroler(biblioteka);

		Font fntNaslov = PogledUtil.getMaliNaslovFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		
		JPanel pnlDodavanjeClana = new JPanel();
		
		//osoba
		Labela lblNaslov = new Labela("Dodavanje clana", fntNaslov, clrForeground);
		Labela lblIme = new Labela("Ime: ", fntLabela, clrForeground);
		tfIme = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblPrezime = new Labela("Prezime: ", fntLabela, clrForeground);
		tfPrezime = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblJMBG = new Labela("JMBG: ", fntLabela, clrForeground);
		tfJMBG = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblMejl = new Labela("Mejl: ", fntLabela, clrForeground);
		tfMejl = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblTelefon = new Labela("Telefon: ", fntLabela, clrForeground);
		tfTelefon = new TekstPolje("", fntTekstPolje, 120, 20);
		
		//adresa
		Labela lblMesto = new Labela("Mesto: ", fntLabela, clrForeground);
		tfMesto = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblPTT = new Labela("Postanski broj: ", fntLabela, clrForeground);
		tfPTT = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblUlica = new Labela("Ulica: ", fntLabela, clrForeground);
		tfUlica = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblBroj = new Labela("Broj: ", fntLabela, clrForeground);
		tfBroj = new TekstPolje("", fntTekstPolje, 120, 20);
		
		//nalog
		Labela lblKorIme = new Labela("Korisnicko ime: ", fntLabela, clrForeground);
		tfKorIme = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblLozinka = new Labela("Lozinka: ", fntLabela, clrForeground);
		tfLozinka = new TekstPolje("", fntTekstPolje, 120, 20);
		
		//clan
		Labela lblClKarta = new Labela("Clanska karta: ", fntLabela, clrForeground);
		tfClKarta = new TekstPolje("", fntTekstPolje, 120, 20);
		
		Labela lblTipClanstva = new Labela("Clanska karta: ", fntLabela, clrForeground);
		TipClana[] tipC = TipClana.values();
		String[] tipoviClana = new String[tipC.length];
		for (int i = 0; i < tipC.length; i++)
			tipoviClana[i] = tipC[i].toString();
		tfTipClanstva = new PadajucaLista(tipoviClana, clrPrimarna, clrForeground, fntTekstPolje, 120, 20);
		
		if (clan.length == 1)
			prikaziPodatke(clan[0]);
		
		FormaDugme btnSacuvaj = new FormaDugme("Sacuvaj", clrPrimarna, clrForeground, 70, 30);
		btnSacuvaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					if (clan.length == 1) {
						korisnikKontroler.azurirajClana(staraClKarta, staroKorIme, tfIme.getText(), tfPrezime.getText(), tfJMBG.getText(), tfMejl.getText(), tfTelefon.getText(), tfMesto.getText(), tfPTT.getText(), tfBroj.getText(), tfUlica.getText(), tfKorIme.getText(), tfLozinka.getText(), tfClKarta.getText(), tfTipClanstva.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Clan je uspesno azuriran!");
						
						PrikazClanovi pc = new PrikazClanovi(biblioteka);
						pc.setVisible(true);
					}
					else {
						korisnikKontroler.registrujClana(tfIme.getText(), tfPrezime.getText(), tfJMBG.getText(), tfMejl.getText(), tfTelefon.getText(), tfMesto.getText(), tfPTT.getText(), tfBroj.getText(), tfUlica.getText(), tfKorIme.getText(), tfLozinka.getText(), tfClKarta.getText(), tfTipClanstva.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Clan je uspesno dodat!");
					}
					dispose();
				} catch (MissingValueException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (BadFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (UniqueValueException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		pnlDodavanjeClana.setBackground(clrPrimarna);
		pnlDodavanjeClana.setLayout(new MigLayout("", "30[][]30", "10[]20[]10[]10[]10[]10[]20[]10[]10[]10[]20[]10[]10[]20[]10[]"));
		
		pnlDodavanjeClana.add(lblNaslov, "wrap");
		pnlDodavanjeClana.add(lblIme, "gapleft 30");
		pnlDodavanjeClana.add(tfIme, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblPrezime, "gapleft 30");
		pnlDodavanjeClana.add(tfPrezime, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblJMBG, "gapleft 30");
		pnlDodavanjeClana.add(tfJMBG, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblMejl, "gapleft 30");
		pnlDodavanjeClana.add(tfMejl, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblTelefon, "gapleft 30");
		pnlDodavanjeClana.add(tfTelefon, "wrap, pushx, growx, gapright 30");
		
		pnlDodavanjeClana.add(lblMesto, "gapleft 30");
		pnlDodavanjeClana.add(tfMesto, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblUlica, "gapleft 30");
		pnlDodavanjeClana.add(tfUlica, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblBroj, "gapleft 30");
		pnlDodavanjeClana.add(tfBroj, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblPTT, "gapleft 30");
		pnlDodavanjeClana.add(tfPTT, "wrap, pushx, growx, gapright 30");
		
		pnlDodavanjeClana.add(lblKorIme, "gapleft 30");
		pnlDodavanjeClana.add(tfKorIme, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblLozinka, "gapleft 30");
		pnlDodavanjeClana.add(tfLozinka, "wrap, pushx, growx, gapright 30");
		
		pnlDodavanjeClana.add(lblClKarta, "gapleft 30");
		pnlDodavanjeClana.add(tfClKarta, "wrap, pushx, growx, gapright 30");
		pnlDodavanjeClana.add(lblTipClanstva, "gapleft 30");
		pnlDodavanjeClana.add(tfTipClanstva, "wrap, pushx, growx, gapright 30");
		
		pnlDodavanjeClana.add(btnSacuvaj, "cell 2 15");
		add(pnlDodavanjeClana);
	}
	
	public void prikaziPodatke(Clan clan) throws IOException {
		staraClKarta = clan.getBrojClanskeKarte();
		
		tfIme.setText(clan.getIme());
		tfPrezime.setText(clan.getPrezime());
		tfJMBG.setText(clan.getJmbg());
		tfMejl.setText(clan.getImejl());
		tfTelefon.setText(clan.getTelefon());
		
		tfUlica.setText(clan.getAdresa().getUlica());
		tfBroj.setText(clan.getAdresa().getBroj());
		tfMesto.setText(clan.getAdresa().getMesto().getNaziv());
		tfPTT.setText(Integer.toString(clan.getAdresa().getMesto().getPptBroj()));
		
		NalogRepo nalogRepo = new NalogRepo();
		Nalog n = nalogRepo.pronadjiNalog(clan);
		staroKorIme = n.getKorisnickoIme();
		tfKorIme.setText(n.getKorisnickoIme());
		tfLozinka.setText(n.getLozinka());
		
		tfClKarta.setText(clan.getBrojClanskeKarte());
		tfTipClanstva.setSelectedIndex(getIndex(clan.getTip()));
	}
	
	private int getIndex(TipClana t) {
		if (t == TipClana.DETE)
			return 0;
		if (t == TipClana.STUDENT)
			return 1;
		if (t == TipClana.PENZIONER)
			return 2;
		if (t == TipClana.ODRASLA_OSOBA)
			return 3;
		return 4;
	}
}
