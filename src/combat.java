import java.lang.String;
import java.util.Scanner;

public class combat {
    private static personnage p1;
    private static personnage p2;
    static arme[] toutArme = { new arme("Epee",10),
            new arme("Hache",15),
            new arme("pistolet",30),
            new arme("Arbalet",100)
    };
    static boolean tourDeJeu = true;
    static Scanner sc = new Scanner(System.in);
    public static void instruction(){
        System.out.println("---------------------------------------------------------------");
        System.out.print("appuyer 1 : afficher etat");
        System.out.print("\nappuyer 2 : attaque joueur");
        System.out.print("\nappuyer 3 : lancer une magie");
        System.out.print("\nappuyer 4 : boire une possion de mana");
        System.out.print("\nappuyer 5 : boire une possion de vie");
        System.out.print("\nappuyer 6:  changer d'arme");
        System.out.print("\nappuyer  0: Arreter de jouer\n");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Voulez-vous jouer (o/n):");
    }
    public static void jouer(){
        while(p1.estVivant() && p2.estVivant()){
            if(tourDeJeu){
                System.out.println("*****"+p1.nom+" a votre tour de jouer*****");
                System.out.print("Entrer le commande:");
                p1.choisirAction(sc.nextInt(),p2);
            }else{
                System.out.println("*****"+p2.nom+" a votre tour de jouer*****");
                System.out.print("Entrer le commande:");
                p2.choisirAction(sc.nextInt(),p1);
            }
            tourDeJeu =!tourDeJeu;
        }
        if(!p1.estVivant()){
            System.out.println(p2.nom+" vous avez gagner");
        }else{
            System.out.println(p2.nom+" vous avez gagner");
        }
    }
    public static void main(String[] args) {
            System.out.print("entrer votre nom joueur 1:");
            p1 = new personnage(sc.next(),toutArme[(int)(Math.random() * toutArme.length)]);
            System.out.print("entrer votre nom joueur 2:");
            p2 = new personnage(sc.next(),toutArme[(int)(Math.random() * toutArme.length)]);
            instruction();
            char resp = 'o';
            resp = sc.next().charAt(0);
            while(resp != 'o' && resp!='n'){
                System.out.print("Voulez-vous jouer (o/n):");
                resp = sc.next().charAt(0);
            }
            if(resp=='o'){
                jouer();
            }else if(resp=='n'){
                System.out.println("Au revoir");
            }else{
                System.out.println("Mauvais commande!!");
                System.out.print("Voulez-vous jouer (o/n):");
                resp = sc.next().charAt(0);
            }
    }
}
