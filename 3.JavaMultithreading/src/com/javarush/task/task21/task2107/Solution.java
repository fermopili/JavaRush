package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
/*
Глубокое клонирование карты
*/
public class Solution  implements Cloneable
{

    public static void main(String[] args)
        {
        Solution solution = new Solution ( );
        solution.users.put ("Hubert", new User (172, "Hubert"));
        solution.users.put ("Zapp", new User (41, "Zapp"));
        Solution clone = null;
        try
            {
                clone =(Solution) solution.clone ( );
                System.out.println (solution);
                System.out.println (clone);

                System.out.println (solution.users);
                System.out.println (clone.users);

            }
        catch (CloneNotSupportedException e)
            {
                e.printStackTrace (System.err);
            }
        }

    protected Map<String, User> users = new LinkedHashMap ( );

    @Override
    public boolean equals(Object o)
        {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return users.equals (solution.users);
        }

    @Override
    protected Solution clone() throws CloneNotSupportedException
        {

        Solution sol = new Solution ( );
        sol.users.putAll (users);
        return sol;
        }

    @Override
    public int hashCode()
        {int result=0;
        for(Map.Entry entry : this.users.entrySet())
            {
                User u =(User)entry.getValue();
                String str= (String) entry.getKey();
                result=result*31+u.hashCode ()+str.hashCode ();

            }
        return result;
        }

    public static class User implements Cloneable
    {
        int    age;
        String name;

        public User(int age, String name)
            {
            this.age = age;
            this.name = name;
            }
        @Override
        public int hashCode()
            {
            int result = age;
            result = result * 31 + (name != null ? name.hashCode ( ) : 0);
            return result;
            }

        @Override
        public boolean equals(Object obj)
            {
            if (this == obj) return true;
            if (obj == null)
                if (!(obj instanceof Solution))
                    return false;
            User u=(User)obj;
            if (age != u.age) return false;
            if (name != null ? !name.equals(u.name) : u.name != null) return false;

            return true;
            }

        @Override
        protected User clone() throws CloneNotSupportedException
            {
                User u= new User(age,name);
            return   u;
            }
    }
}
