# Suorituskykytestaus

Suorituskykytesti selvitt�� todenn�k�isyydet kaikille mahdollisille alkukorteille kerran samalla pakalla ja mittaa t�h�n kuluneen ajan.


Testi mittaa ohjelman suorituskyky� sovelluksessa, joka laskee BJ pelin kannattavuutta tietyll� pakalla.
T�llainen sovellus laskee todenn�k�isyydet jokaiselle mahdolliselle alkukortille jokaisella mahdollisella pakalla kerran.
Testi siis painottaa kaikkia alkukortteja yht� t�rkein�, kuten tekee my�s tosiel�m�n sovellus.


K�ytetyll� pakalla ei ole suurta merkityst� suorituskykyyn. Pakka voi siis olla mik� tahansa.


Suorituskykytestin suorittaminen kesti ohjelmalta ajan v�lilt� 5ms - 10ms, mutta normaalit ajat olivat v�lilt� 6ms - 8ms.

# Yksikk�testit

Ohjelma on kattavasti yksikk�testattu. Testit l�ytyv�t Test Packages-kansiosta maven-projektissa.


Huomionarvoinen testi on AnalysoijaTest.
Analysoijan toiminnan oikeellisuuden testaaminen vaatii vastaavan ohjelman kirjoittamista ja oikeelliseksi toteamista.
Jos analysoija saa samat tulokset kuin oikeelliseksi todettu analysoija, on sekin oikeellinen.
Yhden analysoijan oikeellisuus nojaa siis aina jonkin toisen analysoijan oikeellisuuteen.
AnalysoijaTest olettaa Michael Shacklefordin toteutuksen olevan oikeellinen.
Shackleford on laajalti luotettu uhkapelien matematiikan asiantuntija.
Shacklefordin ohjelman tulokset l�ytyv�t h�nen [Wizard of Odds](https://wizardofodds.com/games/blackjack/appendix/2b/) sivustoltaan.