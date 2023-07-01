package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.NotSavedException;
import kontroleri.IzdanjaKontroler;
import model.Autor;
import model.Biblioteka;
import model.Izdavac;
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
	
	public List<Autor> autori = new ArrayList<Autor>();
	public List<Zanr> zanrovi = new ArrayList<Zanr>();
	public Izdavac izdavac = null;
	
	
	public IzdanjaKontroler kontroler;

	public void dodajAutora(Autor autor) {
		autori.add(autor);
		String t = "";
		for (Autor a : autori) {
			t += a.toString() + "; ";
		}
		taAutori.setText(t);
	}


	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
		this.tfIzdavac.setText(izdavac.toString());
	}


	public FormaIzdanje(Biblioteka biblioteka) {
		
		this.kontroler = new IzdanjaKontroler(biblioteka);
		
		setSize(new Dimension(520, 750));
		setLocationRelativeTo(null);
		setTitle("Dodavanje izdanja");
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
		taOpis = new JTextArea(260, 200);
		JScrollPane scrollOpis = new JScrollPane(taOpis);
		scrollOpis.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollOpis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		Labela lblAutori = new Labela("Autori:", fntLabela, clrTercijarna);
		taAutori = new JTextArea(260, 200);
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
		
		
		
		Labela lblZanrovi = new Labela("�anrovi:", fntLabela, clrTercijarna);
		taZanrovi = new JTextArea(260, 200);
		JScrollPane scrollZanrovi = new JScrollPane(taZanrovi);
		scrollZanrovi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollZanrovi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		FormaDugme btnDodajZanr = new FormaDugme("Dodaj zanr", clrSekundarna, clrForeground, 150, 20);
		btnDodajZanr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
		PadajucaLista plKoricenje = new PadajucaLista(tipoviK,
				clrSekundarna, clrForeground, fntTekstPolje, 240, 30);
		
		
		
		FormaDugme btnDodaj = new FormaDugme("Dodaj izdanje", clrSekundarna, clrForeground, 150, 20);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				try {
					System.out.print(true);
					
					
					zatvori();
					}
				catch (MissingValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (NotSavedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				}
				*/
			}
		});
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblNaziv);
		add(tfNaziv, "wrap");
		
		add(lblJezik);
		add(tfJezik, "wrap");
		
		add(lblIsbn);
		add(tfIsbn, "wrap");
		
		add(lblUdk);
		add(tfUdk, "wrap");
		
		add(lblGodina);
		add(tfGodina, "wrap");
		
		add(lblOpis);
		add(scrollOpis, "wrap");
		
		add(lblZanrovi);
		add(scrollZanrovi, "wrap");
		
		add(lblAutori);
		add(scrollAutori, "wrap");
		add(btnDodajAutora, "wrap");

		add(lblIzdavaci);
		add(tfIzdavac, "wrap");
		add(btnDodajIzdavaca, "wrap");
		
		add(btnDodaj, "wrap, span2, align center");
		
	}
	
	
	private void zatvori() {
		this.dispose();
	}
	
	public void formaIzdavac() {
		JDialog dizd = new FormaIzdavac(this);
		dizd.setVisible(true);
	}
	
	public void formaAutor() {
		JDialog daut = new FormaAutor(this);
		daut.setVisible(true);
	}
}