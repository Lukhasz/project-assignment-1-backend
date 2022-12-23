package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItem
{
    // todo: needs fields: int productId, String title, String color, String size, String previewImage, and int quantity
    // todo: all fields should be public and annotated with @JsonProperty

    @JsonProperty
    public int productId;

    @JsonProperty
    public String title;

    @JsonProperty
    public String color;

    @JsonProperty
    public String size;

    @JsonProperty
    public String previewImage;

    @JsonProperty
    public int quantity;



    // todo: needs 3 constructors:
    //  1. empty constructor
    //  2. constructor with productId, title, color, size, and previewImage
    //  3. constructor with productId, title, color, size, previewImage, and quantity



    public CartItem() {
    }

    public CartItem(int productId, String title, String color, String size, String previewImage) {
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
    }

    public CartItem(int productId, String title, String color, String size, String previewImage, int quantity) {
        this.productId = productId;
        this.title = title;
        this.color = color;
        this.size = size;
        this.previewImage = previewImage;
        this.quantity = quantity;
    }


}
