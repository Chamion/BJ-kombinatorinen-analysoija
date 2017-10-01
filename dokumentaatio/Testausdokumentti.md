# Suorituskykytestaus

Suorituskykytesti selvittää todennäköisyydet kaikille mahdollisille alkukorteille kerran samalla pakalla ja mittaa tähän kuluneen ajan.


Testi mittaa ohjelman suorituskykyä sovelluksessa, joka laskee BJ pelin kannattavuutta tietyllä pakalla.
Tällainen sovellus laskee todennäköisyydet jokaiselle mahdolliselle alkukortille jokaisella mahdollisella pakalla kerran.
Testi siis painottaa kaikkia alkukortteja yhtä tärkeinä, kuten tekee myös tosielämän sovellus.


Käytetyllä pakalla ei ole suurta merkitystä suorituskykyyn. Pakka voi siis olla mikä tahansa.


Suorituskykytestin suorittaminen kesti ohjelmalta ajan väliltä 5ms - 10ms, mutta normaalit ajat olivat väliltä 6ms - 8ms.

# Yksikkötestit

Ohjelma on kattavasti yksikkötestattu. Testit löytyvät Test Packages-kansiosta maven-projektissa.


Huomionarvoinen testi on AnalysoijaTest.
Analysoijan toiminnan oikeellisuuden testaaminen vaatii vastaavan ohjelman kirjoittamista ja oikeelliseksi toteamista.
Jos analysoija saa samat tulokset kuin oikeelliseksi todettu analysoija, on sekin oikeellinen.
Yhden analysoijan oikeellisuus nojaa siis aina jonkin toisen analysoijan oikeellisuuteen.
AnalysoijaTest olettaa Michael Shacklefordin toteutuksen olevan oikeellinen.
Shackleford on laajalti luotettu uhkapelien matematiikan asiantuntija.
Shacklefordin ohjelman tulokset löytyvät hänen [Wizard of Odds](https://wizardofodds.com/games/blackjack/appendix/2b/) sivustoltaan.