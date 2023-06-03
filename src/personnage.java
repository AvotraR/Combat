import java.lang.String;
class personnage {
    public int vie;
    public String nom;
    public arme votreArme;
    public int mana;
    public int possionMana;
    public int possionVie;

    public personnage(String Nom,arme arme){
        this.nom = Nom;
        this.vie = 100;
        this.mana = 100;
        this.possionMana=10;
        this.votreArme=arme;
    }
    public boolean estVivant(){
        if(this.vie>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean recevoirDegat(){
        if(!(this.estVivant())){
            return false;
        }else{
            return true;
        }
    }
    public void changerArme(arme arme){
        if(recevoirDegat()){
            this.votreArme = arme;
            System.out.println(this.nom+" votre arme a ete changer en "+this.votreArme.nomArme);
            System.out.println("---------------------------------------------------------------");
        }
    }
    public void attaquer(personnage p){
        if(recevoirDegat()){
            p.vie = p.vie - votreArme.puissance;
            System.out.println(this.nom+" vous avez attaquer "+p.nom+" // degat infliger"+votreArme.puissance);
            System.out.println("---------------------------------------------------------------");
        }
    }
    public void afficherEtat(){
        System.out.println("Nom= "+ this.nom+
                            "\nVie="+this.vie+
                            "\nMana="+this.mana+
                            "\nArme= "+this.votreArme.nomArme+
                            "(degat ->"+this.votreArme.puissance+")");
        System.out.println("---------------------------------------------------------------");
    }
    public void boirePossionDeVie(){
        if (this.vie<=100 && this.vie>0){
            this.vie = this.vie + this.possionVie;
            System.out.println(this.nom+" vous avez bu une possion de vie +10");
            System.out.println("---------------------------------------------------------------");
        }
    }
    public void boirePossionDeMana(){
        if (this.mana<100){
            this.mana = this.mana + this.possionMana;
            System.out.println(this.nom+" vous avez bu une possion de mana +10");
            System.out.println("---------------------------------------------------------------");
        }
    }
    public void lancerMagie(personnage p){
        if (this.mana<=100 && this.mana!=0){
                p.vie = p.vie - 5;
                this.mana = this.mana - 10; // rehefa mandefa magie izy dia miha mihena ny mana
                System.out.println(this.nom+" vous avez lancer une magie qui a pour degat 5 a "+p.nom+" //magie infliger"+10);
                System.out.println("---------------------------------------------------------------");
        }else{
            System.out.println("veillez boire une possion de mana");
            System.out.println("---------------------------------------------------------------");
        }
    }
    public void choisirAction(int response,personnage p){
            switch(response){
                case 1:
                    this.afficherEtat();
                    break;
                case 2:
                    this.attaquer(p);
                    break;
                case 3:
                    this.lancerMagie(p);
                    break;
                case 4:
                    this.boirePossionDeMana();
                    break;
                case 5:
                    this.boirePossionDeVie();
                    break;
                case 6:
                    this.changerArme(this.votreArme);
                    break;
            }

    }
}