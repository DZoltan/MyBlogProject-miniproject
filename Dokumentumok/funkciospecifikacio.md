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
- A vállalatunk több fejlesztő csapattal rendelkezik. 
  - Minden csapat munkatársai egymás közt apróbb javaslataikat, terveiket vagy öteleteiket egy előre megbeszélt platformon vagy közösségi hálózaton osztják meg egymással. 
  - Ez lényegében minden fejlesztő csapat számára nagyon fontos, mivel így kihasználva az online hálózatot, hamarabb továbbítódik az információ és megérkezik a küldő munkatárstól a fogadó munkatárshoz. 
- Minden csapat különböző platformokat választ magának a számukra legmegfelelőbb alapján. 
  - Vállalatunkban az ilyen fajta darabolódások követhetetlenné tehetik az egyes projektekben fejlesztő kollégák más projektbe való betekintését vagy akár egy másik projekt alapján való inspirálódást, valmint a vállalat egységét is gyengíti. 
  - Rengeteg időt elvesz a több projektet vezető kollégáktól, amikor különböző platformokban kell nyomon követni egy-egy projekt fejlesztőinek kérdéseit, problémáit és megoldásait.

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
