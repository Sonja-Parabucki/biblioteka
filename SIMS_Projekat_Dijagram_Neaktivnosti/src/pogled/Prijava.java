package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import kontroleri.NaloziKontroler;
import model.Biblioteka;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class Prijava extends JFrame{

	private static final long serialVersionUID = 2093555672327447850L;
	
	private TekstPolje tfKorIme;
	private LozinkaPolje tfLozinka;
	private NaloziKontroler naloziKontroler;
	
	public Prijava(Biblioteka biblioteka) {
		
		setSize(new Dimension(500, 400));
		setTitle("Prijava");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	
		this.naloziKontroler = new NaloziKontroler(biblioteka);
		
		Font fntNaslov = PogledUtil.getMaliNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		
		JPanel pnlPrijava = new JPanel();
		
		Labela lblNaslov = new Labela("Prijavite se na sistem", fntNaslov, clrForeground);
		
		JLabel lblImage = new JLabel("");
		
		Labela lblKorIme = new Labela("Korisničko ime: ", fntLabela, clrForeground);
		tfKorIme = new TekstPolje("", fntTekstPolje, 140, 30);
		
		Labela lblLozinka = new Labela("Lozinka: ", fntLabela, clrForeground);
		tfLozinka = new LozinkaPolje("", 140, 30);
		
		FormaDugme btnPrijava = new FormaDugme("Prijava", clrPrimarna, clrForeground, 70, 30);
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					naloziKontroler.login(tfKorIme.getText(), String.valueOf(tfLozinka.getPassword()));
					zatvori();
					otvoriProzor();
				} catch (MissingValueException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadCredentialsException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);	
				}
			}

			private void otvoriProzor() {
				switch (biblioteka.getPrijavljeniKorisnik().getTip()) {
				case OBICAN_BIBLIOTEKAR: break;
				case VISI_BIBLIOTEKAR:
					Meni prozor = new Meni(biblioteka);
					prozor.setVisible(true);
					break;
				case CLAN: break;
				case ADMIN: break;
				}
				
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
		pnlPrijava.setLayout(new MigLayout("", "[][]", "30[]20[]20[]10[]10[]"));
		
		pnlPrijava.add(lblNaslov, "wrap, span2, align center");
		pnlPrijava.add(lblImage, "wrap, span2, align center");
		pnlPrijava.add(lblKorIme, "gapleft 30");
		pnlPrijava.add(tfKorIme, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(lblLozinka, "gapleft 30");
		pnlPrijava.add(tfLozinka, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(btnPrijava, "span2, split2, align right");
		pnlPrijava.add(btnIzlaz, "gapright 30");
		add(pnlPrijava);
	}
	
	private void zatvori() {
		this.dispose();
	}

}
