package com.company.U1M4SummativeHerreraGeofredo.controller;

import com.company.U1M4SummativeHerreraGeofredo.model.Magic8;
import com.company.U1M4SummativeHerreraGeofredo.model.Quote;
import com.company.U1M4SummativeHerreraGeofredo.model.WordDef;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Class level annotation, identifies controller to Spring
@RestController
public class SummativeController {

    //In memory DAO's per instructions
    private List<Quote> quoteList = new ArrayList<>(); //Holds Quote objects and will be called with Random class passed as index
    private List<WordDef> wordList = new ArrayList<>();  //Holds WordDef objects and will be called with Random class passed as index
    private List<Magic8> magicList = new ArrayList<>();  //List that will be updated to save the Magic8 object passed in
    private List<String> answerList = new ArrayList<>();  //Holds magic 8 ball answers and will be called with Random class passed as index

    //Method level annotation(also could be used as class level for an ExceptionHandler class
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){

        Quote quote = new Quote();
        Random rand = new Random();
        int randomInt = rand.nextInt(10);

        //All objects are being initialized and added to quoteList
        quote.setAuthor("Dr. Seuss");
        quote.setQuote("Don't cry because it's over, smile because it happened.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Oscar Wilde");
        quote.setQuote("Be yourself; everyone else is already taken.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Albert Einstein");
        quote.setQuote("Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Robert Frost");
        quote.setQuote("In three words I can sum up everything I've learned about life: it goes on.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Oscar Wilde");
        quote.setQuote("To live is the rarest thing in the world. Most people exist, that is all.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Ralph Waldo Emerson");
        quote.setQuote("To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Stephen King");
        quote.setQuote("Get busy living or get busy dying.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Mark Twain");
        quote.setQuote("Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Theodore Roosevelt");
        quote.setQuote("It is hard to fail, but it is worse never to have tried to succeed.");
        quoteList.add(quote);

        quote = new Quote();
        quote.setAuthor("Joshua J. Marine");
        quote.setQuote("Challenges are what make life interesting and overcoming them is what makes life meaningful");
        quoteList.add(quote);

        return quoteList.get(randomInt);  //returns Quote object at a random index
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public WordDef getWord(){

        WordDef wordDef = new WordDef();
        Random rand = new Random();
        int randomInt = rand.nextInt(10);

        //WordDef objects are initialized and added to wordList
        wordDef.setWord("SUCCESS");
        wordDef.setDefinition("The accomplishment of an aim or purpose");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("PERSISTENCE");
        wordDef.setDefinition("Firm or obstinate continuance in a course of action in spite of difficulty or opposition");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("DETERMINATION");
        wordDef.setDefinition("Firmness of purpose");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("DEDICATION");
        wordDef.setDefinition("Self sacrificing devotion and loyalty");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("PERFORMANCE");
        wordDef.setDefinition("The execution of an action");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("ACTION");
        wordDef.setDefinition("An act of will");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("WILL");
        wordDef.setDefinition("Used to express desire, choice, willingness, consent, or in negative constructions refusal");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("DISCIPLINE");
        wordDef.setDefinition("A rule or system of rules governing conduct or activity");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("COMMITMENT");
        wordDef.setDefinition("An agreement or pledge to do something in the future");
        wordList.add(wordDef);

        wordDef = new WordDef();
        wordDef.setWord("FAILURE");
        wordDef.setDefinition("Lack of success");
        wordList.add(wordDef);

        return wordList.get(randomInt); //Returns a WordDef object at a random index from wordList
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Magic8 getMagic(@RequestBody @Valid Magic8 question){

        Random rand = new Random();
        int randomInt = rand.nextInt(6);

        //initializing answerList
        answerList.add("Don't count on it buddy.");
        answerList.add("How about...NO!");
        answerList.add("Totes Mc'gotes, it's a go.");
        answerList.add("YASSS!");
        answerList.add("I'm on the toilet, try again in 35 or 45 minutes.");
        answerList.add("Don't you have google?");

        question.setAnswer(answerList.get(randomInt));  //randomly initializes the "answer" property

        magicList.add(question); //adds object to magicList

        return question;
    }
}
