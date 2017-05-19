package com.javarush.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution
{
    private boolean[][] humansRelationships;

    public static void main(String[] args)
        {
        Solution solution = new Solution ( );
        solution.humansRelationships = generateRelationships ( );

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends ( 4, 2 );
        System.out.println ( allFriendsAndPotentialFriends );                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet ( allFriendsAndPotentialFriends, 4 );
        System.out.println ( potentialFriends );                                           //expected: [2, 5, 7]
        }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep)
        {
        Set<Integer> set=new TreeSet<> (  );
        //напишите тут ваш код
        if (deep == 0) return set;
        for (int i = 0; i < humansRelationships.length; i++) {
            if (i < index) {
                if (humansRelationships[index][i]) {
                    set.add(i);
                    set.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humansRelationships[i][index]) {
                    set.add(i);
                    set.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        set.remove(index);
        return set;
        }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index)
        {
        for (int i = 0; i < humansRelationships.length; i++)
            {
                if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i])
                    {
                        set.remove ( i );
                    }
                else if ((i > index) && humansRelationships[i][index])
                    {
                        set.remove ( i );
                    }
            }
        return set;
        }

    //return tests data
    private static boolean[][] generateRelationships()
        {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
        }
}