package de.hskl.cs.master.JSON;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Species {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("classification")
	@Expose
	private String classification;
	@SerializedName("designation")
	@Expose
	private String designation;
	@SerializedName("average_height")
	@Expose
	private String averageHeight;
	@SerializedName("skin_colors")
	@Expose
	private String skinColors;
	@SerializedName("hair_colors")
	@Expose
	private String hairColors;
	@SerializedName("eye_colors")
	@Expose
	private String eyeColors;
	@SerializedName("average_lifespan")
	@Expose
	private String averageLifespan;
	@SerializedName("homeworld")
	@Expose
	private String homeworld;
	@SerializedName("language")
	@Expose
	private String language;
	@SerializedName("people")
	@Expose
	private List<String> people = null;
	@SerializedName("films")
	@Expose
	private List<String> films = null;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("edited")
	@Expose
	private String edited;
	@SerializedName("url")
	@Expose
	private String url;

	private static final Client client = ClientBuilder.newClient();

	public static Species getSpeciesFromApi(String url) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.serializeNulls()
				.create();

		String jsonSpecies = client.target(url)
				.request(MediaType.APPLICATION_JSON).get(String.class);
		return gson.fromJson(jsonSpecies, Species.class);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAverageHeight() {
		return averageHeight;
	}

	public void setAverageHeight(String averageHeight) {
		this.averageHeight = averageHeight;
	}

	public String getSkinColors() {
		return skinColors;
	}

	public void setSkinColors(String skinColors) {
		this.skinColors = skinColors;
	}

	public String getHairColors() {
		return hairColors;
	}

	public void setHairColors(String hairColors) {
		this.hairColors = hairColors;
	}

	public String getEyeColors() {
		return eyeColors;
	}

	public void setEyeColors(String eyeColors) {
		this.eyeColors = eyeColors;
	}

	public String getAverageLifespan() {
		return averageLifespan;
	}

	public void setAverageLifespan(String averageLifespan) {
		this.averageLifespan = averageLifespan;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getPeople() {
		return people;
	}

	public void setPeople(List<String> people) {
		this.people = people;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Species \n[name=" + name + ", classification=" + classification + ", designation=" + designation
				+ ", averageHeight=" + averageHeight + ", skinColors=" + skinColors + ", hairColors=" + hairColors
				+ ", eyeColors=" + eyeColors + ", averageLifespan=" + averageLifespan + ", homeworld=" + homeworld
				+ ", language=" + language + ", people=" + people + ", films=" + films + ", created=" + created
				+ ", edited=" + edited + ", url=" + url + "]";
	}


}