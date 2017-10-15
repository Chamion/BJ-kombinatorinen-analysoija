#Annetaan aluksi kertoimille niin suuret arvot, ettei yhteentörmäyksiä voi tapahtua.
kertoimet = [10**0, 10**1, 10**2, 10**3, 10**4, 10**5, 10**6, 10**7, 10**8, 10**9]

"""
Tarkistaa, onko summa saavutettu jo jollain aiemmalla kombinaatiolla.
summa on kokonaisluku, jota tarkistetaan.
summat on taulu, jossa on kaikki jo-esiintyneiden summien indeksit täytetty True-arvoilla. Muuten tyhjä.
"""
def tarkista(summa, summat):
    try:
        return summat[summa]
    except:
        return False

"""
Kun arvo = 15, ensimmäisen kortin on oltava ollut 1. Simuloimalla käden muodostumista selvitetään, voiko
parametrina annettu kombinaatio muodostua lähtien alkukortista 1 ilman, että jokin pehmeä käsi olisi jo
ollut yli 16.
"""
def simuloi15(lkm1, lkm2, lkm3, lkm4, lkm5, suuri_kortti):
    for simul1 in range(lkm1+1):
        for simul2 in range(lkm2+1):
            for simul3 in range(lkm3+1):
                for simul4 in range(lkm4+1):
                    for simul5 in range(lkm5+1):
                        arvo = 1*simul1 + 2*simul2 + 3*simul3 + 4*simul4 + 5*simul5
                        if arvo < 6 and arvo + suuri_kortti > 10:
                            return True
    return False

"""
Tarkistaa kaikki kombinaatiot yhteentörmäysten varalta.
Vain mahdolliset Blackjack kädet otetaan huomioon.
"""
def tarkistaKaikki():
    summat = {}
    for lkm1 in range(10):
        for lkm2 in range(8):
            for lkm3 in range(6):
                for lkm4 in range(4):
                    for lkm5 in range(3):
                        for lkm6 in range(3):
                            for lkm7 in range(3):
                                for lkm8 in range(2):
                                    for lkm9 in range(2):
                                        for lkm10 in range(2):
                                            #Käden arvo lukuunottamatta alkukorttia.
                                            #Alkukortti voi olla mikä tahansa.
                                            arvo = (1 * lkm1 +
                                                    2 * lkm2 +
                                                    3 * lkm3 +
                                                    4 * lkm4 +
                                                    5 * lkm5 +
                                                    6 * lkm6 +
                                                    7 * lkm7 +
                                                    8 * lkm8 +
                                                    9 * lkm9 +
                                                    10 * lkm10)
                                            #Jos kombinaatio ei ole mahdollinen Blackjack käsi, continue.
                                            if arvo >= 16:
                                                continue
                                            if (lkm2 == 0 and
                                                lkm3 == 0 and
                                                lkm4 == 0 and
                                                lkm5 == 0 and
                                                lkm6 == 0 and
                                                lkm7 == 0 and
                                                lkm8 == 0 and
                                                lkm9 == 0 and
                                                lkm10 == 0 and
                                                lkm1 >= 6):
                                                continue
                                            #Jos arvo = 15, alkukortti on 1.
                                            if arvo == 15:
                                                #Alkukortilla 1 on oltava jokin kortti, joka on suurempi, kuin
                                                #5, jotta voidaan päästä arvoon 15.
                                                if (lkm6 == 0 and
                                                    lkm7 == 0 and
                                                    lkm8 == 0 and
                                                    lkm9 == 0 and
                                                    lkm10 == 0):
                                                    continue
                                                #Jos kortteja, jotka ovat suurempia kuin 5, on enemmän kuin 1,
                                                #kombinaatio ei voi olla muodostunut alkukortilla 1.
                                                if lkm10 > 0:
                                                    suuri_kortti = 10
                                                elif lkm9 > 0:
                                                    suuri_kortti = 9
                                                elif lkm8 > 0:
                                                    suuri_kortti = 8
                                                elif lkm7 > 0:
                                                    suuri_kortti = 7
                                                elif lkm6 > 0:
                                                    suuri_kortti = 6
                                                if not simuloi15(lkm1, lkm2, lkm3, lkm4, lkm5, suuri_kortti):
                                                    continue
                                            
                                            summa = (kertoimet[0]*lkm1 +
                                                     kertoimet[1]*lkm2 +
                                                     kertoimet[2]*lkm3 +
                                                     kertoimet[3]*lkm4 +
                                                     kertoimet[4]*lkm5 +
                                                     kertoimet[5]*lkm6 +
                                                     kertoimet[6]*lkm7 +
                                                     kertoimet[7]*lkm8 +
                                                     kertoimet[8]*lkm9 +
                                                     kertoimet[9]*lkm10)
                                            #Jos yhteentörmäys, return True.
                                            #Muutoin, lisätään summa summat-tauluun.
                                            if tarkista(summa, summat):
                                                return True
                                            else:
                                                summat[summa] = True
    #Silmukka on suoritettu loppuun asti ja yhteentörmäyksiä ei löytynyt.
    return False

