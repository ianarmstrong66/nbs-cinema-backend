package com.lunacinemas.businesslogic;

import com.lunacinemas.model.Comment;
import com.lunacinemas.model.Film;
import com.lunacinemas.model.Review;
import com.lunacinemas.persistence.CommentRepository;
import com.lunacinemas.persistence.FilmRepository;
import com.lunacinemas.persistence.ReviewRepository;
import com.lunacinemas.persistence.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.lunacinemas.Application.resetToSampleData;

@Service
public class Initialise implements Requestable {

    @Autowired
    private FilmRepository filmRepo;
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private ReviewFilter reviewFilter;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private CommentFilter commentFilter;
    @Autowired
    private ShowingRepository showRepo;
    @Autowired
    private ResponseObject<Object> res;
    @Autowired
    private ShowingHandler showingHandler;

    public ResponseObject<Object> initialiseData(){
        if (resetToSampleData) {
            initialiseFilms();
            initialiseReviews();
            initialiseComments();
            initialiseShowing();
        }
        ArrayList<Object> contentList = new ArrayList<>();
        contentList.addAll(filmRepo.findAll());
        contentList.addAll(reviewRepo.findAll());
        contentList.addAll(commentRepo.findAll());
        contentList.addAll(showRepo.findAll());
        res.positive("All data initialised successfully. ",contentList);
        return res;
    }

    private void initialiseFilms(){
        filmRepo.deleteAll();
        initialiseUpcomingFilms1();
        initialiseCurrentFilms();
    }

