/*
   <Alban Islami>
    Id: <AL0794>
    Study Program: <DT>
*/
package Controller;

import Model.*;
import View.MainFrame;
import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;

public class Controller {
    MainFrame view;
    HashMap<String,Integer> map = new HashMap<>();
    ArrayList<String> scoreList = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    private int targetIndex;
    private int [] shipArray;
    private String names;
    private int oneCell;
    private int secondCell_1;
    private int secondCell_2;
    private int thirdCell_1;
    private int thirdCell_2;
    private int thirdCell_3;
    private int forthCell_1;
    private int forthCell_2;
    private int forthCell_3;
    private int forthCell_4;
    private int fifthCell_1;
    private int fifthCell_2;
    private int fifthCell_3;
    private int fifthCell_4;
    private int fifthCell_5;

    Random random = new Random();
    private int max_size;
    public Controller(){
        view = new MainFrame(this);
        shipArray = new int[101];
        names ="";
        max_size = 100;
        oneCell = 0;
        secondCell_1 = 0;
        secondCell_2 = 0;
        thirdCell_1 = 0;
        thirdCell_2 = 0;
        thirdCell_3 = 0;
        forthCell_1 = 0;
        forthCell_2 = 0;
        forthCell_3 = 0;
        forthCell_4 = 0;
        fifthCell_1 = 0;
        fifthCell_2 = 0;
        fifthCell_3 = 0;
        fifthCell_4 = 0;
        fifthCell_5 = 0;
        generateShips();
        scoreList.add(0,"Name    "+"     Score");
        view.updateScoreList(scoreList.toArray(new String[0]));
        list.add(0,"Max Score   "+view.getNumOfMissed());
        list.add(1," ");
        list.add(2,"Ship Name:      Amount");
        list.add(3,"    Boat        "+"         "+view.getBoatDestroyed());
        list.add(4,"    Destroyer   "+"     "+view.getDestroyerDestroyed());
        list.add(5,"    Submarine   "+"   "+view.getSubmarineDestroyed());
        list.add(6,"    Cruiser     "+"       "+view.getCruiserDestroyed());
        list.add(7,"    AirCarrier  "+"      "+view.getAirCarrierDestroyed());
        list.add(8,"           ");
        list.add(9,"           ");
        list.add(10,"           ");
        list.add(11,"       Status    ");
        list.add(12,"________________________");
        list.add(13,"New Game");
        list.add(14," ");
        list.add(15," ");
        list.add(16," ");
        list.add(17," Game Information");
        list.add(18,"________________________");
        list.add(19," ");
        list.add(20," O = Hit");
        list.add(21," X = Missed");
        list.add(22," ");
        list.add(23," B = Boat is destroyed");
        list.add(24," D = Destroyer is destroyed");
        list.add(25," S = Submarine is destroyed");
        list.add(26," C = Cruiser is destroyed");
        list.add(27," A = AirCarrier is destroyed");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden generateShips() skapar ett skepp av varje type
     */
    public void generateShips() {
        createBoat();
        createDestroyer();
        createSubmarine();
        createCruiser();
        createAirCarrier();
    }

    /**
     *  Metoden createBoat() skapar ett skepp av Boat type genom att generera en random boolean vertikalt eller horisontellt
     *  samtidigt skapas en random int mellan 0 och 100 och dessa v??rderna kastas till klassen Boat.
     */
    public void createBoat(){
        boolean horizontal= random.nextBoolean();
        int b= random.nextInt(max_size);
        setShip(b,horizontal,ShipType.Boat);

    }
    /**
     *  Metoden createDestroyer() skapar ett skepp av Destroyer type genom att generera en random boolean vertikalt eller horisontellt
     *   samtidigt skapas en random int mellan 0 och 100 och dessa v??rderna kastas till klassen Destroyer.
     */
    public void createDestroyer(){
        boolean horizontal= random.nextBoolean();
        int d= random.nextInt(max_size);
        setShip(d,horizontal,ShipType.Destroyer);

    }

    /**
     *  Metoden createSubmarine() skapar ett skepp av Submarine type genom att generera en random boolean vertikalt eller horisontellt
     *  samtidigt skapas en random int mellan 0 och 100 och  dessa v??rderna kastas till klassen Submarine.
     */
    public void createSubmarine(){
        boolean horizontal=random.nextBoolean();
        int s= random.nextInt(max_size);
        setShip(s,horizontal,ShipType.Submarine);

    }

    /**
     *  Metoden createCruiser() skapar ett skepp av Cruiser type genom att generera en random boolean vertikalt eller horisontellt
     *  samtidigt skapas en random int mellan 0 och 100 och dessa v??rderna kastas till klassen Cruiser.
     */
    public void createCruiser(){
        boolean horizontal= random.nextBoolean();
        int c= random.nextInt(max_size);
        setShip(c,horizontal,ShipType.Cruiser);

    }

    /**
     *  Metoden createAirCarrier() skapar ett skepp av AirCarrier type genom att generera en random boolean vertikalt eller horisontellt
     *  samtidigt skapas en random int mellan 0 och 100 och dessa v??rderna kastas till klassen AirCarrier.
     */
    public void createAirCarrier(){
        boolean horizontal= random.nextBoolean();
        int a= random.nextInt(max_size);
        setShip(a,horizontal,ShipType.AirCarrier);

    }

    /**
     *  Metoden setShip() skapar ett objekt skepp av varje type genom att f?? v??rderna av varje metod som finns upp
     *  samtidigt anv??nder metoden enum klass f??r att anropa varje skepp med typen.
     */
    public void setShip(int x, boolean horizontal, ShipType shipType){


        switch (shipType){
            case Boat:
                Boat boat = new Boat(x,horizontal);
                setBoat(boat.getX());

            break;

            case Destroyer:
                Destroyer destroyer = new Destroyer(x,horizontal);
                setDestroyer(destroyer.getX(),destroyer.isHorizontal());
                break;
            case Submarine:
                Submarine submarine = new Submarine(x,horizontal);
                setSubmarine(submarine.getX(),submarine.isHorizontal());
                break;
            case Cruiser:
                Cruiser cruiser = new Cruiser(x,horizontal);
                setCruiser(cruiser.getX(),cruiser.isHorizontal());

            break;
            case AirCarrier:
                AirCarrier airCarrier = new AirCarrier(x,horizontal);
                setAirCarrier(airCarrier.getX(),airCarrier.isHorizontal());

                break;
        }
    }

    /**
     *  Metoden setBoat() s??tter ett skepp med length 1 p?? shipArray genom att f?? en int av parameter x
     *  och testa om platsen ??r tom, annars anropar metoden tills skeppet har sattst.
     */
    private void setBoat(int x)
    {
        boolean check=false;

        if (x!=0){
            if (shipArray[x]== 0&& shipArray[x+1]==0){
                check=true;
            }
        }else {
            createBoat();
        }

        if (check){
            if (x < 100 ) {

                for (int i = 0; i < shipArray.length; i++) {
                    shipArray[x] = x;
                    oneCell=x;
                }

            } else {
                for (int i = 0; i < shipArray.length; i++) {
                    shipArray[x] = x;
                    shipArray[x + 1] = x + 1;
                    oneCell = x +1;
                }
            }
        }else {
            createBoat();
        }
    }

    /**
     *  Metoden setDestroyer() s??tter ett skepp med length 2 p?? shipArray genom att f?? en int av parameter x
     *  och en boolean true eller false f??r vertikala eller horisontella riktninger och testa om denna plats med length
     *  ??r tomma, annars anropas metoden tills skeppet ??r satt.
     */
    private void setDestroyer(int x,boolean isHorizontal)
    {
        boolean check=false;
        boolean checkHorizontal=false;
        if (isHorizontal){
            if (x!=0){

                if (x ==10||x==20||x==30||x==40||x==50||x==60||x==70||x==80||x==90||x==100) {
                    x=x-1;
                }
                if (shipArray[x]== 0&& shipArray[x+1]==0){
                    check=true;
                }

                if (check){
                    if (x <= 100) {
                        shipArray[x] = x;
                        secondCell_1 = x;
                        shipArray[x + 1] = x + 1;
                        secondCell_2 = x + 1;
                    }
                }else {
                    createDestroyer();
                }
            }else {
                if (shipArray[x]== 0&& shipArray[x+1]==0){
                    check=true;
                }
                if (check){

                    shipArray[x + 1] = x + 1;
                    secondCell_1 = x + 1;
                    shipArray[x + 2] = x + 2;
                    secondCell_2 = x + 2;
                } else {

                    createDestroyer();
                }
            }
        }else {

            if (x==91||x==92||x==93||x==94||x==95||x==96||x==97||x==98||x==99||x==100) {
                x=x-10;
            }
            if (shipArray[x]== 0&& shipArray[x+10]==0){
                checkHorizontal=true;
            }
            if (checkHorizontal&&x!=0){
                shipArray[x] = x;
                secondCell_1 = x ;
                shipArray[x + 10] = x + 10;
                secondCell_2 = x + 10;
            }else if (checkHorizontal){
                shipArray[x] = x;
                shipArray[x + 10] = x + 10;
                secondCell_1 = x + 10;
                shipArray[x + 20] = x + 20;
                secondCell_2 = x + 20;

            }else {
                createDestroyer();
            }
        }
    }

    /**
     *  Metoden setSubmarine() s??tter ett skepp med length 3 p?? shipArray genom att f?? en int av parameter x
     *  och en boolean true eller false f??r vertikala eller horisontella riktninger och testa om denna plats med length
     *  ??r tomma, annars anropas metoden tills skeppet ??r satt.
     */
    private void setSubmarine(int x,boolean isHorizontal)
    {
        boolean check=false;
        boolean checkHorizontal=false;
        if (isHorizontal){
            if (x!=0){

                if (x ==9||x==19||x==29||x==39||x==49||x==59||x==69||x==79||x==89||x==99) {
                    x=x-1;
                }
                if (x ==10||x==20||x==30||x==40||x==50||x==60||x==70||x==80||x==90||x==100) {
                    x=x-2;
                }
                if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0){
                    check=true;
                }

                if (check){
                    if (x <= 100) {
                        shipArray[x] = x;
                        thirdCell_1 = x;
                        shipArray[x + 1] = x + 1;
                        thirdCell_2 = x + 1;
                        shipArray[x + 2] = x + 2;
                        thirdCell_3 = x + 2;
                    }
                }else {
                    createSubmarine();
                }
            }else {
                if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0){
                    check=true;
                }
                if (check){

                    shipArray[x + 1] = x + 1;
                    thirdCell_1 = x +1;
                    shipArray[x + 2] = x + 2;
                    thirdCell_2 = x + 2;
                    shipArray[x + 3] = x + 3;
                    thirdCell_3 = x + 3;
                } else {

                    createSubmarine();
                }
            }
        }else {

            if (x==81||x==82||x==83||x==84||x==85||x==86||x==87||x==88||x==89||x ==90) {
                x=x-10;
            }
            if (x==91||x==92||x==93||x==94||x==95||x==96||x==97||x==98||x==99||x==100) {
                x=x-20;
            }
            if (shipArray[x]== 0&& shipArray[x+10]==0&&shipArray[x+20]==0){
                checkHorizontal=true;
            }
            if (checkHorizontal&&x!=0){
                shipArray[x] = x;
                thirdCell_1 = x;
                shipArray[x + 10] = x + 10;
                thirdCell_2 = x + 10;
                shipArray[x + 20] = x + 20;
                thirdCell_3 = x + 20;
            }else if (checkHorizontal){
                shipArray[x] = x;
                shipArray[x + 10] = x + 10;
                thirdCell_1 = x + 10;
                shipArray[x + 20] = x + 20;
                thirdCell_2 = x + 20;
                shipArray[x + 30] = x + 30;
                thirdCell_3 = x + 30;

            }else {
                createSubmarine();
            }
        }
    }

    /**
     *  Metoden setCruiser() s??tter ett skepp med length 4 p?? shipArray genom att f?? en int av parameter x
     *  och en boolean true eller false f??r vertikala eller horisontella riktninger och testa om denna plats med length
     *  ??r tomma, annars anropas metoden tills skeppet ??r satt.
     */
    private void setCruiser(int x,boolean isHorizontal)
    {
        boolean check=false;
        boolean checkHorizontal=false;
        if (isHorizontal){
        if (x!=0){

                if (x ==8||x==18||x==28||x==38||x==48||x==58||x==68||x==78||x==88||x==98) {
                    x=x-1;
                }
                if (x ==9||x==19||x==29||x==39||x==49||x==59||x==69||x==79||x==89||x==99) {
                    x=x-2;
                }
                if (x ==10||x==20||x==30||x==40||x==50||x==60||x==70||x==80||x==90||x==100) {
                    x=x-3;
                }
            if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0&& shipArray[x+3]==0){
                check=true;
            }

            if (check){
                if (x <= 100) {
                    shipArray[x] = x;
                    forthCell_1 = x;
                    shipArray[x + 1] = x + 1;
                    forthCell_2 = x + 1;
                    shipArray[x + 2] = x + 2;
                    forthCell_3 = x + 2;
                    shipArray[x + 3] = x + 3;
                    forthCell_4 = x + 3;
                }
            }else {
                    createCruiser();
            }
        }else {
            if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0&& shipArray[x+3]==0){
                check=true;
            }
            if (check){

                shipArray[x + 1] = x + 1;
                forthCell_1 = x + 1;
                shipArray[x + 2] = x + 2;
                forthCell_2 = x + 2;
                shipArray[x + 3] = x + 3;
                forthCell_3 = x + 3;
                shipArray[x + 4] = x + 4;
                forthCell_4 = x + 4;
            } else {

                createCruiser();
            }
        }
        }else {

            if (x==71||x==72||x==73||x==74||x==75||x==76||x==77||x==78||x==79||x ==80) {
                x=x-10;
            }

            if (x==81||x==82||x==83||x==84||x==85||x==86||x==87||x==88||x==89||x ==90) {
                x=x-20;
            }
            if (x==91||x==92||x==93||x==94||x==95||x==96||x==97||x==98||x==99||x==100) {
                x=x-30;
            }
            if (shipArray[x]== 0&& shipArray[x+10]==0&&shipArray[x+20]==0&&shipArray[x+30]==0){
                checkHorizontal=true;
            }
            if (checkHorizontal&&x!=0){
                shipArray[x] = x;
                forthCell_1 = x;
                shipArray[x + 10] = x + 10;
                forthCell_2 = x + 10;
                shipArray[x + 20] = x + 20;
                forthCell_3 = x + 20;
                shipArray[x + 30] = x + 30;
                forthCell_4 = x + 30;
            }else if (checkHorizontal){
                shipArray[x] = x;
                shipArray[x + 10] = x + 10;
                forthCell_1 = x + 10;
                shipArray[x + 20] = x + 20;
                forthCell_2 = x + 20;
                shipArray[x + 30] = x + 30;
                forthCell_3 = x + 30;
                shipArray[x + 40] = x + 40;
                forthCell_4 = x + 40;

            }else {
                createCruiser();
            }
        }
    }

    /**
     *  Metoden setAirCarrier() s??tter ett skepp med length 5 p?? shipArray genom att f?? en int av parameter x
     *  och en boolean true eller false f??r vertikala eller horisontella riktninger och testa om denna plats med length
     *  ??r tomma, annars anropas metoden tills skeppet ??r satt.
     */
    private void setAirCarrier(int x, boolean isHorizontal) {

        boolean check=false;
        boolean checkHorizontal=false;
        if (isHorizontal){
            if (x!=0){

                if (x ==7||x==17||x==27||x==37||x==47||x==57||x==67||x==77||x==87||x==97) {
                    x=x-1;
                }
                if (x ==8||x==18||x==28||x==38||x==48||x==58||x==68||x==78||x==88||x==98) {
                    x=x-2;
                }
                if (x ==9||x==19||x==29||x==39||x==49||x==59||x==69||x==79||x==89||x==99) {
                    x=x-3;
                }
                if (x ==10||x==20||x==30||x==40||x==50||x==60||x==70||x==80||x==90||x==100) {
                    x=x-4;
                }
                if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0&& shipArray[x+3]==0 && shipArray[x+4]==0){
                    check=true;
                }

                if (check){
                    if (x <= 100) {
                        shipArray[x] = x ;
                        fifthCell_1 = x;
                        shipArray[x + 1] = x + 1;
                        fifthCell_2 = x + 1;
                        shipArray[x + 2] = x + 2;
                        fifthCell_3 = x + 2;
                        shipArray[x + 3] = x + 3;
                        fifthCell_4 = x + 3;
                        shipArray[x + 4] = x + 4;
                        fifthCell_5 = x + 4;
                    }
                }else {
                    createAirCarrier();
                }
            }else {
                if (shipArray[x]== 0&& shipArray[x+1]==0&& shipArray[x+2]==0&& shipArray[x+3]==0&& shipArray[x+4]==0){
                    check=true;
                }
                if (check){

                    shipArray[x + 1] = x + 1;
                    fifthCell_1 = x + 1;
                    shipArray[x + 2] = x + 2;
                    fifthCell_2 = x + 2;
                    shipArray[x + 3] = x + 3;
                    fifthCell_3 = x + 3;
                    shipArray[x + 4] = x + 4;
                    fifthCell_4 = x + 4;
                    shipArray[x + 5] = x + 5;
                    fifthCell_5 = x + 5;
                } else {

                    createAirCarrier();
                }
            }
        }else {

            if (x==61||x==62||x==63||x==64||x==65||x==66||x==67||x==68||x==69||x ==70) {
                x=x-10;
            }
            if (x==71||x==72||x==73||x==74||x==75||x==76||x==77||x==78||x==79||x ==80) {
                x=x-20;
            }

            if (x==81||x==82||x==83||x==84||x==85||x==86||x==87||x==88||x==89||x ==90) {
                x=x-30;
            }
            if (x==91||x==92||x==93||x==94||x==95||x==96||x==97||x==98||x==99||x==100) {
                x=x-40;
            }
            if (shipArray[x]== 0&& shipArray[x+10]==0&&shipArray[x+20]==0&&shipArray[x+30]==0&&shipArray[x+40]==0){
                checkHorizontal=true;
            }
            if (checkHorizontal&&x!=0){
                shipArray[x] = x;
                fifthCell_1 = x;
                shipArray[x + 10] = x + 10;
                fifthCell_2 = x + 10;
                shipArray[x + 20] = x + 20;
                fifthCell_3 = x + 20;
                shipArray[x + 30] = x + 30;
                fifthCell_4 = x + 30;
                shipArray[x + 40] = x + 40;
                fifthCell_5 = x + 40;
            }else if (checkHorizontal){
                shipArray[x] = x;
                shipArray[x + 10] = x + 10;
                fifthCell_1 = x + 10;
                shipArray[x + 20] = x + 20;
                fifthCell_2 = x + 20;
                shipArray[x + 30] = x + 30;
                fifthCell_3 = x + 30;
                shipArray[x + 40] = x + 40;
                fifthCell_4 = x + 40;
                shipArray[x + 50] = x + 50;
                fifthCell_5 = x + 50;

            }else {
                createAirCarrier();
            }
        }
    }

    /**
     *  Metoden arrayContains() med retur v??rde int f??r att j??mf??ra shipArray med buttonArray som finns i GUI. Vi
     *  representerar buttonArray med getNumOfTarget1() v??rde.
     */
    public int arrayContains(){
        int last=0;
        int toFind = getNumOfTarget1();
        for(int i = 0; i < shipArray.length; i++) {
            if (shipArray[i]==toFind){
                last= shipArray[i];
            }
        }
        return last;
    }

    /**
     *  Metoden getNumOfTarget1() och setNumOfTarget1() med retur v??rde int ??r den knapp index i buttonArray som finns i GUI
     */
    public int getNumOfTarget1() {
        return targetIndex;
    }

    public void setNumOfTarget1(int numOfTarget1) {
        this.targetIndex = numOfTarget1;
    }

    /**
     *  Metoden getOneCell() med retur v??rde int ??r det skepp index i shipArray som vi ska anv??nda i GUI f??r att
     *  hitta Boat typ
     */
    public int getOneCell() {
        return oneCell;
    }

    /**
     *  Metoden getSecondCell_1() och getSecondCell_2() med retur v??rde int ??r den skepp index i shipArray som vi
     *  ska anv??nda i GUI f??r att hitta Destroyer typ
     */
    public int getSecondCell_1() {
        return secondCell_1;
    }

    public int getSecondCell_2() {
        return secondCell_2;
    }

    /**
     *  Metoden getThirdCell_1(), getThirdCell_2() och getThirdCell_3() med retur v??rde int ??r den skepp index i shipArray som vi
     *  ska anv??nda i GUI f??r att hitta Submarine typ
     */
    public int getThirdCell_1() {
        return thirdCell_1;
    }

    public int getThirdCell_2() {
        return thirdCell_2;
    }

    public int getThirdCell_3() {
        return thirdCell_3;
    }

    /**
     *  Metoden getForthCell_1(), getForthCell_2(),getForthCell_3() och getForthCell_4() med retur v??rde int
     *  ??r det skepp index i shipArray som vi ska anv??nda i GUI f??r att hitta Cruiser typ
     */
    public int getForthCell_1() {
        return forthCell_1;
    }

    public int getForthCell_2() {
        return forthCell_2;
    }

    public int getForthCell_3() {
        return forthCell_3;
    }

    public int getForthCell_4() {
        return forthCell_4;
    }

    /**
     *  Metoden getFifthCell_1(), getFifthCell_2(),getFifthCell_3(),getFifthCell_4() och getFifthCell_5() med
     *  retur v??rde int ??r det skepp index i shipArray som vi ska anv??nda i GUI f??r att hitta AirCarrier typ
     */
    public int getFifthCell_1() {
        return fifthCell_1;
    }

    public int getFifthCell_2() {
        return fifthCell_2;
    }

    public int getFifthCell_3() {
        return fifthCell_3;
    }

    public int getFifthCell_4() {
        return fifthCell_4;
    }

    public int getFifthCell_5() {
        return fifthCell_5;
    }

    /**
     *  Metoden gameController() kontrollerar om att alla skepp har sj??nkat f??r att skriva anv??ndaren namn coh
     *  genererar resultatet och sen nollst??ll spel f??r att man kan spela en g??ng till.
     */
    public void gameController(){

        if (view.getNumOfHit() == 15){
            names = JOptionPane.showInputDialog("Insert Your Name !!");
            if (names.isEmpty()){
                names="No name";
            }
            scoreList.set(0,"Name    "+"     Score");
            view.updateScoreList(scoreList.toArray(new String[0]));
            addWinner();
            view.updateNameList(list.toArray(new String[0]));
            view.gameFinished();
            gameReset();

        }
    }

    /**
     *  Metoden gameReset() nollst??ller spelet och s??tta varje v??rde till grunden f??r att man kan spela en g??ng till
     *  och updaterar GUI med de nya v??rden.
     */
    public void gameReset(){
        Arrays.fill(shipArray, 0);
        view.setNumOfHit(0);
        view.setCounter(0);
        view.setNumOfMissed(85);
        view.setBoatDestroyed(1);
        view.setDestroyerDestroyed(1);
        view.setSubmarineDestroyed(1);
        view.setCruiserDestroyed(1);
        view.setAirCarrierDestroyed(1);
        list.set(13,"New Game");
        scoreList.clear();
        scoreList.add(0,"");
        updateView();
        generateShips();
    }

    public String getNames() {
        return names;
    }

    /**
     *  Metoden updateView() updaterar GUI listan med de nya v??rden n??r ett skepp sjunker.
     */
    public void updateView(){
        list.set(0,"Max Score   "+view.getNumOfMissed());
        list.set(3,"    Boat        "+"         "+view.getBoatDestroyed());
        list.set(4,"    Destroyer   "+"     "+view.getDestroyerDestroyed());
        list.set(5,"    Submarine   "+"   "+view.getSubmarineDestroyed());
        list.set(6,"    Cruiser       "+"     "+view.getCruiserDestroyed());
        list.set(7,"    AirCarrier   "+"     "+view.getAirCarrierDestroyed());
        view.updateNameList(list.toArray(new String[0]));

    }

    /**
     *  Metoden messed() identifierar om man inte har tr??ffat ett skepp och visar det genom att
     *  uppdatera GUI listan att anv??ndaren har missat skeppet.
     */
    public void messed(){
        if (view.getNumOfMissed()<=84){
            list.set(13,"You Missed Target");
            view.updateNameList(list.toArray(new String[0]));
        }
    }

    /**
     *  Metoden hit() identifierar om man har tr??ffat ett skepp och visar det genom att
     *  uppdatera GUI listan att anv??ndaren har tr??ffat ett skepp.
     */
    public void hit(){
        if (view.getCounter()>=1){
            list.set(13,"You Hit Target");
            view.updateNameList(list.toArray(new String[0]));
        }
    }

    /**
     *  Metoden sankBoat() identifierar om boat typ har sjunkt och visar det genom att
     *  updaterar GUI listan .
     */
    public void sankBoat(){

            list.set(13,"You Sank Boat");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden sankDestroyer() identifierar om Destroyer typ har sjunkt och visar det genom att
     *  updaterar GUI listan .
     */
    public void sankDestroyer(){

            list.set(13,"You Sank Destroyer");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden sankSubmarine() identifierar om Submarine typ har sjunkt och visar det genom att
     *  updaterar GUI listan .
     */
    public void sankSubmarine(){

            list.set(13,"You Sank Submarine");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden sankCruiser() identifierar om Cruiser typ har sjunkt och visar det genom att
     *  updaterar GUI listan .
     */
    public void sankCruiser(){

            list.set(13,"You Sank Cruiser");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden sankAirCarrier() identifierar om AirCarrier typ har sjunkt och visar det genom att
     *  updaterar GUI listan .
     */
    public void sankAirCarrier(){

            list.set(13,"You Sank AirCarrier");
        view.updateNameList(list.toArray(new String[0]));
    }

    /**
     *  Metoden addWinner() f??r tv?? v??rden en av de String som ??r en namn och den andra ??r int som resultat av
     *  b??sta spel. Varje g??ng sorterar metoden resultaten och j??mf??ra det med det nya resultatet och skriver ut
     *  p?? listan som anv??ndaren kan se och t??vla igen.
     */
    public void addWinner(){
        map.put(getNames(),view.getNumOfMissed());
        Set<Entry<String,Integer>> set = map.entrySet();
        List<Entry<String, Integer>>list1 = new ArrayList<Entry<String,Integer>>(set);
        Collections.sort(list1, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o2, Entry<String, Integer> o1) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Entry<String,Integer> entry :list1){
            scoreList.add( entry.getKey()+"         "+entry.getValue());
        }
        view.updateScoreList(scoreList.toArray(new String[0]));

    }

    /**
     *  Metoden exit() f??r att avsluta programet
     */
    public void exit() {
        int option = JOptionPane.showConfirmDialog(null,"Exit, Are you sure");
        if (option ==0)
            System.exit(0);
    }

    /**
     *  Metoden reset() f??r att nollst??ll spelet med en knapp som finns i GUI
     */
    public void reset() {
        view.gameFinished();
        gameReset();
    }
}
