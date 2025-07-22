package com.sharedcart.backend.model;

public class CollaboratorReaction {
    private String productId;
    private String collaboratorName;
    private String type; // "text", "emoji", or "voice"
    private String content;

    public CollaboratorReaction() {}

    public CollaboratorReaction(String productId, String collaboratorName, String type, String content) {
        this.productId = productId;
        this.collaboratorName = collaboratorName;
        this.type = type;
        this.content = content;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getCollaboratorName() { return collaboratorName; }
    public void setCollaboratorName(String collaboratorName) { this.collaboratorName = collaboratorName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
