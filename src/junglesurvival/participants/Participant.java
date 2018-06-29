package junglesurvival.participants;

public abstract class Participant {
    private String name;


    public Participant(String name) {
        setName(name);
    }

    public String getName() {
      return name;
    }

    private void setName(String name){
      this.name = name;
    }
    abstract void concedeAttack(Participant participant);
}
