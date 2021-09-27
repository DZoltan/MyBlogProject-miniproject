Rendszerterv
=============

A rendszer célja
-----------------

- Egy olyan oldal, amely segíti a fejlesztő csapatok munkatársai között a kommunikációt, valamint egy egységes
rendszert biztosít a vállalat számára. 
- A fejlesztők megtudják osztani ötleteiket, problémáikat és megoldásaikat egy hírfolyamon, amelyekre kollégáik reagálnak, kommentelnek hozzá így segítve a fejlesztési menet fluiditását. A üzenetek időrendben egy hírfolyamon vannak közzétéve. Az üzenetek állapotát meg lehet adni, vagyis megoldásra vár, megoldott, folyamatban stb.  
- Különböző témákat lehet rendelni az üzenetekhez, amelyek alapján szűrni és keresni lehet. Színes címkékel lehet jelezni a különböző témákat.

Projektterv
------------

- Szerepkörök:
    A projekten résztvevő emberek közötti feladatelosztás elsődleges szempontja a hatékonyság, illetve az egyéni preferenciák.
    A szerepkörök felosztása a taskok felosztásakor történik. A legtöbb sprint alatt szükség van a dokumentumok készítésére, manuális, illetve automatizált tesztekre, illetve természetesen fejlesztőkre. Bizonyos szinten átjárhatóak ezek a szerepkörök, szem előtt tartva a mindenkori határidőt.
- Ütemterv: 
    Heti sprintekben történik a fejlesztés. A planningen megbeszélik a kollégák a heti taskokat, amiket a retrok során kiértékelnek. Fontos reális célokat kitűzni, hogy teljesíthetőek legyenek az elvárások.
- Mérföldkövek: 
    1. A dokumentációk elkészítése jelenti a fejlesztés első mérföldkövét, ezzel párhuzamosan zajlanak a főbb funkciók kialakításai. 
    2. A fejlesztés legnagyobb részét teszi ki ez a szekció. Ha a főbb funkciók működnek, szükség lesz a tesztelésére is ezeknek a funkcióknak. Ennél a mérföldkőnél rendelkezésére         fog állni a program váza, illetve működőképes lesz. 
    3. A következő, utolsó, etapban pedig a kényelmi funkciók, illetve a dizájn kerül beépítésre.



Üzleti folyamatok modellje
---------------------------
  ![uzleti_folymaatok](https://user-images.githubusercontent.com/55513932/134815706-a3982f57-7fe9-4024-b09b-a9105273d457.jpg)


Követelmények
--------------
K01 Egyszerű, átlátható dizájn  
K02 Könnyen kezelhető felület  
K03 Név megadása  
	- A felhasználók megadhassák nevüket, amit kijelez ha bejegyzést, vagy kommentet írnak  
K04 Operációs rendszer függetlenség  
	- Az elkészített rendszert, első sorban Windows-on és Linux-on szeretnénk használni  
K05 Dátummal ellátott bejegyzések  
	- A bejegyzésnél legyen látható, hogy ki írta és hogy mikor  
K06 Komment lehetőség  
	- A bejegyzéshez lehessen kommentálni bármelyik felhasználónak  
K07 Adatok mellőzése  
	- A rendszer ne kérjen be semmilyen adatot a felhasználótól, az általa megadott neven kívül  

Funkcionális terv
-------------------
- **Rendszerszereplők:**
  - *Minden felhasználó az alábbi két rendszerszerepet veheti fel. Továbbá minden üzenethez egy üzenetet létrehozó tartozhat. Az üzenetet létrehozónak is lehetősége van hozzászólni a saját üzenetéhez és másokéhoz.*
  * Üzenetet létrehozó
  * Üzenetre reagáló
- **Rendszerszerhasználati esetek és lefutásaik:**
  #### Üzenetet létrehozó: ####
  - Üzenetet tud létrehozni és módosítani.
  - Saját üzeneteinek címet adhat meg és változtathatja.
  - Saját üzeneteinek témát adhat meg és változtathatja.
  - Saját üzeneteinek állapotot adhat meg (Pl. megoldva, megoldásra vár, stb.) és változtathatja. 
  - Saját üzeneteit törölheti.
  
  #### Üzenetre reagáló: ####
  - Egy üzenethez hozzászólhat és saját hozzászólását megváltoztathatja.
  
- **Menü-hierarchiák:**
  #### Belépés: ####
  * Név megadása
  * Belépés
  
  #### Hírfolyam: ####
  * Üzenet létrehozás 
  * Keresés
  * Üzenet megnyitás
  * Kilépés
  
  #### Üzenet: ####
  * Reagálás
  * Hozzászólás
  * Visszalépés a hírfolyamba

Fizikai környezet
-----------------
- A program a 17 es javaban készül, ami az új megjelenés ellenére egy LTS verzió, tehát hosszútávon támogatott. Szükség van különböző beimportált projektek (pl. Jackson a JSON kezeléshez) kezelésére, amit az Apache Maven valósít meg.
- A grafikus megjelenítést a Java Swingel valósítjuk meg. 
- Nincs szükség továbbá semmilyen hálózati beállításra, leszámítva, hogy el kell érnie a JSON fájlt a programnak. Ezért szükséges a folyamatos internetkapcsolat.
- A programnak futás közben minimális erőforrásra van szüksége, a tároláshoz szükséges lemezterület elhanyagolható.

Implementációs terv
-------------------
- A Java platformfüggetlensége miatt nincs szükség kompatibilitási megoldásokra.
- Az alkalmazást különböző részegységekre, modulokra kell bontani, hogy a későbbiekben, illetve a fejlesztés során könnyedén lehessen új funkciókat bekötni.
- A JSON állomány felépítését egy vagy több osztály reprezentálja. Ezen objektumok tartalmazzák és teszik módósíthatóvá az adatokat.
- Törekedni kell a clean code szabályok és SOLID alapelvek betartására. 
