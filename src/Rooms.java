public class Rooms {

    private final int r = 0;
    private final int c = 2;
    private int[] currentRoom = {r, c};
    private int[] lastRoom = {r, c};
    AdventureDice game;
    private String[][] roomArray = {
            {"", "", "Entrance- Are you ready?", "", "", "", ""},
            {"", "", "Ladder- Darkness Lies Ahead", "", "", "", ""},
            {"CHEST,SWORD:A fiery sword is embedded in a \nblock of granite", "MONSTER:An amethyst rabbit guards \nthe end of the passage", "\"Ouch!\" your head hits a\n low hanging stalagtite", "CHEST,RED: A blazing fire fills \nthe room with smoke", "LOCKED:There's a locked green \ndoor to your east", "MONSTER:Red Monster", ""},
            {"", "", "", "Purple door", "", "", ""},
            {"", "", "", "Ladder going down", "", "", ""},
            {"", "MONSTER:Room with a smoky grey monster", "Tunnel", "Tall Room- the ceiling is\n hidden in darkness", "LOCKED:A surprisingly normal bookshelf is ", "CHEST,RAINBOW: Secret Rainbow Room- for some reason, violet\n is missing from the \nrainbow", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"MONSTER:Room with a \ntulip orange monster", "Tunnel", "Tunnel", "Narrow Room- \nyou can barely \nfit through", "Tunnel", "Tunnel", "MONSTER:Room with a pine \ngreen monster"},
            {"", "", "", "LOCKED:Locked Banana Yellow Door", "", "", ""},
            {"", "CHEST,WELL:Room with a well- \n \"You fool of a Took!\" ", "Tunnel", "Long Room- \n the room stretches out \n to infinity...", "Tunnel", "CHEST,ROLLS:Large Chest filled with \ninfinite-sided dice", ""},
            {"", "", "", "Tunnel", "", "", ""},
            {"CHEST,SHIELD:Small Chest \n made from coconut husks", "Damp Room- \nyour boots are \nsoaking wet", "LOCKED:Locked Purple Door", "Smelly Room- \n it smells like\n uneaten breakfast", "LOCKED:Locked Sunset-Orange Door", "SPIKE:Spike Pit", ""},
            {"", "Tunnel", "", "Tunnel", "", "", ""},
            {"BUCKET:\"There is a bucket\" \n *in the distance* \n Dear God...", "Puzzle Room- \n A sign reads\n \"Those who enter must extinguish \n their fears with water from the \n depths of the earth\" ", "", "MONSTER:A very Grey Monster", "", "", ""},
            {"", "KEY,RED:Locked Red Door", "", "", "", "", ""},
            {"MONSTER:Dark-Gray Monster", "Echo Room", "Tunnel", "MONSTER:Sea-Green Monster", "Tunnel", "MONSTER:Magenta Monster", "Winter-Wizard-Blue Room"},
            {"", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "MONSTER:Turquoise Monster", "Tunnel", "Tunnel", "MONSTER:Pink Monster", "", "MONSTER:Dark Green Monster"},
            {"CHEST,HEALTH:Dark Red Chest", "Tunnel", "", "Tunnel", "", "", "Tunnel"},
            {"", "Tunnel", "", "Tunnel", "", "", "KEY,GOLD:Locked Gold Door"},
            {"CHEST,GOLD:Gold Chest", "KEY,RAINBOW:Locked Rainbow Door", "Tunnel", "MONSTER:Burnt Orange Monster- \n Is it a *Burnt*\n Orange Monster, Or a \n *Burnt Orange* Monster?", "SPIKE:Spike Pit", "", "MONSTER,BOSS:A Giant Cavern Lurks\n In A Vast Golden Dragon \n \"Do you think flattery \n will keep you alive?\""},
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

    boolean almostDead = false;
    
    public void callTags() {
        String[] tags = readTags();
        int roll = game.table.updateRoll();
        
        //int roll = currentRoll;
        for (String tag : tags) {
            
            switch (tag) {
                // Parent Classes
                case "MONSTER":
                // Locks Room Till Defeat
                game.choice.disableButtons();
                game.controls.enableButtons();
                if (roll == 1 || roll == 2) {
                    game.display.addHealth(-5);
                }
                else if (roll == 3) {
                    game.display.addHealth(-10);
                }
                else if (roll == 6 || roll == 5 || roll == 4){
                    if (almostDead == true)
                    {
                        game.journey.changeText("The monster is dead");
                        game.controls.disableButtons();
                        game.choice.enableButtons();
                    }
                    else {
                        game.journey.changeText("The monster is almost dead");
                        almostDead = true;
                    }
                }
                break;
                case "CHEST":
                break;
                case "LOCKED":
                // Roll to unlock
                break;
                case "KEY":
                // Requires Key
                break;

                // Colors
                case "RED":
                break;
                case "RAINBOW":
                break;
                case "GOLD":
                break;

                // Items
                case "SWORD":
                break;
                case "WELL":
                break;
                case "ROLLS":
                break;
                case "SHIELD":
                break;
                case "SPIKE":
                break;
                case "BUCKET":
                break;
                case "HEALTH":
                break;
                case "BOSS":
                break;
            }
        }
    }

    public void updateRoom(int directionX, int directionY) {
        if (currentRoom[1] + directionX >= 0 && currentRoom[0] + directionY >= 0 && !roomArray[currentRoom[0] + directionY][currentRoom[1] + directionX].equals("")) {
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
        } else {
            game.journey.appendText("You shall not pass!");
            //             for (String item : readTag()) {
            //                 game.journey.appendText(item);
            //}
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
