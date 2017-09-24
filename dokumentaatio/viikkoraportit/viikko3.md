# Tuntikirjanpito
20.9. 1h Toteutusdokumentin aloitus
23.9. 2h Jono-tietorakenne
24.9. 3h testej�, bugi-korjauksia, maven, raportti

# Raportti


Jono-tietorakenne ei ole korvike yleiselle jonolle, vaan projektin k�ytt��n optimoitu tietorakenne, joka projektin k�ytt�tarkoituksissa korvaa jonon.
Uusi Jono n�ytt�� ensisilm�yksell� olevan tehokkaampi kuin LinkedList, vaikka Jonon koko on viel� optimoimatta.


J�lkiviisautta: TulosVektori ei ole hyv� tai edes kovin luettava ratkaisu. Refaktorointi taulukko-olioksi tms. on paikallaan.


Jonon testit paljastivat bugin, joka saa t�yden Jonon palauttamaan isEmpty() metodilla true.
Bugin korjaaminen heikent�isi Jonon suorituskyky�. On siis tehokkaampaa varata jonolle enemm�n tilaa, kuin huolehtia rajatapauksesta.
Tulisoko bugi silti korjata? Vaihtoehtoisesti maksimikoon voisi m��ritell� olevan maxKoko - 1.
Samantapainen tilanne on Jonon get()-metodissa. Jos get()-metodia kutsutaan tyhj�ll� jonolla, Jono palauttaa arvon taulukon indeksist�, miss� ei ole arvoa (jo-poistettu arvo tai NaN).
get()-metodia kuitenkin kutsutaan ainoastaan while-silmukassa, jonka ehtona on !jono.isEmpty(). Onko kyseess� bugi, jos ohjelma ei ikin� kutsu metodia "v��rin"?


Aloitin kirjoittamaan Toteutusdokumenttia suurelti omien ajatusten selvent�miseksi. Dokumentin tiedot voivat viel� vanhentua.


Map-olion voisi korvata joko omalla map-toteutuksella tai jopa taulukolla, jos kokonaislukukoodeja optimoisi hieman.
Map-toteutus on selv�sti tilatehokkaampi.
J�� pohdittavaksi, kumpi on aikatehokkaampi.