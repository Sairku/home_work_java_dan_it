public class RoboCat extends Pet implements Foul {
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBO_CAT);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я - " + getNickname() + ". Я робот-кіт!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
