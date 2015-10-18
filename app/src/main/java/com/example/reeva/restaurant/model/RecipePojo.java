package com.example.reeva.restaurant.model;

public class RecipePojo {
	
	int id,  cuisineid, tagsid;
	
	String recipeid, recipename, recipe_desc, recipe_ingredients, prep_time, cooking_time, Method, recipe_image, video_link, ratings, cusinename;

	public String getCusinename() {
		return cusinename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCusinename(String cusinename) {
		this.cusinename = cusinename;
	}

	public String getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(String recipeid) {
		this.recipeid = recipeid;
	}

	public int getCuisineid() {
		return cuisineid;
	}

	public void setCuisineid(int cuisineid) {
		this.cuisineid = cuisineid;
	}

	public int getTagsid() {
		return tagsid;
	}

	public void setTagsid(int tagsid) {
		this.tagsid = tagsid;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getRecipe_desc() {
		return recipe_desc;
	}

	public void setRecipe_desc(String recipe_desc) {
		this.recipe_desc = recipe_desc;
	}

	public String getRecipe_ingredients() {
		return recipe_ingredients;
	}

	public void setRecipe_ingredients(String recipe_ingredients) {
		this.recipe_ingredients = recipe_ingredients;
	}

	public String getPrep_time() {
		return prep_time;
	}

	public void setPrep_time(String prep_time) {
		this.prep_time = prep_time;
	}

	public String getCooking_time() {
		return cooking_time;
	}

	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}

	public String getMethod() {
		return Method;
	}

	public void setMethod(String method) {
		Method = method;
	}

	public String getRecipe_image() {
		return recipe_image;
	}

	public void setRecipe_image(String recipe_image) {
		this.recipe_image = recipe_image;
	}

	public String getVideo_link() {
		return video_link;
	}

	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public RecipePojo(String recipeid, String recipename, String recipe_desc,
			String recipe_ingredients, String prep_time, String cooking_time,
			String method, String video_link, String cusinename) {
		super();
		this.recipeid = recipeid;
		this.recipename = recipename;
		this.recipe_desc = recipe_desc;
		this.recipe_ingredients = recipe_ingredients;
		this.prep_time = prep_time;
		this.cooking_time = cooking_time;
		this.Method = method;
		this.video_link = video_link;
		this.cusinename = cusinename;
	}

	public RecipePojo() {
		super();
	}
	
	

}
