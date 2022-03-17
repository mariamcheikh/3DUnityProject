## Utiliser Unity AS A Library  <br />

Pour la démonstration, j'ai choisi créer une Activité principale avec une ImageView et un Bouton pour démarrer la scéne Unity. <br />
Le UnityPlayerActivity sera étendu pour ajouter des composants UI natifs (MaterialButtons) afin d'envoyer des actions au jeu Unity.<br />
<br />
À partir du projet exporté, nous avons 2 choix soit on implimente l'application android directement sur le module de Launcher généré par Unity, soit on importer le module unityLibrary dans l'application existante. J'ai choisi de  Travailler avec la deuxième solution!<br />
<br />

Grâce à UnityPlayer, On peut ajouter n'importe quel composant natif de l'UI à l'écran afin d'interagir avec le jeu.<br />
<br /> J'ai ajouté deux boutons en haut de l'écran, un pour changer la couleur de la plante et l'autre pour quitter le jeu Unity. En bas, il y aura 4 boutons pour déplacer la plante dans la scène.<br />
<br />

L'objet UnityPlayer fournit une méthode statique pour envoyer des messages natifs aux objets de jeu Unity. <br />
<br />
