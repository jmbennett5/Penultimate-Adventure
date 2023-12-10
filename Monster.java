        /**
         * Write a description of class Monster here.
         *
         * @author (your name)
         * @version (a version number or a date)
         */
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;
        
        public class Monster extends GM {
            public static List<String> noobMonsters = new ArrayList<>();
            public static List<String> regularMonsters = new ArrayList<>();
        
            static {
                noobMonsters.add("Rat");
                noobMonsters.add("Dog");
                noobMonsters.add("Cat");
                noobMonsters.add("Crow");
                noobMonsters.add("Bat");
        
                regularMonsters.add("Toxic Rat");
                regularMonsters.add("Humongous Dog");
                regularMonsters.add("Creepy Hobo");
                regularMonsters.add("Enraged Druggie");
                regularMonsters.add("Mutated Roach");
            }
        
            public int level;
            public String monsterType;
            public int hp;
            public int dmg;
        
            public Monster(int level) {
                this.level = level;
                this.stuff();
            }
        
            public void stuff() {
                if (level == 1) {
                    monsterType = noobMonsters.get(new Random().nextInt(noobMonsters.size()));
                    hp = new Random().nextInt(4) + 1;
                    dmg = new Random().nextInt(4) + 1;
                } else {
                    monsterType = regularMonsters.get(new Random().nextInt(regularMonsters.size()));
                    hp = new Random().nextInt(5) + 4;
                    dmg = new Random().nextInt(5) + 4;
                }
            }
            public String getMonsterType(){
            return monsterType;
            
            }
            public static Monster getSpecificMonster(int level, int index) {
                Monster monster = new Monster(level);
                if (level == 1 && index >= 0 && index < noobMonsters.size()) {
                    monster.monsterType = noobMonsters.get(index);
                } else if (level != 1 && index >= 0 && index < regularMonsters.size()) {
                    monster.monsterType = regularMonsters.get(index);
                }
                return monster;
            }
        
            
        public static String FightDruggie()
        {
            String prompt   = "You try to walk past the rambling incoherent man, and he grabs your arm and yells incomprehensible things into your face.\n"
                            + "You see two good options -- Try to WIGGLE out, or KICK him in the balls.\n";
            
            System.out.println(prompt);
           
            String cmd = cmdin.nextLine();
            
            if ("WIGGLE".equalsIgnoreCase(cmd))
            {
                System.out.println("The man resists you and pulls you closer. He holds you tight and whispers into your ear 'THE DRAGONS ARE IN ALL OF US'\n");
                System.out.println("You start to feel a great fire inside of you. A baby dragon wriggles out of your chest and you die.\n");
                return "DEATH";
            }
            else if ("KICK".equalsIgnoreCase(cmd))
            {
                System.out.println("The man doubles over in pain, and starts to glow brightly, you think it might be a good idea to get out of there as quickly as possible");
                return "RUN";
            }
            
            return cmd;
           
    }
          public static String FightMonk()
        {
            String prompt   = "You come up to the monk, and he begins telling you that he is there to challenge you, and if you want to ascend to immortality  you must challenge him. \n" 
                            +"The challenge is this, you must figure out how to defeat me with one attack, you can choose between a PUNCH or a KICK. "
                            + " You can either PUNCH him in the forehead, or KICK him in the backside.";
            
            System.out.println(prompt);
           
            String cmd = cmdin.nextLine();
            
            if ("PUNCH".equalsIgnoreCase(cmd))
            {
                System.out.println("You punch the monk in the forehead, and a flash of green light appears, the monk having disappeared,\n words slowly appearing in front of you. You have achieved immortality as you understand where the lines of power converge in your mind.");
                System.out.println("You are now immortal and can choose whatever you want to do, nothing can kill you and you will live forever. \n");
                return "WON";
            }
            else if ("KICK".equalsIgnoreCase(cmd))
            {
                System.out.println("You kick the man in his backside, and he flashes red, saying 'You have chosen wrongly, prepare to die, as you are not ready to ascend and you do not understand your own body' The man punches you and you die.");
                return "DEATH";
            }
            
            return cmd;
           
    }
    
    
    
    
    public static void main(String[] args) {
        Monster noobMonster = new Monster(1);
        System.out.println("Level: " + noobMonster.level + ", Type: " + noobMonster.monsterType +
                ", HP: " + noobMonster.hp + ", DMG: " + noobMonster.dmg);
    }
}

