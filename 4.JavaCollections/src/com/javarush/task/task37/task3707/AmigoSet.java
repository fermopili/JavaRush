package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Administrator on 15.05.2017.
 */
/*
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>
{
    private static final Object PRESENT = new Object ( );
    private transient HashMap<E, Object> map;

    public AmigoSet()
        {
        map = new HashMap<> ( );
        }

    public AmigoSet(Collection<? extends E> collection)
        {
        map = new HashMap<> ((int) Math.max (16, collection.size ( ) / .75f + 1));
        this.addAll (collection);
        }

    @Override
    public Object clone() //throws CloneNotSupportedException
    {
    try
        {
            AmigoSet amigoSet = new AmigoSet ();//AmigoSet) super.clone ( );
           amigoSet.map = ( HashMap<E, Object> ) map.clone ( );
            return amigoSet;
        }
    catch (Exception e)
        {
            throw new InternalError ( );
        }

    }

    @Override
    public Iterator<E> iterator()
        {
        Set<E> e = map.keySet ( );
        return e.iterator ( );
        }

    @Override
    public int size()
        {
        return map.size ( );
        }

    @Override
    public boolean add(E e)
        {
        return null == map.put (e, PRESENT);
        }

    public boolean isEmpty()
        {
        return map.isEmpty ( );
        }

    public boolean contains(Object o)
        {
        return map.containsValue (o);
        }

    public void clear()
        {
        map.clear ( );
        }

    public boolean remove(Object o)
        {
      //  return map.remove (o) == null;
        return   map.remove(o)==PRESENT;
        }
}
*/

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>
{
    private static final Object PRESENT = new Object ( );
    private transient HashMap<E, Object> map;

    public AmigoSet()
        {
        map = new HashMap<E, Object> ( );
        }

    public AmigoSet(Collection<? extends E> collection)
        {
        int capacity = Math.max (16, (int) (collection.size ( ) / 0.75f + 1));
        map = new HashMap<E, Object> (capacity);
        addAll (collection);
        }

    @Override
    public Iterator<E> iterator()
        {
        return map.keySet ( ).iterator ( );
        }

    @Override
    public int size()
        {
        return map.size ( );
        }

    @Override
    public boolean isEmpty()
        {
        return map.isEmpty ( );
        }

    @Override
    public boolean contains(Object o)
        {
        return map.containsKey (o);
        }

    @Override
    public boolean remove(Object o)
        {
        return map.remove (o) == PRESENT;
        }

    @Override
    public void clear()
        {
        map.clear ( );
        }

    @Override
    public Spliterator<E> spliterator()
        {
        return map.keySet ( ).spliterator ( );
        }

    @Override
    public boolean removeIf(Predicate<? super E> filter)
        {
        return false;
        }

    @Override
    public Stream<E> stream()
        {
        return null;
        }

    @Override
    public boolean add(E e)
        {
        return map.put (e, PRESENT) == null;
        }

    @Override
    public Stream<E> parallelStream()
        {
        return null;
        }

    @Override
    public void forEach(Consumer<? super E> action)
        {
        }

    @Override
    public Object clone()
        {
        try
            {
                AmigoSet copy = (AmigoSet) super.clone ( );
                copy.map = (HashMap) map.clone ( );
                return copy;
            }
        catch (Exception e)
            {
                throw new InternalError ( );
            }
        }

    private void writeObject(ObjectOutputStream out) throws IOException
        {
       out.defaultWriteObject ( );
       out.writeObject (map.keySet ( ));
       out.writeFloat (HashMapReflectionHelper.callHiddenMethod (map, "loadFactor"));
       out.writeInt (HashMapReflectionHelper.callHiddenMethod (map, "capacity"));

        }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
      in.defaultReadObject ( );
        Set   keys       = (Set) in.readObject ( );
       float loadFactor = in.readFloat ( );
        int   capacity   = in.readInt ( );
        map = new HashMap (capacity, loadFactor);
        addAll (keys);
        }

}
