package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable
{
    // todo: needs fields: int id, String category, String title, String description, String previewImage, and List of ColorVariant colorVariants
    
    // todo: all fields should be public and annotated with @JsonProperty

    @JsonProperty
    public int id;

    @JsonProperty
    public String category;

    @JsonProperty
    public String title;

    @JsonProperty
    public String description;

    @JsonProperty
    public String previewImage;

    @JsonProperty
    public List<ColorVariant> colorVariants;


    // todo: needs 3 constructors:
    //  1. empty constructor: this one only initializes colorVariants to new ArrayList<>()
    //  2. constructor with id, category, title, description, and previewImage: this one initializes colorVariants to new ArrayList<>()
    //  3. constructor with id, category, title, description, colorVariants


    public Product(Product prod, HttpStatus created) {
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String category, String title, String description, String previewImage) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.previewImage = previewImage;
        colorVariants = new ArrayList<>();
    }

    public Product(int id, String category, String title, String description, List<ColorVariant> colorVariants) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.colorVariants = colorVariants;
    }
}
