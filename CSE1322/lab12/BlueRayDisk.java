package lab12;

public class BlueRayDisk {
    public String title;
    public String director;
    public int yearOfRelease;
    public double cost;

    public BlueRayDisk(String diskTitle, String diskDirector, int diskYearOfRelease, double diskCost) {
        title = diskTitle;
        director = diskDirector;
        yearOfRelease = diskYearOfRelease;
        cost = diskCost;
    }

    @Override
    public String toString(){
        return "$" + cost + " " + yearOfRelease + " " + title + ", " + director;
    }
}
