# Tuntikirjanpito

|    pvm.   | aika |          aihe         |
|:---------:|:----:|:---------------------:|
| 4.10.2017 |  1h  | Kaaviokuvat           |
| 5.10.2017 | 0.5h | Esimerkki.md          |
| 6.10.2017 |  2h  | Main                  |
| 6.10.2017 | 0.5h | Julkaisu 1.0          |
| 6.10.2017 | 2.5h | MainTest              |
| 6.10.2017 |  1h  | SuorituskykytestiTest |
| 6.10.2017 | 0.5h | Viikkoraportti        |

# Raportti

## Main

* Ohjelmalla on vihdoin k‰yttˆliittym‰. Ajoissa ennen demoa.
* Jouduin rukkaamaan pom.xml-tiedostoa, jotta sain .jar:in toimimaan.
pom.xml taitaa nyt sis‰lt‰‰ p‰‰llek‰isyyksi‰, joita en osaa korjata, koska maven-ymm‰rrykseni on StackOverflow copypasta-tasolla.

## julkaisu 1.0

* Testattu vain Windowsilla.
Luulisi toimivuuden riipuvan Java-versiosta enemm‰n kuin k‰yttiksest‰.
Toivottavasti toimii muillakin k‰yttiksill‰.
* Toivottavasti julkaisu helpottaa koodikatselmoinnin tekemist‰.

## testeist‰

* OTM-kurssista oli rutkasti apua SuorituskykytestiTest:iss‰.
* MainTest:in tekemisest‰ n. tunti oli yhden bugin korjaamista. Olin unohtanut yhden rivin: lukija.close(). :rage:
* SuorituskykytestiTest:i‰ varten kirjoitettu Kello on ainut, jolla ei ole 100% testikattavuutta.
Sit‰ ei ehk‰ edes voi testata. :thinking:

## seuraavaksi

* Taulukon koon optimoiminen ei edennyt t‰ll‰ viikolla lainkaan.
Suunnitelma on edelleen kirjoittaa erillinen ohjelma selvitt‰m‰‰n pienimm‰t mahdollisimmat arvot.