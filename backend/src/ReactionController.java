package com.sharedcart.backend.controller;

import com.sharedcart.backend.model.CollaboratorReaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

    // Map<ProductId, List<CollaboratorReaction>>
    private final Map<String, List<CollaboratorReaction>> reactionsByProduct = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> addOrUpdateReaction(@RequestBody CollaboratorReaction reaction) {
        List<CollaboratorReaction> reactions = reactionsByProduct
            .computeIfAbsent(reaction.getProductId(), k -> new ArrayList<>());

        // Remove any old reaction by this collaborator for this product
        reactions.removeIf(r -> Objects.equals(r.getCollaboratorName(), reaction.getCollaboratorName()));

        // Add the new/latest reaction
        reactions.add(reaction);

        return ResponseEntity.ok("✅ Reaction added/updated");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<CollaboratorReaction>> getReactions(@PathVariable String productId) {
        return ResponseEntity.ok(reactionsByProduct.getOrDefault(productId, new ArrayList<>()));
    }
}
