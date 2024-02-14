package HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Да се дефинира класа Film, во која ќе се чуваат информации за:
//
//        име: String
//        режисер: String
//        жанр: enum
//година: int
//        Сите променливи треба да бидат приватни. Соодветно во рамките на класата да се дефинираат:
//
//default конструктор и конструктор со аргументи
//        метод за печатење на информациите за филмот
//        Дополнително да се реализира надворешна функција:
//
//
//        da se napisat exceptions:
//        godina < 1000 -> YearNotValidException
//        ime i reziser da nema brojki -> NameNotValidException
//
//        void pecati_po_godina(List<Film>, int godina) која ќе прима аргумент низа од филмовиа треба да ги отпечати само филмовите кои се направени во дадената година.
//
//        input:
//        4
//        Frankenweenie
//        Tim_Burton
//        Animation
//        2012
//        Lincoln
//        Steven_Spielberg
//        History
//        2012
//        Wall-E
//        Andrew_Stanton
//        Animation
//        2008
//        Avatar
//        James_Cameron
//        Fantasy
//        2009
//        2008
//
//        OUTPUT:
//
//        Ime: Wall-E
//        Reziser: Andrew_Stanton
//        Zanr: Animation
//        Godina: 2008
//
//
//        input:
//        4
//        Frankenweenie
//        Tim_Burton
//        Animation
//        2012
//        Lincoln
//        Steven_Spielberg
//        History
//        2012
//        Wall-E
//        Andrew_Stanton
//        Animation
//        2008
//        Avatar
//        James_Cameron
//        Fantasy
//        2009
//        2012
//
//        OUTPUT:
//
//        Ime: Frankenweenie
//        Reziser: Tim_Burton
//        Zanr: Animation
//        Godina: 2012


enum Zanr{
    Horror,
    Animation,
    History,
    Fantasy
}

class YearNotValidException extends Exception{
    public YearNotValidException(int year) {
        super(year + " Ne e validna oti e < 1000");
    }
}

class NameNotValidException extends Exception{

    public NameNotValidException(String name) {
        super(name + "Sodrze brojki");
    }
}


class Film{
    private String ime;
    private String reziser;
    private Zanr zanr;
    private int godina;

    public Film() {
        this.ime = "";
        this.reziser = "";
        this.zanr = Zanr.Fantasy;
        this.godina = 2000;


    }

    public boolean checkUsingIsDigitMethod(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

     public static boolean checkUsingIsDigitMethodStatic(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public Film(String ime, String reziser, Zanr zanr, int godina) throws NameNotValidException {
        if(checkUsingIsDigitMethod(ime)){
            throw new NameNotValidException(ime);
        }
        if (checkUsingIsDigitMethod(reziser)){
            throw  new NameNotValidException(reziser);
        }
        this.ime = ime;
        this.reziser = reziser;
        this.zanr = zanr;
        this.godina = godina;
    }

    @Override
    public String toString() {
        return "Ime: " + ime+"\nReziser: " + reziser + "\nZanr: " + zanr.toString() + "\nGodina: " + godina;
    }

    public static void pecati_po_godina(List<Film> filmovi, int godina) throws NameNotValidException {

        Film film = new Film();
        List<Film> list = new ArrayList<>();

        for(int i = 0;i< filmovi.size();i++){
            if(filmovi.get(i).godina == godina){
                list.add(filmovi.get(i));
            }
        }

//        list.stream().forEach(i-> System.out.println(i));

        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

public class FilmTest {
    public static void main(String[] args) throws IOException, NameNotValidException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Film> films = new ArrayList<>();

        for(int i = 0;i < n;i++){
            String ime = bufferedReader.readLine();
            String reziser = bufferedReader.readLine();
            Zanr zanr = Zanr.valueOf(bufferedReader.readLine());
            int godina = Integer.parseInt(bufferedReader.readLine());



            Film film = null;
            try {
                film = new Film(ime,reziser,zanr,godina);
            } catch (NameNotValidException e) {
                e.getMessage();
            }

            films.add(film);
        }

        int godinaZaPecatenje = Integer.parseInt(bufferedReader.readLine());

//        for(int i = 0;i < films.size();i++){
//            System.out.println("Movie: " + (i+1));
//            System.out.println(films.get(i));
//        }


        Film.pecati_po_godina(films,godinaZaPecatenje);
    }
}
