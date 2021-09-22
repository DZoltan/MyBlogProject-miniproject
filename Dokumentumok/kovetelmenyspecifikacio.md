Követelményspecifikáció
======================

Jelenlegi helyzet leírása
-------------------------
- A vállalatunk több rugalmas fejlesztő csapatból áll melyek különböző megbízásokat teljesítenek, vagy néhány csapat ugyan azon a projekten is dolgozhat. 
- Sok a megbízás és sokat kell kommunikálni így ezt mind online álltaluk választott felületeken végzik el. Ennek a hátulütője annyi, hogy így van, aki nem tudja a csoport társának a felületét használni vagy nem szereti így több emberen kell keresztül menjen az információ.
- Az üzenetek nyilvántartása is azokon a felöleteken marad meg.

Vágyálomrendszer leírása
------------------------
- A projekt célja egy olyan rendszer, ami a fejlesztő csapatok munkatársai közötti kommunikációt könnyíti.
- A rendszer lehetőséget nyújt apróbb üzenetek írására, amelyek időrendben egy hírfolyamon vannak közzétéve.
- Különböző témákat lehet rendelni az üzenetekhez, amelyek alapján szűrni és keresni lehet. Színes cimkékel lehet jelezni a különböző témákat.
- Lehetőség van reagálni és hozzászólni a kiírt üzenetekre. 
- Meg lehet adni az üzenet állapotát. (megoldásra vár, megoldott, folyamatban, stb.)
- ![fejdisz](https://user-images.githubusercontent.com/55513932/133985611-eb844a9e-db1c-4f54-af7b-169b4762519c.png)


Jelenlegi üzleti folyamatok modellje
------------------------------------
- 1. Csoport létrehozása :
  1.1. A csapat közösen választ egy közösségi hálót vagy platformot, amely információ megosztására és kommunikációra alkalmas. =>
  1.2. Létrehoznak egy felhasználót, majd a lehetőségeknek megfelelően egy csoportot. 
  
- 2. Ötlet közzététele :
  2.1. Szükség van a 1.1. és 1.2 lépések végrehajtására. =>
  2.2. A csoportban létrehoz egy üzenetet, amelyben leírja az ötletet. =>
  2.3. Megjelölheti az üzenetet, vagy kiemelheti, ezt a lehetőségeknek megfelelően. 
  
- 3. Keresés :
  3.1. A már létrehozott felhasználóval bejelentkezés. =>
  3.2. A kívánt közzétett üzenet megkeresése a hírfolyamon.
  
- 4. Ötlet kommentálása :
  4.1. Megkeresi a kívánt üzenetet a 3.1 és 3.2 alapján. =>
  4.2. Az üzenethez leírja a megjegyzését. =>
  4.3. Elküldi a megjegyzést.
  
- 5. Ötletre reagálás :
  5.1 Megkeresi a kívánt üzenetet a 3.1 és 3.2 alapján. =>
  5.2. Reagál az üzetere (pl. like, dislike, stb.).

Igényelt üzleti folyamatok modellje.
------------------------------------
- Ötlet közzététele :  
  - A felhasználó megadja a nevét és a kategóriát. =>
  - Leírja az ötletét, és címet ad neki. =>
  - Állapotot adhat és módosíthat (megoldva, megoldásra vár, folyamatban, stb.).
- Ötlet kommentálása : 
  - A kommentelő egy kattintással megnyitja lehetőséget. =>
  - Megadja a nevét. =>
  - Leírja a kommentjét, majd elküldi.
- Keresés:
  - A felhasználó képes keresni a megfelelő mezőkben címre. =>
  - A lenyíló ablakokban lehetőség legyen kiválasztani a kategóriát és/vagy a szerzőt. -> 
  - Szűrés.

Követelménylista
--------------------------------------
- Egyszerű megjelenés
- Időrendben legyenek a bejegyzések
- Minimum karakterszám : 30 betű
