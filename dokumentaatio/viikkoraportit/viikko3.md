# Tuntikirjanpito
20.9. 1h Toteutusdokumentin aloitus
23.9. 2h Jono-tietorakenne
24.9. 3h testejä, bugi-korjauksia, maven, raportti

# Raportti


Jono-tietorakenne ei ole korvike yleiselle jonolle, vaan projektin käyttöön optimoitu tietorakenne, joka projektin käyttötarkoituksissa korvaa jonon.
Uusi Jono näyttää ensisilmäyksellä olevan tehokkaampi kuin LinkedList, vaikka Jonon koko on vielä optimoimatta.


Jälkiviisautta: TulosVektori ei ole hyvä tai edes kovin luettava ratkaisu. Refaktorointi taulukko-olioksi tms. on paikallaan.


Jonon testit paljastivat bugin, joka saa täyden Jonon palauttamaan isEmpty() metodilla true.
Bugin korjaaminen heikentäisi Jonon suorituskykyä. On siis tehokkaampaa varata jonolle enemmän tilaa, kuin huolehtia rajatapauksesta.
Tulisoko bugi silti korjata? Vaihtoehtoisesti maksimikoon voisi määritellä olevan maxKoko - 1.
Samantapainen tilanne on Jonon get()-metodissa. Jos get()-metodia kutsutaan tyhjällä jonolla, Jono palauttaa arvon taulukon indeksistä, missä ei ole arvoa (jo-poistettu arvo tai NaN).
get()-metodia kuitenkin kutsutaan ainoastaan while-silmukassa, jonka ehtona on !jono.isEmpty(). Onko kyseessä bugi, jos ohjelma ei ikinä kutsu metodia "väärin"?


Aloitin kirjoittamaan Toteutusdokumenttia suurelti omien ajatusten selventämiseksi. Dokumentin tiedot voivat vielä vanhentua.


Map-olion voisi korvata joko omalla map-toteutuksella tai jopa taulukolla, jos kokonaislukukoodeja optimoisi hieman.
Map-toteutus on selvästi tilatehokkaampi.
Jää pohdittavaksi, kumpi on aikatehokkaampi.