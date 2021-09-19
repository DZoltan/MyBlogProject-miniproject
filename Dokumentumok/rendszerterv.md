Rendszerterv
=============

A rendszer célja
-----------------

Projektterv
------------

- Szerepkörök:
    A projekten résztvevő emberek közötti feladatelosztás elsődleges szempontja a hatékonyság, illetve az egyéni preferenciák.
    A szerepkörök felosztása a taskok felosztásakor történik. A legtöbb sprint alatt szükség van a dokumentumok készítésére, manuális, illetve automatizált tesztekre, illetve természetesen fejlesztőkre. Bizonyos szinten átjárhatóak ezek a szerepkörök, szem előtt tartva a mindenkori határidőt.
- Ütemterv: 
    Heti sprintekben történik a fejlesztés. A planningen megbeszélik a kollégák a heti taskokat, amiket a retrok során kiértékelnek. Fontos reális célokat kitűzni, hogy telejsíthetőek legyenek az elvárások.
- Mérföldkövek: 
    1. A dokumentációk elkészítese jelenti a fejlesztés első mérföldkövét, ezzel párhuazamosan zajlanak a főbb funkciók kialakításai. 
    2. A fejlesztés legnagyobb részét teszi ki ez a szekció. Ha a főbb funkciók működnek, szükség lesz a tesztelésére is ezeknek a funkcióknak. Ennél a mérföldkőnél rendelkezésére         fog állni a program váza, illetve működőképes lesz. 
    3. A következő, utolsó, etapban pedig a kényelmi funkciók, illetve a dizájn kerül beépítésre.

Üzleti folyamatok modellje
---------------------------

Követelmények
--------------

Funkcionális terv
-------------------

Fizikai környezet
-----------------
- A program a 17 es javaban készül, ami az új megjelenés ellenére egy LTE verzió, tehát hosszútávon támogatott. Szükség van különböző beimportált projektek (pl. Jackson a JSON kezeléshez) kezelésére, amit az Apache Maven valósít meg.
- A grafikus megjelenítést a Java Swingel valósítjuk meg. 
- Nincs szükség továbbá semmilyen hálózati beállításra, leszámítva, hogy el kell érnie a JSON fájlt a programnak. Ezért szükséges a folyamatos internetkapcsolat.
- A programnak futás közben minimális erőforrásra van szüksége, a tároláshoz szükséges lemezterület elhanyagolható.