    private void initialiseCurrentFilms() {
        Film currentWar = new Film();
        currentWar.setTitle("The Current War");
        currentWar.setBriefDescription("The dramatic story of the cutthroat race between electricity titans Thomas Edison and George Westinghouse to determine whose electrical system would power the modern world.");
        currentWar.setDetailedDescription("Thomas Edison and George Westinghouse – one a brilliant inventor, the other a hugely successful businessman – fought each other in ‘The Current War’, over whose electricity system would power the world.  Whoever won this battle had the potential to control everything: lighting, communication and transportation could all be powered by this revolutionary new technology. And in the bitter, cutthroat competition that ensued, only one could ever come out on top.  A riveting drama about a defining moment in the history of technology,");
        currentWar.setImagePath("/CurrentFilmImages/CurrentWar.jpg");
        currentWar.setYear("2019");
        currentWar.setLength("1h 48m");
        currentWar.setClassification("Class15");
        currentWar.setDirectors(new String[] {"Alfonso Gomez-Rejon"});
        currentWar.setGenres(new String[] {"Drama"});
        currentWar.setActors(new String[] {"Tom Holland","Benedict Cumberbatch","Katherine Waterston","Tuppence Middleton"});
        currentWar.setReleased(true);
        filmRepo.save(currentWar);
        Film lionKing = new Film();
        lionKing.setTitle("The Lion King");
        lionKing.setBriefDescription("This Disney animated feature follows the adventures of the young lion Simba, the heir of his father, Mufasa. Simba's wicked uncle, Scar, plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests.");
        lionKing.setDetailedDescription("Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny on the plains of Africa. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother -- and former heir to the throne -- has plans of his own. The battle for Pride Rock is soon ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. Now, with help from a curious pair of newfound friends, Simba must figure out how to grow up and take back what is rightfully his.");
        lionKing.setImagePath("/CurrentFilmImages/Lionking.jpg");
        lionKing.setYear("2019");
        lionKing.setLength("2h 0m");
        lionKing.setClassification("ClassPG");
        lionKing.setDirectors(new String[] {"Jon Favreau"});
        lionKing.setGenres(new String[] {"Family", "Musical"});
        lionKing.setActors(new String[] {"Donald Glover, Seth Rogen, Chiwetel Ejiofor, Alfre Woodard, Billy Eichner, John Kani, John Oliver, Florence Kasumba, Eric Andre, Keegan-Michael Key, JD McCrary, Shahadi Wright Joseph, Beyonce Knowles-Carter, James Earl Jones"});
        lionKing.setReleased(true);
        filmRepo.save(lionKing);
        Film spiderMan = new Film();
        spiderMan.setTitle("Spider-Man: Far From Home");
        spiderMan.setBriefDescription("Following the events of Avengers: Endgame, Spider-Man must step up to take on new threats in a world that has changed forever.");
        spiderMan.setDetailedDescription("Peter Parker returns in Spider-Man: Far From Home, the next chapter of the Spider-Man: Homecoming series! Our friendly neighbourhood Super Hero decides to join his best friends Ned, MJ, and the rest of the gang on a European vacation. However, Peter's plan to leave super heroics behind for a few weeks are quickly scrapped when he begrudgingly agrees to help Nick Fury uncover the mystery of several elemental creature attacks, creating havoc across the continent! Following the events of Avengers: Endgame, Spider-Man must step up to take on new threats in a world that has changed forever.");
        spiderMan.setImagePath("/CurrentFilmImages/Spider.jpg");
        spiderMan.setYear("2019");
        spiderMan.setLength("2h 09m");
        spiderMan.setClassification("Class12A");
        spiderMan.setDirectors(new String[] {"Jon Watts"});
        spiderMan.setGenres(new String[] {"Action", "Superhero"});
        spiderMan.setActors(new String[] {"Tom Holland, Samuel L. Jackson, Zendaya, Cobie Smulders, Jon Favreau, JB Smoove, Jacob Batalon, Martin Starr, Marisa Tomei, Jake Gyllenhaal"});
        spiderMan.setReleased(true);
        filmRepo.save(spiderMan);
        Film toyStory = new Film();
        toyStory.setTitle("Toy Story 4");
        toyStory.setBriefDescription("Woody, Buzz Lightyear and the rest of the gang embark on a road trip with Bonnie and a new toy named Forky.");
        toyStory.setDetailedDescription("Woody (voice of Tom Hanks) has always been confident about his place in the world, and that his priority is taking care of his kid, whether that's Andy or Bonnie. So when Bonnie's beloved new craft-project-turned-toy, Forky (voice of Tony Hale), declares himself as 'trash' and not a toy, Woody takes it upon himself to show Forky why he should embrace being a toy. But when Bonnie takes the whole gang on her family's road trip excursion, Woody ends up on an unexpected detour that includes a reunion with his long-lost friend Bo Peep (voice of Annie Potts). After years of being on her own, Bo's adventurous spirit and life on the road belie her delicate porcelain exterior. As Woody and Bo realize they're worlds apart when it comes to life as a toy, they soon come to find that's the least of their worries.");
        toyStory.setImagePath("/CurrentFilmImages/Toystory.jpg");
        toyStory.setYear("2019");
        toyStory.setLength("1h 40m");
        toyStory.setClassification("ClassU");
        toyStory.setDirectors(new String[] {"Josh Cooley"});
        toyStory.setGenres(new String[] {"Family", "Animated Cartoon"});
        toyStory.setActors(new String[] {"Tom Hanks, Tim Allen, Annie Potts, Tony Hale, Keegan-Michael Key, Maddie McGraw, Christina Hendricks, Jordan Peele, Keanu Reeves, Ally Maki, Jay Hernandez, Lori Alan, Joan Cusack, Bonnie Hunt, Kristen Schaal, Emily Davis, Wallace Shawn, John Ratzenberger, Blake Clark, June Squibb, Carl Weathers, Lila Sage, Don Rickles, Jeff Garlin, Maliah Bargas-Good, Jack McGraw, Juliana Hansen, Estelle Harris"});
        toyStory.setReleased(true);
        filmRepo.save(toyStory);
        initialiseCurrentFilms2();
    }

