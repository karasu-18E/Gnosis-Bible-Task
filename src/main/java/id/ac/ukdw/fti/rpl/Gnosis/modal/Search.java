package id.ac.ukdw.fti.rpl.Gnosis.modal;

public class Search {
    private String place;
    private String peopledied;
    private String hasbeenhere;
    private String ayat;
    private String verseDuration1;
    private String verseText1;
    private int jumlaho;
    private int jumlaht;
    private String osisRef;


    public String getHasbeenhere() {
        if (this.hasbeenhere == null) {
            return "unknown";
        } else {
            return this.hasbeenhere;
        }
    }

    public String getOsisRef() {
        return osisRef;
    }

    public void setOsisRef(String osisRef) {
        this.osisRef = osisRef;
    }

    public int getJumlaht() {
        return jumlaht;
    }

    public void setJumlaht(int jumlaht) {
        this.jumlaht = jumlaht;
    }

    public int getJumlaho() {
        return jumlaho;
    }

    public void setJumlaho(int jumlaho) {
        this.jumlaho = jumlaho;
    }

    public String getAyat() {
        if (this.ayat == null) {
            return "unknown";
        } else {
            return this.ayat;
        }
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public void setHasbeenhere(String hasbeenhere) {
        this.hasbeenhere = hasbeenhere;
    }

    public String getPeopledied() {
        if (this.peopledied == null) {
            return "unknown";
        } else {
            return this.peopledied;
        }
    }

    public void setPeopledied(String peopledied) {
        this.peopledied = peopledied;
    }

    public String getPlace() {
        if (this.place == null) {
            return "unknown";
        } else {
            return this.place;
        }
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setVerseDuration1(String verseDuration1) {
        this.verseDuration1 = verseDuration1;
    }

    public String getVerseDuration1() {
        if (this.verseDuration1 == null) {
            return "unknown";
        } else {
            return this.verseDuration1;
        }
    }

    public String getVerseText1() {
        return this.verseText1;
    }

    public void setVerseText1(String verseText1) {
        this.verseText1 = verseText1;
    }
    /*
     * public String getName(){
     * if (this.name==null) {
     * return "unknown";
     * }
     * else{
     * return this.name;
     * }
     * }
     * 
     * public String getBirthplace(){
     * if (this.birthplace==null) {
     * return "unknown";
     * }
     * else{
     * return this.birthplace;
     * }
     * }
     * 
     * public String getDeathplace(){
     * if (this.deathplace==null) {
     * return "unknown";
     * }
     * else if(this.deathplace.contains("-")){
     * return this.deathplace.substring(1,this.deathplace.length())+" BC";
     * }
     * else{
     * return "AD "+this.deathplace;
     * }
     * }
     * 
     * public void setName(String name){
     * this.name = name;
     * }
     * 
     * public void setBirthplace(String birthplace){
     * this.birthplace = birthplace;
     * }
     * 
     * public void setDeathplace(String deathplace){
     * this.deathplace = deathplace;
     * }
     * 
     * 
     */

}
