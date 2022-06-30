package ru.gb.Patterns.Visitor;

public class Student extends Person{
    public int groupId;

    @Override
    public void Visit(PersonVisitor personVisitor) {
        personVisitor.showInfoPerson(this);
    }
}
