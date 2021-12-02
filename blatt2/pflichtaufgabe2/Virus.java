public class Virus {
  public static void main(String[] args) {

    //Eingaben in der Console
    float infektionProzent = Float.parseFloat(args[0]);
    int feldGr = Integer.parseInt(args[1]);
    int a = Integer.parseInt(args[2]);
    boolean debug = false;
    if (a == 1) {
      debug = true;
    }

    int einwohnerZahl = feldGr * feldGr;
    double wocheninzidenzGesamt = 0.0;
    int neuinfektionen = 1;
    int[] wocheninzidenz = new int[7];
    int tagNummer = 0;
    int tag = 1;
    int[][] welt = new int[feldGr][feldGr];
    boolean[][] weltNeuinfiziert = new boolean[feldGr][feldGr];

    // Erste Infizierung
    int first = (int) (Math.random() * einwohnerZahl + 1);
    int firstWelt = 1;
    for(int  i = 0; i < welt.length; i++){
      for(int  j = 0; j < welt.length; j++){
        if (firstWelt == first){
          welt[i][j] = (int) (Math.random() * 5 + 4);
          i = welt.length;
          j = welt.length;
        }
        firstWelt++;
      }
    }
    tagNummer++;
    wocheninzidenz[tagNummer] = neuinfektionen;
    for(int  i = 0; i < wocheninzidenz.length; i++){
      wocheninzidenzGesamt = wocheninzidenzGesamt + wocheninzidenz[i];
    }
    System.out.println("Tag: 1");
    System.out.println("Neuinfektionen: " + neuinfektionen);
    System.out.println("Wocheninzidenz: " + (wocheninzidenzGesamt / einwohnerZahl) * 100000);

    weltkarte(welt);
    if(debug == true){
      System.out.print("\n");
      System.out.println("Debug:");
      weltkarteDebug(welt);

    }
    System.out.println("_____________________________________");

    //Tagesablauf der Infektion auf der Welt
    boolean istJemandInfiziert = true;
    while (istJemandInfiziert) {
      wocheninzidenzGesamt = 0;
      neuinfektionen = 0;
      for (int  i = 0; i < welt.length; i++) {
        for(int  j = 0; j < welt.length; j++) {
          if(welt[i][j] > 1 && weltNeuinfiziert[i][j] == false) {
            welt[i][j]--;
            neuinfektionen = infizierungPlus(welt, weltNeuinfiziert, i+1, j, infektionProzent, neuinfektionen);
            neuinfektionen = infizierungMinus(welt, weltNeuinfiziert, i-1, j, infektionProzent, neuinfektionen);
            neuinfektionen = infizierungPlus(welt, weltNeuinfiziert, i, j+1, infektionProzent, neuinfektionen);
            neuinfektionen = infizierungMinus(welt, weltNeuinfiziert, i, j-1, infektionProzent, neuinfektionen);
          }
        }
      }
      tagNummer++;
      if (tagNummer == 7) {
        tagNummer = 0;
      }
      wocheninzidenz[tagNummer] = neuinfektionen;
      for(int  i = 0; i < wocheninzidenz.length; i++){
        wocheninzidenzGesamt = wocheninzidenzGesamt + wocheninzidenz[i];
      }

      tag++;
      System.out.println("Tag: " + tag);
      System.out.println("Neuinfektionen: " + neuinfektionen);
      System.out.println("Wocheninzidenz: " + (wocheninzidenzGesamt / einwohnerZahl) * 100000));
      weltkarte(welt);
      if(debug == true){
        System.out.print("\n");
        System.out.println("Debug:");
        weltkarteDebug(welt);
      }
      System.out.println("_____________________________________");
      istJemandInfiziert = false;
      for (int  i = 0; i < welt.length; i++) {
        for(int  j = 0; j < welt.length; j++){
          weltNeuinfiziert[i][j] = false;
          if(welt[i][j] > 1){
            istJemandInfiziert = true;
          }
        }
      }
    }
  }
  // Welt auf der Konsole ausgeben
  public static void weltkarte(int[][] welt) {
    for(int  i = 0; i < welt.length; i++){
      for(int  j = 0; j < welt.length; j++){
        if(welt[i][j] > 1){
          System.out.print("*");
        }
        else if(welt[i][j] == 1){
          System.out.print("#");
        }
        else{
          System.out.print("-");
        }
      }
      System.out.print("\n");
    }
  }
  // Welt auf der Konsole ausgeben Debug
  public static void weltkarteDebug(int[][] welt) {
    for(int  i = 0; i < welt.length; i++){
      for(int  j = 0; j < welt.length; j++){
        if(welt[i][j] > 1){
          System.out.print(welt[i][j]);
        }
        else if(welt[i][j] == 1){
          System.out.print("#");
        }
        else{
          System.out.print("-");
        }
      }
      System.out.print("\n");
    }
  }
  //checkt ob uninfizierte neben dem infizierten sind, wenn ja, wird die wahrscheinlichkeit berechnet dass dieser angesteckt wird.
  public static int infizierungPlus(int[][] welt, boolean[][] weltNeuinfiziert, int i, int j, float infektionProzent, int neuinfektionen) {
    if(j < welt.length && i < welt.length){
      if(welt[i][j] == 0){
        double chanceInfizierung = (Math.random() * 100);
        if (chanceInfizierung < infektionProzent) {
          welt[i][j] = (int) (Math.random() * 5 + 4);
          weltNeuinfiziert[i][j] = true;
          neuinfektionen++;
        }
      }
    }
    return neuinfektionen;
  }
  //checkt ob neben dem Infizierten Unizizierte sind, wenn ja steckt er diese mit der eingegebenen Wahrscheinlichkeit an.
  public static int infizierungMinus(int[][] welt, boolean[][] weltNeuinfiziert, int i, int j, float infektionProzent, int neuinfektionen) {
    if(j >=  0 && i >= 0){
      if(welt[i][j] == 0){
        double chanceInfizierung = (Math.random() * 100);
        if (chanceInfizierung < infektionProzent) {
          welt[i][j] = (int) (Math.random() * 5 + 4);
          weltNeuinfiziert[i][j] = true;
          neuinfektionen++;
        }
      }
    }
    return neuinfektionen;
  }
}
