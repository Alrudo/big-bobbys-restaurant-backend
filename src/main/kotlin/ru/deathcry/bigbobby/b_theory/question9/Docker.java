package ru.deathcry.bigbobby.b_theory.question9;

public class Docker {

    //todo A
    // What is a server?
    // Answer: Some real piece of hardware located somewhere and doing some computation stuff

    //todo B
    // What is the difference between build server and production server?
    // Answer: build server is used for building and testing application, production server is used to run latest
    // and stable version of that application, for being used by customers/users

    //todo C
    // What is docker?
    // Answer: Docker is a tool designed to make it easier to create, deploy, and run applications by using containers,
    // which are basically images of OS with all required dependencies for application to be able to run.

    //todo D
    // Name and explain docker container benefits over virtual machine setup (java jar as system process and installed nginx)
    // 1 Containers are far lighter than VM and start faster
    // 2 There are a lot of "ready for use" containers in Docker Hub

    //todo E
    // Name and explain docker container drawback over virtual machine setup (java jar as system process and installed nginx)
    // 1 Persistent data storage is complicated, because by design all of the
    // data inside a container disappears forever when the container shuts down

    //todo F
    // Name and describe tools for docker architecture
    // 1 Kubernetes - open-source container orchestration platform that enables the
    // operation of an elastic web server framework for cloud applications
    // 2 GitLab CI - CI platform that makes use of that docker thing

    //todo G
    // Name and explain why are companies slow in moving existing systems to docker architecture (do not explain why docker is bad)
    // 1 Companies don't see to be getting enough profit from moving over to docker
    // 2 Company has too much of already working VMs that do their job well, and transfering everything to docker might be unworthy and risky
}
