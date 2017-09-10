Blackjack on uhkapeli, jossa on mahdollista saada pelaajana yli 100% teoreettinen palautus, jos jäljellä oleva pakka on pelaajalle edullinen. Ohjelman tulisi kertoa käyttäjälle mitkä ovat jakajan käden todennäköisyydet käyttäjän syöttämällä pakalla. Jakajan käden todennäköisyydet ovat tärkeä osa blackjack pelin teoreettisen palautuksen laskemista. Teoreettisen palautuksen laskeminen olisi kuitenkin liian suuri projekti kurssin aikana toteutettavaksi.


Ohjelma saa syötteenään jakajan ensimmäisen kortin ja pakassa jäljellä olevien korttien arvot.


Esim. Jakajan kortti: 10, Jäljellä oleva pakka: A: 10, 2: 12, 3: 10, 4: 11, 5: 9, 6: 16, 7: 11, 8: 7, 9: 12, 10: 38


Ohjelma antaa ulostulona jakajan käden mahdolliset arvot ja niiden todennäköisyydet.


Esim. 17: 0.138, 18: 0.138, 19: 0.138, 20: 0.138, 21: 0.138, BJ: 0.0, yli: 0.31


Ohjelma tulee hyödyntämään rekursiivista algoritmia, joka analysoi kaikkien mahdollisten tapahtumahaarojen todennäköisyydet ja arvot kutsumalla samaa metodia uudestaan eri arvoilla.
Lisäksi ohjelma vaatii suunnatun verkon tai puun, mihin tallennetaan välituloksia, sillä rekursiivinen algoritmi yksinään laskisi samoja välituloksia monesti ja siten ajautuisi suorituskykyongelmiin.


Lopullisen ohjelman tulisi soveltua käytettäväksi suuremmassa ohjelmassa, joka laskee sen avulla arvoja useasti, joten suorituskyky on moninkertaisesti tärkeä. 
Rekursion tulisi suorittua lineaarisessa ajassa, kunhan välitulosten verkko/puu on laskettu. välituloksia tarvitaan määrä, joka on pienempi kuin mahdollisten tapahtumasarjojen määrä. Mahdollisten tapahtumasarjojen määrä riippuu syötteestä.
Mahdollisia tapahtumasarjoja on luokkaa n^n, missä n on nostettujen korttien määrä. Aikavaativuus on siis eksponentiaalinen, mutta onneksi 1 <= n <= 10. Tilavaativuus on myös riippuvainen välitulosten tietorakenteen koosta ja käyttäytyy siis samoin kuin aikavaativuus.


Ohjelman toteutus tukee erinomaisesti kurssin tavoitteita ja lopullinen ohjelma menee toivottavasti hyvään käyttöön.
