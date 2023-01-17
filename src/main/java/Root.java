import java.util.ArrayList;
import java.util.List;

public class Root{
    public Name name;
    public List<String> tld;
    public String cca2;
    public String ccn3;
    public String cca3;
    public String cioc;
    public boolean independent;
    public String status;
    public boolean unMember;
    public Currencies currencies;
    public Idd idd;
    public ArrayList<String> capital;
    public ArrayList<String> altSpellings;
    public String region;
    public String subregion;
    public Languages languages;
    public Translations translations;
    public ArrayList<Double> latlng;
    public boolean landlocked;
    public double area;
    public Demonyms demonyms;
    public String flag;
    public Maps maps;
    public int population;
    public String fifa;
    public Car car;
    public ArrayList<String> timezones;
    public ArrayList<String> continents;
    public Flags flags;
    public CoatOfArms coatOfArms;
    public String startOfWeek;
    public CapitalInfo capitalInfo;
    public ArrayList<String> borders;
    public Gini gini;
    public PostalCode postalCode;
    
    
	public void setTld(List<String> tld) {
		this.tld =  tld;
	}
	public List<String> getTld() {
		return tld;
	}
	
	public String getCca2() {
		return cca2;
	}

	public void setCca2(String cca2) {
		this.cca2 = cca2;
	}
	
	public String getCcn3() {
		return ccn3;
	}

	public void setCcn3(String ccn3) {
		this.ccn3 = ccn3;
	}
	public String getCca3() {
		return cca3;
	}

	public void setCca3(String cca3) {
		this.cca3 = cca3;
	}
	public String getcioc() {
		return cca3;
	}

	public void setcioc(String cioc) {
		this.cioc = cioc;
	}
	public boolean getIndependent() {
		return independent;
	}

	public void setIndependent(boolean independent) {
		this.independent = independent;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getUnMember() {
		return unMember;
	}

	public void setunMember(boolean unMember) {
		this.unMember = unMember;
	}
}
