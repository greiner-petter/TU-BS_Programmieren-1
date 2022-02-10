# Bewertung Blatt 5

17 von 18 Punkten

Checkstyle, Variablennamen, JavaDoc (3 von 3 Punkten)

## Aufgabe 1

4 von 5 Punkten.

Es war eigentlich gedacht, dass ein Passwort mindestens 10 Zeichen haben soll. Mehr sind normalerweise auch ok, weil es das Passwort ja nur stärker macht. Finde ich aber so auch ok.

Ihr habt nicht genau das gemacht, was die Aufgabe verlangt. Ziel war es, dass der Konstruktor von Password eine Exception schmeißt. Ihr schmeißt eine Exception in main und catcht sie sofort wieder. Das ist nicht der Sinn von Exceptions. Innerhalb von main könntet ihr ja auch einfach mit einem boolean arbeiten. Exceptions werden ja an die aufrufende Funktion weitergeleitet, die dann darauf reagieren kann.

Password Konstruktor hat kein throws Keyword (-1 Punkt)

## Aufgabe 2

10 von 10 Punkten