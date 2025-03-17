import java.util.*;

/*
1. ajouter une  interface Graphic
   void drow();
   void colorer(int color);

2. Implémémenter Graphic dans Cercle

   void drow();
        afficher le message "Traçage graphique du cercle de rayon [r]"
   void colorer(int color);
        afficher le message:
        "Changement avec succès de la couleur du cercle du [r] vers la    
         couleur [color]"
3. TestForme :
        colorer en noir (0) les cerlce du dessin


*/
interface DbServices{
    void addToDb();
    void delFromDb();
}

abstract class Forme{
    int color;
    Forme(int color){this.color = color;}
    abstract float surf();
}

class Rect extends Forme implements  DbServices{
    float l, L;
    public void addToDb(){
        System.out.println("Ajout avac succès " +
                "du Rectangle ["+color+"], long. ["+ L +"] " +
                "et largeur ["+l+"]");
    };
    public void delFromDb(){
        System.out.println("Supp avac succès " +
                "du Rectangle ["+color+"], long. ["+ L +"] " +
                "et largeur ["+l+"]");


};


    float surf(){ return L*l;}
    public Rect(float l, float L, int color){
        super(color);    this.l=l;  this.L=L;
    }
}
class Cercle extends Forme  implements DbServices{
    float r;

    public void addToDb(){
        System.out.println("Ajout avec succès " +
                "du Cercle ["+color+"], Ray. ["+ r +"] " );
    };
    public void delFromDb(){
        System.out.println("supp  avec succès " +
                "du Cercle ["+color+"], Ray. ["+ r +"] " );


    };


    float surf(){ return (float)(3.14*r*r);}
    public Cercle(float r, int color){
        super(color);    this.r=r;
    }
}
public class TestForme{
    public static void main(String []args){
        Vector<Forme> dessin = new Vector<Forme>();
        
        try{dessin.add(new Rect(-400,50,1));
        dessin.add(new Cercle(10  ,3));
        dessin.add(new Rect(70,-20 ,4));
        dessin.add(new Rect(100,50,1));
        dessin.add(new Cercle(0  ,7));
        for (Forme F : dessin)
            ((DbServices)F).addToDb();
        //supp. les cerlcle de rayon r=0
        for (Forme F : dessin)
            if (F instanceof Cercle) // si F contient une instance de Cercle
                if (((Cercle) F).r==0)
        ((DbServices)F).delFromDb();
        // conversion de F en DbServices (casting)
        // pour pouvoir appeler del_db à partir de F
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }
}