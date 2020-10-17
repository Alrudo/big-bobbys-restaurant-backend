package ru.deathcry.bigbobby.a_theory.question5

class ApplicationLayers { //todo
    // Architects insist on having layered architecture in the back-end... ¯\_(ツ)_/¯

    //todo p1
    // Name 3 layers of back-end architecture. Give a brief description for each.
    // 1 API
    // Description: top layer that presents the functionality of the application to the end user
    // 2 Business
    // Description: layer that contains the logic, sets of rules, services and tools required to perform some action
    // 3 Data
    // Description: layer that includes everything needed to communicate with the database

    //todo p2
    // Do you agree with the architects? Why?
    // Yes
    // Because: Its much easier to maintain the code when it is separated for those layers, instead of having one big chunk
    // of code that is doing everything in unthinkable manner.

    //todo p3
    // We use objects to transport data between different layers.
    // What is the difference between Entity and Dto? What is same between them?
    // Answer: Dto is simplified version of Entity that misses some not important data from Entity and that
    // is used to exchange data between back and frontend
}