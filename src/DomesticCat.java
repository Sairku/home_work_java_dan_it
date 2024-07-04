public class DomesticCat extends Pet implements Foul {
    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOMESTIC_CAT);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я - " + getNickname() + ". Я мурчу!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
