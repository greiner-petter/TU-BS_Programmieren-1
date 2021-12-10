# Bewertung Blatt 2

Insgesamt 14,5 von 18 Punkten

- Formattierung: Checkstyle gibt 14 Fehler bei `Fibonnaci.java` (0 von 1 Punkte)
- JavaDoc: Die Annotationen von `@param` sollen die Übergabeparameter näher erklären. Die Erklärung habt ihr einfach leer gelassen :(. Und wenn die Parameter schon i und j heißen, was jetzt nicht wirklich aussagekräftig ist, dann wäre eine Erklärung schon schön. (0 von 1 Punkte)
- Sinnvolle Variablennamen: Der Unterschied zwischen `tag` und `tagNummer` ist jetzt vom Namen her nicht klar (0 von 1 Punkte)

## Pflichtaufgabe 1

5 von 5 Punkten

## Pflichtaufgabe 2

9,5 von 10 Punkten

- Die Idee war eigentlich, dass man `welt` und `weltNeuinfiziert` in einem einzigen 2D int Array speichert (-0,5 Punkte)
- Den Abschnitt habt ihr fast genau so doppelt, nur statt Tag für einen allgemeinen Tag. Macht da doch eine `toString()` Methode oder so draus, die ihr aufrufen könnt. Dann spart ihr euch den doppelten Code.

```java
System.out.println("Tag: 1");
System.out.println("Neuinfektionen: " + neuinfektionen);
System.out.println("Wocheninzidenz: " + (wocheninzidenzGesamt / einwohnerZahl) * 100000);
weltkarte(welt);
if (debug == true) {
    System.out.print("\n");
    System.out.println("Debug:");
    weltkarteDebug(welt);
}
System.out.println("_____________________________________");
```