    private void initialiseCurrentFilms2() {
        Film fastAndFurious = new Film();
        fastAndFurious.setTitle("Fast & Furious: Hobbs & Shaw");
        fastAndFurious.setBriefDescription("Lawman Luke Hobbs and outcast Deckard Shaw form an unlikely alliance when a cyber-genetically enhanced villain threatens the future of humanity.");
        fastAndFurious.setDetailedDescription("After eight films that have amassed almost $5 billion worldwide, the Fast & Furious franchise now features its first stand-alone vehicle as Dwayne Johnson and Jason Statham reprise their roles as Luke Hobbs and Deckard Shaw in Fast & Furious: Hobbs & Shaw. Ever since hulking lawman Hobbs (Johnson), a loyal agent of America's Diplomatic Security Service, and lawless outcast Shaw (Statham), a former British military elite operative, first faced off in 2015's Fast & Furious 7, the duo have swapped smack talk and body blows as they've tried to take each other down. But when cyber-genetically enhanced anarchist Brixton (Idris Elba) gains control of an insidious bio-threat that could alter humanity forever — and bests a brilliant and fearless rogue MI6 agent (The Crown's Vanessa Kirby), who just happens to be Shaw's sister - these two sworn enemies will have to partner up to bring down the only guy who might be badder than themselves. Hobbs & Shaw blasts open a new door in the Fast universe as it hurtles action across the globe, from Los Angeles to London and from the toxic wasteland of Chernobyl to the lush beauty of Samoa.");
        fastAndFurious.setImagePath("/CurrentFilmImages/FastAndFurious.jpg");
        fastAndFurious.setYear("2019");
        fastAndFurious.setLength("2h 14m");
        fastAndFurious.setClassification("Class12");
        fastAndFurious.setDirectors(new String[] {"David Leitch"});
        fastAndFurious.setGenres(new String[] {"Action", "Adventure"});
        fastAndFurious.setActors(new String[] {"Dwayne Johnson, Jason Statham, Vanessa Kirby, Idris Elba"});
        fastAndFurious.setReleased(true);
        filmRepo.save(fastAndFurious);
        Film angryBirds = new Film();
        angryBirds.setTitle("The Angry Birds Movie 2");
        angryBirds.setBriefDescription("Flightless birds lead a mostly happy existence, except for Red (Jason Sudeikis), who just can't get past the daily annoyances of life. His temperament leads him to anger management class, where he meets fellow misfits Chuck (Josh Gad) and Bomb.");
        angryBirds.setDetailedDescription("The flightless angry birds and the scheming green piggies take their beef to the next level in The Angry Birds Movie 2! When a new threat emerges that puts both Bird and Pig Island in danger, Red (Jason Sudeikis), Chuck (Josh Gad), Bomb (Danny McBride), and Mighty Eagle (Peter Dinklage) recruit Chuck's sister Silver (Rachel Bloom) and team up with pigs Leonard (Bill Hader), his assistant Courtney (Awkwafina), and techpig Garry (Sterling K. Brown) to forge an unsteady truce and form an unlikely superteam to save their homes.");
        angryBirds.setImagePath("/CurrentFilmImages/Angrybirds.jpg");
        angryBirds.setYear("2019");
        angryBirds.setLength("1h 35m");
        angryBirds.setClassification("ClassU");
        angryBirds.setDirectors(new String[] {"Tony Leondis, John Rice"});
        angryBirds.setGenres(new String[] {"Action", "Adventure","Animation"});
        angryBirds.setActors(new String[] {"Jason Sudeikis, Josh Gad, Danny McBride, Peter Dinklage, Rachel Bloom, Bill Hader, Awkwafina, Sterling K. Brown"});
        angryBirds.setReleased(true);
        filmRepo.save(angryBirds);
        Film horribleHistories = new Film();
        horribleHistories.setTitle("Horrible Histories: The Movie - Rotten Romans");
        horribleHistories.setBriefDescription("Atti, a smart and quick-witted Roman teenager, manages to upset Emperor Nero with one of his schemes. For punishment, Atti is sent to work in a cold and wet Britain where he also meets the Celts.");
        horribleHistories.setDetailedDescription("Who are the Celts? What have the Romans ever done for us? And why is Emperor Nero dousing himself in horse wee? Friends, Romans, Celts... Lend us your ears. The all-conquering Romans rule the civilised world – and that includes 'the stain' that is Britain. While the young Emperor Nero must battle his scheming mother Agrippina for ultimate power, Celt queen Boudicca gathers an army in Britain to repel the rotten Romans. Mixed up in this battle for liberation are the teenage Atti, a reluctant Roman soldier, and Orla, a young Celt with dreams of becoming a warrior like Boudicca. Will they fall on opposite sides or forge a friendship in the chaos of Celtic-inspired rebellion?");
        horribleHistories.setImagePath("/CurrentFilmImages/HorribleHistories.jpg");
        horribleHistories.setYear("2019");
        horribleHistories.setLength("1h 32m");
        horribleHistories.setClassification("ClassPG");
        horribleHistories.setDirectors(new String[] {"Dominic Brigstocke"});
        horribleHistories.setGenres(new String[] {"Comedy","Family","History"});
        horribleHistories.setActors(new String[] {"Sebastian Croft, Emilia Jones, Nick Frost, Craig Roberts, Kim Cattrall, Kate Nash, Rupert Graves, Alex Macqueen, Sir Derek Jacobi, Alexander Armstrong, Lee Mack, Warwick Davis, Lucy Montgomery"});
        horribleHistories.setReleased(true);
        filmRepo.save(horribleHistories);
        Film stuber = new Film();
        stuber.setTitle("Stuber");
        stuber.setBriefDescription("When a mild-mannered Uber driver named Stu (Kumail Nanjiani) picks up a passenger (Dave Bautista) who turns out to be a cop hot on the trail of a brutal killer, he's thrust into a harrowing ordeal.");
        stuber.setDetailedDescription("A mild-mannered Uber driver named Stu picks up a grizzled detective who is hot on the trail of a sadistic, bloodthirsty terrorist and finds himself thrust into a harrowing ordeal where he has to keep his wits, himself unharmed, and work with his passenger while maintaining his high-class rating.");
        stuber.setImagePath("/CurrentFilmImages/Stuber.jpg");
        stuber.setYear("2019");
        stuber.setLength("1h 33m");
        stuber.setClassification("Class15");
        stuber.setDirectors(new String[] {"Michael Dowse"});
        stuber.setGenres(new String[] {"Action", "Comedy", "Crime", "Thriller"});
        stuber.setActors(new String[] {"Kumail Nanjiani, Dave Bautista, Iko Uwais, Natalie Morales, Betty Gilpin, Jimmy Tatro, Mira Sorvino, Karen Gillan"});
        stuber.setReleased(true);
        filmRepo.save(stuber);
    }

