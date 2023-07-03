package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import enumeracije.TipKoricenja;
import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.NotSavedException;
import kontroleri.IzdanjaKontroler;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Izdavac;
import model.Knjiga;
import model.Zanr;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class FormaIzdanje extends JDialog  {

	private static final long serialVersionUID = 3749558997889600480L;
	
	private TekstPolje tfNaziv;
	private TekstPolje tfJezik;
	private JTextArea taAutori;
	private JTextArea taZanrovi;
	
	private JTextArea taOpis;
	private TekstPolje tfUdk;
	private TekstPolje tfIsbn;
	private TekstPolje tfGodina;
	private TekstPolje tfIzdavac;
	private PadajucaLista plKoricenje;
	
	private Izdanje izdanje0 = null;
	
	public List<Autor> autori = new ArrayList<Autor>();
	public List<Zanr> zanrovi = new ArrayList<Zanr>();
	public Izdavac izdavac = null;
	
	
	public IzdanjaKontroler kontroler;

	public void dodajAutora(Autor autor) {
		if (!autori.contains(autor)) {
			autori.add(autor);
			ispisiAutore();
		}
	}
	
	private void ispisiAutore() {
		String t = "";
		for (Autor a : autori) {
			t += a.toString() + "; ";
		}
		taAutori.setText(t.substring(0, t.length()-2));
	}
	
	public void resetujAutore() {
		autori.clear();
		taAutori.setText("");
	}
	
	public void dodajZanr(Zanr zanr) {
		if (!zanrovi.contains(zanr)) {
			zanrovi.add(zanr);
			ispisiZanrove();
		}
	}
	
	private void ispisiZanrove() {
		String t = "";
		for (Zanr a : zanrovi) {
			t += a.getNaziv() + ", ";
		}
		taZanrovi.setText(t.substring(0, t.length()-2));
	}
	
	public void resetujZanrove() {
		zanrovi.clear();
		taZanrovi.setText("");
	}


	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
		this.tfIzdavac.setText(izdavac.toString());
	}
	
	private void osnova(Biblioteka biblioteka, Knjiga knjiga) {
		try {
			this.kontroler = new IzdanjaKontroler(biblioteka);
		} catch (IOException e3) {
			JOptionPane.showMessageDialog(null, "Greska pri citanju iz fajlova.", "Greska", JOptionPane.ERROR_MESSAGE);
			e3.printStackTrace();
		}
		setSize(new Dimension(600, 750));
		setLocationRelativeTo(null);
		setResizable(false);
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		this.getContentPane().setBackground(clrPrimarna);
		
		Labela lblNaziv = new Labela("Naslov:", fntLabela, clrTercijarna);
		tfNaziv = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblJezik = new Labela("Jezik:", fntLabela, clrTercijarna);
		tfJezik = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblUdk = new Labela("UDK:", fntLabela, clrTercijarna);
		tfUdk = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblIsbn = new Labela("ISBN:", fntLabela, clrTercijarna);
		tfIsbn = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblGodina = new Labela("Godina izdanja:", fntLabela, clrTercijarna);
		tfGodina = new TekstPolje("", fntTekstPolje, 240, 30);
		
		
		Labela lblOpis = new Labela("Opis:", fntLabela, clrTercijarna);
		taOpis = new JTextArea(260, 90);
		JScrollPane scrollOpis = new JScrollPane(taOpis);
		scrollOpis.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollOpis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Labela lblAutori = new Labela("Autori:", fntLabela, clrTercijarna);
		taAutori = new JTextArea(260, 90);
		taAutori.setEditable(false);
		JScrollPane scrollAutori = new JScrollPane(taAutori);
		scrollAutori.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollAutori.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		FormaDugme btnDodajAutora = new FormaDugme("Dodaj autora", clrSekundarna, clrForeground, 150, 20);
		btnDodajAutora.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				formaAutor();
			}
		});
		
		FormaDugme btnResetAutora = new FormaDugme("Resetuj autore", clrSekundarna, clrForeground, 150, 20);
		btnResetAutora.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				resetujAutore();
			}
		});

		Labela lblZanrovi = new Labela("Zanrovi:", fntLabela, clrTercijarna);
		taZanrovi = new JTextArea(260, 90);
		taZanrovi.setEditable(false);
		JScrollPane scrollZanrovi = new JScrollPane(taZanrovi);
		scrollZanrovi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollZanrovi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		FormaDugme btnDodajZanr = new FormaDugme("Dodaj zanr", clrSekundarna, clrForeground, 150, 20);
		btnDodajZanr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formaZanr();
			}
		});
		
		FormaDugme btnResetZanr = new FormaDugme("Resetuj zanrove", clrSekundarna, clrForeground, 150, 20);
		btnResetZanr.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				resetujZanrove();
			}
		});
		
		Labela lblIzdavaci = new Labela("Izdavac:", fntLabela, clrTercijarna);
		tfIzdavac = new TekstPolje("", fntTekstPolje, 240, 30);
		tfIzdavac.setEditable(false);
		
		FormaDugme btnDodajIzdavaca = new FormaDugme("Dodaj izdavaca", clrSekundarna, clrForeground, 150, 20);
		btnDodajIzdavaca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formaIzdavac();
			}
		});
		
		Labela lblKoricenje = new Labela("Koricenje:", fntLabela, clrTercijarna);
		String[] tipoviK = {"mek povez", "tvd povez"};
		plKoricenje = new PadajucaLista(tipoviK,
				clrSekundarna, clrForeground, fntTekstPolje, 240, 30);
		
		FormaDugme btnDodaj = new FormaDugme("Zavrsi", clrSekundarna, clrForeground, 150, 20);
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String naziv = tfNaziv.getText();
				String jezik = tfJezik.getText();
				String opis = taOpis.getText();
				String isbn = tfIsbn.getText();
				String udk = tfUdk.getText();
				String god = tfGodina.getText();
				TipKoricenja koricenje;
				if (naziv.isEmpty() || jezik.isEmpty() || opis.isEmpty() || isbn.isEmpty() || udk.isEmpty()
						|| god.isEmpty() || izdavac == null || autori.isEmpty() || zanrovi.isEmpty() || plKoricenje.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Nisu uneti svi podaci.", "Fale podaci", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						int godina = Integer.parseInt(god);
						if (plKoricenje.getSelectedIndex()==0) koricenje = TipKoricenja.MEK_POVEZ;
						else koricenje = TipKoricenja.TVRD_POVEZ;
						
						if (izdanje0 == null) {
							if (kontroler.dodajNovo(naziv, jezik, zanrovi, autori, opis, udk, isbn, godina, koricenje, izdavac)) {
								dispose();
								JOptionPane.showMessageDialog(null, "Dodato novo izdanje.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "Vec postoji ovo izdanje u sistemu.", "Greska", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							kontroler.izmeni(izdanje0.getId(), naziv, jezik, zanrovi, autori, opis, udk, isbn, godina, koricenje, izdavac);
							JOptionPane.showMessageDialog(null, "Sacuvani novi podaci.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							
							PrikazKnjiga prikaz1 = new PrikazKnjiga(biblioteka);
		                	prikaz1.setVisible(true);
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Godina mora da bude broj.", "Greska", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Greska pri upisu u fajlove.", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		add(lblNaziv);
		add(tfNaziv, "wrap, span3");
		add(lblJezik);
		add(tfJezik, "wrap, span2");
		add(lblIsbn);
		add(tfIsbn, "wrap, span2");
		add(lblUdk);
		add(tfUdk, "wrap, span2");
		add(lblGodina);
		add(tfGodina, "wrap");
		add(lblOpis);
		add(scrollOpis, "wrap, span3");
		add(lblZanrovi);
		add(scrollZanrovi);
		add(btnDodajZanr);
		add(btnResetZanr, "wrap");
		add(lblAutori);
		add(scrollAutori);
		add(btnDodajAutora);
		add(btnResetAutora, "wrap");
		add(lblIzdavaci);
		add(tfIzdavac, "span2");
		add(btnDodajIzdavaca, "wrap");
		add(lblKoricenje);
		add(plKoricenje, "wrap, span2");
		add(btnDodaj, "wrap, span4, align center");
	}
	
	
	public FormaIzdanje(Biblioteka biblioteka, Knjiga knjiga) {
		setTitle("Dodavanje izdanja");
		osnova(biblioteka, knjiga);
	}
	
	
	public FormaIzdanje(Biblioteka biblioteka, Izdanje izabrano, int br) {
		setTitle("Promena podataka o izdanju");
		osnova(biblioteka, izabrano);
		izdanje0 = izabrano;
		tfNaziv.setText(izabrano.getNaziv());
		tfJezik.setText(izabrano.getJezik());
		tfIsbn.setText(izabrano.getIsbn());
		tfUdk.setText(izabrano.getUdk());
		tfGodina.setText(Integer.toString(izabrano.getGodinaIzdanja()));
		taOpis.setText(izabrano.getOpis());
		int i = 1;
		if (izabrano.getKoricenje() == TipKoricenja.MEK_POVEZ) i = 0;
		plKoricenje.setSelectedIndex(i);
		tfIzdavac.setText(izabrano.getIzdavac().toString());
		izdavac = izabrano.getIzdavac();
		autori = izabrano.getAutori();
		ispisiAutore();
		zanrovi=izabrano.getZanrovi();
		ispisiZanrove();
	}

	
	public void formaIzdavac() {
		JDialog dizd = new FormaIzdavac(this);
		dizd.setVisible(true);
	}
	
	public void formaAutor() {
		JDialog daut = new FormaAutor(this);
		daut.setVisible(true);
	}
	
	public void formaZanr() {
		JDialog dz = new FormaZanr(this);
		dz.setVisible(true);
	}
}
