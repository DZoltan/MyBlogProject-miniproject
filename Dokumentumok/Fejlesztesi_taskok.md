A 09.21 -i Planingen megbeszélt részltek a program felépítésről: 
------------------------

View:
----

- NodePanel 
  - Megjelenési minta a bejegyzéseknek
  - A konstruktornak átadott paraméterek alapján
- MainWindow fxml
  - Menüpanel
  - Főpanel a Node-okkal
- Komment fxml
  - A megnyitott bejegyzések komemntjei olvashatóak
  - Lehetőség új megadására

Controller: 
--------
- All 
  - Minden bejegyzés
- Keresés 
  - Specifikus adatok alapján kiválaszott bejegyzések.
- Új
  - Új bejegyzés hozzáadása
- Törlés
  - Bejegyzés törlése(csak a szerzőnek!)

KommentController:
----------------

- Új komment
- Komment törlés

*Mindkettőre ugyanaz érvényes, mint az előző Controllernél*

Model & JSON:
--------------

- Post Model
  - Tagjai:  id, user, title, description, date, status, kategória, List<Komment>, ENUM status , ENUM kategória
- Komment Model
  - Tagjai: id, user, comment
- Serialize 
  - list -> json (void)
- Deserialize 
  - json -> lista (function)

  
PopUp:
----------

- Bejelentkezés
  - Felugró ablak ahol meg lehet adni a nevet
- Keresés 
  - Szabadszavas, dátum, kategória keresés
- Új
  - A Post osztály apraméterei alaján létrehozott új bejegyzés