    private void initialiseUpcomingFilms1() {
        intitialiseUpcomingFilms2();
        Film goodboys = new Film();
        goodboys.setTitle("Goodboys");
        goodboys.setBriefDescription("Three sixth-graders try to impress girls and upperclassmen by skipping school and attending parties.");
        goodboys.setDetailedDescription("Invited to his first kissing party, 12-year-old Max asks his best friends Lucas and Thor for some much-needed help on how to pucker up. When they hit a dead end, Max decides to use his father's drone to spy on the teenage girls next door. When the boys lose the drone, they skip school and hatch a plan to retrieve it before Max's dad can figure out what happened.");
        goodboys.setImagePath("/UpcomingFilmsImages/Goodboys.jpg");
        goodboys.setYear("2019");
        goodboys.setLength("1h 40m");
        goodboys.setClassification("Class15");
        goodboys.setDirectors(new String[]{"Lee Eisenberg"});
        goodboys.setGenres(new String[]{"Adventure", "Comedy"});
        goodboys.setActors(new String[]{"Jacob Tremblay", "Brady Noon, Keith L. Williams", "Will Forte", "Molly Gordon", "Midori Francis"});
        goodboys.setReleased(false);
        filmRepo.save(goodboys);
        Film zombieland = new Film();
        zombieland.setTitle("Zombieland: Double Tap");
        zombieland.setBriefDescription("Zombie slayers Tallahassee, Columbus, Wichita and Little Rock square off against the newly evolved undead.");
        zombieland.setDetailedDescription("Columbus, Tallahasse, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.");
        zombieland.setImagePath("/UpcomingFilmsImages/Zombieland2.png");
        zombieland.setYear("2019");
        zombieland.setLength("2h 30m");
        zombieland.setClassification("Class15");
        zombieland.setDirectors(new String[]{"Ruben Fleischer"});
        zombieland.setGenres(new String[]{"Action", "Comedy", "Horror"});
        zombieland.setActors(new String[]{"Abigail Breslin", "Zoey Deutch", "Emma Stone", "Woody Harrelson", "Avan Jogia", "Rosario Dawson", "Jesse Eisenberg", "Bill Murray"});
        zombieland.setReleased(false);
        filmRepo.save(zombieland);
        Film gemini = new Film();
        gemini.setTitle("Gemini Man");
        gemini.setBriefDescription("An over-the-hill hitman faces off against a younger clone of himself.");
        gemini.setDetailedDescription("Gemini Man is an innovative action-thriller starring Will Smith as Henry Brogan, an elite assassin, who is suddenly targeted and pursued by a mysterious young operative that seemingly can predict his every move.");
        gemini.setImagePath("/UpcomingFilmsImages/GeminiMan.png");
        gemini.setYear("2019");
        gemini.setLength("2h 29m");
        gemini.setClassification("Class15");
        gemini.setDirectors(new String[]{"Ang Lee"});
        gemini.setGenres(new String[]{"Action", "Drama", "Sci-fi"});
        gemini.setActors(new String[]{"Will Smith", "Mary Elizabeth Winstead", "Clive Owen", "Benedict Wong", "Theodora Miranne", "Douglas Hodge", "Ralph Brown", "Linda Emond"});
        gemini.setReleased(false);
        filmRepo.save(gemini);
        Film jumanji = new Film();
        jumanji.setTitle("Jumanji: The Next Level");
        jumanji.setBriefDescription("Everything you know about Jumanji is about to change as the gang set off for another adventure. Get ready for a crazy ride!");
        jumanji.setDetailedDescription("A team of friends return to Jumanji to rescue one of their own but discover that nothing is as they expect. The players need to brave parts unknown, from arid deserts to snowy mountains, in order to escape the world's most dangerous game.");
        jumanji.setImagePath("/UpcomingFilmsImages/Jumanji.jpg");
        jumanji.setYear("2019");
        jumanji.setLength("2h 49m");
        jumanji.setClassification("Class12");
        jumanji.setDirectors(new String[]{"Jake Kasdan"});
        jumanji.setGenres(new String[]{"Action", "Adventure", "Comedy"});
        jumanji.setActors(new String[]{"Dwayne Johnson", "Awkwafina", "Karen Gillan", "Ashley Scott", "Jack Black", "Kevin Hart", "Madison Iseman", "Colin Hanks", "Danny DeVito", "Danny Glover"});
        jumanji.setReleased(false);
        filmRepo.save(jumanji);
    }

