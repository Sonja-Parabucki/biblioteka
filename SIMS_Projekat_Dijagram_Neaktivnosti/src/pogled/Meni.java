package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import kontroleri.NaloziKontroler;
import model.Biblioteka;
import model.Nalog;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class Meni extends JFrame{

	private static final long serialVersionUID = 2093555672327447850L;
	
	public Meni(Biblioteka biblioteka) {
		
		setSize(new Dimension(500, 400));
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
		
		FormaDugme prikazIzdanja = new FormaDugme("Prikaz izdanja", clrPrimarna, clrForeground, 70, 30);
		prikazIzdanja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		FormaDugme btnPrimeraka = new FormaDugme("Dodavanje primeraka", clrPrimarna, clrForeground, 70, 30);
		btnPrimeraka.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
		
		FormaDugme btnClanovi = new FormaDugme("Dodavanje clanova", clrPrimarna, clrForeground, 70, 30);
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
		pnlPrijava.add(btnClanovi, "wrap, align center");
		pnlPrijava.add(btnIzdanja, "wrap, align center");
		pnlPrijava.add(btnPrimeraka, "wrap, align center");
		pnlPrijava.add(btnIzlaz, "wrap, align center");
		add(pnlPrijava);
	}

}
