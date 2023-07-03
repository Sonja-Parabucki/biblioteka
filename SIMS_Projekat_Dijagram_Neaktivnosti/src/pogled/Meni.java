package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import kontroleri.KorisnikKontroler;
import model.Biblioteka;
import model.Nalog;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class Meni extends JFrame{

	private static final long serialVersionUID = 2093555672327447850L;
	
	public Meni(Biblioteka biblioteka) {
		
		setSize(new Dimension(500, 600));
		setTitle("Meni");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Font fntNaslov = PogledUtil.getMaliNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		
		JPanel pnlPrijava = new JPanel();
		
		Labela lblNaslov = new Labela("Prijavljeni korisnik: " + biblioteka.getPrijavljeniKorisnik().getKorisnickoIme(), fntLabela, clrForeground);
		
		FormaDugme prikazIzdanja = new FormaDugme("Prikaz knjiga", clrPrimarna, clrForeground, 70, 30);
		prikazIzdanja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazKnjiga prikaz = new PrikazKnjiga(biblioteka);
				prikaz.setVisible(true);
			}
		});
		
		FormaDugme btnPrimeraka = new FormaDugme("Dodavanje primeraka", clrPrimarna, clrForeground, 70, 30);
		btnPrimeraka.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePrimerka prozor = new DodavanjePrimerka(biblioteka);
				prozor.setVisible(true);
			}
		});
		
		FormaDugme btnIzdanja = new FormaDugme("Dodavanje izdanja", clrPrimarna, clrForeground, 70, 30);
		btnIzdanja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog prozor = new FormaIzdanje(biblioteka);
				prozor.setVisible(true);
			}
		});
		
		FormaDugme btnClanoviPrikaz = new FormaDugme("Prikaz clanova", clrPrimarna, clrForeground, 70, 30);
		btnClanoviPrikaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrikazClanovi pc = new PrikazClanovi(biblioteka);
				pc.setVisible(true);
			}
		});
		
		FormaDugme btnClanovi = new FormaDugme("Dodavanje clanova", clrPrimarna, clrForeground, 70, 30);
		btnClanovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeClana prikaz;
				try {
					prikaz = new DodavanjeClana(biblioteka);
					prikaz.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		FormaDugme btnIznajmi = new FormaDugme("Iznajmljivanje knjige", clrPrimarna, clrForeground, 70, 30);
		btnClanovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		FormaDugme btnVrati = new FormaDugme("Vracanje knjige", clrPrimarna, clrForeground, 70, 30);
		btnClanovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		FormaDugme btnIzlaz = new FormaDugme("Izlaz", clrPrimarna, clrForeground, 70, 30);
		btnIzlaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		pnlPrijava.setBackground(clrPrimarna);
		pnlPrijava.setLayout(new MigLayout("", "180[]", "20[]30[]20[]20[]20[]30[]"));
		
		pnlPrijava.add(lblNaslov, "wrap, align center");
		pnlPrijava.add(prikazIzdanja, "wrap, align center");
		pnlPrijava.add(btnClanoviPrikaz, "wrap, align center");
		pnlPrijava.add(btnClanovi, "wrap, align center");
		pnlPrijava.add(btnIzdanja, "wrap, align center");
		pnlPrijava.add(btnPrimeraka, "wrap, align center");
		pnlPrijava.add(btnIznajmi, "wrap, align center");
		pnlPrijava.add(btnVrati, "wrap, align center");
		pnlPrijava.add(btnIzlaz, "wrap, align center");
		add(pnlPrijava);
	}

}
