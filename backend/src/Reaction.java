package com.sharedcart.backend.model;

public class Reaction {
    private String productName;
    private String reactionEmoji;
    private String message;

    // Getters and setters
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getReactionEmoji() { return reactionEmoji; }
    public void setReactionEmoji(String reactionEmoji) { this.reactionEmoji = reactionEmoji; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
