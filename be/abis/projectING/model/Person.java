package be.abis.projectING.model;

abstract class Person{
    public abstract void Personorder();
}

abstract class Admin extends Person{
   public abstract void Personorder();
}

abstract class Participant extends Person{

    public abstract void Personorder();
}


