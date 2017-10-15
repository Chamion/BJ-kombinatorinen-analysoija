# Tuntikirjanpito

| pvm.       | aika. | aihe                |
|------------|-------|---------------------|
| 14.10.2017 | 2h    | optimisaatio.py     |
| 15.10.2017 | 2h    | koodin kommentointi |

# Raportti

## optimisaatio.py
* Ei teknisesti ole osa koodia, joten sitä ei ole testattu. Käytännössä AnalysoijaTest älähtää,
jos apuohjelma ei toimi.
* Kirjoitettu Pythonilla, koska se ei ole osa ohjelmaa ja Python on helpompaa.

## Bugi!
* Alkukortilla 1 seuraavat kädet saivat saman koodin edellisessä toteutuksessa: 26 ja 1111161111
* optimisaatio.py paljasti yhteentörmäyksen aiemmassa toteutuksessa.
* Bugi aiheutti niin pienen virheen, että se jäi viimeisen merkitsevän numeron oikealle puolelle
AnalysoijaTestissä.

## Bugi vai feature?
* Väärinkäyttö sekoittaa Jono-luokan toiminnan.
* Bugi: toimii väärin tietyissä tilanteissa, joita ei esiinny ohjelmassa.
* Feature: Turhat tarkistelut on jätetty pois ja näin on säästetty kellosyklejä.

## Kommentit
* Kaikki kiinnostavat metodit on kommentoitu.

## Testaus
* Kello-luokkaan en keksinyt ratkaisua. Muuten edelleen 100% kattavuus.