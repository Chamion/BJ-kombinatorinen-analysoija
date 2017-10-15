# Tuntikirjanpito

| pvm.       | aika. | aihe                |
|------------|-------|---------------------|
| 14.10.2017 | 2h    | optimisaatio.py     |
| 15.10.2017 | 2h    | koodin kommentointi |

# Raportti

## optimisaatio.py
* Ei teknisesti ole osa koodia, joten sit� ei ole testattu. K�yt�nn�ss� AnalysoijaTest �l�ht��,
jos apuohjelma ei toimi.
* Kirjoitettu Pythonilla, koska se ei ole osa ohjelmaa ja Python on helpompaa.

## Bugi!
* Alkukortilla 1 seuraavat k�det saivat saman koodin edellisess� toteutuksessa: 26 ja 1111161111
* optimisaatio.py paljasti yhteent�rm�yksen aiemmassa toteutuksessa.
* Bugi aiheutti niin pienen virheen, ett� se j�i viimeisen merkitsev�n numeron oikealle puolelle
AnalysoijaTestiss�.

## Bugi vai feature?
* V��rink�ytt� sekoittaa Jono-luokan toiminnan.
* Bugi: toimii v��rin tietyiss� tilanteissa, joita ei esiinny ohjelmassa.
* Feature: Turhat tarkistelut on j�tetty pois ja n�in on s��stetty kellosyklej�.

## Kommentit
* Kaikki kiinnostavat metodit on kommentoitu.

## Testaus
* Kello-luokkaan en keksinyt ratkaisua. Muuten edelleen 100% kattavuus.