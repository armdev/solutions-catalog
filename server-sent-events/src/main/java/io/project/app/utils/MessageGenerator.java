package io.project.app.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MessageGenerator {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final List<String> COMMENT_AUTHOR
            = Arrays.asList(
                    "Linus Torvalds", "Bill Gates", "Ada Lovelace", "Grace Hopper", "Mark Zuckerberg", "Sheryl Sandberg",
                    "Elon Musk", "Tim Berners-Lee", "Guido van Rossum", "James Gosling", "Bjarne Stroustrup", "Margaret Hamilton",
                    "Taylor Swift", "Beyonce Knowles", "Adele Adkins", "Ed Sheeran", "Ariana Grande", "Bruno Mars",
                    "Elton John", "Lady Gaga", "Rihanna Fenty", "Katy Perry", "Michael Jackson");

    private static final List<String> COMMENT_MESSAGE
            = Arrays.asList(
                    "There are only two hard things in Computer Science: cache invalidation and naming things.",
                    "It's not a bug – it’s an undocumented feature.",
                    "Why do Java developers wear glasses? Because they don't see sharp.",
                    "To understand recursion, you must first understand recursion.",
                    "There are 10 types of people in the world: those who understand binary, and those who don't.",
                    "Programming is like writing a book... except if you miss a single comma on page 126, the whole thing makes no sense.",
                    "Software and cathedrals are much the same – first we build them, then we pray.",
                    "Weeks of coding can save you hours of planning.",
                    "In theory, there is no difference between theory and practice. But, in practice, there is.",
                    "If debugging is the process of removing bugs, then programming must be the process of putting them in.",
                    "Code is like humor. When you have to explain it, it’s bad.",
                    "Experience is the name everyone gives to their mistakes.",
                    "First, solve the problem. Then, write the code.",
                    "Simplicity is the soul of efficiency.",
                    "Before software can be reusable, it first has to be usable.",
                    "Any fool can write code that a computer can understand. Good programmers write code that humans can understand.",
                    "Optimism is an occupational hazard of programming: feedback is the treatment.",
                    "Perfection is achieved not when there is nothing more to add, but rather when there is nothing more to take away.",
                    "The best way to get a project done faster is to start sooner.",
                    "The best thing about a boolean is even if you are wrong, you are only off by a bit.",
                    "Deleted code is debugged code.",
                    "The problem with troubleshooting is that trouble shoots back.",
                    "Don't comment bad code – rewrite it.",
                    "If at first you don’t succeed; call it version 1.0.",
                    "A good programmer looks both ways before crossing a one-way street.",
                    "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
                    "The trouble with programmers is that you can never tell what a programmer is doing until it’s too late.",
                    "Walking on water and developing software from a specification are easy if both are frozen.",
                    "If builders built buildings the way programmers wrote programs, then the first woodpecker that came along would destroy civilization.",
                    "There is no Ctrl-Z in life.",
                    "One man's crappy software is another man's full-time job.",
                    "When in doubt, use brute force.",
                    "If you think it's simple, then you have misunderstood the problem.",
                    "Talk is cheap. Show me the code.",
                    "Programs must be written for people to read, and only incidentally for machines to execute.",
                    "You can't have great software without a great team, and most software teams behave like dysfunctional families.",
                    "When a program is being tested, it is too late to make design changes.",
                    "A language that doesn't affect the way you think about programming is not worth knowing.",
                    "Don't worry if it doesn't work right. If everything did, you'd be out of a job.",
                    "Program testing can be a very effective way to show the presence of bugs, but it is hopelessly inadequate for showing their absence.",
                    "The most disastrous thing that you can ever learn is your first programming language.",
                    "In order to understand recursion, one must first understand recursion.",
                    "The function of good software is to make the complex appear to be simple.",
                    "Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.",
                    "If at first you don’t succeed, you must be a programmer.",
                    "Before software can be reusable it first has to be usable.",
                    "People think that computer science is the art of geniuses but the reality is the opposite, just many people doing things that build on each other, like a wall of mini stones.",
                    "Never underestimate the bandwidth of a station wagon full of tapes hurtling down the highway.",
                    "A computer program does what you tell it to do, not what you want it to do.",
                    "Computers are fast; programmers keep it slow.",
                    "Programming is not about what you know; it's about what you can figure out.",
                    "The best error message is the one that never shows up.",
                    "Programming is the art of telling another human what one wants the computer to do.",
                    "Any sufficiently advanced bug is indistinguishable from a feature.",
                    "The perfect project plan is possible if one first documents a list of all unknowns.",
                    "To iterate is human, to recurse divine.",
                    "Real programmers don't comment their code. If it was hard to write, it should be hard to understand.",
                    "A user interface is like a joke. If you have to explain it, it’s not that good.",
                    "Programming is like kicking yourself in the face, sooner or later your nose will bleed.",
                    "In a room full of top software designers, if two agree on the same thing, that’s a majority.",
                    "The best code is no code at all.",
                    "Weeks of coding can save you hours of planning.",
                    "The trouble with quotes on the internet is that you can never know if they are genuine.",
                    "Programming is 10% writing code and 90% understanding why it doesn't work.",
                    "Fast, Good, Cheap: Pick any two.",
                    "Just because you’ve counted all the trees doesn’t mean you’ve seen the forest.",
                    "The best thing about a boolean is even if you are wrong, you are only off by a bit.",
                    "There are two ways to write error-free programs; only the third one works.",
                    "The most important property of a program is whether it accomplishes the intention of its user.",
                    "If debugging is the process of removing software bugs, then programming must be the process of putting them in.",
                    "Make it work, make it right, make it fast.",
                    "It's not a bug – it's an undocumented feature!",
                    "I don’t care if it works on your machine! We are not shipping your machine!",
                    "Failure is not an option — it comes bundled with the software.",
                    "Software undergoes beta testing shortly before it’s released. Beta is Latin for “still doesn’t work.",
                    "There are two ways of constructing a software design: one way is to make it so simple that there are obviously no deficiencies and the other way is to make it so complicated that there are no obvious deficiencies.",
                    "Computer science education cannot make anybody an expert programmer any more than studying brushes and pigment can make somebody an expert painter.",
                    "The only way to go fast is to go well.",
                    "The proper use of comments is to compensate for our failure to express ourself in code.",
                    "Sometimes it pays to stay in bed on Monday, rather than spending the rest of the week debugging Monday’s code."
            );

    public static String randomAuthor() {
        return COMMENT_AUTHOR.get(RANDOM.nextInt(COMMENT_AUTHOR.size()));
    }

    public static String randomMessage() {
        return COMMENT_MESSAGE.get(RANDOM.nextInt(COMMENT_MESSAGE.size()));
    }

    public static String getCurrentTimeStamp() {
        return dtf.format(LocalDateTime.now());
    }
}