"""
Selvittää, kuinka suuri taulukko vaaditaan, jotta kaikki summat mahtuvat siihen indekseinä.
Ruma copy-paste toteutus. Metodi on yksi iso koodihaju.
"""
def taulukonKoko():
    suurin = 0
    for lkm1 in range(10):
        for lkm2 in range(8):
            for lkm3 in range(6):
                for lkm4 in range(4):
                    for lkm5 in range(3):
                        for lkm6 in range(3):
                            for lkm7 in range(3):
                                for lkm8 in range(2):
                                    for lkm9 in range(2):
                                        for lkm10 in range(2):
                                            arvo = (1 * lkm1 +
                                                    2 * lkm2 +
                                                    3 * lkm3 +
                                                    4 * lkm4 +
                                                    5 * lkm5 +
                                                    6 * lkm6 +
                                                    7 * lkm7 +
                                                    8 * lkm8 +
                                                    9 * lkm9 +
                                                    10 * lkm10)
                                            
                                            if arvo >= 16:
                                                continue
                                            if (lkm2 == 0 and
                                                lkm3 == 0 and
                                                lkm4 == 0 and
                                                lkm5 == 0 and
                                                lkm6 == 0 and
                                                lkm7 == 0 and
                                                lkm8 == 0 and
                                                lkm9 == 0 and
                                                lkm10 == 0 and
                                                lkm1 >= 6):
                                                continue
                                            if arvo == 15:
                                                if (lkm6 == 0 and
                                                    lkm7 == 0 and
                                                    lkm8 == 0 and
                                                    lkm9 ==0 and
                                                    lkm10 == 0):
                                                    continue
                                                if lkm10 > 0:
                                                    suuri_kortti = 10
                                                elif lkm9 > 0:
                                                    suuri_kortti = 9
                                                elif lkm8 > 0:
                                                    suuri_kortti = 8
                                                elif lkm7 > 0:
                                                    suuri_kortti = 7
                                                elif lkm6 > 0:
                                                    suuri_kortti = 6
                                                if not simuloi15(lkm1, lkm2, lkm3, lkm4, lkm5, suuri_kortti):
                                                    continue
                                            
                                            summa = (kertoimet[0]*lkm1 +
                                                     kertoimet[1]*lkm2 +
                                                     kertoimet[2]*lkm3 +
                                                     kertoimet[3]*lkm4 +
                                                     kertoimet[4]*lkm5 +
                                                     kertoimet[5]*lkm6 +
                                                     kertoimet[6]*lkm7 +
                                                     kertoimet[7]*lkm8 +
                                                     kertoimet[8]*lkm9 +
                                                     kertoimet[9]*lkm10)
                                            if summa > suurin:
                                                suurin = summa
    # Myös nolla tulee tallentaa taulukkoon: +1
    return suurin + 1

#Silmukka käy läpi optimoitavat kertoimet yksi kerrallaan.
#Kerroin lähtee arvosta 1 ja sitä kasvatetaan, kunnes yhteentörmäyksiä ei enää löydy.
#Silmukan suorittaminen kestää pari minuuttia.
for optimoitava in range(10):
    kertoimet[optimoitava] = 1
    while tarkistaKaikki():
        kertoimet[optimoitava] += 1

print("Kertoimet:")
print(kertoimet)
print("\nTaulukon koko:")
print(taulukonKoko())
