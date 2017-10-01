# Tuntikirjanpito
1.10. 2h Testien kirjoittamista.
1.10. 2h Hajautustaulun korvaaminen ja algoritmin opimoimista.
1.10. 1h Dokumentaation vääntöä.

# Raportti

## testeistä

* PakkaTestin pitKattavuusBoosteri testaa... jotakin. Toivottavasti (ja luultavasti) siihen ei ole mitään asiaa koskea enää.
* AnalysoijaTest vahingossa paransi testikattavuutta muissakin luokissa. Onko se huijaamista?
* AnalysoijaTest paljasti tarpeettoman ehtolauseen Analysoija-luokassa. Testien kirjoittaminen tuntuu aina tarpeettomalta ennen niiden kirjoittamista ja välttämättömältä jälkeenpäin.

## hajautustaulun korvannut taulukko

* Taulukon koko voisi olla pienempi. Täytynee selvittää, miten pienimmän mahdollisen koon voi selvittää matemaattisesti.
* Hajautustaulun korvaaminen taulukolla paransi ohjelman suorituskykytuloksia n. 20%.
* Uskon taulukon olevan tehokkaampi toteutus kuin mikään hajautustauluun perustuva toteutus, vaikka taulukkoon jää tyhjiä paikkoja.

## muuta

* O-analyysi on ohjelman kannalta hieman kömpelöä, sillä ohjelman syöte voi olla vain rajoitettu joukko 1-10 ja syötteenä oleva pakka ei vaikuta vaativuuksiin.

## seuraavaksi

* Käyttöliittymä tulisi luoda viimeistään ennen demoa.
* Tod. näk. joudun kirjoittamaan ohjelman, joka optimoi taulukon koon.