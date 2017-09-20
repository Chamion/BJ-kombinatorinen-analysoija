# Ohjelman rakenne
Ohjelma käy läpi kaikki mahdolliset tapahtumaketjut, jotka voivat seurata lähtöasetelmaa. Tapahtumaketjut muodostuvat TapahtumaSolmuista.


TapahtumaSolmu muodostuu hetkellisestä tilanteesta, jossa jakajan käsi ei vielä ole valmis, eli joudutaan nostamaan lisää kortteja.
TapahtumaSolmun määrittelemiseksi vaaditaan jakajan käden arvo ja pakassa jäljellä olevien korttien lukumäärät.
Lisäksi TapahtumaSolmuihin liittyy todennäköisyys, jolla tilanne esiintyy.


Lähtösolmun todennäköisyys on 1. Jokainen TapahtumaSolmu saa 10 lasta, jotka voivat olla päätepisteitä (jakajan käsi on valmis) tai TapahtumaSolmuja (jakajan käsi ei ole valmis).


Päätepisteiden todennäköisyydet lisätään suoraan TulosVektoriin sopivaan kohtaan. Esim. Päätepiste, jossa jakajan käden arvo on 20 merkitään TulosVektorin tulos20 lukuun. TulosVektorin luku on siis kaikkien siihen jakajan käden arvoon päättyvien tapahtumaketjujen todennäköisyyksien summa. TulosVektorin kaikkien lukujen summa on 1.


TapahtumaSolmun lapset, jotka eivät ole päätepisteitä, ovat TapahtumaSolmuja. Jos TapahtumaSolmu on uusi (sitä ei löydy mapista), se tallennetaan map-olioon ja jonoon. TapahtumaSolmu koodataan map-olioon kokonaislukukoodin avulla. Jonoon merkitään vain tämä kokonaislukukoodi.


Kokonaislukukoodi on käytännössä lukujono, jossa jokainen luku kuvaa tietyn arvoisten korttien lukumäärää jakajan kädessä (lukuunottamatta alkukorttia). Luvut ovat järjestyksessä 10, 1, 2, 3, 4, 5, 6, 7, 8, 9. TapahtumaSolmut koodataan näin, koska nostamalla samat kortit, päädytään samaan tilanteeseen riippumatta korttien järjestyksestä. Esim. nostamalla kortit 3 ja 5 päädytään samaan tilanteeseen kuin nostamalla 5 ja 3.
Suurin mahdollinen lukumäärä samanarvoisia kortteja on kädessä (1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1). Tämän käden alkukortti on aina oltava 1, joten suurin määrä samanarvoisia kortteja on 9. Vältymme siis yhteentörmäyksiltä.


Lähtösolmu on käsiteltävä erikseen Blackjack-erikoistapauksen takia. Blackjack todennäköisyydet lasketaan kovakoodatulla logiikalla lähtösolmun käsittelyssä.
