# Ohjelman rakenne
Ohjelma käy läpi kaikki mahdolliset tapahtumaketjut, jotka voivat seurata lähtöasetelmaa. Tapahtumaketjut muodostuvat TapahtumaSolmuista.


TapahtumaSolmu muodostuu hetkellisestä tilanteesta, jossa jakajan käsi ei vielä ole valmis, eli joudutaan nostamaan lisää kortteja.
TapahtumaSolmun määrittelemiseksi vaaditaan jakajan käden arvo ja pakassa jäljellä olevien korttien lukumäärät.
Lisäksi TapahtumaSolmuihin liittyy todennäköisyys, jolla tilanne esiintyy.


Lähtösolmun todennäköisyys on 1. Jokainen TapahtumaSolmu saa 10 lasta, jotka voivat olla päätepisteitä (jakajan käsi on valmis) tai TapahtumaSolmuja (jakajan käsi ei ole valmis).


Päätepisteiden todennäköisyydet lisätään suoraan TulosVektoriin sopivaan kohtaan. Esim. Päätepiste, jossa jakajan käden arvo on 20 merkitään TulosVektorin tulos20 lukuun.
TulosVektorin luku on siis kaikkien siihen jakajan käden arvoon päättyvien tapahtumaketjujen todennäköisyyksien summa. TulosVektorin kaikkien lukujen summa on 1.


TapahtumaSolmun lapset, jotka eivät ole päätepisteitä, ovat TapahtumaSolmuja. Jos TapahtumaSolmu on uusi (sitä ei löydy mapista), se tallennetaan map-olioon ja jonoon.
TapahtumaSolmu koodataan taulukkoon kokonaislukukoodin avulla. Jonoon merkitään vain tämä kokonaislukukoodi.


Kokonaislukukoodi saadaan antamalla jokaiselle jakajan käden kortille lukuarvo kortin arvon perusteella (alkukorttia lukuunottamatta) ja laskemalla nämä lukuarvot yhteen.
Korttien arvoja vastaavat lukuarvot on valittu siten, että erilaisten käsien lukuarvojen summat eivät ole samat millään jakajan käsillä, joiden arvo on 16 tai pienempi.
Käytännössä keksin ne yritys-erehdys menetelmällä.


Lähtösolmu on käsiteltävä erikseen Blackjack-erikoistapauksen takia. Blackjack todennäköisyydet lasketaan kovakoodatulla logiikalla lähtösolmun käsittelyssä.


# Aika- ja tilavaativuus

Analysoija kutsuu kasitteleTapahtuma-metodia tasan kerran jokaista käsiteltävää TapahtumaSolmua kohti. Aikavaativuus on siis luokkaa O(k), missä k on TapahtumaSolmujen lukumäärä.
Kaikki käsiteltävät TapahtumaSolmut tallennetaan taulukkoon, jonka koko on m samanaikaisesti. Voidaan siis todeta k <= m.
Aikavaativuudeksi saadaan O(m).


TIlavaativuus muodostuu analysoijan kahden tietorakenteen tilavaativuuksista.
Taulukon koko on m ja jonoon tallennetaan vain taulukon indeksejä, eli jonon koko on pienempi tai yhtäsuuri kuin m.
Tilavaativuudeksi saadaan siis O(m + m) = O(m).


Kirjoitushetkellä m = 2206.

# Parannettavaa

m voisi olla pienempi, jos Korttien arvojen vastaavia lukuarvoja viilaisi. Parasta olisi ratkaista pienin m matemaattisesti. Näin tulisi samalla todistettua m olevan pienin mahdollinen.


Ohjelma selvittää jakajan käden todennäköisyydet, mikä ei ole itsessään hyödyllistä, vaan vaatii vielä pelaajan käden todennäköisyyksien laskemisen, jotta saadaan selville rahanarvoista tietoa tietyn pakan kannattavuudesta pelaajalle.