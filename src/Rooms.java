public class Rooms {

    boolean sword = false;
    private final int r = 0;
    private final int c = 2;
    private int[] currentRoom = {r, c};
    private int[] lastRoom = {r, c};
    boolean almostDead = false;
    boolean almostAlmostDead = true;
    boolean rainbowKey = false;
    boolean redKey = false;
    boolean goldKey = false;
    AdventureDice game;
    private String[][] roomArray = {
            {"", "", "Entrance", "", "", "", ""},
            {"", "", "Ladder", "", "", "", ""},
            {"CHEST,SWORD:Sword In Stone", "MONSTER:Room of the Rabbit", "Rough-Cut Staircase", "RED:Smoke-Filled Room", "LOCKED:Green Door", "MONSTER:Red Monster", ""},
            {"", "", "", "Purple door", "", "", ""},
            {"", "", "", "Ladder going down", "", "", ""},
            {"", "MONSTER:Smoky Grey Monster", "Tunnel", "Tall Room", "LOCKED:Library", "CHEST,RAINBOW:Secret Rainbow Room", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"MONSTER:Tulip Orange Monster", "Tunnel", "Tunnel", "Narrow Room", "Tunnel", "Tunnel", "MONSTER:Pine Green Monster"},
            {"", "", "", "LOCKED:Banana Yellow Door", "", "", ""},
            {"", "CHEST,WELL:Room With a Well", "Tunnel", "Long Room", "Tunnel", "CHEST,ROLLS:Chest Room", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"CHEST,SHIELD:Chest Room", "Damp Room", "LOCKED:Purple Door", "Smelly Room", "LOCKED:Sunset-Orange Door", "SPIKE:Spike Pit", ""},
            {"", "Tunnel", "", "Tunnel", "", "", ""},
            {"BUCKET:Room with Bucket", "Puzzle Room", "", "MONSTER:Grey Monster", "", "", ""},
            {"", "KEY:Red Door", "", "", "", "", ""},
            {"MONSTER:Dark-Gray Monster", "Echo Room", "Tunnel", "MONSTER:Sea-Green Monster", "Tunnel", "MONSTER:Magenta Monster", "Winter-Wizard-Blue Room"},
            {"", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "MONSTER:Turquoise Monster", "Tunnel", "Tunnel", "MONSTER:Pink Monster", "", "MONSTER:Dark Green Monster"},
            {"HEALTH:Chest Room", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "Tunnel", "", "Tunnel", "", "", "GOLD:Locked Gold Door"},
            {"GOLD:Chest Room", "RAINBOW:Rainbow Door", "Tunnel", "MONSTER:Burnt Orange Monster", "SPIKE:Spike Pit", "", "MONSTER,BOSS:The Final Showdown"},
        };
    private String[][] descriptionsArray = {
            {"", "", "Are you ready?", "", "", "", ""},
            {"", "", "Darkness lies ahead", "", "", "", ""},
            {"A fiery sword is embedded in a \nblock of granite \n You pull it out!", "An amethyst rabbit from Caerbannog guards \nthe end of the passage", "\"Ouch!\" your head hits a\n low hanging stalactite", "A blazing fire fills \nthe room with smoke", "There's a locked green \ndoor to your east", "Red Monster", ""},
            {"", "", "", "Purple door", "", "", ""},
            {"", "", "", "Ladder going down", "", "", ""},
            {"", "Room with a smoky grey monster", "Tunnel", "the ceiling is\n hidden in darkness", "A surprisingly normal bookshelf is ", "for some reason, violet\n is missing from the \nrainbow", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"Room with a \ntulip orange monster", "Tunnel", "Tunnel", "you can barely \nfit through", "Tunnel", "Tunnel", "Room with a pine \ngreen monster"},
            {"", "", "", "Locked Banana Yellow Door", "", "", ""},
            {"", "\"You fool of a Took!\" ", "Tunnel", "the room stretches out \n to infinity...", "Tunnel", "Large Chest filled with \ninfinite-sided dice", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"Small Chest \n made from coconut husks", "your boots are \nsoaking wet", "Locked Purple Door", "it smells like\n uneaten breakfast", "Locked Sunset-Orange Door", "Spike Pit \n -Ow!", ""},
            {"", "Tunnel", "", "Tunnel", "", "", ""},
            {"\"This is a bucket\" \n *in the distance* \n \"Dear God...\"", "A sign reads\n \"Those who enter must extinguish \n their fears with water from the \n depths of the earth\" ", "", "A very Grey Monster", "", "", ""},
            {"", "Locked Red Door", "", "", "", "", ""},
            {"Dark-Gray Monster", "Echo Room", "Tunnel", "Sea-Green Monster", "Tunnel", "Magenta Monster", "Winter-Wizard-Blue Room"},
            {"", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "Turquoise Monster", "Tunnel", "Tunnel", "Pink Monster", "", "Dark Green Monster"},
            {"Dark Red Chest", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "Tunnel", "", "Tunnel", "", "", "Locked Gold Door"},
            {"Gold Chest", "Locked Rainbow Door", "Tunnel", "Is it a *Burnt*\n Orange Monster, Or a \n *Burnt Orange* Monster?", "Spike Pit", "", "A Giant Cavern Lurks\n In A Vast Golden Dragon \n \"Do you think flattery \n will keep you alive?\""},
        };

    public Rooms(AdventureDice g) {
        game = g;
    }

    public String[] readTags() {
        int end = roomArray[currentRoom[0]][currentRoom[1]].indexOf(':');

        if (end != -1) {
            String[] tag = roomArray[currentRoom[0]][currentRoom[1]].substring(0, end).split(",");

            return tag;
        }
        String[] NORMAL = {"NORM"};
        return NORMAL;
    }

    public void callTags() {
        String[] tags = readTags();
        int roll = game.table.updateRoll();

        //int roll = currentRoll;
        for (String tag : tags) {
            switch (tag) {
                // Parent Classes
                case "MONSTER":
                // Locks Room Till Defeat
                game.controls.setAction("Fight");
                game.choice.disableButtons();
                game.controls.enableButtons();
                if (roll == 1 || roll == 2) {
                    if (sword == true)
                    {
                        game.journey.appendText("The monster is almost dead");
                        almostDead = true;
                    } else {

                        game.display.addHealth(-3);
                    }
                } else if (roll == 3) {

                    game.display.addHealth(-5);
                } else if (roll == 6 || roll == 5 || roll == 4) {
                    if (almostDead) {
                        game.journey.appendText("The monster is dead");
                        game.controls.disableButtons();
                        game.choice.enableButtons();
                        changeTag("MONSTER", "DEAD");
                    } else {
                        game.journey.appendText("The monster is almost dead");
                        almostDead = true;
                    }
                }
                break;

                case "CHEST":
                break;

                case "LOCKED":
                game.controls.setAction("Pick Lock");
                game.choice.disableButtons();
                game.controls.enableButtons();

                if (roll == 6 || roll == 5 || roll == 4) {
                    game.journey.appendText("Alohomora! \n The Door is Unlocked");
                    game.controls.disableButtons();
                    game.choice.enableButtons();

                }
                // Roll to unlock
                break;

                case "KEY":
                game.choice.disableButtons();
                game.controls.enableButtons();
                game.controls.setAction("You Need the RED key");
                if ((currentRoom[r] == 15 && currentRoom[c] == 2 && redKey)) {
                    game.journey.appendText("The RED room is unlocked!");
                    game.controls.disableButtons();
                    game.choice.enableButtons();
                }
                break;

                case "DEAD":
                descriptionsArray[currentRoom[0]][currentRoom[1]] = "A monster lies dead at your feet";
                break;

                // Colors
                case "RED":
                redKey = true;
                game.journey.appendText("You got the RAINBOW key!");
                break;

                case "RAINBOW":
                rainbowKey = true;
                game.journey.appendText("You got the RAINBOW key!");
                break;

                case "GOLD":
                goldKey = true;
                game.journey.appendText("You got the GOLD key!");
                break;

                // Items
                case "SWORD":
                sword = true;

                break;

                case "WELL":
                break;
                case "ROLLS":
                break;
                case "SHIELD":
                break;
                case "SPIKE":
                game.display.addHealth(-10);
                
                break;
                case "BUCKET":
                break;
                case "HEALTH":
                game.display.addHealth(15);
                
                break;
                case "BOSS":
                game.controls.setAction("Challenge Dragon");
                game.choice.disableButtons();
                game.controls.enableButtons();
                if (roll == 1 || roll == 2) {
                    game.display.addHealth(-10);
                } else if (roll == 3) {
                    game.display.addHealth(-15);
                } else if (roll == 6 || roll == 5) {
                    if (almostAlmostDead && almostDead) {
                        game.journey.appendText("The dragon is slain... \n Congratulations, Hero!");
                        game.controls.disableButtons();
                        game.choice.enableButtons();
                        changeTag("BOSS", "DEAD");
                    } else {
                        if (almostDead) {
                            game.journey.appendText("The dragon ROARS!");
                            almostAlmostDead = true;
                        }
                        game.choice.disableButtons();
                        game.controls.enableButtons();
                        game.journey.appendText("The dragon breathes fire!");
                        almostDead = true;
                    }
                }
                break;
            }
        }
    }

    public void changeTag(String oldTag, String newTag) {
        roomArray[currentRoom[0]][currentRoom[1]] = roomArray[currentRoom[0]][currentRoom[1]].replace(oldTag, newTag);
    }

    public void updateRoom(int directionX, int directionY) {
        if (currentRoom[1] + directionX >= 0 && currentRoom[0] + directionY >= 0 && currentRoom[0] + directionX < 20 && currentRoom[1] + directionY < 7 && !roomArray[currentRoom[0] + directionY][currentRoom[1] + directionX].equals("")) {
            almostDead = false;
            lastRoom[0] = currentRoom[0];
            lastRoom[1] = currentRoom[1];
            currentRoom[0] += directionY;
            currentRoom[1] += directionX;
            callTags();
            int end = roomArray[currentRoom[0]][currentRoom[1]].indexOf(':');
            if (end != -1) {
                game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]].substring(end + 1));
            } else {
                game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
            }
            game.journey.appendText(descriptionsArray[currentRoom[0]][currentRoom[1]]);
        } else {
            game.journey.appendText("You shall not pass!");
        }
    }

    public void gotoLastRoom() {
        currentRoom[0] = lastRoom[0];
        currentRoom[1] = lastRoom[1];
        callTags();
        int end = roomArray[currentRoom[0]][currentRoom[1]].indexOf(':');
        if (end != -1) {
            game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]].substring(end + 1));
        } else {
            game.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
        }
    }
}
