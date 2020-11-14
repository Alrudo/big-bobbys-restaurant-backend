package ru.deathcry.bigbobby.b_theory.question11;

public class Nr4isI {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does I stand for in SOLID? Explain the principle.
    //todo B Give an example. Write actual or pseudo code.

    // I stands for Interface Segregation Principle

}

// As the author of SOLID book Robert C. Martin describes it:
// clients should not be forced to implement unnecessary methods which they will not use.

// If we translate this idea to code - we shouldn't modify any existing interface and instead
// we should just add a new one, so the user that uses our code can chose by himself
// what he need by simply implementing multiple interfaces

// Example
// Let's imagine we created simple interface for creating emails
interface IEmail
{
    void CreateEmail();
}

// But then after a while we decided that we need some more functionality for working with emails
// This would be wrong way to do it
interface IEmailWrong
{
    void CreateEmail();
    void ReadEmail();
    void DeleteEmail();
}

// Instead you should just create more interfaces, so the user could implement those ones that he needs.
interface IEmailCreate {
    void CreateEmail();
}

interface IEmailRead {
    void ReadEmail();
}

interface IEmailDelete {
    void DeleteEmail();
}