    private void intitialiseUpcomingFilms2() {
        Film itC2 = new Film();
        itC2.setTitle("IT Chapter Two");
        itC2.setBriefDescription("Because every 27 years evil revisits the town of Derry, Maine, IT CHAPTER TWO brings the characters - who've long since gone their separate ways - back together as adults, nearly three decades after the events of the first film.");
        itC2.setDetailedDescription("Twenty-seven years after the Losers Club defeated Pennywise (Bill Skarsgård), it returns to terrorize the town of Derry once more. Now adults, the Losers have long since gone their separate ways. However, the kids are disappearing again, so Mike (Isaiah Mustafa), the only one of the group to remain in their hometown, calls the others home. Damaged by the experiences of their past, they must each conquer their deepest fears to destroy Pennywise once and for all... putting them directly in the path of the clown that become deadlier than ever.");
        itC2.setImagePath("/UpcomingFilmsImages/IT.jpg");
        itC2.setYear("2019");
        itC2.setLength("2h 45m");
        itC2.setClassification("Class18");
        itC2.setDirectors(new String[]{"Andy Muschietti"});
        itC2.setGenres(new String[]{"Horror","Thriller"});
        itC2.setActors(new String[]{"Finn Wolfhard, Bill Skarsgård, Jessica Chastain"});
        itC2.setReleased(false);
        filmRepo.save(itC2);
        Film angelHasFallen = new Film();
        angelHasFallen.setTitle("Angel Has Fallen");
        angelHasFallen.setBriefDescription("Secret Service Agent Mike Banning is framed for the attempted assassination of the President and must evade his own agency and the FBI as he tries to uncover the real threat.");
        angelHasFallen.setDetailedDescription("When there is an assassination attempt on US President Allan Trumbull (Morgan Freeman), his trusted confidant, Secret Service Agent Mike Banning (Gerard Butler), is wrongfully accused and taken into custody. After escaping from capture, he becomes a man on the run and must evade his own agency and outsmart the FBI in order to find the real threat to the President. Desperate to uncover the truth, Banning turns to unlikely allies to help clear his name, keep his family from harm and save the country from imminent danger.");
        angelHasFallen.setImagePath("/UpcomingFilmsImages/angel.jpg");
        angelHasFallen.setYear("2019");
        angelHasFallen.setLength("2h 01m");
        angelHasFallen.setClassification("Class15");
        angelHasFallen.setDirectors(new String[]{"Ric Roman Waugh"});
        angelHasFallen.setGenres(new String[]{"Action"});
        angelHasFallen.setActors(new String[]{"Gerard Butler, Morgan Freeman, Jada Pinkett Smith, Lance Reddick, Tim Blake Nelson, Piper Perabo, Nick Nolte, Danny Huston"});
        angelHasFallen.setReleased(false);
        filmRepo.save(angelHasFallen);
        Film crawl = new Film();
        crawl.setTitle("Crawl");
        crawl.setBriefDescription("A young woman, while attempting to save her father during a category 5 hurricane, finds herself trapped in a flooding house and must fight for her life against alligators.");
        crawl.setDetailedDescription("When a massive hurricane hits her Florida hometown, Haley (Kaya Scodelario) ignores evacuation orders to search for her missing father (Barry Pepper). Finding him gravely injured in the crawl space of their family home, the two become trapped by quickly encroaching floodwaters. As time runs out to escape the strengthening storm, Haley and her father discover that the rising water level is the least of their fears.");
        crawl.setImagePath("/UpcomingFilmsImages/Crawl.jpg");
        crawl.setYear("2019");
        crawl.setLength("1h 27m");
        crawl.setClassification("Class15");
        crawl.setDirectors(new String[]{"Alexandre Aja"});
        crawl.setGenres(new String[]{"Horror","Thriller"});
        crawl.setActors(new String[]{"Kaya Scodelario, Barry Pepper"});
        crawl.setReleased(false);
        filmRepo.save(crawl);
        Film maleficent = new Film();
        maleficent.setTitle("Maleficent: Mistress Of Evil");
        maleficent.setBriefDescription("Maleficent is back. Get ready for a whole new adventure with Maleficent and Aurora as they face new threats to the magical land of the Moors.");
        maleficent.setDetailedDescription("Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.");
        maleficent.setImagePath("/UpcomingFilmsImages/Maleficent.jpg");
        maleficent.setYear("2019");
        maleficent.setLength("1h 40m");
        maleficent.setClassification("Class12A");
        maleficent.setDirectors(new String[]{"Joachim Rřnning"});
        maleficent.setGenres(new String[]{"Adventure", "Family", "Fantasy"});
        maleficent.setActors(new String[]{"Teresa Mahoney, Chiwetel Ejiofor, Angelina Jolie "});
        maleficent.setReleased(false);
        filmRepo.save(maleficent);
    }

