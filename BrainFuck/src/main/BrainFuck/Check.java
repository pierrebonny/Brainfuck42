package BrainFuck;
import BrainFuck.Exception.CheckException;
import BrainFuck.Instructions.Back;
import BrainFuck.Instructions.Jump;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Campo on 16/11/2016.
 */

public class Check {

    private static Map<Integer, Integer> jumpBackMap = new HashMap<>();
    private BFReader reader;

    public Check(BFReader reader) {
        this.reader = reader;
    }

    //HashMap qui a comme clée la positions d'un back ou d'un jump et comme valeur la position du back ou jump associée à la clé
    public static Map<Integer, Integer> getJumpBackMap() {
        return jumpBackMap;
    }


    //Méthode Check est la SEULE méthode qui va lire le fichier (texte ou image), STOCKER les instructions dans la liste Programm de Computational, vérifier le parenthésage et remplir la jumpBackMap
    public void check(String nameFile) throws CheckException, IOException {
        this.reader.read(nameFile);
        Stack<Integer> pile = new Stack();
        try {
            for (int i = 0; i < Computational.getProgramm().size(); i++) {
                if (Computational.getProgramm().get(i) instanceof Jump)
                    pile.add(i);
                if (Computational.getProgramm().get(i) instanceof Back) {
                    jumpBackMap.put(pile.peek(), i);
                    jumpBackMap.put(i, pile.peek());
                    pile.pop();
                }
            }
            if (pile.size() != 0)
                throw new CheckException("Error 4 : CheckException", 4);
        } catch (EmptyStackException e) {
            throw new CheckException("Error 4 : CheckException", 4);
        }
    }
}



