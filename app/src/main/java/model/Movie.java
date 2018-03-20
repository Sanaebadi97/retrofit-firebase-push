package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 3/12/18.
 */

public class Movie {

  @SerializedName("name")
  private String name;

  @SerializedName("realname")
  private String realName;

  @SerializedName("team")
  private String team;

  @SerializedName("firstappearance")
  private String firstAppearance;

  @SerializedName("createdby")
  private String createdBy;

  @SerializedName("imageurl")
  private String imageUrl;

  @SerializedName("publisher")
  private String publisher;

  @SerializedName("bio")
  private String bio;

  public Movie(String name, String realName, String team, String firstAppearance, String createdBy, String publisher, String imageUrl, String bio) {
    this.name = name;
    this.realName = realName;
    this.team = team;
    this.firstAppearance = firstAppearance;
    this.createdBy = createdBy;
    this.publisher = publisher;
    this.imageUrl = imageUrl;
    this.bio = bio;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getFirstAppearance() {
    return firstAppearance;
  }

  public void setFirstAppearance(String firstAppearance) {
    this.firstAppearance = firstAppearance;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