    private void initialiseReviews(){
        reviewRepo.deleteAll();
        Review goodboysreview1 = new Review();
        goodboysreview1.setFilmId (filmRepo.findByTitle("Goodboys").getId());
        goodboysreview1.setUsername("Coxy91");
        goodboysreview1.setRating("3");
        goodboysreview1.setReview("This film was okay, but the script was poor and the acting left a lot to be desired.");
        reviewFilter.saveReview(goodboysreview1);
        Review goodboysreview2 = new Review();
        goodboysreview2.setFilmId (filmRepo.findByTitle("Goodboys").getId());
        goodboysreview2.setUsername("Andy");
        goodboysreview2.setRating("4");
        goodboysreview2.setReview("Really enjoyed this film, would definitely watch again.");
        reviewFilter.saveReview(goodboysreview2);
        Review goodboysreview3 = new Review();
        goodboysreview3.setFilmId (filmRepo.findByTitle("Goodboys").getId());
        goodboysreview3.setUsername("Ian");
        goodboysreview3.setRating("1");
        goodboysreview3.setReview("This film was a load of shit.");
        reviewFilter.saveReview(goodboysreview3);
        Review zombieland2review1 = new Review();
        zombieland2review1.setFilmId (filmRepo.findByTitle("Zombieland: Double Tap").getId());
        zombieland2review1.setUsername("Dale");
        zombieland2review1.setRating("5");
        zombieland2review1.setReview("Film of the year! This shit was Oscar Worthy.");
        reviewFilter.saveReview(zombieland2review1);
        Review zombieland2review2 = new Review();
        zombieland2review2.setFilmId (filmRepo.findByTitle("Zombieland: Double Tap").getId());
        zombieland2review2.setUsername("Carl");
        zombieland2review2.setRating("3");
        zombieland2review2.setReview("Meh, it was alright, wont be watching again.");
        reviewFilter.saveReview(zombieland2review2);
        Review geminireview1 = new Review();
        geminireview1.setFilmId (filmRepo.findByTitle("Gemini Man").getId());
        geminireview1.setUsername("Dale");
        geminireview1.setRating("1");
        geminireview1.setReview("This film was so rubbish it's unreal. Will Smith should be ashamed.");
        reviewFilter.saveReview(geminireview1);
        Review geminireview2 = new Review();
        geminireview2.setFilmId (filmRepo.findByTitle("Gemini Man").getId());
        geminireview2.setUsername("Arun");
        geminireview2.setRating("5");
        geminireview2.setReview("WHAT A FILM! ABSOLUTELY BLEW MY MIND");
        reviewFilter.saveReview(geminireview2);
        Review jumanjireview1 = new Review();
        jumanjireview1.setFilmId (filmRepo.findByTitle("Jumanji: The Next Level").getId());
        jumanjireview1.setUsername("Ben");
        jumanjireview1.setRating("3");
        jumanjireview1.setReview("It was okay but I HATE KEVIN HART. FIRE HIM NOW!");
        reviewFilter.saveReview(jumanjireview1);
        Review jumanjireview2 = new Review();
        jumanjireview2.setFilmId (filmRepo.findByTitle("Jumanji: The Next Level").getId());
        jumanjireview2.setUsername("Carl");
        jumanjireview2.setRating("5");
        jumanjireview2.setReview("Masterpiece of a film");
        reviewFilter.saveReview(jumanjireview2);
        Review currentwarreview1 = new Review();
        currentwarreview1.setFilmId (filmRepo.findByTitle("The Current War").getId());
        currentwarreview1.setUsername("Ian");
        currentwarreview1.setRating("5");
        currentwarreview1.setReview("Wonderful superb, must see film.");
        reviewFilter.saveReview(currentwarreview1);
    }

