package id.ac.ukdw.fti.rpl.Gnosis.modal;

public class Search {
    private String place;
    private String peopleborn;
    private String peopledied;
    private String hasbeenhere;
    private String versebible;
    private String ayat;
    private String verseText1;
    private int jumlaho;
    private int jumlaht;
    private String osisRef;
    private String eastons1;
    private String nama;


    //grafik
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

    //alkitab
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

    public String getVerseText1() {
        return this.verseText1;
    }

    public void setVerseText1(String verseText1) {
        this.verseText1 = verseText1;
    }

    //VUT
    public String getHasbeenhere() {
        if (this.hasbeenhere == null) {
            return "unknown";
        } else {
            return this.hasbeenhere;
        }
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

    public String getVersebible() {
        if (this.versebible == null) {
            return "unknown";
        } else {
            return this.versebible;
        }
    }

    public void setVersebible(String versebible) {
        this.versebible = versebible;
    }

    public String getPeopleborn() {
        if (this.peopleborn == null) {
            return "unknown";
        } else {
            return this.peopleborn;
        }
    }

    public void setPeopleborn(String peopleborn) {
        this.peopleborn = peopleborn;
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

    //sekunder
    public String getNama() {
        if (this.nama == null) {
            return "unknown";
        } else {
            return this.nama;
        }
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEastons1() {
        if (this.eastons1 == null) {
            return "unknown";
        } else {
            return this.eastons1;
        }
    }

    public void setEastons1(String eastons1) {
        this.eastons1 = eastons1;
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
