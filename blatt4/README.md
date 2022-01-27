# Bewertung Blatt 4

17 von 18 Punkten

Die Methode `tryHack()` soll eigentlich nur in `HackedRobot` definiert werden. Ihr habt sie in `Robot` definiert, damit ihr darauf einfacher zugreifen könnt. Besser wäre es gewesen, einen `Robot` in einen `HackedRobot` zu casten, wenn man sich sicher ist, dass es tatsächlich ein `HackedRobot` ist. Die Methode `checkCoordinates()` der Map gibt ja extra einen Enum zurück, sodass man damit prüfen kann, ob an der Stelle in der Map tatsächlich ein `HackedRobot` ist, den man dann einfach casten kann mit `HackedRobot hackedRobot = (HackedRobot) robot`. (-0,5 Punkte)

In der `Map` habt ihr `Robot[][] locations` und `MapObjectType[][] map` (-0,5 Punkte). Die Idee war eigentlich nur das `locations` Array zu haben. Den `MapObjectType` eines `Robots` kann man nämlich in der `checkCoordinates()` Methode einfach bestimmen. Also zum Beispiel

```java
// In der Methode checkCoordinats()...

Robot robot = locations[x][y];
if (robot instanceof HackedRobot) {
    return MapObjectType.HACKED;
} else if (robot instanceof NormalRobt) {
    return MapObjectType.NORMAL;
} else {
    return MapObjectType.EMPTY;
}
```