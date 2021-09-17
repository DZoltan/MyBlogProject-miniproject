Funkcionális Specifikáció
=========================

Áttekintés
----------
- Egy olyan szoftvert fejlesztünk, amely segíti a fejlesztő csapatok munkatársai között a kommunikációt, valamint egy egységes rendszert biztosí a vállalat számára.
- A fejlesztőknek lehetőségük lesz megosztani ötleteiket, problémáikat és megoldásaikat egy hírfolyamon, amelyekre kollégáik reagálhatnak. 
- Lehetőség lesz cimkéket megadni az egyes bejegyzésekhez, valamint címek alapján keresni a hírfolyamban.

Jelenlegi helyzet leírása
-------------------------
- A cégünk csapatai közötti kommunikáció több különböző felülete tagolódott. Ez a klikkesedés tömérdek mennyiségű időt vesz el a project vezetőktől, hiszen több platformon kénytelenek követni az alakulatok előrehaladását, problémát.
- Hatékonyságnövelés érdekében cégünk elhatározta, hogy keresünk ezen probléma áthidalására egy már létező megoldást (pl: trello), de ezen megoldások nem váltották be a hozzájuk társított elvárásokat. Ezért csapatunk a vállalat elvárásainak megfelelő szoftvert készít.

Jelenlegi üzleti folyamatok modellje
------------------------------------
- 1. Csoport létrehozása:
  - 1.1. Egy közösségi hálón vagy portálon regisztrálni kell minden csapattagnak. =>
  - 1.2. A közösségi hálón létre kell hozni egy csoportot. =>
  - 1.3. A csapat munkatársait hozzá kell adni a csoporthoz. 

- 2. Ötlet közzététele :
  - 2.1. Ha még nincs csoport létrehozva, akkor a 1. folyamat vérehajtása alapján kell létrehozni. =>
  - 2.2. Ha van csoport, akkor a csoportban létrehoz egy üzenetet, amelyben leírja az ötletet. =>
  - 2.3. Megjelölheti az üzenetet, vagy kiemelheti, ezt a platform lehetőségeinek megfelelően. =>
  - 2.4. Közzéteszi az üzenetet.
  
- 3. Keresés :
  - 3.1. Ha van csoport (1. folyamat végre lett hajtva) és vannak üzenetek (a 2. folyamat végere lett hajtva). =>
  - 3.2. A már létrehozott felhasználóval bejelentkezés. =>
  - 3.3. A kívánt közzétett üzenet megkeresése a hírfolyamon a keresőbe írt kulcsszavak alapján.
  
- 4. Ötlet kommentálása :
  - 4.1. Bejelentkezés a felhasználóba, aztán a csoporthoz navigálás. =>
  - 4.2. Megkeresi a kívánt üzenetet a 3. folyamat végrehajtása alapján. =>
  - 4.3. Az üzenethez leírja a megjegyzését. =>
  - 4.4. Elküldi a megjegyzést.
  
- 5. Ötletre reagálás :
  - 5.1. Bejelentkezés a felhasználóba, aztán a csoporthoz navigálás. =>
  - 5.2. Megkeresi a kívánt üzenetet a 3. folyamat végrehajtása alapján. =>
  - 5.3. Reagál az üzetere (pl. like, dislike, stb.).
  
Igényelt üzleti folyamatok modellje
------------------------------------
- Ötlet közzététele :  
  - A felhasználó megadja a nevét és a kategóriát.
  - Leírja az ötletét, és címet ad neki.
  - Állapotot adhat és módosíthat (megoldva, megoldásra vár, folyamatban, stb.)
- Ötlet kommentálása : 
  - A kommentelő egy kattintással megnyitja lehetőséget.
  - Megadja a nevét.
  - Leírja a kommentjét, majd elküldi.
- Keresés:
  - A felhasználó képes keresni a megfelelő mezőkben címre.
  - A lenyíló ablakokban lehetőség legyen kiválasztani a kategóriát és/vagy a szerzőt -> szűrés

Követelménylista
--------------------------------------
- Egyszerű megjelenés
- Időrendben legyenek a bejegyzések
- Minimum karakterszám : 30 betű

Használati esetek
-------------------------------------
Bejegyzés közzététele:
1. A felhasználó belelép a szövegbeviteli mezőbe, megírja a bejegyzést
2. Megadja a kategóriát/cimkét egy legördülő listából.
3. Megadja a fennmaradó mezőben a nevét.
4. Elküldi a bejegyzést

Bejegyzés kommentálása: 
1. A fsz. rákattint a kiválaszott bejegyzésre.
2. A szövegmezőbe begépeli a hozzászólását.
3. Megadja a fennamradó mezőben a nevét.
4. Elküldi a hozzászólást.

Bejegyzés keresése.
1/a. Kiválasztja a felhasználó a listából, hogy milyen kategóriákra szeretne szűrni.
1/b. Begépeli a keresőmezőbe a keresett szöveget.
1/c. Kiválasztja a megadott időintervallumot.
2. A keresés gomb megnyomásával megjelennek a bejegyzések.

Funckió - követelmény megfeleltetés
-----------------------------------

Fogalomszótár
-------------
