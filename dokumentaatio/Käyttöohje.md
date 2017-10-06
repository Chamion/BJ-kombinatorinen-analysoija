# Käyttöohje
.jar-tiedosto voidaan suorittaa komentoriviltä.


Esim.
```
java -jar BJKA.jar
```



Oletusarvoisesti ohjelma etsii tiedostoa syöte.txt hakemistosta, jossa olet.
Jos haluat käyttää jotain muuta syötettä, anna syötetiedosto argumenttina.


Esim.
```
java -jar BJKA.jar toinen_syöte.txt
```

## Syötetiedoston sisältö

Syötetiedoston tulisi olla tekstitiedosto, joka koostuu kahdesta rivistä.


1. Alkukortti
2. Pakan korttien lukumäärät pilkuilla erotettuna, järjestyksessä 10, 1, 2, 3, 4, 5, 6, 7, 8, 9


Esim.
```
1
16, 3, 4, 4, 4, 4, 4, 4, 4, 4
```


Alkukortti ässä, jäljellä oleva pakka on täysi tavallinen korttipakka, josta poistettu yksi ässä.


Toisesta rivistä vain merkit 0-9 ja ',' luetaan, joten seuraava esimerkki toimii kuten ylläolevakin.
```
1
{kymppi: 16, ässä: 3, kaksi: 4, kolme: 4, neljä: 4, viisi: 4, kuusi: 4, seitsemän: 4, kahdeksan: 4, yhdeksän: 4}
```

## Suorituskykytesti

Suorituskykytestin saa suoritettua antamalla argumentiksi "suorituskyky".
```
java -jar BJKA.jar suorituskyky
```