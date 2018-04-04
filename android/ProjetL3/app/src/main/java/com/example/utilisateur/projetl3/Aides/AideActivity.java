package com.example.utilisateur.projetl3.Aides;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.utilisateur.projetl3.R;

/**
 * Created by Utilisateur on 31/03/2018.
 */

public class AideActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String intitule = getIntent().getStringExtra("Titre");

        setContentView(R.layout.activity_aide);

        TextView titre= findViewById(R.id.titleView);
        TextView description= findViewById(R.id.descriptionView);

        titre.setText(intitule);

        //TODO : Quand on aura de véritables "aides" avec images explicatives, on pourra les placer là. (à moins que l'on ai trouvé le moyen de le faire via BDD, ce qui serait plus propre.)
        switch (intitule){
            case "Les nombres":
                description.setText("Chaque quantité à son nombre! Cela nous évite de devoir dire à quelqu'un qu'on veut une pomme...\n Puis une pomme...\n Puis ecore une pomme.\n Au lieu de ça, nous pouvons dire : Je veux 3 pommes!");
                break;
            case "Compter":
                description.setText("Compter est comme ajouter une pomme à un tas. Au début on part avec aucune pomme... Et on en ajoute une, nous avons donc une pomme.\n Puis on en ajoute une autre, ça fait deux pommes!\n On continue et on en ajoute encore une? Nous avons donc maintenant un petit tas de trois pommes.");
                break;
            case "(+) Les additions":
                description.setText("Additioner c'est comme prendre un panier de pommes et le verser dans un autre panier de pommes, on se retrouve donc avec toutes ces pommes dans le même panier!\n Celles qui étaient dans le panier qu'on à versé mais aussi celles qui étaient déjà dans le panier qui contient maintenant toutes les pommes.");
                break;
            case "(-) La soustraction":
                description.setText("Soustraire c'est comme manger ou jeter des pommes hors de son panier, si on retire des pommes de son panier alors on a moins de pommes donc leur nombre diminue.");
                break;
            case "(*) La multiplication":
                description.setText("Quand on multiplie c'est comme si on prenait un sac de pommes et qu'on en demandait plusieurs avec le même nombre de pommes dedans.");
                break;
            case "(/) La division":
                description.setText("Maintenant qu'on a eu toutes ces pommes... On voudrait les partager, parcequ'on arrivera jamais à les manger tous seuls... Dans ce cas on peut diviser nos pommes!\n Diviser c'est comme séparer nos tas de pommes en plusieurs tas plus petits mais de qui ont tous la même taille. (Comme ça, pas de jaloux!)");
                break;
            default:
                description.setText("Cette aide ne semble pas exister... Désolé, mais pour nous faire pardonner nous te donnons cette magnifique pomme!");
                break;
        }
    }
}