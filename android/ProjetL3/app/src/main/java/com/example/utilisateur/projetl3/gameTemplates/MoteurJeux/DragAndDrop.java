package com.example.utilisateur.projetl3.gameTemplates.MoteurJeux;

/**
 * Created by Utilisateur on 14/03/2018.
 */

/*

Cette classe n'est pas trés utile ni complexe, mais c'est pour la garder en tant qu'exemple pour continuer :
Chaque jeu devra par la suite séparer (au maximum) les aspects visibles des aspects "moteur".

 */

public class DragAndDrop {
    private int objectif;
    private int valeurDepart; //poms' déjà dans le panier en début de partie
    private int stock; //poms' mises à disposition du joeur.

    public DragAndDrop(int goal){
        if(goal >= 0){
            objectif=goal;
        }else{
            objectif=goal*-1;
        }
        valeurDepart=0; // On changera ça par la suite en "Un nombre aléatoire entre 0 et objectif-1" (le -1 seulement si objectif>0)
        stock=objectif - valeurDepart; //On pourra ajouter un nombre aléatoire de poms' à ce nombre.
    }

    public int verifWin(int score){
        if(score == objectif){
            //gagné
            return 1;
        }
        if(score < objectif){
            //Pas assez
            return -1;
        }else{
            //trop
            return 0;
        }
    }

    public int getGoal(){
        return objectif;
    }

    public int getStock(){
        return stock;
    }
}