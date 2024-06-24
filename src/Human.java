
public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public void greetPet(){
        System.out.println("Привіт, " + pet.getNickname() ); // dopusati
    }

    public void describePet(){
        String slyPet;
        if (pet.getTrickLevel()> 50){
            slyPet = "дуже хитрий";
        }else {
            slyPet = "майже не хитрий";
        }
        System.out.println("У мене є " + pet.getSpecies() + ", їй " + pet.getAge() + " років, він " + slyPet );
}
public Human(String name,String surname,int year ){
        this.name = name;
        this.surname = surname;
        this.year = year;
}
    public Human(String name,String surname,int year,Human mother,Human father  ){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }
    public Human(String name,String surname,int year,Human mother,Human father, Pet pet, int iq,String[][] schedule  ){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
        this.pet = pet;
        this.iq = iq;
        this.schedule = schedule;
    }
    public Human(){};

    // Getter and Setters

    public String getName(){
        return name;
    }
    public void setName(String name){
            this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public  int getIq(){
        return iq;
    }
    public void setIq(int iq){
        this.iq = iq;
    }
    public Human getMother(){
        return mother;
    }
    public void setMother(Human mother){
        this.mother = mother;
    }
    public Human getFather(){
        return father;
    }
    public void setFather(Human father){
        this.father = father;
    }
    public Pet getPet(){
        return pet;
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }
    public String[][] getSchedule(){
        return schedule;
    }
    public void setSchedule(String[][] schedule){
        this.schedule = schedule;
    }

}
