package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet
{
    private String name;

    public Cat(String name)
        {
        this.name = name;
        }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i <= 0, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     *
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i)
        {
        String str="";
        if (i < 1)
            {str=name+" спит.";
            }
        else
            {  str=name+" говорит м"+repeat("я",i)+"у!";  // printing may
            }
        String str2=str;
        class CatPat implements Sayable
        {
            @Override
            public String say()
                {
                return str2;
                }
        }
        CatPat cc=new CatPat();
        return cc;
        }
    String repeat(String s, int times) {     if (times <= 0) return "";     else return s + repeat(s, times-1); }
}