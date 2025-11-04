import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TextAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";
        while (playAgain.equalsIgnoreCase("yes"))
        {
            // game start menu and variables
            System.out.println("\n---ROCKY ROAD---\n");
            int health = 100;
            int respect = 0;
            int coins = 0;
            ArrayList<String> inventory = new ArrayList<>();

            // Scene 1: introduction/house
            System.out.println("It's a normal day in the village. You have just come back from getting your fat cat, Rocky, some food.");
            System.out.println("You enter your house, and call for Rocky. He doesn't come.");
            System.out.println("You see a note on your dining table.");
            System.out.println("\"Kee-hee-hee. We have your boulder shaped cat, and if you don't find our secret lair \nand rescue him within 3 days, you will never see him again! ~Evil Wizards >:)\"");
            System.out.println("Oh no! You need to go save him! There are 3 items on the table, you may only take one.\n");
            System.out.println("A sword");
            System.out.println("A cloak");
            System.out.println("A can of beans\n");

            // Decision 1: Picking an item
            String userInput;
            boolean isValidInput = false;
            do {
                System.out.print("Choice (sword, cloak, or beans): ");
                userInput = sc.nextLine();
                if (userInput.equalsIgnoreCase("inventory"))
                {
                    System.out.println("\n---INVENTORY---");
                    System.out.println("You don't have anything yet.\n");
                }
                else if (userInput.equalsIgnoreCase("stats"))
                {
                    System.out.println("\n---STATS---");
                    System.out.println("Health: " + health);
                    System.out.println("Respect: " + respect);
                    System.out.println("Coins: " + coins + "\n");
                }
                else if (userInput.equalsIgnoreCase("sword"))
                {
                    inventory.add("Sword");
                    isValidInput = true;
                }
                else if (userInput.equalsIgnoreCase("cloak"))
                {
                    inventory.add("Cloak");
                    isValidInput = true;
                }
                else if (userInput.equalsIgnoreCase("beans"))
                {
                    inventory.add("Can of Beans");
                    isValidInput = true;
                }
                else
                {
                    System.out.println("\nThat isn't one of the choices, silly! Try again.");
                }
            } while (!isValidInput);
            System.out.println("\nYou added your choice to your inventory.");
            System.out.println("Your journey has just begun!\n");

            // Scene 2: The woods
            System.out.println("You leave your village and go into the woods.");
            if (inventory.contains("Cloak"))
            {
                System.out.println("It's a bit chilly out, so you use your cloak for some warmth.\n");
            }
            else if (inventory.contains("Sword"))
            {
                System.out.println("You use your sword to cut through the brush.");
            }
            else if (inventory.contains("Can of Beans"))
            {
                System.out.println("You decide to save your can of beans for later.");
            }

            // Decision 2 (Major): Choosing a path
            System.out.println("After walking for a bit, you see a fork in the path.");
            System.out.println("The one on the left has lots of snow, and looks cold.");
            System.out.println("The one on the right leads out of the forest, and seems sunnier. ");
            System.out.println("Which path will you take?\n");
            boolean hasCompanion = false;
            String companion = "";
            String userInput2;
            boolean isValidInput2 = false;
            do {
                System.out.print("Choice (left or right): ");
                userInput2 = sc.nextLine();
                if (userInput2.equalsIgnoreCase("inventory"))
                {
                    System.out.println("\n---INVENTORY---");
                    System.out.println(String.join(", ", inventory) + "\n");
                }
                else if (userInput2.equalsIgnoreCase("stats"))
                {
                    System.out.println("\n---STATS---");
                    System.out.println("Health: " + health);
                    System.out.println("Respect: " + respect);
                    System.out.println("Coins: " + coins + "\n");
                }
                else if (userInput2.equalsIgnoreCase("left"))
                {
                    if (inventory.contains("Cloak"))
                    {
                        // Scene 3 version 1: The mountains(with cloak)
                        System.out.println("\nYou walk towards the snowy path.");
                        System.out.println("The air is freezing, but your cloak makes it manageable.");
                        System.out.println("You see mountains in the distance, and on a short cliff, there is a cave with a light from a fire.");
                        System.out.println("You proceed to the cave.");
                        System.out.println("Once you enter, you are greeted with a punch to the face and you fall over.");
                        health -= 5;
                        System.out.println("Your face throbs, and you look up and realize your attacker is an auburn haired elf.");
                        System.out.println("He steps back, realizing you are not a threat.");
                        System.out.println("\"Geez, human. Don't just go into someone's camp like that! I thought you are here to kill me.\"");
                        System.out.println("You tell him that is very much not so, and why you're traveling there.");
                        System.out.println("\"Heh. Wizards, huh? I've had my share of them. Well, since you seem helpless in terms of self-defense, I have no choice but to come with you.\"");
                        System.out.println("The elf grabs a spare bow and quiver of arrows and throws it to you.");
                        inventory.add("Bow");
                        System.out.println("\"You'll need this. Name's Lucien. Let's go find ourselves a cat.\"");
                        companion = "Lucien";
                        hasCompanion = true;
                    }
                    else
                    {
                        // Scene 3 version 1: The mountains (without cloak)
                        System.out.println("\nYou walk towards the snowy path.");
                        System.out.println("The snow is coming down fast, and the air is freezing. You see mountains slightly ahead.");
                        System.out.println("You try to warm youself, but your clothes were too thin.");
                        System.out.println("Eventually, you pass out from the cold.");
                        health -= 20;
                        System.out.print("When you wake up, you are in a cave and there is an auburn haired elf sitting on the opposite wall.");
                        System.out.println(" There is a small bonfire burning next to you.");
                        System.out.println("The elf notices you're awake and speaks up.");
                        System.out.println("\"You know, that was real dumb, going out in the cold like that. Especially for a human. You're lucky I found you.\"");
                        System.out.println("You sit up and ask what his name is.");
                        System.out.println("\"Lucien. You?\"");
                        System.out.println("You tell him your name and why you were in the cold.");
                        System.out.println("\"Heh. Wizards, huh? Well, since you're a human dumb enough to travel in this weather without proper clothing, I guess I have to go with you.\"");
                        System.out.println("Lucien throws you a thick coat and a bow.");
                        inventory.add("Coat");
                        inventory.add("Bow");
                        System.out.println("\"There. Now you won't die early. Come on, human. Let's go find ourselves a cat.\"");
                        companion = "Lucien";
                        hasCompanion = true;
                    }
                    isValidInput2 = true;
                }
                else if (userInput2.equalsIgnoreCase("right"))
                {
                    // Scene 3 version 2: The town
                    System.out.println("\nYou head towards the light on the path to the right.");
                    System.out.println("At the end of the path, you find a small town.");
                    System.out.println("It looks friendly enough, so you approach one of the buildings.");
                    System.out.println("As you enter, you see a dwarf at one end of the room, forging what looks like an axe.");
                    System.out.println("You realize that this is a blacksmith's shop.");
                    System.out.println("The dwarf notices you. \"Oh, hello traveler. What brings you here? I'm Thormir. \"");
                    System.out.println("You tell him the reason for your journey, and the dwarf gets upset on your behalf.");
                    System.out.println("\"Oh, those darn wizards! This is the last straw for me.\"");
                    System.out.println("Thormir stands up with a determined look on his face.");
                    System.out.print("\"I've decided. I will accompany you on your quest! ");
                    companion = "Thormir";
                    hasCompanion = true;

                    // Scene 3 version 2 continued (with sword)
                    if (inventory.contains("Sword"))
                    {
                        System.out.println("\"It seems you already have a weapon. Good. Let us go!\"");
                    }
                    // Scene 3 version 2 continued (without sword)
                    else
                    {
                        System.out.println("\"You will need a weapon. This should suffice.\"");
                        System.out.println("Thormir gives you the axe he was forging.");
                        System.out.println("\"Now then, let us go!\"");
                        inventory.add("Axe");
                    }
                    isValidInput2 = true;
                }
                else
                {
                    System.out.println("\nOops! That isn't a path! Try again.");
                }
            } while (!isValidInput2);

            // Scene 4: The enemy
            System.out.println("\nYou and your companion make it out onto the main road.");
            System.out.println("Suddenly, a goblin jumps out at you with a small knife and prepares for a fight.\n");

            // Decision 3: Fight or spare
            System.out.println("What do you do?");
            System.out.println("Fight and kill/injure him");
            System.out.println("Try to talk things out\n");
            String userInput3;
            boolean isValidInput3 = false;
            do {
                System.out.print("Choice (fight or talk): ");
                userInput3 = sc.nextLine();
                if (userInput3.equalsIgnoreCase("inventory"))
                {
                    System.out.println("\n---INVENTORY---");
                    System.out.println(String.join(", ", inventory) + "\n");
                }
                else if (userInput3.equalsIgnoreCase("stats"))
                {
                    System.out.println("\n---STATS---");
                    System.out.println("Health: " + health);
                    System.out.println("Respect: " + respect);
                    System.out.println("Coins: " + coins + "\n");
                }
                else if (userInput3.equalsIgnoreCase("fight"))
                {
                    respect -= 3;
                    isValidInput3 = true;
                    if (inventory.contains("Sword"))
                    {
                        System.out.println("\nYou draw your sword, ready to strike the goblin.");
                        System.out.println("You manage to cut his arm, and he runs away in pain.");
                    }
                    else if (inventory.contains("Bow"))
                    {
                        System.out.println("\nYou quickly take out your bow and arrows from Lucien, and take aim.");
                        System.out.println("You hit the goblin's leg, and he cries out in pain and limps away.");
                    }
                    else if (inventory.contains("Axe"))
                    {
                        System.out.println("\nYou take your axe from Thormir off your back, and get into a fighting stance.");
                        System.out.println("The goblin is terrified and runs off before you can attack.");
                    }
                }
                else if (userInput3.equalsIgnoreCase("talk"))
                {
                    respect += 3;
                    System.out.println("\nYou put down your weapon and hold up your hands, telling him you don't want any trouble.");
                    System.out.println("The goblin deflates and drops his knife.");
                    System.out.println("\"Oh, darn it all. I'm sorry. I don't really want to fight, I just need some food to feed my family.\"");
                    if (inventory.contains("Can of Beans"))
                    {
                        // if you have beans
                        System.out.println("You tell him you have some, and roll the can over to him.");
                        System.out.println("The goblin smiles. \"Really? You'd give me this? Thank you so much, human.\"");
                        System.out.println("He gives you a sack of 50 coins.");
                        System.out.println("\"Only wandering traders take these, but they don't like goblins. You'll have more luck with them than me.\"");
                        System.out.println("You thank the goblin, and he goes on his way.");
                        coins += 50;
                        inventory.remove("Can of Beans");
                    }

                    // if you have coat
                    else if (inventory.contains("Coat"))
                    {
                        System.out.println("You tell the goblin you don't have any food, but offer him your coat instead.");
                        System.out.println("He gives you a sack of 20 coins.");
                        System.out.println("Only wandering traders take these, but they don't like goblins. You'll have more luck with them than me.");
                        System.out.println("You thank the goblin, and he goes on his way.");
                        coins += 20;
                        inventory.remove("Coat");
                    }

                    //if you have neither
                    else
                    {
                        System.out.println("You tell the goblin that you don't have any food, but he can go to your village, and the villagers will gladly provide him with it.");
                        System.out.println("He gives you a sack of 10 coins.");
                        System.out.println("Only wandering traders take these, but they don't like goblins. You'll have more luck with them than me.");
                        System.out.println("You thank the goblin, and he goes on his way.");
                        coins += 10;
                    }
                    isValidInput3 = true;
                }
                else
                {
                    System.out.println("\nWhoops! You can only fight or talk. Try again.");
                }
            } while(!isValidInput3);

            // Scene 5: The wandering trader
            System.out.println("\nA bit farther down the path, you see a wandering trader.");
            if (respect >= 3)
            {
                // Decision 4: Buy something
                System.out.println("She approaches you.");
                System.out.println("\"Hello, human. Would you like to choose from my stock today?\"");
                String userInput4;
                boolean isValidInput4 = false;
                do {
                    System.out.print("\nChoice (yes or no): ");
                    userInput4 = sc.nextLine();
                    if (userInput4.equalsIgnoreCase("inventory"))
                    {
                        System.out.println("\n---INVENTORY---");
                        System.out.println(String.join(", ", inventory) + "\n");
                    }
                    else if (userInput4.equalsIgnoreCase("stats"))
                    {
                        System.out.println("\n---STATS---");
                        System.out.println("Health: " + health);
                        System.out.println("Respect: " + respect);
                        System.out.println("Coins: " + coins + "\n");
                    }
                    // if you say yes
                    else if (userInput4.equalsIgnoreCase("yes"))
                    {
                        System.out.println("\n\"Very well then. Please choose an item.\"");
                        System.out.println("\nA loaf of bread (10 coins, heals 5 health)");
                        System.out.println("A potion (20 coins, adds a point of respect)");
                        System.out.println("A mysterious orb (50 coins, origin is unknown...)");
                        String userInput5;
                        isValidInput4 = true;

                        boolean isValidItem = false;
                        do {
                            System.out.print("\nChoice (bread, potion, or mysterious orb): ");
                            userInput5 = sc.nextLine();
                            if (userInput5.equalsIgnoreCase("bread") && coins >= 10)
                            {
                                System.out.println("\nYou choose the loaf of bread and your health is restored.");
                                health += 5;
                                coins -= 10;
                                isValidItem = true;
                            }
                            else if (userInput5.equalsIgnoreCase("potion") && coins >= 20)
                            {
                                System.out.println("\nYou choose the potion, and you gain a point of respect.");
                                respect += 1;
                                coins -= 20;
                                isValidItem = true;
                            }
                            else if (userInput5.equalsIgnoreCase("mysterious orb") && coins >= 50)
                            {
                                System.out.println("\nYou choose the strange orb, tucking it in your inventory for later use.");
                                inventory.add("Mysterious Orb");
                                coins -= 50;
                                isValidItem = true;
                            }
                            else
                            {
                                System.out.println("\nNot enough money/not an option.");
                            }
                        } while(!isValidItem);
                        System.out.println("The trader thanks you for your patronage and leaves.\n");
                    }

                    // if you say no (for loop minigame)
                    else if (userInput4.equalsIgnoreCase("no"))
                    {
                        int lowerBound = 1;
                        int upperBound = 10;
                        int maxAttempts = 3;
                        boolean correct = false;
                        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                        System.out.println("\n\"Very well, then. I have a guessing game for you.\"");
                        System.out.println("You accept.");
                        System.out.println("\"If you can guess what number I am thinking of between 1 and 10 in 3 attempts, I will give you 5 coins.\"");
                        for (int attempt = 1; attempt <= maxAttempts; attempt++)
                        {
                            System.out.print("\nAttempt " + attempt + ": Guess: ");
                            int guess = sc.nextInt();
                            sc.nextLine();
                            if (guess == targetNumber)
                            {
                                System.out.println("The trader looks impressed.");
                                System.out.println("\"Congratulations, human. Here is the 5 coins, as promised.\"");
                                coins += 5;
                                correct = true;
                                break;
                            }
                            else if (guess < targetNumber)
                            {
                                System.out.println("\"Too low, human. Try again.\"");
                            }
                            else
                            {
                                System.out.println("\"Too high, human. Try again.\"");
                            }
                        }
                        if (!correct)
                        {
                            System.out.println("\n\"Sorry, human. You're out of attempts. Goodbye.\"");
                            System.out.println("\"I was thinking of " + targetNumber + ".\"");
                        }
                        System.out.println("The trader leaves.");
                        isValidInput4 = true;
                    }
                    else
                    {
                        System.out.println("Sorry, it's a yes or no question.");
                    }
                } while (!isValidInput4);
            }

            // if you fought the goblin from Scene 4
            else
            {
                System.out.println("She starts to approach you, but seems to realize something and her face contorts in disgust.");
                System.out.println("She walks away from you.\n");
            }


            // Scene 6: The injury
            if (companion.equals("Thormir"))
            {
                System.out.println("\nAfter a few hours of walking, Thormir suddenly trips on a rock and cries out.");
                System.out.println("You spin around to see that he has badly twisted his ankle.");
                System.out.println("\"Gah! Human, please help! I don't think I can walk on this injury.\"");
            }
            else if (companion.equals("Lucien"))
            {
                System.out.println("\nAfter a few hours of walking, you hear a rustling sound.");
                System.out.println("He winces in pain, and says sarcastically but weakly, \"Oh, just great.\"");
                System.out.println("You turn around, and realize that he has been pricked by a poisonous thornbush.");
                System.out.println("He collapses, unable to move or speak.");
            }

            // Decision 5: Companion-help or leave behind (MAJOR)
            System.out.println("You have two options.");
            System.out.println("\nHelp him");
            System.out.println("Leave him behind\n");
            String userInput6;
            boolean isValidInput5 = false;
            do {
                System.out.print("Choice (help or leave): ");
                userInput6 = sc.nextLine();
                if (userInput6.equalsIgnoreCase("inventory"))
                {
                    System.out.println("\n---INVENTORY---");
                    System.out.println(String.join(", ", inventory) + "\n");
                }
                else if (userInput6.equalsIgnoreCase("stats"))
                {
                    System.out.println("\n---STATS---");
                    System.out.println("Health: " + health);
                    System.out.println("Respect: " + respect);
                    System.out.println("Coins: " + coins + "\n");
                }
                else if (userInput6.equalsIgnoreCase("Help"))
                {
                    respect += 3;
                    health -= 5;
                    if (companion.equals("Thormir"))
                    {
                        System.out.println("\nYou can't just leave him behind, that would be wrong.");
                        System.out.println("While holding onto Thormir's arm, you slowly help him walk.");
                        System.out.println("Eventually, you find a small cottage, and the owner is a healer who helps with his wound.");
                        System.out.println("You lose a couple hours, but are able to get back on the road safely.");
                        System.out.println("Thormir tells you he is forever in your debt.");
                    }
                    else if (companion.equals("Lucien"))
                    {
                        System.out.println("\nYou hurry over to Lucien, and find the strength to carry him some of the way.");
                        System.out.println("He is heavy, but you manage to get him to a small cottage where a healer lives.");
                        System.out.println("She gives him an antidote for the poison, and it takes about an hour to work.");
                        System.out.println("Once he can talk again, Lucien quickly thanks you, and you both continue your journey.");
                    }
                    isValidInput5 = true;
                }
                else if (userInput6.equalsIgnoreCase("Leave"))
                {
                    respect -= 3;
                    if (companion.equals("Thormir"))
                    {
                        System.out.println("\nYou decide that the dwarf would just be dead weight, and that he will be fine on his own.");
                        System.out.println("You start to walk away, but Thormir keeps yelling.");
                        System.out.println("\"Wait! Where are you going? I thought we were friends! Please don't leave me here!\"");
                        System.out.println("You ignore him, because you can finish this journey on your own.");
                        System.out.println("And so Thormir helplessly watches you leave, feeling completely and utterly betrayed.");
                    }
                    else if (companion.equals("Lucien"))
                    {
                        System.out.println("\nYou decide that the elf would just be dead weight, and that the poison will wear off eventually.");
                        System.out.println("As you walk away, Lucien is still helpless, but can see everything.");
                        System.out.println("He watches you leave him behind, after all he's done for you.");
                        System.out.println("The only emotion in his mind is anger. At you for leaving him behind, and at himself for thinking a human was his friend.");
                    }
                    hasCompanion = false;
                    companion = "";
                    isValidInput5 = true;
                }
                else
                {
                    System.out.println("That isn't one of the options.");
                }

            }while(!isValidInput5);

            // Scene 7: The Wizard's domain
            if (hasCompanion)
            {
                if (companion.equals("Thormir"))
                {
                    System.out.println("\nYou and Thormir arrive at the wizard's domain.");
                    System.out.println("There is a blood moon, making the sky look red.");
                    System.out.println("The entire domain is covered in dry land and dark colors.");
                    System.out.println("Thormir makes a disgusted face.");
                    System.out.println("\"This place sucks. I've been here to fight before. I don't want you to have to be in this evil land much longer. Come on human, I know a shortcut.\"");
                    System.out.println("Thormir leads you to a tunnel that leads directly to the castle.");
                }
                else if (companion.equals("Lucien"))
                {
                    System.out.println("\nYou and Lucien arrive at the wizard's domain.");
                    System.out.println("There is a blood moon, making the sky look red.");
                    System.out.println("Lucien looks at the huge castle in the distance.");
                    System.out.println("He scoffs. \"Wow. These imbeciles really expanded the castle since I was last here to attack. So arrogant.\"");
                    System.out.println("\"Come on human. It's much faster this way.\"");
                    System.out.println("Lucien leads you to a hidden portal that leads directly to the castle.");
                }
            }
            // if you left your companion behind
            else if (!hasCompanion)
            {
                System.out.println("\nYou arrive at the wizard's domain.");
                System.out.println("There is a blood moon, making the sky look red.");
                System.out.println("You have never been here before, and since you no longer have a companion, you get lost.");
                System.out.println("\nAfter wandering for about an hour, you find a winding river, with a cloaked figure standing in it.");
                System.out.println("You approach the figure. It seems to be an old, frail man.");
                System.out.println("He looks up at you.");
                System.out.println("\"Hello, mortal. I assume you want to get to the castle. I know the way. I will take you, but you must first pay.\"");
                System.out.println("\"I require a cloak. Mine is getting very worn.\"");
                if (inventory.contains("Cloak"))
                {
                    System.out.println("You give the boatman your cloak. He accepts it and allows you onto his boat.");
                }
                else
                {
                    System.out.println("The boatman frowns, and takes 20 points of your health instead.");
                    health -= 20;
                }
                System.out.println("After a long boat ride, you make it to a castle entrance.");
            }
            // Scene 8: The Dungeon
            System.out.println("\nThe long winding corridors in the castle eventually lead to a damp, dark dungeon.");
            System.out.println("There is a scrawny, sick looking knight in one of the cells, begging you to let him out.");

            // Decision 6: The Cell
            System.out.println("You have two choices.");
            System.out.println("\nFree him");
            System.out.println("Leave him there");
            String userInput7;
            boolean isValidInput6 = false;
            do {
                System.out.print("\nChoice(free or leave): ");
                userInput7 = sc.nextLine();
                if (userInput7.equalsIgnoreCase("free"))
                {
                    System.out.println("\nYou decide to set him free.");
                    System.out.println("After the door opens, the knight falls to his knees and cries tears of happiness.");
                    System.out.println("\"Thank you so much, traveler. I am forever in your debt.\"");
                    System.out.println("He reaches into his cell.");
                    System.out.println("\"I can never repay you enough, but please accept this.\"");
                    System.out.println("The knight hands you an iron chestplate.");
                    System.out.println("You thank him, and tell him he should leave quickly.");
                    System.out.println("He again thanks you, and runs out of the dungeon without a second thought.");
                    respect += 2;
                    inventory.add("Chestplate");
                    isValidInput6 = true;
                }
                else if (userInput7.equalsIgnoreCase("leave"))
                {
                    System.out.println("\nYou decide to just keep walking. He's probably locked up for good reason anyway.");
                    if (hasCompanion)
                    {
                        System.out.println("Your companion glares at you with distaste, and lets the prisoner out while you aren't looking.");
                        System.out.println("You both continue down the corridor.");
                    }
                    else
                    {
                        System.out.println("As you advance down the corridor, the knight still begs and begs, but is helpless once more.");
                    }
                    respect -= 2;
                    isValidInput6 = true;
                }
            }while (!isValidInput6);

            // Scene 9 (Final): The Throne Room
            System.out.println("At last, you arrive at the throne room, where the king of the wizards waits.");
            System.out.println("As you walk in, you see Rocky sitting in an enchanted crate next to the throne.");
            System.out.println("The wizard king smirks.");
            System.out.println("\"Ah, there you are, human. I see you have finally made it to my domain.\"");
            System.out.println("You demand that Rocky be let go.");
            boolean gameEnded = false;
            if (hasCompanion)
            {
                if (respect > 3)
                {
                    // GOOD ENDING
                    if (companion.equals("Lucien"))
                    {
                        System.out.println("\nLucien takes out his bow.");
                        System.out.println("\"Enough of this. I hate talking.\"");
                        System.out.println("You take out your weapon.");
                        System.out.println("The wizard king orders his henchmen to attack.");
                        System.out.println("You and Lucien fight off the wizards.");
                        System.out.println("By the end of the fight, most of them are injured or have run away.");
                        System.out.println("The wizard king is terrified, and gives you Rocky back to avoid more fighting.");
                        System.out.println("\"J-Just take the stupid thing. I-It's not worth it anyway.\"");
                    }
                    else if (companion.equals("Thormir"))
                    {
                        System.out.println("\nThormir takes out his axe.");
                        System.out.println("\"Well I could sit here and talk all day, but I think you have something that belongs to the human, you scum.\"");
                        System.out.println("You take out your weapon.");
                        System.out.println("The wizard king orders his henchmen to attack.");
                        System.out.println("You and Thormir fight off the wizards.");
                        System.out.println("By the end of the fight, most of them are injured or have run away.");
                        System.out.println("The wizard king is terrified, and gives you Rocky back to avoid more fighting.");
                        System.out.println("\"J-Just take the stupid thing. I-It's not worth it anyway.\"");
                    }
                    System.out.println("\nYou finally have Rocky back! He is seemingly unharmed, but starts meowing loudly.");
                    System.out.println("It seems that he is hungry, like always.");
                    System.out.println("You reassure him that he has lots of food waiting for him at home, and start the long journey back to the village.");
                    System.out.println("GAME OVER (Good ending)");
                    gameEnded = true;
                }
                else if (respect < 3)
                {
                    //BAD ENDING
                    if (companion.equals("Lucien"))
                    {
                        System.out.println("\nYou take out your weapon.");
                        System.out.println("Instead of ordering his henchmen to attack, the wizard king just smirks.");
                        System.out.println("Suddenly, you hear sound of a bow being drawn. You look to Lucien, and he is pointing it right at you.");
                        System.out.println("\"Sorry, human. I can't help someone so malicious. I'd rather take my chances with these fools.\"");
                        System.out.println("The wizard king chuckles evilly.");
                        System.out.println("\"Well, well, well. It seems you were right, Lucien. This human deserves to be locked in the dungeons forever.\"");
                        System.out.println("Two wizard henchmen restrain you, and start dragging you to the dungeons. You look back at Lucien.");
                        System.out.println("You find that he is looking at you with anger, but also a hint of guilt.");
                        System.out.println("However, he does nothing to stop the wizards as they drag you down to the dungeon that will be your home for the rest of your life.");
                        System.out.println("GAME OVER. (Bad ending)");
                        gameEnded = true;
                    }
                    else if (companion.equals("Thormir"))
                    {
                        System.out.println("\nYou take out your weapon.");
                        System.out.println("Instead of ordering his henchmen to attack, the wizard king just smirks.");
                        System.out.println("Suddenly, you feel the blade of an axe inches from your face. You glance to your right, and Thormir is standing there, tears lining his eyes.");
                        System.out.println("\"I'm sorry, human. Helping you just doesn't feel right. You've done so many bad things.\"");
                        System.out.println("The wizard king chuckles evilly.");
                        System.out.println("\"Well, well, well. It seems you were right, Thormir. This human deserves to be locked in the dungeons forever.\"");
                        System.out.println("Two wizard henchmen restrain you, and start dragging you to the dungeons. You look back at Thormir.");
                        System.out.println("You find that he is staring at you with sadness and regret.");
                        System.out.println("However, he does nothing to stop the wizards as they drag you down to the dungeon that will be your home for the rest of your life.");
                        System.out.println("GAME OVER. (Bad ending)");
                        gameEnded = true;
                    }
                }
            }
            else if (!hasCompanion)
            {
                if (respect > -3)
                {
                    //GOOD ENDING
                    System.out.println("\nWhen the wizard doesn't listen, you take out your weapon.");
                    System.out.println("You challenge the wizard to a duel, and he smiles and accepts.");
                    System.out.println("After a long battle, you vanquish the wizard king. His henchmen tremble in fear and allow you to take back Rocky.");
                    System.out.println("You finally have him back! He is seemingly unharmed, but starts meowing loudly.");
                    System.out.println("It seems that he is hungry, like always.");
                    System.out.println("You reassure him that he has lots of food waiting for him at home, and start the long journey back to the village.");
                    System.out.println("GAME OVER (Good ending)");
                    gameEnded = true;
                }
                else if (respect < -3)
                {
                    //BAD ENDING
                    System.out.println("\nWhen the wizard doesn't listen, you take out your weapon.");
                    System.out.println("Before you can challenge him, the wizard king smiles and speaks up.");
                    System.out.println("\"That won't be necessary, human. It seems your animal companion is detested by you.\"");
                    System.out.println("You are confused, but look to the crate next to the throne and see Rocky, turned away from you.");
                    System.out.println("You call to him, but he remains faced away.");
                    System.out.println("Because of your malicious choices, Rocky doesn't even want to look at you.");
                    System.out.println("You feel heartbroken, and drop your weapon with regret.");
                    System.out.println("Two wizard henchmen restrain you, and start dragging you to the dungeons. ");
                    System.out.println("You don't fight them, because you know that your quest has turned out to be pointless.");
                    System.out.println("GAME OVER. (Bad ending)");
                    gameEnded = true;
                }
            }
            if (inventory.contains("Mysterious Orb") && !gameEnded)
            {
                //SECRET ENDING
                System.out.println("\"You foolish human. Of course you can't have it ba-\"");
                System.out.println("The wizard king freezes mid sentence.");
                System.out.println("He suddenly falls to his knees.");
                System.out.println("\"You-you have the orb of destiny! You..are the chosen one!\"");
                System.out.println("All the wizards gasp and fall to their knees.");
                System.out.println("\"All hail the chosen one!\" They chant.");
                System.out.println("The king surrenders his throne, and invites you to sit.");
                if (companion.equals("Lucien"))
                {
                    System.out.println("Lucien suddenly grabs you, and searches through your pack. He takes out the mysterious orb you bought from the wandering merchant.");
                    System.out.println("\"Is this your precious orb, you fools?\"");
                    System.out.println("They all agree, and remain on their knees.");
                    System.out.println("\"Well, that explains it. Congrats, human. I guess you're their new ruler.\"");
                }
                else if (companion.equals("Thormir"))
                {
                    System.out.println("Thormir looks confused.");
                    System.out.println("\"What do you mean, orb of destiny? We don't have anything like that. Wait...\"");
                    System.out.println("He turns to you.");
                    System.out.println("\"Human! Didn't you buy that weird orb from that wandering trader?\"");
                    System.out.println("You nod, and Thormir guffawed.");
                    System.out.println("\"So that's what this is, eh? Well, so be it! You wizards answer to the human now!\"");
                }
                else
                {
                    System.out.println("You realize that the orb you purchased earlier was the one they speak of, and gladly take a seat at the throne.");
                }
                System.out.println("\nYou order the wizard king to release Rocky.");
                System.out.println("You then take your seat as the new ruler of the wizard's domain.");
                System.out.println("GAME OVER. (Secret ending)");
                gameEnded = true;
            }
            System.out.println("\nDo you want to play again?");
            System.out.print("Choice (yes or no): ");
            playAgain = sc.nextLine();
        }
        System.out.println("Thank you for playing my game!");
        sc.close();
    }
}
