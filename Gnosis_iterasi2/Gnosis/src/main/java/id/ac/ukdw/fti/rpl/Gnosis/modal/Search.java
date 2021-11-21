package id.ac.ukdw.fti.rpl.Gnosis.modal;

public class Search {
    private String name;
    private String birthplace;
    private String deathplace;
    private String verseDuration1;

    public void setName(String name){
        this.name = name;
    }
    
    public void setBirthplace(String birthplace){
        this.birthplace = birthplace;
    }

    public void setDeathplace(String deathplace){
        this.deathplace = deathplace;
    }

    public void setVerseDuration1(String verseDuration1){
        this.verseDuration1=verseDuration1;
    }

    public String getName(){
        if (this.name==null) {
            return "unknown";
        }
        else{
            return this.name;
        } 
    }

    public String getBirthplace(){
        if (this.birthplace==null) {
            return "unknown";
        }
        else{
            return this.birthplace;
        } 
    }

    public String getDeathplace(){
        if (this.deathplace==null) {
            return "unknown";
        }
        else if(this.deathplace.contains("-")){
            return this.deathplace.substring(1,this.deathplace.length())+" BC";
        }
        else{
            return "AD "+this.deathplace;
        }   
    }

    public String getVerseDuration1(){
        if (this.verseDuration1==null) {
            return "unknown";
        }
        else{
            return this.verseDuration1;
        }   
    }

}
