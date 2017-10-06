# K�ytt�ohje
.jar-tiedosto voidaan suorittaa komentorivilt�.


Esim.
```
java -jar BJKA.jar
```



Oletusarvoisesti ohjelma etsii tiedostoa sy�te.txt hakemistosta, jossa olet.
Jos haluat k�ytt�� jotain muuta sy�tett�, anna sy�tetiedosto argumenttina.


Esim.
```
java -jar BJKA.jar toinen_sy�te.txt
```

## Sy�tetiedoston sis�lt�

Sy�tetiedoston tulisi olla tekstitiedosto, joka koostuu kahdesta rivist�.


1. Alkukortti
2. Pakan korttien lukum��r�t pilkuilla erotettuna, j�rjestyksess� 10, 1, 2, 3, 4, 5, 6, 7, 8, 9


Esim.
```
1
16, 3, 4, 4, 4, 4, 4, 4, 4, 4
```


Alkukortti �ss�, j�ljell� oleva pakka on t�ysi tavallinen korttipakka, josta poistettu yksi �ss�.


Toisesta rivist� vain merkit 0-9 ja ',' luetaan, joten seuraava esimerkki toimii kuten yll�olevakin.
```
1
{kymppi: 16, �ss�: 3, kaksi: 4, kolme: 4, nelj�: 4, viisi: 4, kuusi: 4, seitsem�n: 4, kahdeksan: 4, yhdeks�n: 4}
```

## Suorituskykytesti

Suorituskykytestin saa suoritettua antamalla argumentiksi "suorituskyky".
```
java -jar BJKA.jar suorituskyky
```