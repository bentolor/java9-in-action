Der in RevealJS eingebaute Weg ein PDF-File zu machen funktioniert nicht: Es verhaut das komplette Layout.

Folgender Weg führte bei mir zum Ziel

 1. Plugin "Screengrab!" für Firefox installieren
 2. Konfigurieren, dass bei Druck auf das Plugin-icon _automatisch_ ein
    Screeshot des _aktuell sichtbaren Bereichs_ ohne Nachfrage als `.png`
    gespeichert wird
 3. Presentation durchsteppen & shots machen
 4. `convert *.png docker-file.pdf`
