package ru.deathcry.bigbobby.a_theory.question4

class DependencyInjection { //todo
    // One of the reasons we use Spring is that it gives us good support for
    // Dependency Injection (DI) and Inversion of Control (IoC)
    //todo p1
    // In your words (do not use wiki definitions)
    // What is Dependency Injection?
    // Answer: Sort of programming technique that makes a class independent of its dependencies
    //todo p2
    // Bring example from your code of Dependency Injection.
    // Paste your code here, but comment it out
    // Seriously? The whole spring framework is about DI, all those @Bean and @Autowired annotations are used for those purposes
    // Every Repository, Service and Controller has some constructor variables - those are dependecy injected

//    @RestController
//    @RequestMapping("/common")
//    class CommonController(
//            var menuItems: MenuRepository,            // this will be injected
//            var customers: CustomerRepository,        // this too
//            var ingredients: IngredientRepository,    // and this
//            var orders: OrderRepository,              // even this
//            var customerService: CustomerService      // ... and this too!
//    ) {
//
//        @GetMapping("/testdata")
//        fun addTestData(): List<Order> {
//            orders.deleteAll()
//            customers.deleteAll()
//            val customer1 = customers.save(Customer("test123123123@gmail.com", "123123123", "Sergei", "Saal", ""))
//            val customer2 = customers.save(Customer("test31231231231@yandex.ru", "123123123", "Sergei", "Saal", ""))
//            orders.save(Order("Sergei", "+37256966669", customer1))
//            return orders.findAll().toList()
//        }
//
//    }

    //todo p3
    // Name 2 benefits of Dependency Injection
    // 1 testing is simplified, any dependency can be easily swapped out for some mock.
    // 2 classes are more modular, as they depend only on the interface of passed-in dependencies
    //todo p4
    // Name 1 disadvantage of Dependency Injection
    // 1 harder to understand how a class works when reading just that class, hard to track down the places where it is invoked
}