package dslab5;

/**
 *
 * @author conor
 */
public class Princess {
    private final String name;
    private final int birthYear;
    
    public Princess() {
        name = "Jen Erik";
        birthYear = 2020;
    }
    
    public Princess(String name, int year) {
        this.name = name;
        this.birthYear = year;
    }
    
    public String getName() {
        return name;
    }
    public int getBirthYear() {
        return birthYear;
    }
    @Override
    public String toString() {
        return "Name: " + name + " Birth Year: " + birthYear;
    }
}
