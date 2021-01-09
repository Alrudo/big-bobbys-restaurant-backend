package ru.deathcry.bigbobby.c_theory.question14.blogs

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/blogs")
class BlogsController {
    //todo for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //todo
    // You are creating a rest controller for blogs. Think blog aggregator or blog collection.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //todo A add necessary annotations on the class

    //todo B create a method to query blogs (plural)
    @GetMapping
    fun getAllPosts(
        @RequestParam page: Int = 1,
        @RequestParam size: Int = 20,
        @RequestParam sortByColumn: String = "views",
        @RequestParam order: String = "desc"
    ): List<Blog>{
        // call some `BlogsService` function, that would fetch data using BlogsRepository.findAll()
        return listOf()
    }

    //todo C create a method to query single blog
    @GetMapping("/{name}")
    fun findPostByName(@PathVariable name: String): Blog?{
        // call some `BlogsService` function, that would fetch 1 Blog object using BlogsRepository.findByName(name)
        return null
    }

    //todo D create a method to save a new blog
    @PostMapping
    fun createBlog(@RequestBody blog: Blog) {
        // call some `BlogsService` function, that would save data using BlogsRepository.findByName(blog)
    }

    //todo E create a method to update a blog
    @PutMapping("/{name}")
    fun updateBlog(@PathVariable name: String, @RequestBody blog: Blog) {
        // call some `BlogsService` function, that would find Blog by  data using BlogsRepository.save(blog)
        // in service there can be some validation for fields that can't be modified, if needed
    }

    //todo F create a method to delete a blog
    @DeleteMapping("/{name}")
    fun deleteBlog(@PathVariable name: String) {
        // call some `BlogsService` function, that would in data using BlogsRepository.save(blog)
        // blog object must have name that already exists, exception otherwise
        // in service there can be validation for fields that can't be modified for example
    }

    //todo G assuming each blog has only 1 author (one-to-one relation) create a method to query blog's author
    @GetMapping("/{name}/author")
    fun getAuthorByBlog(@PathVariable name: String): Author?{
        // call some `BlogsService` function, that would fetch Blog by name and then return Author from it
        return null
    }

    //todo H create a method to update blog url (and nothing else)
    @PutMapping("/{name}/url", consumes = ["text/plain"])
    fun updateBlog(@PathVariable name: String, @RequestBody url: String) {
        // Updates url for blog specified by name
    }

    //todo I-J modify correct method to support pagination, pagination is done by page and size
    // Function at task B was modified

    //todo I add page (pagination starts at page 1)
    // Function at task B was modified
    //todo J add size (default page size is 20)
    // Function at task B was modified

    //todo K modify correct method to order blogs
    // * by most recent first
    // * by least recent first
    // (you can assume that by default it searches by most popular first)
    // Function at task B was modified
}