# Exemple de dénition d'interface en Java

Pour illustrer la définition d'interface en Java j'ai modélisé ma station météo avec des classes Java.

## Utilisation des classes abstraites

J'ai défini une classe `Measure` ainsi qu'une classe abstraite `ConvertibleMeasure` qui serviront de classes parentes aux classes `Temparature`, `Humidity` et `Pressure`.

Cela permet d'observer l'utilisation des classes abstraites. Les mesures qui peuvent gérer la conversion d'unité étendront la classe `ConvertibleMeasure` et devront donc implémenter la fonction `convertTo()`.

## Utilisation des interfaces

J'ai défini des services factices pour illustrer l'utilisation d'interfaces. J'ai choisi de permettre à mon application de sauvegarder les mesures, et je dois les sauvegarder de différentes manières. J'ai donc défini une interface `MeasureService` qui définit la fonction `saveMeasure()` que mes services devront implémenter avec leur logique propre.
