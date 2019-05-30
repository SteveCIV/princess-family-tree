package dslab5;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author conor
 */
public class DsLab5 {
    public static void main(String[] args) {
        
        // data structures needed to create and traverse a family tree
        HashMap hm = new HashMap(37);
        TNode royalFamily;
        LQueue<TNode> royalQueue = new LQueue<>();
        
        // scanner for finding file
        File file = new File("C:\\Users\\conor\\Documents\\NetBeansProjects\\CS141\\DsLab5\\src\\dslab5\\familyTreeData\\royals2.txt");
        Scanner scr = null;

        // finds requested file
        try {
            scr = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
        // access node for tree traversals 
        royalFamily = fillTreeRoyals(scr, hm);
        
        System.out.println("FINAL TREE");
        printHashMap(hm);
        
        // level order transeral of tree
        System.out.println("FINAL QUEUE");
        printRoyalFamily(royalFamily);
    }
    
    // takes txt file and builds royal family
    public static TNode fillTreeRoyals(Scanner scr, HashMap hm) {
        
        // get common ancestor name, birthyear
        String commonAncestor = scr.nextLine();
        String commonAncestorName = commonAncestor.substring(16, 31);
        int commonAncestorBirth = Integer.valueOf(commonAncestor.substring(32, 36));
        
        // puts commonAncestor at the base of new tree
        Princess grandmotherPrincess = new Princess(commonAncestorName, commonAncestorBirth);
        TNode ca = new TNode(grandmotherPrincess);
        //Tree royalFamily = new Tree(ca);
        
        // puts ca node in hashmap
        hm.put(commonAncestorName, ca);
                
        // for every descendant...
        while(scr.hasNextLine()) {
            
            // get descendant name, mother, birthyear
            String royalData = scr.nextLine();
            String royalMother = royalData.substring(0, 15);
            String royalName   = royalData.substring(16, 31);
            int    royalBirth  = Integer.valueOf(royalData.substring(32, 36));
            
            // puts descendant to put in tree
            Princess commonPrincess = new Princess(royalName, royalBirth);
            TNode descendantPrincess = new TNode(commonPrincess);
            
            // put descendant in hashmap
            hm.put(royalName, descendantPrincess);
            
            // find mother in hashmap
            TNode mother = (TNode)hm.get(royalMother);
                        
            // places descendant in tree, among siblings, by birthyear. Three possible cases
            try {
                
                // if descendant does not have an older sibling
                // set mothers eldest child
                if(mother.getFirstChild() == null) {
                    mother.setFirstChild(descendantPrincess);
                }
                
                // else if descendant is older than mothers eldest child
                // set as mothers eldest child and current eldest child as next sibling
                else if(mother.getFirstChild().getPrincess().getBirthYear() > descendantPrincess.getPrincess().getBirthYear()) {
                    descendantPrincess.setNextSibling(mother.getFirstChild());
                    mother.setFirstChild(descendantPrincess);
                }
                
                // else if descendant isn't eldest sibling, loop through siblings until suitable spot between two siblings is found
                // make two pointer assignments to place descendant amoung siblings
                else if(mother.getFirstChild().getPrincess().getBirthYear() <= descendantPrincess.getPrincess().getBirthYear()) {
                    TNode current = mother.getFirstChild();
                    while(current.getNextSibling() != null && current.getNextSibling().getPrincess().getBirthYear() <= descendantPrincess.getPrincess().getBirthYear()) {
                        current = current.getNextSibling();
                    }
                    descendantPrincess.setNextSibling(current.getNextSibling());
                    current.setNextSibling(descendantPrincess);
                }
            } catch(NullPointerException npe) {
                System.out.println("Yeet. NullPointerException");
            }
            
            // updates the new value 
            hm.replace(royalMother, mother);
        }
        return ca;
    }
    
    // level order traversal of royal family
    public static void printRoyalFamily(TNode family) {
        // adds base of tree to queue
        LQueue q = new LQueue();
        TNode current = family;
        q.enqueue(current);

        // level order traversal of family
        while(!q.isEmpty()) {
            current = (TNode)q.dequeue();
            System.out.println(current.getPrincess().getName());

            if(current.getFirstChild() != null) {
                current = current.getFirstChild();
                q.enqueue(current);
                while (current.getNextSibling() != null) {
                    current = current.getNextSibling();
                    q.enqueue(current);
                }
            }
        }
    }
    
    public static void printHashMap(HashMap hm) {
        for(Object name : hm.keySet()) {
            String key = name.toString();
            Object value = hm.get(key);
            System.out.println("Key (" + key + ") Value (" + value + ")");
        }
    }
}