    private void initialiseComments(){
        commentRepo.deleteAll();
        Comment goodboyscomment1 = new Comment();
        goodboyscomment1.setReviewId (reviewRepo.findByFilmId(filmRepo.findByTitle("Goodboys").getId()).get(0).getId());
        goodboyscomment1.setUsername("Dale");
        goodboyscomment1.setBody("I completely agree");
        commentFilter.saveComment(goodboyscomment1);
        Comment goodboyscomment2 = new Comment();
        goodboyscomment2.setReviewId (reviewRepo.findByFilmId(filmRepo.findByTitle("Goodboys").getId()).get(1).getId());
        goodboyscomment2.setUsername("Ian");
        goodboyscomment2.setBody("You're chatting shit mate.");
        commentFilter.saveComment(goodboyscomment2);
        Comment goodboyscomment3 = new Comment();
        goodboyscomment3.setReviewId (reviewRepo.findByFilmId(filmRepo.findByTitle("Goodboys").getId()).get(1).getId());
        goodboyscomment3.setUsername("Andy");
        goodboyscomment3.setBody("Fuck you, you piece of shit.");
        commentFilter.saveComment(goodboyscomment3);
        Comment zombieland2comment1 = new Comment();
        zombieland2comment1.setReviewId (reviewRepo.findByFilmId(filmRepo.findByTitle("Zombieland: Double Tap").getId()).get(0).getId());
        zombieland2comment1.setUsername("Carl");
        zombieland2comment1.setBody("Mate, that bit at the end blew my mind! Stunning");
        commentFilter.saveComment(zombieland2comment1);

    }
    
    private void initialiseShowing() {
    	showRepo.deleteAll();
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Standard","15:00","09/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Dbox","19:00","09/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Dbox","21:00","09/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Standard","11:00","10/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Standard","14:00","10/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Dbox","18:00","10/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Dbox","18:00","11/08/2019");
        showingHandler.addShowing(filmRepo.findByTitle("The Current War").getId(),"Standard","20:00","11/08/2019");
    }
}